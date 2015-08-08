/*
 * 创建日期 2009-11-26
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.lefthand.comm.tag;

import java.io.*;

import sun.misc.BASE64Encoder;

/**
 * @author Administrator
 *
 * TODO 要更改此生成的类型注释的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public class EncodeDataImpl implements IencodeData {


	public String encode2HtmlUnicode(String str) {
	     
		if(str == null) return "";		 
		StringBuffer sb = new StringBuffer();
		//System.out.println("-----------:" + str.length() * 2);
		for (int i = 0; i < str.length(); i++) {
			sb.append(encode2HtmlUnicode(str.charAt(i)));
		}
		//System.out.println("-----------:" + sb.toString().length());
		return sb.toString();
	}
	
	public String encode2HtmlUnicode(char character) {
		if (character > 255) {//不在ascii范围内
			return "&#" + (character & 0xffff) + ";";
		} else {
			return String.valueOf(character);
		}
	}
	
	
	private static BASE64Encoder base64Encoder = new BASE64Encoder();
	
	/**
	 * 把给定的二进制流变成base64码
	 * @param in
	 * @return
	 * @throws java.io.IOException
	 */
	/*public String base64Encode(InputStream in) throws IOException {
		byte[] img = new byte[in.available()];
		in.read(img);
		return base64Encode(img);
	}
	
	public String base64Encode(String in) throws IOException {
		return base64Encode(in.getBytes());
	}*/
	
	public String base64Encode(byte[] in) throws IOException {
		//System.out.println("byte[] in:" + in);
		//System.out.println("byte[] in2:" + base64Encoder.encode(in));
		return base64Encoder.encode(in);
	}

}
