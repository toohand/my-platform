package com.lefthand.example.service;

import com.lefthand.comm.exception.ServiceException;
import com.lefthand.example.ExampleModule;
import com.lefthand.example.dao.ExampleDao;
import com.lefthand.example.domain.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * 范例服务实现类
 * Created by wangmz on 2014/9/30.
 */
@Service
@Transactional
public class ExampleServiceImpl implements ExampleService {

    private static Logger logger = LoggerFactory.getLogger(ExampleServiceImpl.class);
    @Autowired
    private ExampleDao exampleDao;
    @Override
    public void save(Example example) {
        try {
            // 保存范例信息, 包括新增|更新
            exampleDao.save(example);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(ExampleModule.ERR_SEV_TODO_SAVE, e);
        }
    }

    @Override
    public void delete(String id) {
        try {
            // 删除范例
            exampleDao.delete(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(ExampleModule.ERR_SEV_TODO_DELETE, e);
        }
    }

    @Override
    public Example find(String id) {
        try {
            return exampleDao.find(id);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(ExampleModule.ERR_SEV_TODO_FIND, e);
        }
    }

    @Override
    public List<Example> findByAll(Map<String, Object> terms) {
        try {
            return exampleDao.findByAll(terms);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(ExampleModule.ERR_SEV_TODO_FIND_BY_ALL, e);
        }
    }

    @Transactional(readOnly = true)
    @Override
    public Page<Example> query(PageRequest page, Map<String, Object> terms) {
        try {
            return exampleDao.query(page, terms);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(ExampleModule.ERR_SEV_TODO_QUERY, e);
        }
    }

    @Override
    public long count(Map<String, Object> terms) {
        try {
            return exampleDao.count(terms);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ServiceException(ExampleModule.ERR_SEV_TODO_COUNT, e);
        }
    }
}
