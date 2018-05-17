package windows;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class EditEmployeeWindow extends JFrame {

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField street;
	private JTextField house;
	private JTextField city;
	private JTextField salary;

	Scanner scanner = new Scanner(System.in);
	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					AddEmployeeWindow.getEmployees().add(new Employee("fadi", 19, "steh", "2999", "sahour", 19999));
					EditEmployeeWindow frame = new EditEmployeeWindow(0);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// main
*/
	/**
	 * Create the frame.
	 */

	public EditEmployeeWindow(final int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblUpdateEmployee = new JLabel("Update Employee");
		lblUpdateEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		lblUpdateEmployee.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 44));
		lblUpdateEmployee.setBounds(263, 11, 414, 90);
		contentPane.add(lblUpdateEmployee);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("SansSerif", Font.BOLD, 23));
		nameLabel.setBounds(87, 126, 122, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age: ");
		ageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("SansSerif", Font.BOLD, 23));
		ageLabel.setBounds(87, 228, 122, 45);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street: ");
		streetLabel.setHorizontalAlignment(SwingConstants.CENTER);
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("SansSerif", Font.BOLD, 23));
		streetLabel.setBounds(87, 325, 122, 54);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Num: ");
		houseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("SansSerif", Font.BOLD, 23));
		houseLabel.setBounds(508, 134, 153, 29);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City: ");
		cityLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("SansSerif", Font.BOLD, 23));
		cityLabel.setBounds(475, 236, 186, 29);
		contentPane.add(cityLabel);

		JLabel salaryLabel = new JLabel("Salary: ");
		salaryLabel.setHorizontalAlignment(SwingConstants.CENTER);
		salaryLabel.setForeground(Color.BLACK);
		salaryLabel.setFont(new Font("SansSerif", Font.BOLD, 23));
		salaryLabel.setBounds(475, 338, 186, 29);
		contentPane.add(salaryLabel);

		name = new JTextField(LoginPageWindow.getEmployeesList().get(index).getName());
		name.setFont(new Font("SansSerif", Font.PLAIN, 20));
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBounds(227, 133, 202, 42);
		contentPane.add(name);
		name.setColumns(10);
		


		age = new JTextField(Integer.toString(LoginPageWindow.getEmployeesList().get(index).getAge()));
		age.setFont(new Font("SansSerif", Font.PLAIN, 20));
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setColumns(10);
		age.setBounds(227, 231, 202, 42);
		contentPane.add(age);

		street = new JTextField(LoginPageWindow.getEmployeesList().get(index).getAddress().getStreetName());
		street.setFont(new Font("SansSerif", Font.PLAIN, 20));
		street.setHorizontalAlignment(SwingConstants.CENTER);
		street.setColumns(10);
		street.setBounds(227, 337, 202, 42);
		contentPane.add(street);

		house = new JTextField(LoginPageWindow.getEmployeesList().get(index).getAddress().getHouseNumber());
		house.setFont(new Font("SansSerif", Font.PLAIN, 20));
		house.setHorizontalAlignment(SwingConstants.CENTER);
		house.setColumns(10);
		house.setBounds(691, 133, 202, 42);
		contentPane.add(house);

		city = new JTextField(LoginPageWindow.getEmployeesList().get(index).getAddress().getCity());
		city.setFont(new Font("SansSerif", Font.PLAIN, 20));
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setColumns(10);
		city.setBounds(691, 230, 202, 42);
		contentPane.add(city);

		salary = new JTextField(Integer.toString(LoginPageWindow.getEmployeesList().get(index).getSalary()));
		salary.setFont(new Font("SansSerif", Font.PLAIN, 20));
		salary.setHorizontalAlignment(SwingConstants.CENTER);
		salary.setColumns(10);
		salary.setBounds(691, 332, 202, 42);
		contentPane.add(salary);

		JButton btnOkay = new JButton("Update");
		btnOkay.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfo3(index);
				setVisible(false);
				JOptionPane.showMessageDialog(null, "Info has been updated!");

			}
		});
		btnOkay.setBounds(357, 454, 455, 54);
		contentPane.add(btnOkay);
		
		JButton btnBack = new JButton("Close");
		btnBack.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseJframe();
			}
		});
		btnBack.setBounds(10, 458, 100, 50);
		contentPane.add(btnBack);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(115, 199, 314, 5);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(115, 309, 314, 5);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(508, 199, 385, 5);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(508, 309, 385, 5);
		contentPane.add(separator_3);

	}

	// -------------------------------------------------
	// -------------------------------------------------
	// -------------------------------------------------
	// -------------------------------------------------
	

	/*public EditEmployeeWindow() {
		setDefault
Operation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Employee");
		label.setFont(new Font("Tahoma", Font.BOLD, 43));
		label.setBounds(328, 0, 279, 90);
		contentPane.add(label);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		nameLabel.setBounds(156, 94, 121, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age: ");
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		ageLabel.setBounds(156, 167, 81, 29);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street:");
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		streetLabel.setBounds(155, 231, 122, 29);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Num: ");
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		houseLabel.setBounds(156, 283, 212, 29);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City: ");
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		cityLabel.setBounds(171, 344, 121, 29);
		contentPane.add(cityLabel);

		JLabel salaryLabel = new JLabel("Salary: ");
		salaryLabel.setForeground(Color.BLACK);
		salaryLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		salaryLabel.setBounds(171, 403, 133, 29);
		contentPane.add(salaryLabel);

		JButton btnOkay = new JButton("Update");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnOkay.setBounds(208, 454, 455, 54);
		contentPane.add(btnOkay);

		name = new JTextField();
		name.setBounds(449, 101, 202, 42);
		contentPane.add(name);
		name.setColumns(10);

		age = new JTextField();
		age.setColumns(10);
		age.setBounds(449, 154, 202, 42);
		contentPane.add(age);

		street = new JTextField();
		street.setColumns(10);
		street.setBounds(437, 218, 202, 42);
		contentPane.add(street);

		house = new JTextField();
		house.setColumns(10);
		house.setBounds(437, 270, 202, 42);
		contentPane.add(house);

		city = new JTextField();
		city.setColumns(10);
		city.setBounds(437, 331, 202, 42);
		contentPane.add(city);

		salary = new JTextField();
		salary.setColumns(10);
		salary.setBounds(426, 390, 202, 42);
		contentPane.add(salary);

	}*/

	public void CloseJframe() {
		super.dispose();
	}

	public void updateInfo(int index) {
		

			
		
		
		LoginPageWindow.getEmployeesList().get(index).setName(name.getText());
		LoginPageWindow.getEmployeesList().get(index).setAge(Integer.parseInt(age.getText()));
		LoginPageWindow.getEmployeesList().get(index).getAddress().setStreetName(street.getText());
		LoginPageWindow.getEmployeesList().get(index).getAddress().setHouseNumber(house.getText());
		LoginPageWindow.getEmployeesList().get(index).getAddress().setCity(city.getText());
		LoginPageWindow.getEmployeesList().get(index).setSalary(Integer.parseInt(salary.getText()));

	}
	
	
	
	
	
public void updateInfo3(int x) {

/*		int i = 0;
		for (Employee employee : AddEmployeeWindow.getEmployees()) {
			System.out.println(i + ": " + employee.getName());
			i++;
		}*/
		
	LoginPageWindow.getEmployeesList().get(x).setName(name.getText());
	LoginPageWindow.getEmployeesList().get(x).setAge(Integer.parseInt(age.getText()));
	LoginPageWindow.getEmployeesList().get(x).getAddress().setStreetName(street.getText());
	LoginPageWindow.getEmployeesList().get(x).getAddress().setHouseNumber(house.getText());
	LoginPageWindow.getEmployeesList().get(x).getAddress().setCity(city.getText());
	LoginPageWindow.getEmployeesList().get(x).setSalary(Integer.parseInt(salary.getText()));

		EditEmployeeWindow w = new EditEmployeeWindow(x);
		//EmployeeInfoWindow win = new EmployeeInfoWindow(x);
	}











	
public void updateInfo2(Scanner scanner) {
		
		int i = 0;
		for (Employee employee : LoginPageWindow.getEmployeesList()) {
			System.out.println(i + ": " +employee.getName());
			i++;
		} 
		
		int input = scanner.nextInt();
			
		
		
		LoginPageWindow.getEmployeesList().get(input).setName(name.getText());
		LoginPageWindow.getEmployeesList().get(input).setAge(Integer.parseInt(age.getText()));
		LoginPageWindow.getEmployeesList().get(input).getAddress().setStreetName(street.getText());
		LoginPageWindow.getEmployeesList().get(input).getAddress().setHouseNumber(house.getText());
		LoginPageWindow.getEmployeesList().get(input).getAddress().setCity(city.getText());
		LoginPageWindow.getEmployeesList().get(input).setSalary(Integer.parseInt(salary.getText()));

		EmployeeInfoWindow win = new EmployeeInfoWindow(input, false);
	}
	
	
}