package windows;

import testPackage.PersonManagerTest;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import edu.bu.FinalProjectMaven.Encryption;
import personClasses.Administator;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.awt.Choice;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import java.awt.Scrollbar;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Component;

import javax.security.auth.kerberos.EncryptionKey;
import javax.swing.Box;

public class PersonManagerWindow extends JFrame {
	 private Dimension dl, db, center; 

	private JPanel contentPane;
	private static ArrayList<String> jsonStrings = new ArrayList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonManagerWindow frame = new PersonManagerWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public PersonManagerWindow() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
			// display window in the center
			center = Toolkit.getDefaultToolkit().getScreenSize();
			setLocation(center.width / 2 - getSize().width / 2, center.height / 2 - getSize().height / 2);


		JButton addPersonButton = new JButton("Add Person");
		addPersonButton.setBackground(new Color(255, 248, 220));
		addPersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddPersonWindow apt = new AddPersonWindow();

				apt.setVisible(true);
			}
		});
		addPersonButton.setMaximumSize(new Dimension(100, 23));
		addPersonButton.setFont(new Font("SansSerif", Font.BOLD, 30));
		addPersonButton.setBounds(163, 145, 443, 106);
		contentPane.add(addPersonButton);

		JLabel label = new JLabel("Person Manager");
		label.setBackground(SystemColor.activeCaptionBorder);
		label.setFont(new Font("Tahoma", Font.BOLD, 71));
		label.setBounds(105, 11, 635, 86);
		contentPane.add(label);

		JButton searchPersonButton = new JButton("Search Person");
		searchPersonButton.setBackground(new Color(255, 248, 220));
		searchPersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				setVisible(false);
				SearchPersonWindow searchPersonWindow = new SearchPersonWindow();
				searchPersonWindow.setVisible(true);

			}
		});
		searchPersonButton.setMaximumSize(new Dimension(100, 23));
		searchPersonButton.setFont(new Font("SansSerif", Font.BOLD, 30));
		searchPersonButton.setBounds(163, 262, 443, 106);
		contentPane.add(searchPersonButton);

		JButton showReportButton = new JButton("Reports");
		showReportButton.setBackground(new Color(255, 248, 220));
		showReportButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);

				ReportsWindow win = new ReportsWindow();
				win.setVisible(true);
			}
		});
		showReportButton.setMaximumSize(new Dimension(100, 23));
		showReportButton.setFont(new Font("SansSerif", Font.BOLD, 30));
		showReportButton.setBounds(163, 379, 443, 106);
		contentPane.add(showReportButton);

		JButton btnExit = new JButton("Save and Exit");
		btnExit.setBackground(new Color(143, 188, 143));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				File file1 = new File("admins.txt");
				File file2 = new File("employees.txt");
				File file3 = new File("students.txt");
				
				try {
					if (!file1.exists()) {
						file1.createNewFile();
					}
					if (!file2.exists()) {
						file2.createNewFile();
					}
					if (!file3.exists()) {
						file3.createNewFile();
					}
				} catch (Exception ex) {
					ex.printStackTrace();
				}

				// FILE WRITER

				FileWriter fileWriter1 = null;
				FileWriter fileWriter2 = null;
				FileWriter fileWriter3 = null;

				try {
					fileWriter1 = new FileWriter(file1);
					fileWriter2 = new FileWriter(file2);
					fileWriter3 = new FileWriter(file3);

				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				// PRINTWRITER

				try {
					Scanner scanner1 = new Scanner(file1);
					Scanner scanner2 = new Scanner(file2);
					Scanner scanner3 = new Scanner(file3);
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				PrintWriter printWriter1 = new PrintWriter(fileWriter1);
				PrintWriter printWriter2 = new PrintWriter(fileWriter2);
				PrintWriter printWriter3 = new PrintWriter(fileWriter3);

				ObjectMapper om = new ObjectMapper();

				// om.enable(SerializationFeature.INDENT_OUTPUT);

				String jsonString1 = null;
				String jsonString2 = null;
				String jsonString3 = null;


				try {
					if (LoginPageWindow.getAdminsList() != null)
						jsonString1 = om.writeValueAsString(LoginPageWindow.getAdminsList());

					if (LoginPageWindow.getEmployeesList() != null)
						jsonString2 = om.writeValueAsString(LoginPageWindow.getEmployeesList());

					if (LoginPageWindow.getStudentsList() != null)
						jsonString3 = om.writeValueAsString(LoginPageWindow.getStudentsList());

				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}

				printWriter1.print(jsonString1);
				printWriter2.print(jsonString2);
				printWriter3.print(jsonString3);
				printWriter1.close();
				printWriter2.close();
				printWriter3.close();

				System.out.println(jsonString1);
				System.out.println(jsonString2);
				System.out.println(jsonString3);

				/*
				 * ObjectMapper mapper = new ObjectMapper(); String s = null;
				 * 
				 * File file = new
				 * File("D:\\java-oxygen\\eclipse\\projects\\FinalProjectMaven\\admins.txt"); if
				 * (!file.exists()) try { file.createNewFile(); } catch (IOException e2) {
				 * e2.printStackTrace(); }
				 * 
				 * String source = readFile(file); //file.delete();
				 * 
				 * File fnew = new File("admins2"); if(!fnew.exists()) { try {
				 * fnew.createNewFile(); } catch (IOException e) { // TODO Auto-generated catch
				 * block e.printStackTrace(); } } System.out.println(source);
				 * 
				 * try { FileWriter f2 = new FileWriter(fnew, false); f2.write(source);
				 * f2.close();
				 * 
				 * } catch (IOException e) { e.printStackTrace(); }
				 * 
				 * if (!file.exists()) { try { file.createNewFile(); } catch (IOException e1) {
				 * e1.printStackTrace(); } }
				 * 
				 * // Object to JSON in file
				 * 
				 * try {
				 * 
				 * mapper.writerWithDefaultPrettyPrinter(); mapper.writeValue(file,
				 * AddAdminWindow.getAdmins()); CloseJframe();
				 * 
				 * } catch (Exception e) { JOptionPane.showMessageDialog(null, "save problem");
				 * e.printStackTrace(); }
				 */
				setVisible(false);
				
				Encryption.encrypt(file1, new File("encryptedAdminsFile.txt"));
				Encryption.encrypt(file2, new File("encryptedEmployeeFile.txt"));
				Encryption.encrypt(file3, new File("encryptedStudentFile.txt"));

				
				System.exit(0);

			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnExit.setBounds(484, 530, 266, 59);
		contentPane.add(btnExit);
		
		JButton button = new JButton("Exit");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}
		});
		button.setFont(new Font("Tahoma", Font.BOLD, 26));
		button.setBackground(new Color(143, 188, 143));
		button.setBounds(52, 530, 266, 59);
		contentPane.add(button);
	}

	public void CloseJframe() {
		super.dispose();
	}

	public static String readFile(File file) {
		String text = null;
		BufferedReader reader;
		Scanner scanner = null;

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

	public static ArrayList<String> getJsonStrings() {
		return jsonStrings;
	}
}
