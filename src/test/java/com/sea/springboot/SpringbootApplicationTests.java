package com.sea.springboot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.connection.CorrelationData;
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
            String pkid = "1";
            Object message="你好";
            rabbitTemplate.convertAndSend("queue23", message, new CorrelationData(pkid));
            int a = 1;
        } catch (Exception ex) {
            int a = 1;
        }
    }


    @Test
    void test() {

    }

}
