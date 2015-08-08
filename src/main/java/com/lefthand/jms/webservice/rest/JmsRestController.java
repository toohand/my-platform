package com.lefthand.jms.webservice.rest;

import com.lefthand.jms.domain.Message;
import com.lefthand.jms.domain.support.MessageType;
import com.lefthand.jms.service.JmsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * JMS restful 控制器
 * Created by wangmz on 2015/7/14.
 */
@RestController
@RequestMapping(value = "/api/v1/jms")
public class JmsRestController {

    private static Logger logger = LoggerFactory.getLogger(JmsRestController.class);

    @Autowired
    private JmsService jmsService;

    /**
     * 向指定队列发送消息
     * @param queueName   队列名称
     * @param messageType 消息类型 参考 MessageType
     * @param title       消息标题
     * @param content     消息内容
     * @return 发送消息实体
     */
    @RequestMapping(value = "/sendToQueue", method = RequestMethod.POST)
    public Message sendToQueue(@RequestParam String queueName,
                               @RequestParam int messageType,
                               @RequestParam String title,
                               @RequestParam String content){
        try {
            Message message = new Message();
            message.setId(com.lefthand.comm.utils.Identities.uuid2());
            message.setMessageType(MessageType.fromTypeId(messageType));
            message.setTitle(title);
            message.setContent(content);
            message.setRead(true);
            message.setCreateTime(new Date());
            jmsService.sendToQueue(queueName, message);
            return message;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException("发送消息到指定队列出错", e);
        }
    }

    /**
     * 向指定主题发送消息
     * @param topicName   主题名称
     * @param messageType 消息类型 参考 MessageType
     * @param title       消息标题
     * @param content     消息内容
     * @return 发送消息实体
     */
    @RequestMapping(value = "/sendToTopic", method = RequestMethod.POST)
    public Message sendToTopic(@RequestParam String topicName,
                               @RequestParam int messageType,
                               @RequestParam String title,
                               @RequestParam String content){
        try {
            Message message = new Message();
            message.setId(com.lefthand.comm.utils.Identities.uuid2());
            message.setMessageType(MessageType.fromTypeId(messageType));
            message.setTitle(title);
            message.setContent(content);
            message.setCreateTime(new Date());
            jmsService.sendToTopic(topicName, message);
            return message;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException("发送消息到指定主题出错", e);
        }
    }

    /**
     * 接收指定队列消息
     * @param queueName 队列名称
     * @return 接收消息实体
     */
    @RequestMapping(value = "/receiveFromQueue", method = RequestMethod.POST)
    public Message receiveFromQueue(@RequestParam String queueName){
        try {
            return jmsService.receiveFromQueue(queueName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException("接收指定队列消息出错", e);
        }
    }

    /**
     * 接收指定主题消息
     * @param topicName 主题名称
     * @return 接收消息实体
     */
    @RequestMapping(value = "/receiveFromTopic", method = RequestMethod.POST)
    public Message receiveFromTopic(@RequestParam String topicName){
        try {
            return jmsService.receiveFromTopic(topicName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException("接收指定主题消息出错", e);
        }
    }
}
