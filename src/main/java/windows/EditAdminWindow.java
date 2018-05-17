package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import personClasses.Administator;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EditAdminWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField street;
	private JTextField house;
	private JTextField city;

	Scanner scanner = new Scanner(System.in);
	private JTextField username;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try {
	 * 
	 * AddEmployeeWindow.getEmployees().add(new Employee("fadi", 19, "steh", "2999",
	 * "sahour", 19999)); EditEmployeeWindow frame = new EditEmployeeWindow(0);
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * 
	 * }// main
	 */
	/**
	 * Create the frame.
	 */

	public EditAdminWindow(final int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Admin");
		label.setFont(new Font("Tahoma", Font.BOLD, 43));
		label.setBounds(289, 11, 238, 90);
		contentPane.add(label);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		nameLabel.setBounds(75, 126, 142, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age: ");
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		ageLabel.setBounds(54, 244, 115, 29);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street: ");
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		streetLabel.setBounds(54, 338, 115, 29);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Num: ");
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		houseLabel.setBounds(475, 134, 186, 29);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City: ");
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		cityLabel.setBounds(532, 244, 100, 29);
		contentPane.add(cityLabel);

		name = new JTextField(LoginPageWindow.getAdminsList().get(index).getName());
		name.setBounds(227, 133, 202, 42);
		contentPane.add(name);
		name.setColumns(10);

		age = new JTextField(Integer.toString(LoginPageWindow.getAdminsList().get(index).getAge()));
		age.setColumns(10);
		age.setBounds(227, 231, 202, 42);
		contentPane.add(age);

		street = new JTextField(LoginPageWindow.getAdminsList().get(index).getAddress().getStreetName());
		street.setColumns(10);
		street.setBounds(227, 337, 202, 42);
		contentPane.add(street);

		house = new JTextField(LoginPageWindow.getAdminsList().get(index).getAddress().getHouseNumber());
		house.setColumns(10);
		house.setBounds(691, 133, 202, 42);
		contentPane.add(house);

		city = new JTextField(LoginPageWindow.getAdminsList().get(index).getAddress().getCity());
		city.setColumns(10);
		city.setBounds(691, 243, 202, 42);
		contentPane.add(city);

		JButton btnOkay = new JButton("Update");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfo3(index);
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Info has been updated!");

			}
		});
		btnOkay.setBounds(75, 454, 339, 54);
		contentPane.add(btnOkay);

		JButton btnBack = new JButton("Close");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseJframe();
			}
		});
		btnBack.setBounds(793, 469, 100, 50);
		contentPane.add(btnBack);

		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblUsername.setBounds(491, 322, 171, 45);
		contentPane.add(lblUsername);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblPassword.setBounds(475, 390, 151, 54);
		contentPane.add(lblPassword);

		username = new JTextField(LoginPageWindow.getAdminsList().get(index).getUserName());
		username.setColumns(10);
		username.setBounds(691, 337, 202, 42);
		contentPane.add(username);

		password = new JTextField(LoginPageWindow.getAdminsList().get(index).getPassword());
		password.setColumns(10);
		password.setBounds(691, 390, 202, 42);
		contentPane.add(password);

	}

	

	public void CloseJframe() {
		super.dispose();
	}

	public void updateInfo(int index) {

		LoginPageWindow.getAdminsList().get(index).setName(name.getText());
		LoginPageWindow.getAdminsList().get(index).setAge(Integer.parseInt(age.getText()));
		LoginPageWindow.getAdminsList().get(index).getAddress().setStreetName(street.getText());
		LoginPageWindow.getAdminsList().get(index).getAddress().setHouseNumber(house.getText());
		LoginPageWindow.getAdminsList().get(index).getAddress().setCity(city.getText());
		LoginPageWindow.getAdminsList().get(index).setUserName(username.getText());
		LoginPageWindow.getAdminsList().get(index).setPassword(password.getText());

	}

	public void updateInfo3(int x) {


		LoginPageWindow.getAdminsList().get(x).setName(name.getText());
		LoginPageWindow.getAdminsList().get(x).setAge(Integer.parseInt(age.getText()));
		LoginPageWindow.getAdminsList().get(x).getAddress().setStreetName(street.getText());
		LoginPageWindow.getAdminsList().get(x).getAddress().setHouseNumber(house.getText());
		LoginPageWindow.getAdminsList().get(x).getAddress().setCity(city.getText());
		LoginPageWindow.getAdminsList().get(x).setUserName(username.getText());
		LoginPageWindow.getAdminsList().get(x).setPassword(password.getText());

		EditAdminWindow w = new EditAdminWindow(x);
	}

	public void updateInfo2(Scanner scanner) {

		int i = 0;
		for (Administator admin : LoginPageWindow.getAdminsList()) {
			System.out.println(i + ": " + admin.getName());
			i++;
		}

		int input = scanner.nextInt();

		LoginPageWindow.getAdminsList().get(input).setName(name.getText());
		LoginPageWindow.getAdminsList().get(input).setAge(Integer.parseInt(age.getText()));
		LoginPageWindow.getAdminsList().get(input).getAddress().setStreetName(street.getText());
		LoginPageWindow.getAdminsList().get(input).getAddress().setHouseNumber(house.getText());
		LoginPageWindow.getAdminsList().get(input).getAddress().setCity(city.getText());
		LoginPageWindow.getAdminsList().get(input).setUserName(username.getText());
		LoginPageWindow.getAdminsList().get(input).setPassword(password.getText());

		AdminInfoWindow win = new AdminInfoWindow(input);
	}
}