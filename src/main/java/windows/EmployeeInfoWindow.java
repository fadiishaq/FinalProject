package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.Employee;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JToggleButton;

public class EmployeeInfoWindow extends JFrame {
	 private Dimension dl, db, center; 

	private JPanel contentPane;
	private static int i = 1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeInfoWindow frame = new EmployeeInfoWindow();
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

	public EmployeeInfoWindow(final int index, boolean showNextButton) {

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
		label.setBounds(168, 11, 571, 90);
		contentPane.add(label);

		JLabel name = new JLabel("Name: " +LoginPageWindow.getEmployeesList().get(index).getName());
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		name.setBounds(37, 122, 515, 45);
		contentPane.add(name);

		JLabel age = new JLabel("Age: " + LoginPageWindow.getEmployeesList().get(index).getAge());
		age.setForeground(Color.BLACK);
		age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		age.setBounds(37, 195, 490, 29);
		contentPane.add(age);

		JLabel street = new JLabel(
				"Street: " + LoginPageWindow.getEmployeesList().get(index).getAddress().getStreetName());
		street.setForeground(Color.BLACK);
		street.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		street.setBounds(36, 259, 490, 29);
		contentPane.add(street);

		JLabel house = new JLabel(
				"House Num: " + LoginPageWindow.getEmployeesList().get(index).getAddress().getHouseNumber());
		house.setForeground(Color.BLACK);
		house.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		house.setBounds(37, 311, 490, 29);
		contentPane.add(house);

		JLabel city = new JLabel("City: " + LoginPageWindow.getEmployeesList().get(index).getAddress().getCity());
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		city.setBounds(52, 372, 490, 29);
		contentPane.add(city);

		JLabel salary = new JLabel("Salary: " + LoginPageWindow.getEmployeesList().get(index).getSalary());
		salary.setForeground(Color.BLACK);
		salary.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		salary.setBounds(52, 431, 490, 29);
		contentPane.add(salary);

		JButton btnOkay = new JButton("Done");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseJframe();

			}
		});
		btnOkay.setBounds(666, 454, 179, 54);
		contentPane.add(btnOkay);

		JButton btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				EditEmployeeWindow win = new EditEmployeeWindow(index);

				win.setVisible(true);

			}
		});
		btnUpdateInfo.setBounds(96, 454, 262, 54);
		contentPane.add(btnUpdateInfo);

		btnOkay = new JButton("Done");
		btnOkay.setBounds(666, 454, 179, 54);
		contentPane.add(btnOkay);
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseJframe();

			}
		});

		if (showNextButton == true) {
			JButton btnNext = new JButton("Next");
			btnNext.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {

					ArrayList<Employee> employeesFound= SearchPersonWindow.getEmployeesFound();
					if(employeesFound.size() == 2) {
						EmployeeInfoWindow win = new EmployeeInfoWindow(employeesFound.get(1).getIndex(), false);
					}
					
				}
			});
			btnNext.setBounds(721, 132, 157, 113);
			contentPane.add(btnNext);
		}

	}

	////////////////////////////////////////////////////////////////////////////////

	public EmployeeInfoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("Employee");
		label.setFont(new Font("Tahoma", Font.BOLD, 43));
		label.setBounds(250, 11, 279, 90);
		contentPane.add(label);

		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setForeground(Color.BLACK);
		nameLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		nameLabel.setBounds(156, 94, 515, 45);
		contentPane.add(nameLabel);

		JLabel ageLabel = new JLabel("Age: 0");
		ageLabel.setForeground(Color.BLACK);
		ageLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		ageLabel.setBounds(156, 167, 490, 29);
		contentPane.add(ageLabel);

		JLabel streetLabel = new JLabel("Street: <dynamic>");
		streetLabel.setForeground(Color.BLACK);
		streetLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		streetLabel.setBounds(155, 231, 490, 29);
		contentPane.add(streetLabel);

		JLabel houseLabel = new JLabel("House Num: <dynamic>");
		houseLabel.setForeground(Color.BLACK);
		houseLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		houseLabel.setBounds(156, 283, 490, 29);
		contentPane.add(houseLabel);

		JLabel cityLabel = new JLabel("City: <dynamic>");
		cityLabel.setForeground(Color.BLACK);
		cityLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		cityLabel.setBounds(171, 344, 490, 29);
		contentPane.add(cityLabel);

		JLabel salaryLabel = new JLabel("Salary: 0");
		salaryLabel.setForeground(Color.BLACK);
		salaryLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		salaryLabel.setBounds(171, 403, 490, 29);
		contentPane.add(salaryLabel);

		JButton btnOkay = new JButton("Done");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseJframe();

			}
		});
		btnOkay.setBounds(666, 454, 179, 54);
		contentPane.add(btnOkay);

		JButton btnUpdateInfo = new JButton("Update Info");
		btnUpdateInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnUpdateInfo.setBounds(107, 443, 262, 54);
		contentPane.add(btnUpdateInfo);

		JButton btnNext = new JButton("Next");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNext.setBounds(721, 132, 157, 113);
		contentPane.add(btnNext);


	}

	public void CloseJframe() {
		super.dispose();
	}

	public static int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}
}