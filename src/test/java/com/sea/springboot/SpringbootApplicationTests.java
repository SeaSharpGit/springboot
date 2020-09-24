package com.sea.springboot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
class SpringbootApplicationTests {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    void rabbitMqSendMessage() {
        try {
            rabbitTemplate.convertAndSend("queue23", "你好");
            int a = 1;
        } catch (Exception ex) {
            int a = 1;
        }
    }


    @Test
    void test() {

    }

}
