package com.lefthand.jms.service;

import com.lefthand.jms.dao.MessageDao;
import com.lefthand.jms.domain.Message;
import com.lefthand.jms.domain.support.MessageState;
import com.mongodb.DBCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 消息服务实现类
 * Created by wangmz on 2015/7/14.
 */
@Service
public class MessageServiceImpl implements MessageService {
    private static Logger logger = LoggerFactory.getLogger(MessageServiceImpl.class);

    @Autowired
    private MessageDao messageDao;
    @Autowired
    private JmsService jmsService;

    /**
     * 保存消息
     *
     * @param message    消息实体
     * @param collection 集合名称
     * @return 消息
     */
    @Override
    public Message save(Message message, String collection) {
        boolean result = jmsService.sendToTopic(message.getMessageType().desc(), message);
        if(result){
            message.setMessageState(MessageState.SUCCESS);
        }else{
            message.setMessageState(MessageState.FAIL);
        }
        return messageDao.save(message, collection);
    }

    /**
     * 根据消息编号，获取消息
     *
     * @param id         消息编号
     * @param collection 集合名称
     * @return 消息
     */
    @Transactional(readOnly = true)
    @Override
    public Message find(String id, String collection) {
        return messageDao.find(id, collection);
    }

    /**
     * 根据条件，获取消息
     *
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 消息集合
     */
    @Transactional(readOnly = true)
    @Override
    public List<Message> findAll(Map<String, Object> terms, String collection) {
        return messageDao.findAll(terms, collection);
    }

    /**
     * 根据条件，分页查询
     *
     * @param page       分页对象
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 分页集合
     */
    @Transactional(readOnly = true)
    @Override
    public Page<Message> query(PageRequest page, Map<String, Object> terms, String collection) {
        return messageDao.query(page, terms, collection);
    }

    /**
     * 根据消息编号，删除消息
     *
     * @param id         消息编号
     * @param collection 集合名称
     */
    @Override
    public void delete(String id, String collection) {
        messageDao.delete(id, collection);
    }

    /**
     * 创建集合
     *
     * @param collection 集合名称
     * @return 集合
     */
    @Override
    public DBCollection createCollection(String collection) {
        return messageDao.createCollection(collection);
    }

    /**
     * 删除集合
     *
     * @param collection 集合名称
     */
    @Override
    public void dropCollection(String collection) {
        messageDao.dropCollection(collection);
    }

    /**
     * 获取所有集合
     *
     * @return 集合名称
     */
    @Transactional(readOnly = true)
    @Override
    public Set<String> getCollectionNames() {
        return messageDao.getCollectionNames();
    }

    /**
     * 设置已读状态
     *
     * @param id         消息编号
     * @param collection 集合名称
     */
    @Override
    public void isRead(String id, String collection) {
        messageDao.isRead(id, collection);
    }
}
