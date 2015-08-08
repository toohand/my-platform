package com.lefthand.activiti.dao;

import com.lefthand.activiti.dao.mapper.*;
import com.lefthand.activiti.domain.*;
import com.lefthand.comm.exception.ApplicationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Dao层
 * Created by PanjinF on 2015/6/15.
 */
@Repository
public class ActivitiManageDao {
    private static Logger logger = LoggerFactory.getLogger(ActivitiManageDao.class);

    @Autowired
    private ProcessDefinitionMapper processDefinitionMapper;

    @Autowired
    private ProcessInstanceMapper processInstanceMapper;

    @Autowired
    private ProcessTaskMapper processTaskMapper;

    @Autowired
    private HisProcinstMapper hisProcinstMapper;

    @Autowired
    private HisTaskMapper hisTaskMapper;

//-----------------------------------------------查询流程部署start---------------------------------------------------------

    /**
     * 按照条件 查询流程部署的lsit集合
     *
     * @param terms
     * @param terms
     * @param page
     * @return
     */
    public Page<MyProcessDefinition> findAllProcessDefinition(PageRequest page, Map<String, Object> terms) {
        try {
            long total = processDefinitionMapper.queryProcessDefinitionTotal(terms);
            List<MyProcessDefinition> content = processDefinitionMapper.findAllProcessDefinition(page, terms);
            return new PageImpl<MyProcessDefinition>(content, page, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
//-----------------------------------------------查询流程部署end----------------------------------------------------------

//-----------------------------------------------查询流程实例start--------------------------------------------------------

    /**
     * 按照条件 查询流程实例的lsit集合
     *
     * @param terms
     * @param page
     * @return
     */
    public Page<MyProcessInstance> findAllProcessInstance(PageRequest page, Map<String, Object> terms) {
        try {

            List<MyProcessInstance> content = processInstanceMapper.findAllProcessInstance(page, terms);
            long total = processInstanceMapper.queryProcessInstanceTotal(terms);
            return new PageImpl<MyProcessInstance>(content, page, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
//-----------------------------------------------查询流程实例end----------------------------------------------------------

//-----------------------------------------------查询任务对象start--------------------------------------------------------

    /**
     * 按照条件 查询流程执行中任务的lsit集合和总数
     *
     * @param terms
     * @param page
     * @param page
     * @return
     */
    public Page<MyTask> findAllProcessTask(PageRequest page, Map<String, Object> terms) {
        try {
            List<MyTask> content = processTaskMapper.findAllProcessTask(page, terms);
            long total = processTaskMapper.queryProcessTaskTotal(terms);
            return new PageImpl<MyTask>(content, page, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
//-----------------------------------------------查询任务对象end----------------------------------------------------------


//-----------------------------------------------查询历史实例对象start-----------------------------------------------------

    /**
     * 按照条件 查询历史实例对象的lsit集合
     *
     * @param terms
     * @param page
     * @return
     */
    public Page<HisProcinst> findAllHisProcinst(PageRequest page, Map<String, Object> terms) {
        try {
            List<HisProcinst> content = hisProcinstMapper.findAllHisProcinst(page, terms);
            long total = hisProcinstMapper.queryHisProcinstTotal(terms);
            return new PageImpl<HisProcinst>(content, page, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }

//-----------------------------------------------查询历史任务对象start-----------------------------------------------------

    /**
     * 按照条件 查询历史任务对象的lsit集合
     *
     * @param terms
     * @param page
     * @return
     */
    public Page<HisTask> findAllHisTask(PageRequest page, Map<String, Object> terms) {
        try {
            List<HisTask> content = hisTaskMapper.findAllHisTask(page, terms);
            long total = hisTaskMapper.queryHisTaskTotal(terms);
            return new PageImpl<HisTask>(content, page, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new ApplicationException(e.getMessage(), e);
        }
    }
//-----------------------------------------------查询历史任务对象end-----------------------------------------------------
}
