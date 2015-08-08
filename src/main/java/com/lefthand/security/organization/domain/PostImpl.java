package com.lefthand.security.organization.domain;

public class PostImpl extends OrganizationImpl
        implements Post
{
    private User user;

    public PostImpl()
    {
        setType(com.lefthand.security.organization.domain.support.OrganizationType.POST);
    }

    public User getUser()
    {
        return this.user;
    }

    public void setUser(User user)
    {
        this.user = user;
    }

    public Department getParent()
    {
        return (Department)super.getParent();
    }

    public com.lefthand.security.organization.domain.Unit getUnit()
    {
        return getParent().getParent();
    }
}