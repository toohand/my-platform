package com.lefthand.example.data;

import com.lefthand.example.domain.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * 范例-测试数据提供类
 * Created by wangmz on 2015/6/15.
 */
public class ExampleDataProvider {

    private ExampleDataProvider(){}

    /**
     * 不产生ID的数据类，可用于测试数据新增
     * @return
     */
    public static Example example1(){
        Example example = new Example();
        example.setName("测试_01");
        example.setGender(true);
        return example;
    }

    /**
     * 产生ID的数据类，可用于测试数据更新
     * @return
     */
    public static Example example1_(){
        Example example = new Example();
        example.setId("UT_EXAMPLE_01");//测试ID编号规范：UT_模块代号_编号
        example.setName("测试_01");
        example.setGender(true);
        return example;
    }

    /**
     * 数据集合类
     * @param num 初始化个数
     * @return
     */
    public static List<Example> list(int num){
        List<Example> list = new ArrayList<Example>();
        for(int i=0;i<num;i++){
            list.add(example1());
        }
        return list;
    }

    /**
     * 不产生ID的数据类，可用于测试数据新增
     * @return
     */
    public static Example example2(){
        Example example = new Example();
        example.setName("测试_02");
        example.setGender(true);
        return example;
    }

    /**
     * 产生ID的数据类，可用于测试数据更新
     * @return
     */
    public static Example example2_(){
        Example example = new Example();
        example.setId("UT_EXAMPLE_02");//测试ID编号规范：UT_模块代号_编号
        example.setName("测试_02");
        example.setGender(true);
        return example;
    }
}
