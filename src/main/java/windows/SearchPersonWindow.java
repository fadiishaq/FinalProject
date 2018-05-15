package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javafx.beans.binding.When;
import personClasses.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JEditorPane;

public class SearchPersonWindow extends JFrame {

	private Dimension dl, db, center;

	private static JPanel contentPane;
	private JTextField name;
	private ArrayList<Student> studentsFound = new ArrayList();
	private static ArrayList<Employee> employeesFound = new ArrayList();
	private ArrayList<Administator> adminsFound = new ArrayList();
	ArrayList<JFrame> windowsList = new ArrayList();
	JLabel PeopleFoundLabel;
	JLabel nPeopleFound;
	int count;

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
	private JTextField numOfPeople;
	private JTextField numOfPersons;
	static ArrayList<Person> persons;

	public SearchPersonWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 744, 551);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// display window in the center
		center = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(center.width / 2 - getSize().width / 2, center.height / 2 - getSize().height / 2);

		JLabel lblNewLabel = new JLabel("Search Person");
		lblNewLabel.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 47));
		lblNewLabel.setBounds(188, 11, 453, 79);
		contentPane.add(lblNewLabel);

		JLabel lblEnterNameTo = new JLabel("Enter name to search");
		lblEnterNameTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEnterNameTo.setBounds(42, 114, 231, 41);
		contentPane.add(lblEnterNameTo);

		name = new JTextField();
		name.setBounds(236, 115, 246, 40);
		contentPane.add(name);
		name.setColumns(10);

		employeeBox = new JCheckBox("Employee");
		employeeBox.setBounds(246, 162, 87, 23);
		contentPane.add(employeeBox);

		studentBox = new JCheckBox("Student");
		studentBox.setBounds(331, 162, 70, 23);
		contentPane.add(studentBox);

		unlimitedBox = new JCheckBox("Unlimited");
		unlimitedBox.setBounds(403, 162, 97, 23);
		contentPane.add(unlimitedBox);

		JLabel lblChoose = new JLabel("choose ");
		lblChoose.setBounds(166, 166, 60, 19);
		contentPane.add(lblChoose);

		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if ((employeeBox.isSelected() || studentBox.isSelected()) && unlimitedBox.isSelected())
					JOptionPane.showMessageDialog(null, "Please check one box only");

				else if ((employeeBox.isSelected() && studentBox.isSelected()) && unlimitedBox.isSelected())
					JOptionPane.showMessageDialog(null, "Please check one box only");

				else if (employeeBox.isSelected()) {

					if (employeesFound.size() > 0)
						employeesFound.clear();

					employeesFound = findEmployees(LoginPageWindow.getEmployeesList(), name.getText());

					if (employeesFound.size() > 0) {

						if (employeesFound.size() == 1) {
							EmployeeInfoWindow win = new EmployeeInfoWindow(0, false);
							win.setVisible(true);
						}

					} else {
						JOptionPane.showMessageDialog(null, "no employees");
					}

					/*
					 * for (int i = 0; i < employeesFound.size(); i++) {
					 * 
					 * EmployeeInfoWindow win = new
					 * EmployeeInfoWindow(employeesFound.get(i).getNum() + 1, false);
					 * windowsList.add(win); win.setVisible(true);
					 * 
					 * }
					 */

				}

				else if (studentBox.isSelected()) {

					if (studentsFound.size() > 0)
						studentsFound.clear();

					studentsFound = findStudents(LoginPageWindow.getStudentsList(), name.getText());

					if (studentsFound == null) {
						JOptionPane.showMessageDialog(null, "no students found");
					}

					else {
						createTextField(studentsFound.size());
						createResult2(studentsFound);

					}

				}

				else if (unlimitedBox.isSelected()) {
					ArrayList<Person> persons = searchAll(LoginPageWindow.getEmployeesList(),
							LoginPageWindow.getStudentsList());

					if (persons.size() < 1)
						JOptionPane.showMessageDialog(null, "no results found");

					else {
						createTextField(persons.size());
						createResult3();

					}

				}

			}// ACTION PERFORMED

		});
		btnSearch.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnSearch.setBounds(236, 192, 246, 29);
		contentPane.add(btnSearch);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(837, 477, -98, 40);
		contentPane.add(btnBack);

		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setBounds(179, 424, -154, 73);
		contentPane.add(btnBack_1);

		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				PersonManagerWindow personManagerWindow = new PersonManagerWindow();
				setVisible(false);
				personManagerWindow.setVisible(true);
			}

		});
		btnNewButton.setBounds(10, 454, 118, 47);
		contentPane.add(btnNewButton);

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

	public static void createTextField(int numOfResults) {
		JTextField textField = new JTextField(numOfResults + " results found");
		textField.setBounds(615, 153, 246, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.repaint();

	}

	public static void createResult(final ArrayList<Employee> foundEmployees) {
		JButton btnResults = new JButton("Results");
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 40;
				int x = 0;

				for (Employee employee : foundEmployees) {
					createEmployeeInfoButton(i, x);
					i += 150;
					x++;
				}

			}
		});
		btnResults.setBounds(412, 269, 208, 79);
		contentPane.add(btnResults);
		contentPane.repaint();
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

	public static void createResult3() {
		JButton btnResults = new JButton("Results");
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 40;
				int x = 0;
				for (Person person : persons) {
					if (person instanceof Employee) {
						createEmployeeInfoButton(i, x);

					} else if (person instanceof Student) {
						createStudentInfoButtons(i, x);
					}

					i += 150;
					x++;
				}

			}
		});
		btnResults.setBounds(412, 269, 208, 79);
		contentPane.add(btnResults);
		contentPane.repaint();
	}

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

				StudentInfoWindow info = new StudentInfoWindow(count);

				info.setVisible(true);

			}

		});
		btnEmployee.setBounds(i, 400, 109, 39);
		contentPane.add(btnEmployee);
		contentPane.repaint();

	}

	public static ArrayList<Person> searchAll(ArrayList<Employee> employees, ArrayList<Student> students) {

		persons = new ArrayList();

		/*
		 * for (int i = 0; (i < employees.size() + students.size() - 1); i++) {
		 * if(employees.get(i) != null) persons.add(employees.get(i));
		 * 
		 * if(students.get(i) != null) persons.add(students.get(i));
		 * 
		 * if(students.get(i) == null && employees.get(i) == null) { break; } }
		 */

		for (Employee employee : LoginPageWindow.getEmployeesList()) {
			if (employee != null)
				persons.add(employee);

		}
		for (Student student : LoginPageWindow.getStudentsList()) {
			if (student != null)
				persons.add(student);

		}
		return persons;
	}

	public ArrayList<Student> getStudentsFound() {
		return studentsFound;
	}

	public static ArrayList<Employee> getEmployeesFound() {
		return employeesFound;
	}

	public ArrayList<Administator> getAdminsFound() {
		return adminsFound;
	}
}
