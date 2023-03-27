package com.webapp.flights;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.util.List;

import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import com.hibernatehelloworld.domain.Flight;
import com.hibernatehelloworld.utils.HibernateUtils;


@WebServlet("/FlightsServlet")
public class FlightsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	PrintWriter out=response.getWriter();
    	String destination=request.getParameter("destination");
    	String source=request.getParameter("source");
    
    	Session session=HibernateUtils.getSessionFactory().openSession();
    	session.beginTransaction();
    	
    	String query="from Flight where source='"+source+"' and destination='"+destination+"'";
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
    		out.println("<center><h1>Please Select The Flight</h1><center>");
        	out.println("<body><form action='Payment'><center><table><tr><th>Air Lines</th><th>Date<th>Time</th><th>Source</th><th>Destination</th><th>Ticket Price</th></tr>");
    			for(Flight f:result) {
    				
    				out.print("<tr><td>"+f.getAirlines()+"</td><td>"+f.getDate()+"</td><td>"+f.getTime()+"</td><td>"+f.getSource()+"</td><td>"+f.getDestination()+"</td><td>"+f.getTicketprice()+"</td><td>"+"<input type='submit' value='Book Flight'></td></tr>");
    				
    			}
    			out.println("</table></center>");
    			out.println("</form></body>");
    	    	out.println("</html>");
    			
    			session.getTransaction().commit();
    	    	session.close();
    		
    	}
    	else {
    		session.getTransaction().commit();
        	session.close();
    		out.println("<html><center><p>Sorry No Flights are Available<br>");
    		out.println("Back to Home <a href='UserHomepage.html'>click here</a></p><center></html>");
    		
    		
    		
    		
    	}
    	
    	
	}
	

}
