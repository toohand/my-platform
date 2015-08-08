package com.lefthand.security.organization.domain;

import com.lefthand.comm.domain.AbstractEntity;

public abstract class OrganizationImpl extends AbstractEntity
        implements Organization
{
    private String id;
    private String name;
    private Organization parent;
    private com.lefthand.security.organization.domain.support.OrganizationType type;

    public String getId()
    {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public com.lefthand.security.organization.domain.support.OrganizationType getType()
    {
        return this.type;
    }

    public void setType(com.lefthand.security.organization.domain.support.OrganizationType type)
    {
        this.type = type;
    }

    public Organization getParent()
    {
        return this.parent;
    }

    public void setParent(Organization parent)
    {
        this.parent = parent;
    }
}