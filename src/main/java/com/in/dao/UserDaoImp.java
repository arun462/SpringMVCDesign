package com.in.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.in.model.Notification;
import com.in.model.User;
import com.in.model.UserDto;
import com.in.model.UserOtpDTO;
import com.in.utility.DBConnectivity;

@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	DBConnectivity connection;

	public void Signup(User user) {

		Session session = connection.getsession();
		session.save(user);
		
	

	}

	@Override
	public User validateUser(User user) {
		Session session = connection.getsession();
		Criteria criteria = session.createCriteria(User.class);
		Criterion criterion = Restrictions.eq("username", user.getUsername());
		Criterion criterion1 = Restrictions.eq("password", user.getPassword());
		criteria.add(criterion).add(criterion1);
		List<User> userList = criteria.list();
		User validUser = null;
		if (userList.size() > 0) {
			validUser = new User();
			validUser = userList.get(0);
		}

		return validUser;

	}

	@SuppressWarnings("unchecked")
	@Override
	public <userList> List<User> getProfile(String key) {

		Session session = connection.getsession();
		Criteria criteria = session.createCriteria(User.class);
		Criterion criterion = Restrictions.eq("username", key);
		criteria.add(criterion);
		List<User> userList = criteria.list();
		System.out.println("the userlist are" + " " + userList);

		return userList;
	}

	@Override
	public Notification getNotificatios(int id) {
		List<Notification> notifications = connection.getsession().createCriteria(Notification.class)
				.add(Restrictions.eq("id", id)).list();
		if (notifications.size() > 0) {

			return notifications.get(0);
		}
		return null;
	}

	@Override
	public String validatingOTP(User user) {
		Session session=connection.getsession();
		Criteria criteria=session.createCriteria(User.class);
		Criterion criterion=Restrictions.eq("otp", user.getOtp());
		criteria.add(criterion);
		@SuppressWarnings("unchecked")
		List<User>userlist=criteria.list();
		@SuppressWarnings("unused")
		User vlaidOtpUser=null;
		if(userlist.size()>0){
			vlaidOtpUser= new User();
			vlaidOtpUser=userlist.get(0);
			vlaidOtpUser.getActivationSession();
		}
		
		return vlaidOtpUser.getActivationSession();
	}

	
	public String reVerifictaionMail(User user) {
	
		Session session=connection.getsession();
		Criteria criteria=session.createCriteria(User.class);
		Criterion criterion=Restrictions.eq("useremail", user.getUseremail());
		criteria.add(criterion);
		List<User>userlist=criteria.list();
		User mailValidUser=null;
		if(userlist.size()>0){
			mailValidUser=new User();
			mailValidUser=userlist.get(0);
			mailValidUser.getUseremail();
		}
		return mailValidUser.getUseremail();
	}
	
}
