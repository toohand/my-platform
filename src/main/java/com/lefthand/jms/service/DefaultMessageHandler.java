package com.lefthand.jms.service;

import com.lefthand.comm.exception.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * 默认消息监听器
 * Created by wangmz on 2015/6/24.
 */
public class DefaultMessageHandler implements MessageListener {

    private static Logger logger = LoggerFactory.getLogger(DefaultMessageHandler.class);

    @Override
    public void onMessage(Message message) {
        try {
            logger.debug("[监听方式]-从默认队列{}收到了消息:{}", message.getJMSDestination().toString(), message.toString());
            this.handle(message);
        } catch (JMSException e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException("接收目标队列消息出错", e);
        }
    }

    /**
     * 消息处理方法
     * @param message 接收到的消息实体
     * @return
     */
    protected Message handle(Message message){
        return message;
    }
}
