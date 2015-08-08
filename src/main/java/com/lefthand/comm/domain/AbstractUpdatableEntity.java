package com.lefthand.comm.domain;

import java.util.Date;

/**
 * 可更新的实体基类
 */
public abstract class AbstractUpdatableEntity extends AbstractCreatableEntity implements Entity {

    /**
     * 更新时间
     */
    private Date updateTime;

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
