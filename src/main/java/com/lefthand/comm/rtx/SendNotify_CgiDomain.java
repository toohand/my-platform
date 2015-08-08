package com.lefthand.comm.rtx;

public class SendNotify_CgiDomain {

	private String URL = "";		//rtx提醒CGI服务地址
	private String receiver = "";	//接收人，用户昵称，多个接收者以“,”隔开
	private String sender = "";		//发送人
	private String content = "";	//提醒内容
	private String title = "";		//提醒标题
	private String delaytime = "";	//0 消息提醒框的停留时间（毫秒），0表示不自动消失。
	
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDelaytime() {
		return delaytime;
	}
	public void setDelaytime(String delaytime) {
		this.delaytime = delaytime;
	}
	
	
}
