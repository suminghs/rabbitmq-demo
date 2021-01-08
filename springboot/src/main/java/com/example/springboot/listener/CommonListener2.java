package com.example.springboot.listener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author fuzz
 * @since 2021/1/7 16:01
 *
 * 普通模式一队列对多消费者
 */
@Component
public class CommonListener2 {

    @RabbitListener(queues = "hello2")
    public void consumer(String message) {
        System.out.println("消费者1： " + message);
    }

    @RabbitListener(queues = "hello2")
    public void consumer2(String message) {
        System.out.println("消费者2： " + message);
    }
}
