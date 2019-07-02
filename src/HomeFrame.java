import java.awt.EventQueue;

import java.applet.Applet;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTable;
import java.awt.Panel;
import javax.swing.BoxLayout;
import java.awt.Component;

import javax.swing.AbstractButton;
import javax.swing.Box;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.ComponentOrientation;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.SystemColor;

public class HomeFrame {

	private JFrame frame;
	JButton btnDst;
	public int capacity;
	JComboBox cmbCapacity;
	JLabel lblEmpty;
	static HomeFrame homeWin;
	JPanel panelQueue;
	JPanel[] elements=null;
	private JTextField textFieldCapacity;
	private JTextField textFieldSize;
	private JTextField textFieldRear;
	private JTextField textFieldFront;
	private JTextField txtElement;
	private int rear;
	private int front;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame window = new HomeFrame();
					homeWin=window;
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
	public HomeFrame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(44, 62, 82));
		frame.setBounds(100, 100, 1336, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel visualPanel = new Panel();
		visualPanel.setBackground(Color.decode("#2E100F"));
		visualPanel.setBounds(0, 0, 1047, 721);
		frame.getContentPane().add(visualPanel);
		visualPanel.setLayout(null);
		
		lblEmpty = new JLabel("DISPLAY PANEL");
		lblEmpty.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpty.setBounds(12, 13, 1023, 85);
		lblEmpty.setForeground(Color.decode("#ffbf00"));
		lblEmpty.setFont(new Font("Tahoma", Font.PLAIN, 70));
		visualPanel.add(lblEmpty);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 151, 1023, 354);
		visualPanel.add(panel);
		panel.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBounds(807, 24, 206, 204);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setBackground(Color.WHITE);
		lblCapacity.setForeground(Color.BLACK);
		lblCapacity.setBounds(10, 11, 52, 14);
		panel_2.add(lblCapacity);
		
		textFieldCapacity = new JTextField();
		textFieldCapacity.setEditable(false);
		textFieldCapacity.setBounds(86, 8, 86, 20);
		panel_2.add(textFieldCapacity);
		textFieldCapacity.setColumns(10);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setBounds(10, 53, 46, 14);
		panel_2.add(lblSize);
		
		textFieldSize = new JTextField();
		textFieldSize.setEditable(false);
		textFieldSize.setBounds(86, 50, 86, 20);
		panel_2.add(textFieldSize);
		textFieldSize.setColumns(10);
		
		JLabel lblFront = new JLabel("Front:");
		lblFront.setBounds(10, 95, 46, 14);
		panel_2.add(lblFront);
		
		textFieldFront = new JTextField();
		textFieldFront.setEditable(false);
		textFieldFront.setBounds(86, 92, 86, 20);
		panel_2.add(textFieldFront);
		textFieldFront.setColumns(10);
		
		
		JLabel lblRear = new JLabel("Rear:");
		lblRear.setBounds(10, 133, 46, 14);
		panel_2.add(lblRear);
		
		textFieldRear = new JTextField();
		textFieldRear.setEditable(false);
		textFieldRear.setBounds(86, 130, 86, 20);
		panel_2.add(textFieldRear);
		textFieldRear.setColumns(10);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(89, 24, 712, 204);
		 panel.add(scrollPane);
		 
		 JPanel panel_1 = new JPanel();
		 scrollPane.setViewportView(panel_1);
		 panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		 
		  panelQueue = new JPanel();
		  panel_1.add(panelQueue);
		  panelQueue.setLayout(new BoxLayout(panelQueue, BoxLayout.X_AXIS));
		  
		  JLabel lblQueueIsEmpty = new JLabel("QUEUE IS EMPTY");
		  panel_1.add(lblQueueIsEmpty);
		  lblQueueIsEmpty.setFont(new Font("Tahoma", Font.BOLD, 82));
		  
		  Panel panel_3 = new Panel();
		  panel_3.setBounds(133, 246, 635, 98);
		  panel.add(panel_3);
		  panel_3.setBackground(SystemColor.controlHighlight);
		  panel_3.setLayout(null);
		  panel_3.setVisible(false);
		  
		  JLabel lblEnterTheElement = new JLabel("Enter the Element to be Inserted: ");
		  lblEnterTheElement.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		  lblEnterTheElement.setBounds(12, 13, 244, 39);
		  panel_3.add(lblEnterTheElement);
		  
		  txtElement = new JTextField();
		  txtElement.setToolTipText("Element.");
		  txtElement.setBounds(392, 22, 116, 22);
		  panel_3.add(txtElement);
		  txtElement.setColumns(10);
		  
		  JButton btnInsert = new JButton("Insert.");
		  btnInsert.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		if(rear==(capacity-1)) {
		  			
		  			
		  		}
		  		else {
		  			panel_3.setVisible(false);
		  			JLabel lbl =(JLabel)elements[rear+1].getComponent(1);
		  			lbl.setText(txtElement.getText());
		  			lbl =(JLabel)elements[rear+1].getComponent(2);
		  			lbl.setText("Rear");
		  			lbl =(JLabel)elements[rear].getComponent(2);
		  			lbl.setText(" ");
		  			rear=rear+1;
		  			textFieldRear.setText(""+rear);
		  			
		  		}
		  		
		  	
		  	}
		  });
		  btnInsert.setBounds(392, 60, 116, 25);
		  panel_3.add(btnInsert);
		  
		  JLabel lblQueueIsFull = new JLabel("Queue is Full.");
		  lblQueueIsFull.setBounds(0, 0, 635, 98);
		  panel_3.add(lblQueueIsFull);
		  lblQueueIsFull.setHorizontalAlignment(SwingConstants.CENTER);
		  lblQueueIsFull.setFont(new Font("Tahoma", Font.BOLD, 60));
		  lblQueueIsFull.setVisible(false);
		capacity= 5;
		Panel controlPanel = new Panel();
		controlPanel.setBackground(Color.decode("#2F2F2F"));
		controlPanel.setBounds(1053, 0, 265, 721);
		frame.getContentPane().add(controlPanel);
		controlPanel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(12, 142, 241, 32);
		controlPanel.add(comboBox);
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Simple Queue", "Priority Queue", "Circular Queue", "Doubly Ended Queue (DEqueue)"}));
		comboBox.setBackground(Color.decode("#bdc3c7"));
		comboBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnCrt = new JButton("Create");
		btnCrt.setBackground(Color.decode("#FAF0F6"));
		btnCrt.setBounds(12, 496, 103, 28);
		btnCrt.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateQueueFrame win = new CreateQueueFrame(homeWin);
				win.frame.setVisible(true);
				btnDst.setEnabled(true);
				lblQueueIsEmpty.setVisible(false);
			}
		});
		
		cmbCapacity = new JComboBox();
		cmbCapacity.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		cmbCapacity.setBackground(Color.decode("#bdc3c7"));
		cmbCapacity.setComponentOrientation(ComponentOrientation.UNKNOWN);
		cmbCapacity.setBounds(12, 187, 241, 32);
		cmbCapacity.addItem("5");
		cmbCapacity.addItem("10");
		controlPanel.add(cmbCapacity);
		cmbCapacity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						String s= cmbCapacity.getSelectedItem().toString();
						capacity=Integer.parseInt(s);
					
			}
		});
		
		
		controlPanel.add(btnCrt);
	//	displayQueue(10);
		btnDst = new JButton("Destroy");
		btnDst.setBackground(Color.decode("#FAF0F6"));
		btnDst.setBounds(150, 496, 103, 28);
		controlPanel.add(btnDst);
		btnDst.setEnabled(false);
		btnDst.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnNewButton_1 = new JButton("Enqueue");
		btnNewButton_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				
				if(elements==null) {
		  			
		  			
		  		}
		  		else{
		  			
		  			panel_3.setVisible(true);
		  		}
				
			}
		 });
		btnNewButton_1.setBackground(Color.decode("#FAF0F6"));
		btnNewButton_1.setBounds(12, 601, 103, 28);
		controlPanel.add(btnNewButton_1);
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JButton btnNewButton_2 = new JButton("Dequeue");
		btnNewButton_2.setBackground(Color.decode("#FAF0F6"));
		btnNewButton_2.setBounds(150, 601, 103, 28);
		controlPanel.add(btnNewButton_2);
		btnNewButton_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JLabel lblNewLabel = new JLabel("Toolkit");
		lblNewLabel.setForeground(Color.decode("#e67e22"));
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 241, 116);
		controlPanel.add(lblNewLabel);
	}
	void displayQueue(int n, JTextField[] e) {
		
		elements=new JPanel[capacity];
		
		//elements
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panelQueue.add(horizontalStrut);
		for(int i=0;i<capacity;i++) {
		JPanel panelElement = new JPanel();
		panelElement.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panelQueue.add(panelElement);
		panelElement.setLayout(new BoxLayout(panelElement, BoxLayout.Y_AXIS));
		
		JLabel lblIndex = new JLabel(""+i);
		lblIndex.setMaximumSize(new Dimension(50, 15));
		lblIndex.setMinimumSize(new Dimension(50, 15));
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		panelElement.add(lblIndex);
		
		JLabel lblElement ;
		if(i<n)
		{
		lblElement = new JLabel(""+e[i].getText());
		}
		else
			lblElement = new JLabel("NULL");
		
		lblElement.setBorder(new MatteBorder(3, 0, 3, 0, (Color) Color.RED));
		lblElement.setMaximumSize(new Dimension(50, 15));
		lblElement.setMinimumSize(new Dimension(50, 15));
		lblElement.setHorizontalAlignment(SwingConstants.CENTER);
		panelElement.add(lblElement);
		JLabel lblPointer = new JLabel("");
		if(i==0)
			lblPointer.setText("Front");
		
		else if(i==(n-1))
			lblPointer.setText("Rear");
		lblPointer.setMaximumSize(new Dimension(50, 15));
		lblPointer.setMinimumSize(new Dimension(50, 15));
		lblPointer.setHorizontalAlignment(SwingConstants.CENTER);
		panelElement.add(lblPointer);
		elements[i]=panelElement;
	//	Component horizontalStrut1 = Box.createHorizontalStrut(20);
		//panelQueue.add(horizontalStrut1);
		textFieldCapacity.setText(""+capacity);
		textFieldSize.setText(""+n);
		textFieldFront.setText(""+0);
		front=0;
		rear=n-1;
		textFieldRear.setText(""+(n-1));
		panelQueue.revalidate();
		
		
		}
		
		
		
	}
}
