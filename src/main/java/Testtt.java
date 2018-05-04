import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Testtt extends JFrame {

	private JPanel contentPane;
	static Testtt frame;
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					 frame = new Testtt();
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
	public Testtt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCreateLabel = new JButton("Create Label");
		btnCreateLabel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				createLabel(frame.contentPane);
			}
			
		});
		
		btnCreateLabel.setBounds(107, 11, 211, 35);
		contentPane.add(btnCreateLabel);
		
		/*JLabel lblHaha = new JLabel("Haha");
		lblHaha.setFont(new Font("Tahoma", Font.BOLD, 29));
		lblHaha.setBounds(48, 51, 117, 53);
		contentPane.add(lblHaha);*/
	}//Cons
	
	private static void createLabel(JPanel contentPane) {
		
		  JLabel v = new JLabel ("xxxxxxxxxx");
	        v.setBounds(50,50,50,50);
	        contentPane.add(v);
	        contentPane.repaint();
		
		JLabel label  = new JLabel("HAHA");
		label.setFont(new Font("Tahoma", Font.BOLD, 29));
		label.setBounds(48, 51, 117, 53);
		contentPane.add(label);
		
		
	}

}
