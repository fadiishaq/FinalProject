package personClasses;

import windows.StudentInfoWindow;

public class Person {
	private String name;
	private int age;
	private Address address;
	private int index;

	public Person() {

	}

	public Person(String name, int age, Address address, int index) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.index = index;
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

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

}
