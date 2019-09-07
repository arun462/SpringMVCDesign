package com.in.utility;

import com.in.model.User;

public interface MailandSMSUitility {
	
	public void sendMailandSMS(User user,Integer status,String OTP);

}
