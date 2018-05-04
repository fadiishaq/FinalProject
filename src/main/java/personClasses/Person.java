package personClasses;

import windows.StudentInfoWindow;

public class Person {
	private String name;
	private int age;
	private Address address;
	
	public Person() {	
	
	}
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public Person(String name, int age, Address address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String toString() {
		return "Name: " + this.name + "\nAge: " + this.age + "\nAddress: " + this.address;
	}
	
}
