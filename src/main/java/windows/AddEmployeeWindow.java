package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.Employee;
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

public class AddEmployeeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField street;
	private JTextField salary;
	private JTextField house;
	private JTextField city;

	private static ArrayList<Employee> employees = new ArrayList<Employee>();
	private static int numOfEmployees = 0;

	public static void addNumOfEmployees() {
		numOfEmployees++;
	}

	public static int getNumOfEmployees() {
		return numOfEmployees;
	}

	public static void setNumOfEmployees(int numOfEmployees) {
		AddEmployeeWindow.numOfEmployees = numOfEmployees;
	}

	public static ArrayList<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(ArrayList<Employee> employees) {
		AddEmployeeWindow.employees = employees;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddEmployeeWindow frame = new AddEmployeeWindow();
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
	public AddEmployeeWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddEmployee = new JLabel("Add Employee");
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

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblSalary.setBounds(441, 394, 81, 78);
		contentPane.add(lblSalary);

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

		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(546, 408, 248, 58);
		contentPane.add(salary);

		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					Employee employee = new Employee(name.getText(), Integer.parseInt(age.getText()), street.getText(),
							house.getText(), city.getText(), Integer.parseInt(salary.getText()));

					employees.add(employee);
					addNumOfEmployees();
					//JOptionPane.showMessageDialog(null, getNumOfEmployees());
					EmployeeInfoWindow employeeInfo = new EmployeeInfoWindow(numOfEmployees - 1);
					employeeInfo.setVisible(true);
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
