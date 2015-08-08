package com.lefthand.activititest.service.impl;

import com.lefthand.base.service.BaseServiceImpl;
import com.lefthand.activititest.service.ContradictionDemoService;
import com.lefthand.activititest.dao.mapper.ContradictionDemoDao;
import com.lefthand.activititest.domain.ContradictionDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
* Title: 矛盾上报Demo 业务类
* Description: 矛盾上报Demo
* Company: hugeinfo
* author: hp
* time:2015-08-05 10:16:08
* version 1.0
*/
@Service
public class ContradictionDemoServiceImpl  extends BaseServiceImpl<ContradictionDemo> implements ContradictionDemoService {
    @Autowired
    private ContradictionDemoDao fDao;

    @PostConstruct
    protected void injectSessionFactory() {
        super.setBaseDao(fDao);
    }

}
