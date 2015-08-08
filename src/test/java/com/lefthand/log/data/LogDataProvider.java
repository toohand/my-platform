package com.lefthand.log.data;

import com.lefthand.log.domain.entity.Log;

import java.util.Date;

/**
 * 日志数据提供类
 * Created by wangmz on 2015/7/2.
 */
public class LogDataProvider {

    private LogDataProvider(){}

    /**
     * 产生固定ID日志
     * @return
     */
    public static Log log(){
        Log log = new Log();
        log.setId("UT_LOG_ID");
        log.setDetail("测试日志信息");
        log.setHost("123.123.123.13");
        log.setIp("192.189.1.1");
        log.setLevel("BUG");
        log.setLogger(LogDataProvider.class.getName());
        log.setMessage("测测测测");
        log.setCreateTime(new Date());
        return log;
    }

    /**
     * 产生随机ID日志
     * @return
     */
    public static Log log_(){
        Log log = new Log();
        log.setId("UT_LOG_"+ com.lefthand.comm.utils.Identities.uuid2());
        log.setDetail("测试日志信息");
        log.setHost("123.123.123.13");
        log.setIp("192.189.1.1");
        log.setLevel("BUG");
        log.setLogger(LogDataProvider.class.getName());
        log.setMessage("测测测测");
        log.setCreateTime(new Date());
        return log;
    }
}
