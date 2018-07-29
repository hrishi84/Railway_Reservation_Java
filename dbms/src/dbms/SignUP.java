package dbms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.*;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.SwingConstants;


import java.awt.SystemColor;
import javax.swing.JScrollBar;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class SignUP {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_5;
	private JPasswordField passwordField;
	static String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	static String uname = "me";
	static String password = "hello";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUP window = new SignUP();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SignUP() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(SystemColor.inactiveCaption);
		frame.setBounds(100, 100, 613, 368);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setHorizontalAlignment(SwingConstants.LEFT);
		lblName.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblName.setBounds(72, 38, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblUserName = new JLabel("Contact");
		lblUserName.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblUserName.setBounds(72, 63, 71, 14);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblNewLabel = new JLabel("Address");
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblNewLabel.setBounds(72, 88, 71, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblAnswer = new JLabel("Age");
		lblAnswer.setHorizontalAlignment(SwingConstants.LEFT);
		lblAnswer.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblAnswer.setBounds(72, 138, 46, 19);
		frame.getContentPane().add(lblAnswer);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(18, 1, 100, 1));
		spinner.setBounds(248, 137, 53, 20);
		frame.getContentPane().add(spinner);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(248, 165, 86, 22);
		frame.getContentPane().add(comboBox);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;	
				String name = textField.getText();
				String no = textField_1.getText();
				String add = textField_2.getText();
				String city = textField_3.getText();
				int age = (Integer)spinner.getValue();
				String gender = (String) comboBox.getSelectedItem();
				String u_name = textField_5.getText();
				String pwd = passwordField.getText();
				if((name.equals("")||no.equals("")||add.equals("")||city.equals("")||u_name.equals("")||pwd.equals("")))
				{
					JOptionPane.showMessageDialog(frame,"Please fill all the credentials");
					frame.setVisible(false);
					new SignUP().frame.setVisible(true);
				}
				else
				{
					String query = "INSERT INTO user(User_name, Name, Address, City, Contact, Age, Gender) values ('"+u_name+"','"+name+"','"+add+"','"+city+"',"+no+","+age+",'"+gender+"')";
					try{
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection(url,uname,password);
						Statement st = conn.createStatement();
						st.executeUpdate(query);
						query = "INSERT INTO Login (User_name,Password) values('"+u_name+"','"+pwd+"')";
						st.executeUpdate(query);
						frame.setVisible(false);
						new Login_page().frame.setVisible(true);
					}catch(Exception ex){
						ex.printStackTrace();
					}
				}
			}
		});
		btnRegister.setBounds(336, 267, 140, 39);
		frame.getContentPane().add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login_page().frame.setVisible(true);
			}
		});
		btnBack.setBounds(190, 267, 111, 39);
		frame.getContentPane().add(btnBack);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setHorizontalAlignment(SwingConstants.LEFT);
		lblCity.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblCity.setBounds(72, 113, 71, 19);
		frame.getContentPane().add(lblCity);
		
		JLabel lblUserName_1 = new JLabel("User Name");
		lblUserName_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblUserName_1.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblUserName_1.setBounds(72, 199, 86, 14);
		frame.getContentPane().add(lblUserName_1);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.LEFT);
		lblPassword.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblPassword.setBounds(72, 224, 86, 14);
		frame.getContentPane().add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(248, 37, 171, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(248, 62, 171, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(248, 87, 171, 20);
		frame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(248, 112, 171, 20);
		frame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 223, 171, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblGender.setBounds(72, 168, 71, 14);
		frame.getContentPane().add(lblGender);
		
		textField_5 = new JTextField();
		textField_5.setBounds(248, 198, 171, 20);
		frame.getContentPane().add(textField_5);
		textField_5.setColumns(10);
		textField_5.addActionListener(new java.awt.event.ActionListener(){
			public void actionPerformed(java.awt.event.ActionEvent e) {
				ResultSet rs = null;
				String userid = textField_5.getText();
				String query = "SELECT User_name FROM user WHERE User_name = '"+userid+"'";
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url,uname,password);
					Statement st = conn.createStatement();
					rs = st.executeQuery(query);
					while(rs.next())
					{
						String id = rs.getString("User_name");
						if(userid.equals(id))
						{
							JOptionPane.showMessageDialog(frame,"Username already exists !!\n Please enter another Username");
							textField_5.setText("");
							break;
						}
					}
				}catch(Exception e1){}
			}
		});
	}
}
