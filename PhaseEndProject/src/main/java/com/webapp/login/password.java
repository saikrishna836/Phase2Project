package com.webapp.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.NamedNativeQuery;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.query.NativeQuery;

import com.hibernatehelloworld.domain.Admin;
import com.hibernatehelloworld.utils.HibernateUtils;



@WebServlet("/password")
public class password extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String old_password=request.getParameter("old_password");
		String new_password=request.getParameter("new_password");
		String r_new_password=request.getParameter("r_new_password");
		Session session=HibernateUtils.getSessionFactory().openSession();
		try {
		
		session.beginTransaction();
		String qry="from Admin";
		Query query=session.createQuery(qry);
		List<Admin> ls=query.getResultList();
		for(Admin a: ls){
			if(a.password.equals(request.getParameter("old_password"))) {
				String email=a.email;
				if(new_password.equals(r_new_password)) {
				String qry1="update Admin set password=:new_password where email=:email";
				
				Query q=session.createQuery(qry1);
				q.setParameter("new_password",new_password);
				q.setParameter("email",email);
				q.executeUpdate();
				session.getTransaction().commit();
				session.close();
				out.println("Successfully changed password");
				RequestDispatcher rd=request.getRequestDispatcher("Admin.html");
				rd.include(request, response);
				}else {
					session.getTransaction().commit();
					session.close();
					out.println("The new passwords entered are not same");
					RequestDispatcher rd=request.getRequestDispatcher("password.html");
					rd.include(request, response);
				}
				
			}
			else {
				session.getTransaction().commit();
				session.close();
				out.println("Incorrect old password");
				RequestDispatcher rd=request.getRequestDispatcher("password.html");
				rd.include(request, response);
			}
		}
		
		
	}catch(Exception e) {
		session.getTransaction().commit();
		session.close();
		out.println("Incorrect values");
		RequestDispatcher rd=request.getRequestDispatcher("password.html");
		rd.include(request, response);
	}
	}
}
