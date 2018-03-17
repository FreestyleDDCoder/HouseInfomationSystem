package utils;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by liangzhan on 18-3-13.
 * amqp协议的消息服务总线
 */
public class AMQPMessageHandle {

    String user = env("ACTIVEMQ_USER", "admin");
    String password = env("ACTIVEMQ_PASSWORD", "password");
    String host = env("ACTIVEMQ_HOST", "localhost");
    int port = Integer.parseInt(env("ACTIVEMQ_PORT", "61616"));
    String connectionURI = "tcp://" + host + ":" + port;

    /**
     * 这是发送消息的方法
     *
     * @param message       发送的消息
     * @param queueName     发送消息的队列名称
     * @param messageIDName 发送消息的属性名
     * @param messageID     发送消息的属性id
     */
    public void sendMessage(String message, String queueName, String messageIDName, String messageID) {
        Connection connection = null;
        Session session = null;
        ConnectionFactory factory;
        try {
            factory = new ActiveMQConnectionFactory(connectionURI);
            connection = factory.createConnection(user, password);
            connection.start();
            //会话
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);
            MessageProducer producer = session.createProducer(destination);
            Message msg = session.createTextMessage(message);
            if (!messageID.equals("") || !messageID.isEmpty()) {
                msg.setStringProperty("messageIDName", messageID);
            }
            producer.send(msg);
            System.out.println("amqp:send to queue:" + queueName + "," + "message:" + message);
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            //释放本次资源
            try {
                if (session != null)
                    session.close();
                if (connection != null)
                    connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 消息队列取消息的方法
     *
     * @param queueName     消息队列名称
     * @param messageIDName 消息ID名
     * @param messageID     消息ID
     * @return 接收到的消息
     */
    public String receiveMessage(String queueName, String messageIDName, String messageID) {
        Connection connection = null;
        Session session = null;
        String message = null;
        try {
            ConnectionFactory factory;
            factory = new ActiveMQConnectionFactory(connectionURI);
            connection = factory.createConnection(user, password);
            connection.start();
            //会话
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            Destination destination = session.createQueue(queueName);
            MessageConsumer consumer;
            if (!messageID.equals("") || !messageID.isEmpty()) {
                consumer = session.createConsumer(destination, "messageIDName=" + "\'" + messageID + "\'");
            } else {
                consumer = session.createConsumer(destination);
            }

            Message msg = consumer.receive();
            if (msg instanceof TextMessage) {
                message = ((TextMessage) msg).getText();
                System.out.println("amqp:receive from queue:" + queueName + "," + "message:" + message);
            }
        } catch (JMSException e) {
            e.printStackTrace();
        } finally {
            try {
                if (session != null)
                    session.close();
                if (connection != null)
                    connection.close();
            } catch (JMSException e) {
                e.printStackTrace();
            }
        }
        return message;
    }

    private static String env(String key, String defaultValue) {
        String rc = System.getenv(key);
        if (rc == null)
            return defaultValue;
        return rc;
    }
}
