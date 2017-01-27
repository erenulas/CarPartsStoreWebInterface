package carpartsstore.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carpartsstore.bean.Customer;
import carpartsstore.connection.ConnectionUtil;
import carpartsstore.connection.SQLServerConnection;
import carpartsstore.util.DBUtil;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginServlet extends HttpServlet{
	   private static final long serialVersionUID = 1L;
	   
	   public LoginServlet(){
		   
	   }
	   
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
		         throws IOException, ServletException {
		      // Set the MIME type for the response message
		      response.setContentType("text/html");
		      // Write to network
		      PrintWriter out = response.getWriter();
		      int customer_id=0;
		      String email = request.getParameter("email");
		      String password = request.getParameter("password");
		      if(request.getParameter("id") != null)
		    	  customer_id = Integer.parseInt(request.getParameter("id"));
		      Customer customer = null;
		      try {
				if(DBUtil.checkUser(ConnectionUtil.getConnection(), email, password)){
						customer = DBUtil.findUser(ConnectionUtil.getConnection(), email, password);
						request.setAttribute("customer", customer);
					       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/CustomerProfile.jsp");
					       dispatcher.forward(request, response);
				  } else if (DBUtil.checkUserbyId(ConnectionUtil.getConnection(), customer_id)){
					  	customer = DBUtil.findUserbyId(ConnectionUtil.getConnection(), customer_id);
					  	request.setAttribute("customer", customer);
					       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/CustomerProfile.jsp");
					       dispatcher.forward(request, response);
		      	  } else {
				       RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
				        
				       dispatcher.forward(request, response);
				  }
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