package submission;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Faclog2 {
String name,regat;int regid;
	public JFrame frame;
	JTextField textField;
	String insert,gender,group,year,sem,firstname,lastname,fname,mname,pno,eid;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Faclog2 window = new Faclog2(0);
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
	public Faclog2(int y) {
		initialize(y);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(int x) {
		frame = new JFrame("Faculty Page");
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setUndecorated(true);
		JButton btnNewButton_3 = new JButton("x");
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		btnNewButton_3.setBackground(new Color(255, 0, 0));
		btnNewButton_3.setForeground(new Color(0, 0, 0));
		btnNewButton_3.setBounds(1159, 0, 41, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		
		Connection con;
		try {
			con = Database.connect();
		
	
			String Query1="select * from faculty where id="+x;
			PreparedStatement nst=con.prepareStatement(Query1);
			ResultSet rs=nst.executeQuery();
			rs.next();
			JLabel lblNewLabel = new JLabel("Hello  Mr."+rs.getString("username"));
			lblNewLabel.setForeground(new Color(0, 255, 0));
			name=rs.getString("username");
			JToolBar toolBar = new JToolBar();	toolBar.setBackground(new Color(0, 139, 139));
			toolBar.setBounds(0, 0, 1160, 31);
			frame.getContentPane().add(toolBar);
			toolBar.add(lblNewLabel);
			toolBar.add(Box.createHorizontalGlue());
			JButton btnNewButton = new JButton("logout");btnNewButton.setFocusPainted(false);
			btnNewButton.setBackground(new Color(255, 127, 80));
			toolBar.add(btnNewButton);
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					frame.dispose();
		
					new Faclog1().frame.setVisible(true);
				}
			});
			toolBar.add(btnNewButton);
	
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 32, 1200, 600);
		frame.getContentPane().add(tabbedPane);
		
		//
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(135, 206, 235));
		panel1.setForeground(new Color(135, 206, 235));
		panel1.setLayout(null);
		tabbedPane.addTab("Register for a student", null, panel1, null);
		JLabel lblNewLabel_9 = new JLabel("FirstName");
		lblNewLabel_9.setBounds(450, 25, 81, 28);
		panel1.add(lblNewLabel_9);
		JTextField textField1=new JTextField();
		textField1.setBounds(510, 25, 114, 28);
		panel1.add(textField1);
		textField1.setColumns(10);
	
		JLabel lblNewLabel_8= new JLabel("LastName");
		lblNewLabel_8.setBounds(450, 67, 81, 31);
		panel1.add(lblNewLabel_8);
		JTextField textField2 = new JTextField();
		textField2.setBounds(510, 64, 114, 28);
		panel1.add(textField2);
		
		JLabel lblNewLabel_7= new JLabel("Phone No");
		lblNewLabel_7.setBounds(450, 228, 81, 31);
		panel1.add(lblNewLabel_7);
		JTextField textField3 = new JTextField();
		textField3.setBounds(510, 155, 114, 28);
		panel1.add(textField3);
		
		JLabel lblNewLabel_6= new JLabel("FatherName");
		lblNewLabel_6.setBounds(435, 109, 81, 31);
		panel1.add(lblNewLabel_6);
		JTextField  textField4= new JTextField();
		textField4.setBounds(510, 110, 114, 28);
		panel1.add(textField4);
		
		JLabel lblNewLabel_5= new JLabel("MotherName");
		lblNewLabel_5.setPreferredSize(new Dimension(150,23));
		lblNewLabel_5.setBounds(435, 154, 116, 31);
		panel1.add(lblNewLabel_5);
		JTextField textField5 = new JTextField();
		textField5.setBounds(510, 232, 114, 23);
		panel1.add(textField5);
		
		JButton btnNewButton_2 = new JButton("Register");
		
		btnNewButton_2.setBounds(733, 401, 89, 23);
		panel1.add(btnNewButton_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Male");
		rdbtnNewRadioButton.setBackground(new Color(135, 206, 235));
		rdbtnNewRadioButton.setBounds(510, 198, 54, 23);
		panel1.add(rdbtnNewRadioButton);
JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Female");
rdbtnNewRadioButton_1.setBackground(new Color(135, 206, 235));
		rdbtnNewRadioButton_1.setBounds(562, 198, 109, 23);
		panel1.add(rdbtnNewRadioButton_1);
		 ButtonGroup G1=new  ButtonGroup();
		 G1.add(rdbtnNewRadioButton);G1.add(rdbtnNewRadioButton_1);
JLabel lblNewLabel_1 = new JLabel("Gender");
lblNewLabel_1.setBounds(462, 196, 54, 23);
panel1.add(lblNewLabel_1);
JLabel lblNewLabel_2 = new JLabel("Email-Id");
lblNewLabel_2.setBounds(460, 274, 46, 14);
panel1.add(lblNewLabel_2);
textField = new JTextField();
textField.setBounds(510, 270, 114, 23);
panel1.add(textField);
textField.setColumns(10);
JLabel lblNewLabel_3 = new JLabel("Year");
lblNewLabel_3.setBounds(477, 315, 54, 23);
panel1.add(lblNewLabel_3);
JComboBox comboBox = new JComboBox();
comboBox.setBounds(515, 315, 109, 22);
panel1.add(comboBox);
comboBox.addItem("1st_Year");comboBox.addItem("2nd_Year");comboBox.addItem("3rd_Year");comboBox.addItem("4th_Year");
JLabel lblNewLabel_4 = new JLabel("Group");
lblNewLabel_4.setBounds(460, 359, 56, 22);
panel1.add(lblNewLabel_4);
JComboBox comboBox_1 = new JComboBox();
comboBox_1.setBounds(510, 359, 109, 22);
panel1.add(comboBox_1);comboBox_1.addItem("CSE");comboBox_1.addItem("ECE");
comboBox_1.addItem("EEE");comboBox_1.addItem("Civil");comboBox_1.addItem("Mech");comboBox_1.addItem("Bio-Tech");
JLabel lblNewLabel_10 = new JLabel("Semester");
lblNewLabel_10.setBounds(435, 401, 78, 23);
panel1.add(lblNewLabel_10);
JComboBox comboBox_2 = new JComboBox();
comboBox_2.setBounds(510, 401, 114, 22);
panel1.add(comboBox_2);
comboBox_2.addItem("1st_Sem");comboBox_2.addItem("2nd_Sem");
JPanel panel_1 = new JPanel();
panel_1.setBackground(new Color(135, 206, 235));
panel_1.setBounds(421, 11, 301, 418);
panel1.add(panel_1);
JPanel panel = new JPanel();

JTable table = new JTable();
JScrollPane scrollPane_1 = new JScrollPane();
scrollPane_1.setBounds(129, 30, 1055, 450);

scrollPane_1.setViewportView(table);
try {
	Connection coc=Database.connect();
	String Query="select id,Firstname,Lastname,fathername,mothername,year,Grp,sem,regat,regby from students where regby=(select username from faculty where id="+x+")";
	PreparedStatement pst=coc.prepareStatement(Query);
	ResultSet rs2=pst.executeQuery();table.setModel(DbUtils.resultSetToTableModel(rs2));
} catch (Exception e2) {
	// TODO Auto-generated catch block
	e2.printStackTrace();
}

	
	tabbedPane.addTab("View Registered Students", null,  scrollPane_1 , null);
	

	
	JPanel panel_2 = new JPanel();
	panel_2.setBackground(new Color(135, 206, 235));
	tabbedPane.addTab("Update info", null, panel_2, null);
	panel_2.setLayout(null);
	
	JLabel label = new JLabel("Username");
	label.setHorizontalAlignment(SwingConstants.RIGHT);
	label.setBounds(315, 90, 81, 28);
	panel_2.add(label);
	
	textField_1 = new JTextField();
	textField_1.setText(rs.getString("username"));
	textField_1.setColumns(10);
	textField_1.setBounds(415, 93, 114, 23);
	panel_2.add(textField_1);
	
	passwordField = new JPasswordField();
	passwordField.setText(rs.getString("password"));
	passwordField.setBounds(415, 130, 114, 23);
	panel_2.add(passwordField);
	
	JLabel label_1 = new JLabel("password");
	label_1.setHorizontalAlignment(SwingConstants.RIGHT);
	label_1.setBounds(315, 126, 81, 31);
	panel_2.add(label_1);
	
	JButton button = new JButton("Update");
	button.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String Query3="UPDATE faculty SET username='"+textField_1.getText()+"' ,password='"+passwordField.getText()+"' ,phone='"+textField_2.getText()+"' ,email='"+textField_3.getText()+"' ,Name='"+textField_4.getText()+"' ,dept='"+textField_5.getText()+"' where id="+x;
			System.out.println(Query3);
			
			PreparedStatement xst;		
			try {
				xst = con.prepareStatement(Query3);
	
				xst.executeUpdate();
				 
			        JOptionPane.showMessageDialog(null, "Updated successfully","", JOptionPane.PLAIN_MESSAGE);frame.dispose();
			        new Faclog2(x).frame.setVisible(true);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	});
	button.setBounds(440, 336, 89, 23);
	panel_2.add(button);
	
	JLabel label_2 = new JLabel("Phone no");
	label_2.setHorizontalAlignment(SwingConstants.RIGHT);
	label_2.setBounds(315, 243, 81, 18);
	panel_2.add(label_2);
	
	JLabel label_3 = new JLabel("Email");
	label_3.setHorizontalAlignment(SwingConstants.RIGHT);
	label_3.setBounds(336, 285, 60, 23);
	panel_2.add(label_3);
	
	textField_2 = new JTextField();
	textField_2.setText(rs.getString("phone"));
	textField_2.setColumns(10);
	textField_2.setBounds(415, 243, 114, 23);
	panel_2.add(textField_2);
	
	textField_3 = new JTextField();
	textField_3.setText(rs.getString("email"));
	textField_3.setColumns(10);
	textField_3.setBounds(415, 285, 114, 22);
	panel_2.add(textField_3);
	
	textField_4 = new JTextField(rs.getString("Name"));
	textField_4.setBounds(415, 169, 114, 23);
	panel_2.add(textField_4);
	textField_4.setColumns(10);
	
	textField_5 = new JTextField(rs.getString("dept"));
	textField_5.setBounds(415, 207, 114, 23);
	panel_2.add(textField_5);
	textField_5.setColumns(10);
	
	JLabel lblNewLabel_11 = new JLabel("Name");
	lblNewLabel_11.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_11.setBounds(349, 178, 46, 14);
	panel_2.add(lblNewLabel_11);
	
	JLabel lblNewLabel_12 = new JLabel("Department");
	lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_12.setBounds(281, 207, 114, 18);
	panel_2.add(lblNewLabel_12);



		 
	
		 btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					  if ( textField.getText().isEmpty()||textField1.getText().isEmpty()||textField2.getText().isEmpty()||textField3.getText().isEmpty()||textField4.getText().isEmpty()||textField5.getText().isEmpty()) {
						  JOptionPane.showMessageDialog(null, "Fields cannot be empty");
							
					  }else
				
						
					
					
					 try {
					 firstname=textField1.getText();lastname=textField2.getText();
					 fname=textField4.getText();mname=textField3.getText();pno=textField5.getText();eid=textField.getText();
					 
						 if(rdbtnNewRadioButton.isSelected()) {
								gender="Male";}
								 else if(rdbtnNewRadioButton_1.isSelected()) {gender="Female";} else gender="others";
						 year=comboBox.getSelectedItem().toString();
						group=comboBox_1.getSelectedItem().toString();
						sem=comboBox_2.getSelectedItem().toString();
						System.out.println(year);
						 insert="INSERT INTO swing.students (Firstname,Lastname,fathername,mothername,phone,email,gender,year,Grp,sem,regby) VALUES ('"+firstname+"','"+lastname+"','"+fname+"','"+mname+"','"+pno+"','"+eid+"','"+gender+"','"+year+"','"+group+"','"+sem+"','"+rs.getString("username")+"')";
						 System.out.println(insert);
						 
						Connection con2=Database.connect();
						PreparedStatement addstd=con2.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS );
						addstd.executeUpdate(); ResultSet rx=addstd.getGeneratedKeys();rx.next();regid=rx.getInt(1);
						
						 //new Faclog2(x).frame.setVisible(true);
						frame.dispose();
						new Faclog2(x).frame.setVisible(true);
						new regda(regid).frame.setVisible(true);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
			
					  
					}
				
			}   );
		
		
		
		
		
		
			//
		
		}catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}




	

}	
}
