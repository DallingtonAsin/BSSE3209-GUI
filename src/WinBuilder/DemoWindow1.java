package WinBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class DemoWindow1 extends JFrame  {

	private JPanel contentPane;
	private JTextField firstNameTextField;
	private JTextField LastNameTextField;
	JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoWindow1 frame = new DemoWindow1();
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
	public DemoWindow1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 428);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Student Registration Form");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 30));
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setBounds(17, 6, 409, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First Name:");
		lblNewLabel_1.setBounds(23, 70, 82, 25);
		contentPane.add(lblNewLabel_1);
		
		firstNameTextField = new JTextField();
		firstNameTextField.setBounds(117, 64, 201, 36);
		contentPane.add(firstNameTextField);
		firstNameTextField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last Name:");
		lblNewLabel_1_1.setBounds(23, 122, 70, 25);
		contentPane.add(lblNewLabel_1_1);
		
		LastNameTextField = new JTextField();
		LastNameTextField.setColumns(10);
		LastNameTextField.setBounds(117, 116, 201, 36);
		contentPane.add(LastNameTextField);
		
		JButton btnNewButton = new JButton("REGISTER");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String first_name = firstNameTextField.getText().toString();
				String last_name = LastNameTextField.getText().toString();
				String gender = String.valueOf(comboBox.getSelectedItem());
				System.out.format("%s, %s, %s", first_name, last_name, gender);
				new DemoWindow1().resetInputFields();

//				System.out.println("Hey, you have clicked Register Button");

			}
		});
		
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(117, 219, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		btnCancel.setForeground(Color.RED);
		btnCancel.setBounds(244, 219, 117, 29);
		contentPane.add(btnCancel);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Gender");
		lblNewLabel_1_1_1.setBounds(23, 175, 70, 25);
		contentPane.add(lblNewLabel_1_1_1);
		
		String[] genderArr = {"", "Male", "Female"};
		 comboBox = new JComboBox(genderArr);
		comboBox.setBounds(117, 180, 201, 27);
		contentPane.add(comboBox);
		
	}
	
	private void resetInputFields() {
		firstNameTextField.setText("");
		LastNameTextField.setText("");
		comboBox.setSelectedIndex(0);
	}
	
}
