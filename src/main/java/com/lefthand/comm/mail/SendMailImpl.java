package com.lefthand.comm.mail;

import javax.jws.WebService;

/*import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
*/
import org.springframework.beans.factory.annotation.Autowired;



//定义Web Service接口的实现类，Web Service的名字
//注意类的@WebService注解有endpointInterface属性是接口路径,写错了就产生此错误
//javax.xml.ws.WebServiceException: javax.xml.ws.WebServiceException: Could not load Webservice SEI。
@WebService(endpointInterface = "com.gw.common.mail.ISendMail"
	,serviceName = "SendMail")
//@Path("mail")
public class SendMailImpl implements ISendMail {

	@Autowired
	private SendEmail semail;

	@Override
	public void sendEmail(SendMailDomain smd) {
		semail.sendEmail(smd);
	}
		
	//@POST
	//@Path("/send")
	public String sendEmailRest(//String fromAddr,//发信人地址
			/*@FormParam("toAddrs")*/ String toAddrs,	//收信人地址,以逗号分隔
			/*@FormParam("title")*/ String title,		//邮件标题
			/*@FormParam("content")*/ String content,    	//邮件正文
			/*@FormParam("arrfile")*/ String arrfile,	//邮件要上传的附件,key是文件名(要包括扩展名),value是文件路径
			/*@FormParam("arrfilebyte")*/ String arrfilebyte	//邮件要上传的附件,key是文件名(要包括扩展名),value是文件的字节数组内容
								) {
		
		SendMailDomain smd = new SendMailDomain();
		smd.setFromAddr("");
		smd.setTitle(title);
		smd.setContent(content);
		smd.setToAddrs(toAddrs.split(","));
		if(!"".equals(arrfile) && !"".equals(arrfilebyte)){
			java.util.HashMap hm = new java.util.HashMap<String, byte[]>();
//				hm.put(arrfile, Base64.decode(arrfilebyte));
				hm.put(arrfile,org.apache.commons.codec.binary.Base64.decodeBase64(arrfilebyte));
			smd.setArrfilebyte(hm);
		}
		semail.sendEmail(smd);
		return "success";
	}
	/*
	@GET
	@Path("/test/{toAddrs}/{title}")
	public String sendEmailRest2(//String fromAddr,//发信人地址
			@PathParam("toAddrs") String toAddrs,	//收信人地址,以逗号分隔
			@PathParam("title") String title,		//邮件标题
			@PathParam("content") String content,    	//邮件正文
			@PathParam("arrfile") String arrfile,	//邮件要上传的附件,key是文件名(要包括扩展名),value是文件路径
			@PathParam("arrfilebyte") String arrfilebyte	//邮件要上传的附件,key是文件名(要包括扩展名),value是文件的字节数组内容
								) {
		
		System.out.println("toAddrs:" + toAddrs);
		System.out.println("title:" + title);
		System.out.println("content:" + content);
		System.out.println("arrfile:" + arrfile);
		System.out.println("arrfilebyte:" + arrfilebyte);
		
		java.util.List<String> l = new java.util.ArrayList<String>();
		l.add("你好");
		l.add("你好1");
		l.add("你好2");
		return "你好test";
	}
	
	@GET
	@Path("/test2")
	public String sendEmailRest3(//String fromAddr,//发信人地址
			@QueryParam("toAddrs") String toAddrs,	//收信人地址,以逗号分隔
			@QueryParam("title") String title,		//邮件标题
			@QueryParam("content") String content,    	//邮件正文
			@QueryParam("arrfile") String arrfile,	//邮件要上传的附件,key是文件名(要包括扩展名),value是文件路径
			@QueryParam("arrfilebyte") String arrfilebyte	//邮件要上传的附件,key是文件名(要包括扩展名),value是文件的字节数组内容
								) {
		
		System.out.println("toAddrs:" + toAddrs);
		System.out.println("title:" + title);
		System.out.println("content:" + content);
		System.out.println("arrfile:" + arrfile);
		System.out.println("arrfilebyte:" + arrfilebyte);
		
		java.util.List<String> l = new java.util.ArrayList<String>();
		l.add("你好");
		l.add("你好1");
		l.add("你好2");
		return "你好test";
	}*/
}
