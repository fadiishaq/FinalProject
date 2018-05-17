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
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

public class AddStudentWindow extends JFrame {

	private Dimension dl, db, center;

	private JPanel contentPane;
	private JTextField name;
	private JTextField age;
	private JTextField street;
	private JTextField house;
	private JTextField city;
	private JTextField grade;

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
		setBounds(100, 100, 580, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// display window in the center
		center = Toolkit.getDefaultToolkit().getScreenSize();
		setLocation(center.width / 2 - getSize().width / 2, center.height / 2 - getSize().height / 2);

		JLabel lblAddEmployee = new JLabel("Add Student");
		lblAddEmployee.setFont(new Font("SansSerif", Font.BOLD, 48));
		lblAddEmployee.setBounds(125, 32, 371, 73);
		contentPane.add(lblAddEmployee);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
			}
		});
		btnBack.setBounds(48, 642, 81, 80);
		contentPane.add(btnBack);

		JButton btnAddEmployee = new JButton("Add Student");
		btnAddEmployee.setBackground(Color.LIGHT_GRAY);
		btnAddEmployee.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {

					Student student = new Student(name.getText(), Integer.parseInt(age.getText()), street.getText(),
							house.getText(), city.getText(), Integer.parseInt(grade.getText()),
							LoginPageWindow.getStudentsList().size());

					LoginPageWindow.getStudentsList().add(student);

					StudentInfoWindow win = new StudentInfoWindow(LoginPageWindow.getStudentsList().size() - 1, false);
					setVisible(false);
					win.setVisible(true);

				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong input!");
				}

			}

		});
		btnAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 24));
		btnAddEmployee.setBounds(155, 638, 341, 84);
		contentPane.add(btnAddEmployee);

		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(105, 133, 95, 49);
		contentPane.add(label);

		name = new JTextField();
		name.setColumns(10);
		name.setBackground(Color.WHITE);
		name.setBounds(210, 142, 248, 38);
		contentPane.add(name);

		JLabel label_1 = new JLabel("Age");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(105, 209, 95, 52);
		contentPane.add(label_1);

		age = new JTextField();
		age.setColumns(10);
		age.setBackground(Color.WHITE);
		age.setBounds(210, 220, 248, 38);
		contentPane.add(age);

		JLabel label_2 = new JLabel("Street");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(105, 291, 95, 52);
		contentPane.add(label_2);

		street = new JTextField();
		street.setColumns(10);
		street.setBackground(Color.WHITE);
		street.setBounds(210, 302, 248, 38);
		contentPane.add(street);

		JLabel label_3 = new JLabel("House Number");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(48, 369, 152, 52);
		contentPane.add(label_3);

		house = new JTextField();
		house.setColumns(10);
		house.setBackground(Color.WHITE);
		house.setBounds(210, 380, 248, 38);
		contentPane.add(house);

		JLabel label_4 = new JLabel("City");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(119, 447, 81, 49);
		contentPane.add(label_4);

		city = new JTextField();
		city.setColumns(10);
		city.setBackground(Color.WHITE);
		city.setBounds(210, 456, 248, 38);
		contentPane.add(city);

		JLabel gradesss = new JLabel("Grade");
		gradesss.setFont(new Font("Tahoma", Font.BOLD, 20));
		gradesss.setBounds(105, 522, 95, 49);
		contentPane.add(gradesss);

		grade = new JTextField();
		grade.setColumns(10);
		grade.setBackground(Color.WHITE);
		grade.setBounds(210, 535, 248, 38);
		contentPane.add(grade);
	}
}
