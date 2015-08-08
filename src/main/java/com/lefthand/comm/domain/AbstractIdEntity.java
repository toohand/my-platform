package com.lefthand.comm.domain;

/**
 * 实体基类
 */
public abstract class AbstractIdEntity extends AbstractEntity implements com.lefthand.comm.domain.Entity {

    /**
     * 实体编号
     */
    private String id;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
