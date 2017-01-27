package carpartsstore.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLServerConnection {
	 public static Connection getSQLServerConnection_SQLJDBC()
	         throws ClassNotFoundException, SQLException {
	      
	     // Note: Change the connection parameters accordingly.
	      
	     String hostName = "localhost";
	     String sqlInstanceName = "SQLEXPRESS";
	     String database = "CARPARTSSTORE";

	 
	     return getSQLServerConnection_SQLJDBC(hostName, sqlInstanceName,
	             database);
	 }
	 /*public static Connection getSQLServerConnection()
	         throws ClassNotFoundException, SQLException {
	      
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	     String connectionURL = "jdbc:sqlserver://localhost:1433;instance=SQLEXPRESS;databaseName=CARPARTSSTORE;integratedSecurity=true";
	     Connection conn = DriverManager.getConnection(connectionURL);
	     return conn;
	 }-*/
	 
	 //Connect to SQLServer, using SQLJDBC Library.
	 private static Connection getSQLServerConnection_SQLJDBC(String hostName,
	         String sqlInstanceName, String database) throws ClassNotFoundException, SQLException {
	    
	     // Declare the class Driver for SQLServer DB
	     // This is necessary with Java 5 (or older)
	     // Java6 (or newer) automatically find the appropriate driver.
	     // If you use Java> 5, then this line is not needed.        
	     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	 
	     // jdbc:sqlserver://ServerIp:1433/SQLEXPRESS;databaseName=simplehr      
	     String connectionURL = "jdbc:sqlserver://" + hostName + ":1433"
	             + ";instance=" + sqlInstanceName + ";databaseName=" + database+";integratedSecurity=true";
	 
	     Connection conn = DriverManager.getConnection(connectionURL);
	     return conn;
	 }
	 
}


 