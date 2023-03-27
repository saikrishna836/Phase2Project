package com.webapp.AdminHomepage;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PlacesServlet")
public class PlacesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> ls=new ArrayList<String>();
		ls.add("Hyderabad");
		ls.add("Bangalore");
		ls.add("Chennai");
		ls.add("Delhi");
		ls.add("Kolkata");
		ls.add("Mumbai");
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<html>");
		out.println("</body>");
		out.println("<h2>List of Places</h2>");
		for(String s:ls) {
			out.println("<h4>");
			out.println("*"+s);
			out.println("</h4>");
		}
		out.println("Back to home:<a href='AdminHomePage.html'>Click Here</a>");
		out.println("</body>");
		out.println("</html>");
	}

	}



