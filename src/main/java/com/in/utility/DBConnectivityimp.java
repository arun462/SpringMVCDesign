package com.in.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBConnectivityimp implements DBConnectivity {

	@Autowired
	SessionFactory sessionFactory;
	
	public Session getsession() {
		
		Session session=sessionFactory.getCurrentSession();
		
		 return session;
	}
	

}

