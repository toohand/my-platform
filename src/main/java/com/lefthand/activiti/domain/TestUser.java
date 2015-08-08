package com.lefthand.activiti.domain;

import java.io.Serializable;

/**
 * Created by PanjinF on 2015/6/12.
 */
public class TestUser implements Serializable{
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    private String id;
    private String loginName;
    private String passWord;
    private String postName;
}
