package com.lefthand.security.organization.domain;

public abstract interface User extends Organization
{
    public abstract com.lefthand.security.organization.domain.Department getParent();

    public abstract com.lefthand.security.organization.domain.Unit getUnit();
}