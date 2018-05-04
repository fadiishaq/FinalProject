package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentInfoWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfoWindow frame = new StudentInfoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// main

	/**
	 * Create the frame.
	 */

	public StudentInfoWindow(int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Student");
		label.setFont(new Font("Tahoma", Font.BOLD, 43));
		label.setBounds(168, 11, 571, 90);
		contentPane.add(label);

		JLabel name = new JLabel("Name: " + AddStudentWindow.getStudents().get(index).getName());
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		name.setBounds(37, 122, 515, 45);
		contentPane.add(name);

		JLabel age = new JLabel("Age: " + AddStudentWindow.getStudents().get(index).getAge());
		age.setForeground(Color.BLACK);
		age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		age.setBounds(37, 195, 490, 29);
		contentPane.add(age);

		JLabel street = new JLabel(
				"Street: " + AddStudentWindow.getStudents().get(index).getAddress().getStreetName());
		street.setForeground(Color.BLACK);
		street.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		street.setBounds(36, 259, 490, 29);
		contentPane.add(street);

		JLabel house = new JLabel(
				"House Num: " + AddStudentWindow.getStudents().get(index).getAddress().getHouseNumber());
		house.setForeground(Color.BLACK);
		house.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		house.setBounds(37, 311, 490, 29);
		contentPane.add(house);

		JLabel city = new JLabel("City: " + AddStudentWindow.getStudents().get(index).getAddress().getCity());
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		city.setBounds(52, 372, 490, 29);
		contentPane.add(city);

		JLabel salary = new JLabel("Salary: " + AddStudentWindow.getStudents().get(index).getGrade());
		salary.setForeground(Color.BLACK);
		salary.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		salary.setBounds(52, 431, 490, 29);
		contentPane.add(salary);
		
		JButton btnOkay = new JButton("OKAY");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPersonWindow addPersonWindow = new AddPersonWindow();
				addPersonWindow.setVisible(true);
			}
		});
		btnOkay.setBounds(208, 454, 455, 54);
		contentPane.add(btnOkay);
		
		

	}

	public StudentInfoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewStudentAdded = new JLabel("Student");
		lblNewStudentAdded.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblNewStudentAdded.setBounds(168, 11, 571, 90);
		contentPane.add(lblNewStudentAdded);

		JLabel name = new JLabel("Name: " );
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		name.setBounds(156, 94, 515, 45);
		contentPane.add(name);

		JLabel age = new JLabel("Age: 0");
		age.setForeground(Color.BLACK);
		age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		age.setBounds(156, 167, 490, 29);
		contentPane.add(age);

		JLabel street = new JLabel("Street: <dynamic>");
		street.setForeground(Color.BLACK);
		street.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		street.setBounds(155, 231, 490, 29);
		contentPane.add(street);

		JLabel house = new JLabel("House Num: <dynamic>");
		house.setForeground(Color.BLACK);
		house.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		house.setBounds(156, 283, 490, 29);
		contentPane.add(house);

		JLabel city = new JLabel("City: <dynamic>");
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		city.setBounds(171, 344, 490, 29);
		contentPane.add(city);

		JLabel salary = new JLabel("Salary: 0");
		salary.setForeground(Color.BLACK);
		salary.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		salary.setBounds(171, 403, 490, 29);
		contentPane.add(salary);

		JSeparator separator = new JSeparator();
		separator.setBounds(141, 139, 500, 15);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(98, 207, 500, 15);
		contentPane.add(separator_1);

		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(77, 271, 500, 15);
		contentPane.add(separator_2);

		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(77, 318, 500, 15);
		contentPane.add(separator_3);

		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(77, 384, 500, 15);
		contentPane.add(separator_4);
		
		JButton btnOkay = new JButton("OKAY");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPersonWindow addPersonWindow = new AddPersonWindow();
				addPersonWindow.setVisible(true);
			}
		});
		btnOkay.setBounds(208, 454, 455, 54);
		contentPane.add(btnOkay);

	}
}