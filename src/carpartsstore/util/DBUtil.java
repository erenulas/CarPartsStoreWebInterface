package carpartsstore.util;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import carpartsstore.bean.CarPart;
import carpartsstore.bean.Customer;
import carpartsstore.bean.CustomerLogin;
import carpartsstore.bean.CustomerOrder;

public class DBUtil {
	public static Customer findUser(Connection conn,  String email,String pass)
		throws SQLException {
		String sql = "Select c.customer_id,c.address_id,c.age,c.birthDate,c.firstName,c.lastName,c.gender,c.phoneNumber from Customer c, Customer_Login cl "
				+ " where cl.email =? and cl.pw=? and cl.customer_id=c.customer_id";
		
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1,email);
		statement.setString(2, pass);
		ResultSet rs = statement.executeQuery();
		
		if(rs.next()) {
			Customer c = new Customer();
			int customer_id = rs.getInt("customer_id");
			int address_id = rs.getInt("address_id");
			String firstName = rs.getString("firstName");
			String lastName = rs.getString("lastName");
			String phoneNumber = rs.getString("phoneNumber");
			java.sql.Date birthDate = rs.getDate("birthDate");
			int age = rs.getInt("age");
			char gender = rs.getString("gender").charAt(0);
			
			c.setCustomer_id(customer_id);
			c.setAddress_id(address_id);
			c.setAge(age);
			c.setBirthDate(birthDate);
			c.setCustomer_id(customer_id);
			c.setFirstName(firstName);
			c.setGender(gender);
			c.setLastName(lastName);
			c.setPhoneNumber(phoneNumber);
			return c;
		}
		return null;
	}
	public static boolean checkUser(Connection conn, String email, String password)
			throws Exception {
			String sql = "Select * from Customer_Login cl "
					+ " where cl.pw = ? and cl.email=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1,password);
			statement.setString(2, email);
			ResultSet rs = statement.executeQuery();
			boolean st = rs.next();
			return st;
		}
	public static Customer findUserbyId(Connection conn, int customer_id)
			throws SQLException {
			String sql = "Select * from Customer"
					+ " where customer_id=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1,customer_id);
			ResultSet rs = statement.executeQuery();
			
			if(rs.next()) {
				Customer c = new Customer();
				int address_id = rs.getInt("address_id");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String phoneNumber = rs.getString("phoneNumber");
				java.sql.Date birthDate = rs.getDate("birthDate");
				int age = rs.getInt("age");
				char gender = rs.getString("gender").charAt(0);
				
				c.setCustomer_id(customer_id);
				c.setAddress_id(address_id);
				c.setAge(age);
				c.setBirthDate(birthDate);
				c.setCustomer_id(customer_id);
				c.setFirstName(firstName);
				c.setGender(gender);
				c.setLastName(lastName);
				c.setPhoneNumber(phoneNumber);
				return c;
			}
			return null;
		}
		public static boolean checkUserbyId(Connection conn, int customer_id)
				throws Exception {
				if(customer_id == 0)
					return false;
				String sql = "Select * from Customer_Login "
						+ "where customer_id=?";
				
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1,customer_id);
				ResultSet rs = statement.executeQuery();
				boolean st = rs.next();
				return st;
			}
	
	public static List<CustomerOrder> getOrders(Connection conn, int customer_id) throws Exception {
		String sql = "select * from Customer_Order where customer_id=?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1,customer_id);
				ResultSet rs = statement.executeQuery();
				
				List<CustomerOrder> list = new ArrayList<CustomerOrder>();
				while(rs.next()) {
					int order_id = rs.getInt("order_id");
					java.sql.Date dateOfOrder = rs.getDate("dateOfOrder");
					float amount = rs.getFloat("amount");
					CustomerOrder co = new CustomerOrder();
					co.setCustomer_id(customer_id);
					co.setAmount(amount);
					co.setDateOfOrder(dateOfOrder);
					co.setOrder_id(order_id);
					list.add(co);
				}
				return list;
	}
	
	public static boolean checkOrders(Connection conn, int customer_id)
			throws Exception {
			String sql = "Select * from Customer_Order "
					+ " where customer_id=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setInt(1,customer_id);
			ResultSet rs = statement.executeQuery();
			boolean st = rs.next();
			return st;
		}
	public static List<CarPart> getPartsInOrder(Connection conn, int order_id) throws Exception {
		String sql = "select p.part_id,p.car_id,p.supplier_id,p.partName,p.priceToUs,p.priceToCustomer"
				+ " from Car_Part p, Part_In_Order po "
				+ "where po.part_id=p.part_id and po.order_id=?";
				PreparedStatement statement = conn.prepareStatement(sql);
				statement.setInt(1,order_id);
				ResultSet rs = statement.executeQuery();
				
				List<CarPart> list = new ArrayList<CarPart>();
				while(rs.next()) {
					int part_id = rs.getInt("part_id");
					int car_id = rs.getInt("car_id");
					int supplier_id = rs.getInt("supplier_id");
					String partName = rs.getString("partName");
					float priceToUs = rs.getFloat("priceToUs");
					float priceToCustomer = rs.getFloat("priceToCustomer");
					
					CarPart p = new CarPart();
					p.setCar_id(car_id);
					p.setPart_id(part_id);
					p.setPartName(partName);
					p.setPriceToCustomer(priceToCustomer);
					p.setPriceToUs(priceToUs);
					p.setSupplier_id(supplier_id);
					list.add(p);
				}
				return list;
	}
	
	public static void updateLastName(Connection conn, int customer_id, String lastName) throws Exception {
		String sql = "update Customer set lastName=? where customer_id=?";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setString(1, lastName);
		statement.setInt(2, customer_id);
		statement.executeUpdate();
	}
	
	public static void insertNewOrder(Connection conn,int customer_id) throws Exception {
		String sql = "insert into Customer_Order (customer_id) values(?)";
		PreparedStatement statement = conn.prepareStatement(sql);
		statement.setInt(1, customer_id);
		statement.executeQuery();
	}
}
