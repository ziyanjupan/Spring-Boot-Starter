package jms.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @Author: xiaguangyong
 * @ClassName: AppProducer
 * @Description: 消息生产者
 * @Date: 2019/10/15 21:06
 * @Version: 1.0
 * @Modify:
 */
public class AppProducer {

    // activemq服务器的url地址，默认端口为61616
    private static final String URL = "tcp://115.236.50.17:61616";
    // 队列的名称
    private static final String QUEUE_NAME = "queue-test";

    public static void main(String[] args) throws JMSException {
        //创建工厂
        ConnectionFactory connectionFactory=new ActiveMQConnectionFactory(URL);
        //创建连接
        Connection connection=connectionFactory.createConnection();
        //启动连接
        connection.start();
        //创建会话
        //第一个参数表示启用事务处理，第二个参数表示启动哪种应答模式 这里是启用自动应答
        Session session=connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建目的地
        Destination destination=session.createQueue(QUEUE_NAME);
        //创建生产者
        MessageProducer producer=session.createProducer(destination);
        //发送消息
        for (int i=0;i<100;i++){
            //文本消息
            TextMessage textMessage=session.createTextMessage("test"+i);
            //生产者往目的地发送消息
            producer.send(destination,textMessage);

            System.out.println("消息发送成功：" + textMessage.getText());
        }
        //关闭连接
        connection.close();
    }
}
