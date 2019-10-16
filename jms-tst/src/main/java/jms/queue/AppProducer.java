package jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class AppProducer {
    //activemq 服务器地址，默认端口为61616
    private static final String URL = "tcp://127.0.0.1:61616";
    //队列名
    private static final String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws JMSException {
        //创建创建工厂
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(URL);
        //创建连接
        Connection connection = connectionFactory.createConnection();
        //打开连接
        connection.start();
        //创建会话 是否启动事务；应答模式（自动应答）
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //创建目的地(队列)
        Destination destination = session.createQueue(QUEUE_NAME);
        //创建生产者
        MessageProducer producer = session.createProducer(destination);
        //发送消息
        for (int i = 0; i < 100; i++) {
            TextMessage textMessage = session.createTextMessage("test" + i);
            producer.send(textMessage);

            System.out.println(textMessage);
        }
        //关闭连接
        connection.close();
    }
}
