package com.lefthand.activiti.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by PanjinF on 2015/5/23.
 */
public class MyDeployment implements Serializable {
    private String id;

    private String name;

    private Date deploymentTime;

    private String category;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDeploymentTime() {
        return deploymentTime;
    }

    public void setDeploymentTime(Date deploymentTime) {
        this.deploymentTime = deploymentTime;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
