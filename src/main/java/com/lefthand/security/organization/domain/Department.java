package com.lefthand.security.organization.domain;

public abstract interface Department extends Organization, com.lefthand.comm.domain.Handleable
{
    public abstract com.lefthand.security.organization.domain.Unit getParent();
}