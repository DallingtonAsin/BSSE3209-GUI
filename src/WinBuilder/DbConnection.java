package WinBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection  {

	  
	     public Connection getDbConnection() throws SQLException
	     {
	    	try {
							//Class.forName("com.mysql.jdbc.Driver"); // this has been deprecated
							String connectionString = "jdbc:mysql://localhost:3306/bank_bsse";
							String db_username = "AfricaOne";
							String db_password = "AfricaOne";
							Connection con = DriverManager.getConnection(connectionString, db_username, db_password);  
							return con;
	     }catch(SQLException ex) {
	    	  throw ex;
	     }
	    	
	     }
	    	
	    	
	
	
	
	
	
	
	
	
	
}
