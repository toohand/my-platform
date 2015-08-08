package com.lefthand.comm.hdfs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
 



import org.apache.hadoop.io.IOUtils;
//import org.apache.commons.io.IOUtils;
import org.apache.hadoop.fs.FSDataInputStream;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * HDFS(分布式文件存储系统操作类)
 * @author -hzy-
 *
 */
public class HDFSClient {
	
	private static Logger logger = LoggerFactory.getLogger(HDFSClient.class);
	
	/**
	 * 文件系统类
	 */
	private FileSystem fileSystem;
	 
	/**
	 * 无参数构造方法
	 */
	public HDFSClient() {
	   init();
	}
	 
	/**
	 * 初始化
	 */
	private void init() {
	   fileSystem = HDFSServer.getFileSystem();
	}
	 
	/**
	 * 获取HDFS指定目录下文件状态列表
	 * 
	 * @param dirPath指定目录路径
	 * @return fileStatusList
	 * @throws java.io.FileNotFoundException
	 * @throws java.io.IOException
	 */
	public FileStatus[] getFileStatus(Path path) throws FileNotFoundException,
	IOException {
	   FileStatus[] fileStatusList = fileSystem.listStatus(path);
	   return fileStatusList;
	}
	 
	/**
	 * 获取指定目录列表路径
	 * 
	 * @param dirPath
	 */
	public List<String> dir(String dirPath) throws IOException {
	  List<String> fileList = null;
	  Path path = new Path(dirPath);
	  if (fileSystem.exists(path)) {
	    fileList = new ArrayList<String>();
	    FileStatus[] list = this.getFileStatus(path);
	  for (FileStatus fileStatus : list) {
	    fileList.add(fileStatus.getPath().toString());
	  }
	  } else {
	     System.out.println("目录不存在");
	  }
	  return fileList;
	}
	 
	/**
	 * 获取文件
	 * 
	 * @param filePath
	 * @return
	 * @throws java.io.IOException
	 */
	public InputStream getFile(String filePath) throws IOException {
	Path path = new Path(filePath);
	return fileSystem.open(path);
	}
	 
	/**
	 * 更改HDSF文件名称
	 * 
	 * @param fileOldName
	 * @param fileNewName
	 * @return boolean:是否更名字成功
	 * @throws java.io.IOException
	 */
	public boolean rename(String src, String dst) throws IOException {
	   Path srcPath = new Path(src);
	   if (fileSystem.exists(srcPath)) {
	     Path dstPath = new Path(dst);
	     return fileSystem.rename(srcPath, dstPath);
	   }
	   System.out.println("原文件不存在");
	   return false;
	}
	 
	/**
	 * 创建HDFS目录
	 * 
	 * @param dir
	 */
	public boolean createDir(String dir) throws IOException {
	   Path path = new Path(dir);
	   if (fileSystem.exists(path)) {
	     System.out.println("此目录已经存在不需要再创建");
	   return true;
	   }
	   return fileSystem.mkdirs(path);
	}
	 
	/**
	 * 上传本地文件到HDFS（注意是服务器本地硬盘，非客户端硬盘)）
	 * 
	 * @return
	 * 
	 * @throws java.io.IOException
	 */
	public void uploadLocalFile(String localFileSrc, String HDFSFileDst)
	           throws IOException {
	  Path src = new Path(localFileSrc);
	  Path dst = new Path(HDFSFileDst);
	  fileSystem.copyFromLocalFile(src, dst);
	}
	/**
	 * 批量上传本地文件到HDFS
	 * @param localFileSrcs本地文件列表
	 * @param HDFSFileDst
	 * @throws java.io.IOException
	 */
	public void uploadLocalFile(String[] localFileSrcs,String HDFSFileDst) throws IOException{
	    Path dstPath=new Path(HDFSFileDst);
	    Path[] paths=new Path[localFileSrcs.length];
	    for (int i=0;i<localFileSrcs.length;i++) {
	    	paths[i]=new Path(localFileSrcs[i]);
		}
	    fileSystem.copyFromLocalFile(false, false, paths,dstPath);
	}
	/**
	 * 从HDFS下载文件到本地(注意是服务器本地硬盘，非浏览器客户端硬盘)
	 * 
	 * @param HDFSFilePath
	 * @param localFilePath
	 * @throws java.io.IOException
	 */
	public void downFileToLocal(String HDFSFilePath, String localFilePath)
	throws IOException {
	  Path dstPath = new Path(HDFSFilePath);
	  FSDataInputStream in = fileSystem.open(dstPath);
	  OutputStream out = new FileOutputStream(new File(localFilePath));
	  IOUtils.copyBytes(in, out, 1024);
	}
	 
	/**
	 * HDFS文件是否存在
	 * 
	 * @param filePath
	 * @return boolean:是否存在
	 * @throws java.io.IOException
	 */
	public boolean exists(String filePath) throws IOException {
	  Path path = new Path(filePath);
	  return fileSystem.exists(path);
	}
	 
	/**
	 * 根据路径删除文件或文件夹
	 * 
	 * @param filePath
	 * @return
	 * @throws java.io.IOException
	 */
	@SuppressWarnings("deprecation")
	public boolean deleteFile(String filePath) throws IOException {
	  if (this.exists(filePath)) {
	    Path path = new Path(filePath);
	    fileSystem.delete(path, true);
	    return true;
	  }
	  System.out.println("文件不存在");
	  return false;
	}
	 
	/**
	 * 剪切本地文件到HDFS(注意为服务器本地文件);
	 * 
	 * @param src本地路径
	 * @param dst分布式存储路径
	 * @throws java.io.IOException
	 */
	public void moveFromLocalFile(String localSrc, String HDFSDst) throws IOException {
	   Path srcPath = new Path(localSrc);
	   Path dstPath = new Path(HDFSDst);
	   fileSystem.moveFromLocalFile(srcPath, dstPath);
	}
	/**
	 * HDFS文件之间的复制
	 * @param src源文件路径
	 * @param dst要复制后复制文件的路径
	 * @throws java.io.IOException
	 */
	public void copyHDFSFile(String src,String dst) throws IOException{
	   Path srcPath=new Path(src);
	   Path dstPath=new Path(dst);
	   InputStream in=fileSystem.open(srcPath);
	   OutputStream out=fileSystem.create(dstPath);
	   IOUtils.copyBytes(in, out, 1024);
	}
	/**
	 * HDFS中移动文件
	 * @param src源文件路径
	 * @param dst要移动后的路径
	 * @throws java.io.IOException
	 */
	@SuppressWarnings("deprecation")
	public void moveHDFSFile(String src,String dst) throws IOException{
	   Path srcPath=new Path(src);
	   Path dstPath=new Path(dst);
	   InputStream in=fileSystem.open(srcPath);
	   OutputStream out=fileSystem.create(dstPath);
	   IOUtils.copyBytes(in, out, 1024);
	   fileSystem.delete(srcPath,true);
	}
	/**
	 * 剪切HDFS文件到本地
	 * @param HDFSSrc
	 * @param localDst
	 * @throws java.io.IOException
	 */
    public void moveToLocalFile(String HDFSSrc,String localDst) throws IOException{
	    Path srcPath = new Path(HDFSSrc);
	    Path dstPath = new Path(localDst);
	    fileSystem.moveToLocalFile(srcPath, dstPath);
    }
	/**
	 * HDFS创建文件
	 * 
	 * @param in输入流
	 * @param dst分布式存储路径
	 * @throws java.io.IOException
	 */
	public boolean create(InputStream in, String dst) throws IOException {
	   try {
		   Path dstPath = new Path(dst);
		   System.out.println("文件流信息：" + in.available());
		   System.out.println("路径信息：" + dst);
		   FSDataOutputStream out = fileSystem.create(dstPath, new Progressable() {
		        @Override
		        public void progress() {
		         logger.debug("write success.");
		        }
		   });
		   IOUtils.copyBytes(in, out, 4096);
		   IOUtils.closeStream(out);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	   return true;
	}
	 
	/**
	 * 在HDFS创建文件
	 * 
	 * @param file
	 * @param dst分布式存储路径
	 * @throws java.io.IOException
	 */
	public void create(File file, String dst) throws IOException {
	   InputStream in = new FileInputStream(file);
	   this.create(in, dst);
	}
	 
	/**
	 * 在HDFS创建文件
	 * 
	 * @param src本地文件路径
	 * @param dst分布式存储路径
	 * @throws java.io.IOException
	 */
	public void create(String src, String dst) throws IOException {
	   File file = new File(src);
	   this.create(file, dst);
	}
	
	/**
	 * 获取文件输出流
	 * @param dst 分布式存储路径
	 * @return
	 * @throws java.io.IOException
	 */
	public InputStream read(String dst) throws IOException {
		Path dstPath = new Path(dst);
		InputStream in = fileSystem.open(dstPath);
		return in;
	}
	 
	/**
	 * 获取FileSystem对象
	 * 
	 * @return
	 */
	public FileSystem getFileSystem() {
	   return fileSystem;
	}
	 
	/**
	 * 关闭HDFS
	 * 
	 * @throws java.io.IOException
	 */
	public void close() throws IOException {
	   fileSystem.close();
	}
	 
	public boolean isDir(String src) throws IOException {
	   Path path = new Path(src);
	   return fileSystem.isDirectory(path);
	}
	
	public static void main(String[] args) throws IOException {
		HDFSClient hdfs = new HDFSClient();
		// hdfs.uploadLocalFile("D:/picture", "/test"); //
		System.out.println(hdfs.dir("/"));
//		System.out.println(hdfs.exists("/dzgw/市信息中心/dcf13928667144e5a44e237de85b2e13.doc"));
//		新增文件夹
		hdfs.createDir("/test1");
		//上传客户端文件至HDFS测试
//		hdfs.create("D:/ABCDEFG.doc","/dzgw/市信息中心/ABCDEFG.doc");
//		System.out.println(hdfs.dir("/test/picture/mypicture"));
		//hdfs.uploadLocalFile(new String[]{"E:/input","E:/output"}, "/");
		//hdfs.rename("/input", "/debug_in");
//		System.out.println(hdfs.dir("/debug_out"));
		//hdfs.deleteFile("/output");
		// hdfs.moveFromLocalFile("E:/test.jpg", "/test/picture/POP海报2590.jpg");
		/*
		 * System.out.println(hdfs.dir("/test"));
		 * System.out.println(hdfs.exists("/test/picture/mypicture")); //
		 * hdfs.delete("/test/picture/mypicture");
		 * System.out.println(hdfs.dir("/test/picture"));
		 */
//		hdfs.downFileToLocal("/dzgw/null/a7c0e1615072b37fe040000ac308769a.pdf", "D:/龙华区反馈意见2.pdf");
//		hdfs.uploadLocalFile(new String[]{"E:/text","E:/text2"}, "/test");
//		hdfs.deleteFile("/dir");
		hdfs.close();
	}

}
