package dbms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import javax.swing.JTextPane;

public class PassengerDetails {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	static String [] train;
	static int nop;
	static String src;
	static String dest;
	static String day;
	static String url="jdbc:mysql://localhost:3306/mydb?useSSL=false";
	static String uname = "me";
	static String password = "hello";
	static String u_id;
	static String [] p_name;
	static int [] pnr;
	static String [] p_gender;
	static int [] p_age; 
	static int tno;
	static String train_name;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PassengerDetails window = new PassengerDetails(u_id,train,nop,src,dest,day);
					System.out.println(day);
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
	public PassengerDetails(String u_id,String [] train,int nop,String src,String dest,String day) {
		this.u_id = u_id;
		this.train = train;
		this.nop = nop;
		this.src = src;
		this.dest = dest;
		this.day = day;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 664, 390);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblEnterThePassenger = new JLabel("");
		lblEnterThePassenger.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterThePassenger.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEnterThePassenger.setBounds(153, 11, 322, 25);
		frame.getContentPane().add(lblEnterThePassenger);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblName.setBounds(47, 170, 46, 14);
		frame.getContentPane().add(lblName);
		
		textField = new JTextField();
		textField.setBounds(103, 169, 195, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblGender.setBounds(328, 170, 62, 14);
		frame.getContentPane().add(lblGender);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox.setBounds(400, 166, 94, 22);
		frame.getContentPane().add(comboBox);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAge.setBounds(514, 169, 46, 17);
		frame.getContentPane().add(lblAge);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(18, 1, 100, 1));
		spinner.setBounds(569, 169, 46, 20);
		frame.getContentPane().add(spinner);
		
		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(47, 199, 46, 14);
		if(nop>1)frame.getContentPane().add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(103, 198, 195, 20);
		if(nop>1)frame.getContentPane().add(textField_1);
		
		JLabel label_1 = new JLabel("Gender");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_1.setBounds(328, 199, 62, 14);
		if(nop>1)frame.getContentPane().add(label_1);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_1.setBounds(400, 195, 94, 22);
		if(nop>1)frame.getContentPane().add(comboBox_1);
		
		JLabel label_2 = new JLabel("Age");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_2.setBounds(514, 198, 46, 17);
		if(nop>1)frame.getContentPane().add(label_2);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setModel(new SpinnerNumberModel(18, 1, 100, 1));
		spinner_1.setBounds(569, 198, 46, 20);
		if(nop>1)frame.getContentPane().add(spinner_1);
		
		JLabel label_3 = new JLabel("Name");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_3.setBounds(47, 228, 46, 14);
		if(nop>2)frame.getContentPane().add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(103, 227, 195, 20);
		if(nop>2)frame.getContentPane().add(textField_2);
		
		JLabel label_4 = new JLabel("Gender");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_4.setBounds(328, 228, 62, 14);
		if(nop>2)frame.getContentPane().add(label_4);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_2.setBounds(400, 224, 94, 22);
		if(nop>2)frame.getContentPane().add(comboBox_2);
		
		JLabel label_5 = new JLabel("Age");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_5.setBounds(514, 227, 46, 17);
		if(nop>2)frame.getContentPane().add(label_5);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setModel(new SpinnerNumberModel(18, 1, 100, 1));
		spinner_2.setBounds(569, 227, 46, 20);
		if(nop>2)frame.getContentPane().add(spinner_2);
		
		JLabel label_6 = new JLabel("Name");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_6.setBounds(47, 257, 46, 14);
		if(nop>3)frame.getContentPane().add(label_6);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(103, 256, 195, 20);
		if(nop>3)frame.getContentPane().add(textField_3);
		
		JLabel label_7 = new JLabel("Gender");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_7.setBounds(328, 257, 62, 14);
		if(nop>3)frame.getContentPane().add(label_7);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_3.setBounds(400, 253, 94, 22);
		if(nop>3)frame.getContentPane().add(comboBox_3);
		
		JLabel label_8 = new JLabel("Age");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_8.setBounds(514, 256, 46, 17);
		if(nop>3)frame.getContentPane().add(label_8);
		
		JSpinner spinner_3 = new JSpinner();
		spinner_3.setModel(new SpinnerNumberModel(18, 1, 100, 1));
		spinner_3.setBounds(569, 256, 46, 20);
		if(nop>3)frame.getContentPane().add(spinner_3);
		
		JLabel label_9 = new JLabel("Name");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_9.setBounds(47, 286, 46, 14);
		if(nop>4)frame.getContentPane().add(label_9);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(103, 285, 195, 20);
		if(nop>4)frame.getContentPane().add(textField_4);
		
		JLabel label_10 = new JLabel("Gender");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_10.setBounds(328, 286, 62, 14);
		if(nop>4)frame.getContentPane().add(label_10);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] {"Male", "Female"}));
		comboBox_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox_4.setBounds(400, 282, 94, 22);
		if(nop>4)frame.getContentPane().add(comboBox_4);
		
		JLabel label_11 = new JLabel("Age");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label_11.setBounds(514, 285, 46, 17);
		if(nop>4)frame.getContentPane().add(label_11);
		
		JSpinner spinner_4 = new JSpinner();
		spinner_4.setModel(new SpinnerNumberModel(18, 1, 100, 1));
		spinner_4.setBounds(569, 285, 46, 20);
		if(nop>4)frame.getContentPane().add(spinner_4);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new MainPage(u_id).frame.setVisible(true);
			}
		});
		btnBack.setBounds(155, 316, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(train));
		comboBox_5.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		comboBox_5.setBounds(103, 39, 287, 22);
		frame.getContentPane().add(comboBox_5);
		
		JButton btnBookTicket = new JButton("Book Ticket");
		btnBookTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBookTicket.setBounds(348, 316, 138, 23);
		frame.getContentPane().add(btnBookTicket);
		btnBookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs;
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url,uname,password);
					Statement st = conn.createStatement();
					train_name = comboBox_5.getSelectedItem().toString();
					String name;
					String gender;
					String query = "SELECT Train_no FROM Train WHERE Train_name = '"+train_name+"'";
					rs = st.executeQuery(query);
					rs.next();
					p_name = new String[nop];
					p_age = new int[nop];
					p_gender = new String[nop];
					pnr = new int[nop];
					tno = rs.getInt("Train_no");
					int age;
					query = "SELECT Pnr FROM Passenger";
					rs = st.executeQuery(query);
					rs.last();
					int PNR = rs.getInt("PNR");
					query="update Train set "+day+" = "+day+"-"+nop+" where Train_no = "+ tno;
					st.executeUpdate(query);
					for(int i = 0;i < nop;i++)
					{
						switch(i)
						{
						case 0 : name = textField.getText();
								 gender = comboBox.getSelectedItem().toString();
								 age = (int) spinner.getValue();
								 query = "INSERT INTO Passenger (User_name,Age,p_name,Gender,Source,Destination,Train_no) values ('" + u_id + "'," + age + ",'" + name +"','"+gender+"','"+src+"','"+dest+"',"+tno+")";
								 st.executeUpdate(query);
								 pnr[i] = ++PNR;
								 p_name[i] = name;
								 p_age[i] = age;
								 p_gender[i] = gender;
								 break;
						case 1 : name = textField_1.getText();
						 		 gender = comboBox_1.getSelectedItem().toString();
						 		 age = (int) spinner_1.getValue();
						 		 query = "INSERT INTO Passenger (User_name,Age,p_name,Gender,Source,Destination,Train_no) values ('" + u_id + "'," + age + ",'" + name +"','"+gender+"','"+src+"','"+dest+"',"+tno+")";
						 		 st.executeUpdate(query);
						 		 pnr[i] = ++PNR;
								 p_name[i] = name;
								 p_age[i] = age;
								 p_gender[i] = gender;
						 		 break;
						case 2 : name = textField_2.getText();
						 		 gender = comboBox_2.getSelectedItem().toString();
						 		 age = (int) spinner_2.getValue();
						 		 query = "INSERT INTO Passenger (User_name,Age,p_name,Gender,Source,Destination,Train_no) values ('" + u_id + "'," + age + ",'" + name +"','"+gender+"','"+src+"','"+dest+"',"+tno+")";
						 		 st.executeUpdate(query);
						 		 pnr[i] = ++PNR;
								 p_name[i] = name;
								 p_age[i] = age;
								 p_gender[i] = gender;
						 		 break;
						case 3 : name = textField_3.getText();
						 		 gender = comboBox_3.getSelectedItem().toString();
						 		 age = (int) spinner_3.getValue();
						 		 query = "INSERT INTO Passenger (User_name,Age,p_name,Gender,Source,Destination,Train_no) values ('" + u_id + "'," + age + ",'" + name +"','"+gender+"','"+src+"','"+dest+"',"+tno+")";
						 		 st.executeUpdate(query);
						 		 pnr[i] = ++PNR;
								 p_name[i] = name;
								 p_age[i] = age;
								 p_gender[i] = gender; 
						 		 break;
						case 4 : name = textField_4.getText();
							     gender = comboBox_4.getSelectedItem().toString();
							     age = (int) spinner_4.getValue();
							     query = "INSERT INTO Passenger (User_name,Age,p_name,Gender,Source,Destination,Train_no) values ('" + u_id + "'," + age + ",'" + name +"','"+gender+"','"+src+"','"+dest+"',"+tno+")";
							     st.executeUpdate(query);
							     pnr[i] = ++PNR;
								 p_name[i] = name;
								 p_age[i] = age;
								 p_gender[i] = gender;
							     break;
						}
					}
				}catch(Exception exp){System.out.println(exp);};
				frame.setVisible(false);
				new FinalTicket(u_id,tno,train_name,src,dest,pnr,p_name,p_gender,p_age).frame.setVisible(true);
			}
		});
		
		
		JLabel lblTrain = new JLabel("Train");
		lblTrain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTrain.setBounds(47, 41, 46, 14);
		frame.getContentPane().add(lblTrain);
		
		JLabel lblEnterPassengerDetails = new JLabel("Enter Passenger Details");
		lblEnterPassengerDetails.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEnterPassengerDetails.setBounds(226, 120, 207, 14);
		frame.getContentPane().add(lblEnterPassengerDetails);
	}
}
