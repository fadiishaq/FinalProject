package windows;

import java.awt.EventQueue;

import personClasses.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;

public class ReportsWindow extends JFrame {


	private JPanel contentPane;
	private JTextField enteredSalary;
	private JTextField enteredGrade;
	private JButton btnBack;
	private JSeparator separator;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {


		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReportsWindow frame = new ReportsWindow();
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
	public ReportsWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 613, 433);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);
		
		enteredSalary = new JTextField();
		enteredSalary.setHorizontalAlignment(SwingConstants.CENTER);
		enteredSalary.setFont(new Font("SansSerif", Font.BOLD, 17));
		enteredSalary.setBounds(444, 137, 80, 41);
		contentPane.add(enteredSalary);
		enteredSalary.setColumns(10);

		JButton btnReportEmployeesWith = new JButton("Report Employees with Salary larger than ");
		btnReportEmployeesWith.setForeground(new Color(0, 0, 255));
		btnReportEmployeesWith.setBackground(new Color(220, 220, 220));
		btnReportEmployeesWith.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnReportEmployeesWith.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					File employeeFile = new File("employeesReport.txt");

					
				if(!employeeFile.exists())
					employeeFile.createNewFile();

					PrintWriter writer = new PrintWriter(employeeFile);
					
					int count = 1;

					for (Employee employee : LoginPageWindow.getEmployeesList()) {
						if(employee.getSalary() > Integer.parseInt(enteredSalary.getText())) {
							
							writer.println("Employee:");
							writer.println("\tName: " + employee.getName());
							writer.println("\tAge: " +employee.getAge());
							writer.println("\tStreet Name: " +employee.getAddress().getStreetName());
							writer.println("\tHouse Number: " +employee.getAddress().getHouseNumber());
							writer.println("\tCity: " +employee.getAddress().getCity());
							writer.println("\tSalary: " +employee.getSalary());
							
							count++;
						}
					}
					if(count > 1) 
						JOptionPane.showMessageDialog(null, "A report file has been created on the project path!");
					else
						JOptionPane.showMessageDialog(null, "None found");
					
					writer.close();
					
				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Something went wrong!");

				}
				
				


			}// AL
		});
		btnReportEmployeesWith.setBounds(68, 137, 329, 41);
		contentPane.add(btnReportEmployeesWith);

		JButton btnReportStudentsWith = new JButton("Report Students with grade larger than ");
		btnReportStudentsWith.setForeground(new Color(0, 0, 255));
		btnReportStudentsWith.setBackground(new Color(220, 220, 220));
		btnReportStudentsWith.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnReportStudentsWith.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {

					File studentsFile = new File("studentsReport.txt");

					studentsFile.createNewFile();

					PrintWriter writer = new PrintWriter(studentsFile);
					
					int count = 1;
					for (Student student : LoginPageWindow.getStudentsList()) {
						if(student.getGrade() > Integer.parseInt(enteredSalary.getText())) {
							
							

							writer.println("Student:");
							writer.println("\tName: " + student.getName());
							writer.println("\tAge: " +student.getAge());
							writer.println("\tStreet Name: " +student.getAddress().getStreetName());
							writer.println("\tHouse Number: " +student.getAddress().getHouseNumber());
							writer.println("\tCity: " +student.getAddress().getCity());
							writer.println("\tGrade: " +student.getGrade());							
							
							
							count++;
						}
					}
					if(count > 1) 
						JOptionPane.showMessageDialog(null, "A report file has been created on the project path!");
					else
						JOptionPane.showMessageDialog(null, "None found");
					
					writer.close();

				} catch (Exception e) {

					JOptionPane.showMessageDialog(null, "Something went wrong!");

				}
			}
		});
		btnReportStudentsWith.setBounds(68, 233, 329, 41);
		contentPane.add(btnReportStudentsWith);

		enteredGrade = new JTextField();
		enteredGrade.setHorizontalAlignment(SwingConstants.CENTER);
		enteredGrade.setFont(new Font("SansSerif", Font.BOLD, 17));
		enteredGrade.setColumns(10);
		enteredGrade.setBounds(444, 233, 80, 41);
		contentPane.add(enteredGrade);
		
		btnBack = new JButton("Back");
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBackground(new Color(169, 169, 169));
		btnBack.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonManagerWindow win = new PersonManagerWindow();
				win.show();
			}
		});
		btnBack.setBounds(10, 334, 101, 49);
		contentPane.add(btnBack);
		
		JLabel lblReports = new JLabel("Reports");
		lblReports.setHorizontalAlignment(SwingConstants.CENTER);
		lblReports.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 58));
		lblReports.setBounds(139, 11, 346, 62);
		contentPane.add(lblReports);
		
		separator = new JSeparator();
		separator.setBounds(40, 92, 521, 7);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(40, 301, 521, 7);
		contentPane.add(separator_1);
	}
}
