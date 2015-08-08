package com.lefthand.security.organization.domain;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.lefthand.comm.domain.Entity;

@JsonTypeInfo(use=JsonTypeInfo.Id.MINIMAL_CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract interface Organization extends Entity
{
    public abstract String getId();

    public abstract com.lefthand.security.organization.domain.support.OrganizationType getType();

    public abstract void setType(com.lefthand.security.organization.domain.support.OrganizationType paramOrganizationType);

    public abstract Organization getParent();

    public abstract void setParent(Organization paramOrganization);
}