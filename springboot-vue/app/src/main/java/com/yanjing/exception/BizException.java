package com.yanjing.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author yanjing
 * @date 2022/6/4
 */
@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class BizException extends RuntimeException {

    public BizException(String message) {
        super(message);
    }
}
