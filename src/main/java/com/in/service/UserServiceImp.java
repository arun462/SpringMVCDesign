package com.in.service;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.in.dao.UserDao;
import com.in.model.Notification;
import com.in.model.User;
import com.in.model.UserOtpDTO;


@Service
@Transactional("txManager")

public class UserServiceImp  implements UserService{

	
	
	@Autowired
	UserDao userDao;
	public void Signup(User user) {
	
		userDao.Signup(user);
		
	}
	@Override
	public User validateUser(User user) {
		return	userDao.validateUser(user);
		 
	}
	@Override
	public <userList> List<User> getProfile(String key) {
		
		return userDao.getProfile(key);
	}
	@Override
	public Notification getNotificatios(int id) {

		return  userDao.getNotificatios(id);
	}
	@Override
	public String validatingOTP(User user) {
		
		return userDao.validatingOTP(user);
	}
	@Override
	public String reVerifictaionMail(User user) {
		
		return userDao.reVerifictaionMail(user);
	}

}
