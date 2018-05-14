package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.annotation.JacksonAnnotation;

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
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Component;
import javax.swing.Box;

public class AddEmployeeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField street;
	private JTextField salary;
	private JTextField house;
	private JTextField city;

	//private static ArrayList<Employee> employees = LoginPageWindow.getEmployeesList();




/*	public static ArrayList<Employee> getEmployees() {
		return employees;
	}

	public static void setEmployees(ArrayList<Employee> employees) {
		AddEmployeeWindow.employees = employees;
	}*/

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
		setBounds(100, 100, 622, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblAddEmployee = new JLabel("Add Employee");
		lblAddEmployee.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 49));
		lblAddEmployee.setBounds(139, 11, 413, 73);
		contentPane.add(lblAddEmployee);

		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblName.setBounds(138, 117, 95, 49);
		contentPane.add(lblName);

		JLabel lblAge = new JLabel("Age");
		lblAge.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblAge.setBounds(138, 199, 95, 52);
		contentPane.add(lblAge);

		JLabel lblAddress = new JLabel("Street");
		lblAddress.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblAddress.setBounds(138, 286, 95, 52);
		contentPane.add(lblAddress);

		JLabel lblSalary = new JLabel("Salary");
		lblSalary.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblSalary.setBounds(138, 553, 95, 49);
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
		name.setBackground(SystemColor.textHighlightText);
		name.setBounds(243, 126, 248, 38);
		contentPane.add(name);
		name.setColumns(10);

		age = new JTextField();
		age.setBackground(SystemColor.textHighlightText);
		age.setColumns(10);
		age.setBounds(243, 210, 248, 38);
		contentPane.add(age);

		street = new JTextField();
		street.setBackground(SystemColor.textHighlightText);
		street.setColumns(10);
		street.setBounds(243, 297, 248, 38);
		contentPane.add(street);

		salary = new JTextField();
		salary.setBackground(SystemColor.textHighlightText);
		salary.setColumns(10);
		salary.setBounds(243, 566, 248, 38);
		contentPane.add(salary);

		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBackground(new Color(192, 192, 192));
		btnAddEmployee.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					
					Employee employee = new Employee(name.getText(), Integer.parseInt(age.getText()), street.getText(),
							house.getText(), city.getText(), Integer.parseInt(salary.getText()));

					LoginPageWindow.getEmployeesList().add(employee);
					
					EmployeeInfoWindow employeeInfo = new EmployeeInfoWindow(LoginPageWindow.getEmployeesList().size() - 1, false);
					setVisible(false);
					employeeInfo.setVisible(true);
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong input!");
				}

			}

		});
		btnAddEmployee.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 33));
		btnAddEmployee.setBounds(152, 655, 400, 67);
		contentPane.add(btnAddEmployee);

		JLabel lblHouseNum = new JLabel("House Number");
		lblHouseNum.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblHouseNum.setBounds(56, 376, 177, 52);
		contentPane.add(lblHouseNum);

		house = new JTextField();
		house.setBackground(SystemColor.textHighlightText);
		house.setColumns(10);
		house.setBounds(243, 387, 248, 38);
		contentPane.add(house);

		JLabel lblCity = new JLabel("City");
		lblCity.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblCity.setBounds(152, 465, 81, 49);
		contentPane.add(lblCity);

		city = new JTextField();
		city.setBackground(SystemColor.textHighlightText);
		city.setColumns(10);
		city.setBounds(243, 474, 248, 38);
		contentPane.add(city);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 15));
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				AddPersonWindow win = new AddPersonWindow();
				setVisible(false);
				win.setVisible(true);
				
			}
		});
		btnBack_1.setBounds(42, 655, 81, 67);
		contentPane.add(btnBack_1);
	}
}
