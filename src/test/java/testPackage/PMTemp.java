package testPackage;

import java.util.ArrayList;
import java.util.Scanner;

import personClasses.*;

public class PMTemp {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Person[] list = new Person[1000];
		int count = 0;

		printMenu();
		int choice = input.nextInt();
		input.nextLine();

		while (choice != 6) {
			switch (choice) {
			case 1:
			case 2:
				if (count < list.length) {
					AddPerson(input, list, count, choice);
					count++;
				} else {
					System.out.println("Array is full!");
				}
				break;
			case 3:
				System.out.println("Enter the person's name for which to get details: ");
				String name = input.nextLine();
				Person p = findPerson(list, name);
				if (p == null)
					System.out.println("This person doesn't exist!");
				else
					System.out.println(p.toString());
				break;
			case 4:
				System.out.println("The Employee with the Max Salary is: ");
				Employee maxEmp = findEmpMaxSalary(list);
				if (maxEmp != null)
					System.out.println(maxEmp.toString());
				else
					System.out.println("There are no employees in the list!");
				break;
			case 5:
				findMatchingAge(list);
				break;
			default:
				System.out.println("Wrong Choice!");
				break;
			}

			printMenu();
			choice = input.nextInt();
			input.nextLine();
		}

		System.out.println("Thank you.. Goodbye!");
		input.close();
	}

	public static void printMenu() {
		System.out.println("Choose an option: \n" + "\t1) Create New Student \n" + "\t2) Create New Employee \n"
				+ "\t3) Search for Person \n" + "\t4) Find the Max Employee Salary \n"
				+ "\t5) Find Matching age for a Student and Employee\n" + "\t6) Exit \n");
	}

	public static void AddPerson(Scanner input, Person[] list, int count, int choice) {
		System.out.println("Enter the person's name: ");
		String name = input.nextLine();
		System.out.println("Enter the person's age: ");
		int age = input.nextInt();
		input.nextLine();
		System.out.println("Enter the person's street name: ");
		String streetNum = input.nextLine();
		System.out.println("Enter the person's house numebr: ");
		String houseNum = input.nextLine();
		System.out.println("Enter the person's city: ");
		String city = input.nextLine();
		Address address = new Address(streetNum, houseNum, city);
		if (choice == 1) {
			System.out.println("Enter the grade");
			int grade = input.nextInt();
			input.nextLine();
			list[count] = new Student(name, age, streetNum, houseNum, city, grade);
			list[count].setAddress(address);
		} else {
			System.out.println("Enter the salary");
			int salary = input.nextInt();
			input.nextLine();
			list[count] = new Employee(name, age, streetNum, houseNum, city, salary);
			list[count].setAddress(address);
		}

	}

	public static Person findPerson(Person[] list, String name) {
		for (Person p : list) {
			if (p != null) {
				if (p.getName().equalsIgnoreCase(name)) {
					return p;
				}
			}
		}
		return null;
	}

	public static Employee findEmpMaxSalary(Person[] list) {
		int max = 0;
		Employee emp = null;
		for (Person p : list) {
			if (p != null) {
				if (p instanceof Employee) {
					if (((Employee) p).getSalary() > max) {
						max = ((Employee) p).getSalary();
						emp = ((Employee) p);
					}
				}
			}
		}
		return emp;
	}

	public static void findMatchingAge(Person[] list) {
		int count = 0; // count number of matching ages
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list.length; j++) {
				if (list[i] instanceof Student && list[j] instanceof Employee) {
					if (list[i].getAge() == list[j].getAge())
						System.out.println("(Student " + (i + 1) + ", Employee " + (j + 1) + ")");
					count++;
				}
			}
		}
		/*
		 * Another way ArrayList<Student> slist = new ArrayList<Student>();
		 * ArrayList<Employee> elist = new ArrayList<Employee>();
		 * 
		 * for(Person p : list) { if(p != null) { if(p instanceof Employee) {
		 * elist.add(((Employee)p)); } else if(p instanceof Student) {
		 * slist.add(((Student)p)); } } }
		 * 
		 * for(int i=0; i < slist.size(); i++) { for(int j=0; j < elist.size(); j++) {
		 * if(slist.get(i).getAge() == elist.get(j).getAge()) {
		 * System.out.println("(Student " + (i+1) + ", Employee " + (j+1) + ")");
		 * count++; } } }
		 */

		if (count == 0)
			System.out.println("There are no matching ages found!");

	}

}
