package com.lefthand;

import org.junit.FixMethodOrder;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 所有测试类的基类
 * 统一测试配置信息
 * Created by wangmz on 2015/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring-mvc.xml", "classpath*:/spring-context.xml"})
@FixMethodOrder(MethodSorters.JVM)
public class AbstractTest {
}
