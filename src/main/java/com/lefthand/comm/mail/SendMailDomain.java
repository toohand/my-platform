package com.lefthand.comm.mail;

import java.util.Map;

public class SendMailDomain {

	private String fromAddr = "";		//发信人地址
	private String toAddrs[] = null;	//收信人地址
	private String title = "";		//邮件标题
	private String content = "";    	//邮件正文
	private Map<String,String> arrfile = null;	//邮件要上传的附件,key是文件名(要包括扩展名),value是文件路径
	private Map<String,byte[]> arrfilebyte = null;	//邮件要上传的附件,key是文件名(要包括扩展名),value是文件的字节数组内容
	private Map<String,String> contentImage = null;	//邮件要显示的图片,key是代码,value是文件路径,但这个功能现在的邮箱都不支持    
    
	public String getFromAddr() {
		return fromAddr;
	}
	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}
	public String[] getToAddrs() {
		return toAddrs;
	}
	public void setToAddrs(String[] toAddrs) {
		this.toAddrs = toAddrs;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Map<String, String> getArrfile() {
		return arrfile;
	}
	public void setArrfile(Map<String, String> arrfile) {
		this.arrfile = arrfile;
	}
	public Map<String, String> getContentImage() {
		return contentImage;
	}
	public void setContentImage(Map<String, String> contentImage) {
		this.contentImage = contentImage;
	}
	public Map<String, byte[]> getArrfilebyte() {
		return arrfilebyte;
	}
	public void setArrfilebyte(Map<String, byte[]> arrfilebyte) {
		this.arrfilebyte = arrfilebyte;
	}

}
