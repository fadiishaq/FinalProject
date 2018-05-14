package personClasses;

import windows.*;


public class Student extends Person{

	private int grade;

	
	
	public Student() {
		super();
	}

	public Student(String name, int age, String streetName, String houseNumber, String city, int grade, int num) {
		super(name, age, new Address(streetName, houseNumber, city), num);
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nGrade: " + this.grade;
	}
	
	public static void toWindow(int index) {

		StudentInfoWindow infoWin = new StudentInfoWindow(index);
		infoWin.setVisible(true);

	}
}
