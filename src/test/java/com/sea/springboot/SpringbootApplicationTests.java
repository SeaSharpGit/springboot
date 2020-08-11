package com.sea.springboot;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringbootApplicationTests {

    @Test
    void contextLoads() {
        log.info("1");
        log.info("2");
        log.info("3");
    }

}
