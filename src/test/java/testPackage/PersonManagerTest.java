package testPackage;

import personClasses.*;
import windows.AddEmployeeWindow;
import windows.EmployeeInfoWindow;
import windows.LoginPageWindow;

import java.util.ArrayList;
import java.util.List;

public class PersonManagerTest {

	// static ArrayList<Employee> employees = new ArrayList<Employee>();
	// static ArrayList<Student> students = new ArrayList<Student>();
	// static ArrayList<Administator> admins = new ArrayList<Administator>();

	public static int personCount = 0;

	/*
	 * public static void addPersonCount() { personCount++; }
	 * 
	 * public static int getPersonCount() { return personCount; }
	 */

	public static void main(String[] args) {
		AddEmployeeWindow win = new AddEmployeeWindow();
		// win.setVisible(true);

		LoginPageWindow l = new LoginPageWindow();
		l.setVisible(true);

		/*Employee em = new Employee("fadi", 14, "haha", "haha", "haha", 9000);
		AddEmployeeWindow.getEmployees().add(em);
		AddEmployeeWindow.addNumOfEmployees();
		em.toWindow(0);*/
	}// main

	/*
	 * public static void addEmployee(Employee employee, ArrayList<Employee>
	 * employees) {
	 * 
	 * employees.add(employee); }
	 * 
	 * public static void addStudent(Student student, ArrayList<Student> students) {
	 * 
	 * students.add(student); }
	 * 
	 * public static void addAdministator(Administator admin,
	 * ArrayList<Administator> admins) {
	 * 
	 * admins.add(admin); }
	 * 
	 * public static ArrayList<Employee> getEmployeeList() { return employees; }
	 * 
	 * public static ArrayList<Student> getStudentsList() { return students; }
	 * 
	 * public static ArrayList<Administator> getAdminsList() { return admins; }
	 */

}
