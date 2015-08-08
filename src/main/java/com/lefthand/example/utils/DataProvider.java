package com.lefthand.example.utils;

import com.lefthand.example.domain.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangmz on 2015/5/20.
 */
public class DataProvider {

    private static Example createExample() {
        String id = com.lefthand.comm.utils.Identities.uuid2();
        Example example = new Example();
        example.setId(id);
        example.setName("TEST-data-"+id);
        example.setGender(true);
        return example;
    }

    public static Example getExample(){
        return createExample();
    }

    public static List<Example> getExamlpes(){
        List<Example> list = new ArrayList<Example>();
        for(int i=0;i<10;i++){
            list.add(createExample());
        }
        return list;
    }
}
