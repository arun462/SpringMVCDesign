package com.in.utility;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.in.model.Notification;
import com.in.model.User;
import com.in.service.UserService;

@Component
public class MailandSMSUitlityImp implements MailandSMSUitility {
	
	@Autowired
	MailUitlity mailUitlity;
	@Autowired
	UserService userService;

	@Override
	@Async
	public void sendMailandSMS(User user,Integer notificationId,String OTP) {
	Notification notification=	userService.getNotificatios(notificationId);
		
	String body=	notification.getSubject();
	String [] bodyArray=body.split("~");
		
		for(int i=0;i<bodyArray.length;i++){
			if(bodyArray[i].equals("1")){
				bodyArray[i]=user.getUsername();
				
			}
			if(bodyArray[i].equals("2")){
				
				bodyArray[i]=OTP;
			}
			
		}
		String messageBody =	String.join(" ", bodyArray);
		String messageSubject=notification.getBody();
		mailUitlity.SendMail(user.getUseremail(), messageSubject,messageBody);	 
		
	}
}