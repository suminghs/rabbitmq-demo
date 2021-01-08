package com.example.springboot.listener;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * <p>
 *
 * </p>
 *
 * @author fuzz
 * @since 2021/1/7 14:44
 *
 * 普通模式一对一
 */
@Component
@RabbitListener(queuesToDeclare = @Queue("hello"))
public class CommonListener {

    @RabbitHandler
    public void consumer(String message) {
        System.out.println(message);
    }


}
