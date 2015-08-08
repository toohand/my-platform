package com.lefthand.jms.service;

import com.lefthand.jms.domain.Message;

/**
 * 消息生产服务接口
 * Created by wangmz on 2015/6/24.
 */
public interface JmsService {

    /**
     * 向指定队列发送消息
     * @param queueName 队列名称
     * @param message   消息实体
     * @return true:成功，false:失败
     */
    boolean sendToQueue(String queueName, Message message);

    /**
     * 向指定主题发送消息
     * @param topicName 主题名称
     * @param message   消息实体
     * @return true:成功，false:失败
     */
    boolean sendToTopic(String topicName, Message message);

    /**
     * 接收指定队列消息
     * @param queueName 队列名称
     */
    Message receiveFromQueue(String queueName);

    /**
     * 接收指定主题消息
     * @param topicName 主题名称
     */
    Message receiveFromTopic(String topicName);

}
