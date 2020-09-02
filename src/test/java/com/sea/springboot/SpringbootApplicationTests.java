package com.sea.springboot;

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
        rabbitTemplate.convertAndSend("test", "你好");
    }

    @Test
    void rabbitMqReceiveMessage() {
        rabbitTemplate.convertAndSend("test", "你好");
    }

}
