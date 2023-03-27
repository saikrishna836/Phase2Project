package com.webapp.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import com.hibernatehelloworld.HUserLogin;
import com.hibernatehelloworld.domain.Admin;
import com.hibernatehelloworld.domain.User;
import com.hibernatehelloworld.utils.HibernateUtils;

@WebServlet("/adminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String email = request.getParameter("emailId");
	String password = request.getParameter("password");
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	try {
	if(isValidInput(email ,false)&&isValidInput(password,false)) {
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		String query="from Admin where email=:email and password=:password";
		Query q=session.createQuery(query);
		q.setParameter("email", email);
		q.setParameter("password", password);
		List<Admin> rs=q.getResultList();
		session.getTransaction().commit();
		session.close();
		
	if(!rs.isEmpty()) {
		RequestDispatcher rd=request.getRequestDispatcher("AdminHomePage.html");
		rd.forward(request, response);
	}
	else {
		out.println("Invalid Input");
		RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
		rd.include(request, response);
	}
	}else {
		out.println("Invalid Input");
	}
	}catch(Exception e) {
		out.println("Entered wrong values");
		RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
		rd.include(request, response);
	}
	}
	

	private boolean isValidInput(String value,boolean b) {
		if(value == null || value.length() == 0 || value.equals(" ")) {
			 return false;
			}
		else {
			return true;
		}
	}


}
