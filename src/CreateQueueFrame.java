import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Component;
import javax.swing.border.BevelBorder;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CreateQueueFrame {

	 public JFrame frame;
	 private JTextField textField;
	 static HomeFrame homeWin;
	 JLabel lblNewLabel;
	 JButton btnCreate;
	 JLabel lblCreateError;
	 private JLabel lblNumOnly;
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
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		lblNewLabel = new JLabel("Enter Number of Elements");
		lblNewLabel.setBounds(32, 0, 165, 77);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent evt) {
				char c = evt.getKeyChar();
				if(Character.isLetter(c)  ) {
					textField.setEditable(false);
					lblNumOnly.setText("Enter Number's Only!");
				}
					else
					{
						
						textField.setEditable(true);
					}
			}
			
			public void keyReleased(KeyEvent e) {
				lblNumOnly.setText("");
			}
		});
		textField.setBounds(222, 27, 116, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		lblCreateError = new JLabel("");
		lblCreateError.setForeground(Color.RED);
		lblCreateError.setBounds(32, 166, 380, 84);
		frame.getContentPane().add(lblCreateError);
		
		btnCreate = new JButton("Create");
		btnCreate.setFont(new Font("Sitka Small", Font.BOLD, 15));
		btnCreate.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		btnCreate.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCreate.setBackground(SystemColor.activeCaption);
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(textField.getText().trim().isEmpty())
				{
					lblNumOnly.setText("Field is Empty");
				}
				else {
				
				int c = Integer.parseInt(textField.getText().trim().toString());
				
				 if(c>homeWin.capacity) {
					lblCreateError.setText("Queue size must be less than or equal to Maximum Capacity("+ homeWin.capacity+")");
					
				}
				else {
					ElementWindow win = new ElementWindow(c,homeWin);
					win.frame.setVisible(true);
					frame.setVisible(false);
					
					
				}
				
				
			}
			}
		});
		btnCreate.setBounds(119, 81, 149, 25);
		frame.getContentPane().add(btnCreate);
		
		JLabel lblOnlynum = new JLabel("");
		lblOnlynum.setBounds(169, 140, 46, 14);
		frame.getContentPane().add(lblOnlynum);
		
		lblNumOnly = new JLabel("");
		lblNumOnly.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNumOnly.setForeground(Color.RED);
		lblNumOnly.setBounds(272, 228, 152, 22);
		frame.getContentPane().add(lblNumOnly);
		
		
	}
}
