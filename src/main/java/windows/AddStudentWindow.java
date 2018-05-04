package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.Employee;
import personClasses.Student;
import testPackage.PersonManagerTest;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;

public class AddStudentWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField street;
	private JTextField grade;
	private JTextField house;
	private JTextField city;

	private static ArrayList<Student> students = new ArrayList<Student>();
	private static int numOfStudents = 0;

	public static void addNumOfStudents() {
		numOfStudents++;
	}

	public static int getNumOfStudents() {
		return numOfStudents;
	}

	public static void setNumOfEmployees(int numOfEmployees) {
		AddStudentWindow.numOfStudents = numOfStudents;
	}

	public static ArrayList<Student> getStudents() {
		return students;
	}

	public static void setEmployees(ArrayList<Employee> employees) {
		AddStudentWindow.students = students;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddStudentWindow frame = new AddStudentWindow();
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
	public AddStudentWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddEmployee = new JLabel("Add Student");
		lblAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 71));
		lblAddEmployee.setBounds(155, 11, 569, 73);
		contentPane.add(lblAddEmployee);

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

		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblGrade.setBounds(441, 394, 81, 78);
		contentPane.add(lblGrade);

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

		grade = new JTextField();
		grade.setColumns(10);
		grade.setBounds(546, 408, 248, 58);
		contentPane.add(grade);

		JButton btnAddEmployee = new JButton("Add Student");
		btnAddEmployee.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Student student = new Student(name.getText(), Integer.parseInt(age.getText()), street.getText(),
							house.getText(), city.getText(), Integer.parseInt(grade.getText()));

					students.add(student);
					addNumOfStudents();
					StudentInfoWindow studentInfoWindow = new StudentInfoWindow(getNumOfStudents()-1);
					studentInfoWindow.setVisible(true);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong input!");
				}

			}

		});
		btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAddEmployee.setBounds(290, 518, 258, 58);
		contentPane.add(btnAddEmployee);

		JLabel lblHouseNum = new JLabel("House Num");
		lblHouseNum.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHouseNum.setBounds(406, 146, 152, 78);
		contentPane.add(lblHouseNum);

		house = new JTextField();
		house.setColumns(10);
		house.setBounds(546, 160, 248, 58);
		contentPane.add(house);

		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCity.setBounds(441, 263, 152, 78);
		contentPane.add(lblCity);

		city = new JTextField();
		city.setColumns(10);
		city.setBounds(546, 277, 248, 58);
		contentPane.add(city);
	}

}
