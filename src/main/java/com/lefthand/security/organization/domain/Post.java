package com.lefthand.security.organization.domain;

public abstract interface Post extends Organization, com.lefthand.comm.domain.Handleable
{
    public abstract User getUser();

    public abstract void setUser(User paramUser);

    public abstract Department getParent();

    public abstract Unit getUnit();
}