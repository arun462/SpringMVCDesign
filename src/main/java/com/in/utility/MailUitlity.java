package com.in.utility;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.springframework.stereotype.Component;

@Component
public class MailUitlity {
	public void SendMail(String  emailTo,String sub,String messBody){
	try {
		String emailUserMail = "arun.kumar.reddy.bora@gmail.com";
		String emailPassword = "Arun@99@#";

		
		  Properties props = new Properties();
	      props.put("mail.smtp.auth", "true");
	      props.put("mail.smtp.starttls.enable", "true");
	      props.put("mail.smtp.host", "smtp.gmail.com");
	      props.put("mail.smtp.port", "587");
	      
		Session session = Session.getInstance(props, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(emailUserMail, emailPassword);
			}

		});

		MimeMessage message = new MimeMessage(session);
		
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(emailTo));
		System.out.println("emailTo :"+emailTo);
		message.setSubject(sub);
		System.out.println("sub :"+sub);
		message.setText(messBody);
		System.out.println("messBody :"+ messBody);
		Transport.send(message);  

	}

	catch (Exception e) {

		e.printStackTrace();
	}
	}
}
