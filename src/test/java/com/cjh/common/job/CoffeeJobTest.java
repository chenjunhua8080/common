package com.cjh.common.job;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CoffeeJobTest {

    @Autowired
    private CoffeeJob job;

    @Test
    void sign() throws InterruptedException {
        job.sign();
    }
}