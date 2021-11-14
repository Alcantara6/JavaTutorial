package com.yanjing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author yanjing
 * @date 2021/11/14
 */
@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class UnAuthorizedException extends RuntimeException {

    private static final long serialVersionUID = 6404992734069063475L;

    public UnAuthorizedException(String message) {
        super(message);
    }
}