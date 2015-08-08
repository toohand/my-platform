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
public class HDFSClientServer {
	
	private static Configuration configuration;
	private static FileSystem fileSystem;
	private static final String HDFS_URL = "hdfs://192.168.0.165:8020";
	
	public HDFSClientServer() {
		
	}
	/**
	 * HDFS服务器读取初始化
	 * @param path 
	 */
	private static void init(String path) {
		try {
			File workaround = new File(".");
			System.out.println(workaround.getAbsolutePath());
			
	        System.getProperties().put("hadoop.home.dir", workaround.getAbsolutePath());
	        new File("./bin").mkdirs();
	        new File("./bin/winutils.exe").createNewFile();

			configuration= new Configuration();
			fileSystem = FileSystem.get(URI.create(path), configuration);

			System.out.println("读取服务器成功");
		} catch (IOException e) {
			System.out.println("读取服务器失败");
			e.printStackTrace();
		}
	}
	public static FileSystem getFileSystem(String path){
		if(fileSystem==null){
			init(path);
		}
		return fileSystem;
	}

}
