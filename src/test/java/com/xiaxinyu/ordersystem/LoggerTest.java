package com.xiaxinyu.ordersystem;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class LoggerTest {

//    private final Logger logger = LoggerFactory.getLogger(LoggerTest.class); 等价使用Slf4j注解

    @Test
    public void test1(){
        String name = "OrderSystem";
        String password = "123456";
        log.debug("debug...");
        log.info("info...");
        log.error("error...");
    }
}
