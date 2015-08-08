package com.lefthand.jms.service;

import com.lefthand.AbstractTest;
import com.lefthand.jms.data.MessageDataProvider;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 消息生产服务测试
 * Created by wangmz on 2015/6/24.
 */
public class JmsServiceTest extends AbstractTest {

    private static Logger logger = LoggerFactory.getLogger(JmsServiceTest.class);

    @Autowired
    private JmsService jmsService;

    /**
     * 测试消息发送接口
     * @throws Exception
     */
    @Test()
    public void testSendToTopic() throws Exception {
        jmsService.sendToTopic(".topic.event", MessageDataProvider.message());

    }
}
