package com.example.springboot.listener;

import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author fuzz
 * @since 2021/1/7 16:08
 *
 * 订阅模型——Topic
 */
@Component
public class TopicListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic_queue"),
            key = {"user.*"},
            exchange = @Exchange(name = "topic_exchange2", type = "topic")
    ))
    public void costumer1(String message) {
        System.out.println("消费者1 : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("topic_queue"),
            key = {"user.#"},
            exchange = @Exchange(name = "topic_exchange2", type = "topic")
    ))
    public void costumer2(String message) {
        System.out.println("消费者2 : " + message);
    }



}
