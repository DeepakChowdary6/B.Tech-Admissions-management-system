package submission;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import java.awt.Color;

public class student {

	public JFrame frame;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					student window = new student();
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
	public student() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Student Login");
		frame.setBounds(100, 100, 1200, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(new Color(0, 191, 255));
		frame.setUndecorated(true);
		JButton btnNewButton_3 = new JButton("X");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton_3.setBackground(Color.RED);
				frame.dispose();
			}
		});
		btnNewButton_3.setBackground(new Color(0, 191, 255));
		btnNewButton_3.setForeground(Color.BLACK);
		btnNewButton_3.setBounds(1155, 0, 45, 23);
		frame.getContentPane().add(btnNewButton_3);
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(530, 164, 114, 28);
		frame.getContentPane().add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(530, 213, 114, 28);
		frame.getContentPane().add(passwordField);
		
		JLabel label = new JLabel("Username");
		label.setBounds(464, 164, 81, 28);
		frame.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setBounds(464, 212, 81, 31);
		frame.getContentPane().add(label_1);
		
		JButton button = new JButton("Login");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
String password=passwordField.getText();
				
				try {
					Connection con=Database.connect();
					String check="select * from students where id=? and password=?";
					PreparedStatement checkStmt=con.prepareStatement(check);int col=1;
					checkStmt.setString(col++,textField.getText());
					checkStmt.setString(col++,password);
					ResultSet checkResult=checkStmt.executeQuery();
					
					if(checkResult.next()) {	
						int y=checkResult.getInt("id");
						
				 frame.dispose();
				new student2(y).frame.setVisible(true);
					}else {
						JOptionPane.showMessageDialog(null, "Invalid username or password");
		
				} }catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
			}
		});
		button.setBounds(573, 275, 89, 23);
		frame.getContentPane().add(button);
		
		JButton button_1 = new JButton("Back");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {frame.dispose();
				new Home().frame.setVisible(true);
			}
		});
		button_1.setBounds(442, 275, 89, 23);
		frame.getContentPane().add(button_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(student.class.getResource("/submission/images/student login.jpg")));
		lblNewLabel.setBounds(202, 151, 224, 184);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 191, 255));
		panel.setBounds(187, 131, 518, 243);
		frame.getContentPane().add(panel);
	}
}
