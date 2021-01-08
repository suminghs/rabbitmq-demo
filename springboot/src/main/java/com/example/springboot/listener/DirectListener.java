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
 * 订阅模型——直连
 */
@Component
public class DirectListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            key = {"route1", "route2"},
            exchange = @Exchange(name = "direct_cms", type = "direct", durable = "false")
    ))
    public void costumer1(String message) {
        System.out.println("订阅直连消费者1 : " + message);
    }



    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            key = {"route1", "route3"},
            exchange = @Exchange(name = "direct_cms", type = "direct", durable = "false")
    ))
    public void costumer2(String message) {
        System.out.println("订阅直连消费者2 : " + message);
    }


}
