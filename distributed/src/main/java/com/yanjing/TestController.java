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

    @PostMapping("/api/declarative")
    public boolean declarative() {

        return testService.tx();
    }

    @PostMapping("/api/programmatic")
    public boolean programmatic() {

        return testService.programmatic();
    }

    @PostMapping("/api/chained")
    public boolean chained() {

        return testService.chained();
    }
}
