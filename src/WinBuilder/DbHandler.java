package WinBuilder;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;  

public class DbHandler  implements Bank{
	
	DbConnection db = new DbConnection();
    
	public boolean register(Customer customer)  {
	
		  try {
			  Connection con = db.getDbConnection();
			   String query = "insert into customers (first_name, last_name, gender, address, mobile_no, occupation, dob, account_no, balance)  values (?, ?, ?, ?, ?, ?, ?,?,?)";

			        SimpleDateFormat format =new SimpleDateFormat("yyyy/MM/dd");
			        
			        java.util.Date utilDate = format.parse("2014/04/13");
			        java.sql.Date convertedDob = new java.sql.Date(utilDate.getTime());
			        
			       
			   
				      PreparedStatement preparedStmt = con.prepareStatement(query);
				      preparedStmt.setString(1, customer.firstname);
				      preparedStmt.setString(2, customer.lastname);
				      preparedStmt.setString(3,  customer.gender);
				      preparedStmt.setString(4, customer.address);
				      preparedStmt.setString(5, customer.mobile_no);
				      preparedStmt.setString(6, customer.occupation);
				      preparedStmt.setObject(7, convertedDob); 
				      preparedStmt.setString(8, customer.account_no);  
				      preparedStmt.setDouble(9, customer.account_balance);  
				      preparedStmt.execute();
					  con.close();
				      return true;
				  
		  }catch(SQLException | ParseException e) {
			  System.out.println("Got exception while registering "+e.getMessage());
			    return false;
		  }

	}
	public double deposit(double amount, String account_no) {
		 return 9000;
	}
	public double withdraw(double amount, String account_no) {
		return 8000;
	}
    public void displayCustomers() {
    	
    }
	

}
