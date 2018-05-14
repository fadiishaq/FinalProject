package personClasses;

import windows.StudentInfoWindow;

public class Person {
	private String name;
	private int age;
	private Address address;
	private int num;

	public Person() {

	}

	public Person(String name, int age, Address address, int num) {
		super();
		this.name = name;
		this.age = age;
		this.address = address;
		this.num = num;
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

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

}
