package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SearchPersonWindow extends JFrame {

	private static JPanel contentPane;
	private JTextField name;
	ArrayList<Student> studentsFound;
	ArrayList<Employee> employeesFound;
	ArrayList<Administator> adminsFound;
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

	public SearchPersonWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 952, 592);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Search Person");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblNewLabel.setBounds(236, 11, 488, 79);
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

				if ((employeeBox.isSelected() && studentBox.isSelected()) || unlimitedBox.isSelected())
					JOptionPane.showMessageDialog(null, "Please check one box only");

				if (employeeBox.isSelected()) {
					employeesFound = findEmployees(AddEmployeeWindow.getEmployees(), name.getText());

					if (employeesFound == null) {
						JOptionPane.showMessageDialog(null, "no employees found");
					}

					else {
						createTextField();
						createResult();

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
				personManagerWindow.setVisible(true);
			}
		});
		btnNewButton.setBounds(10, 495, 118, 47);
		contentPane.add(btnNewButton);

	}

	public static ArrayList<Employee> findEmployees(ArrayList<Employee> employees, String name) {

		ArrayList<Employee> foundEmployees = new ArrayList();

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

	public static void createTextField() {
		JTextField textField = new JTextField(AddEmployeeWindow.getEmployees().size() + " employees found");
		textField.setBounds(615, 153, 246, 40);
		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.repaint();

	}

	public static void createResult() {
		JButton btnResults = new JButton("Results");
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i = 40;
				int x =0;
				for (Employee employee : AddEmployeeWindow.getEmployees()) {
					createInfoButtons(i, x);
					i += 150;
					x++;
				}

			}
		});
		btnResults.setBounds(412, 269, 208, 79);
		contentPane.add(btnResults);
		contentPane.repaint();
	}

	public static void createInfoButtons(int i, final int count) {
		JButton btnEmployee = new JButton("employee " + (count + 1));
		btnEmployee.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				EmployeeInfoWindow info = new EmployeeInfoWindow(count);

				info.setVisible(true);

			}

		});
		btnEmployee.setBounds(i, 400, 109, 39);
		contentPane.add(btnEmployee);
		contentPane.repaint();

	}

}
