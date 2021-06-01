package submission;



import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Home {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window= new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Home");
		
		frame.setBackground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 1150, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 191, 255));
		panel_2.setBounds(0, 0, 1150, 641);
		frame.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("New label");
		lblNewLabel_1_1.setIcon(new ImageIcon(Home.class.getResource("/submission/images/images.png")));
		lblNewLabel_1_1.setBounds(288, 182, 126, 126);
		panel_2.add(lblNewLabel_1_1);
		
		JButton btnNewButton = new JButton("Admin ");
		btnNewButton.setBounds(288, 319, 126, 23);
		panel_2.add(btnNewButton);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1.setIcon(new ImageIcon(Home.class.getResource("/submission/images/App-login-manager-icon.png")));
		lblNewLabel_1_1_1.setBounds(519, 182, 126, 126);
		panel_2.add(lblNewLabel_1_1_1);
		
		JButton btnNewButton_2 = new JButton("Student Login");
		btnNewButton_2.setBounds(755, 319, 126, 23);
		panel_2.add(btnNewButton_2);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("New label");
		lblNewLabel_1_1_1_1.setIcon(new ImageIcon(Home.class.getResource("/submission/images/User-Interface-Login-icon.png")));
		lblNewLabel_1_1_1_1.setBounds(755, 182, 126, 126);
		panel_2.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Faculty login");
		btnNewButton_1.setBounds(519, 319, 126, 23);
		panel_2.add(btnNewButton_1);
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
		btnNewButton_3.setBounds(1105, 0, 45, 23);
		panel_2.add(btnNewButton_3);

	
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {frame.dispose();
			new Faclog1().frame.setVisible(true);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				new student().frame.setVisible(true);
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				
				new Adminlog1().frame.setVisible(true);
			}
		});
	}
}
