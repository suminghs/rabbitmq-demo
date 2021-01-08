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
    private final static String QUEUE_NAME = "hello";

    public void readMessage() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("39.106.77.135");
        factory.setPort(5672);
        factory.setUsername("guest");
        factory.setPassword("guest");
        factory.setVirtualHost("cms");
        Connection connection = factory.newConnection();
        final Channel channel = connection.createChannel();
        channel.basicQos(1);
        channel.queueDeclare(QUEUE_NAME, true, false, false, null);
        channel.basicConsume("hello", false, new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(new String(body));
                channel.basicAck(envelope.getDeliveryTag(), false); //手动确认消息
            }
        });
    }

    public static void main(String[] args) throws IOException, TimeoutException {
        Customer2 customer = new Customer2();
        customer.readMessage();
    }
}
