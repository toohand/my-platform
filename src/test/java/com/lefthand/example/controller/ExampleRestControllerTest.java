package com.lefthand.example.controller;

import com.lefthand.ControllerAbstractTest;
import com.lefthand.comm.utils.JsonMapper;
import com.lefthand.example.data.ExampleDataProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 单元测试范例-控制层单元测试类
 * 必须继承 ControllerAbstractTest 类
 * Created by wangmz on 2015/6/15.
 */
public class ExampleRestControllerTest extends ControllerAbstractTest {

    private static Logger logger = LoggerFactory.getLogger(ExampleRestControllerTest.class);

    //JSON数据转换
    private static JsonMapper jsonMapper = new JsonMapper();

    /**
     * 测试GET请求
     * @throws Exception
     */
    @Test
    public void testData() throws Exception {
        String url = "/api/example/data";
        this.testGet(url);
    }

    /**
     * 测试POST请求
     * 提交的数据是JSON字符串
     * @throws Exception
     */
    @Test
    public void testSave() throws Exception {
        String url = "/api/example/save";
        String json = jsonMapper.toJson(ExampleDataProvider.example1_());
        this.testPost(url,json);
    }
}
