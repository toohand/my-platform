package com.lefthand.system.service.impl;

import com.lefthand.base.service.BaseServiceImpl;
import com.lefthand.system.service.SysPortalService;
import com.lefthand.system.dao.mapper.SysPortalDao;
import com.lefthand.system.domain.SysPortal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;

/**
* Title: portal管理 业务类
* Description: portal新增、删除、修改
* Company: hugeinfo
* author: codeBuilder
* time:2015-06-24 15:13:45
* version 1.0
*/
@Service
public class SysPortalServiceImpl  extends BaseServiceImpl<SysPortal> implements SysPortalService {
    @Autowired
    private SysPortalDao fDao;

    @PostConstruct
    protected void injectSessionFactory() {
        super.setBaseDao(fDao);
    }

}
