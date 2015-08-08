package com.lefthand.example;

import com.lefthand.comm.exception.MessageProvider;

/**
 * Created by Administrator on 2014/9/30.
 */
public enum ExampleModule {

    ERR_DAO_TODO_SAVE,
    ERR_DAO_TODO_DELETE,
    ERR_DAO_TODO_FIND,
    ERR_DAO_TODO_FIND_BY_ALL,
    ERR_DAO_TODO_QUERY,
    ERR_DAO_TODO_COUNT,

    ERR_SEV_TODO_SAVE,
    ERR_SEV_TODO_DELETE,
    ERR_SEV_TODO_FIND,
    ERR_SEV_TODO_FIND_BY_ALL,
    ERR_SEV_TODO_QUERY,
    ERR_SEV_TODO_COUNT,
    ;

    @Override
    public String toString() {
        return MessageProvider.getResource(ExampleModule.class).getMessage(this.name());
    }
}
