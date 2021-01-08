package com.example.springboot;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * <p>
 *
 * </p>
 *
 * @author fuzz
 * @since 2021/1/7 14:42
 */
@SpringBootTest
class MQTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    /**
     * 直接发送1
     */
    @Test
    void commonSend() {
        rabbitTemplate.convertAndSend("hello", "hello common");
    }

    /**
     * 直接发送2
     */
    @Test
    void commonSend2() {
        for (int i = 0; i < 10; i++) {
            rabbitTemplate.convertAndSend("hello2", "hello common" + i);
        }
    }

    /**
     * 广播模式
     */
    @Test
    void fanoutSend() {
        rabbitTemplate.convertAndSend("fanoutLogs2", "", "hello fanout");
    }

    /**
     * 订阅模式直连
     */
    @Test
    void directSend() {
        String route = "route1";
//        String route = "route2";
        rabbitTemplate.convertAndSend("direct_cms", route, "hello direct, route: " + route);
    }

    /**
     * 订阅模式Topic
     */
    @Test
    void topicSend() {
        String route = "user.add";
//        String route = "user.and.add";
        rabbitTemplate.convertAndSend("topic_exchange2",route , "hello topic, route: " + route);
    }

}
