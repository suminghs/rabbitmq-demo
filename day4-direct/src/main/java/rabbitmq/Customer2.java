package rabbitmq;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * <p>
 *
 * </p>
 *
 * @author fuzz
 * @since 2021/1/6 14:09
 */
public class Customer2 {
    private final static String EXCHANGE = "logs_direct";

    public void readMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.106.77.135");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("cms");
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();
        channel.exchangeDeclare(EXCHANGE, "direct");
        String queue = channel.queueDeclare().getQueue();
        channel.queueBind(queue, EXCHANGE, "route2");
        channel.basicConsume(queue, true, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println("订阅模型-Direct(直连)消费者2：  " + new String(body));
            }
        });
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Customer2 customer = new Customer2();
        customer.readMessage();
    }
}
