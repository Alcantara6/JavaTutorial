package com.yanjing;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanjing
 * @date 2022/5/15
 */
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping("/api/updateData")
    public void execute() {

        testService.tx();
    }
}
