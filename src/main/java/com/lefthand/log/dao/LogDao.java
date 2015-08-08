package com.lefthand.log.dao;

import com.lefthand.log.domain.entity.Log;
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
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

/**
 * 日志数据访问类
 * Created by wangmz on 2015/7/1.
 */
@Repository
public class LogDao {

    private static Logger logger = LoggerFactory.getLogger(LogDao.class);

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 保存日志
     *
     * @param log        日志实体
     * @param collection 集合名称
     * @return 日志
     */
    public Log save(Log log, String collection){
        mongoTemplate.insert(log, collection);
        return log;
    }

    /**
     * 根据日志编号，获取日志
     *
     * @param id         日志编号
     * @param collection 集合名称
     * @return 日志
     */
    public Log find(String id, String collection){
        return mongoTemplate.findById(id, Log.class, collection);
    }

    /**
     * 根据条件，获取日志
     *
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 日志集合
     */
    public List<Log> findAll(Map<String, Object> terms, String collection){
        Query query = this.getQuery(terms);
        return mongoTemplate.find(query, Log.class, collection);
    }

    /**
     * 根据条件，分页查询
     *
     * @param page       分页对象
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 分页集合
     */
    public Page<Log> query(PageRequest page, Map<String, Object> terms, String collection){
        Query query = this.getQuery(terms);
        long total = mongoTemplate.count(query, collection);
        query.skip(page.getOffset());
        query.limit(page.getPageSize());
        List<Log> logs = mongoTemplate.find(query, Log.class, collection);
        return new PageImpl<Log>(logs, page, total);
    }

    /**
     * 根据日志编号，删除日志
     *
     * @param id         日志编号
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
        if(terms.get("level")!=null && terms.get("level")!=""){
            Criteria criteria = Criteria.where("level").is(terms.get("level"));
            query.addCriteria(criteria);
        }
        if(terms.get("message")!=null && terms.get("message")!=""){
            Criteria criteria = Criteria.where("message").regex(Pattern.compile("^.*"+terms.get("message")+".*$", Pattern.CASE_INSENSITIVE));
            query.addCriteria(criteria);
        }
        query.with(new Sort(new Sort.Order(Sort.Direction.DESC,"createTime")));
        return query;
    }
}
