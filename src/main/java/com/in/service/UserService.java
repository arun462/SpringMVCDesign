package com.in.service;

import java.util.List;

import com.in.model.Notification;
import com.in.model.User;
import com.in.model.UserOtpDTO;

public interface UserService {
	
	public void Signup(User user);
	public User validateUser(User user);
	public <userList> List<User> getProfile(String key);
	public Notification getNotificatios(int id);
	public String validatingOTP(User user);
	public String reVerifictaionMail(User user);

}
