package com.lefthand.comm.hdfs;

import java.io.File;
import java.io.IOException;
import java.net.URI;
 
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.mapred.JobConf;


/**
 * HDFS服务器
 * @author wangminzhao
 *
 */
public class HDFSServer {
	
	private static Configuration configuration;
	private static FileSystem fileSystem;
	private static final String HDFS_URL = "hdfs://192.168.0.165:8020";
//	private static final String HDFS_URL = "hdfs://10.0.8.117:9000";
//	private static final String HDFS_URL = new PropertiesLoader("META-INF/config/attach.properties").getProperty("attach.hdfs.url");
	 
	
	public HDFSServer() {
		
	}
	/**
	 * HDFS服务器读取初始化
	 */
	private static void init() {
		try {
//			configuration= new JobConf(HDFSServer.class);
            File workaround = new File(".");
            System.out.println(workaround.getAbsolutePath());


//			File workaround = new File(".");
            System.getProperties().put("hadoop.home.dir", workaround.getAbsolutePath());
            new File("./bin").mkdirs();
            new File("./bin/winutils.exe").createNewFile();

//	        System.getProperties().put("hadoop.home.dir", workaround.getAbsolutePath());
            configuration= new Configuration();
            fileSystem = FileSystem.get(URI.create(HDFS_URL), configuration);
            //配置参数个数
            System.out.println(configuration.size());

            //查看配置参数信息
			/*Iterator<Map.Entry<String, String>> it = configuration.iterator();
			 while(it.hasNext()) {
				 Entry<String, String> en = it.next();
				 String key = en.getKey();
				 String value = en.getValue();
				 System.out.println("key=" + key + "  value=" + value);
			 }
			 configuration.writeXml(System.out);
			
			 //显示配置文件路径
			 System.out.println("\n\n" + configuration.getResource("core-default.xml"));
			 System.out.println("\n\n" + configuration.getResource("core-site.xml"));*/
            System.out.println("读取服务器成功");
		} catch (IOException e) {
			System.out.println("读取服务器失败");
			e.printStackTrace();
		}
	}
	public static FileSystem getFileSystem(){
		if(fileSystem==null){
			init();
		}
		return fileSystem;
	}

}
