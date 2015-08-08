package com.lefthand.jms.dao;

import com.lefthand.jms.domain.Message;
import com.mongodb.DBCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.regex.Pattern;

/**
 * 消息数据访问层
 * Created by wangmz on 2015/7/14.
 */
@Repository
public class MessageDao {
    private static Logger logger = LoggerFactory.getLogger(MessageDao.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存消息
     *
     * @param message        消息实体
     * @param collection 集合名称
     * @return 消息
     */
    public Message save(Message message, String collection){
        mongoTemplate.insert(message, collection);
        return message;
    }

    /**
     * 根据消息编号，获取消息
     *
     * @param id         消息编号
     * @param collection 集合名称
     * @return 消息
     */
    public Message find(String id, String collection){
        return mongoTemplate.findById(id, Message.class, collection);
    }

    /**
     * 根据条件，获取消息
     *
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 消息集合
     */
    public List<Message> findAll(Map<String, Object> terms, String collection){
        Query query = this.getQuery(terms);
        return mongoTemplate.find(query, Message.class, collection);
    }

    /**
     * 根据条件，分页查询
     *
     * @param page       分页对象
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 分页集合
     */
    public Page<Message> query(PageRequest page, Map<String, Object> terms, String collection){
        Query query = this.getQuery(terms);
        long total = mongoTemplate.count(query, collection);
        query.skip(page.getOffset());
        query.limit(page.getPageSize());
        List<Message> logs = mongoTemplate.find(query, Message.class, collection);
        return new PageImpl<Message>(logs, page, total);
    }

    /**
     * 根据消息编号，删除消息
     *
     * @param id         消息编号
     * @param collection 集合名称
     */
    public void delete(String id, String collection){
        mongoTemplate.remove(new Query(Criteria.where("_id").is(id)), collection);
    }

    /**
     * 创建集合
     *
     * @param collection 集合名称
     * @return 集合
     */
    public DBCollection createCollection(String collection){
        if (!mongoTemplate.collectionExists(collection)) {
            return mongoTemplate.createCollection(collection);
        }else{
            return mongoTemplate.getCollection(collection);
        }
    }

    /**
     * 删除集合
     *
     * @param collection 集合名称
     */
    public void dropCollection(String collection) {
        if (mongoTemplate.collectionExists(collection)) {
            mongoTemplate.dropCollection(collection);
        }
    }

    /**
     * 获取所有集合
     *
     * @return 集合名称
     */
    public Set<String> getCollectionNames() {
        return mongoTemplate.getCollectionNames();
    }

    /**
     * 设置已读状态
     *
     * @param id         消息编号
     * @param collection 集合名称
     */
    public void isRead(String id, String collection){
        Update update = new Update();
        update.set("isRead", false);
        update.set("updateTime", new Date());
        mongoTemplate.updateFirst(new Query(Criteria.where("id").is(id)), update, collection);
    }

    /**
     * 组装查询条件
     *
     * @param terms 条件集合
     * @return 条件对象
     */
    private Query getQuery(Map<String, Object> terms) {
        if(terms==null){
            terms = new HashMap<String, Object>();
        }
        Query query = new Query();
        if(terms.get("isRead")!=null && terms.get("isRead")!=""){
            Criteria criteria = Criteria.where("isRead").is(terms.get("isRead"));
            query.addCriteria(criteria);
        }
        if(terms.get("keyword")!=null && terms.get("keyword")!=""){
            Criteria criteria = Criteria.where("title").regex(Pattern.compile("^.*" + terms.get("keyword") + ".*$", Pattern.CASE_INSENSITIVE));
            query.addCriteria(criteria);
        }
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"createTime")));
        return query;
    }
}
