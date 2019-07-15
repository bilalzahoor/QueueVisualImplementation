import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Panel;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.border.MatteBorder;
import java.awt.Dimension;
import java.awt.SystemColor;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class HomeFrame {

	private JFrame frame;
	JButton btnDst;
	public int capacity;
	JComboBox<String> cmbCapacity;
	JLabel lblDisplay;
	JLabel lblElement;
	JButton btnEnQ;
	JButton btnDeQ;
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
	JComboBox TypeBox;
	JRadioButton rdbtnFront;
	JRadioButton rdbtnDFront;
	private JTextField textFieldCapacity;
	private JTextField textFieldSize;
	private JTextField textFieldRear;
	private JTextField textFieldFront;
	private JTextField txtFieldEnQ;
	private int rear;
	private int front;
	private JLabel lblError;
	private JLabel lblFempty;
	private String queueType;
	private Panel EnqueuePanel;
	private Panel DQInsertAtPNL;
	public Panel DeleteFromPanel;
	private final ButtonGroup buttonGroupInsert = new ButtonGroup();
	private final ButtonGroup buttonGroupDelete = new ButtonGroup();
	private JLabel lblSelectMaxCapacity;
	private JLabel lblInfoPanel;
	private JLabel lblOperations;
	
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
		frame.setResizable(false);
		
		Panel visualPanel = new Panel();
		visualPanel.setBackground(Color.decode("#2E100F"));
		visualPanel.setBounds(0, 0, 1047, 721);
		frame.getContentPane().add(visualPanel);
		visualPanel.setLayout(null);
		
		lblDisplay = new JLabel("DISPLAY PANEL");
		lblDisplay.setBounds(12, 13, 1023, 127);
		lblDisplay.setHorizontalAlignment(SwingConstants.CENTER);
		lblDisplay.setForeground(Color.decode("#ffbf00"));
		lblDisplay.setFont(new Font("Sitka Banner", Font.BOLD, 99));
		visualPanel.add(lblDisplay);
		
		JPanel MainPanel = new JPanel();
		MainPanel.setBounds(12, 151, 1023, 339);
		MainPanel.setBackground(SystemColor.info);
		visualPanel.add(MainPanel);
		MainPanel.setLayout(null);
		
		Panel InfoPanel = new Panel();
		InfoPanel.setBackground(SystemColor.controlHighlight);
		InfoPanel.setBounds(807, 59, 206, 169);
		MainPanel.add(InfoPanel);
		InfoPanel.setLayout(null);
		
		JLabel lblCapacity = new JLabel("Capacity:");
		lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCapacity.setBackground(Color.WHITE);
		lblCapacity.setForeground(SystemColor.controlDkShadow);
		lblCapacity.setBounds(10, 11, 64, 14);
		InfoPanel.add(lblCapacity);
		
		textFieldCapacity = new JTextField();
		textFieldCapacity.setEditable(false);
		textFieldCapacity.setBounds(86, 8, 86, 20);
		InfoPanel.add(textFieldCapacity);
		textFieldCapacity.setColumns(10);
		
		JLabel lblSize = new JLabel("Size:");
		lblSize.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSize.setForeground(SystemColor.controlDkShadow);
		lblSize.setBounds(10, 53, 46, 14);
		InfoPanel.add(lblSize);
		
		textFieldSize = new JTextField();
		textFieldSize.setEditable(false);
		textFieldSize.setBounds(86, 50, 86, 20);
		InfoPanel.add(textFieldSize);
		textFieldSize.setColumns(10);
		
		JLabel lblFront = new JLabel("Front:");
		lblFront.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblFront.setForeground(SystemColor.controlDkShadow);
		lblFront.setBounds(10, 95, 46, 14);
		InfoPanel.add(lblFront);
		
		textFieldFront = new JTextField();
		textFieldFront.setEditable(false);
		textFieldFront.setBounds(86, 92, 86, 20);
		InfoPanel.add(textFieldFront);
		textFieldFront.setColumns(10);
		
		
		JLabel lblRear = new JLabel("Rear:");
		lblRear.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRear.setForeground(SystemColor.controlDkShadow);
		lblRear.setBounds(10, 133, 46, 14);
		InfoPanel.add(lblRear);
		
		textFieldRear = new JTextField();
		textFieldRear.setEditable(false);
		textFieldRear.setBounds(86, 130, 86, 20);
		InfoPanel.add(textFieldRear);
		textFieldRear.setColumns(10);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 11, 791, 217);
		 MainPanel.add(scrollPane);
		 
		 JPanel panel_1 = new JPanel();
		 scrollPane.setViewportView(panel_1);
		 panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		 
		  panelQueue = new JPanel();
		  panel_1.add(panelQueue);
		  panelQueue.setLayout(new BoxLayout(panelQueue, BoxLayout.X_AXIS));
		  panelQueue.setVisible(true);
		  
		  lblQueueIsEmpty = new JLabel("QUEUE IS EMPTY");
		  lblQueueIsEmpty.setHorizontalAlignment(SwingConstants.CENTER);
		  panel_1.add(lblQueueIsEmpty);
		  lblQueueIsEmpty.setFont(new Font("Tahoma", Font.BOLD, 91));
		  
		  EnqueuePanel = new Panel();
		  EnqueuePanel.setBounds(10, 234, 689, 98);
		  MainPanel.add(EnqueuePanel);
		  EnqueuePanel.setBackground(SystemColor.controlHighlight);
		  EnqueuePanel.setLayout(null);
		  EnqueuePanel.setVisible(false);
		  
		  txtFieldEnQ = new JTextField();
		  txtFieldEnQ.setBounds(516, 26, 116, 22);
		  EnqueuePanel.add(txtFieldEnQ);
		  txtFieldEnQ.setColumns(10);
		 
		  
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
				lblFempty.setVisible(true);	
				DQInsertAtPNL.setVisible(false);
			}
	 });
		  btnInsert.setBounds(516, 62, 116, 25);
		  EnqueuePanel.add(btnInsert);
		  
		  lblEnterTheElement = new JLabel("Enter the Element to be Inserted: ");
		  lblEnterTheElement.setHorizontalAlignment(SwingConstants.CENTER);
		  lblEnterTheElement.setBounds(46, 25, 272, 23);
		  EnqueuePanel.add(lblEnterTheElement);
		  lblEnterTheElement.setBackground(SystemColor.controlHighlight);
		  lblEnterTheElement.setForeground(SystemColor.desktop);
		  lblEnterTheElement.setFont(new Font("Sitka Subheading", Font.BOLD, 16));
		  
		  lblFempty = new JLabel("");
		  lblFempty.setForeground(Color.RED);
		  lblFempty.setBounds(56, 68, 165, 19);
		  EnqueuePanel.add(lblFempty);
		  
		  DQInsertAtPNL = new Panel();
		  DQInsertAtPNL.setBackground(SystemColor.controlHighlight);
		  DQInsertAtPNL.setBounds(705, 234, 308, 98);
		  MainPanel.add(DQInsertAtPNL);
		  DQInsertAtPNL.setLayout(null);
		  DQInsertAtPNL.setVisible(false);
		  
		  rdbtnRear = new JRadioButton("Rear");
		  rdbtnRear.setFont(new Font("Sitka Text", Font.BOLD, 11));
		  rdbtnRear.setSelected(true);
		  buttonGroupInsert.add(rdbtnRear);
		  rdbtnRear.setBackground(SystemColor.controlHighlight);
		  rdbtnRear.setBounds(29, 40, 87, 23);
		  DQInsertAtPNL.add(rdbtnRear);
		  
		  rdbtnFront = new JRadioButton("Front");
		  rdbtnFront.setFont(new Font("Sitka Text", Font.BOLD, 11));
		  buttonGroupInsert.add(rdbtnFront);
		  rdbtnFront.setBackground(SystemColor.controlHighlight);
		  rdbtnFront.setBounds(221, 40, 87, 23);
		  DQInsertAtPNL.add(rdbtnFront);
		  
		  JLabel lblInsertAt = new JLabel("Insert At:");
		  lblInsertAt.setFont(new Font("Sitka Display", Font.BOLD, 22));
		  lblInsertAt.setBounds(110, 0, 103, 33);
		  DQInsertAtPNL.add(lblInsertAt);
		  
		  lblInfoPanel = new JLabel("INFO PANEL");
		  lblInfoPanel.setBackground(SystemColor.info);
		  lblInfoPanel.setFont(new Font("Sitka Display", Font.BOLD, 26));
		  lblInfoPanel.setForeground(SystemColor.controlDkShadow);
		  lblInfoPanel.setHorizontalAlignment(SwingConstants.CENTER);
		  lblInfoPanel.setBounds(807, 11, 206, 42);
		  MainPanel.add(lblInfoPanel);
		  
		  Panel ErrPNL = new Panel();
		  ErrPNL.setBounds(0, 496, 1047, 225);
		  visualPanel.add(ErrPNL);
		  ErrPNL.setLayout(null);
		  
		  lblError = new JLabel("");
		  lblError.setHorizontalAlignment(SwingConstants.CENTER);
		  lblError.setFont(new Font("Sitka Heading", Font.BOLD, 66));
		  lblError.setForeground(Color.RED);
		  lblError.setBounds(0, 77, 1047, 82);
		  lblError.setVisible(false);
		  ErrPNL.add(lblError);
		 // lblQueueIsEmpty_1.setVisible(false);
		capacity= 5;
		Panel controlPanel = new Panel();
		controlPanel.setBackground(Color.decode("#2F2F2F"));
		controlPanel.setBounds(1053, 0, 265, 721);
		frame.getContentPane().add(controlPanel);
		controlPanel.setLayout(null);
		
		TypeBox = new JComboBox();
		TypeBox.setFont(new Font("Sitka Text", Font.BOLD, 11));
		TypeBox.setForeground(Color.BLACK);
		TypeBox.setModel(new DefaultComboBoxModel (new String[] { "Simple Queue","Doubly Ended Queue (DEque)", "Priority Queue", "Circular Queue"} ));
		TypeBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String s =TypeBox.getSelectedItem().toString();
				if(s.compareTo("Doubly Ended Queue (DEqueue)")==0)
				{
					DeleteFromPanel.setVisible(true);
				queueType="DQ";
				lblError.setVisible(false);
				}
		else if(s.compareTo("Simple Queue")==0) {
			DeleteFromPanel.setVisible(false);
			queueType="SQ";
			lblError.setVisible(false);	
		}
				
			}
		});
		TypeBox.setBounds(12, 169, 241, 32);
		controlPanel.add(TypeBox);
		
		TypeBox.setBackground(Color.decode("#bdc3c7"));
		TypeBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		btnCrt = new JButton("Create");
		btnCrt.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnCrt.setBackground(SystemColor.inactiveCaption);
		btnCrt.setBounds(12, 422, 103, 28);
		btnCrt.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		btnCrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateQueueFrame win = new CreateQueueFrame(homeWin);
				win.frame.setVisible(true);
				panelQueue.setVisible(true);
				btnCrt.setEnabled(false);
				cmbCapacity.setEnabled(false);
				TypeBox.setEnabled(false); 
				lblError.setVisible(false);
			
			}
		});
		
		cmbCapacity = new JComboBox<String>();
		cmbCapacity.setFont(new Font("Sitka Text", Font.BOLD, 11));
		cmbCapacity.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		cmbCapacity.setBackground(Color.decode("#bdc3c7"));
		cmbCapacity.setComponentOrientation(ComponentOrientation.UNKNOWN);
		cmbCapacity.setBounds(12, 276, 241, 32);
		cmbCapacity.addItem("5");
		cmbCapacity.addItem("10");
		cmbCapacity.addItem("60");
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
				btnEnQ.setEnabled(false);
				btnDeQ.setEnabled(false);
				btnCrt.setEnabled(true);
				lblError.setVisible(true);
				lblError.setText("Queue Deleted!");
				TypeBox.setEnabled(true);
				cmbCapacity.setEnabled(true);
				btnDst.setEnabled(false);
				EnqueuePanel.setVisible(false);
				
			}
		});
		btnDst.setBackground(SystemColor.activeCaption);
		btnDst.setBounds(150, 422, 103, 28);
		controlPanel.add(btnDst);
		btnDst.setEnabled(false);
		btnDst.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		
		btnEnQ = new JButton("Enqueue");
		btnEnQ.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnEnQ.setEnabled(false);
		btnEnQ.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				lblFempty.setVisible(false);
				if(queueType.compareTo("SQ")==0) {
					if(rear==(capacity-1)) {
			  			
			  			lblError.setVisible(true);
			  			lblError.setText("Queue is Full!");
			  		}
					else {
						EnqueuePanel.setVisible(true);
						txtFieldEnQ.setText(null);
						DQInsertAtPNL.setVisible(false);
			  			
			  		}

				}
				else if(queueType.compareTo("DQ")==0) {
					if(rear==(capacity-1) && front==0) {
			  			
			  			lblError.setVisible(true);
			  			lblError.setText("Queue is Full!");
			  		}
					else {
						EnqueuePanel.setVisible(true);
						DQInsertAtPNL.setVisible(true);
			  			txtFieldEnQ.setText(null);
			  			

			  		}
				}
				
			}
		 });
		btnEnQ.setBackground(SystemColor.activeCaption);
		btnEnQ.setBounds(12, 494, 103, 28);
		controlPanel.add(btnEnQ);
		btnEnQ.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		
		btnDeQ = new JButton("Dequeue");
		btnDeQ.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnDeQ.addActionListener(new ActionListener() {
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
		btnDeQ.setEnabled(false);
		btnDeQ.setBackground(SystemColor.activeCaption);
		btnDeQ.setBounds(150, 494, 103, 28);
		controlPanel.add(btnDeQ);
		btnDeQ.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		
		JLabel TKitHeadings = new JLabel("Toolkit");
		TKitHeadings.setForeground(Color.decode("#e67e22"));
		TKitHeadings.setFont(new Font("Sitka Banner", Font.BOLD, 56));
		TKitHeadings.setHorizontalAlignment(SwingConstants.CENTER);
		TKitHeadings.setBounds(12, 11, 241, 116);
		controlPanel.add(TKitHeadings);
		
		DeleteFromPanel = new Panel();
		DeleteFromPanel.setEnabled(false);
		DeleteFromPanel.setBackground(SystemColor.controlDkShadow);
		DeleteFromPanel.setBounds(0, 571, 265, 108);
		controlPanel.add(DeleteFromPanel);
		DeleteFromPanel.setVisible(false);
		DeleteFromPanel.setLayout(null);
		
		rdbtnDFront = new JRadioButton("Front");
		rdbtnDFront.setForeground(SystemColor.desktop);
		rdbtnDFront.setFont(new Font("Sitka Text", Font.BOLD, 18));
		rdbtnDFront.setSelected(true);
		buttonGroupDelete.add(rdbtnDFront);
		rdbtnDFront.setBackground(SystemColor.controlDkShadow);
		rdbtnDFront.setBounds(23, 54, 80, 38);
		DeleteFromPanel.add(rdbtnDFront);
		
		JRadioButton rdbtnDRear = new JRadioButton("Rear");
		rdbtnDRear.setForeground(SystemColor.desktop);
		rdbtnDRear.setFont(new Font("Sitka Text", Font.BOLD, 18));
		buttonGroupDelete.add(rdbtnDRear);
		rdbtnDRear.setBackground(SystemColor.controlDkShadow);
		rdbtnDRear.setBounds(179, 54, 80, 38);
		DeleteFromPanel.add(rdbtnDRear);
		
		JLabel lblDeleteFrom = new JLabel("Delete From:");
		lblDeleteFrom.setForeground(SystemColor.info);
		lblDeleteFrom.setHorizontalAlignment(SwingConstants.CENTER);
		lblDeleteFrom.setFont(new Font("Sitka Display", Font.BOLD, 22));
		lblDeleteFrom.setBounds(51, 11, 165, 36);
		DeleteFromPanel.add(lblDeleteFrom);
		
		JLabel lblSelectType = new JLabel("Select Type: ");
		lblSelectType.setFont(new Font("Sitka Heading", Font.BOLD, 26));
		lblSelectType.setForeground(SystemColor.info);
		lblSelectType.setBackground(SystemColor.windowBorder);
		lblSelectType.setBounds(12, 130, 162, 32);
		controlPanel.add(lblSelectType);
		
		lblSelectMaxCapacity = new JLabel("Select Max Capacity:");
		lblSelectMaxCapacity.setFont(new Font("Sitka Heading", Font.BOLD, 24));
		lblSelectMaxCapacity.setForeground(SystemColor.info);
		lblSelectMaxCapacity.setBackground(SystemColor.windowBorder);
		lblSelectMaxCapacity.setBounds(10, 224, 243, 41);
		controlPanel.add(lblSelectMaxCapacity);
		
		lblOperations = new JLabel("OPERATION'S:");
		lblOperations.setForeground(SystemColor.info);
		lblOperations.setFont(new Font("Sitka Heading", Font.BOLD, 26));
		lblOperations.setBounds(12, 352, 241, 32);
		controlPanel.add(lblOperations);
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
			if(txtFieldEnQ.getText().trim().isEmpty())
			{
				lblFempty.setText("Field Is Empty!");
			}
			// if the queue is empty
	  		else if(rear==-1){
	  			lblError.setVisible(false);
	  			EnqueuePanel.setVisible(false);
	  			
	  			JLabel lbl =(JLabel)elements[rear+1].getComponent(1);
	  			lbl.setText(txtFieldEnQ.getText());
	  			lbl =(JLabel)elements[rear+1].getComponent(2);
	  			lbl.setText("Front/Rear");
	  			rear=rear+1;
	  			front=front+1;
	  			textFieldRear.setText(""+rear);
	  			textFieldFront.setText(""+front);
	  		}
				//if queue contains at least one element
	  		else if(rear<=capacity) {
	  			EnqueuePanel.setVisible(false);
	  			JLabel lbl =(JLabel)elements[rear+1].getComponent(1);
	  			lbl.setText(txtFieldEnQ.getText());
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
		if(txtFieldEnQ.getText().trim().isEmpty())
		{
			lblFempty.setText("Field Is Empty");
		}
		// if the queue is empty
  		else if(rear==-1){
  			lblError.setVisible(false);
  			EnqueuePanel.setVisible(false);
  			JLabel lbl =(JLabel)elements[rear+1].getComponent(1);
  			lbl.setText(txtFieldEnQ.getText());
  			lbl =(JLabel)elements[rear+1].getComponent(2);
  			lbl.setText("Front/Rear");
  			rear=rear+1;
  			front=front+1;
  			textFieldRear.setText(""+rear);
  			textFieldFront.setText(""+front);
  		}
		//if queue contains at least one element
  		else {
  			EnqueuePanel.setVisible(false);
  			JLabel lbl =(JLabel)elements[front-1].getComponent(1);
  			lbl.setText(txtFieldEnQ.getText());
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
  		//if array contains more than one element
		if(rear!=front) {
				lbl=(JLabel)elements[rear-1].getComponent(2);
				lbl.setText("Rear");
				rear=rear-1;
				textFieldFront.setText(""+rear);
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
}
