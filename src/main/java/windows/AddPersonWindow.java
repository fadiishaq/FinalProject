package windows;

import testPackage.PersonManagerTest;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.SystemColor;
import java.awt.Color;

public class AddPersonWindow extends JFrame {

	private JPanel contentPane;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPersonWindow frame = new AddPersonWindow();
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
	public AddPersonWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 654);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnAddEmployee = new JButton("Add Employee");
		btnAddEmployee.setBackground(SystemColor.controlHighlight);
		btnAddEmployee.setForeground(Color.DARK_GRAY);
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// setVisible(false);

				AddEmployeeWindow addEmployeeWindow = new AddEmployeeWindow();
				addEmployeeWindow.setVisible(true);

			}
		});
		btnAddEmployee.setFont(new Font("SansSerif", Font.BOLD, 30));
		btnAddEmployee.setBounds(181, 141, 463, 107);
		contentPane.add(btnAddEmployee);

		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setBackground(SystemColor.controlHighlight);
		btnAddStudent.setForeground(Color.DARK_GRAY);
		btnAddStudent.setFont(new Font("SansSerif", Font.BOLD, 30));
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddStudentWindow addStudentWindow = new AddStudentWindow();
				addStudentWindow.setVisible(true);
			}
		});
		btnAddStudent.setBounds(181, 259, 463, 107);
		contentPane.add(btnAddStudent);

		JButton btnAddAdministration = new JButton("Add Administration");
		btnAddAdministration.setBackground(SystemColor.controlHighlight);
		btnAddAdministration.setForeground(Color.DARK_GRAY);
		btnAddAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				AddAdminWindow addAdminWindow = new AddAdminWindow();
				addAdminWindow.setVisible(true);

			}
		});
		btnAddAdministration.setFont(new Font("SansSerif", Font.BOLD, 30));
		btnAddAdministration.setBounds(181, 377, 463, 107);
		contentPane.add(btnAddAdministration);

		JLabel lblAddPerson = new JLabel("Add Person");
		lblAddPerson.setFont(new Font("Tahoma", Font.BOLD, 71));
		lblAddPerson.setBounds(212, 23, 468, 73);
		contentPane.add(lblAddPerson);

		JButton btnBack = new JButton("Back");
		btnBack.setForeground(SystemColor.desktop);
		btnBack.setBackground(SystemColor.controlHighlight);
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				PersonManagerWindow pm = new PersonManagerWindow();
				setVisible(false);
				pm.setVisible(true);
			}
		});
		btnBack.setBounds(271, 536, 283, 41);
		contentPane.add(btnBack);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}
