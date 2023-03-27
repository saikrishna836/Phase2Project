package com.webapp.login;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Hibernate;
import org.hibernate.Session;

import com.hibernatehelloworld.domain.User;
import com.hibernatehelloworld.utils.HibernateUtils;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("emailId");
		String password = request.getParameter("password");
		Session session=HibernateUtils.getSessionFactory().openSession();
		session.beginTransaction();
		
		try {
			
			
			
		User user=new User();
		user.setEmail(email);
		System.out.println("Hii");
		user.setFirstname(firstname);
		user.setLastname(lastname);
		user.setPassword(password);
		String query="from User where email=:email";
		Query q=session.createQuery(query);
		q.setParameter("email", email);
		List<User> list=q.getResultList();
		if(list.isEmpty()) {
		session.save(user);
		session.getTransaction().commit();
		session.close();
		out.println("Registered Successfully");
		RequestDispatcher rd=request.getRequestDispatcher("User.html");
		rd.include(request, response);
		}
		else {
			session.getTransaction().commit();
			session.close();
			out.println("Mail Already Exists or Invalid Input");
			RequestDispatcher rd=request.getRequestDispatcher("Register.html");
			rd.include(request, response);
		}
		
		}
		catch(Exception e) {
			session.getTransaction().commit();
			session.close();
			out.println("<html><body><h1>Invalid Input</h1><br>Back to Home <a href='User.html'>click here</a></p><center></body></html>");
			
			
		}
		
		}

}
