package com.sea.springboot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
@RequiredArgsConstructor
class SpringbootApplicationTests {

    private final RabbitTemplate rabbitTemplate;

    @Test
    void rabbitMqSendMessage() {
        rabbitTemplate.convertAndSend("test", "你好");
    }


    @Test
    void test(){

    }

}
