/*
 * 创建日期 2009-11-26
 *
 * TODO 要更改此生成的文件的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
package com.lefthand.comm.tag;

import java.io.IOException;

/**
 * @author Administrator
 *
 * TODO 要更改此生成的类型注释的模板，请转至
 * 窗口 － 首选项 － Java － 代码样式 － 代码模板
 */
public interface IencodeData {

	public String encode2HtmlUnicode(String str);
	public String base64Encode(byte[] in) throws IOException;
}
