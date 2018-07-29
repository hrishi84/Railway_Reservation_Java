package dbms;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.SystemColor;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class MainPage {

	public JFrame frame;
	static String url = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
	static String uname = "me";
	static String password = "hello";
	static String u_id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainPage window = new MainPage(u_id);
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
	public MainPage(String u_id) {
		this.u_id = u_id;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(SystemColor.activeCaption);
		frame.setBounds(100, 100, 516, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToOnline = new JLabel("Welcome to Ticketing System");
		lblWelcomeToOnline.setHorizontalAlignment(SwingConstants.CENTER);
		lblWelcomeToOnline.setFont(new Font("Century Gothic", Font.BOLD, 20));
		lblWelcomeToOnline.setBounds(61, 11, 379, 36);
		frame.getContentPane().add(lblWelcomeToOnline);
		
		JLabel label = new JLabel("Source");
		label.setFont(new Font("Tahoma", Font.PLAIN, 16));
		label.setBounds(50, 72, 81, 14);
		frame.getContentPane().add(label);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDestination.setBounds(286, 74, 90, 14);
		frame.getContentPane().add(lblDestination);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Mumbai", "Jaipur", "Ahmdebad", "Delhi"}));
		comboBox.setBounds(125, 70, 98, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Mumbai", "Jaipur", "Ahmdebad", "Delhi"}));
		comboBox_1.setBounds(389, 70, 98, 22);
		frame.getContentPane().add(comboBox_1);
		
		JLabel lblDate = new JLabel("Day");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDate.setBounds(50, 119, 46, 14);
		frame.getContentPane().add(lblDate);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"Monday", "Tuesday", "Wednesday"}));
		comboBox_3.setBounds(125, 117, 98, 22);
		frame.getContentPane().add(comboBox_3);
		
		JLabel lblNoOfSeats = new JLabel("No of Passengers");
		lblNoOfSeats.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoOfSeats.setBounds(248, 117, 128, 18);
		frame.getContentPane().add(lblNoOfSeats);
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(1, 1, 5, 1));
		spinner.setBounds(389, 118, 54, 20);
		frame.getContentPane().add(spinner);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				new Login_page().frame.setVisible(true);
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(125, 183, 89, 23);
		frame.getContentPane().add(btnBack);
		
		JButton btnBookTicket = new JButton("Proceed");
		btnBookTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				String src = comboBox.getSelectedItem().toString();
				String dest = comboBox_1.getSelectedItem().toString();
				String Day = comboBox_3.getSelectedItem().toString();
				String train_name[];
				int total;
				int no = (Integer)spinner.getValue();
				String nest_query="SELECT Train_no FROM Station WHERE "+src+" = 1 AND "+dest+" = 1 AND End <> '"+src+"' AND "+Day+" >= "+no;
				String query = "SELECT Train_name FROM Train WHERE Train_no IN ("+nest_query+")";
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url,uname,password);
					Statement st = conn.createStatement();
					if(!src.equals(dest))rs = st.executeQuery(query);
					if(rs == null && src.equals(dest)) 
					{
						JOptionPane.showMessageDialog(frame, "Sorry no Trains are available");
						frame.setVisible(false);
						new MainPage(u_id).frame.setVisible(true);
					}
					else
					{
						
						rs.last();
						total = rs.getRow();
						rs.beforeFirst();
						train_name = new String [total];
						int i = 0;
						while(rs.next())
						{
							train_name[i++] = rs.getString("Train_name");
						}
						frame.setVisible(false);
						new PassengerDetails(u_id,train_name,no,src,dest,Day).frame.setVisible(true);
					}
				}catch(Exception exmp){}
			}
		});
		btnBookTicket.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBookTicket.setBounds(261, 183, 115, 23);
		frame.getContentPane().add(btnBookTicket);
		
		
	}
}
