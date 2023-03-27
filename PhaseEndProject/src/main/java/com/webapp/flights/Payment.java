package com.webapp.flights;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		out.println("<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<title>FlyAway-Payment</title>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "	<center><h1>FlyAway PayMent</h1><div>\r\n"
				+ "	<form action=\"Paymentnav\">\r\n"
				+ "	<table>\r\n"
				+ "<tr><td>Select Bank</td><td><select name=\"bank\" id=\"bank\">\r\n"
				+ "  <option value=\"SBI\">SBI</option>\r\n"
				+ "  <option value=\"HDFC\">HDFC</option>\r\n"
				+ "  <option value=\"Corporation Bank\">Corporation Bank</option>\r\n"
				+ "  <option value=\"ICICI\">ICICI</option>\r\n"
				+ "</select></td></tr>\r\n"
				+ "<tr><td>Account No:</td><td><input type=\"text\"/></td></tr>\r\n"
				+ "<tr><td>IFSC code:</td><td><input type=\"text\"/></td></tr>\r\n"
				+ "<tr><td>Amount:</td><td><input type=\"text\" /></td></tr>\r\n"
				+ "<tr><td><input type=\"submit\" value=\"Pay\"/></td></tr>\r\n"
				+ "	</table>\r\n"
				+ "	</form>\r\n"
				+ "	</div></center>\r\n"
				+ "</body>\r\n"
				+ "</html>");
		
	}

}
