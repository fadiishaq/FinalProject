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

public class AddAdminWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField street;
	private JTextField house;
	private JTextField city;

	private static ArrayList<Administator> admins = new ArrayList<Administator>();
	private static int numOfAdmins = 0;
	
	private JTextField userName;
	private JTextField password;
	private JTextField password2;

	public static void addNumOfAdmins() {
		numOfAdmins++;
	}

	public static int getNumOfEmployees() {
		return numOfAdmins;
	}

	public static void setNumOfEmployees(int numOfEmployees) {
		AddAdminWindow.numOfAdmins = numOfEmployees;
	}

	public static ArrayList<Administator> getAdmins() {
		return admins;
	}

	public static void setEmployees(ArrayList<Administator> admins) {
		AddAdminWindow.admins = admins;
	}

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
		setBounds(100, 100, 820, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddAdmin = new JLabel("Add Administration");
		lblAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 71));
		lblAddAdmin.setBounds(54, 11, 728, 73);
		contentPane.add(lblAddAdmin);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblName.setBounds(33, 156, 95, 49);
		contentPane.add(lblName);

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAge.setBounds(33, 263, 152, 78);
		contentPane.add(lblAge);

		JLabel lblAddress = new JLabel("Street");
		lblAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblAddress.setBounds(33, 388, 152, 78);
		contentPane.add(lblAddress);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			AddPersonWindow addPersonWindow = new AddPersonWindow();
			addPersonWindow.setVisible(true);
			}
		});
		btnBack.setBounds(719, 566, 75, 38);
		contentPane.add(btnBack);

		name = new JTextField();
		name.setBounds(138, 155, 248, 58);
		contentPane.add(name);
		name.setColumns(10);

		age = new JTextField();
		age.setColumns(10);
		age.setBounds(138, 277, 248, 58);
		contentPane.add(age);

		street = new JTextField();
		street.setColumns(10);
		street.setBounds(138, 402, 248, 58);
		contentPane.add(street);

		JButton btnAddAdmin = new JButton("Add Administration");
		btnAddAdmin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					if(password.getText().equals(password2.getText())) {
					Administator employee = new Administator(name.getText(), Integer.parseInt(age.getText()), street.getText(),
							house.getText(), city.getText(), userName.getText(), password.getText());

					admins.add(employee);
					addNumOfAdmins();
					AdminInfoWindow adminInfo = new AdminInfoWindow(numOfAdmins - 1);
					adminInfo.setVisible(true);
					}else { 
						JOptionPane.showMessageDialog(null, "Passwords don't match!");
						throw new Exception();
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong input!");
				}

			}

		});
		btnAddAdmin.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAddAdmin.setBounds(10, 477, 283, 84);
		contentPane.add(btnAddAdmin);

		JLabel lblHouseNum = new JLabel("House Num");
		lblHouseNum.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHouseNum.setBounds(396, 121, 152, 78);
		contentPane.add(lblHouseNum);

		house = new JTextField();
		house.setColumns(10);
		house.setBounds(536, 135, 248, 58);
		contentPane.add(house);

		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCity.setBounds(441, 210, 152, 78);
		contentPane.add(lblCity);

		city = new JTextField();
		city.setColumns(10);
		city.setBounds(546, 224, 248, 58);
		contentPane.add(city);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(406, 317, 152, 78);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(416, 409, 152, 78);
		contentPane.add(lblPassword);
		
		userName = new JTextField();
		userName.setColumns(10);
		userName.setBounds(546, 331, 248, 58);
		contentPane.add(userName);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(536, 423, 248, 58);
		contentPane.add(password);
		
		password2 = new JTextField();
		password2.setColumns(10);
		password2.setBounds(526, 491, 248, 58);
		contentPane.add(password2);
		
		JLabel lblConfirmPassword = new JLabel("confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmPassword.setBounds(335, 482, 196, 78);
		contentPane.add(lblConfirmPassword);
	}
}
