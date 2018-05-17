package windows;

import testPackage.PersonManagerTest;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import personClasses.*;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;

public class LoginPageWindow extends JFrame {

	
	private static File file1 = new File("admins.txt");
	private static File file2 = new File("employees.txt");
	private static File file3 = new File("students.txt");

	private static ArrayList<Administator> adminsList = new ArrayList();
	private static ArrayList<Employee> employeesList = new ArrayList();
	private static ArrayList<Student> studentsList = new ArrayList();

	static ObjectMapper om1 = new ObjectMapper();
	static ObjectMapper om2 = new ObjectMapper();
	static ObjectMapper om3 = new ObjectMapper();

	static Scanner scanner1 = null;
	static Scanner scanner2 = null;
	static Scanner scanner3 = null;

	private JPanel contentPane;
	private JTextField username;
	private JPasswordField password;
	private static BufferedReader reader;
	static Scanner scanner;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginPageWindow frame = new LoginPageWindow();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		try {

			scanner1 = new Scanner(file1);
			scanner2 = new Scanner(file2);
			scanner3 = new Scanner(file3);

			if (file1.exists() && file1.length() != 0) {
				if (scanner1.hasNextLine()) {

					adminsList = om1.readValue(file1, new TypeReference<ArrayList<Administator>>() {
					});

					System.out.println(adminsList);

					scanner1.close();
				}
			}
		} catch (JsonParseException e) {
			System.out.println("Parsing exception");

		} catch (JsonMappingException e) {
			System.out.println("Json mapping exception");

		} catch (IOException e) {
			System.out.println("Admin file doesn't exist exception \n "
					+ "default input: admin");

		}

		if (file2.exists() && file1.length() != 0) {
			if (scanner2.hasNextLine()) {

				try {

					employeesList = om2.readValue(file2, new TypeReference<ArrayList<Employee>>() {
					});
					System.out.println(employeesList);

				} catch (JsonParseException e) {
					System.out.println("Parsing exception");

				} catch (JsonMappingException e) {
					System.out.println("Json mapping exception");

				} catch (IOException e) {
					System.out.println("Employee file doesn't exist exception");

				}
				/*
				 * try { employeesList = om2.readValue(scanner2.nextLine(), new
				 * TypeReference<ArrayList<Employee>>() { }); System.out.println(employeesList);
				 * 
				 * } catch (Exception e) { e.printStackTrace(); }
				 */
				scanner2.close();


			}
		}

		if (file3.exists() && file1.length() != 0) {
			if (scanner3.hasNextLine()) {
				try {

					studentsList = om3.readValue(file3, new TypeReference<ArrayList<Student>>() {
					});
					System.out.println(studentsList);
					
					scanner3.close();


				} catch (JsonParseException e) {
					System.out.println("Parsing exception");

				} catch (JsonMappingException e) {
					System.out.println("Json mapping exception");

				} catch (IOException e) {
					System.out.println("Student file doesn't exist exception");

				}

			}
		}

	}

	/**
	 * Create the frame.
	 */
	public LoginPageWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 597, 345);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);

		JLabel nameLabel = new JLabel("Username");
		nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		nameLabel.setBounds(97, 84, 132, 53);
		contentPane.add(nameLabel);

		JLabel title = new JLabel("Person Manager");
		title.setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 47));
		title.setBounds(87, -2, 401, 72);
		contentPane.add(title);

		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 28));
		passwordLabel.setBounds(97, 148, 132, 53);
		contentPane.add(passwordLabel);

		username = new JTextField();
		username.setFont(new Font("Tahoma", Font.PLAIN, 20));
		username.setBounds(269, 97, 184, 34);
		contentPane.add(username);
		username.setColumns(10);

		JButton loginButton = new JButton("Login");
		loginButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				/*
				 * ObjectMapper om = new ObjectMapper();
				 * 
				 * 
				 * ArrayList<Administator> adminsList = new ArrayList();
				 * 
				 * 
				 * try {
				 * 
				 * adminsList = om.readValue(readFile(file), new
				 * TypeReference<ArrayList<Administator>>() {});
				 * 
				 * } catch (JsonParseException e) { e.printStackTrace(); } catch
				 * (JsonMappingException e) { e.printStackTrace(); } catch (IOException e) {
				 * e.printStackTrace(); }
				 * 
				 */

				if (!file1.exists() || adminsList.isEmpty()) {
					if (username.getText().equals("admin") && password.getText().equals("admin")) {
						PersonManagerWindow tab = new PersonManagerWindow();
						setVisible(false);
						tab.setVisible(true);
					}

					else
						JOptionPane.showMessageDialog(null,
								"Your login attempt has failed. Make sure the username and password are correct.",
								"Login Error", JOptionPane.WARNING_MESSAGE, null);

				}

				else {
					boolean tf = false;
					for (Administator admin : adminsList) {
						if (username.getText().equals(admin.getUserName())
								&& password.getText().equals(admin.getPassword())) {
							tf = true;
							PersonManagerWindow tab = new PersonManagerWindow();
							setVisible(false);
							tab.setVisible(true);
						}

					} // for

					if (tf == false)
						JOptionPane.showMessageDialog(null,
								"Your login attempt has failed. Make sure the username and password are correct.",
								"Login Error", JOptionPane.WARNING_MESSAGE, null);

				}

			}
		});
		loginButton.setBounds(382, 238, 127, 53);
		contentPane.add(loginButton);

		password = new JPasswordField();
		password.setBounds(269, 164, 184, 34);
		contentPane.add(password);

		JSeparator separator = new JSeparator();
		separator.setBounds(40, 68, 488, 5);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(40, 222, 481, 5);
		contentPane.add(separator_1);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				username.setText("");
				password.setText("");

			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBounds(219, 238, 127, 53);
		contentPane.add(btnReset);

		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setBounds(50, 238, 127, 53);
		contentPane.add(btnExit);
	}

	public static String readFile(File file) {
		String text = null;

		try {
			reader = new BufferedReader(new FileReader(file));
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (scanner.hasNext()) {
			text = scanner.next();
		}
		return text;

	}

	public static ArrayList<Administator> getAdminsList() {
		return adminsList;
	}

	public static ArrayList<Employee> getEmployeesList() {
		return employeesList;
	}


	public static ArrayList<Student> getStudentsList() {
		return studentsList;
	}

}
