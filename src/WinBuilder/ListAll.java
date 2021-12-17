package WinBuilder;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.*;
import java.sql.*;
public class ListAll extends JFrame {

	private JPanel contentPane;
	private DefaultTableModel model;
	 JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListAll frame = new ListAll();
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
	public ListAll() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 586, 399);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("List of all people");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		lblNewLabel.setBounds(167, 24, 261, 16);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 52, 544, 299);
		contentPane.add(panel);
		
		try {
			
			Connection con = new DbConnection().getDbConnection();
			
			
			String sql = "SELECT * FROM students";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			 String columns[] = { "ID", "Name", "Age" };
			  String data[][] = new String[8][3];
			  int i = 0;
	  		while(rs.next()) {
	  			
	  			 int id = rs.getInt("id");
				 String name = rs.getString("first_name");
				 int age = rs.getInt("age");
				 data[i][0] = id + "";
			     data[i][1] = name;
			     data[i][2] = age + "";
			     System.out.println("Name "+name);
			        i++;
			}
	  		
	  		 frame = new JFrame();
	  		 model = new DefaultTableModel(data, columns);
	  	     JTable table = new JTable(model);
			 table.setShowGrid(true);
			 table.setShowHorizontalLines(true);
			 table.setShowVerticalLines(true);
			 table.setGridColor(Color.BLACK);
	  		 panel.add(table);
	
		}catch(Exception e) {
			System.out.print((e.getMessage()));
		}
		
		
	
	}
}
