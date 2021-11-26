package WinBuilder;

public class Customer {
	String firstname, lastname, gender, address, mobile_no, occupation, dob, account_no;
	double account_balance;

	
	 Customer(String fname, String lname, String address, String gender, String tel_no, String jobtitle, String  dob, String accountNo, double bal){
		   this.firstname = lname;
		   this.lastname = lname;
		   this.gender = gender;
		   this.address = address;
		   this.mobile_no = tel_no;
		   this.occupation = jobtitle;
		   this.dob = dob;
		   this.account_no = accountNo;
		   this.account_balance = bal;
	 }

}
