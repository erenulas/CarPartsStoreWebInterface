package carpartsstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carpartsstore.bean.Customer;
import carpartsstore.bean.CustomerOrder;
import carpartsstore.connection.ConnectionUtil;
import carpartsstore.util.DBUtil;

public class OrderServlet extends HttpServlet{
	   private static final long serialVersionUID = 1L;
	   
	   public OrderServlet(){
		   
	   }
	   
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
		         throws IOException, ServletException {
		      // Set the MIME type for the response message
		      response.setContentType("text/html");
		      // Write to network
		      PrintWriter out = response.getWriter();
		      List<CustomerOrder> list = null;
		      
		      int customer_id = Integer.parseInt(request.getParameter("id"));
		      try {
				if(DBUtil.checkOrders(ConnectionUtil.getConnection(), customer_id)){
						list = DBUtil.getOrders(ConnectionUtil.getConnection(), customer_id);
						request.setAttribute("orderlist",list);
						RequestDispatcher dispatcher = request.getServletContext()
				                .getRequestDispatcher("/WEB-INF/views/OrderListView.jsp");
				        dispatcher.forward(request, response);
				} else {
					RequestDispatcher dispatcher = request.getServletContext()
			                .getRequestDispatcher("/WEB-INF/views/loginView.jsp");
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
