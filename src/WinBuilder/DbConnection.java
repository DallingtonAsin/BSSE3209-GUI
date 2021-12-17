package WinBuilder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection  {

	  
	     public Connection getDbConnection() throws SQLException
	     {
	    	try {
							//Class.forName("com.mysql.jdbc.Driver"); // this has been deprecated
							String connectionString = "jdbc:mysql://localhost:3306/school";
							String db_username = "Dallingtons";
							String db_password = "Dallingtons";
							Connection con = DriverManager.getConnection(connectionString, db_username, db_password);  
							return con;
	     }catch(SQLException ex) {
	    	  throw ex;
	     }
	    	
	     }
	    	
	    	
	
	
	
	
	
	
	
	
	
}
