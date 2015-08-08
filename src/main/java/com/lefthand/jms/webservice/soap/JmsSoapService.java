package com.lefthand.jms.webservice.soap;

import com.lefthand.jms.domain.Message;
import com.lefthand.jms.service.JmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.jws.WebService;

/**
 * JMS webservice服务
 * Created by wangmz on 2015/7/14.
 */
@WebService
public class JmsSoapService {

    private static Logger logger = LoggerFactory.getLogger(JmsSoapService.class);

    @Autowired
    private JmsService jmsService;

    /**
     * 向指定队列发送消息
     *
     * @param queueName 队列名称
     * @param message   消息实体
     * @return true:成功，false:失败
     */
    public boolean sendToQueue(String queueName, Message message){
        return jmsService.sendToQueue(queueName, message);
    }

    /**
     * 向指定主题发送消息
     *
     * @param topicName 主题名称
     * @param message   消息实体
     * @return true:成功，false:失败
     */
    public boolean sendToTopic(String topicName, Message message){
        return jmsService.sendToTopic(topicName, message);
    }

    /**
     * 接收指定队列消息
     *
     * @param queueName 队列名称
     * @return 消息实体
     */
    public Message receiveFromQueue(String queueName){
        return jmsService.receiveFromQueue(queueName);
    }

    /**
     * 接收指定主题消息
     *
     * @param topicName 主题名称
     * @return 消息实体
     */
    public Message receiveFromTopic(String topicName){
        return jmsService.receiveFromTopic(topicName);
    }

}
