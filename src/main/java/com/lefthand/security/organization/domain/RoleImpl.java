package com.lefthand.security.organization.domain;

import com.lefthand.comm.domain.AbstractEntity;

public class RoleImpl extends AbstractEntity
        implements Role
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