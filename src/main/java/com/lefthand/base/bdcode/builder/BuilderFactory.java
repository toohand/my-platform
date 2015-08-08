package com.lefthand.base.bdcode.builder;

import com.lefthand.demo.domain.BdCodeDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;



/**
 * tooNan代码生成器模板
 * @author hp
 *
 */
public class BuilderFactory {
	//代码生成器集合根据Class生成各种代码
	private List<ICodeBuilder> builderList = new ArrayList<ICodeBuilder>();

	//需要生成的Class集合
	@SuppressWarnings("unchecked")
	private List<Class> classList = new ArrayList<Class>();

	/** 
	 * description:设置需要使用的代码生成器集（不同的生成器生成不同的代码）
	 * @param builderList 代码生成器集 
	*/
	public void setBuilderList(List<ICodeBuilder> builderList) {
		this.builderList = builderList;
	}

	/** 
	 * description:设置需要生成的Class集合（加入特定注解的pojo对象）
	 * @param classList pojo对象Class集合
	*/
	@SuppressWarnings("unchecked")
	public void setClassList(List<Class> classList) {
		this.classList = classList;
	}

	/** 
	 * description:  生成代码，生成的代码文件放到当前默认的工程所在目录中
	*/
	public void build() {
		build(System.getProperty("user.dir"));
	}

	/** 
	 * description: 生成代码，生成的代码文件放到指定目录中
	 * @param path  指定文件目录 为null 这放到当前默认的工程所在目录
	*/
	@SuppressWarnings("unchecked")
	public void build(String path) {
		if (path == null) {
			build();
		}
		for (Class cls : classList) {
			for (ICodeBuilder builder : builderList) {
				Map<String, Object> map;
				try {
					map = builder.createMap(cls);
					builder.buildCode(map, path);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

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
	 *		buildList.add(new ControllerBuilder());   控制层 类
	 *		buildList.add(new ServiceBuilder());  业务处理类
	 *		buildList.add(new IServiceBuilder()); 业务处理接口
	 *		buildList.add(new JspListBuilder());  查询页面
	 *		buildList.add(new JspEditBuilder());  业务编辑页面
	 *		builderFactory.setBuilderList(buildList);<br/>
	 *<br/>
	 * 第三步：加载需要生成的类（加入了特定自定义注解的Pojo对象,根据需要可以注释掉不需要生成的类。)<br/>
	 * 		//		下列只生成SysEmpOrg 人员与组织机构多对多关系类相关的文件<br/>
	 * 				List<Class> classList = new ArrayList<Class>();<br/>
	 *		//		classList.add(SysUserGroup.class);<br/>
	 *		//		classList.add(TestObject.class);<br/>
	 *				classList.add(SysEmpOrg.class);<br/>
	 *		//		classList.add(DemoAuthData.class);<br/>
	 *		//		classList.add(SysGroup.class);<br/>
	 *		//		classList.add(SysPhrase.class);<br/>
	 *		//		classList.add(SysPost.class);<br/>
	 *				builderFactory.setClassList(classList);<br/>
	 *<br/>
	 * 第四步：开始代码生成<br/>
	 * 				builderFactory.build();<br/>
	*/
	@SuppressWarnings("unchecked")
	public static void runBuilder() {
		//创建代码工厂
		BuilderFactory builderFactory = new BuilderFactory();

		List<ICodeBuilder> buildList = new ArrayList<ICodeBuilder>();
		//加载代码生成器

		/*buildList.add(new JspEditBuilder());
		buildList.add(new JspListBuilder());
		buildList.add(new ControllerBuilder());
		buildList.add(new ServiceBuilder());
		buildList.add(new IServiceBuilder());*/
		buildList.add(new MapperCodeBuilder());
		//buildList.add(new IDaoBuilder());
		builderFactory.setBuilderList(buildList);
		//加载需要生成的类
		List<Class> classList = new ArrayList<Class>();
		classList.add(BdCodeDemo.class);
		builderFactory.setClassList(classList);
		//构造代码
		builderFactory.build();
		System.out.println("build Complete");
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] agrs) {
		runBuilder();
	}
}
