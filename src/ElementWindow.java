import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;

public class ElementWindow {

	public JFrame frame;
	private JTextField textField;
	int noOfElements;
	Panel[] elements;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ElementWindow window = new ElementWindow();
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
	public ElementWindow() {
		noOfElements=3;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		elements = new Panel[noOfElements];
		for(int i=0;i<noOfElements;i++) {
	
		//elements[i]=panel_1;
		}
	
	JScrollPane scrollPane = new JScrollPane();
	panel.add(scrollPane);
	Panel panel_1 = new Panel();
	scrollPane.setViewportView(panel_1);
		
		JLabel lblNewLabel = new JLabel("Element1\r\n");
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
	}

}
