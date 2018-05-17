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

public class EmployeeInfoWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfoWindow frame = new EmployeeInfoWindow();
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
	EmployeeInfoWindow win1;
	EmployeeInfoWindow win2;
	EmployeeInfoWindow win3;

	/*
	 * public static void declareWins() {
	 * 
	 * EmployeeInfoWindow win1 = null; EmployeeInfoWindow win2 = null;
	 * EmployeeInfoWindow win3 = null; }
	 */

	public static void assignWins(EmployeeInfoWindow win1, EmployeeInfoWindow win2, EmployeeInfoWindow win3) {

		if (SearchPersonWindow.getEmployeesFound().size() == 2) {
			win1 = new EmployeeInfoWindow(SearchPersonWindow.getEmployeesFound().get(1).getIndex(), false);
		}

		else if (SearchPersonWindow.getEmployeesFound().size() == 3) {
			win2 = new EmployeeInfoWindow(SearchPersonWindow.getEmployeesFound().get(1).getIndex(), true);
			win3 = new EmployeeInfoWindow(SearchPersonWindow.getEmployeesFound().get(2).getIndex(), false);
		}

	}

	public EmployeeInfoWindow(final int index, boolean showNextButton) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);

		JLabel label = new JLabel("Employee");
		label.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 57));
		label.setBounds(253, 0, 371, 90);
		contentPane.add(label);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		nameLabel.setBounds(119, 101, 272, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age: ");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		ageLabel.setBounds(119, 178, 272, 45);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street: ");
		streetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		streetLabel.setBounds(119, 259, 272, 45);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Number: ");
		houseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		houseLabel.setBounds(119, 340, 272, 50);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City: ");
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		cityLabel.setBounds(119, 425, 272, 45);
		contentPane.add(cityLabel);

		JLabel salaryLabel = new JLabel("Salary: ");
		salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaryLabel.setForeground(Color.BLACK);
		salaryLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		salaryLabel.setBounds(119, 500, 272, 45);
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

				EditEmployeeWindow win = new EditEmployeeWindow(index);
				setVisible(false);
				win.setVisible(true);

			}

		});
		btnUpdateInfo.setBounds(261, 590, 262, 58);
		contentPane.add(btnUpdateInfo);

		if (showNextButton) {

			JButton btnNext = new JButton("Next");
			btnNext.setFont(new Font("SansSerif", Font.BOLD, 21));
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					if (SearchPersonWindow.getEmployeesFound().size() == 2) {
						setVisible(false);
						SearchPersonWindow.employeeWin2.setVisible(true);
					}

					else if (SearchPersonWindow.getEmployeesFound().size() == 3) {

						if (SearchPersonWindow.employeeWin2.isVisible()) {
							SearchPersonWindow.employeeWin2.setVisible(false);
							SearchPersonWindow.employeeWin3.setVisible(true);
						} else if (!SearchPersonWindow.employeeWin2.isVisible()) {

							SearchPersonWindow.employeeWin1.setVisible(false);
							SearchPersonWindow.employeeWin2.setVisible(true);

						}

					}

				}
			});
			btnNext.setBounds(608, 590, 157, 58);
			contentPane.add(btnNext);
		}
		JLabel name = new JLabel(LoginPageWindow.getEmployeesList().get(index).getName());
		name.setBackground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.RED);
		name.setFont(new Font("SansSerif", Font.PLAIN, 30));
		name.setBounds(401, 98, 272, 45);
		contentPane.add(name);

		JLabel age = new JLabel(Integer.toString(LoginPageWindow.getEmployeesList().get(index).getAge()));
		age.setBackground(Color.WHITE);
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setForeground(Color.RED);
		age.setFont(new Font("SansSerif", Font.PLAIN, 30));
		age.setBounds(401, 178, 272, 42);
		contentPane.add(age);

		JLabel street = new JLabel(LoginPageWindow.getEmployeesList().get(index).getAddress().getStreetName());
		street.setBackground(Color.WHITE);
		street.setHorizontalAlignment(SwingConstants.CENTER);
		street.setForeground(Color.RED);
		street.setFont(new Font("SansSerif", Font.PLAIN, 30));
		street.setBounds(401, 259, 272, 45);
		contentPane.add(street);

		JLabel house = new JLabel(LoginPageWindow.getEmployeesList().get(index).getAddress().getHouseNumber());
		house.setBackground(Color.WHITE);
		house.setHorizontalAlignment(SwingConstants.CENTER);
		house.setForeground(Color.RED);
		house.setFont(new Font("SansSerif", Font.PLAIN, 30));
		house.setBounds(401, 340, 272, 50);
		contentPane.add(house);

		JLabel city = new JLabel(LoginPageWindow.getEmployeesList().get(index).getAddress().getCity());
		city.setBackground(Color.WHITE);
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setForeground(Color.RED);
		city.setFont(new Font("SansSerif", Font.PLAIN, 30));
		city.setBounds(401, 425, 272, 45);
		contentPane.add(city);

		JLabel salary = new JLabel(Integer.toString(LoginPageWindow.getEmployeesList().get(index).getSalary()));
		salary.setBackground(Color.WHITE);
		salary.setHorizontalAlignment(SwingConstants.CENTER);
		salary.setForeground(Color.RED);
		salary.setFont(new Font("SansSerif", Font.PLAIN, 30));
		salary.setBounds(401, 500, 272, 45);
		contentPane.add(salary);

		JSeparator separator = new JSeparator();
		separator.setBounds(129, 154, 521, 9);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(129, 242, 521, 9);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(129, 323, 521, 9);
		contentPane.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(129, 408, 521, 9);
		contentPane.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(129, 483, 521, 9);
		contentPane.add(separator_4);

		setLocationRelativeTo(null);

	}

	////////////////////////////////////////////////////////////////////////////////

	public EmployeeInfoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Employee");
		label.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 57));
		label.setBounds(253, 0, 371, 90);
		contentPane.add(label);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		nameLabel.setBounds(119, 101, 272, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age: ");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		ageLabel.setBounds(119, 178, 272, 45);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street: ");
		streetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		streetLabel.setBounds(119, 259, 272, 45);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Number: ");
		houseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		houseLabel.setBounds(119, 340, 272, 50);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City: ");
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		cityLabel.setBounds(119, 425, 272, 45);
		contentPane.add(cityLabel);

		JLabel salaryLabel = new JLabel("Salary: ");
		salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaryLabel.setForeground(Color.BLACK);
		salaryLabel.setFont(new Font("SansSerif", Font.BOLD, 30));
		salaryLabel.setBounds(119, 500, 272, 45);
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

		JLabel name = new JLabel("hahaha");
		name.setBackground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(Color.RED);
		name.setFont(new Font("SansSerif", Font.PLAIN, 30));
		name.setBounds(401, 98, 272, 45);
		contentPane.add(name);

		JLabel age = new JLabel("hahaha");
		age.setBackground(Color.WHITE);
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setForeground(Color.RED);
		age.setFont(new Font("SansSerif", Font.PLAIN, 30));
		age.setBounds(401, 178, 272, 42);
		contentPane.add(age);

		JLabel street = new JLabel("hahaha");
		street.setBackground(Color.WHITE);
		street.setHorizontalAlignment(SwingConstants.CENTER);
		street.setForeground(Color.RED);
		street.setFont(new Font("SansSerif", Font.PLAIN, 30));
		street.setBounds(401, 259, 272, 45);
		contentPane.add(street);

		JLabel house = new JLabel("hahaha");
		house.setBackground(Color.WHITE);
		house.setHorizontalAlignment(SwingConstants.CENTER);
		house.setForeground(Color.RED);
		house.setFont(new Font("SansSerif", Font.PLAIN, 30));
		house.setBounds(401, 340, 272, 50);
		contentPane.add(house);

		JLabel city = new JLabel("hahaha");
		city.setBackground(Color.WHITE);
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setForeground(Color.RED);
		city.setFont(new Font("SansSerif", Font.PLAIN, 30));
		city.setBounds(401, 425, 272, 45);
		contentPane.add(city);

		JLabel salary = new JLabel("hahaha");
		salary.setBackground(Color.WHITE);
		salary.setHorizontalAlignment(SwingConstants.CENTER);
		salary.setForeground(Color.RED);
		salary.setFont(new Font("SansSerif", Font.PLAIN, 30));
		salary.setBounds(401, 500, 272, 45);
		contentPane.add(salary);

		JSeparator separator = new JSeparator();
		separator.setBounds(129, 154, 521, 9);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(129, 242, 521, 9);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(129, 323, 521, 9);
		contentPane.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(129, 408, 521, 9);
		contentPane.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(129, 483, 521, 9);
		contentPane.add(separator_4);

	}

	public void CloseJframe() {
		super.dispose();
	}

}