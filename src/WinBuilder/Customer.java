package WinBuilder;

import java.sql.*;

public class Customer {

	public static void main(String[] args) {
		
		try { 

			Class.forName("com.mysql.cj.jdbc.Driver");
			//Class.forName("com.mysql.jdbc.Driver"); // this has been deprecated
			String connectionString = "jdbc:mysql://localhost:3306/vms";
			String db_username = "AfricaOne";
			String db_password = "AfricaOne";

			Connection con = DriverManager.getConnection(connectionString, db_username, db_password);  

			Statement stmt=con.createStatement();  
			ResultSet rs=stmt.executeQuery("select * from users");  
			while(rs.next()) {

				int id = rs.getInt("id");
				String firstName = rs.getString("first_name");
				String lastName = rs.getString("last_name");

				String name = firstName+" "+lastName;
				String username = rs.getString("username");
				String telephone_no = rs.getString("mobile_no");
				String gender = rs.getString("gender");


				Date dateCreated = rs.getDate("created_at");
				boolean isActive = rs.getBoolean("is_active");
				int user_role = rs.getInt("role");

				System.out.format("%s, %s, %s,%s, %s, %s, %s, %s, %s\n", 
						id,firstName, lastName, dateCreated,
						isActive, user_role, name, username,
						telephone_no, gender);
			}
			con.close();  
		}
		catch(Exception e){ 
			System.out.println(e);
		}  
	}  
}
