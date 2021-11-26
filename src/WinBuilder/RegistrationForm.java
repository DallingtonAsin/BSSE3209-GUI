package WinBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;

public class RegistrationForm extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	private JTextField fnameTextField;
	private JLabel lblNewLabel_2;
	private JTextField lnameTextField;
	private JLabel lblNewLabel_3;
	private JTextField addressTextField;
	private JLabel lblNewLabel_4;
	private JTextField telTextField;
	private JLabel lblNewLabel_5;
	private JTextField jobTextField;
	private JLabel lblNewLabel_6;
	private JButton btnCancel;

	
	
	private  void Reset() {
		fnameTextField.setText("");
		lnameTextField.setText("");
		addressTextField.setText("");
		telTextField.setText("");
		jobTextField.setText("");
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationForm frame = new RegistrationForm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationForm() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 506, 377);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.window);
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Register with Bank BSSE3209");
		lblNewLabel.setForeground(SystemColor.controlHighlight);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 18));
		lblNewLabel.setBounds(117, 18, 281, 23);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name:");
		lblNewLabel_1.setBounds(39, 109, 96, 23);
		contentPane.add(lblNewLabel_1);
		
		fnameTextField = new JTextField();
		fnameTextField.setBounds(117, 62, 215, 35);
		contentPane.add(fnameTextField);
		fnameTextField.setColumns(10);
		
		lblNewLabel_2 = new JLabel("First Name:");
		lblNewLabel_2.setBounds(39, 68, 76, 23);
		contentPane.add(lblNewLabel_2);
		
		lnameTextField = new JTextField();
		lnameTextField.setColumns(10);
		lnameTextField.setBounds(117, 98, 215, 35);
		contentPane.add(lnameTextField);
		
		lblNewLabel_3 = new JLabel("Address:");
		lblNewLabel_3.setBounds(39, 144, 96, 23);
		contentPane.add(lblNewLabel_3);
		
		addressTextField = new JTextField();
		addressTextField.setColumns(10);
		addressTextField.setBounds(117, 133, 215, 35);
		contentPane.add(addressTextField);
		
		lblNewLabel_4 = new JLabel("Telephone");
		lblNewLabel_4.setBounds(39, 181, 96, 23);
		contentPane.add(lblNewLabel_4);
		
		telTextField = new JTextField();
		telTextField.setColumns(10);
		telTextField.setBounds(117, 175, 215, 35);
		contentPane.add(telTextField);
		
		lblNewLabel_5 = new JLabel("Occupation");
		lblNewLabel_5.setBounds(39, 216, 76, 23);
		contentPane.add(lblNewLabel_5);
		
		jobTextField = new JTextField();
		jobTextField.setColumns(10);
		jobTextField.setBounds(117, 212, 215, 35);
		contentPane.add(jobTextField);
		
		lblNewLabel_6 = new JLabel("Gender");
		lblNewLabel_6.setBounds(39, 251, 62, 23);
		contentPane.add(lblNewLabel_6);
		
		
		JRadioButton rdbtnFemale = new JRadioButton("Female");
		rdbtnFemale.setBounds(117, 259, 88, 23);
		contentPane.add(rdbtnFemale);
		
		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setBounds(216, 259, 141, 23);
		contentPane.add(rdbtnMale);
		

		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String firstname = fnameTextField.getText().toString();
				String lastname = lnameTextField.getText().toString();
				String address = addressTextField.getText().toString();
				String gender = "Male";
				String telephone = telTextField.getText().toString();
				String occupation = jobTextField.getText().toString();
				String dob = "12/12/1934";
				Random random = new Random();
				String account_no = String.valueOf(random.nextInt(10000000));
				double balance = 0;
				
				Customer cust = new Customer(firstname, lastname, address, gender, telephone, occupation, dob, account_no, balance);
				DbHandler handler = new DbHandler();
				boolean res = handler.register(cust);
				if(java.util.Objects.equals(res, true)) {
					 Reset();
					JOptionPane.showMessageDialog(null, "Customer "+firstname+" "+lastname+" registered successfully");
				}else {
					JOptionPane.showMessageDialog(null, "Oops, unable to create customer!");
				}
				
				System.out.format("%s, %s, %s, %s, %s, %s", firstname, lastname, address, telephone, occupation, gender);
				
			}
		});
		
		
		
		btnNewButton.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBackground(Color.BLACK);
		btnNewButton.setBounds(117, 297, 117, 29);
		contentPane.add(btnNewButton);
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			      	System.exit(0);
			}
		});
		btnCancel.setForeground(Color.RED);
		btnCancel.setBackground(Color.BLACK);
		btnCancel.setBounds(240, 297, 117, 29);
		contentPane.add(btnCancel);
	}
}
