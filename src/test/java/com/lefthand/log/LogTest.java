package com.lefthand.log;

import com.lefthand.AbstractTest;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 系统日志打印测试
 * Created by wangmz on 2015/7/20.
 */
public class LogTest extends AbstractTest {
    private static Logger logger = LoggerFactory.getLogger(LogTest.class);

    @Test
    public void test(){
        logger.trace("trace===========");
        logger.debug("debug===========");
        logger.warn("warn===========");
        logger.info("info===========");
        logger.error("error===========");
    }
}
