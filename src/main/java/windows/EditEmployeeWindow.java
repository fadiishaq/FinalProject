package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import personClasses.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class EditEmployeeWindow extends JFrame {
	 private Dimension dl, db, center; 

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

			// display window in the center
			center = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation(center.width / 2 - getSize().width / 2, center.height / 2 - getSize().height / 2);

		
		JLabel label = new JLabel("Employee");
		label.setFont(new Font("Tahoma", Font.BOLD, 43));
		label.setBounds(289, 11, 238, 90);
		contentPane.add(label);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		nameLabel.setBounds(75, 126, 142, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age: ");
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		ageLabel.setBounds(54, 244, 115, 29);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street: ");
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		streetLabel.setBounds(54, 338, 115, 29);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Num: ");
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		houseLabel.setBounds(475, 134, 186, 29);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City: ");
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		cityLabel.setBounds(532, 244, 100, 29);
		contentPane.add(cityLabel);

		JLabel salaryLabel = new JLabel("Salary: ");
		salaryLabel.setForeground(Color.BLACK);
		salaryLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		salaryLabel.setBounds(539, 350, 122, 29);
		contentPane.add(salaryLabel);

		name = new JTextField(LoginPageWindow.getEmployeesList().get(index).getName());
		name.setBounds(227, 133, 202, 42);
		contentPane.add(name);
		name.setColumns(10);
		
		name.getDocument().addDocumentListener(new DocumentListener() {
			  public void changedUpdate(DocumentEvent e) {
			    doSomethingInAnotherTextfield();
			  }
			  public void removeUpdate(DocumentEvent e) {
			    doSomethingInAnotherTextfield();
			  }
			  public void insertUpdate(DocumentEvent e) {
			    doSomethingInAnotherTextfield();
			  }

			  public void doSomethingInAnotherTextfield() {
			     //whatever you have to do
			  }
			});

		age = new JTextField(Integer.toString(LoginPageWindow.getEmployeesList().get(index).getAge()));
		age.setColumns(10);
		age.setBounds(227, 243, 202, 42);
		contentPane.add(age);

		street = new JTextField(LoginPageWindow.getEmployeesList().get(index).getAddress().getStreetName());
		street.setColumns(10);
		street.setBounds(227, 337, 202, 42);
		contentPane.add(street);

		house = new JTextField(LoginPageWindow.getEmployeesList().get(index).getAddress().getHouseNumber());
		house.setColumns(10);
		house.setBounds(691, 133, 202, 42);
		contentPane.add(house);

		city = new JTextField(LoginPageWindow.getEmployeesList().get(index).getAddress().getCity());
		city.setColumns(10);
		city.setBounds(691, 243, 202, 42);
		contentPane.add(city);

		salary = new JTextField(Integer.toString(LoginPageWindow.getEmployeesList().get(index).getSalary()));
		salary.setColumns(10);
		salary.setBounds(691, 349, 202, 42);
		contentPane.add(salary);

		JButton btnOkay = new JButton("Update");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateInfo3(index);
				CloseJframe();
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

		EmployeeInfoWindow win = new EmployeeInfoWindow(index, false);
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