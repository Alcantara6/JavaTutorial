package com.yanjing.vo.response;

public final class ResponseUtils {
    public static <T> Response<T> success() {
        return new Response<>(ResponseStatus.OK);
    }

    public static <T> Response<T> success(T body) {
        return new Response<>(ResponseStatus.OK, body);
    }

    public static <T> Response<T> badRequest(String message) {
        return new Response<>(ResponseStatus.BAD_REQUEST, message);
    }

    public static <T> Response<T> notFound(String message) {
        return new Response<>(ResponseStatus.NOT_FOUND, message);
    }

    public static <T> Response<T> unAuthorized(String message) {
        return new Response<>(ResponseStatus.UNAUTHORIZED, message);
    }

    public static <T> Response<T> internalServerError(String message) {

        return new Response<>(ResponseStatus.INTERNAL_SERVER_ERROR, message);
    }
}
