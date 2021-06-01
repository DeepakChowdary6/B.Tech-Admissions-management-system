package submission;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;

public class regdata extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					regdata frame = new regdata(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public regdata(int y) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		Connection con = Database.connect();
		
		
		String Query1="select * from students where id="+y;
		PreparedStatement nst=con.prepareStatement(Query1);
		ResultSet rt=nst.executeQuery();
		rt.next();
		 JPanel panel2=new JPanel();
		 panel2.setLayout(null);
			contentPane.add(panel2);
			JLabel lblNewLabel_90 = new JLabel("FullName :");
			lblNewLabel_90.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_90.setBounds(408, 71, 81, 28);
			panel2.add(lblNewLabel_90);
			JLabel textField01=new JLabel(rt.getString("firstname")+" "+rt.getString("lastname"));
			textField01.setHorizontalAlignment(SwingConstants.LEFT);
			textField01.setBounds(505, 71, 114, 28);
			panel2.add(textField01);
	
		
			JLabel lblNewLabel_80= new JLabel("Reg No :");
			lblNewLabel_80.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_80.setBounds(408, 41, 81, 31);
			panel2.add(lblNewLabel_80);
			JLabel textField02 = new JLabel(rt.getString("id"));
			textField02.setHorizontalAlignment(SwingConstants.LEFT);
			textField02.setBounds(505, 42, 114, 28);
			panel2.add(textField02);
			
			JLabel lblNewLabel_70= new JLabel("Phone No :");
			lblNewLabel_70.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_70.setBounds(408, 190, 81, 31);
			panel2.add(lblNewLabel_70);
			JLabel textField03 = new JLabel(rt.getString("phone"));
			textField03.setHorizontalAlignment(SwingConstants.LEFT);
			textField03.setBounds(505, 191, 114, 28);
			panel2.add(textField03);
			
			JLabel lblNewLabel_60= new JLabel("FatherName :");
			lblNewLabel_60.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_60.setBounds(408, 99, 81, 31);
			panel2.add(lblNewLabel_60);
			JLabel  textField04= new JLabel(rt.getString("fathername"));
			textField04.setHorizontalAlignment(SwingConstants.LEFT);
			textField04.setBounds(505, 100, 114, 28);
			panel2.add(textField04);
			
			JLabel lblNewLabel_50= new JLabel("MotherName :");
			lblNewLabel_50.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel_50.setPreferredSize(new Dimension(150,23));
			lblNewLabel_50.setBounds(373, 128, 116, 31);
			panel2.add(lblNewLabel_50);
			JLabel textField05 = new JLabel(rt.getString("mothername"));
			textField05.setHorizontalAlignment(SwingConstants.LEFT);
			textField05.setBounds(505, 132, 114, 23);
			panel2.add(textField05);
			
			
	JLabel lblNewLabel_12 = new JLabel("Gender :");
	lblNewLabel_12.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_12.setBounds(435, 160, 54, 23);
	panel2.add(lblNewLabel_12);
	JLabel rdbtnNewRadioButtons = new JLabel(rt.getString("gender"));
	rdbtnNewRadioButtons.setHorizontalAlignment(SwingConstants.LEFT);
	rdbtnNewRadioButtons.setBounds(505, 160, 68, 23);
	panel2.add(rdbtnNewRadioButtons);

	JLabel lblNewLabel_22 = new JLabel("Email-Id :");
	lblNewLabel_22.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_22.setBounds(428, 228, 61, 23);
	panel2.add(lblNewLabel_22);
	JLabel em = new JLabel(rt.getString("email"));
	em.setHorizontalAlignment(SwingConstants.LEFT);
	em.setBounds(505, 228, 114, 23);
	panel2.add(em);

	JLabel lblNewLabel_30 = new JLabel("Year :");
	lblNewLabel_30.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_30.setBounds(435, 264, 54, 23);
	panel2.add(lblNewLabel_30);
	JLabel comboBox0 = new JLabel("Registered by :");
	comboBox0.setHorizontalAlignment(SwingConstants.RIGHT);
	comboBox0.setBounds(239, 448, 109, 22);
	panel2.add(comboBox0);
	
	JLabel lblNewLabel_40 = new JLabel("Group :");
	lblNewLabel_40.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_40.setBounds(433, 298, 56, 22);
	panel2.add(lblNewLabel_40);
	JLabel lcomboBox_1 = new JLabel(rt.getString("Grp"));
	lcomboBox_1.setHorizontalAlignment(SwingConstants.LEFT);
	lcomboBox_1.setBounds(505, 298, 109, 22);
	panel2.add(lcomboBox_1);
	JLabel lblNewLabel_100= new JLabel("Semester :");
	lblNewLabel_100.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel_100.setBounds(411, 331, 78, 23);
	panel2.add(lblNewLabel_100);
	JLabel lcomboBox_2 = new JLabel(rt.getString("sem"));
	lcomboBox_2.setHorizontalAlignment(SwingConstants.LEFT);
	lcomboBox_2.setBounds(505, 331, 114, 22);
	panel2.add(lcomboBox_2);
	
	JLabel lblNewLabel = new JLabel("Registration time :");
	lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
	lblNewLabel.setBounds(239, 414, 109, 23);
	panel2.add(lblNewLabel);
	
	JLabel lblNewLabel_1 = new JLabel(rt.getString("year"));
	lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
	lblNewLabel_1.setBounds(505, 266, 68, 14);
	panel2.add(lblNewLabel_1);
	
	JLabel lblNewLabel_2 = new JLabel(rt.getString("regat"));
	lblNewLabel_2.setBounds(358, 411, 161, 29);
	panel2.add(lblNewLabel_2);
	
	JLabel lblNewLabel_3 = new JLabel(rt.getString("regby"));
	lblNewLabel_3.setBounds(359, 448, 95, 23);
	panel2.add(lblNewLabel_3);
	
	}
}
