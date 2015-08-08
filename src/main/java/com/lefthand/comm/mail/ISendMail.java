package com.lefthand.comm.mail;

import javax.jws.WebService;

//以@WebService Annotation标注，表明该接口将对应一个Web Services
@WebService
public interface ISendMail {

	public void sendEmail(SendMailDomain smd);
	
}
