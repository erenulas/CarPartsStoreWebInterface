package carpartsstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carpartsstore.bean.Customer;
import carpartsstore.connection.ConnectionUtil;
import carpartsstore.util.DBUtil;

public class CreateOrderServlet extends HttpServlet{
	   private static final long serialVersionUID = 1L;
	   
	   public CreateOrderServlet(){
		   
	   }
	   
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
		         throws IOException, ServletException {
		      // Set the MIME type for the response message
		      response.setContentType("text/html");
		      // Write to network
		      PrintWriter out = response.getWriter();
		      int customer_id = Integer.parseInt(request.getParameter("id"));

		      try {
						DBUtil.insertNewOrder(ConnectionUtil.getConnection(), customer_id);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		      
		   }
		 
		   // Runs as a thread whenever there is HTTP POST request
		   public void doPost(HttpServletRequest request, HttpServletResponse response)
		         throws IOException, ServletException {
		      // do the same thing as HTTP GET request
		      doGet(request, response);
		   } 
}
