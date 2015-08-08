package com.lefthand.security.organization.domain;

public class DepartmentImpl extends OrganizationImpl
        implements Department
{
    public DepartmentImpl()
    {
        setType(com.lefthand.security.organization.domain.support.OrganizationType.DEPARTMENT);
    }

    public com.lefthand.security.organization.domain.Unit getParent()
    {
        return (com.lefthand.security.organization.domain.Unit)super.getParent();
    }
}