package com.webapp.AdminHomepage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.hibernatehelloworld.domain.Flight;
import com.hibernatehelloworld.utils.HibernateUtils;

@WebServlet("/FlightListsServlet")
public class FlightListsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
    	Session session=HibernateUtils.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	String query="from Flight";
    	Query q=session.createQuery(query);
    	List<Flight> result=q.getResultList();
    	
    	
    	out.println("<html>");
    	out.println("<head><title>FlyAway-Flight Booking</title><style>table, th, td {\r\n"
    			+ "  border: 1px solid white;\r\n"
    			+ "  border-collapse: collapse;\r\n"
    			+ "}\r\n"
    			+ "th, td {\r\n"
    			+ "  background-color: #96D4D4;\r\n"
    			+ "}</style></head>");
    	if(!result.isEmpty()) {
    		out.println("<center><h1>Master List of Flights</h1><center>");
        	out.println("<body><form action='PaymentServlet'><center><table><tr><th>Air Lines</th><th>Date<th>Time</th><th>Source</th><th>Destination</th><th>Ticket Price</th></tr>");
    			for(Flight f:result) {
    				
    				out.print("<tr><td>"+f.getAirlines()+"</td><td>"+f.getDate()+"</td><td>"+f.getTime()+"</td><td>"+f.getSource()+"</td><td>"+f.getDestination()+"</td><td>"+f.getTicketprice()+"</td></tr>");
    				
    			}
    			out.println("</table></center>");
    			out.println("</form></body>");
    			out.println("Back to home:<a href='AdminHomePage.html'>Click Here</a>");
    	    	out.println("</html>");
    			
    			session.getTransaction().commit();
    	    	session.close();
    		
    	}
    	else {
    		session.getTransaction().commit();
        	session.close();
    		out.println("<html><center><p>Sorry No Flights are Available<br>");
	}
	}
}
