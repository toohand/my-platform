package com.lefthand.security.organization.domain.support;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using=OrganizationTypeSerializer.class)
@JsonDeserialize(using= com.lefthand.security.organization.domain.support.OrganizationTypeDeserializer.class)
public enum OrganizationType
{
    USER(1, "用户"),
    POST(2, "岗位"),
    DEPARTMENT(3, "部门"),
    UNIT(4, "单位");

    private int id;
    private String desc;

    private OrganizationType(int id, String desc)
    {
        this.id = id;
        this.desc = desc;
    }

    public static OrganizationType fromTypeId(int id)
    {
        switch (id) { case 1:
            return USER;
            case 2:
                return POST;
            case 3:
                return DEPARTMENT;
            case 4:
                return UNIT;
        }
        throw new IllegalArgumentException("Invalid OrganizationType Id: " + id);
    }

    public int id() {
        return this.id;
    }

    public String desc() {
        return this.desc;
    }
}