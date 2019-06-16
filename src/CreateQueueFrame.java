import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateQueueFrame {

	 public JFrame frame;
	 private JTextField textField;
	 HomeFrame home;
	 JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateQueueFrame window = new CreateQueueFrame();
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
	public CreateQueueFrame() {
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
		lblNewLabel.setBounds(0, 0, 165, 77);
		frame.getContentPane().add(lblNewLabel);
		home = new HomeFrame();
		
		textField = new JTextField();
		textField.setBounds(222, 27, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int c = Integer.parseInt(textField.getText().toString());
				lblNewLabel.setText("capac"+home.capacity+"ele"+c);
				if(c<=home.capacity) {
					lblNewLabel.setText("capac"+home.capacity+"ele"+c);
					
				}
				else {
					
					
					
				}
				
				
				
			}
		});
		btnCreate.setBounds(129, 94, 97, 25);
		frame.getContentPane().add(btnCreate);
	}
}
