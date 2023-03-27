package com.hibernatehelloworld;

import java.util.List;

import org.hibernate.Session;

import com.hibernatehelloworld.domain.User;
import com.hibernatehelloworld.utils.HibernateUtils;
public class HUserLogin {
public static void main(String args[]) {
	String email = null;
	getUser(email);
}



public static User getUser(String email) {
	Session session=HibernateUtils.getSessionFactory().openSession();
	session.beginTransaction();
	User user=null;
	user.getEmail();
	user=session.get(User.class,email);
	session.getTransaction().commit();
	session.close();
	return user;
}
}
