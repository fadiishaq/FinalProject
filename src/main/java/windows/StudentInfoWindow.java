package windows;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.Employee;
import personClasses.Student;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.security.SignatureException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class StudentInfoWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { StudentInfoWindow frame = new
	 * StudentInfoWindow(); frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } });
	 * 
	 * }// main
	 */
	/**
	 * Create the frame.
	 */

	public StudentInfoWindow(final int index, boolean showNextButton) {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		JLabel label = new JLabel("Student");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 57));
		label.setBounds(211, 0, 371, 90);
		contentPane.add(label);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		nameLabel.setBounds(119, 101, 272, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age: ");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		ageLabel.setBounds(119, 178, 272, 45);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street: ");
		streetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		streetLabel.setBounds(119, 259, 272, 45);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Number: ");
		houseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		houseLabel.setBounds(119, 340, 272, 50);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City: ");
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		cityLabel.setBounds(119, 425, 272, 45);
		contentPane.add(cityLabel);

		JLabel salaryLabel = new JLabel("Grade: ");
		salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaryLabel.setForeground(Color.BLACK);
		salaryLabel.setFont(new Font("SansSerif", Font.BOLD, 22));
		salaryLabel.setBounds(119, 500, 272, 45);
		contentPane.add(salaryLabel);

		JButton btnOkay = new JButton("Done");
		btnOkay.setFont(new Font("SansSerif", Font.BOLD, 21));
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});
		btnOkay.setBounds(10, 590, 179, 58);
		contentPane.add(btnOkay);

		JButton btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.setFont(new Font("SansSerif", Font.BOLD, 21));

		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				EditStudentInfo win = new EditStudentInfo(index);
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

					if (SearchPersonWindow.getStudentsFound().size() == 2) {

						SearchPersonWindow.studentWin1.setVisible(false);
						SearchPersonWindow.studentWin2.setVisible(true);
					}

					else if (SearchPersonWindow.getStudentsFound().size() == 3) {

						if (SearchPersonWindow.studentWin2.isVisible()) {
							SearchPersonWindow.studentWin2.setVisible(false);
							SearchPersonWindow.studentWin3.setVisible(true);
						} else if (!SearchPersonWindow.studentWin2.isVisible()) {

							SearchPersonWindow.studentWin1.setVisible(false);
							SearchPersonWindow.studentWin2.setVisible(true);

						}

					}

					else if (SearchPersonWindow.getPersonsFound().size() == 2) {

						if (SearchPersonWindow.getPersonsFound().get(1) instanceof Student) {

							SearchPersonWindow.studentWin2 = new StudentInfoWindow(
									SearchPersonWindow.getPersonsFound().get(1).getIndex(), false);
							SearchPersonWindow.studentWin1.setVisible(false);
							SearchPersonWindow.studentWin2.setVisible(true);

						}

						else if (SearchPersonWindow.getPersonsFound().get(1) instanceof Employee) {

							SearchPersonWindow.employeeWin1 = new EmployeeInfoWindow(
									SearchPersonWindow.getPersonsFound().get(1).getIndex(), false);
							setVisible(false);
							SearchPersonWindow.employeeWin1.setVisible(true);

						}

					}

				}
			});
			btnNext.setBounds(608, 590, 157, 58);
			contentPane.add(btnNext);
		}
		JLabel name = new JLabel(LoginPageWindow.getStudentsList().get(index).getName());
		name.setBackground(Color.WHITE);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setForeground(new Color(0, 0, 255));
		name.setFont(new Font("SansSerif", Font.PLAIN, 22));
		name.setBounds(401, 98, 272, 45);
		contentPane.add(name);

		JLabel age = new JLabel(Integer.toString(LoginPageWindow.getStudentsList().get(index).getAge()));
		age.setBackground(Color.WHITE);
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setForeground(new Color(0, 0, 255));
		age.setFont(new Font("SansSerif", Font.PLAIN, 22));
		age.setBounds(401, 178, 272, 42);
		contentPane.add(age);

		JLabel street = new JLabel(LoginPageWindow.getStudentsList().get(index).getAddress().getStreetName());
		street.setBackground(Color.WHITE);
		street.setHorizontalAlignment(SwingConstants.CENTER);
		street.setForeground(new Color(0, 0, 255));
		street.setFont(new Font("SansSerif", Font.PLAIN, 22));
		street.setBounds(401, 259, 272, 45);
		contentPane.add(street);

		JLabel house = new JLabel(LoginPageWindow.getStudentsList().get(index).getAddress().getHouseNumber());
		house.setBackground(Color.WHITE);
		house.setHorizontalAlignment(SwingConstants.CENTER);
		house.setForeground(new Color(0, 0, 255));
		house.setFont(new Font("SansSerif", Font.PLAIN, 22));
		house.setBounds(401, 340, 272, 50);
		contentPane.add(house);

		JLabel city = new JLabel(LoginPageWindow.getStudentsList().get(index).getAddress().getCity());
		city.setBackground(Color.WHITE);
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setForeground(new Color(0, 0, 255));
		city.setFont(new Font("SansSerif", Font.PLAIN, 22));
		city.setBounds(401, 425, 272, 45);
		contentPane.add(city);

		JLabel salary = new JLabel(Integer.toString(LoginPageWindow.getStudentsList().get(index).getGrade()));
		salary.setBackground(Color.WHITE);
		salary.setHorizontalAlignment(SwingConstants.CENTER);
		salary.setForeground(new Color(0, 0, 255));
		salary.setFont(new Font("SansSerif", Font.PLAIN, 22));
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

	/*
	 * public StudentInfoWindow() { setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * setBounds(100, 100, 820, 698); contentPane = new JPanel();
	 * contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	 * setContentPane(contentPane); contentPane.setLayout(null);
	 * 
	 * JLabel label = new JLabel("Employee"); label.setFont(new Font("SansSerif",
	 * Font.BOLD | Font.ITALIC, 57)); label.setBounds(253, 0, 371, 90);
	 * contentPane.add(label);
	 * 
	 * JLabel nameLabel = new JLabel("Name: ");
	 * nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 * nameLabel.setForeground(Color.BLACK); nameLabel.setFont(new Font("SansSerif",
	 * Font.BOLD, 30)); nameLabel.setBounds(119, 101, 272, 45);
	 * contentPane.add(nameLabel);
	 * 
	 * JLabel ageLabel = new JLabel("Age: ");
	 * ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 * ageLabel.setForeground(Color.BLACK); ageLabel.setFont(new Font("SansSerif",
	 * Font.BOLD, 30)); ageLabel.setBounds(119, 178, 272, 45);
	 * contentPane.add(ageLabel);
	 * 
	 * JLabel streetLabel = new JLabel("Street: ");
	 * streetLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 * streetLabel.setForeground(Color.BLACK); streetLabel.setFont(new
	 * Font("SansSerif", Font.BOLD, 30)); streetLabel.setBounds(119, 259, 272, 45);
	 * contentPane.add(streetLabel);
	 * 
	 * JLabel houseLabel = new JLabel("House Number: ");
	 * houseLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 * houseLabel.setForeground(Color.BLACK); houseLabel.setFont(new
	 * Font("SansSerif", Font.BOLD, 30)); houseLabel.setBounds(119, 340, 272, 50);
	 * contentPane.add(houseLabel);
	 * 
	 * JLabel cityLabel = new JLabel("City: ");
	 * cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 * cityLabel.setForeground(Color.BLACK); cityLabel.setFont(new Font("SansSerif",
	 * Font.BOLD, 30)); cityLabel.setBounds(119, 425, 272, 45);
	 * contentPane.add(cityLabel);
	 * 
	 * JLabel salaryLabel = new JLabel("Salary: ");
	 * salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 * salaryLabel.setForeground(Color.BLACK); salaryLabel.setFont(new
	 * Font("SansSerif", Font.BOLD, 30)); salaryLabel.setBounds(119, 500, 272, 45);
	 * contentPane.add(salaryLabel);
	 * 
	 * JButton btnOkay = new JButton("Done"); btnOkay.setFont(new Font("SansSerif",
	 * Font.BOLD, 21)); btnOkay.addActionListener(new ActionListener() { public void
	 * actionPerformed(ActionEvent e) { CloseJframe();
	 * 
	 * } }); btnOkay.setBounds(10, 590, 179, 58); contentPane.add(btnOkay);
	 * 
	 * JButton btnUpdateInfo = new JButton("Update Info"); btnUpdateInfo.setFont(new
	 * Font("SansSerif", Font.BOLD, 21)); btnUpdateInfo.addActionListener(new
	 * ActionListener() { public void actionPerformed(ActionEvent arg0) {
	 * 
	 * } }); btnUpdateInfo.setBounds(261, 590, 262, 58);
	 * contentPane.add(btnUpdateInfo);
	 * 
	 * JLabel name = new JLabel("hahaha"); name.setBackground(Color.WHITE);
	 * name.setHorizontalAlignment(SwingConstants.CENTER);
	 * name.setForeground(Color.RED); name.setFont(new Font("SansSerif", Font.PLAIN,
	 * 30)); name.setBounds(401, 98, 272, 45); contentPane.add(name);
	 * 
	 * JLabel age = new JLabel("hahaha"); age.setBackground(Color.WHITE);
	 * age.setHorizontalAlignment(SwingConstants.CENTER);
	 * age.setForeground(Color.RED); age.setFont(new Font("SansSerif", Font.PLAIN,
	 * 30)); age.setBounds(401, 178, 272, 42); contentPane.add(age);
	 * 
	 * JLabel street = new JLabel("hahaha"); street.setBackground(Color.WHITE);
	 * street.setHorizontalAlignment(SwingConstants.CENTER);
	 * street.setForeground(Color.RED); street.setFont(new Font("SansSerif",
	 * Font.PLAIN, 30)); street.setBounds(401, 259, 272, 45);
	 * contentPane.add(street);
	 * 
	 * JLabel house = new JLabel("hahaha"); house.setBackground(Color.WHITE);
	 * house.setHorizontalAlignment(SwingConstants.CENTER);
	 * house.setForeground(Color.RED); house.setFont(new Font("SansSerif",
	 * Font.PLAIN, 30)); house.setBounds(401, 340, 272, 50); contentPane.add(house);
	 * 
	 * JLabel city = new JLabel("hahaha"); city.setBackground(Color.WHITE);
	 * city.setHorizontalAlignment(SwingConstants.CENTER);
	 * city.setForeground(Color.RED); city.setFont(new Font("SansSerif", Font.PLAIN,
	 * 30)); city.setBounds(401, 425, 272, 45); contentPane.add(city);
	 * 
	 * JLabel salary = new JLabel("hahaha"); salary.setBackground(Color.WHITE);
	 * salary.setHorizontalAlignment(SwingConstants.CENTER);
	 * salary.setForeground(Color.RED); salary.setFont(new Font("SansSerif",
	 * Font.PLAIN, 30)); salary.setBounds(401, 500, 272, 45);
	 * contentPane.add(salary);
	 * 
	 * JSeparator separator = new JSeparator(); separator.setBounds(129, 154, 521,
	 * 9); contentPane.add(separator);
	 * 
	 * JSeparator separator_1 = new JSeparator(); separator_1.setBounds(129, 242,
	 * 521, 9); contentPane.add(separator_1);
	 * 
	 * JSeparator separator_2 = new JSeparator(); separator_2.setBounds(129, 323,
	 * 521, 9); contentPane.add(separator_2);
	 * 
	 * JSeparator separator_3 = new JSeparator(); separator_3.setBounds(129, 408,
	 * 521, 9); contentPane.add(separator_3);
	 * 
	 * JSeparator separator_4 = new JSeparator(); separator_4.setBounds(129, 483,
	 * 521, 9); contentPane.add(separator_4);
	 * 
	 * }
	 */

}