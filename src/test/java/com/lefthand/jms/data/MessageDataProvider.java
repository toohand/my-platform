package com.lefthand.jms.data;

import com.lefthand.jms.domain.Message;
import com.lefthand.jms.domain.support.MessageType;

import java.util.Date;

/**
 * 消息数据提供类
 * Created by wangmz on 2015/7/13.
 */
public class MessageDataProvider {

    private MessageDataProvider(){}

    public static Message message(){
        Message message = new Message();
        message.setId("UT_JMS_ID");
        message.setMessageType(MessageType.TODO);
        message.setCreateTime(new Date());
        message.setContent("测试消息内容");
        return message;
    }

    public static Message message_(){
        Message message = new Message();
        message.setId("UT_JMS_"+ com.lefthand.comm.utils.Identities.uuid2());
        message.setMessageType(MessageType.TODO);
        message.setCreateTime(new Date());
        message.setContent("测试消息内容:"+message.getId());
        return message;
    }
}
