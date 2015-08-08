package com.lefthand.log.service;

import com.lefthand.log.domain.entity.Log;
import com.mongodb.DBCollection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 日志服务接口
 * Created by wangmz on 2015/7/2.
 */
public interface LogService {

    /**
     * 保存日志
     *
     * @param log        日志实体
     * @param collection 集合名称
     * @return 日志
     */
    Log save(Log log, String collection);

    /**
     * 根据日志编号，获取日志
     *
     * @param id         日志编号
     * @param collection 集合名称
     * @return 日志
     */
    Log find(String id, String collection);

    /**
     * 根据条件，获取日志
     *
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 日志集合
     */
    List<Log> findAll(Map<String, Object> terms, String collection);

    /**
     * 根据条件，分页查询
     *
     * @param page       分页对象
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 分页集合
     */
    Page<Log> query(PageRequest page, Map<String, Object> terms, String collection);

    /**
     * 根据日志编号，删除日志
     *
     * @param id         日志编号
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
}
