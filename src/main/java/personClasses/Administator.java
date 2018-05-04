package personClasses;

import windows.StudentInfoWindow;

public class Administator extends Person{

	private String userName;
	private String password;
	
	
	
	
	public Administator(String name, int age, String streetName, String houseNumber, 
			String city,String username, String password) {
		super(name, age, new Address(streetName, houseNumber, city));
		this.userName = userName;
		this.password= password;
	}
	
	
	
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	/*public static void toWindow(int index) {

		AdminInfoWindow infoWin = new AdminInfoWindow(index);
		infoWin.setVisible(true);

	}*/
	
}