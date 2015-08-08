package com.lefthand.base.bdcode.builder;

import com.lefthand.base.bdcode.LowerFirstCharacter;
import com.lefthand.base.bdcode.UpperFirstCharacter;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Map;

/**
 * 代码生成基础类
 * @author hp
 *
 */
public abstract class BaseCodeBuilder implements ICodeBuilder {
	
	/** 
	 * description:将java包路径装载到map中的处理,路径为空则默认为和Class同包
	 * @param map 	信息集
	 * @param path	包路径
	 * @param cls	处理类
	 * @param id  	放入信息的标示
	*/ 
	@SuppressWarnings("unchecked")
	protected void setPath(Map<String, Object> map,String path,Class cls,String id){
		if (path.equals("")) {
			map.put(id, cls.getPackage().getName());
		} else {
			map.put(id, path);
		}
	}
	
	/** 
	 * description:根据包名，解析文件路径
	 * @param path 	包名
	 * @param name  文件名
	 * @return  
	*/ 
	@SuppressWarnings("unchecked")
	protected String getUrl(String path,String name) {
		String classPath = path;
		StringBuffer urlString = new StringBuffer();
		for (int i = classPath.indexOf("."); classPath.indexOf(".") > 0;) {
			i = classPath.indexOf(".");
			urlString.append("/" + classPath.substring(0, i));
			classPath = classPath.substring(i + 1);
		}
		urlString.append("/" + classPath);
		urlString.append("/" + name);
		return urlString.toString();
	}
	
	/** 
	 * 获取的模板配置对象
	 * @return  模板配置对象
	*/ 
	protected Configuration getConfiguration(){
		Configuration cfg = new Configuration();
		cfg.setClassForTemplateLoading(this.getClass(), getTemplateDir());
    	cfg.setSharedVariable("upperFC", new UpperFirstCharacter());
    	cfg.setSharedVariable("lowerFC", new LowerFirstCharacter());
    	cfg.setDefaultEncoding("UTF-8");
    	return cfg;
	}
	
	/** 
	 * description:获得模板目录地址
	 * @return  模板目录地址
	*/ 
	public abstract String getTemplateDir();
	
	/** 
	 * description:获得模板名称
	 * @return  模板名称
	*/ 
	public abstract String getTemplateName();
	
	/** 
	 * description:获取项目名下的根目录路径
	 * 如：java源文件的根目录一般为src。jsp/js等的根路径一般为 webRoot
	 * @return  目录路径
	*/ 
	public abstract String getRootUrl();
	
	/** 
	 * description:		输入对象解析后的参数信息生成代码
	 * @param data 		解析后的参数信息
	 * @param libUrl  	需要生成的代码项目路径
	*/ 
	public void buildCode(Map<String,Object> data,String libUrl){
		buildCode(data, libUrl, null);
	}

	public void buildCode(Map<String,Object> data){
		buildCode(data, System.getProperty("user.dir"), null);
	}

	public void buildCode(Map<String, Object> data, String libUrl, String url) {
		String root = getRootUrl()==null?"":"\\"+getRootUrl();
		String path = url==null? libUrl+root+data.get("url") : libUrl+root+url;
		System.out.println(path);
		try {
			Configuration cfg = getConfiguration();
			cfg.setDefaultEncoding("UTF-8");
			Template template = cfg.getTemplate(getTemplateName());
			buildFile(path, template, data);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (TemplateException e) {
			e.printStackTrace();
		}
	}
	
	public void buildFile(String path,Template template,Map<String, Object> data) throws IOException, TemplateException{
		template.setEncoding("utf-8"); 
		File file = new File(path);
		File dir = new File(file.getParent());
		if(!dir.exists()){
			dir.mkdirs();
		}
		if(!file.exists()){
			file.createNewFile();
		} else {  //文件存在就做备份
			int i= 1;
			File bakFile= new File(path+i+".bak");
			while (bakFile.exists()){
				i ++;
			    bakFile= new File(path+i+".bak");
			}
			file.renameTo(bakFile);
		}
		FileOutputStream fos = new FileOutputStream(new File(path));
		template.process(data, new OutputStreamWriter(fos,"utf-8"));
		fos.flush();
		fos.close();
	}
}
