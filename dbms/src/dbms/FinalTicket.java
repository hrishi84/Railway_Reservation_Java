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

import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class FinalTicket {

	public JFrame frame;
	static String u_id = "ABC";
	static int tno;
	static String train_name;
	static String src;
	static String dest;
	static int [] pnr;
	static String [] p_name;
	static String [] p_gender;
	static int [] p_age;
	static String url="jdbc:mysql://localhost:3306/mydb?useSSL=false";
	static String uname = "me";
	static String password = "hello";
	static int fare;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FinalTicket window = new FinalTicket(u_id,tno,train_name,src,dest,pnr,p_name,p_gender,p_age);
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
	public FinalTicket(String u_id,int tno,String train_name,String src,String dest,int [] pnr,String [] p_name,String [] p_gender,int [] p_age) {
		this.u_id = u_id;
		this.tno = tno;
		this.train_name = train_name;
		this.src = src;
		this.dest = dest;
		this.pnr = pnr;
		this.p_name = p_name;
		this.p_gender = p_gender;
		this.p_age = p_age;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));//255,255,255
		frame.setBounds(100, 100, 615, 406);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblBookedBy = new JLabel("Booked By ");
		lblBookedBy.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBookedBy.setBounds(20, 41, 92, 27);
		frame.getContentPane().add(lblBookedBy);
		
		JLabel lblTrainNo = new JLabel("Train no ");
		lblTrainNo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTrainNo.setBounds(20, 79, 92, 14);
		frame.getContentPane().add(lblTrainNo);
		
		JLabel lblTrainName = new JLabel("Train Name ");
		lblTrainName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTrainName.setBounds(264, 79, 107, 14);
		frame.getContentPane().add(lblTrainName);
		
		JLabel lblSou = new JLabel("Source ");
		lblSou.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSou.setBounds(20, 110, 81, 14);
		frame.getContentPane().add(lblSou);
		
		JLabel lblDestination = new JLabel("Destination ");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDestination.setBounds(264, 110, 98, 14);
		frame.getContentPane().add(lblDestination);
		
		JLabel lblPassengerDetails = new JLabel("Passenger Details : ");
		lblPassengerDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblPassengerDetails.setBounds(20, 136, 232, 14);
		frame.getContentPane().add(lblPassengerDetails);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblName.setBounds(156, 161, 46, 14);
		frame.getContentPane().add(lblName);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGender.setBounds(424, 161, 46, 14);
		frame.getContentPane().add(lblGender);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblAge.setBounds(513, 160, 46, 17);
		frame.getContentPane().add(lblAge);
		
		JLabel lblPnrNo = new JLabel("PNR NO");
		lblPnrNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPnrNo.setBounds(20, 161, 58, 14);
		frame.getContentPane().add(lblPnrNo);
		
		JTextPane bookedBy = new JTextPane();
		bookedBy.setBounds(103, 41, 227, 20);
		frame.getContentPane().add(bookedBy);
		bookedBy.setEnabled(false);
		bookedBy.setText(u_id);
		
		JTextPane train = new JTextPane();
		train.setBounds(103, 73, 112, 20);
		frame.getContentPane().add(train);
		train.setEnabled(false);
		train.setText(train_name);
		
		JTextPane trainno = new JTextPane();
		trainno.setBounds(355, 73, 227, 20);
		frame.getContentPane().add(trainno);
		trainno.setEnabled(false);
		trainno.setText(String.valueOf(tno));
		
		JTextPane source = new JTextPane();
		source.setBounds(103, 104, 112, 20);
		frame.getContentPane().add(source);
		source.setEnabled(false);
		source.setText(src);
		
		JTextPane desti = new JTextPane();
		desti.setBounds(355, 104, 227, 20);
		frame.getContentPane().add(desti);
		desti.setEnabled(false);
		desti.setText(dest);
		
		JTextPane p1 = new JTextPane();
		p1.setBounds(10, 186, 131, 20);
		frame.getContentPane().add(p1);
		p1.setEnabled(false);
		
		JTextPane p2 = new JTextPane();
		p2.setBounds(10, 216, 131, 20);
		frame.getContentPane().add(p2);
		p2.setEnabled(false);
		
		JTextPane p3 = new JTextPane();
		p3.setBounds(10, 247, 131, 20);
		frame.getContentPane().add(p3);
		p3.setEnabled(false);
		
		JTextPane p4 = new JTextPane();
		p4.setBounds(10, 278, 131, 20);
		frame.getContentPane().add(p4);
		p4.setEnabled(false);
		
		JTextPane p5 = new JTextPane();
		p5.setBounds(10, 309, 131, 20);
		frame.getContentPane().add(p5);
		p5.setEnabled(false);
		
		JTextPane n1 = new JTextPane();
		n1.setBounds(156, 186, 238, 20);
		frame.getContentPane().add(n1);
		n1.setEnabled(false);
		
		JTextPane n2 = new JTextPane();
		n2.setBounds(156, 216, 238, 20);
		frame.getContentPane().add(n2);
		n2.setEnabled(false);
		
		JTextPane n3 = new JTextPane();
		n3.setBounds(156, 247, 238, 20);
		frame.getContentPane().add(n3);
		n3.setEnabled(false);
		
		JTextPane n4 = new JTextPane();
		n4.setBounds(156, 278, 238, 20);
		frame.getContentPane().add(n4);
		n4.setEnabled(false);
		
		JTextPane n5 = new JTextPane();
		n5.setBounds(156, 309, 238, 20);
		frame.getContentPane().add(n5);
		n5.setEnabled(false);
		
		JTextPane g1 = new JTextPane();
		g1.setBounds(412, 186, 58, 20);
		frame.getContentPane().add(g1);
		g1.setEnabled(false);
		
		JTextPane g2 = new JTextPane();
		g2.setBounds(412, 216, 58, 20);
		frame.getContentPane().add(g2);
		g2.setEnabled(false);
		
		JTextPane g3 = new JTextPane();
		g3.setBounds(412, 247, 58, 20);
		frame.getContentPane().add(g3);
		g3.setEnabled(false);
		
		JTextPane g4 = new JTextPane();
		g4.setBounds(412, 278, 58, 20);
		frame.getContentPane().add(g4);
		g4.setEnabled(false);
		
		JTextPane g5 = new JTextPane();
		g5.setBounds(412, 309, 58, 20);
		frame.getContentPane().add(g5);
		g5.setEnabled(false);
		
		JTextPane a1 = new JTextPane();
		a1.setBounds(499, 186, 58, 20);
		frame.getContentPane().add(a1);
		a1.setEnabled(false);
		
		JTextPane a2 = new JTextPane();
		a2.setBounds(499, 216, 58, 20);
		frame.getContentPane().add(a2);
		a2.setEnabled(false);
		
		JTextPane a3 = new JTextPane();
		a3.setBounds(499, 247, 58, 20);
		frame.getContentPane().add(a3);
		a3.setEnabled(false);
		
		JTextPane a4 = new JTextPane();
		a4.setBounds(499, 278, 58, 20);
		frame.getContentPane().add(a4);
		a4.setEnabled(false);
		
		JTextPane a5 = new JTextPane();
		a5.setBounds(499, 309, 58, 20);
		frame.getContentPane().add(a5);
		a5.setEnabled(false);
		
		JLabel label = new JLabel("");
		label.setToolTipText("e-Ticket Reservation Slip");
		label.setBounds(206, 11, 46, 14);
		frame.getContentPane().add(label);
		
		JLabel lblEticketReservation = new JLabel("e-Ticket Reservation ");
		lblEticketReservation.setHorizontalAlignment(SwingConstants.CENTER);
		lblEticketReservation.setFont(new Font("Franklin Gothic Book", Font.BOLD, 18));
		lblEticketReservation.setBounds(187, 11, 259, 19);
		frame.getContentPane().add(lblEticketReservation);
		
		JButton exit = new JButton("Exit");
		exit.setFont(new Font("Tahoma", Font.BOLD, 14));
		exit.setBounds(367, 333, 89, 23);
		frame.getContentPane().add(exit);
		exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
			}
		});
		
		
		JLabel lblTotalFare = new JLabel("Total Fare: ");
		lblTotalFare.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalFare.setBounds(10, 339, 91, 14);
		frame.getContentPane().add(lblTotalFare);
		JTextPane total_fare = new JTextPane();
		total_fare.setBounds(90, 336, 112, 20);
		frame.getContentPane().add(total_fare);
		
		JButton confirm = new JButton("Confirm");
		confirm.setFont(new Font("Tahoma", Font.BOLD, 14));
		confirm.setBounds(470, 333, 112, 23);
		frame.getContentPane().add(confirm);
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rs = null;
				try{
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection(url,uname,password);
					Statement st = conn.createStatement();
					String query = "SELECT Cost FROM Train WHERE Train_no = " + tno;
					rs = st.executeQuery(query);
					rs.next();
					fare = rs.getInt("Cost");
					total_fare.setText(String.valueOf(fare*p_name.length));
				}catch(Exception ex){};
			}
		});
		
		
		for(int i = 0;i < p_name.length;i++)
		{
			switch(i)
			{
			    case 0:	p1.setText(String.valueOf(pnr[i]));
					   	n1.setText(p_name[i]);
					   	g1.setText(p_gender[i]);
					   	a1.setText(String.valueOf(p_age[i]));
					   	break;
			    case 1:	p2.setText(String.valueOf(pnr[i]));
				   		n2.setText(p_name[i]);
				   		g2.setText(p_gender[i]);
				   		a2.setText(String.valueOf(p_age[i]));
				   		break;
			    case 2:	p3.setText(String.valueOf(pnr[i]));
				   		n3.setText(p_name[i]);
				   		g3.setText(p_gender[i]);
				   		a3.setText(String.valueOf(p_age[i]));
				   		break;
			    case 3:	p4.setText(String.valueOf(pnr[i]));
				   		n4.setText(p_name[i]);
				   		g4.setText(p_gender[i]);
				   		a4.setText(String.valueOf(p_age[i]));
				   		break;
			    case 4:	p5.setText(String.valueOf(pnr[i]));
				   		n5.setText(p_name[i]);
				   		g5.setText(p_gender[i]);
				   		a5.setText(String.valueOf(p_age[i]));
				   		break;
			}
		}
	}
}
