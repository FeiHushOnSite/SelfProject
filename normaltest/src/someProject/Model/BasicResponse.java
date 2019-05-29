package someProject.Model;

public class BasicResponse<T> {

    private int code;

    private String message;

    private T value;

    public BasicResponse(ResponseStatus status, String message, T value) {
        this.code = status.getCode();
        this.message = message;
        this.value = value;
    }

    public BasicResponse(ResponseStatus status, String message) {
        this(status, message, null);
    }

    public BasicResponse(ResponseStatus status) {
        this(status, null, null);
    }

    public BasicResponse(ResponseStatus status, T value) {
        this(status, null, value);
    }

    /**
     * A factory method for a successful response with no value. Such a response looks like:
     * <p>
     * <pre>
     * {
     *  "code": 200,
     *  "message": null,
     *  "value": null
     * }
     * </pre>
     *
     * @return the simple BasicResponse with the HTTP code 200.
     */
    public static BasicResponse ok() {
        return new BasicResponse(ResponseStatus.OK);
    }

    /**
     * A factory method for a successful response with a value.
     * <p>
     * <pre>
     * {
     *  "code": 200,
     *  "message": null,
     *  "value": {
     *    "amount": 1546,
     *    "dueDate": "2016-09-26 00:00:01.2"
     *  }
     * }
     *
     * @param value a response value
     * @param <T>   a type of the value
     * @return the BasicResponse with the value and HTTP code 200
     */
    public static <T> BasicResponse<T> okWithValue(T value) {
        return new BasicResponse<>(ResponseStatus.OK, value);
    }

    /**
     * A factory method for a successful response with a value.
     * <p>
     * <pre>
     * {
     *  "code": 200,
     *  "message": "Some message",
     *  "value": null
     * }
     *
     * @param message a response message
     * @return the BasicResponse with the value and HTTP code 200
     */
    public static <T> BasicResponse<T> okWithMessage(String message) {
        return new BasicResponse<>(ResponseStatus.OK, message);
    }

    /**
     * A factory method for a response with a status and a message and no value. A sample response looks like:
     * <p>
     * <pre>
     * {
     *  "code": 400,
     *  "message": "Some message to the user",
     *  "value": null
     * }
     * </pre>
     *
     * @param responseStatus a response status
     * @param message        a response message
     * @return the BasicResponse with code and message
     */
    public static <T> BasicResponse<T> withStatusAndMessage(ResponseStatus responseStatus, String message) {
        return new BasicResponse<>(responseStatus, message);
    }

    /**
     * A factory method for a response with a status code, message and value. A sample response looks like:
     * <p>
     * <pre>
     * {
     *  "code": 400,
     *  "message": "Some message to the user",
     *  "value": "Some value"
     * }
     * </pre>
     *
     * @param responseStatus a response responseStatus
     * @param message        a response message
     * @return the BasicResponse with code, message and value
     */
    public static <T> BasicResponse<T> createBasicResponse(ResponseStatus responseStatus, String message, T value) {
        return new BasicResponse<>(responseStatus, message, value);
    }

    /**
     * A factory method for a response with {@code ResponseStatus.DATA_ERROR} (400) status code, message and value. A sample response looks like:
     * <p>
     * <pre>
     * {
     *  "code": 400,
     *  "message": "Some message to the user",
     *  "value": null
     * }
     * </pre>
     *
     * @param message a response message
     * @return the BasicResponse with the {@code ResponseStatus.DATA_ERROR} (400) status and a message
     */
    public static <T> BasicResponse<T> dataError(String message) {
        return withStatusAndMessage(ResponseStatus.DATA_ERROR, message);
    }

    /**
     * A factory method for a response with {@code ResponseStatus.UNAUTHORIZED} (401) status code, message and value. A sample response looks like:
     * <p>
     * <pre>
     * {
     *  "code": 401,
     *  "message": "Some message to the user",
     *  "value": null
     * }
     * </pre>
     *
     * @param message a response message
     * @return the BasicResponse with the {@code ResponseStatus.DATA_ERROR} (401) status and a message
     */
    public static <T> BasicResponse<T> unauthorized(String message) {
        return withStatusAndMessage(ResponseStatus.UNAUTHORIZED, message);
    }

}

