package com.lefthand.comm.rtx;

import com.lefthand.comm.utils.HttpCall;

import java.io.UnsupportedEncodingException;

public class SendNotify_Cgi {

	/**
	 * 
	 * @param URL      rtx提醒CGI服务地址
	 * @param receiver 接收人，用户昵称，多个接收者以“,”隔开
	 * @param sender   发送人
	 * @param content  提醒内容
	 * @param title    提醒标题
	 * @param delaytime 0 消息提醒框的停留时间（毫秒），0表示不自动消失。
	 * @return
	 */
	public static String sendNotify(SendNotify_CgiDomain scd){

		if(scd.getURL() == null || "".equals(scd.getURL()) ){
			scd.setURL("http://10.0.8.17:8012/SendNotify.cgi?");
		}		
        
        StringBuffer sendMsgParams = new StringBuffer();

        sendMsgParams.append("&receiver=" + scd.getReceiver());	// 接收人，RTX帐号
        if (scd.getContent() != null && !scd.getContent().equals("")){
        	String contentEncoder = "";
            try {
    			contentEncoder = java.net.URLEncoder.encode(scd.getContent(),"GBK"); // 内容要URL编码
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		};
            sendMsgParams.append("&msg=" + contentEncoder);
        }

        if (scd.getSender() != null && !scd.getSender().equals("")) {
            sendMsgParams.append("&sender=" + scd.getSender());
        }
        
        if (scd.getTitle() != null && !scd.getTitle().equals("")) {
        	try {
        		scd.setTitle(java.net.URLEncoder.encode(scd.getTitle(),"GBK"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            sendMsgParams.append("&title=" + scd.getTitle());
        }
        
        if (scd.getDelaytime() != null && !scd.getDelaytime().equals("")) {
            sendMsgParams.append("&delaytime=" + scd.getDelaytime());
        }
        /*
         参数表： 
		变量名称 默认值 说明 
		receiver 　 接收者，用户昵称，多个接收者以“,”隔开。 
		msg 　 消息内容 
		title 空 消息提醒的标题。 
		delaytime 0 消息提醒框的停留时间（毫秒），0表示不自动消失。
		okurl    成功后IE自动定位到指定的url ,格式类似为：okurl=rtx.tencent.com 或者okurl=http://tx.tencent.com 注意：这里的url必须为绝对地址。 
		errurl   失败后IE自动定位到指定的url。
         */
        String jiegue = HttpCall.sendPost(scd.getURL(), sendMsgParams.toString());
        //System.out.println("ok " + jiegue + " - " + sendMsgParams);
        return jiegue;
	}
}
