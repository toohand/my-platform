package com.lefthand.system.service;

import com.lefthand.base.service.BaseServiceable;
import com.lefthand.system.domain.SysDictionary;

import java.util.List;

/**
* Title: 数据字典管理 业务接口类
* Description: portal新增、删除、修改
* Company: hugeinfo
* author: codeBuilder
* time:2015-07-06 11:39:01
* version 1.0
*/
public interface SysDictionaryService extends BaseServiceable<SysDictionary> {

    public List<SysDictionary> getDtyDetail(String typeId);

}
