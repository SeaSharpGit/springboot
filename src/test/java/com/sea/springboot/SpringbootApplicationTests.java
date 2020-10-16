package com.sea.springboot;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
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
            //设置消息的过期时间
            MessageProperties messageProperties = new MessageProperties();
            messageProperties.setExpiration("10000");

            String msg="你好";
            String pkid = "1";
            Message message = new Message(msg.getBytes("UTF-8"),messageProperties);
            rabbitTemplate.convertAndSend("queue", message, new CorrelationData(pkid));
            int a = 1;
        } catch (Exception ex) {
            int a = 1;
        }
    }


    @Test
    void test() {

    }

}
