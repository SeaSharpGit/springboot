package com.sea.springboot.rabbitmq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RabbitListener(queues = "queue")
public class FirstMessageHandler {

    @RabbitHandler
    public void handleMessage(String message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        try {
            System.out.println(message);

        }catch (Exception ex){

        }
        finally {
            try {
                channel.basicAck(tag,false);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @RabbitHandler
    public void handleMessage(byte[] message, Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long tag) {
        handleMessage(new String(message), channel, tag);
    }

}
