package Demo;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;


/**
 * 我们可以将Callable比作一个Runnable接口，而Callable的call()方法则类似于Runnable的run()方法。
 */
public class CallableFutureTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("start main Thread");
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        //新建一个Callable 任务, 并将其提交到一个ExecutorService上, 将返回一个描述任务的情况的Future
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                System.out.println("start new Thread");
                Thread.sleep(3000);
                System.out.println("end new thread");
                return "这是返回内容";
            }
        };
        Future<String> task = executorService.submit(callable);
        Thread.sleep(1000);
        String s = task.get();
        //关闭线程池
        executorService.shutdown();
        System.out.println(s + "end main thread ----");
    }
}
