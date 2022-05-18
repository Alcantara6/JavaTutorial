package com.yanjing.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.transaction.ChainedTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author yanjing
 * @date 2022/5/18
 */
@Configuration
public class chainedConfig {

    @Autowired
    @Qualifier("transactionManagerPrimary")
    private PlatformTransactionManager transactionManagerPrimary;

    @Autowired
    @Qualifier("transactionManagerSecondary")
    private PlatformTransactionManager transactionManagerSecondary;

    @Bean
    public PlatformTransactionManager chainedTransactionManager() {

        return new ChainedTransactionManager(transactionManagerSecondary, transactionManagerPrimary);
    }
}
