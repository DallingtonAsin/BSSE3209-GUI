package WinBuilder;

public interface Bank {
	
	public boolean register(Customer customer);
	public double deposit(double amount, String account_no);
	public double withdraw(double amount, String account_no);
    public void displayCustomers();
   
}
