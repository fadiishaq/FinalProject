package windows;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import personClasses.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class EditStudentInfo extends JFrame {

	private JPanel contentPane;

	Scanner scanner = new Scanner(System.in);
	private JTextField name;
	private JTextField house;
	private JTextField city;
	private JTextField age;
	private JTextField street;
	private JTextField grade;
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

	public EditStudentInfo(final int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		
		JLabel label = new JLabel("Student");
		label.setFont(new Font("Tahoma", Font.BOLD, 43));
		label.setBounds(289, 11, 238, 90);
		contentPane.add(label);

		JButton btnOkay = new JButton("Update");
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
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CloseJframe();
			}
		});
		btnBack.setBounds(53, 458, 100, 50);
		contentPane.add(btnBack);
		
		JLabel label_1 = new JLabel("Name: ");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.BLACK);
		label_1.setFont(new Font("SansSerif", Font.BOLD, 23));
		label_1.setBounds(53, 126, 122, 45);
		contentPane.add(label_1);
		
		name = new JTextField(LoginPageWindow.getStudentsList().get(index).getName());
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(new Font("SansSerif", Font.PLAIN, 20));
		name.setColumns(10);
		name.setBounds(193, 133, 202, 42);
		contentPane.add(name);
		
		JLabel label_2 = new JLabel("House Num: ");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.BLACK);
		label_2.setFont(new Font("SansSerif", Font.BOLD, 23));
		label_2.setBounds(474, 134, 153, 29);
		contentPane.add(label_2);
		
		house = new JTextField(LoginPageWindow.getStudentsList().get(index).getAddress().getHouseNumber());
		house.setHorizontalAlignment(SwingConstants.CENTER);
		house.setFont(new Font("SansSerif", Font.PLAIN, 20));
		house.setColumns(10);
		house.setBounds(657, 133, 202, 42);
		contentPane.add(house);
		
		city = new JTextField(LoginPageWindow.getStudentsList().get(index).getAddress().getCity());
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setFont(new Font("SansSerif", Font.PLAIN, 20));
		city.setColumns(10);
		city.setBounds(657, 230, 202, 42);
		contentPane.add(city);
		
		JLabel label_3 = new JLabel("City: ");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("SansSerif", Font.BOLD, 23));
		label_3.setBounds(441, 236, 186, 29);
		contentPane.add(label_3);
		
		age = new JTextField(Integer.toString(LoginPageWindow.getStudentsList().get(index).getAge()));
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setFont(new Font("SansSerif", Font.PLAIN, 20));
		age.setColumns(10);
		age.setBounds(193, 231, 202, 42);
		contentPane.add(age);
		
		JLabel label_4 = new JLabel("Age: ");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.BLACK);
		label_4.setFont(new Font("SansSerif", Font.BOLD, 23));
		label_4.setBounds(53, 228, 122, 45);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Street: ");
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.BLACK);
		label_5.setFont(new Font("SansSerif", Font.BOLD, 23));
		label_5.setBounds(53, 325, 122, 54);
		contentPane.add(label_5);
		
		street = new JTextField(LoginPageWindow.getStudentsList().get(index).getAddress().getStreetName());
		street.setHorizontalAlignment(SwingConstants.CENTER);
		street.setFont(new Font("SansSerif", Font.PLAIN, 20));
		street.setColumns(10);
		street.setBounds(193, 337, 202, 42);
		contentPane.add(street);
		
		JLabel lblGrade = new JLabel("Grade");
		lblGrade.setHorizontalAlignment(SwingConstants.CENTER);
		lblGrade.setForeground(Color.BLACK);
		lblGrade.setFont(new Font("SansSerif", Font.BOLD, 23));
		lblGrade.setBounds(441, 338, 186, 29);
		contentPane.add(lblGrade);
		
		grade = new JTextField(Integer.toString(LoginPageWindow.getStudentsList().get(index).getGrade()));
		grade.setHorizontalAlignment(SwingConstants.CENTER);
		grade.setFont(new Font("SansSerif", Font.PLAIN, 20));
		grade.setColumns(10);
		grade.setBounds(657, 332, 202, 42);
		contentPane.add(grade);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(81, 199, 314, 5);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(474, 199, 385, 5);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(474, 309, 385, 5);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(81, 309, 314, 5);
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
		LoginPageWindow.getEmployeesList().get(index).setSalary(Integer.parseInt(grade.getText()));

		EmployeeInfoWindow win = new EmployeeInfoWindow(index, false);
	}
	
	
	
	
	
public void updateInfo3(int index) {

/*		int i = 0;
		for (Employee employee : AddEmployeeWindow.getEmployees()) {
			System.out.println(i + ": " + employee.getName());
			i++;
		}*/
		
	LoginPageWindow.getStudentsList().get(index).setName(name.getText());
	LoginPageWindow.getStudentsList().get(index).setAge(Integer.parseInt(age.getText()));
	LoginPageWindow.getStudentsList().get(index).getAddress().setStreetName(street.getText());
	LoginPageWindow.getStudentsList().get(index).getAddress().setHouseNumber(house.getText());
	LoginPageWindow.getStudentsList().get(index).getAddress().setCity(city.getText());
	LoginPageWindow.getStudentsList().get(index).setGrade(Integer.parseInt(grade.getText()));

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
		LoginPageWindow.getEmployeesList().get(input).setSalary(Integer.parseInt(grade.getText()));

		EmployeeInfoWindow win = new EmployeeInfoWindow(input, false);
	}
}