import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Panel;
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
import javax.swing.border.BevelBorder;

public class ElementWindow {

	public JFrame frame;
	private JTextField textField;
	static int noOfElements;
	JTextField[] elements;
	JButton btnDst;
	static HomeFrame home;
	JLabel lblNumonly;
	JButton btnCrt;
	private JScrollPane scrollPane;
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
		frame.setBounds(100, 100, 1202, 701);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.isMaximumSizeSet();
		frame.getContentPane().setLayout(null);
		btnCrt = new JButton("Create");
		btnCrt.setBounds(554, 630, 141, 21);
		btnCrt.setBackground(SystemColor.activeCaption);
		btnCrt.setForeground(new Color(0, 0, 0));
		btnCrt.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCrt.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		btnCrt.setFont(new Font("Sitka Subheading", Font.BOLD, 15));
		btnCrt.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				//for(int i=0;i<noOfElements;i++) {
				//	JTextField t =(JTextField)elements[i].getComponent(2);	
				//}
				if(textField.getText().trim().isEmpty())
				{
					lblNumonly.setText("Field Is Empty!");
				
				}
					else {	
							home.btnDst.setEnabled(true);
							home.btnEnQ.setEnabled(true);
							home.btnDeQ.setEnabled(true);
							home.displayQueue(noOfElements,elements);
							home.lblQueueIsEmpty.setVisible(false);
							home.DeleteFromPanel.setEnabled(true);
							frame.setVisible(false);
				}
			}
		});
		frame.getContentPane().add(btnCrt);
		
		lblNumonly = new JLabel("");
		lblNumonly.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNumonly.setForeground(Color.RED);
		lblNumonly.setBounds(1001, 637, 153, 14);
		frame.getContentPane().add(lblNumonly);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 2, 2);
		frame.getContentPane().add(scrollPane);
		
		
		Panel MainPNL = new Panel();
		MainPNL.setBounds(10, 10, 1176, 614);
		
		frame.getContentPane().add(MainPNL);
		MainPNL.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
			

			Panel ElementPNL = new Panel();
			MainPNL.add(ElementPNL);
			ElementPNL.setLayout(new BoxLayout(ElementPNL, BoxLayout.Y_AXIS));
			ElementPNL.revalidate();
						
		elements = new JTextField[noOfElements];
		for(int i=0;i<noOfElements;i++) {
			JPanel panel_2 = new JPanel();
			ElementPNL.add(panel_2);
			panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
			
			JLabel lblNewLabel = new JLabel("Element "+(i+1));
			panel_2.add(lblNewLabel);
			
			Component horizontalStrut = Box.createHorizontalStrut(30);
			panel_2.add(horizontalStrut);
			
			textField = new JTextField();	
			panel_2.add(textField);
			textField.setColumns(10);
			Component Strut = Box.createVerticalStrut(30);
			ElementPNL.add(Strut);
			elements[i]=textField;
			
		}
		

	}

	protected void close() {
		// TODO Auto-generated method stub
		
	}
}
