package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.Administator;
import testPackage.PersonManagerTest;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

public class AddAdminWindow extends JFrame {

	private JPanel contentPane;
	private JTextField age;
	private JTextField name;
	private JTextField street;
	private JTextField house;
	private JTextField city;
	private JTextField username;
	private JTextField password;
	private JTextField password2;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdminWindow frame = new AddAdminWindow();
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
	public AddAdminWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddAdmin = new JLabel("Add Administration");
		lblAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 71));
		lblAddAdmin.setBounds(54, 11, 728, 73);
		contentPane.add(lblAddAdmin);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AddPersonWindow addPersonWindow = new AddPersonWindow();
				addPersonWindow.setVisible(true);
			}
		});
		btnBack.setBounds(719, 566, 75, 38);
		contentPane.add(btnBack);

		JButton btnAddAdmin = new JButton("Add Administration");
		btnAddAdmin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {
					
					if (password.getText().equals(password2.getText())) {
						
						Administator admin = new Administator(name.getText(), Integer.parseInt(age.getText()),
								street.getText(), house.getText(), city.getText(), username.getText(),
								password.getText());
						LoginPageWindow.getAdminsList().add(admin);
						AdminInfoWindow adminInfo = new AdminInfoWindow(LoginPageWindow.getAdminsList().size() - 1);
						setVisible(false);
						adminInfo.setVisible(true);
						
					} else {
						
						JOptionPane.showMessageDialog(null, "Passwords don't match!");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong input!");
				}

			}

		});
		btnAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAddAdmin.setBounds(182, 655, 339, 73);
		contentPane.add(btnAddAdmin);
		
		JButton btnNewButton = new JButton("back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddPersonWindow win = new AddPersonWindow();
				setVisible(false);
				win.setVisible(true);
				
			}
		});
		btnNewButton.setBounds(54, 655, 88, 73);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("Name");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(121, 95, 95, 49);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Age");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(121, 165, 95, 52);
		contentPane.add(label_1);
		
		age = new JTextField();
		age.setColumns(10);
		age.setBackground(Color.WHITE);
		age.setBounds(226, 176, 248, 38);
		contentPane.add(age);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBackground(Color.WHITE);
		name.setBounds(226, 104, 248, 38);
		contentPane.add(name);
		
		JLabel label_2 = new JLabel("Street");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(121, 228, 95, 52);
		contentPane.add(label_2);
		
		street = new JTextField();
		street.setColumns(10);
		street.setBackground(Color.WHITE);
		street.setBounds(226, 239, 248, 38);
		contentPane.add(street);
		
		JLabel label_3 = new JLabel("House Number");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(64, 299, 152, 52);
		contentPane.add(label_3);
		
		house = new JTextField();
		house.setColumns(10);
		house.setBackground(Color.WHITE);
		house.setBounds(226, 310, 248, 38);
		contentPane.add(house);
		
		JLabel label_4 = new JLabel("City");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(135, 356, 81, 49);
		contentPane.add(label_4);
		
		city = new JTextField();
		city.setColumns(10);
		city.setBackground(Color.WHITE);
		city.setBounds(226, 365, 248, 38);
		contentPane.add(city);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBackground(Color.WHITE);
		username.setBounds(226, 423, 248, 38);
		contentPane.add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBackground(Color.WHITE);
		password.setBounds(226, 481, 248, 38);
		contentPane.add(password);
		
		password2 = new JTextField();
		password2.setColumns(10);
		password2.setBackground(Color.WHITE);
		password2.setBounds(226, 539, 248, 38);
		contentPane.add(password2);
		
		lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(54, 414, 162, 49);
		contentPane.add(lblUsername);
		
		lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(69, 472, 147, 49);
		contentPane.add(lblPassword);
		
		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmPassword.setBounds(10, 530, 206, 49);
		contentPane.add(lblConfirmPassword);
	}
}
