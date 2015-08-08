package com.lefthand.login;

import com.lefthand.ControllerAbstractTest;
import org.junit.Test;

/**
 * 登录测试
 * Created by wangmz on 2015/7/13.
 */
public class LoginControllerTest extends ControllerAbstractTest {

    @Test
    public void testLogin() throws Exception {
        String url = "/android/login?loginName=hzq&password=123456";
        this.testPost(url);
    }
}
