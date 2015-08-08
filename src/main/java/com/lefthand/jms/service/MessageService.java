package com.lefthand.jms.service;

import com.lefthand.jms.domain.Message;
import com.mongodb.DBCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 消息服务接口
 * Created by wangmz on 2015/7/14.
 */
public interface MessageService {
    /**
     * 保存消息
     *
     * @param message    消息实体
     * @param collection 集合名称
     * @return 消息
     */
    Message save(Message message, String collection);

    /**
     * 根据消息编号，获取消息
     *
     * @param id         消息编号
     * @param collection 集合名称
     * @return 消息
     */
    Message find(String id, String collection);

    /**
     * 根据条件，获取消息
     *
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 消息集合
     */
    List<Message> findAll(Map<String, Object> terms, String collection);

    /**
     * 根据条件，分页查询
     *
     * @param page       分页对象
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 分页集合
     */
    Page<Message> query(PageRequest page, Map<String, Object> terms, String collection);

    /**
     * 根据消息编号，删除消息
     *
     * @param id         消息编号
     * @param collection 集合名称
     */
    void delete(String id, String collection);

    /**
     * 创建集合
     *
     * @param collection 集合名称
     * @return 集合
     */
    DBCollection createCollection(String collection);

    /**
     * 删除集合
     *
     * @param collection 集合名称
     */
    void dropCollection(String collection);

    /**
     * 获取所有集合
     *
     * @return 集合名称
     */
    Set<String> getCollectionNames();

    /**
     * 设置已读状态
     * @param id         消息编号
     * @param collection 集合名称
     */
    void isRead(String id, String collection);
}
