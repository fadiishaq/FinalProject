package windows;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import personClasses.Employee;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class OnlyTest extends JFrame {

	private static JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	static ArrayList<Employee> employees = new ArrayList();

	
	 
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OnlyTest frame = new OnlyTest();
					frame.setVisible(true);
					employees.add(new Employee("fadi", 19, "steh", "haha", "kek", 9999));
					employees.add(new Employee("alex", 15, "xD", "fd", "23", 7654));
					employees.add(new Employee("Xd", 15, "xD", "fd", "23", 7654));
					employees.add(new Employee("4213", 15, "xD", "fd", "23", 7654));


					
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OnlyTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 721, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPressHere = new JButton("Search");
		btnPressHere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				createTextField();
				createResult();
				
			}
		});
		btnPressHere.setBounds(10, 11, 237, 46);
		contentPane.add(btnPressHere);

		

		
		
	}
	
	public static void createTextField() {
		JTextField textField = new JTextField(employees.size() + " employees found");
		textField.setBounds(25, 84, 237 , 46);
		contentPane.add(textField);
		textField.setColumns(10);
		contentPane.repaint();
		
		
		
	}
	
	public static void createResult() {
		JButton btnResults = new JButton("Results");
		btnResults.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int i  = 40;
				 for (Employee employee : employees) {
					createInfoButtons(i);
					i += 200;
				}
					
				
			}
		});
		btnResults.setBounds(574, 273, 89, 53);
		contentPane.add(btnResults);
		contentPane.repaint();
	}
	
	public static void createInfoButtons(int i) {
		JButton btnEmployee = new JButton("employee " + i+1);
		btnEmployee.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnEmployee.setBounds(i, 396, 164, 56);
		contentPane.add(btnEmployee);
		contentPane.repaint();
	}
}
