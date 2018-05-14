package windows;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AdminInfoWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentInfoWindow frame = new StudentInfoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}// main

	/**
	 * Create the frame.
	 */

	public AdminInfoWindow(final int index) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("New Admin Added!");
		label.setFont(new Font("Tahoma", Font.BOLD, 43));
		label.setBounds(168, 11, 571, 90);
		contentPane.add(label);

		JLabel name = new JLabel("Name: " + LoginPageWindow.getAdminsList().get(index).getName());
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		name.setBounds(37, 122, 515, 45);
		contentPane.add(name);

		JLabel age = new JLabel("Age: " + LoginPageWindow.getAdminsList().get(index).getAge());
		age.setForeground(Color.BLACK);
		age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		age.setBounds(37, 195, 490, 29);
		contentPane.add(age);

		JLabel street = new JLabel("Street: " + LoginPageWindow.getAdminsList().get(index).getAddress().getStreetName());
		street.setForeground(Color.BLACK);
		street.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		street.setBounds(36, 259, 490, 29);
		contentPane.add(street);

		JLabel house = new JLabel("House Num: " + LoginPageWindow.getAdminsList().get(index).getAddress().getHouseNumber());
		house.setForeground(Color.BLACK);
		house.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		house.setBounds(37, 311, 490, 29);
		contentPane.add(house);

		JLabel city = new JLabel("City: " + LoginPageWindow.getAdminsList().get(index).getAddress().getCity());
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		city.setBounds(52, 372, 490, 29);
		contentPane.add(city);

		JLabel username = new JLabel("Username: " + LoginPageWindow.getAdminsList().get(index).getUserName());
		username.setForeground(Color.BLACK);
		username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		username.setBounds(564, 168, 340, 45);
		contentPane.add(username);

		JLabel password = new JLabel("Password:" + LoginPageWindow.getAdminsList().get(index).getPassword());
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		password.setBounds(564, 251, 340, 45);
		contentPane.add(password);

		JButton btnOkay = new JButton("OKAY");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseJframe();
			}
		});
		btnOkay.setBounds(208, 454, 455, 54);
		contentPane.add(btnOkay);
		
		JButton btnEditupdate = new JButton("Edit / Update");
		btnEditupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				EditAdminWindow win = new EditAdminWindow(index);
				win.show();
			}
		});
		btnEditupdate.setBounds(56, 452, 253, 56);
		contentPane.add(btnEditupdate);

	}
	

	public AdminInfoWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 558);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel label = new JLabel("New Admin Added!");
		label.setFont(new Font("Tahoma", Font.BOLD, 43));
		label.setBounds(168, 11, 571, 90);
		contentPane.add(label);

		JLabel name = new JLabel("Name: ");
		name.setForeground(Color.BLACK);
		name.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		name.setBounds(37, 122, 515, 45);
		contentPane.add(name);

		JLabel age = new JLabel("Age: ");
		age.setForeground(Color.BLACK);
		age.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		age.setBounds(37, 195, 490, 29);
		contentPane.add(age);

		JLabel street = new JLabel("Street: ");
		street.setForeground(Color.BLACK);
		street.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		street.setBounds(36, 259, 490, 29);
		contentPane.add(street);

		JLabel house = new JLabel("House Num: ");
		house.setForeground(Color.BLACK);
		house.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		house.setBounds(37, 311, 490, 29);
		contentPane.add(house);

		JLabel city = new JLabel("City: ");
		city.setForeground(Color.BLACK);
		city.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		city.setBounds(37, 373, 490, 29);
		contentPane.add(city);

		// JLabel username = new JLabel("Username: " +
		// AddAdminWindow.getAdmins().get(index).getUserName());
		JLabel username = new JLabel("Username: ");

		username.setForeground(Color.BLACK);
		username.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 21));
		username.setBounds(564, 168, 340, 45);
		contentPane.add(username);

		JLabel password = new JLabel("Password:");
		password.setForeground(Color.BLACK);
		password.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 19));
		password.setBounds(564, 251, 340, 45);
		contentPane.add(password);

		JButton btnOkay = new JButton("OKAY");
		btnOkay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPersonWindow addPersonWindow = new AddPersonWindow();
				CloseJframe();
			}
		});
		btnOkay.setBounds(564, 454, 272, 54);
		contentPane.add(btnOkay);
		
		JButton btnEditupdate = new JButton("Edit / Update");
		btnEditupdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnEditupdate.setBounds(56, 452, 253, 56);
		contentPane.add(btnEditupdate);

	}

	public void CloseJframe() {
		super.dispose();
	}
}