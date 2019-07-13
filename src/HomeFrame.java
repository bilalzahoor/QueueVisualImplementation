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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
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
import javax.swing.border.TitledBorder;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.AbstractAction;
import javax.swing.Action;

public class HomeFrame {

	private JFrame frame;
	JButton btnDst;
	public int capacity;
	JComboBox cmbCapacity;
	JLabel lblEmpty;
	JLabel lblElement;
	JButton btnNewButton_1;
	JButton btnNewButton_2;
	JButton btnCrt;
	JLabel lblQueueIsEmpty;
	JLabel lblEnterTheElement;
	JLabel lblIndex;
	JLabel lblPointer;
	static HomeFrame homeWin;
	JPanel panelQueue;
	JPanel[] elements=null;
	JPanel panelElement;
	JRadioButton rdbtnRear;
	JButton btnInsert;
	JComboBox comboBox;
	JRadioButton rdbtnFront;
	JRadioButton rdbtnDFront;
	private JTextField textFieldCapacity;
	private JTextField textFieldSize;
	private JTextField textFieldRear;
	private JTextField textFieldFront;
	private JTextField txtElement;
	private int rear;
	private int front;
	private JLabel lblError;
	private JLabel lblNumonly;
	private String queueType;
	private Panel panel_3;
	private Panel panel_5;
	private Panel DeleteFromPanel;
	private final ButtonGroup buttonGroupInsert = new ButtonGroup();
	private JLabel lblDeleteFrom_1;
	private final ButtonGroup buttonGroupDelete = new ButtonGroup();
	
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
		front=-1;
		queueType="SQ";
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
		lblEmpty.setBounds(12, 13, 1023, 85);
		lblEmpty.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmpty.setForeground(Color.decode("#ffbf00"));
		lblEmpty.setFont(new Font("Tahoma", Font.PLAIN, 70));
		visualPanel.add(lblEmpty);
		
		JPanel panel = new JPanel();
		panel.setBounds(12, 151, 1023, 339);
		panel.setBackground(SystemColor.info);
		visualPanel.add(panel);
		panel.setLayout(null);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(SystemColor.controlHighlight);
		panel_2.setBounds(807, 24, 206, 204);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacity.setBackground(Color.WHITE);
		lblCapacity.setForeground(SystemColor.controlDkShadow);
		lblCapacity.setBounds(10, 11, 64, 14);
		panel_2.add(lblCapacity);
		
		textFieldCapacity = new JTextField();
		textFieldCapacity.setEditable(false);
		textFieldCapacity.setBounds(86, 8, 86, 20);
		panel_2.add(textFieldCapacity);
		textFieldCapacity.setColumns(10);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSize.setForeground(SystemColor.controlDkShadow);
		lblSize.setBounds(10, 53, 46, 14);
		panel_2.add(lblSize);
		
		textFieldSize = new JTextField();
		textFieldSize.setEditable(false);
		textFieldSize.setBounds(86, 50, 86, 20);
		panel_2.add(textFieldSize);
		textFieldSize.setColumns(10);
		
		JLabel lblFront = new JLabel("Front:");
		lblFront.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFront.setForeground(SystemColor.controlDkShadow);
		lblFront.setBounds(10, 95, 46, 14);
		panel_2.add(lblFront);
		
		textFieldFront = new JTextField();
		textFieldFront.setEditable(false);
		textFieldFront.setBounds(86, 92, 86, 20);
		panel_2.add(textFieldFront);
		textFieldFront.setColumns(10);
		
		
		JLabel lblRear = new JLabel("Rear:");
		lblRear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRear.setForeground(SystemColor.controlDkShadow);
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
		  panelQueue.setVisible(true);
		  
		  lblQueueIsEmpty = new JLabel("QUEUE IS EMPTY");
		  lblQueueIsEmpty.setHorizontalAlignment(SwingConstants.CENTER);
		  lblQueueIsEmpty.setBorder(new TitledBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null), "", TitledBorder.LEADING, TitledBorder.BELOW_BOTTOM, null, null));
		  panel_1.add(lblQueueIsEmpty);
		  lblQueueIsEmpty.setFont(new Font("Tahoma", Font.BOLD, 81));
		  
		   panel_3 = new Panel();
		  panel_3.setBounds(184, 234, 515, 98);
		  panel.add(panel_3);
		  panel_3.setBackground(SystemColor.controlHighlight);
		  panel_3.setLayout(null);
		  panel_3.setVisible(false);
		  
		  txtElement = new JTextField();
		  txtElement.setBounds(377, 25, 116, 22);
		  panel_3.add(txtElement);
		  txtElement.setColumns(10);
		 
		  
		  btnInsert = new JButton("Insert.");
		  btnInsert.setFont(new Font("Sitka Text", Font.BOLD, 16));
		  btnInsert.setBackground(SystemColor.activeCaption);
		  btnInsert.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		  btnInsert.setAlignmentX(Component.CENTER_ALIGNMENT);
		  btnInsert.addActionListener(new ActionListener() {
		  	
			public void actionPerformed(ActionEvent mv) {
				// insert into the simple queue
				if(queueType.compareTo("SQ")==0)
				{
					insertAtRear();
			  	}
				// insert in dequeue
				else if(queueType.compareTo("DQ")==0)
				{
					if(rdbtnRear.isSelected())
						insertAtRear();
					else
						insertAtFront();
					
				}
				lblNumonly.setVisible(true);	
				panel_5.setVisible(false);
			}
	 });
		  btnInsert.setBounds(377, 60, 116, 25);
		  panel_3.add(btnInsert);
		  
		  lblEnterTheElement = new JLabel("Enter the Element to be Inserted: ");
		  lblEnterTheElement.setHorizontalAlignment(SwingConstants.CENTER);
		  lblEnterTheElement.setBounds(46, 25, 247, 23);
		  panel_3.add(lblEnterTheElement);
		  lblEnterTheElement.setBackground(SystemColor.controlHighlight);
		  lblEnterTheElement.setForeground(SystemColor.controlDkShadow);
		  lblEnterTheElement.setFont(new Font("Times New Roman", Font.BOLD, 16));
		  
		  lblNumonly = new JLabel("");
		  lblNumonly.setForeground(Color.RED);
		  lblNumonly.setBounds(122, 68, 165, 19);
		  panel_3.add(lblNumonly);
		  
		  panel_5 = new Panel();
		  panel_5.setBackground(SystemColor.controlHighlight);
		  panel_5.setBounds(705, 234, 308, 98);
		  panel.add(panel_5);
		  panel_5.setLayout(null);
		  panel_5.setVisible(false);
		  
		  rdbtnRear = new JRadioButton("Rear");
		  rdbtnRear.setSelected(true);
		  buttonGroupInsert.add(rdbtnRear);
		  rdbtnRear.setBackground(SystemColor.controlHighlight);
		  rdbtnRear.setBounds(159, 21, 109, 23);
		  panel_5.add(rdbtnRear);
		  
		  rdbtnFront = new JRadioButton("Front");
		  buttonGroupInsert.add(rdbtnFront);
		  rdbtnFront.setBackground(SystemColor.controlHighlight);
		  rdbtnFront.setBounds(159, 68, 109, 23);
		  panel_5.add(rdbtnFront);
		  
		  JLabel lblInsertAt = new JLabel("Insert At:");
		  lblInsertAt.setFont(new Font("Sitka Display", Font.BOLD, 18));
		  lblInsertAt.setBounds(10, 21, 119, 23);
		  panel_5.add(lblInsertAt);
		  
		  JLabel lblNewLabel_1 = new JLabel("Insert At:");
		  lblNewLabel_1.setFont(new Font("Sitka Display", Font.BOLD, 18));
		  lblNewLabel_1.setBounds(10, 68, 119, 23);
		  panel_5.add(lblNewLabel_1);
		  
		  Panel panel_4 = new Panel();
		  panel_4.setBounds(0, 496, 1047, 225);
		  visualPanel.add(panel_4);
		  panel_4.setLayout(null);
		  
		  lblError = new JLabel("");
		  lblError.setHorizontalAlignment(SwingConstants.CENTER);
		  lblError.setFont(new Font("Sitka Heading", Font.BOLD, 66));
		  lblError.setForeground(Color.RED);
		  lblError.setBounds(0, 77, 1047, 82);
		  lblError.setVisible(false);
		  panel_4.add(lblError);
		 // lblQueueIsEmpty_1.setVisible(false);
		capacity= 5;
		Panel controlPanel = new Panel();
		controlPanel.setBackground(Color.decode("#2F2F2F"));
		controlPanel.setBounds(1053, 0, 265, 721);
		frame.getContentPane().add(controlPanel);
		controlPanel.setLayout(null);
		
		comboBox = new JComboBox();
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Simple Queue","Doubly Ended Queue (DEqueue)", "Priority Queue", "Circular Queue"}));
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String s =comboBox.getSelectedItem().toString();
				if(s.compareTo("Doubly Ended Queue (DEqueue)")==0)
				{
					DeleteFromPanel.setVisible(true);
				queueType="DQ";
				}
		else if(s.compareTo("Simple Queue")==0) {
			DeleteFromPanel.setVisible(false);
			queueType="SQ";
			
		}
				
			}
		});
		comboBox.setBounds(12, 142, 241, 32);
		controlPanel.add(comboBox);
		
		comboBox.setBackground(Color.decode("#bdc3c7"));
		comboBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		btnCrt = new JButton("Create");
		btnCrt.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnCrt.setBackground(SystemColor.inactiveCaption);
		btnCrt.setBounds(12, 386, 103, 28);
		btnCrt.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		btnCrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateQueueFrame win = new CreateQueueFrame(homeWin);
				win.frame.setVisible(true);
				panelQueue.setVisible(true);
				btnCrt.setEnabled(false);
				cmbCapacity.setEnabled(false);
				comboBox.setEnabled(false); 
				lblError.setVisible(false);
			
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
		btnDst = new JButton("Delete");
		btnDst.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnDst.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnDst.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblQueueIsEmpty.setVisible(true);
				panelQueue.removeAll();
				elements=null;
				textFieldCapacity.setText("");
				textFieldSize.setText("");
				textFieldFront.setText("");
				textFieldRear.setText("");
				btnNewButton_1.setEnabled(false);
				btnNewButton_2.setEnabled(false);
				btnCrt.setEnabled(true);
				lblError.setVisible(true);
				lblError.setText("Queue Deleted!");
				comboBox.setEnabled(true);
				cmbCapacity.setEnabled(true);
				btnDst.setEnabled(false);
				panel_3.setVisible(false);
				
			}
		});
		btnDst.setBackground(SystemColor.activeCaption);
		btnDst.setBounds(150, 386, 103, 28);
		controlPanel.add(btnDst);
		btnDst.setEnabled(false);
		btnDst.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		
		btnNewButton_1 = new JButton("Enqueue");
		btnNewButton_1.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				lblNumonly.setVisible(false);
				if(queueType.compareTo("SQ")==0) {
					if(rear==(capacity-1)) {
			  			
			  			lblError.setVisible(true);
			  			lblError.setText("Queue is Full!");
			  		}
					else {
			  			panel_3.setVisible(true);
			  			txtElement.setText(null);
			  			panel_5.setVisible(false);
			  			
			  		}

				}
				else if(queueType.compareTo("DQ")==0) {
					if(rear==(capacity-1) && front==0) {
			  			
			  			lblError.setVisible(true);
			  			lblError.setText("Queue is Full!");
			  		}
					else {
			  			panel_3.setVisible(true);
			  			panel_5.setVisible(true);
			  			txtElement.setText(null);
			  			

			  		}
				}
				
			}
		 });
		btnNewButton_1.setBackground(SystemColor.activeCaption);
		btnNewButton_1.setBounds(12, 457, 103, 28);
		controlPanel.add(btnNewButton_1);
		btnNewButton_1.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		
		btnNewButton_2 = new JButton("Dequeue");
		btnNewButton_2.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(queueType.compareTo("SQ")==0)
				{
					deleteAtFront();
			  	}
				else if(queueType.compareTo("DQ")==0) {
					if(rdbtnDFront.isSelected()) {
						deleteAtFront();
						}
					else {
						deleteAtRear();
					}
				}
			}
		});
		btnNewButton_2.setEnabled(false);
		btnNewButton_2.setBackground(SystemColor.activeCaption);
		btnNewButton_2.setBounds(150, 457, 103, 28);
		controlPanel.add(btnNewButton_2);
		btnNewButton_2.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		
		JLabel lblNewLabel = new JLabel("Toolkit");
		lblNewLabel.setForeground(Color.decode("#e67e22"));
		lblNewLabel.setFont(new Font("MS UI Gothic", Font.BOLD, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 13, 241, 116);
		controlPanel.add(lblNewLabel);
		
		DeleteFromPanel = new Panel();
		DeleteFromPanel.setBackground(SystemColor.textInactiveText);
		DeleteFromPanel.setBounds(0, 562, 265, 159);
		controlPanel.add(DeleteFromPanel);
		DeleteFromPanel.setVisible(false);
		DeleteFromPanel.setLayout(null);
		
		rdbtnDFront = new JRadioButton("Front");
		rdbtnDFront.setSelected(true);
		buttonGroupDelete.add(rdbtnDFront);
		rdbtnDFront.setBackground(SystemColor.textInactiveText);
		rdbtnDFront.setBounds(138, 28, 109, 23);
		DeleteFromPanel.add(rdbtnDFront);
		
		JRadioButton rdbtnDRear = new JRadioButton("Rear");
		buttonGroupDelete.add(rdbtnDRear);
		rdbtnDRear.setBackground(SystemColor.textInactiveText);
		rdbtnDRear.setBounds(138, 109, 109, 23);
		DeleteFromPanel.add(rdbtnDRear);
		
		JLabel lblDeleteFrom = new JLabel("Delete From:");
		lblDeleteFrom.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblDeleteFrom.setBounds(10, 28, 108, 23);
		DeleteFromPanel.add(lblDeleteFrom);
		
		lblDeleteFrom_1 = new JLabel("Delete From:");
		lblDeleteFrom_1.setFont(new Font("Sitka Display", Font.BOLD, 18));
		lblDeleteFrom_1.setBackground(SystemColor.info);
		lblDeleteFrom_1.setBounds(10, 109, 108, 23);
		DeleteFromPanel.add(lblDeleteFrom_1);
	}
	void displayQueue(int n, JTextField[] e) {
		
		elements=new JPanel[capacity];
		
		//elements
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panelQueue.add(horizontalStrut);
		for(int i=0;i<capacity;i++) {
		panelElement = new JPanel();
		panelElement.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panelQueue.add(panelElement);
		panelElement.setLayout(new BoxLayout(panelElement, BoxLayout.Y_AXIS));
		
		lblIndex = new JLabel(""+i);
		lblIndex.setMaximumSize(new Dimension(50, 15));
		lblIndex.setMinimumSize(new Dimension(50, 15));
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		panelElement.add(lblIndex);
		
		lblElement =new JLabel();
		if(i<n)
		{
		lblElement = new JLabel(""+e[i].getText());
		}
		else
			lblElement = new JLabel("NULL");
		
		lblElement.setBorder(new MatteBorder(3, 0, 3, 0, (Color) Color.RED));
		lblElement.setMaximumSize(new Dimension(50, 60));
		lblElement.setMinimumSize(new Dimension(50, 60));
		lblElement.setForeground(SystemColor.red);
		lblElement.setHorizontalAlignment(SwingConstants.CENTER);
		panelElement.add(lblElement);
		lblPointer = new JLabel("");
		if(i==0)
			lblPointer.setText("Front");
		
		else if(i==(n-1))
			lblPointer.setText("Rear");
		lblPointer.setMaximumSize(new Dimension(50, 15));
		lblPointer.setMinimumSize(new Dimension(50, 15));
		lblPointer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointer.setForeground(SystemColor.BLUE);
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
	// insert element at rear
	void insertAtRear() {
			if(txtElement.getText().trim().isEmpty())
			{
				lblNumonly.setText("Field Is Empty");
			}
			// if the queue is empty
	  		else if(rear==-1){
	  			lblError.setVisible(false);
	  			panel_3.setVisible(false);
	  			
	  			JLabel lbl =(JLabel)elements[rear+1].getComponent(1);
	  			lbl.setText(txtElement.getText());
	  			lbl =(JLabel)elements[rear+1].getComponent(2);
	  			lbl.setText("Front/Rear");
	  			rear=rear+1;
	  			front=front+1;
	  			textFieldRear.setText(""+rear);
	  			textFieldFront.setText(""+front);
	  		}
				//if queue contains at least one element
	  		else if(rear<=capacity) {
	  			panel_3.setVisible(false);
	  			JLabel lbl =(JLabel)elements[rear+1].getComponent(1);
	  			lbl.setText(txtElement.getText());
	  			lbl =(JLabel)elements[rear+1].getComponent(2);
	  			lbl.setText("Rear");
	  			lbl =(JLabel)elements[rear].getComponent(2);
	  			// if queue contains only one element
	  			if(front == rear)
	  			{
	  				lbl.setText("Front");
	  				
	  			}
	  			else
	  			
	  				lbl.setText(" ");
	  			rear=rear+1;
	  			textFieldRear.setText(""+rear);
	  			
	  		}
			
		}
	void insertAtFront() {
		if(txtElement.getText().trim().isEmpty())
		{
			lblNumonly.setText("Field Is Empty");
		}
		// if the queue is empty
  		else if(rear==-1){
  			lblError.setVisible(false);
  			panel_3.setVisible(false);
  			JLabel lbl =(JLabel)elements[rear+1].getComponent(1);
  			lbl.setText(txtElement.getText());
  			lbl =(JLabel)elements[rear+1].getComponent(2);
  			lbl.setText("Front/Rear");
  			rear=rear+1;
  			front=front+1;
  			textFieldRear.setText(""+rear);
  			textFieldFront.setText(""+front);
  		}
		//if queue contains at least one element
  		else {
  			panel_3.setVisible(false);
  			JLabel lbl =(JLabel)elements[front-1].getComponent(1);
  			lbl.setText(txtElement.getText());
  			lbl =(JLabel)elements[front-1].getComponent(2);
  			lbl.setText("Front");
  			lbl =(JLabel)elements[front].getComponent(2);
  			// if queue contains only one element
  			if(front == rear)
  			{
  				lbl.setText("Rear");
  				
  			}
  			else
  			
  				lbl.setText(" ");
  			front=front-1;
  			textFieldFront.setText(""+front);
  			
  		}

	}
	void deleteAtFront()
	{
		
		if(front==-1)
		{
			lblError.setVisible(true);
			lblError.setText("Queue is Empty!");
		}
		else {
			lblError.setVisible(false);
  			
  			JLabel lbl=(JLabel)elements[front].getComponent(1);
  			lbl.setText("NULL");
  			lbl=(JLabel)elements[front].getComponent(2);
  			lbl.setText(" ");
  			//if array contains more than one element
  			if(front!=rear) {
  				lbl=(JLabel)elements[front+1].getComponent(2);
  				lbl.setText("Front");
  				front=front+1;
  				textFieldFront.setText(""+front);
  			}
  			//if array contains only one element	
  			else {
  				front=-1;
  				rear=-1;
  				textFieldFront.setText(""+front);
  				textFieldRear.setText(""+rear);
  				
  			}
  			
  			
			
		}
		
		
		
		
		
	}
	void deleteAtRear()
	{
		if(rear==-1)
		{
			lblError.setVisible(true);
			lblError.setText("Queue is Empty!");
		}
		else {
			lblError.setVisible(false);
  			
  			JLabel lbl=(JLabel)elements[rear].getComponent(1);
  			lbl.setText("NULL");
  			lbl=(JLabel)elements[rear].getComponent(2);
  			lbl.setText(" ");
		
		if(rear!=front) {
				lbl=(JLabel)elements[rear-1].getComponent(2);
				lbl.setText("Rear");
				rear=rear-1;
				textFieldFront.setText(""+rear);
			}
		
		else {
				front=-1;
				rear=-1;
				textFieldFront.setText(""+front);
				textFieldRear.setText(""+rear);
			}
		}
	}
}
