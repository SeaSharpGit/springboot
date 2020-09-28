package com.sea.springboot.rabbitmq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListenerConfigurer;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RabbitListener(queues ="queue")
public class FirstMessageHandler {

    @RabbitHandler
    public void handleMessage(String message) {
        System.out.println(message);
    }

    @RabbitHandler
    public void handleMessage(byte[] message){
        handleMessage(new String(message));
    }

}
