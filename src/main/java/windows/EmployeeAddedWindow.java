package windows;

import testPackage.PersonManagerTest;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JTextArea;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class EmployeeAddedWindow extends JFrame {

	private JPanel contentPane;
	private JLabel name;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeAddedWindow frame = new EmployeeAddedWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public EmployeeAddedWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnewEmployee = new JLabel("New Employee Added!");
		lblnewEmployee.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblnewEmployee.setBounds(143, 11, 571, 90);
		contentPane.add(lblnewEmployee);
		
		
		name = new JLabel("Name: " );
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		name.setBounds(143, 133, 515, 45);
		contentPane.add(name);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(131, 187, 500, 15);
		contentPane.add(separator);
		
		JLabel age = new JLabel("Age: " +AddEmployeeWindow.getEmployees().get(AddEmployeeWindow.getNumOfEmployees() - 1).getAge());
		age.setForeground(Color.BLACK);
		age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		age.setBounds(141, 213, 490, 29);
		contentPane.add(age);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddEmployeeWindow addEmployeeWindow = new AddEmployeeWindow();
				addEmployeeWindow.setVisible(true);
				
			}
		});
		btnOk.setBounds(247, 559, 273, 45);
		contentPane.add(btnOk);
		
		JLabel street = new JLabel("Street: " +AddEmployeeWindow.getEmployees().
				get(AddEmployeeWindow.getNumOfEmployees() - 1).getAddress().getStreetName());
		street.setForeground(Color.BLACK);
		street.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		street.setBounds(143, 282, 490, 29);
		contentPane.add(street);
		
		JLabel house = new JLabel("House Num: " +AddEmployeeWindow.getEmployees().
				get(AddEmployeeWindow.getNumOfEmployees() - 1).getAddress().getHouseNumber());
		house.setForeground(Color.BLACK);
		house.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		house.setBounds(143, 354, 490, 29);
		contentPane.add(house);
		
		JLabel city = new JLabel("City: " +AddEmployeeWindow.getEmployees().
				get(AddEmployeeWindow.getNumOfEmployees() - 1).getAddress().getCity());
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		city.setBounds(131, 431, 490, 29);
		contentPane.add(city);
		
		JLabel salary = new JLabel("Salary: " +AddEmployeeWindow.getEmployees().
				get(AddEmployeeWindow.getNumOfEmployees() - 1).getSalary());
		salary.setForeground(Color.BLACK);
		salary.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		salary.setBounds(143, 497, 490, 29);
		contentPane.add(salary);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(131, 256, 500, 15);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(131, 328, 500, 15);
		contentPane.add(separator_2);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(131, 405, 500, 15);
		contentPane.add(separator_3);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(131, 471, 500, 15);
		contentPane.add(separator_4);
		
		JSeparator separator_5 = new JSeparator();
		separator_5.setBounds(10, 96, 784, 15);
		contentPane.add(separator_5);
	}
}
