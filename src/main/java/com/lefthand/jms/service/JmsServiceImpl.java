package com.lefthand.jms.service;

import com.lefthand.comm.exception.ServiceException;
import com.lefthand.comm.utils.JsonMapper;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.*;
import javax.jms.Message;

/**
 * 消息生产服务实现类
 * Created by wangmz on 2015/6/24.
 */
@Service
public class JmsServiceImpl implements JmsService {

    private static Logger logger = LoggerFactory.getLogger(JmsServiceImpl.class);

    @Autowired
    private JmsTemplate jmsTemplate;

    /**
     * 向指定队列发送消息
     *
     * @param queueName 队列名称
     * @param message   消息实体
     */
    @Override
    public boolean sendToQueue(String queueName, final com.lefthand.jms.domain.Message message) {
        try {
            Destination destination = new ActiveMQQueue(queueName);
            jmsTemplate.send(destination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(new JsonMapper().toJson(message));
                }
            });
            return true;
        } catch (JmsException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("发送消息到指定队列出错", e);
        }
    }

    /**
     * 向指定主题发送消息
     *
     * @param topicName 主题名称
     * @param message   消息实体
     */
    @Override
    public boolean sendToTopic(String topicName, final com.lefthand.jms.domain.Message message) {
        try {
            Destination destination = new ActiveMQTopic(topicName);
            jmsTemplate.send(destination, new MessageCreator() {
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(new JsonMapper().toJson(message));
                }
            });
            return true;
        } catch (JmsException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("发送消息到指定主题出错", e);
        }
    }

    /**
     * 接收指定队列消息
     *
     * @param queueName 队列名称
     */
    @Override
    public com.lefthand.jms.domain.Message receiveFromQueue(String queueName) {
        try {
            Destination destination = new ActiveMQQueue(queueName);
            TextMessage message = (TextMessage)jmsTemplate.receive(destination);
            return new JsonMapper().fromJson(message.getText(), com.lefthand.jms.domain.Message.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("接收指定队列消息出错", e);
        }
    }

    /**
     * 接收指定主题消息
     *
     * @param topicName 主题名称
     */
    @Override
    public com.lefthand.jms.domain.Message receiveFromTopic(String topicName) {
        try {
            Destination destination = new ActiveMQTopic(topicName);
            TextMessage message = (TextMessage)jmsTemplate.receive(destination);
            return new JsonMapper().fromJson(message.getText(), com.lefthand.jms.domain.Message.class);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("接收指定主题消息出错", e);
        }
    }

}
