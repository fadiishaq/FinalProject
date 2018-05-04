package windows;

import testPackage.PersonManagerTest;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.List;
import java.awt.Choice;
import java.awt.FlowLayout;
import javax.swing.JSpinner;
import java.awt.Scrollbar;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
import javax.swing.JToolBar;
import javax.swing.JSlider;
import java.awt.Canvas;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import javax.swing.JList;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Window.Type;

public class PersonManagerWindow extends JFrame {

	private JPanel contentPane;

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
		
		JButton addPersonButton = new JButton("Add Person");
		addPersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPersonWindow apt = new AddPersonWindow();
				PersonManagerWindow pm = new PersonManagerWindow();
				
				apt.setVisible(true);
				pm.setVisible(false);
			}
		});
		addPersonButton.setMaximumSize(new Dimension(100, 23));
		addPersonButton.setPreferredSize(new Dimension(110, 23));
		addPersonButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		addPersonButton.setBounds(29, 129, 228, 195);
		contentPane.add(addPersonButton);
		
		JLabel label = new JLabel("Person Manager");
		label.setFont(new Font("Tahoma", Font.BOLD, 71));
		label.setBounds(106, 11, 688, 86);
		contentPane.add(label);
		
		JButton searchPersonButton = new JButton("Search Person");
		searchPersonButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				SearchPersonWindow searchPersonWindow = new SearchPersonWindow();
				searchPersonWindow.setVisible(true);
				
				
				
			}
		});
		searchPersonButton.setMaximumSize(new Dimension(100, 23));
		searchPersonButton.setFont(new Font("Tahoma", Font.BOLD, 23));
		searchPersonButton.setBounds(278, 286, 252, 202);
		contentPane.add(searchPersonButton);
		
		JButton showReportButton = new JButton("Reports");
		showReportButton.setMaximumSize(new Dimension(100, 23));
		showReportButton.setFont(new Font("Tahoma", Font.BOLD, 24));
		showReportButton.setBounds(551, 122, 228, 208);
		contentPane.add(showReportButton);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 26));
		btnExit.setBounds(681, 552, 112, 49);
		contentPane.add(btnExit);
	}
}

