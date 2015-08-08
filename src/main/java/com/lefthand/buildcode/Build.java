package com.lefthand.buildcode;

import com.lefthand.base.bdcode.builder.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用代码生成类.
 */
public class Build {
    /**
     * 开启代码构造器，开始生成代码<br/>
     * <br/>
     * 该方法为开发性方法，为开发人员如何调用代码生成器进行最简单的引导<br/>
     * 开发人员也可以根据需要进行自行修改并启动，以达到提高开发效率的作用<br/>
     * 方法内主要是对代码生成器工厂的方法使用的一个范例。<br/>
     * <br/>
     * 第一步：初始化代码生成器工厂<br/>
     * 				BuilderFactory builderFactory = new BuilderFactory();<br/>
     * <br/>
     * 第二步：加载代码生成器(根据需要可以注释掉不需要生成器，避免将原有的代码覆盖掉。)<br/>
     * 		该过程也可以是使用Spring注入方式进行，为提高效率不建议开发人员在开发阶段使用这种方法<br/>
     *	  	//		下列中只生成Dao的接口和实现<br/>
     *		List<ICodeBuilder> buildList = new ArrayList<ICodeBuilder>();<br/>
     *      buildList.add(new JspEditBuilder());       //生成jsp编辑页面
     *      buildList.add(new JspListBuilder());       //生成jsp查询页面
     *      buildList.add(new ControllerBuilder());    //生成业务控制层
     *      buildList.add(new ServiceBuilder());       //生成业务处理类
     *      buildList.add(new IServiceBuilder());      //生成业务处理类接口
     *      buildList.add(new MapperCodeBuilder());    //生成数据库操作Mapper文件
     *      buildList.add(new IDaoBuilder());          //生成数据库操作接口文件
     *		builderFactory.setBuilderList(buildList);<br/>
     *<br/>
     * 第三步：加载需要生成的类<br/>
     *				builderFactory.setClassList(classList);<br/>
     *              classList.add(BdCodeDemo.class);
     * 第四步：开始代码生成<br/>
     * 				builderFactory.build();<br/>
     */
    @SuppressWarnings("unchecked")
    public static void runBuilder() {
        //创建代码工厂
        BuilderFactory builderFactory = new BuilderFactory();

        List<ICodeBuilder> buildList = new ArrayList<ICodeBuilder>();
        //加载代码生成器，可以根据需要注释掉不需要生成的部分
        buildList.add(new JspEditBuilder());
        buildList.add(new JspListBuilder());
        buildList.add(new ControllerBuilder());
        buildList.add(new ServiceBuilder());
        buildList.add(new IServiceBuilder());
        buildList.add(new MapperCodeBuilder());
        buildList.add(new IDaoBuilder());
        builderFactory.setBuilderList(buildList);
        //加载需要生成的类，生成完成就删除掉，多次生成会把上次的文件按需要备份起来。
        List<Class> classList = new ArrayList<Class>();
       // classList.add(Student.class);
        builderFactory.setClassList(classList);
        //构造代码
        builderFactory.build();
        System.out.println("build Complete");
    }


    public static void main(String[] agrs) {
        runBuilder();
    }

}
