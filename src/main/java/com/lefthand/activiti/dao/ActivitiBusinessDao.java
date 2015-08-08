package com.lefthand.activiti.dao;

import com.lefthand.activiti.dao.mapper.HisTaskMapper;
import com.lefthand.activiti.dao.mapper.ProcessTaskMapper;
import com.lefthand.activiti.domain.HisTask;
import com.lefthand.activiti.domain.MyTask;
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
 * Created by PanjinF on 2015/6/18.
 */
@Repository
public class ActivitiBusinessDao {
    private static Logger logger = LoggerFactory.getLogger(ActivitiBusinessDao.class);
    @Autowired
    private ProcessTaskMapper processTaskMapper;

    @Autowired
    private HisTaskMapper hisTaskMapper;

    /**
     * 根据用户，查询 所属的待办 全部信息集合 包含list 和 page 和 total
     * @param page
     * @param terms
     * @return
     */
    public Page<MyTask> findTaskListByName(PageRequest page, Map<String, Object> terms){
        try {
            List<MyTask> content = processTaskMapper.findTaskListByName(page,terms);
            long total = processTaskMapper.queryProcessTaskTotal(terms);
            return new PageImpl<MyTask>(content, page, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }

    /**
     * 按照条件 查询历史任务对象的lsit集合,根据用户Id 查询所属办理任务
     *
     * @param terms
     * @param page
     * @return
     */
    public Page<HisTask> findAllHisTaskByUserId(PageRequest page, Map<String, Object> terms,String userId) {
        try {
            List<HisTask> content = hisTaskMapper.findAllHisTaskByUserId(page, terms, userId);
            long total = hisTaskMapper.queryHisTaskTotalByUserId(terms, userId);
            return new PageImpl<HisTask>(content, page, total);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new com.lefthand.comm.exception.ApplicationException(e.getMessage(), e);
        }
    }
}
