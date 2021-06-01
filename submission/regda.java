package submission;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Dimension;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class regda {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regda window = new regda(0);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public regda(int y) throws Exception {
		initialize(y);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Exception 
	 */
	private void initialize(int y) throws Exception {
		frame = new JFrame("Registered Successfully");frame.setUndecorated(true);
		frame.getContentPane().setBackground(new Color(220, 220, 220));
		frame.setBounds(450,110,500 ,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
	Connection con = Database.connect();
		
		
		String Query1="select * from students where id="+y;
		PreparedStatement nst=con.prepareStatement(Query1);
		ResultSet rt=nst.executeQuery();
		rt.next();

		
		JLabel label = new JLabel("FullName :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setBounds(169, 56, 81, 28);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel(rt.getString("firstname")+" "+rt.getString("lastname"));
		label_1.setHorizontalAlignment(SwingConstants.LEFT);
		label_1.setBounds(266, 56, 114, 28);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("Reg No :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setBounds(169, 26, 81, 31);
		frame.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel(rt.getString("id"));
		label_3.setHorizontalAlignment(SwingConstants.LEFT);
		label_3.setBounds(266, 27, 114, 28);
		frame.getContentPane().add(label_3);
		
		JLabel label_4 = new JLabel("Phone No :");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(169, 175, 81, 31);
		frame.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel(rt.getString("phone"));
		label_5.setHorizontalAlignment(SwingConstants.LEFT);
		label_5.setBounds(266, 176, 114, 28);
		frame.getContentPane().add(label_5);
		
		JLabel label_6 = new JLabel("FatherName :");
		label_6.setHorizontalAlignment(SwingConstants.RIGHT);
		label_6.setBounds(169, 84, 81, 31);
		frame.getContentPane().add(label_6);
		
		JLabel label_7 = new JLabel(rt.getString("fathername"));
		label_7.setHorizontalAlignment(SwingConstants.LEFT);
		label_7.setBounds(266, 85, 114, 28);
		frame.getContentPane().add(label_7);
		
		JLabel label_8 = new JLabel("MotherName :");
		label_8.setPreferredSize(new Dimension(150, 23));
		label_8.setHorizontalAlignment(SwingConstants.RIGHT);
		label_8.setBounds(134, 113, 116, 31);
		frame.getContentPane().add(label_8);
		
		JLabel label_9 = new JLabel(rt.getString("mothername"));
		label_9.setHorizontalAlignment(SwingConstants.LEFT);
		label_9.setBounds(266, 117, 114, 23);
		frame.getContentPane().add(label_9);
		
		JLabel label_10 = new JLabel("Gender :");
		label_10.setHorizontalAlignment(SwingConstants.RIGHT);
		label_10.setBounds(196, 145, 54, 23);
		frame.getContentPane().add(label_10);
		
		JLabel label_11 = new JLabel(rt.getString("gender"));
		label_11.setHorizontalAlignment(SwingConstants.LEFT);
		label_11.setBounds(266, 145, 68, 23);
		frame.getContentPane().add(label_11);
		
		JLabel label_12 = new JLabel("Email-Id :");
		label_12.setHorizontalAlignment(SwingConstants.RIGHT);
		label_12.setBounds(189, 213, 61, 23);
		frame.getContentPane().add(label_12);
		
		JLabel label_13 = new JLabel(rt.getString("email"));
		label_13.setHorizontalAlignment(SwingConstants.LEFT);
		label_13.setBounds(266, 213, 114, 23);
		frame.getContentPane().add(label_13);
		
		JLabel label_14 = new JLabel("Year :");
		label_14.setHorizontalAlignment(SwingConstants.RIGHT);
		label_14.setBounds(196, 249, 54, 23);
		frame.getContentPane().add(label_14);
		
		JLabel label_15 = new JLabel("Registered by :");
		label_15.setHorizontalAlignment(SwingConstants.RIGHT);
		label_15.setBounds(0, 433, 109, 22);
		frame.getContentPane().add(label_15);
		
		JLabel label_16 = new JLabel("Group :");
		label_16.setHorizontalAlignment(SwingConstants.RIGHT);
		label_16.setBounds(194, 283, 56, 22);
		frame.getContentPane().add(label_16);
		
		JLabel label_17 = new JLabel(rt.getString("Grp"));
		label_17.setHorizontalAlignment(SwingConstants.LEFT);
		label_17.setBounds(266, 283, 109, 22);
		frame.getContentPane().add(label_17);
		
		JLabel label_18 = new JLabel("Semester :");
		label_18.setHorizontalAlignment(SwingConstants.RIGHT);
		label_18.setBounds(172, 316, 78, 23);
		frame.getContentPane().add(label_18);
		
		JLabel label_19 = new JLabel(rt.getString("sem"));
		label_19.setHorizontalAlignment(SwingConstants.LEFT);
		label_19.setBounds(266, 316, 114, 22);
		frame.getContentPane().add(label_19);
		
		JLabel label_20 = new JLabel("Registration time :");
		label_20.setHorizontalAlignment(SwingConstants.RIGHT);
		label_20.setBounds(0, 399, 109, 23);
		frame.getContentPane().add(label_20);
		
		JLabel label_21 = new JLabel(rt.getString("year"));
		label_21.setHorizontalAlignment(SwingConstants.LEFT);
		label_21.setBounds(266, 251, 68, 14);
		frame.getContentPane().add(label_21);
		
		JLabel label_22 = new JLabel(rt.getString("regat"));
		label_22.setBounds(119, 396, 161, 29);
		frame.getContentPane().add(label_22);
		
		JLabel label_23 = new JLabel(rt.getString("regby"));
		label_23.setBounds(120, 433, 95, 23);
		frame.getContentPane().add(label_23);
		
		JButton btnNewButton = new JButton("Close");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton.setBounds(290, 421, 89, 23);
		frame.getContentPane().add(btnNewButton);
	}
}
