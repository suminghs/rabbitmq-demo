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
 * fanout广播模型
 */
@Component
public class FanoutListener {

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fanout1"),
            exchange = @Exchange(name = "fanoutLogs2", type = "fanout", durable = "false")
    ))
    public void costumer1(String message) {
        System.out.println("message1 : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fanout2"),
            exchange = @Exchange(name = "fanoutLogs2", type = "fanout", durable = "false")
    ))
    public void costumer2(String message) {
        System.out.println("message2 : " + message);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("fanout3"),
            exchange = @Exchange(name = "fanoutLogs2", type = "fanout", durable = "false")
    ))
    public void costumer3(String message) {
        System.out.println("message3 : " + message);
    }

}
