package jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: xiaguangyong
 * @ClassName: AppConsumer
 * @Description: 消费者
 * @Date: 2019/10/16 9:37
 * @Version: 1.0
 * @Modify:
 */
public class AppConsumer {
    //地址

    private static final String URL = "tcp://127.0.0.1:61616";

    //队列名

    private static final String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws JMSException {
        //创建工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话
        //第一个参数表示启用事务处理，第二个参数表示启动哪种应答模式 这里是启用自动应答
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //创建监听器
        consumer.setMessageListener(message -> {
            try {
                TextMessage textMessage = (TextMessage) message;
//                consumer.receive();
                System.out.println("接收消息: " + textMessage.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
