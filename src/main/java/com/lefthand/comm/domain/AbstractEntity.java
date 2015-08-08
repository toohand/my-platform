package com.lefthand.comm.domain;

public abstract class AbstractEntity
        implements Entity
{
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if ((o == null) || (getClass() != o.getClass())) return false;

        AbstractEntity entity = (AbstractEntity)o;

        if (getId() != null ? !getId().equals(entity.getId()) : entity.getId() != null) return false;

        return true;
    }

    public int hashCode()
    {
        return getId() != null ? getId().hashCode() : 0;
    }
}