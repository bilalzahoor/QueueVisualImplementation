import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.Window;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ElementWindow {

	public JFrame frame;
	private JTextField textField;
	static int noOfElements;
	JTextField[] elements;
	static HomeFrame home;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {;
					ElementWindow window = new ElementWindow(noOfElements,home);
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

	public ElementWindow(int n, HomeFrame h ) {
		noOfElements=n;
		home=h;

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
		
		JScrollPane scrollPane_1 = new JScrollPane();
		frame.getContentPane().add(scrollPane_1);
		
		Panel panel = new Panel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
	
		

		Panel panel_1 = new Panel();
	
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
		panel.add(panel_1);
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				//for(int i=0;i<noOfElements;i++) {
				//	JTextField t =(JTextField)elements[i].getComponent(2);	
				//}
				
				home.displayQueue(noOfElements,elements);
			frame.setVisible(false);
			}
		});
		frame.getContentPane().add(btnNewButton);
		elements = new JTextField[noOfElements];
		for(int i=0;i<noOfElements;i++) {
			JPanel panel_2 = new JPanel();
			panel_1.add(panel_2);
			panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
			
			JLabel lblNewLabel = new JLabel("Element "+(i+1));
			panel_2.add(lblNewLabel);
			
			Component horizontalStrut = Box.createHorizontalStrut(30);
			panel_2.add(horizontalStrut);
			
			textField = new JTextField();
			panel_2.add(textField);
			textField.setColumns(10);
			Component Strut = Box.createVerticalStrut(30);
			panel_1.add(Strut);
			elements[i]=textField;
			
		}
		panel_1.revalidate();
		

	}

	protected void close() {
		// TODO Auto-generated method stub
		
	}

}
