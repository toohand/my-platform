package com.lefthand.log.dao;

import com.lefthand.AbstractTest;
import com.lefthand.log.data.LogDataProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * 日志数据访问类测试
 * Created by wangmz on 2015/7/2.
 */
public class LogDaoTest extends AbstractTest {

    private static Logger logger = LoggerFactory.getLogger(LogDaoTest.class);

    @Autowired
    private LogDao logDao;

    private static final String COLLECTION_NAME = "log";

    @Test
    public void testSave(){
        if(logDao.find(LogDataProvider.log().getId(), COLLECTION_NAME)==null){
            logDao.save(LogDataProvider.log(), COLLECTION_NAME);
        }
        logDao.save(LogDataProvider.log_(), COLLECTION_NAME);
    }

    @Test
    public void testFind(){
        Assert.notNull(logDao.find(LogDataProvider.log().getId(), COLLECTION_NAME));
    }

    @Test
    public void testFindAll(){
        Assert.notNull(logDao.findAll(null, COLLECTION_NAME));
    }

    @Test
    public void testQuery(){
        Map<String, Object> terms = new HashMap<String, Object>();
        terms.put("level","BUG");
        terms.put("message","测");
        Assert.notNull(logDao.query(new PageRequest(0, 10), terms, COLLECTION_NAME).getContent());
    }

    @Test
    public void testDelete(){
        logDao.delete(LogDataProvider.log().getId(), COLLECTION_NAME);
    }

    @Test
    public void testCreateCollection(){
        logDao.createCollection("TEST_"+COLLECTION_NAME);
    }

    @Test
    public void testDropCollection(){
        logDao.dropCollection("TEST_"+COLLECTION_NAME);
    }

    @Test
    public void testGetCollectionNames(){
        Assert.notEmpty(logDao.getCollectionNames());
    }
}
