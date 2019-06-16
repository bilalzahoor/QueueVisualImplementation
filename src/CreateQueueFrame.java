import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class CreateQueueFrame {

	 public JFrame frame;
	 private JTextField textField;
	 static HomeFrame homeWin;
	 JLabel lblNewLabel;
	 JLabel lblCreateError;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateQueueFrame window = new CreateQueueFrame(homeWin);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateQueueFrame(HomeFrame home) {
		this.homeWin=home;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Enter Number of Elements");
		lblNewLabel.setBounds(32, 0, 165, 77);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(222, 27, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		lblCreateError = new JLabel("");
		lblCreateError.setForeground(Color.RED);
		lblCreateError.setBounds(32, 166, 380, 84);
		frame.getContentPane().add(lblCreateError);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int c = Integer.parseInt(textField.getText().toString());
				if(c>homeWin.capacity) {
					lblCreateError.setText("Queue size must be less than or equal to Maximum Capacity("+ homeWin.capacity+")");
					
				}
				else {
					
					
					
				}
				
				
			}
		});
		btnCreate.setBounds(119, 81, 149, 25);
		frame.getContentPane().add(btnCreate);
		
		
	}
}
