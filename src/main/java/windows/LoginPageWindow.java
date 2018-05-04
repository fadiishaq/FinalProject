package windows;

import testPackage.PersonManagerTest;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.Administator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class LoginPageWindow extends JFrame {

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPageWindow frame = new LoginPageWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public LoginPageWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 507, 283);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel nameLabel = new JLabel("Name:");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nameLabel.setBounds(51, 60, 132, 53);
		contentPane.add(nameLabel);
		
		JLabel title = new JLabel("Person Manager");
		title.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		title.setBounds(112, 0, 279, 39);
		contentPane.add(title);
		
		JLabel passwordLabel = new JLabel("Password:");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		passwordLabel.setBounds(51, 124, 132, 53);
		contentPane.add(passwordLabel);
		
		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(223, 76, 184, 34);
		contentPane.add(username);
		username.setColumns(10);
		
		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				String name = username.getText();
				String pass = password.getText();
				
				
				for (Administator admin: AddAdminWindow.getAdmins()) {
					if(name.equals(admin.getName()) && pass.equals(admin.getPassword())) {
						JOptionPane.showMessageDialog(null, "you've successfully signed in");
						PersonManagerWindow tab = new PersonManagerWindow();
						tab.setVisible(true);
					}
					
				}
				
				if(name.equals("admin") && pass.equals("admin")) {
					JOptionPane.showMessageDialog(null, "you've successfully signed in");
					PersonManagerWindow tab = new PersonManagerWindow();
					tab.setVisible(true);
				}
				
				else {	
					JOptionPane.showMessageDialog(null, "wrong name or pass\ntry again");
				}
				
				
				
				

				
				
				
				
			}
		});
		loginButton.setBounds(191, 194, 111, 39);
		contentPane.add(loginButton);
		
		password = new JPasswordField();
		password.setBounds(223, 140, 184, 34);
		contentPane.add(password);
	}
}

