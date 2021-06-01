package submission;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Font;

public class student2 {

	public JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JPasswordField passwordField;String gender;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student2 window = new student2(0);
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
	public student2(int x) {
		initialize(x);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int x) {
		frame = new JFrame("Student page");
		frame.getContentPane().setBackground(new Color(64, 224, 208));
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(173, 216, 230));
		tabbedPane.setBounds(0, 28, 1200, 600);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(64, 224, 208));
		tabbedPane.addTab("Update info", null, panel, null);
		panel.setLayout(null);
		
		frame.setUndecorated(true);
		Connection con;
		
		try {
			con = Database.connect();
			
	
			String Query1="select * from students where id="+x;
			PreparedStatement nst=con.prepareStatement(Query1);
			ResultSet rs=nst.executeQuery();
			rs.next();
			JLabel lblNewLabel = new JLabel("Hi, "+rs.getString("Firstname")+rs.getString("Lastname"));
			lblNewLabel.setForeground(new Color(0, 255, 0));
			
			JToolBar toolBar = new JToolBar();
			toolBar.setForeground(new Color(50, 205, 50));
			toolBar.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 12));
			toolBar.setBackground(new Color(0, 128, 128));
			toolBar.setBounds(0, 0, 1160, 31);
			frame.getContentPane().add(toolBar);
			toolBar.add(lblNewLabel);
			toolBar.add(Box.createHorizontalGlue());
			JButton btnNewButton = new JButton("logout");btnNewButton.setFocusPainted(false);
			btnNewButton.setForeground(new Color(128, 0, 0));
			btnNewButton.setBackground(new Color(244, 164, 96));
			toolBar.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
		
					new student().frame.setVisible(true);
				}
			});
			toolBar.add(btnNewButton);
			JLabel label = new JLabel("FirstName");
			label.setHorizontalAlignment(SwingConstants.RIGHT);
			label.setBounds(385, 99, 81, 28);
			panel.add(label);
			
			textField = new JTextField();
			textField.setColumns(10);
			textField.setBounds(476, 99, 114, 28);
			panel.add(textField);textField.setText(rs.getString("Firstname"));
			
			JLabel label_1 = new JLabel("LastName");
			label_1.setHorizontalAlignment(SwingConstants.RIGHT);
			label_1.setBounds(385, 149, 81, 31);
			panel.add(label_1);
			
			textField_1 = new JTextField();
			textField_1.setBounds(476, 150, 114, 28);
			panel.add(textField_1);textField_1.setText(rs.getString("Lastname"));
			
			JLabel label_2 = new JLabel("Phone No");
			label_2.setBounds(416, 322, 81, 31);
			panel.add(label_2);
			
			textField_2 = new JTextField();
			textField_2.setBounds(476, 249, 114, 28);
			panel.add(textField_2);textField_2.setText(rs.getString("mothername"));
			
			JLabel label_3 = new JLabel("FatherName");
			label_3.setHorizontalAlignment(SwingConstants.RIGHT);
			label_3.setBounds(385, 203, 81, 31);
			panel.add(label_3);
			
			textField_3 = new JTextField();
			textField_3.setBounds(476, 204, 114, 28);
			panel.add(textField_3);textField_3.setText(rs.getString("fathername"));
			
			JLabel label_4 = new JLabel("MotherName");
			label_4.setHorizontalAlignment(SwingConstants.RIGHT);
			label_4.setPreferredSize(new Dimension(150, 23));
			label_4.setBounds(344, 248, 116, 31);
			panel.add(label_4);
			
			textField_4 = new JTextField();
			textField_4.setBounds(476, 326, 114, 23);
			panel.add(textField_4);textField_4.setText(rs.getString("phone"));
			
			JRadioButton radioButton = new JRadioButton("Male");
			radioButton.setBackground(new Color(135, 206, 235));
			radioButton.setBounds(476, 292, 54, 23);
			panel.add(radioButton);
			
			JRadioButton radioButton_1 = new JRadioButton("Female");
			radioButton_1.setBackground(new Color(135, 206, 235));
			radioButton_1.setBounds(528, 292, 109, 23);
			panel.add(radioButton_1);
			 ButtonGroup G1=new  ButtonGroup();
			 G1.add(radioButton);G1.add(radioButton_1);
			 
			 if(rs.getString("gender").equals("Male")) { radioButton.setSelected(true);}else radioButton_1.setSelected(true);
			JLabel label_5 = new JLabel("Gender");
			label_5.setBounds(428, 290, 54, 23);
			panel.add(label_5);
			
			JLabel label_6 = new JLabel("Email-Id");
			label_6.setBounds(426, 368, 46, 14);
			panel.add(label_6);
			
			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(476, 364, 114, 23);
			panel.add(textField_5);textField_5.setText(rs.getString("email"));
			
			JLabel lblNewLabel_1 = new JLabel("Registration No");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_1.setBounds(58, 32, 96, 26);
			panel.add(lblNewLabel_1);
			
			JLabel lblNewLabel_2 = new JLabel("Password");
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_2.setBounds(391, 52, 71, 24);
			
			
			JButton btnNewButton_1 = new JButton("Update");
			btnNewButton_1.setBackground(Color.WHITE);
			
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 if(radioButton.isSelected()) {
							gender="Male";}
							 else if(radioButton_1.isSelected()) {gender="Female";}
					String Query3="UPDATE students SET Lastname='"+textField_1.getText()+"' ,password='"+passwordField.getText()+"' ,gender='"+gender+"' ,phone='"+textField_4.getText()+"' ,email='"+textField_5.getText()+"' ,Firstname='"+textField.getText()+"' ,fathername='"+textField_3.getText()+"' ,mothername='"+textField_2.getText()+"' where id="+x;
					System.out.println(Query3);
					
					PreparedStatement xst;		
					try {
						xst = con.prepareStatement(Query3);
			
						xst.executeUpdate();
						 
					        JOptionPane.showMessageDialog(null, "Updated successfully","", JOptionPane.PLAIN_MESSAGE);frame.dispose();
					        new student2(x).frame.setVisible(true);
					} catch (SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				}
			});
			btnNewButton_1.setBounds(771, 381, 89, 23);
			panel.add(btnNewButton_1);
			
			JLabel lblNewLabel_3 = new JLabel("Password");
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_3.setBounds(401, 55, 65, 28);
			panel.add(lblNewLabel_3);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(476, 51, 116, 28);
			panel.add(passwordField);passwordField.setText(rs.getString("password"));
			
			JLabel lblNewLabel_4 = new JLabel((rs.getString("id")));
			lblNewLabel_4.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_4.setBounds(164, 35, 96, 20);
			panel.add(lblNewLabel_4);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(135, 206, 250));
			panel_1.setBounds(385, 89, 252, 330);
			panel.add(panel_1);
			
			JLabel lblNewLabel_5 = new JLabel("Year");
			lblNewLabel_5.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_5.setBounds(79, 69, 75, 14);
			panel.add(lblNewLabel_5);
			
			JLabel lblNewLabel_6 = new JLabel((rs.getString("year")));
			lblNewLabel_6.setBounds(164, 68, 65, 17);
			panel.add(lblNewLabel_6);
			
			JLabel lblNewLabel_7 = new JLabel("Group");
			lblNewLabel_7.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_7.setBounds(108, 99, 46, 14);
			panel.add(lblNewLabel_7);
			
			JLabel lblNewLabel_8 = new JLabel((rs.getString("Grp")));
			lblNewLabel_8.setHorizontalAlignment(SwingConstants.LEFT);
			lblNewLabel_8.setBounds(164, 99, 75, 14);
			panel.add(lblNewLabel_8);
			
			JButton btnNewButton_2 = new JButton("X");
			btnNewButton_2.setHorizontalAlignment(SwingConstants.RIGHT);
			btnNewButton_2.setBounds(1114, 0, 29, 23);
			frame.getContentPane().add(btnNewButton_2);
			
			JButton btnNewButton_3 = new JButton("x");
			btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
				}
			});
			btnNewButton_3.setBackground(new Color(255, 69, 0));
			btnNewButton_3.setForeground(new Color(0, 0, 0));
			btnNewButton_3.setBounds(1159, 0, 41, 23);
			frame.getContentPane().add(btnNewButton_3);
			
		} catch (Exception e1) {
			// TODO Auto-generated catch blo
			e1.printStackTrace();
		}
		
	}
}
