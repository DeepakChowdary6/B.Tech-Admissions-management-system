package submission;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollBar;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JToolBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import java.awt.GridBagLayout;
/*import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;*/

import net.proteanit.sql.DbUtils;

import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

public class Adminlog2 {

	public JFrame frame;
	
	private JTextField textField;
	private JTextField textField1,textField2,textField3;
	private JPasswordField passwordField;
	private JPasswordField passwordField1,passwordField2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Adminlog2 window = new Adminlog2(0);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws SQLException 
	 */
	public Adminlog2(int y) throws SQLException {
		initialize(y);
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 */
	private void initialize(int x) throws SQLException {
	
		
		frame = new JFrame("Admin page");
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
		
	
			String Query1="select * from admin where id="+x;
			PreparedStatement nst=con.prepareStatement(Query1);
			ResultSet rs=nst.executeQuery();
			rs.next();
			JLabel lblNewLabel = new JLabel("Hello "+rs.getString("username"));
			lblNewLabel.setForeground(new Color(0, 255, 0));
			JToolBar toolBar = new JToolBar();
			toolBar.setBackground(new Color(0, 128, 128));
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
		
					new Adminlog1().frame.setVisible(true);
				}
			});
			toolBar.add(btnNewButton);
		
			
		
			
			JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
			tabbedPane.setBackground(new Color(64, 224, 208));
			tabbedPane.setBounds(0, 32, 1200, 600);
			frame.getContentPane().add(tabbedPane);
			 ButtonGroup G1=new  ButtonGroup();
				
				JTable table = new JTable();
				JScrollPane scrollPane_1 = new JScrollPane();
				scrollPane_1.setBounds(129, 30, 1055, 450);
			
				scrollPane_1.setViewportView(table);
			
					String Query="select * from faculty";
					PreparedStatement pst=con.prepareStatement(Query);
					ResultSet rs2=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs2));
					tabbedPane.addTab("View Faculty", null,  scrollPane_1 , null);
					
					JTable table1= new JTable();
					JScrollPane scrollPane_2 = new JScrollPane();
					scrollPane_2.setBounds(129, 30, 1055, 450);
				
					scrollPane_2.setViewportView(table1);
				
						String Query2="select * from students";
						PreparedStatement pst1=con.prepareStatement(Query2);
						ResultSet rs3=pst1.executeQuery();
						table1.setModel(DbUtils.resultSetToTableModel(rs3));
						tabbedPane.addTab("View Students", null,  scrollPane_2 , null);
						
						
						
						
						
						
							//
							JPanel panel = new JPanel();
							panel.setBackground(new Color(135, 206, 235));
							
							panel.setLayout(null);
							JLabel lblNewLabel_1 = new JLabel("Username");
							lblNewLabel_1.setBounds(480, 147, 81, 28);
							panel.add(lblNewLabel_1);
							
							textField = new JTextField();
							textField.setBounds(546, 147, 114, 28);
							panel.add(textField);
							textField.setColumns(10);
							
								
								passwordField = new JPasswordField();
								passwordField.setBounds(546, 196, 114, 28);
								panel.add(passwordField);
								JLabel lblNewLabel_2 = new JLabel("password");
								lblNewLabel_2.setBounds(480, 195, 81, 31);
								panel.add(lblNewLabel_2);
								passwordField.setText(rs.getString("password"));
								textField.setText(rs.getString("username"));
								JButton btnNewButton_1 = new JButton("Save");
								btnNewButton_1.setBounds(571, 336, 89, 23);
								panel.add(btnNewButton_1);
								tabbedPane.addTab("Edit profile", null, panel, null);
								JLabel lblNewLabel_3 = new JLabel("Phone no");
								lblNewLabel_3.setBounds(480, 252, 60, 14);
								panel.add(lblNewLabel_3);
								JLabel lblNewLabel_4 = new JLabel("Email");
								lblNewLabel_4.setBounds(501, 284, 60, 23);
								panel.add(lblNewLabel_4);
								JTextField textField_p = new JTextField();
								textField_p.setBounds(546, 243, 114, 23);
								panel.add(textField_p);
								textField_p.setText(rs.getString("phone"));
								textField_p.setColumns(10);
								JTextField textField_e = new JTextField();
								textField_e.setText(rs.getString("email"));
								textField_e.setBounds(546, 285, 114, 22);
								panel.add(textField_e);
								textField_e.setColumns(10);
								
								//
								JPanel panel1 = new JPanel();
								panel1.setBackground(new Color(64, 224, 208));
								panel1.setLayout(null);
								tabbedPane.addTab("Add user", null, panel1, null);
								JLabel lblNewLabel_9 = new JLabel("Username");
								lblNewLabel_9.setBounds(480, 70, 81, 28);
								panel1.add(lblNewLabel_9);
								textField1=new JTextField();
								textField1.setBounds(546, 70, 114, 28);
								panel1.add(textField1);
								textField1.setColumns(10);
								
									JLabel lblNewLabel_8= new JLabel("phone no");
									lblNewLabel_8.setBounds(480, 120, 81, 31);
									panel1.add(lblNewLabel_8);
									textField2 = new JTextField();
									textField2.setBounds(546, 120, 114, 28);
									panel1.add(textField2);
									
									JLabel lblNewLabel_7= new JLabel("email-Id");
									lblNewLabel_7.setBounds(480, 170, 81, 31);
									panel1.add(lblNewLabel_7);
									textField3 = new JTextField();
									textField3.setBounds(546, 170, 114, 28);
									panel1.add(textField3);
									
									JLabel lblNewLabel_6= new JLabel("Password");
									lblNewLabel_6.setBounds(480, 220, 81, 31);
									panel1.add(lblNewLabel_6);
									passwordField1 = new JPasswordField();
									passwordField1.setBounds(546, 220, 114, 28);
									panel1.add(passwordField1);
									
									JLabel lblNewLabel_5= new JLabel("Confirm Password");
									lblNewLabel_5.setPreferredSize(new Dimension(150,23));
									lblNewLabel_5.setBounds(435, 269, 116, 31);
									panel1.add(lblNewLabel_5);
									passwordField2 = new JPasswordField();
									passwordField2.setBounds(546, 270, 114, 28);
									panel1.add(passwordField2);
									
									JButton btnNewButton_2 = new JButton("ADD");
									
									btnNewButton_2.setBounds(546, 412, 89, 23);
									panel1.add(btnNewButton_2);
									
									JRadioButton rdbtnNewRadioButton = new JRadioButton("Faculty");
									rdbtnNewRadioButton.setBackground(new Color(64, 224, 208));
									rdbtnNewRadioButton.setBounds(546, 325, 109, 23);
									panel1.add(rdbtnNewRadioButton);
									JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Admin");
									rdbtnNewRadioButton_1.setBackground(new Color(64, 224, 208));
									rdbtnNewRadioButton_1.setBounds(546, 349, 109, 23);
									panel1.add(rdbtnNewRadioButton_1);
									G1.add(rdbtnNewRadioButton);
									G1.add(rdbtnNewRadioButton_1);
									JPanel panel_1 = new JPanel();
									panel_1.setBackground(new Color(64, 224, 208));
									panel_1.setBounds(421, 59, 308, 376);
									panel1.add(panel_1);
									
		
									btnNewButton_2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						  if ( textField1.getText().isEmpty()||textField2.getText().isEmpty()||textField3.getText().isEmpty()||passwordField1.getText().isEmpty()||passwordField2.getText().isEmpty()) {
							  JOptionPane.showMessageDialog(null, "Fields cannot be empty");
								
						  }else
						if(passwordField1.getText().equals(passwordField2.getText())) {
							
						
						
						 try {String insert;
							 if(rdbtnNewRadioButton.isSelected()) {
									insert="insert into faculty (username,phone,email,password) values (?,?,?,?)";}
									 else if(rdbtnNewRadioButton_1.isSelected()) {insert="insert into admin (username,phone,email,password) values (?,?,?,?)";}
									 else insert=null;
							 if(insert!=null) {
							Connection con=Database.connect();
							PreparedStatement addusr=con.prepareStatement(insert);int col=1;
							addusr.setString(col++,textField1.getText());
							addusr.setString(col++,textField2.getText());
							addusr.setString(col++,textField3.getText());
							String pwd=passwordField1.getText();
							addusr.setString(col++,pwd);
							addusr.executeUpdate();
							 JOptionPane.showMessageDialog(null, "New user Added Successfully","", JOptionPane.PLAIN_MESSAGE);
							 frame.dispose();
							 new Adminlog2(x).frame.setVisible(true);}else JOptionPane.showMessageDialog(null, "select Faculty or Admin");
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						}else JOptionPane.showMessageDialog(null, "Enter password again");
				
						  
						}
					
				}   );
				
			
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						
						String Query3="UPDATE admin SET username='"+textField.getText()+"' ,password='"+passwordField.getText()+"' ,phone='"+textField_p.getText()+"' ,email='"+textField_e.getText()+"' where id="+x;
						System.out.println(Query3);
						
						PreparedStatement xst;		
						try {
							xst = con.prepareStatement(Query3);
				
							xst.executeUpdate();
							 
						        JOptionPane.showMessageDialog(null, "Updated successfully","", JOptionPane.PLAIN_MESSAGE);
						} catch (SQLException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
				
						
					}
				});
			
				
		
			

				
			 
			
			
			
	
		
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		
		
		
	
		
	
		
	}		
	
}
