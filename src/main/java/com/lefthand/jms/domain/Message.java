package com.lefthand.jms.domain;

import com.lefthand.jms.domain.support.MessageState;
import com.lefthand.jms.domain.support.MessageType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;
import java.util.Date;

/**
 * 业务消息实体
 * Created by wangmz on 2015/7/10.
 */
@Document
public class Message implements Serializable {

    @Id
    private String id;//消息编号

    private MessageType messageType;//消息类型，待办

    private String title;//消息题目

    private String content;//消息内容

    private boolean isRead;//读取状态，true:未读，false:已读

    private MessageState messageState;//消息状态

    private Date createTime;//创建时间

    private Date updateTime;//更新时间

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean isRead) {
        this.isRead = isRead;
    }

    public MessageState getMessageState() {
        return messageState;
    }

    public void setMessageState(MessageState messageState) {
        this.messageState = messageState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return String.format("{id:%s, title:%s, content:%s, createTime:%tc, messageType:{id:%d, desc:%s}}", id,title,content,createTime,messageType.id(),messageType.desc());
    }
}
