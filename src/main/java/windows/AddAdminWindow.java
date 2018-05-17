package windows;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import personClasses.Administator;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class AddAdminWindow extends JFrame {

	private JPanel contentPane;
	private JTextField age;
	private JTextField name;
	private JTextField street;
	private JTextField house;
	private JTextField city;
	private JTextField username;
	private JTextField password;
	private JTextField password2;
	private JLabel lblUsername;
	private JLabel lblPassword;
	private JLabel lblConfirmPassword;
	private JSeparator separator;
	private JSeparator separator_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddAdminWindow frame = new AddAdminWindow();
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
	public AddAdminWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 790);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setLocationRelativeTo(null);

		JLabel lblAddAdmin = new JLabel("Add Administration");
		lblAddAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddAdmin.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
		lblAddAdmin.setBounds(54, 2, 486, 82);
		contentPane.add(lblAddAdmin);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				AddPersonWindow addPersonWindow = new AddPersonWindow();
				addPersonWindow.setVisible(true);
			}
		});
		btnBack.setBounds(719, 566, 75, 38);
		contentPane.add(btnBack);

		JButton btnAddAdmin = new JButton("Add");
		btnAddAdmin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				try {

					if (password.getText().equals(password2.getText())) {

						Administator admin = new Administator(name.getText(), Integer.parseInt(age.getText()),
								street.getText(), house.getText(), city.getText(), username.getText(),
								password.getText(), LoginPageWindow.getEmployeesList().size() - 1);

						LoginPageWindow.getAdminsList().add(admin);

						AdminInfoWindow adminInfo = new AdminInfoWindow(LoginPageWindow.getAdminsList().size() - 1);

						setVisible(false);

						adminInfo.setVisible(true);

					} else {

						JOptionPane.showMessageDialog(null, "Passwords don't match!");
					}
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Wrong input!");
				}

			}

		});
		btnAddAdmin.setFont(new Font("SansSerif", Font.BOLD, 22));
		btnAddAdmin.setBounds(258, 661, 248, 73);
		contentPane.add(btnAddAdmin);

		JButton btnNewButton = new JButton("back");
		btnNewButton.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);

			}
		});
		btnNewButton.setBounds(10, 667, 88, 73);
		contentPane.add(btnNewButton);

		JLabel label = new JLabel("Name");
		label.setFont(new Font("Tahoma", Font.BOLD, 20));
		label.setBounds(54, 126, 162, 49);
		contentPane.add(label);

		JLabel label_1 = new JLabel("Age");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(54, 186, 162, 52);
		contentPane.add(label_1);

		age = new JTextField();
		age.setHorizontalAlignment(SwingConstants.CENTER);
		age.setColumns(10);
		age.setBackground(Color.WHITE);
		age.setBounds(258, 198, 248, 38);
		contentPane.add(age);

		name = new JTextField();
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setColumns(10);
		name.setBackground(Color.WHITE);
		name.setBounds(258, 136, 248, 38);
		contentPane.add(name);

		JLabel label_2 = new JLabel("Street");
		label_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_2.setBounds(54, 249, 162, 52);
		contentPane.add(label_2);

		street = new JTextField();
		street.setHorizontalAlignment(SwingConstants.CENTER);
		street.setColumns(10);
		street.setBackground(Color.WHITE);
		street.setBounds(258, 261, 248, 38);
		contentPane.add(street);

		JLabel label_3 = new JLabel("House Number");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(54, 312, 162, 52);
		contentPane.add(label_3);

		house = new JTextField();
		house.setHorizontalAlignment(SwingConstants.CENTER);
		house.setColumns(10);
		house.setBackground(Color.WHITE);
		house.setBounds(258, 324, 248, 38);
		contentPane.add(house);

		JLabel label_4 = new JLabel("City");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_4.setBounds(54, 375, 162, 49);
		contentPane.add(label_4);

		city = new JTextField();
		city.setHorizontalAlignment(SwingConstants.CENTER);
		city.setColumns(10);
		city.setBackground(Color.WHITE);
		city.setBounds(258, 385, 248, 38);
		contentPane.add(city);

		username = new JTextField();
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setColumns(10);
		username.setBackground(Color.WHITE);
		username.setBounds(258, 445, 248, 38);
		contentPane.add(username);

		password = new JTextField();
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setColumns(10);
		password.setBackground(Color.WHITE);
		password.setBounds(258, 505, 248, 38);
		contentPane.add(password);

		password2 = new JTextField();
		password2.setHorizontalAlignment(SwingConstants.CENTER);
		password2.setColumns(10);
		password2.setBackground(Color.WHITE);
		password2.setBounds(258, 564, 248, 38);
		contentPane.add(password2);

		lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblUsername.setBounds(54, 435, 162, 49);
		contentPane.add(lblUsername);

		lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPassword.setBounds(54, 495, 162, 49);
		contentPane.add(lblPassword);

		lblConfirmPassword = new JLabel("Confirm Password");
		lblConfirmPassword.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblConfirmPassword.setBounds(54, 555, 191, 49);
		contentPane.add(lblConfirmPassword);
		
		separator = new JSeparator();
		separator.setBounds(21, 633, 512, 11);
		contentPane.add(separator);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(28, 104, 512, 11);
		contentPane.add(separator_1);
	}
}
