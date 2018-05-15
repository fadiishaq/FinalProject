package windows;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import personClasses.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import com.google.gson.JsonArray;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;

public class ReportsWindow extends JFrame {

	 private Dimension dl, db, center; 

	private JPanel contentPane;
	private JTextField enteredSalary;
	private JTextField enteredGrade;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		JsonArray arr = new JsonArray();

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
		setBounds(100, 100, 820, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

			// display window in the center
			center = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation(center.width / 2 - getSize().width / 2, center.height / 2 - getSize().height / 2);

		
		enteredSalary = new JTextField();
		enteredSalary.setBounds(355, 119, 80, 45);
		contentPane.add(enteredSalary);
		enteredSalary.setColumns(10);

		JButton btnReportEmployeesWith = new JButton("Report Employees with Salary larger than ");
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
		btnReportEmployeesWith.setBounds(55, 124, 276, 34);
		contentPane.add(btnReportEmployeesWith);

		JButton btnReportStudentsWith = new JButton("Report Students with grade larger than ");
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
		btnReportStudentsWith.setBounds(55, 226, 276, 34);
		contentPane.add(btnReportStudentsWith);

		enteredGrade = new JTextField();
		enteredGrade.setColumns(10);
		enteredGrade.setBounds(355, 221, 80, 45);
		contentPane.add(enteredGrade);
		
		btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PersonManagerWindow win = new PersonManagerWindow();
				win.show();
			}
		});
		btnBack.setBounds(618, 452, 108, 105);
		contentPane.add(btnBack);
	}
}
