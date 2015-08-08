package com.lefthand.comm.mail;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.*;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component("sendEmail") //getBean时的默认名称是类名（头字母小写），如果想自定义，可以@Component("xxx")
public class SendEmail {

	public void setSender(JavaMailSender sender) {
		this.sender = sender;
	}

	public void setFromAddr(String fromAddr) {
		this.fromAddr = fromAddr;
	}

	@Autowired 
	private JavaMailSender sender;
	
	//@Value("${mail.fromAddr}")
	private String fromAddr = "68710000@haikou.gov.cn";
	
	//发邮件一定要把mail.jar加入lib中，不要使用myeclipse自带的，会造成很多问题。要是放到lib不行，可通用修改myeclipse类加载包的路径里的mail.jar文件，把它替换掉
	public void sendEmail(SendMailDomain smd){
		
		if(smd.getToAddrs() == null || smd.getToAddrs().length == 0){
			throw new RuntimeException("收件人不能为空！");
		}
		
		MimeMessageHelper helper;
		try {
			MimeMessage msg = sender.createMimeMessage(); 
			helper = new MimeMessageHelper(msg, true, "UTF-8"); 
			if(smd.getFromAddr() == null || "".equals(smd.getFromAddr())){
				helper.setFrom(this.fromAddr);
			}else{
				helper.setFrom(smd.getFromAddr());
			}
			helper.setTo(smd.getToAddrs()); 
			helper.setSubject(smd.getTitle()); 
			String htmlText = smd.getContent();			
			
			helper.setText(htmlText,true); //第二个参数为true，表示是HTML邮件
			
			//处理显示嵌入文本中的图片
			if(smd.getContentImage() != null && smd.getContentImage().size() > 0){
				for (Map.Entry<String, String> entry : smd.getContentImage().entrySet()) {
					String key = entry.getKey();
					System.out.println("key:" + key + " file:" + smd.getContentImage().get(key));
					helper.addInline("cid:" + key, new File(smd.getContentImage().get(key))); 
				}
			}
			
			//处理上传附件
			if(smd.getArrfile() != null && smd.getArrfile().size() > 0){
				for (Map.Entry<String, String> entry : smd.getArrfile().entrySet()) {
					String key = entry.getKey();					
					try {
						//System.out.println("key:" + MimeUtility.encodeWord(key) + " file:" + smd.getArrfile().get(key));
						helper.addAttachment(MimeUtility.encodeWord(key), new File(smd.getArrfile().get(key)));
						//MimeUtility.encodeWord(key)是为了解决附件的乱码问题
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			}
			
			//处理上传附件二进制内容
			if(smd.getArrfilebyte() != null && smd.getArrfilebyte().size() > 0){
				for (Map.Entry<String, byte[]> entry : smd.getArrfilebyte().entrySet()) {
					String key = entry.getKey();					
					try {
						//System.out.println("key:" + MimeUtility.encodeWord(key) + " file:" + smd.getArrfile().get(key));
						helper.addAttachment(MimeUtility.encodeWord(key), new ByteArrayResource(smd.getArrfilebyte().get(key)));
						//MimeUtility.encodeWord(key)是为了解决附件的乱码问题
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				}
			}

			sender.send(msg); 
			
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
}
