package com.lefthand.activititest.dao;

import com.lefthand.activititest.dao.mapper.TestLoginMapper;
import com.lefthand.activiti.domain.TestUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
/**
 * 工作流 辅助 状态 ，流程定义
 * Created by PanjinF on 2015/6/11.
 */
@Repository
public class TestLoginDao{
    private static Logger logger = LoggerFactory.getLogger(TestLoginDao.class);
    @Autowired
    private TestLoginMapper testLoginMapper;

    /**
     *
     * @param loginName
     * @return
     */
    public TestUser findByLoginName(String loginName) {
        try {
            return  testLoginMapper.findByLoginName(loginName);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }
}
