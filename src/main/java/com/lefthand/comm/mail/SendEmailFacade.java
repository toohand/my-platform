package com.lefthand.comm.mail;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 发送邮件门面类,为方便调用发邮件功能
 * @author lyu
 */
public class SendEmailFacade {

	public static void sendEmail(SendMailDomain smd){
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-context.xml");
		SendEmail semail = ctx.getBean("sendEmail", SendEmail.class);
			
		semail.sendEmail(smd);
	}
}
