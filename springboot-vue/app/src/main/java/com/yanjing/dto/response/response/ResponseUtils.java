package com.yanjing.dto.response.response;

public final class ResponseUtils {
    public static Response success() {
        return new Response(ResponseStatus.OK);
    }

    public static <T> Response<T> success(T body) {
        return new Response<T>(ResponseStatus.OK, body);
    }

    public static Response badRequest(String message) {
        return new Response(ResponseStatus.BAD_REQUEST, message);
    }

    public static Response notFound(String message) {
        return new Response(ResponseStatus.NOT_FOUND, message);
    }

    public static Response unAuthorized(String message) {
        return new Response(ResponseStatus.UNAUTHORIZED, message);
    }

    public static Response internalServerError(String message) {

        return new Response(ResponseStatus.INTERNAL_SERVER_ERROR, message);
    }
}
