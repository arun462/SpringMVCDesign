package com.in.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.utility.OTPUtility;
@Service
public class UserOTPServiceImp  implements UserOTPService{

	@Autowired
	OTPUtility otpUtility;	
	
	@Override
	public String GenerateOTP() {
	
	String OTP=	otpUtility.GetOTP();
		
	
	
		return OTP;
	}

}
