package WinBuilder;

import java.sql.*;

public class Customers {

	public static void main(String[] args) {

		try { 

			DbConnection db = new DbConnection();
            Connection con = db.getDbConnection();
			Statement stmt= con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from customers");  
			while(rs.next()) {

				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");
				String address = rs.getString("address");
				String telephone_no = rs.getString("mobile_no");
				String gender = rs.getString("gender");
				String occupation = rs.getString("occupation");
				String account_no = rs.getString("account_no");
				String balance = rs.getString("balance");
				Date dob = rs.getDate("dob");

				System.out.format("%s. %s, %s,%s, %s, %s, %s, %s, %s\n", 
						id, firstName, lastName,gender, address,telephone_no, occupation, dob, account_no, balance);
			}
			con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);
		}  
	}  
}
