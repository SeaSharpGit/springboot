package com.sea.springboot.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AcknowledgeMode;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.api.ChannelAwareMessageListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.concurrent.TimeUnit;

@Slf4j
@Configuration
@Profile("prod")
public class RabbitMqConfig {

//    @Bean
//    public ConnectionFactory connectionFactory() {
//        //org.springframework.boot.autoconfigure.amqp.RabbitProperties
//        CachingConnectionFactory factory = new CachingConnectionFactory();
//        factory.setUri("amqp://admin:123456@192.168.83.129:5672");
//        //当消息不能路由到队列中去的时候，会触发回调
//        factory.setPublisherReturns(true);
//        //开启消息确认PublisherConfirm
//        factory.setPublisherConfirmType(CachingConnectionFactory.ConfirmType.SIMPLE);
//        return factory;
//    }

    @Bean
    public RabbitAdmin rabbitAdmin(ConnectionFactory connectionFactory) {
        RabbitAdmin rabbitAdmin = new RabbitAdmin(connectionFactory);
        return rabbitAdmin;
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        //设置Exchange默认操作的exchange和routingkey
        rabbitTemplate.setExchange("");
        rabbitTemplate.setRoutingKey("");
        //当消息不能路由到队列中去的时候，会触发
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setReturnCallback((message, replyCode, replyText, exchange, routingKey) -> {
            //消息不能路由到队列
            System.out.println("============returnedMessage method=========");
            System.out.println("message: " + message);
            System.out.println("replyCode: " + replyCode);
            System.out.println("replyText: " + replyText);
            System.out.println("exchange: " + exchange);
            System.out.println("routingKey: " + routingKey);
        });

        //消息到达Exchange是否成功
        rabbitTemplate.setConfirmCallback(new RabbitTemplate.ConfirmCallback() {
            /**
             * @param correlationData 唯一标识，有了这个唯一标识，我们就知道可以确认（失败）哪一条消息了
             * @param ack
             * @param cause
             */
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if(!ack){
                    log.error("消息id为: "+correlationData+"的消息，消息nack，失败原因是："+cause);
                }
            }
        });
        return rabbitTemplate;
    }

    /**
     * 发现消息中有content_type有text就会默认将其转换成string类型
     *
     * @param connectionFactory
     * @return
     */
    @Bean
    public RabbitListenerContainerFactory<?> rabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        //消费者手动ACK
        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
        return factory;
    }


}
