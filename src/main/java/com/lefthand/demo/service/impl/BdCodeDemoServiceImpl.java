package com.lefthand.demo.service.impl;

import com.lefthand.base.service.BaseServiceImpl;
import com.lefthand.demo.service.BdCodeDemoService;
import com.lefthand.demo.dao.mapper.BdCodeDemoDao;
import com.lefthand.demo.domain.BdCodeDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
* Title: 代码生成器Demo 业务类
* Description: 代码生成器Demo
* Company: hugeinfo
* author: hp
* time:2015-07-16 13:29:06
* version 1.0
*/
@Service
public class BdCodeDemoServiceImpl  extends BaseServiceImpl<BdCodeDemo> implements BdCodeDemoService{
    @Autowired
    private BdCodeDemoDao fDao;

    @PostConstruct
    protected void injectSessionFactory() {
        super.setBaseDao(fDao);
    }

}
