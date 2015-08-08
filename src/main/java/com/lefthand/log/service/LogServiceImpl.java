package com.lefthand.log.service;

import com.lefthand.log.dao.LogDao;
import com.lefthand.log.domain.entity.Log;
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
 * 日志服务实现类
 * Created by wangmz on 2015/7/2.
 */
@Service
public class LogServiceImpl implements LogService {

    private static Logger logger = LoggerFactory.getLogger(LogServiceImpl.class);

    @Autowired
    private LogDao logDao;

    /**
     * 保存日志
     *
     * @param log        日志实体
     * @param collection 集合名称
     * @return 日志
     */
    @Override
    public Log save(Log log, String collection) {
        return logDao.save(log, collection);
    }

    /**
     * 根据日志编号，获取日志
     *
     * @param id         日志编号
     * @param collection 集合名称
     * @return 日志
     */
    @Transactional(readOnly = true)
    @Override
    public Log find(String id, String collection) {
        return logDao.find(id, collection);
    }

    /**
     * 根据条件，获取日志
     *
     * @param terms      查询条件
     * @param collection 集合名称
     * @return 日志集合
     */
    @Transactional(readOnly = true)
    @Override
    public List<Log> findAll(Map<String, Object> terms, String collection) {
        return logDao.findAll(terms, collection);
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
    public Page<Log> query(PageRequest page, Map<String, Object> terms, String collection) {
        return logDao.query(page, terms, collection);
    }

    /**
     * 根据日志编号，删除日志
     *
     * @param id         日志编号
     * @param collection 集合名称
     */
    @Override
    public void delete(String id, String collection) {
        logDao.delete(id, collection);
    }

    /**
     * 创建集合
     *
     * @param collection 集合名称
     * @return 集合
     */
    @Override
    public DBCollection createCollection(String collection) {
        return logDao.createCollection(collection);
    }

    /**
     * 删除集合
     *
     * @param collection 集合名称
     */
    @Override
    public void dropCollection(String collection) {
        logDao.dropCollection(collection);
    }

    /**
     * 获取所有集合
     *
     * @return 集合名称
     */
    @Transactional(readOnly = true)
    @Override
    public Set<String> getCollectionNames() {
        return logDao.getCollectionNames();
    }
}
