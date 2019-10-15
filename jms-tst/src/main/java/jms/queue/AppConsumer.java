package jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppConsumer {
    //activemq 服务器地址，默认端口为61616
    private static final String URL = "tcp://127.0.0.1:61616";
    //队列名
    private static final String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws JMSException {
        //创建工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目标
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建消费者
        MessageConsumer consumer = session.createConsumer(destination);
        //创建监听器
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                try {
                    TextMessage textMessage = (TextMessage) message;
                    System.out.println("接受消息" + textMessage);
                } catch (Exception ex) {
//                    throw new Exception(ex);
                    ex.getStackTrace();
                }
            }
        });
    }
}
