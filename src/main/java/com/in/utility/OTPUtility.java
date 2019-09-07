package com.in.utility;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class OTPUtility {

	public String GetOTP(){
		String RandomString="123456789";
		
		Random rd= new Random();
		char[] chrOtp= new char[4];
		for(int i=0;i<=3;i++){
			chrOtp[i]=  RandomString.charAt(rd.nextInt(8));
		}
		
		String OTP= new String(chrOtp);
		return OTP;
	}
	
}
