package com.lefthand.comm.domain;

import java.util.Date;

public abstract interface Creatable extends Entity
{
    public abstract Object getOperator();

    public abstract Date getCreateTime();

    public abstract void setCreateTime(Date paramDate);
}