package someProject.Model;

import com.google.common.collect.ImmutableList;
import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.netflix.hystrix.exception.HystrixBadRequestException;
import rx.Observable;
import rx.functions.Func1;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;

/**
 * Simplifies invoking remote calls via Hystrix circuit-breaker
 */
public class HystrixTemplate {

    private final String commandGroupName;
    private final List<Class<? extends Throwable>> ignoredExceptions;

    public HystrixTemplate(String commandGroupName) {
        this(commandGroupName, (Collection<Class<? extends Throwable>>) null);
    }

    public HystrixTemplate(String commandGroupName, Class<? extends Throwable> ignoreException) {
        this(commandGroupName, Collections.singletonList(ignoreException));
    }

    public HystrixTemplate(String commandGroupName, Collection<Class<? extends Throwable>> ignoredExceptions) {
        this.commandGroupName = Objects.requireNonNull(commandGroupName, "Parameter commandGroupName should not be null");
        this.ignoredExceptions = ignoredExceptions != null ? ImmutableList.copyOf(ignoredExceptions) : null;
    }

    /**
     * Provides asynchronous circuit-breaker protected execution.
     *
     * @param commandName a Hystrix command name
     * @param delegate    a supplier of results
     * @param <T>         a type of the result
     * @return {@code Observable<R>} that executes
     */
    public <T> Observable<T> observeWithCircuitBreaker(String commandName, Supplier<T> delegate) {
        return observeWithCircuitBreaker(commandName, delegate, null);
    }

    /**
     * Provides asynchronous circuit-breaker protected execution with fallback.
     *
     * @param commandName a Hystrix command commandName
     * @param delegate    a supplier of results
     * @param <T>         a type of the result
     * @return {@code Observable<R>} that executes or a fallback if the execution fails for any reason
     */
    public <T> Observable<T> observeWithCircuitBreaker(String commandName, Supplier<T> delegate, Supplier<T> fallback) {
        HystrixCommand<T> cmd = createCommand(commandName, delegate, fallback);

        return cmd.observe().onErrorResumeNext((Func1<Throwable, Observable<T>>) throwable -> {
            if (throwable instanceof HystrixBadRequestException) {
                return Observable.error(throwable.getCause());
            }

            return Observable.error(throwable);
        });
    }

    /**
     * Provides synchronous circuit-breaker protected execution with fallback.
     *
     * @param commandName a Hystrix command name
     * @param delegate    a supplier of results
     * @param <T>         a type of the result
     * @return result of {@code delegate} invocation
     */
    public <T> T executeWithCircuitBreaker(String commandName, Supplier<T> delegate) {
        HystrixCommand<T> cmd = createCommand(commandName, delegate, null);
        try {
            return cmd.execute();
        } catch (HystrixBadRequestException e) {
            if (e.getCause() instanceof RuntimeException) {
                throw (RuntimeException) e.getCause();
            }
            throw new RuntimeException(e.getCause());
        }
    }

    private <T> HystrixCommand<T> createCommand(String name, Supplier<T> delegate, Supplier<T> fallback) {
        return new HystrixCommand<T>(
                HystrixCommand.Setter
                        .withGroupKey(HystrixCommandGroupKey.Factory.asKey(commandGroupName))
                        .andCommandKey(HystrixCommandKey.Factory.asKey(name))) {

            @Override
            protected T run() {


                try {
                    return delegate.get();

                } catch (Throwable responseException) {
                    if (isIgnorable(responseException)) {
                        throw new HystrixBadRequestException(responseException.getMessage(), responseException);
                    }

                    throw responseException;
                }
            }

            @Override
            protected T getFallback() {
                if (fallback != null) {
                    return fallback.get();
                }
                return super.getFallback();
            }
        };
    }

    private boolean isIgnorable(Throwable throwable) {
        if (ignoredExceptions == null || ignoredExceptions.isEmpty()) {
            return false;
        }

        for (Class<? extends Throwable> ignoreException : ignoredExceptions) {
            if (ignoreException.isAssignableFrom(throwable.getClass())) {
                return true;
            }
        }

        return false;
    }
}

