import java.awt.EventQueue;
import java.awt.*;
import javax.swing.JFrame;
import java.awt.Panel;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JScrollPane;

public class ElementWindow {

	public JFrame frame;
	private JTextField textField;
	static int noOfElements;
	JTextField[] elements;
	JButton btnDst;
	static HomeFrame home;
	JLabel lblNumonly;
	JButton btnCrt;
	JScrollPane scrollPane;
	Panel ElementPNL;
	JPanel panel_2 ;
	JTextField textFieldPrt;
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
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				home.btnCrt.setEnabled(true);
				home.TypeBox.setEnabled(true);
				home.cmbCapacity.setEnabled(true);
			}
		});
		frame.setBounds(100, 100, 806, 766);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		frame.isMaximumSizeSet();
		frame.getContentPane().setLayout(null);
		frame.setTitle("ElementWindow");
		//frame.setResizable(false);
		frame.setAlwaysOnTop(true);
		
		btnCrt = new JButton("Create");
		btnCrt.setBounds(313, 702, 141, 21);
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
							home.IconDsQ1.setVisible(false);
							home.DeleteFromPanel.setEnabled(true);
							home. rdbtnDFront.setEnabled(true);
							home. rdbtnDRear.setEnabled(true);
							frame.setVisible(false);
				}
			}
		});
		frame.getContentPane().add(btnCrt);
		
		lblNumonly = new JLabel("");
		lblNumonly.setFont(new Font("Sitka Small", Font.BOLD, 11));
		lblNumonly.setForeground(Color.RED);
		lblNumonly.setBounds(627, 709, 153, 14);
		frame.getContentPane().add(lblNumonly);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 70, 770, 621);
		frame.getContentPane().add(scrollPane);
		//ElementPNL.revalidate();
		
		
		Panel MainPNL = new Panel();
		scrollPane.setViewportView(MainPNL);
		MainPNL.setBackground(Color.WHITE);
		MainPNL.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
			

			ElementPNL = new Panel();
			ElementPNL.setBackground(Color.WHITE);
			MainPNL.add(ElementPNL);
			ElementPNL.setLayout(new BoxLayout(ElementPNL, BoxLayout.Y_AXIS));
			
			Panel panel = new Panel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(10, 0, 770, 64);
			frame.getContentPane().add(panel);
			panel.setLayout(null);
			
			JLabel lblEnterTheElements = new JLabel("Enter The Element's");
			lblEnterTheElements.setBackground(Color.WHITE);
			lblEnterTheElements.setHorizontalAlignment(SwingConstants.CENTER);
			lblEnterTheElements.setFont(new Font("Sitka Banner", Font.BOLD, 50));
			lblEnterTheElements.setBounds(0, 0, 768, 64);
			panel.add(lblEnterTheElements);
						
		elements = new JTextField[noOfElements];
		for(int i=0;i<noOfElements;i++) {
			panel_2 = new JPanel();
			panel_2.setBounds(12, 276, 241, 32);
			ElementPNL.add(panel_2);
			
			//panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.X_AXIS));
			
			JLabel lblNewLabel = new JLabel("Element "+(i+1));
			lblNewLabel.setFont(new Font("Sitka Heading", Font.BOLD, 24));
			panel_2.add(lblNewLabel);
			
			Component horizontalStrut = Box.createHorizontalStrut(50);
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
		
	}
}
