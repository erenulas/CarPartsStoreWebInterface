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

import carpartsstore.bean.CarPart;
import carpartsstore.bean.Customer;
import carpartsstore.bean.CustomerOrder;
import carpartsstore.connection.ConnectionUtil;
import carpartsstore.util.DBUtil;

public class OrderContentServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	   public OrderContentServlet(){
		   
	   }
	   
	   public void doGet(HttpServletRequest request, HttpServletResponse response)
		         throws IOException, ServletException {
		      // Set the MIME type for the response message
		      response.setContentType("text/html");
		      // Write to network
		      PrintWriter out = response.getWriter();
		      List<CarPart> list = null;
		      
		      int order_id = Integer.parseInt(request.getParameter("ordr_id"));
		      try {
		    	  list = DBUtil.getPartsInOrder(ConnectionUtil.getConnection(), order_id);
		    	  request.setAttribute("parts", list);
		    	  request.setAttribute("customer_id", request.getParameter("cst_id"));
					RequestDispatcher dispatcher = request.getServletContext()
			                .getRequestDispatcher("/WEB-INF/views/OrderContentView.jsp");
			        dispatcher.forward(request, response);
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





