package com.lefthand.comm.exception;

public class ServiceException extends ApplicationException
{
    private static final long serialVersionUID = -917094867526324064L;

    public ServiceException()
    {
    }

    public ServiceException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ServiceException(Enum clazz, Throwable cause, Object... args) {
        super(clazz, cause, args);
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(Enum clazz, Object... args) {
        super(clazz, args);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}