package personClasses;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

import windows.AddEmployeeWindow;
import windows.EmployeeInfoWindow;

public class Employee extends Person {
	private int salary;
	

	public Employee(String name, int age, String streetName, String houseNumber, String city, int salary, int num) {
		super(name, age, new Address(streetName, houseNumber, city), num);
		this.salary = salary;
	}


	public Employee() {
		super();
	}


	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return super.toString() + "\nSalary: " + this.salary;
	}


}
