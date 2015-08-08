package com.lefthand.comm.domain;

import java.io.Serializable;

public abstract interface Entity extends Serializable
{
    public abstract Object getId();
}