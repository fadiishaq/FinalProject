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
		btnAddEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddEmployeeWindow addEmployeeWindow = new AddEmployeeWindow();
				addEmployeeWindow.setVisible(true);
				
			}
		});
		btnAddEmployee.setFont(new Font("Tahoma", Font.ITALIC, 25));
		btnAddEmployee.setBounds(212, 148, 332, 107);
		contentPane.add(btnAddEmployee);
		
		JButton btnAddStudent = new JButton("Add Student");
		btnAddStudent.setFont(new Font("Tahoma", Font.ITALIC, 25));
		btnAddStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddStudentWindow addStudentWindow = new AddStudentWindow();
				addStudentWindow.setVisible(true);
			}
		});
		btnAddStudent.setBounds(212, 293, 332, 107);
		contentPane.add(btnAddStudent);
		
		JButton btnAddAdministration = new JButton("Add Administration");
		btnAddAdministration.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				AddAdminWindow addAdminWindow = new AddAdminWindow();
				addAdminWindow.setVisible(true);
			}
		});
		btnAddAdministration.setFont(new Font("Tahoma", Font.ITALIC, 25));
		btnAddAdministration.setBounds(212, 436, 332, 107);
		contentPane.add(btnAddAdministration);
		
		JLabel lblAddPerson = new JLabel("Add Person");
		lblAddPerson.setFont(new Font("Tahoma", Font.BOLD, 71));
		lblAddPerson.setBounds(170, 11, 490, 73);
		contentPane.add(lblAddPerson);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				PersonManagerWindow pm = new PersonManagerWindow();
				AddPersonWindow pt = new AddPersonWindow();
				
				pt.setVisible(false);
				pm.setVisible(true);
			}
		});
		btnBack.setBounds(696, 563, 98, 41);
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
