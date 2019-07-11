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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import net.miginfocom.swing.MigLayout;

public class ElementWindow {

	public JFrame frame;
	private JTextField textField;
	static int noOfElements;
	JTextField[] elements;
	JButton btnDst;
	static HomeFrame home;
	JLabel lblNumonly;
	JButton btnNewButton;
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

	public ElementWindow(int n, HomeFrame h) {
		noOfElements=n;
		home=h;

		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 529, 285);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.isMaximumSizeSet();
		frame.getContentPane().setLayout(null);
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(7, 7, 497, 194);
		frame.getContentPane().add(scrollPane_1);
		
		
		Panel panel = new Panel();
		scrollPane_1.setViewportView(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
			

			Panel panel_1 = new Panel();
			
				panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));
				panel.add(panel_1);
				panel_1.revalidate();
		btnNewButton = new JButton("Create");
		btnNewButton.setBounds(179, 207, 141, 21);
		btnNewButton.setBackground(SystemColor.activeCaption);
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnNewButton.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		btnNewButton.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//for(int i=0;i<noOfElements;i++) {
				//	JTextField t =(JTextField)elements[i].getComponent(2);	
				//}
				if(textField.getText().trim().isEmpty())
				{
					lblNumonly.setText("Field Is Empty");
				
				}
					else {	
							home.btnDst.setEnabled(true);
							home.btnNewButton_1.setEnabled(true);
							home.btnNewButton_2.setEnabled(true);
							home.displayQueue(noOfElements,elements);
							home.lblQueueIsEmpty.setVisible(false);
							frame.setVisible(false);
				}
			}
		});
		frame.getContentPane().add(btnNewButton);
		
		lblNumonly = new JLabel("");
		lblNumonly.setBounds(360, 221, 153, 14);
		frame.getContentPane().add(lblNumonly);
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
		

	}

	protected void close() {
		// TODO Auto-generated method stub
		
	}

}
