package com.lefthand.activititest.service.impl;

import com.lefthand.base.service.BaseServiceImpl;
import com.lefthand.activititest.service.LeaveBillDemoService;
import com.lefthand.activiti.dao.mapper.LeaveBillDemoDao;
import com.lefthand.activititest.domain.LeaveBillDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
* Title: 请假流程Demo 业务类
* Description: 请假流程Demo
* Company: hugeinfo
* author: hp
* time:2015-07-02 16:29:44
* version 1.0
*/
@Service
public class LeaveBillDemoServiceImpl  extends BaseServiceImpl<LeaveBillDemo> implements LeaveBillDemoService{
    @Autowired
    private LeaveBillDemoDao fDao;

    @PostConstruct
    protected void injectSessionFactory() {
        super.setBaseDao(fDao);
    }

}
