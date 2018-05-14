package personClasses;

import windows.StudentInfoWindow;

public class Administator extends Person {

	private String username;
	private String password;

	public Administator() {
		super();
	}

	public Administator(String name, int age, String streetName, String houseNumber, String city, String username,
			String password, int num) {
		super(name, age, new Address(streetName, houseNumber, city), num);
		this.username = username;
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	/*
	 * public static void toWindow(int index) {
	 * 
	 * AdminInfoWindow infoWin = new AdminInfoWindow(index);
	 * infoWin.setVisible(true);
	 * 
	 * }
	 */

}