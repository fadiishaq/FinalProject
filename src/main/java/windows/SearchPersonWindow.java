package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JSeparator;

public class SearchPersonWindow extends JFrame {

	private static JPanel contentPane;
	private JTextField name;
	private static ArrayList<Student> studentsFound = new ArrayList();
	private static ArrayList<Employee> employeesFound = new ArrayList();
	private static ArrayList<Person> personsFound = new ArrayList();

	static EmployeeInfoWindow employeeWin1;
	static EmployeeInfoWindow employeeWin2;
	static EmployeeInfoWindow employeeWin3;

	static StudentInfoWindow studentWin1;
	static StudentInfoWindow studentWin2;
	static StudentInfoWindow studentWin3;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPersonWindow frame = new SearchPersonWindow();
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

	JCheckBox employeeBox;
	JCheckBox studentBox;
	JCheckBox unlimitedBox;

	public SearchPersonWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 713, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		JLabel lblNewLabel = new JLabel("Search Person");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 48));
		lblNewLabel.setBounds(181, 11, 377, 79);
		contentPane.add(lblNewLabel);

		JLabel lblEnterNameTo = new JLabel("Name");
		lblEnterNameTo.setHorizontalAlignment(SwingConstants.CENTER);
		lblEnterNameTo.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblEnterNameTo.setBounds(114, 149, 125, 65);
		contentPane.add(lblEnterNameTo);

		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(325, 167, 246, 40);
		contentPane.add(name);
		name.setColumns(10);

		employeeBox = new JCheckBox("Employee");
		employeeBox.setBackground(SystemColor.menu);
		employeeBox.setForeground(new Color(0, 0, 0));
		employeeBox.setBounds(232, 149, 87, 23);
		contentPane.add(employeeBox);

		studentBox = new JCheckBox("Student");
		studentBox.setBackground(SystemColor.menu);
		studentBox.setForeground(new Color(0, 0, 0));
		studentBox.setBounds(232, 175, 70, 23);
		contentPane.add(studentBox);

		unlimitedBox = new JCheckBox("Unlimited");
		unlimitedBox.setBackground(SystemColor.menu);
		unlimitedBox.setForeground(new Color(0, 0, 0));
		unlimitedBox.setBounds(232, 202, 80, 23);
		contentPane.add(unlimitedBox);

		JButton btnSearch = new JButton("Search");
		btnSearch.setBackground(new Color(255, 182, 193));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if ((employeeBox.isSelected() || studentBox.isSelected()) && unlimitedBox.isSelected())
					JOptionPane.showMessageDialog(null, "Please check one box only");

				else if (employeeBox.isSelected() && studentBox.isSelected())
					JOptionPane.showMessageDialog(null, "Please check one box only");

				else if (employeeBox.isSelected()) {

					if (employeesFound.size() > 0) {
						employeesFound.clear();
					}

					employeesFound = findEmployees(LoginPageWindow.getEmployeesList(), name.getText());

					if (employeesFound != null && employeesFound.size() > 0) {

						if (employeesFound.size() == 1) {

							EmployeeInfoWindow win = new EmployeeInfoWindow(employeesFound.get(0).getIndex(), false);
							win.setVisible(true);

						}

						else if (employeesFound.size() == 2) {

							employeeWin1 = new EmployeeInfoWindow(employeesFound.get(0).getIndex(), true);
							employeeWin2 = new EmployeeInfoWindow(employeesFound.get(1).getIndex(), false);

							employeeWin1.setVisible(true);

						}

						else if (employeesFound.size() == 3) {

							employeeWin1 = new EmployeeInfoWindow(employeesFound.get(0).getIndex(), true);
							employeeWin2 = new EmployeeInfoWindow(employeesFound.get(1).getIndex(), true);
							employeeWin3 = new EmployeeInfoWindow(employeesFound.get(2).getIndex(), false);

							employeeWin1.setVisible(true);
						}

					} else
						JOptionPane.showMessageDialog(null, "No employees found!");

				} // employee

				else if (studentBox.isSelected()) {

					if (studentsFound.size() > 0) {
						studentsFound.clear();
					}

					studentsFound = findStudents(LoginPageWindow.getStudentsList(), name.getText());

					if (studentsFound != null && studentsFound.size() > 0) {

						if (studentsFound.size() == 1) {

							StudentInfoWindow win = new StudentInfoWindow(studentsFound.get(0).getIndex(), false);
							win.setVisible(true);

						}

						else if (studentsFound.size() == 2) {

							studentWin1 = new StudentInfoWindow(studentsFound.get(0).getIndex(), true);
							studentWin2 = new StudentInfoWindow(studentsFound.get(1).getIndex(), false);

							studentWin1.setVisible(true);

						}

						else if (studentsFound.size() == 3) {

							studentWin1 = new StudentInfoWindow(studentsFound.get(0).getIndex(), true);
							studentWin2 = new StudentInfoWindow(studentsFound.get(1).getIndex(), true);
							studentWin3 = new StudentInfoWindow(studentsFound.get(2).getIndex(), false);

							studentWin1.setVisible(true);
						}

					} else
						JOptionPane.showMessageDialog(null, "No Students Found!");

				} // stu

				else if (unlimitedBox.isSelected()) {

					if (personsFound.size() > 0) {
						personsFound.clear();
					}

					personsFound = findPersons(LoginPageWindow.getEmployeesList(), LoginPageWindow.getStudentsList(),
							name.getText());
					

					if (personsFound != null && personsFound.size() > 0) {

						if (personsFound.size() == 1) {

							if (personsFound.get(0) instanceof Student) {

								studentWin1 = new StudentInfoWindow(personsFound.get(0).getIndex(), false);
								studentWin1.setVisible(true);

							} else if (personsFound.get(0) instanceof Employee) {

								employeeWin1 = new EmployeeInfoWindow(personsFound.get(0).getIndex(), false);
								employeeWin1.setVisible(true);

							}

						}

						else if (personsFound.size() == 2) {

							if (personsFound.get(0) instanceof Student) {
								studentWin1 = new StudentInfoWindow(studentsFound.get(0).getIndex(), true);
								studentWin1.setVisible(true);
							}

							else if (personsFound.get(0) instanceof Employee) {
								employeeWin1 = new EmployeeInfoWindow(personsFound.get(0).getIndex(), true);
								employeeWin1.setVisible(true);

							}

							if (personsFound.get(1) instanceof Student) {
								studentWin2 = new StudentInfoWindow(personsFound.get(0).getIndex(), false);
							}

							else if (personsFound.get(1) instanceof Employee) {
								employeeWin2 = new EmployeeInfoWindow(personsFound.get(0).getIndex(), false);
							}

						}

						else if (studentsFound.size() == 3) {
							/*
							 * studentWin1 = new StudentInfoWindow(studentsFound.get(0).getIndex(), true);
							 * studentWin2 = new StudentInfoWindow(studentsFound.get(1).getIndex(), true);
							 * studentWin3 = new StudentInfoWindow(studentsFound.get(2).getIndex(), false);
							 * 
							 * studentWin1.setVisible(true);
							 */
						}

					} else
						JOptionPane.showMessageDialog(null, "No Students Found!");

				} // all

			}// ACTION PERFORMED

		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSearch.setBounds(325, 241, 246, 40);
		contentPane.add(btnSearch);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(837, 477, -98, 40);
		contentPane.add(btnBack);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setBounds(179, 424, -154, 73);
		contentPane.add(btnBack_1);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(SystemColor.activeCaptionBorder);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				PersonManagerWindow personManagerWindow = new PersonManagerWindow();
				setVisible(false);
				personManagerWindow.setVisible(true);
			}

		});
		btnNewButton.setBounds(10, 329, 118, 47);
		contentPane.add(btnNewButton);

		JSeparator separator = new JSeparator();
		separator.setBounds(104, 114, 507, 2);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(104, 316, 507, 2);
		contentPane.add(separator_1);

	}

	public static ArrayList<Employee> findEmployees(ArrayList<Employee> employees, String name) {

		ArrayList<Employee> foundEmployees = new ArrayList();
		foundEmployees.clear();

		for (Employee employee : employees) {
			if (employee.getName().equalsIgnoreCase(name)) {
				foundEmployees.add(employee);
			}
		}

		if (foundEmployees.size() > 0)
			return foundEmployees;

		else
			return null;
	}

	public static ArrayList<Student> findStudents(ArrayList<Student> students, String name) {

		ArrayList<Student> foundStudents = new ArrayList();
		foundStudents.clear();

		for (Student student : students) {
			if (student.getName().equals(name)) {
				foundStudents.add(student);
			}
		}

		if (foundStudents.size() > 0)
			return foundStudents;

		else
			return null;
	}

	public static void createResult2(final ArrayList<Student> foundStudents) {
		JButton btnResults = new JButton("Results");
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 40;
				int x = 0;
				for (Student student : foundStudents) {
					createStudentInfoButtons(i, x);
					i += 150;
					x++;
				}

			}
		});
		btnResults.setBounds(412, 269, 208, 79);
		contentPane.add(btnResults);
		contentPane.repaint();
	}

	/*
	 * public static void createResult3() { JButton btnResults = new
	 * JButton("Results"); btnResults.addActionListener(new ActionListener() {
	 * public void actionPerformed(ActionEvent arg0) { int i = 40; int x = 0; for
	 * (Person person : persons) { if (person instanceof Employee) {
	 * createEmployeeInfoButton(i, x);
	 * 
	 * } else if (person instanceof Student) { createStudentInfoButtons(i, x); }
	 * 
	 * i += 150; x++; }
	 * 
	 * } }); btnResults.setBounds(412, 269, 208, 79); contentPane.add(btnResults);
	 * contentPane.repaint(); }
	 */

	public static void createEmployeeInfoButton(int i, final int count) {
		JButton btnEmployee = new JButton("employee " + (count + 1));
		btnEmployee.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				EmployeeInfoWindow info = new EmployeeInfoWindow(count, false);

				info.setVisible(true);

			}

		});
		btnEmployee.setBounds(i, 400, 109, 39);
		contentPane.add(btnEmployee);
		contentPane.repaint();

	}

	public static void createStudentInfoButtons(int i, final int count) {
		JButton btnEmployee = new JButton("student " + (count + 1));
		btnEmployee.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				// StudentInfoWindow info = new StudentInfoWindow(count);

				// info.setVisible(true);

			}

		});
		btnEmployee.setBounds(i, 400, 109, 39);
		contentPane.add(btnEmployee);
		contentPane.repaint();

	}

	public static ArrayList<Person> findPersons(ArrayList<Employee> employees, ArrayList<Student> students,
			String name) {

		for (Employee employee : employees) {
			if (employee != null && employee.getName().equals(name))
				personsFound.add(employee);

		}
		for (Student student : students) {
			if (student != null && student.getName().equals(name))
				personsFound.add(student);

		}
		return personsFound;
	}

	public static ArrayList<Student> getStudentsFound() {
		return studentsFound;
	}

	public static ArrayList<Employee> getEmployeesFound() {
		return employeesFound;
	}

	public static ArrayList<Person> getPersonsFound() {
		return personsFound;
	}
}
