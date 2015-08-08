package com.lefthand.security.organization.domain;

public class UserImpl extends OrganizationImpl
        implements com.lefthand.security.organization.domain.User
{
    public UserImpl()
    {
        setType(com.lefthand.security.organization.domain.support.OrganizationType.USER);
    }

    public com.lefthand.security.organization.domain.Department getParent()
    {
        return (com.lefthand.security.organization.domain.Department)super.getParent();
    }

    public com.lefthand.security.organization.domain.Unit getUnit()
    {
        return getParent().getParent();
    }
}