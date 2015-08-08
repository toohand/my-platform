package com.lefthand.security.organization.domain;

import com.lefthand.comm.domain.AbstractEntity;

public class AreaImpl extends AbstractEntity
        implements Area
{
    private String id;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }
}