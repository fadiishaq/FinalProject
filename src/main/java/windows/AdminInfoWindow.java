package windows;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class AdminInfoWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminInfoWindow frame = new AdminInfoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// main

	/**
	 * Create the frame.
	 */

	public AdminInfoWindow(final int index) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		JLabel label = new JLabel("Admin");
		label.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 57));
		label.setBounds(253, 0, 371, 90);
		contentPane.add(label);

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		nameLabel.setBounds(119, 101, 272, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		ageLabel.setBounds(119, 157, 272, 45);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street");
		streetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		streetLabel.setBounds(119, 213, 272, 45);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Number");
		houseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		houseLabel.setBounds(119, 269, 272, 50);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City");
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		cityLabel.setBounds(119, 333, 272, 45);
		contentPane.add(cityLabel);

		JLabel salaryLabel = new JLabel("Username");
		salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaryLabel.setForeground(Color.BLACK);
		salaryLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		salaryLabel.setBounds(129, 406, 272, 45);
		contentPane.add(salaryLabel);

		JButton btnOkay = new JButton("Done");
		btnOkay.setFont(new Font("SansSerif", Font.BOLD, 21));
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseJframe();

			}
		});
		btnOkay.setBounds(10, 590, 179, 58);
		contentPane.add(btnOkay);

		JButton btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.setFont(new Font("SansSerif", Font.BOLD, 21));
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EditAdminWindow win = new EditAdminWindow(index);
				win.setVisible(true);
				setVisible(false);

			}
		});
		btnUpdateInfo.setBounds(261, 590, 262, 58);
		contentPane.add(btnUpdateInfo);

		JLabel name = new JLabel(LoginPageWindow.getAdminsList().get(index).getName());
		name.setBackground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.RED);
		name.setFont(new Font("SansSerif", Font.BOLD, 16));
		name.setBounds(401, 98, 272, 45);
		contentPane.add(name);

		JLabel age = new JLabel(Integer.toString(LoginPageWindow.getAdminsList().get(index).getAge()));
		age.setBackground(Color.WHITE);
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setForeground(Color.RED);
		age.setFont(new Font("SansSerif", Font.BOLD, 16));
		age.setBounds(401, 157, 272, 42);
		contentPane.add(age);

		JLabel street = new JLabel(LoginPageWindow.getAdminsList().get(index).getAddress().getStreetName());
		street.setBackground(Color.WHITE);
		street.setHorizontalAlignment(SwingConstants.CENTER);
		street.setForeground(Color.RED);
		street.setFont(new Font("SansSerif", Font.BOLD, 16));
		street.setBounds(401, 210, 272, 45);
		contentPane.add(street);

		JLabel house = new JLabel(LoginPageWindow.getAdminsList().get(index).getAddress().getHouseNumber());
		house.setBackground(Color.WHITE);
		house.setHorizontalAlignment(SwingConstants.CENTER);
		house.setForeground(Color.RED);
		house.setFont(new Font("SansSerif", Font.BOLD, 16));
		house.setBounds(401, 269, 272, 50);
		contentPane.add(house);

		JLabel city = new JLabel(LoginPageWindow.getAdminsList().get(index).getAddress().getCity());
		city.setBackground(Color.WHITE);
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setForeground(Color.RED);
		city.setFont(new Font("SansSerif", Font.BOLD, 16));
		city.setBounds(401, 333, 272, 45);
		contentPane.add(city);

		JLabel username = new JLabel(LoginPageWindow.getAdminsList().get(index).getUserName());
		username.setBackground(Color.WHITE);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setForeground(Color.RED);
		username.setFont(new Font("SansSerif", Font.BOLD, 16));
		username.setBounds(411, 406, 272, 45);
		contentPane.add(username);

		JSeparator separator = new JSeparator();
		separator.setBounds(129, 154, 521, 9);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(129, 210, 521, 9);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(129, 269, 521, 9);
		contentPane.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(129, 316, 521, 9);
		contentPane.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(139, 389, 521, 9);
		contentPane.add(separator_4);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPassword.setBounds(119, 489, 272, 45);
		contentPane.add(lblPassword);

		JLabel label_2 = new JLabel(LoginPageWindow.getAdminsList().get(index).getPassword());
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("SansSerif", Font.BOLD, 16));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(378, 489, 272, 45);
		contentPane.add(label_2);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(103, 469, 521, 9);
		contentPane.add(separator_5);

		setLocationRelativeTo(null);

	}

	////////////////////////////////////////////////////////////////////////////////

	public AdminInfoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Admin");
		label.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 57));
		label.setBounds(253, 0, 371, 90);
		contentPane.add(label);

		JLabel nameLabel = new JLabel("Name");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		nameLabel.setBounds(119, 101, 272, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		ageLabel.setBounds(119, 157, 272, 45);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street");
		streetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		streetLabel.setBounds(119, 213, 272, 45);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Number");
		houseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		houseLabel.setBounds(119, 269, 272, 50);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City");
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		cityLabel.setBounds(119, 333, 272, 45);
		contentPane.add(cityLabel);

		JLabel salaryLabel = new JLabel("Username");
		salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaryLabel.setForeground(Color.BLACK);
		salaryLabel.setFont(new Font("SansSerif", Font.BOLD, 18));
		salaryLabel.setBounds(129, 406, 272, 45);
		contentPane.add(salaryLabel);

		JButton btnOkay = new JButton("Done");
		btnOkay.setFont(new Font("SansSerif", Font.BOLD, 21));
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseJframe();

			}
		});
		btnOkay.setBounds(10, 590, 179, 58);
		contentPane.add(btnOkay);

		JButton btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.setFont(new Font("SansSerif", Font.BOLD, 21));
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnUpdateInfo.setBounds(261, 590, 262, 58);
		contentPane.add(btnUpdateInfo);

		JLabel name = new JLabel("");
		name.setBackground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.RED);
		name.setFont(new Font("SansSerif", Font.BOLD, 16));
		name.setBounds(401, 98, 272, 45);
		contentPane.add(name);

		JLabel age = new JLabel("hahaha");
		age.setBackground(Color.WHITE);
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setForeground(Color.RED);
		age.setFont(new Font("SansSerif", Font.BOLD, 16));
		age.setBounds(401, 157, 272, 42);
		contentPane.add(age);

		JLabel street = new JLabel("hahaha");
		street.setBackground(Color.WHITE);
		street.setHorizontalAlignment(SwingConstants.CENTER);
		street.setForeground(Color.RED);
		street.setFont(new Font("SansSerif", Font.BOLD, 16));
		street.setBounds(401, 210, 272, 45);
		contentPane.add(street);

		JLabel house = new JLabel("hahaha");
		house.setBackground(Color.WHITE);
		house.setHorizontalAlignment(SwingConstants.CENTER);
		house.setForeground(Color.RED);
		house.setFont(new Font("SansSerif", Font.BOLD, 16));
		house.setBounds(401, 269, 272, 50);
		contentPane.add(house);

		JLabel city = new JLabel("hahaha");
		city.setBackground(Color.WHITE);
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setForeground(Color.RED);
		city.setFont(new Font("SansSerif", Font.BOLD, 16));
		city.setBounds(401, 333, 272, 45);
		contentPane.add(city);

		JLabel username = new JLabel("hahaha");
		username.setBackground(Color.WHITE);
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setForeground(Color.RED);
		username.setFont(new Font("SansSerif", Font.BOLD, 16));
		username.setBounds(411, 406, 272, 45);
		contentPane.add(username);

		JSeparator separator = new JSeparator();
		separator.setBounds(129, 154, 521, 9);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(129, 210, 521, 9);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(129, 269, 521, 9);
		contentPane.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(129, 316, 521, 9);
		contentPane.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(139, 389, 521, 9);
		contentPane.add(separator_4);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 18));
		lblPassword.setBounds(119, 489, 272, 45);
		contentPane.add(lblPassword);

		JLabel password = new JLabel("hahaha");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setForeground(Color.RED);
		password.setFont(new Font("SansSerif", Font.BOLD, 16));
		password.setBackground(Color.WHITE);
		password.setBounds(384, 489, 272, 45);
		contentPane.add(password);

		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(103, 469, 521, 9);
		contentPane.add(separator_5);

	}

	public void CloseJframe() {
		super.dispose();
	}
}