package com.lefthand.comm.hdfs;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URI;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IOUtils;
import org.apache.hadoop.util.Progressable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Hadoop文件读写服务
 */
public class FileService {

	private static Logger logger = LoggerFactory.getLogger(FileService.class);

	// fttp资源地址
//	private static final String FTTP_URI = "fttp://10.0.8.190/D:/dzgw/";

	// 类名
	private static final String CLASS_NAME = FileService.class.getName();

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
			Configuration conf = new Configuration();
			// 实例化文件系统
			FileSystem hdfs = FileSystem.get(URI.create(path), conf);
			// 获取输入流
			InputStream in = hdfs.open(new Path(path));
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
			Configuration conf = new Configuration();
			// 实例化文件系统
			FileSystem hdfs = FileSystem.get(URI.create(path), conf);
			// 获取输入流
			in = hdfs.open(new Path(path));
		} catch (Exception e) {
			logger.error("read failure.", e);
		}
		return in;
	}

	/**
	 * 根据文件路径获取文件输出流
	 * 
	 * @param path
	 */
	public void readFileOutputStream(OutputStream out, String path) {
		String newPath = path.substring(path.indexOf("dzgw") + 5);
		try {
			// 获取配置对象
			Configuration conf = new Configuration();
			// 实例化文件系统
			FileSystem hdfs = FileSystem.get(URI.create(path), conf);
			// 获取输入流
			InputStream in = hdfs.open(new Path(path));
			// 将输入流的内容通过IOUtils的copyBytes方法复制到输出流
			IOUtils.copyBytes(in, out, 1024, true);
		} catch (IOException e) {
			logger.error("read failure.", e);
			}
//		}
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
			Configuration conf = new Configuration();
			// 实例化文件系统
			FileSystem hdfs = FileSystem.get(URI.create(path), conf);
			// 获取输出流
			OutputStream out = hdfs.create(new Path(path), new Progressable() {
				@Override
				public void progress() {
					logger.debug("write success.");
				}
			});
			// 将输入流的内容通过IOUtils的copyBytes方法复制到输出流
			IOUtils.copyBytes(in, out, 1024, true);
		} catch (IOException e) {
			logger.error("write failure.", e);
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
			Configuration conf = new Configuration();

			// 实例化文件系统
			FileSystem hdfs = FileSystem.get(URI.create(path), conf);

			// 删除文件
			return hdfs.delete(new Path(path), true);

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
			Configuration conf = new Configuration();

			// 实例化文件系统
			FileSystem hdfs = FileSystem.get(URI.create(HDFSFileDst), conf);
			Path src = new Path(localFileSrc);
			Path dst = new Path(HDFSFileDst);
			hdfs.copyFromLocalFile(src, dst);
			return HDFSFileDst;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}

}
