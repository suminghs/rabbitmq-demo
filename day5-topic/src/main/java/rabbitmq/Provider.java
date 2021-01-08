package rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

/**
 * <p>
 *
 * </p>
 *
 * @author fuzz
 * @since 2020/12/25 14:24
 */
public class Provider {
    private final static String QUEUE_NAME = "hello";
    private final static String EXCHANGE = "logs_topic";


    public void sendMessage() throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.106.77.135");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("cms");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        //参数1: 是否持久化  参数2:是否独占队列 参数3:是否自动删除  参数4:其他属性
        channel.exchangeDeclare(EXCHANGE, "topic");
        String route = "user.save";
//        String route = "user.save.all.aa";

        for (int i=0;i<10;i++) {
            channel.basicPublish(EXCHANGE, route, null, ("hello topic route:" + i + route).getBytes());

        }

        channel.close();
        connection.close();
    }

    public static void main(String[] args) throws Exception {
        Provider provider = new Provider();
        provider.sendMessage();
    }
}
