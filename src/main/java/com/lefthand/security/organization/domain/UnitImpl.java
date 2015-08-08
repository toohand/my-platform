package com.lefthand.security.organization.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UnitImpl extends OrganizationImpl
        implements com.lefthand.security.organization.domain.Unit
{
    public UnitImpl()
    {
        setType(com.lefthand.security.organization.domain.support.OrganizationType.UNIT);
    }

    @JsonIgnore
    public com.lefthand.security.organization.domain.Organization getParent()
    {
        IllegalAccessException e = new IllegalAccessException("该对象不允许 getParent.");
        throw new RuntimeException(e);
    }

    @JsonIgnore
    public void setParent(com.lefthand.security.organization.domain.Organization parent)
    {
        IllegalAccessException e = new IllegalAccessException("该对象不允许 setParent.");
        throw new RuntimeException(e);
    }
}