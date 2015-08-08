package com.lefthand.comm.domain;

import java.util.Date;

/**
 * 可更新的实体基类
 */
public abstract class AbstractCreatableEntity extends AbstractIdEntity implements Entity {

    /**
     * 创建时间
     */
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
