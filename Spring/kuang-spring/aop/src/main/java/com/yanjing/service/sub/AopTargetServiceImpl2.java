package com.yanjing.service.sub;

import org.springframework.stereotype.Component;

/**
 * @author yanjing
 * @date 2022/4/17
 */
public class AopTargetServiceImpl2 implements AopTargetService {
    @Override
    public void step() {

    }

    @Override
    public void runFast(int a) {

        System.out.println("执行方法，参数是：" + a);
    }
}
