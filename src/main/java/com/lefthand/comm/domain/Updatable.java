package com.lefthand.comm.domain;

import java.util.Date;

public abstract interface Updatable extends Creatable
{
    public abstract Date getUpdateTime();

    public abstract void setUpdateTime(Date paramDate);
}