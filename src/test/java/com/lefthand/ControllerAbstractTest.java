package com.lefthand;

import org.junit.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * 控制层测试类基类
 * 所有控制层的测试类必须继承该类
 * Created by wangmz on 2015/6/15.
 */
@WebAppConfiguration()
public class ControllerAbstractTest extends AbstractTest {

    private static Logger logger = LoggerFactory.getLogger(ControllerAbstractTest.class);

    @Autowired
    private WebApplicationContext wac;

    protected MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    /**
     * 测试GET请求
     * @param url 测试连接
     * @throws Exception
     */
    public void testGet(String url) throws Exception {
        MvcResult result = mockMvc.perform((get(url)))
                .andExpect(status().isOk())
//               .andDo(print())
                .andReturn();
        logger.debug("响应数据：{}",result.getResponse().getContentAsString());
    }

    /**
     * 测试POST请求
     * 提交的数据是JSON字符串
     * @param url  测试连接
     * @param json JSON字符串
     * @throws Exception
     */
    public void testPost(String url, String json) throws Exception {
        MvcResult result = mockMvc.perform((post(url).contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)))
//               .andDo(print())
                .andReturn();
        logger.debug("响应数据：{}",result.getResponse().getContentAsString());
    }

    /**
     * 测试POST请求
     * @param url  测试连接 比如：${ctx}\login?loginName=xxx&password=xxx
     * @throws Exception
     */
    public void testPost(String url) throws Exception {
        MvcResult result = mockMvc.perform((post(url)))
                .andReturn();
        logger.debug("响应数据：{}",result.getResponse().getContentAsString());
    }
}
