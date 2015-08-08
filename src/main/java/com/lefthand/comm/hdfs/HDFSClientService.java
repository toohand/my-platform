package com.lefthand.comm.hdfs;


import java.io.*;

import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Hadoop文件读写服务
 */
public class HDFSClientService {

	private static Logger logger = LoggerFactory.getLogger(HDFSClientService.class);

	// fttp资源地址
	//private static final String FTTP_URI = "fttp://10.0.8.190/D:/dzgw/";

	// 类名
	private static final String CLASS_NAME = HDFSClientService.class.getName();
	
	/**
	 * 文件系统类
	 */
	private FileSystem fileSystem;
	 
	/**
	 * 无参数构造方法
	 */
	public HDFSClientService(String path) {
	   init(path);
	}
	 
	/**
	 * 初始化
	 * @param path 
	 */
	private void init(String path) {
	   fileSystem = HDFSClientServer.getFileSystem(path);
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
	
	/**
	 * 根据文件路径获取文件
	 * 
	 * @param out
	 *            输出流
	 * @param path
	 *            文件存储路径
	 */
	public void readFile(OutputStream out, String path) {
		String newPath = path.substring(path.indexOf("dzgw") + 5);
		try {
			// 获取配置对象
			//Configuration conf = new Configuration();
			// 实例化文件系统
			//FileSystem hdfs = FileSystem.get(URI.create(path), conf);
			// 获取输入流
			InputStream in = fileSystem.open(new Path(path));
			// 将输入流的内容通过IOUtils的copyBytes方法复制到输出流
			IOUtils.copyBytes(in, out, 1024, true);
		} catch (IOException e) {
			logger.error("read failure.", e);
		}
	}

	/**
	 * 根据文件路径获取文件输入流
	 * 
	 * @param path
	 */
	public InputStream readFile(String path) {
		String newPath = path.substring(path.indexOf("dzgw") + 5);
		InputStream in = null;
		try {
			// 获取配置对象
//			Configuration conf = new Configuration();
			// 实例化文件系统
//			FileSystem hdfs = FileSystem.get(URI.create(path), conf);
			// 获取输入流
			Path hdfsPath = new Path(path);

			if(fileSystem.exists(hdfsPath)){
				in = fileSystem.open(new Path(path));
			}else{
//				取附件名
				String attachName = path.substring(path.lastIndexOf("/") + 1, path.lastIndexOf("."));
				String attachPath = path.substring(0, path.lastIndexOf("/") + 1);
				String attachType = path.substring(path.lastIndexOf("."), path.length());
				
//				拼凑路径，并换附件名称为小写，解决迁移后附件名称为大写找不到问题
				path = attachPath + attachName.toLowerCase() + attachType;
				
				// 获取输入流
				hdfsPath = new Path(path);
				if(fileSystem.exists(hdfsPath)){
					in = fileSystem.open(new Path(path));
				}else{
					logger.error("读取文件错误信息：[在hadoop获取不到此附件！]");
				}
//				判断是否大写
				/*if(isAcronym(attachId)){
					attachId = attachId.toLowerCase();
				}else{
					
				}*/
			}
			
		} catch (Exception e) {
			logger.error("read failure.", e);
		}
		return in;
	}

	/**
	 * 根据文件Object获取文件输出流
	 * 
	 * @param path
	 */
	public void readFileOutputStream(OutputStream out, String path) {
		String newPath = path.substring(path.indexOf("dzgw") + 5);
		try {
			// 获取配置对象
//			Configuration conf = new Configuration();
			// 实例化文件系统
//			FileSystem hdfs = FileSystem.get(URI.create(path), conf);
			// 获取输入流
			InputStream in = fileSystem.open(new Path(path));
			// 将输入流的内容通过IOUtils的copyBytes方法复制到输出流
			IOUtils.copyBytes(in, out, 1024, true);
		} catch (IOException e) {
			logger.error("read failure.", e);

		}
	}

	/**
	 * 根据目录路径获取文件集合
	 * 
	 * @param dir
	 */
	public File[] readFiles(String dir) {
		return null;
	}

	/**
	 * 写文件到存储介质
	 * 
	 * @param in
	 *            输入流
	 * @param path
	 *            文件存储路径
	 */
	public void writeFile(InputStream in, String path) {
		// String newPath =
		// path.substring(path.indexOf("dzgw")+5,path.lastIndexOf("/"));
		// String fileName = path.substring(path.lastIndexOf("/")+1);
		try {
			// 获取配置对象
//			Configuration conf = new Configuration();
			// 实例化文件系统
//			FileSystem hdfs = FileSystem.get(URI.create(path), conf);
			// 获取输出流
			OutputStream out = fileSystem.create(new Path(path), new Progressable() {
				@Override
				public void progress() {
					logger.debug("write success.");
				}
			});
			// 将输入流的内容通过IOUtils的copyBytes方法复制到输出流
			IOUtils.copyBytes(in, out, 1024, true);
			IOUtils.closeStream(out);
		} catch (IOException e) {
			logger.error("write failure.", e);

			// 记录异常
			String methodName = new Throwable().getStackTrace()[0].getMethodName();
			String[] args = new String[] { in.toString(), path };
		}
	}

	/**
	 * 根据文件路径删除文件
	 * 
	 * @param path
	 *            文件存储路径
	 */
	public boolean deleteFile(String path) {
		try {

			// 获取配置对象
//			Configuration conf = new Configuration();

			// 实例化文件系统
//			FileSystem hdfs = FileSystem.get(URI.create(path), conf);

			// 删除文件
			return fileSystem.delete(new Path(path), true);

		} catch (IOException e) {
			logger.error("delete failure.", e);
		}

		return false;
	}

	/**
	 * 上传本地文件到HDFS（注意是服务器本地硬盘，非客户端硬盘)）
	 * 
	 * @param localFileSrc
	 *            本地文件绝对路径
	 * @param HDFSFileDst
	 *            HDFS文件路径
	 * @return HDFS文件路径
	 */
	public String uploadLocalFile(String localFileSrc, String HDFSFileDst) {
		try {
			// 获取配置对象
//			Configuration conf = new Configuration();

			// 实例化文件系统
//			FileSystem hdfs = FileSystem.get(URI.create(HDFSFileDst), conf);
			Path src = new Path(localFileSrc);
			Path dst = new Path(HDFSFileDst);
			fileSystem.copyFromLocalFile(src, dst);
			return HDFSFileDst;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static boolean isAcronym(String word) {
		for(int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (!Character.isLowerCase(c)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean fileExists(String path){
		Path hdfsPath = new Path(path);
		boolean flag = false;
		
		try {
			flag = fileSystem.exists(hdfsPath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return flag;
	}

    public static void main(String[] args){
        String HPATH = "hdfs://192.168.0.100:8020";//DHFS文件存储服务URL
        HDFSClientService hdfsClientService = new HDFSClientService(HPATH);
        String filePath = "E:\\abcd.doc";
        File file = new File(filePath);
        System.out.println("WRITE HDFS PATH -==>"+HPATH+"/dzgw/"+ file.getName());
        hdfsClientService.writeFile(hdfsClientService.getInputStream(file), "/dzgw/" + file.getName());
        System.out.println("write2HDFS.end");
    }

    private InputStream getInputStream(File file){
//        String filePath = "E:\\abcd.doc";
//        File file = new File(filePath);
        InputStream input = null;
        try {
            input = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return input;
    }

}
