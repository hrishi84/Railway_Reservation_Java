package dbms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

public class Login_page {
	public JFrame frame;
	private JTextField txtEnterYourLogin;
	private JPasswordField passwordField;
	static String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	static String uname = "me";
	static String password = "hello";
	/**
	* Launch the application.
	*/
	public static void main(String[] args) throws Exception {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_page window = new Login_page();
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
	public Login_page() {
		initialize();
	}

	/**
	* Initialize the contents of the frame.
	*/
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(240, 255, 255));
		frame.setBounds(100, 100, 578, 303);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblLoginId = new JLabel("Login ID");
		lblLoginId.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblLoginId.setBounds(244, 28, 93, 24);
		frame.getContentPane().add(lblLoginId);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Ubuntu", Font.BOLD, 16));
		lblPassword.setBounds(244, 63, 96, 21);
		frame.getContentPane().add(lblPassword);
		
		txtEnterYourLogin = new JTextField();
		txtEnterYourLogin.setFont(new Font("Ubuntu", Font.BOLD, 16));
		txtEnterYourLogin.setBounds(350, 31, 203, 20);
		frame.getContentPane().add(txtEnterYourLogin);
		txtEnterYourLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Ubuntu", Font.BOLD, 16));
		passwordField.setBounds(350, 62, 203, 20);
		frame.getContentPane().add(passwordField);
		
		JButton btnNewButton = new JButton("Login ");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnNewButton.setBorder(new LineBorder(Color.BLACK));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				String id = txtEnterYourLogin.getText();
				String pwd = passwordField.getText();
				boolean chk = false;
				String query = "SELECT * FROM Login WHERE User_name = '"+id+"' AND Password = '"+ pwd + "'";
				try {
				Class.forName("com.mysql.jdbc.Driver");
				Connection conn = DriverManager.getConnection(url,uname,password);
				Statement st = conn.createStatement();
				rs = st.executeQuery(query);
				while(rs.next())
				{

					String ID = rs.getString("User_name");
					String password = rs.getString("Password");
					if(ID.equals(id) && password.equals(pwd)) 
					{
						chk = true;
						
						break;
					}
				}
				if(chk)
				{
					frame.setVisible(false);
					new MainPage(id).frame.setVisible(true);
					//System.out.println("Correct");
				}
				else
				{
					JOptionPane.showMessageDialog(frame, "Please Enter Valid Credentials");
					frame.setVisible(false);
					new Login_page().frame.setVisible(true);
				}
				}catch(Exception ex) {System.out.println(ex);}			
			}
		});
		btnNewButton.setBounds(256, 122, 118, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.setBorder(new LineBorder(Color.BLACK));
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new SignUP().frame.setVisible(true);
			}
		});
		btnSignUp.setFont(new Font("Ubuntu", Font.BOLD, 20));
		btnSignUp.setBounds(410, 122, 142, 29);
		frame.getContentPane().add(btnSignUp);
		
		JLabel trainbk = new JLabel("");
		Image img1 = new ImageIcon(this.getClass().getResource("/trains.jpg")).getImage();
		trainbk.setIcon(new ImageIcon(img1));
		trainbk.setBounds(0, 0, 562, 269);
		frame.getContentPane().add(trainbk);		
	}
}

