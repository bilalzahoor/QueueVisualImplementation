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
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

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
	JLabel lblIndex1;
	JLabel lblElement1;
	JLabel lblPointer1;
	static HomeFrame homeWin;
	JPanel panelQueue;
	JPanel[] elements=null;
	JPanel panelElement;
	JPanel panelDetls;
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
	Panel DQInsertAtPNL;
	public Panel DeleteFromPanel;
	private final ButtonGroup buttonGroupInsert = new ButtonGroup();
	private final ButtonGroup buttonGroupDelete = new ButtonGroup();
	private JLabel lblSelectMaxCapacity;
	private JLabel lblInfoPanel;
	private JLabel lblOperations;
	private Panel panel_2;
	JComboBox<String> cmbPriority;
	
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
		MainPanel.setBounds(12, 151, 805, 475);
		MainPanel.setBackground(SystemColor.info);
		visualPanel.add(MainPanel);
		MainPanel.setLayout(null);
		 
		 JScrollPane scrollPane = new JScrollPane();
		 scrollPane.setBounds(10, 11, 791, 350);
		 MainPanel.add(scrollPane);
		 
		 JPanel panel_1 = new JPanel();
		 scrollPane.setViewportView(panel_1);
		 panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		 
		  panelQueue = new JPanel();
		  panel_1.add(panelQueue);
		  panelQueue.setLayout(new BoxLayout(panelQueue, BoxLayout.X_AXIS));
		  
		  lblQueueIsEmpty = new JLabel("QUEUE IS EMPTY");
		  panel_1.add(lblQueueIsEmpty);
		  lblQueueIsEmpty.setHorizontalAlignment(SwingConstants.CENTER);
		  lblQueueIsEmpty.setFont(new Font("Tahoma", Font.BOLD, 91));
		  panelQueue.setVisible(true);
		  
		  EnqueuePanel = new Panel();
		  EnqueuePanel.setBounds(10, 367, 791, 98);
		  MainPanel.add(EnqueuePanel);
		  EnqueuePanel.setBackground(SystemColor.controlHighlight);
		  EnqueuePanel.setLayout(null);
		  EnqueuePanel.setVisible(false);
		  cmbPriority = new JComboBox<String>();
		  cmbPriority.setBounds(551, 26, 31, 22);
		  EnqueuePanel.add(cmbPriority);
		  
		  txtFieldEnQ = new JTextField();
		  txtFieldEnQ.setBounds(625, 26, 116, 22);
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
					{
						
						//if element cannot be inserted at rear end
						if(front!=0 && rear==(capacity-1)) {
							
							EnqueuePanel.setVisible(false);
							lblError.setVisible(true);
				  			lblError.setText("Element cannot be inserted at Rear as there is no space!");
							
						}
						else
							insertAtRear();
							EnqueuePanel.setVisible(false);
							DQInsertAtPNL.setEnabled(false);
							
					}
					else {
						//if list contains only one element at index 0 element cannot be inserted at front end
						 if(front==0) {
							 
							EnqueuePanel.setVisible(false);
							lblError.setVisible(true);
				  			lblError.setText("Element cannot be inserted at Front as there is no space!");
							
						}
						 else {
							 	insertAtFront();
							 	EnqueuePanel.setVisible(false);
						 		lblError.setVisible(false);
						 		DQInsertAtPNL.setEnabled(false);
						 }
					}
					
				}
				else if(queueType.compareTo("CQ")==0)
				{
					insertInCircularQueue();
			  	}
					
				
			}
	 });
		  
		  
		  btnInsert.setBounds(625, 62, 116, 25);
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
		
		  
		  Panel ErrPNL = new Panel();
		  ErrPNL.setBounds(0, 632, 1047, 89);
		  visualPanel.add(ErrPNL);
		  ErrPNL.setLayout(null);
		  
		  lblError = new JLabel("");
		  lblError.setHorizontalAlignment(SwingConstants.CENTER);
		  lblError.setFont(new Font("Sitka Heading", Font.BOLD, 40));
		  lblError.setForeground(Color.RED);
		  lblError.setBounds(0, 0, 1047, 82);
		  lblError.setVisible(false);
		  ErrPNL.add(lblError);
		  
		  Panel panel = new Panel();
		  panel.setBounds(821, 151, 208, 358);
		  visualPanel.add(panel);
		  panel.setBackground(SystemColor.info);
		  panel.setLayout(null);
		  
		  lblInfoPanel = new JLabel("INFO PANEL");
		  lblInfoPanel.setBounds(33, 5, 140, 33);
		  panel.add(lblInfoPanel);
		  lblInfoPanel.setBackground(SystemColor.info);
		  lblInfoPanel.setFont(new Font("Sitka Display", Font.BOLD, 26));
		  lblInfoPanel.setForeground(SystemColor.controlDkShadow);
		  lblInfoPanel.setHorizontalAlignment(SwingConstants.CENTER);
		  
		  Panel InfoPanel = new Panel();
		  InfoPanel.setBounds(0, 37, 206, 319);
		  panel.add(InfoPanel);
		  InfoPanel.setBackground(SystemColor.controlHighlight);
		  InfoPanel.setLayout(null);
		  
		  JLabel lblCapacity = new JLabel("Capacity:");
		  lblCapacity.setFont(new Font("Tahoma", Font.BOLD, 13));
		  lblCapacity.setBackground(Color.WHITE);
		  lblCapacity.setForeground(SystemColor.controlDkShadow);
		  lblCapacity.setBounds(10, 31, 64, 14);
		  InfoPanel.add(lblCapacity);
		  
		  textFieldCapacity = new JTextField();
		  textFieldCapacity.setHorizontalAlignment(SwingConstants.CENTER);
		  textFieldCapacity.setEditable(false);
		  textFieldCapacity.setBounds(86, 29, 86, 20);
		  InfoPanel.add(textFieldCapacity);
		  textFieldCapacity.setColumns(10);
		  
		  JLabel lblSize = new JLabel("Size:");
		  lblSize.setFont(new Font("Tahoma", Font.BOLD, 13));
		  lblSize.setForeground(SystemColor.controlDkShadow);
		  lblSize.setBounds(10, 110, 46, 14);
		  InfoPanel.add(lblSize);
		  
		  textFieldSize = new JTextField();
		  textFieldSize.setHorizontalAlignment(SwingConstants.CENTER);
		  textFieldSize.setEditable(false);
		  textFieldSize.setBounds(86, 108, 86, 20);
		  InfoPanel.add(textFieldSize);
		  textFieldSize.setColumns(10);
		  
		  JLabel lblFront = new JLabel("Front:");
		  lblFront.setFont(new Font("Tahoma", Font.BOLD, 13));
		  lblFront.setForeground(SystemColor.controlDkShadow);
		  lblFront.setBounds(10, 181, 46, 14);
		  InfoPanel.add(lblFront);
		  
		  textFieldFront = new JTextField();
		  textFieldFront.setHorizontalAlignment(SwingConstants.CENTER);
		  textFieldFront.setEditable(false);
		  textFieldFront.setBounds(86, 179, 86, 20);
		  InfoPanel.add(textFieldFront);
		  textFieldFront.setColumns(10);
		  
		  
		  JLabel lblRear = new JLabel("Rear:");
		  lblRear.setFont(new Font("Tahoma", Font.BOLD, 13));
		  lblRear.setForeground(SystemColor.controlDkShadow);
		  lblRear.setBounds(10, 266, 46, 14);
		  InfoPanel.add(lblRear);
		  
		  textFieldRear = new JTextField();
		  textFieldRear.setHorizontalAlignment(SwingConstants.CENTER);
		  textFieldRear.setEditable(false);
		  textFieldRear.setBounds(86, 264, 86, 20);
		  InfoPanel.add(textFieldRear);
		  textFieldRear.setColumns(10);
		  
		  panel_2 = new Panel();
		  panel_2.setBackground(SystemColor.info);
		  panel_2.setBounds(821, 512, 208, 114);
		  visualPanel.add(panel_2);
		  panel_2.setLayout(null);
		  
		  DQInsertAtPNL = new Panel();
		  DQInsertAtPNL.setBounds(0, 0, 206, 50);
		  panel_2.add(DQInsertAtPNL);
		  DQInsertAtPNL.setEnabled(false);
		  //DQInsertAtPNL.setEnabled(false);
		  DQInsertAtPNL.setBackground(SystemColor.controlHighlight);
		  DQInsertAtPNL.setLayout(null);
		  DQInsertAtPNL.setVisible(false);
		  
		  rdbtnRear = new JRadioButton("Rear");
		  rdbtnRear.setEnabled(false);
		  rdbtnRear.setFont(new Font("Sitka Text", Font.BOLD, 18));
		  rdbtnRear.setSelected(true);
		  buttonGroupInsert.add(rdbtnRear);
		  rdbtnRear.setBackground(SystemColor.controlHighlight);
		  rdbtnRear.setBounds(0, 29, 82, 14);
		  DQInsertAtPNL.add(rdbtnRear);
		  
		  rdbtnFront = new JRadioButton("Front");
		  rdbtnFront.setEnabled(false);
		  rdbtnFront.setFont(new Font("Sitka Text", Font.BOLD, 18));
		  buttonGroupInsert.add(rdbtnFront);
		  rdbtnFront.setBackground(SystemColor.controlHighlight);
		  rdbtnFront.setBounds(113, 29, 87, 14);
		  DQInsertAtPNL.add(rdbtnFront);
		  
		  JLabel lblInsertAt = new JLabel("Insert At:");
		  lblInsertAt.setFont(new Font("Sitka Display", Font.BOLD, 22));
		  lblInsertAt.setBounds(58, 0, 103, 33);
		  DQInsertAtPNL.add(lblInsertAt);
		  
		  DeleteFromPanel = new Panel();
		  DeleteFromPanel.setBounds(0, 56, 206, 61);
		  panel_2.add(DeleteFromPanel);
		  DeleteFromPanel.setEnabled(false);
		  DeleteFromPanel.setBackground(SystemColor.controlHighlight);
		  DeleteFromPanel.setVisible(false);
		  DeleteFromPanel.setLayout(null);
		  
		  rdbtnDFront = new JRadioButton("Front");
		  rdbtnDFront.setForeground(SystemColor.desktop);
		  rdbtnDFront.setFont(new Font("Sitka Text", Font.BOLD, 18));
		  rdbtnDFront.setSelected(true);
		  buttonGroupDelete.add(rdbtnDFront);
		  rdbtnDFront.setBackground(SystemColor.controlHighlight);
		  rdbtnDFront.setBounds(0, 31, 82, 23);
		  DeleteFromPanel.add(rdbtnDFront);
		  
		  JRadioButton rdbtnDRear = new JRadioButton("Rear");
		  rdbtnDRear.setForeground(SystemColor.desktop);
		  rdbtnDRear.setFont(new Font("Sitka Text", Font.BOLD, 18));
		  buttonGroupDelete.add(rdbtnDRear);
		  rdbtnDRear.setBackground(SystemColor.controlHighlight);
		  rdbtnDRear.setBounds(117, 31, 89, 23);
		  DeleteFromPanel.add(rdbtnDRear);
		  
		  JLabel lblDeleteFrom = new JLabel("Delete From:");
		  lblDeleteFrom.setBackground(SystemColor.controlHighlight);
		  lblDeleteFrom.setForeground(SystemColor.desktop);
		  lblDeleteFrom.setHorizontalAlignment(SwingConstants.CENTER);
		  lblDeleteFrom.setFont(new Font("Sitka Display", Font.BOLD, 22));
		  lblDeleteFrom.setBounds(0, 0, 206, 33);
		  DeleteFromPanel.add(lblDeleteFrom);
		  
		
		 // lblQueueIsEmpty_1.setVisible(false);
		capacity= 5;
		  for(int i=0;i<capacity;i++){
				cmbPriority.addItem(i+"");
			}
		Panel controlPanel = new Panel();
		controlPanel.setBackground(Color.decode("#2F2F2F"));
		controlPanel.setBounds(1053, 0, 265, 721);
		frame.getContentPane().add(controlPanel);
		controlPanel.setLayout(null);
		
		TypeBox = new JComboBox();
		TypeBox.setFont(new Font("Sitka Text", Font.BOLD, 11));
		TypeBox.setForeground(Color.BLACK);
		TypeBox.setModel(new DefaultComboBoxModel (new String[] { "Simple Queue","Doubly Ended Queue (DEqueue)", "Priority Queue", "Circular Queue"} ));
		TypeBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
				String s =TypeBox.getSelectedItem().toString();
				if(s.compareTo("Doubly Ended Queue (DEqueue)")==0)
				{
					DeleteFromPanel.setVisible(true);
					DQInsertAtPNL.setVisible(true);
					queueType="DQ";
					lblError.setVisible(false);
				}
				else if(s.compareTo("Simple Queue")==0) {
					DeleteFromPanel.setVisible(false);
					DQInsertAtPNL.setVisible(false);
					queueType="SQ";
					lblError.setVisible(false);	
				}
				else if(s.compareTo("Circular Queue")==0) {
					DeleteFromPanel.setVisible(false);
					DQInsertAtPNL.setVisible(false);
					queueType="CQ";
					lblError.setVisible(false);	
					DQInsertAtPNL.setVisible(false);
					EnqueuePanel.setVisible(false);
					DeleteFromPanel.setVisible(false);
					
				}
				else if(s.compareTo("Priority Queue")==0) {
					DeleteFromPanel.setVisible(false);
					DQInsertAtPNL.setVisible(false);
					queueType="CQ";
					lblError.setVisible(false);	
					DQInsertAtPNL.setVisible(false);
					EnqueuePanel.setVisible(false);
					DeleteFromPanel.setVisible(false);
				}
				
			}
		});
		TypeBox.setBounds(12, 187, 241, 32);
		controlPanel.add(TypeBox);
		
		TypeBox.setBackground(Color.decode("#bdc3c7"));
		TypeBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		btnCrt = new JButton("Create");
		btnCrt.setFont(new Font("Sitka Heading", Font.BOLD, 15));
		btnCrt.setBackground(SystemColor.inactiveCaption);
		btnCrt.setBounds(12, 512, 103, 28);
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
		cmbCapacity.setBounds(12, 335, 241, 32);
		cmbCapacity.addItem("5");
		cmbCapacity.addItem("10");
		cmbCapacity.addItem("60");
		controlPanel.add(cmbCapacity);
		cmbCapacity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						String s= cmbCapacity.getSelectedItem().toString();
						capacity=Integer.parseInt(s);
						cmbPriority.removeAllItems();
						for(int i=0;i<capacity;i++){
							cmbPriority.addItem(i+"");
						}
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
		btnDst.setBounds(150, 512, 103, 28);
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
			  			
			  		}

				}
				else if(queueType.compareTo("DQ")==0) {
					if(rear==(capacity-1) && front==0) {
						
			  			lblError.setVisible(true);
			  			lblError.setText("Queue is Full!");
			  			
			  		}
					
					else {
						EnqueuePanel.setVisible(true);
						DQInsertAtPNL.setEnabled(true);
						rdbtnRear.setEnabled(true);
						rdbtnFront.setEnabled(true);
			  			txtFieldEnQ.setText(null);
			  			

			  		}
				}
				else if(queueType.compareTo("CQ")==0) {
					if((rear+1)% capacity==front) {
					
			  			lblError.setVisible(true);
			  			lblError.setText("Queue is Full!");
			  		}
					else {
						EnqueuePanel.setVisible(true);
						txtFieldEnQ.setText(null);
			  			
			  		}

				}
				
			}
		 });
		btnEnQ.setBackground(SystemColor.activeCaption);
		btnEnQ.setBounds(12, 627, 103, 28);
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
				else if(queueType.compareTo("CQ")==0) {
					deleteAtCircularQueue();
				}
			}
		});
		btnDeQ.setEnabled(false);
		btnDeQ.setBackground(SystemColor.activeCaption);
		btnDeQ.setBounds(152, 627, 103, 28);
		controlPanel.add(btnDeQ);
		btnDeQ.setBorder(new BevelBorder(BevelBorder.RAISED, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder, SystemColor.windowBorder));
		
		JLabel TKitHeadings = new JLabel("Toolkit");
		TKitHeadings.setForeground(Color.decode("#e67e22"));
		TKitHeadings.setFont(new Font("Sitka Banner", Font.BOLD, 56));
		TKitHeadings.setHorizontalAlignment(SwingConstants.CENTER);
		TKitHeadings.setBounds(12, 11, 241, 116);
		controlPanel.add(TKitHeadings);
		
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
		lblSelectMaxCapacity.setBounds(12, 267, 243, 41);
		controlPanel.add(lblSelectMaxCapacity);
		
		lblOperations = new JLabel("OPERATION'S:");
		lblOperations.setForeground(SystemColor.info);
		lblOperations.setFont(new Font("Sitka Heading", Font.BOLD, 34));
		lblOperations.setBounds(12, 418, 241, 65);
		controlPanel.add(lblOperations);
	}
	void displayQueue(int n, JTextField[] e) {
		
		elements=new JPanel[capacity];
		
		Component horizontalStrut = Box.createHorizontalStrut(150);
		panelQueue.add(horizontalStrut);
		
		panelDetls = new JPanel();
		panelDetls.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panelQueue.add(panelDetls);
		panelDetls.setLayout(new BoxLayout(panelDetls, BoxLayout.Y_AXIS));
		
		
		lblIndex1 = new JLabel("Index:");
		lblIndex1.setMaximumSize(new Dimension(80, 15));
		lblIndex1.setMinimumSize(new Dimension(80, 15));
		lblIndex1.setHorizontalAlignment(SwingConstants.CENTER);
		panelDetls.add(lblIndex1);
		
		lblElement1 =new JLabel("Element:");
		lblElement1.setBorder(new MatteBorder(3, 0, 3, 0, (Color) Color.RED));
		lblElement1.setMaximumSize(new Dimension(80, 60));
		lblElement1.setMinimumSize(new Dimension(80, 60));
		lblElement1.setForeground(SystemColor.red);
		lblElement1.setHorizontalAlignment(SwingConstants.CENTER);
		panelDetls.add(lblElement1);
		
		lblPointer1 = new JLabel("Pointer:");
		lblPointer1.setMaximumSize(new Dimension(80, 15));
		lblPointer1.setMinimumSize(new Dimension(80, 15));
		lblPointer1.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointer1.setForeground(SystemColor.BLUE);
		panelDetls.add(lblPointer1);
		
		for(int i=0;i<capacity;i++) {
		panelElement = new JPanel();
		panelElement.setBorder(new LineBorder(new Color(0, 0, 0), 1));
		panelQueue.add(panelElement);
		panelElement.setLayout(new BoxLayout(panelElement, BoxLayout.Y_AXIS));
		
		
		
		lblIndex = new JLabel(""+i);
		lblIndex.setMaximumSize(new Dimension(80, 15));
		lblIndex.setMinimumSize(new Dimension(80, 15));
		lblIndex.setHorizontalAlignment(SwingConstants.CENTER);
		panelElement.add(lblIndex);
		
		lblElement =new JLabel();
		if(i<n)
		{
		lblElement = new JLabel(""+e[i].getText());
		}
		else
			lblElement = new JLabel("null");
		
		lblElement.setBorder(new MatteBorder(3, 0, 3, 0, (Color) Color.RED));
		lblElement.setMaximumSize(new Dimension(80, 60));
		lblElement.setMinimumSize(new Dimension(70, 60));
		lblElement.setForeground(SystemColor.red);
		lblElement.setHorizontalAlignment(SwingConstants.CENTER);
		panelElement.add(lblElement);
		
		lblPointer = new JLabel("");
		if(i==0)
			lblPointer.setText("Front");
		
		else if(i==(n-1))
		lblPointer.setText("Rear");
		lblPointer.setMaximumSize(new Dimension(70, 15));
		lblPointer.setMinimumSize(new Dimension(70, 15));
		lblPointer.setHorizontalAlignment(SwingConstants.CENTER);
		lblPointer.setForeground(SystemColor.BLUE);
		panelElement.add(lblPointer);
		elements[i]=panelElement;
	
		textFieldCapacity.setText(""+capacity);
		textFieldSize.setText(""+n);
		textFieldFront.setText(""+0);
		front=0;
		rear=n-1;
		textFieldRear.setText(""+(n-1));
		panelQueue.revalidate();
		
		
		}
		Component horizontalStrut1 = Box.createHorizontalStrut(150);
		panelQueue.add(horizontalStrut1);
	
		
		
		
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
	void insertInCircularQueue() {
		
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
  		else if((rear+1)%capacity!=front) {
  			EnqueuePanel.setVisible(false);
  			JLabel lbl =(JLabel)elements[(rear+1)%capacity].getComponent(1);
  			lbl.setText(txtFieldEnQ.getText());
  			lbl =(JLabel)elements[(rear+1)%capacity].getComponent(2);
  			lbl.setText("Rear");
  			lbl =(JLabel)elements[rear].getComponent(2);
  			// if queue contains only one element
  			if(front == rear)
  			{
  				lbl.setText("Front");
  				
  			}
  			else
  			
  				lbl.setText(" ");
  			rear=(rear+1)%capacity;
  			textFieldRear.setText(""+rear);
  			
  		}
		
		
		
		
	}
	void insertAtFront() {
		if(txtFieldEnQ.getText().trim().isEmpty())
		{
			lblFempty.setText("Field Is Empty");
		}
		// if the queue is empty
  		else if(front==-1 && rear==-1){
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
		lblError.setVisible(false);

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
	void deleteAtCircularQueue() {
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
  				lbl=(JLabel)elements[(front+1)%capacity].getComponent(2);
  				lbl.setText("Front");
  				front=(front+1)%capacity;
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
	}
	
		
		
		
		
		
		
		
		
	

