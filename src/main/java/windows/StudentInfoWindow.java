package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class StudentInfoWindow extends JFrame {
	 private Dimension dl, db, center; 

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
		
			// display window in the center
			center = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation(center.width / 2 - getSize().width / 2, center.height / 2 - getSize().height / 2);


		JLabel label = new JLabel("Student");
		label.setFont(new Font("Tahoma", Font.BOLD, 43));
		label.setBounds(168, 11, 571, 90);
		contentPane.add(label);

		JLabel name = new JLabel("Name: " + LoginPageWindow.getStudentsList().get(index).getName());
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		name.setBounds(37, 122, 515, 45);
		contentPane.add(name);

		JLabel age = new JLabel("Age: " + LoginPageWindow.getStudentsList().get(index).getAge());
		age.setForeground(Color.BLACK);
		age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		age.setBounds(37, 195, 490, 29);
		contentPane.add(age);

		JLabel street = new JLabel(
				"Street: " + LoginPageWindow.getStudentsList().get(index).getAddress().getStreetName());
		street.setForeground(Color.BLACK);
		street.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		street.setBounds(36, 259, 490, 29);
		contentPane.add(street);

		JLabel house = new JLabel(
				"House Num: " + LoginPageWindow.getStudentsList().get(index).getAddress().getHouseNumber());
		house.setForeground(Color.BLACK);
		house.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		house.setBounds(37, 311, 490, 29);
		contentPane.add(house);

		JLabel city = new JLabel("City: " + LoginPageWindow.getStudentsList().get(index).getAddress().getCity());
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		city.setBounds(52, 372, 490, 29);
		contentPane.add(city);

		JLabel salary = new JLabel("Salary: " + LoginPageWindow.getStudentsList().get(index).getGrade());
		salary.setForeground(Color.BLACK);
		salary.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		salary.setBounds(52, 431, 490, 29);
		contentPane.add(salary);
		
		JButton btnOkay = new JButton("OKAY");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseJframe();
			}
		});
		btnOkay.setBounds(208, 454, 455, 54);
		contentPane.add(btnOkay);
		
		

	} // ------------------------------------------------------------------------------------

	public StudentInfoWindow() {
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

		JLabel name = new JLabel("Name: ");
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		name.setBounds(37, 122, 515, 45);
		contentPane.add(name);

		JLabel age = new JLabel("Age: " );
		age.setForeground(Color.BLACK);
		age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		age.setBounds(37, 195, 490, 29);
		contentPane.add(age);

		JLabel street = new JLabel(
				"Street: ");
		street.setForeground(Color.BLACK);
		street.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		street.setBounds(36, 259, 490, 29);
		contentPane.add(street);

		JLabel house = new JLabel(
				"House Num: ");
		house.setForeground(Color.BLACK);
		house.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		house.setBounds(37, 311, 490, 29);
		contentPane.add(house);

		JLabel city = new JLabel("City: ");
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		city.setBounds(52, 372, 490, 29);
		contentPane.add(city);

		JLabel salary = new JLabel("Salary: ");
		salary.setForeground(Color.BLACK);
		salary.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		salary.setBounds(52, 431, 490, 29);
		contentPane.add(salary);
		
		JButton btnOkay = new JButton("OKAY");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseJframe();
			}
		});
		btnOkay.setBounds(208, 454, 455, 54);
		contentPane.add(btnOkay);
		

	}
	public void CloseJframe(){
	    super.dispose();
	}
}