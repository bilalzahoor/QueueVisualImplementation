import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.MatteBorder;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;

public class frame0 {

	private JFrame frame;
	private JTextField textField;
	private JTextField txtCreate;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame0 window = new frame0();
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
	public frame0() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		frame.setBounds(100, 100, 1336, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(1033, 13, 273, 22);
		comboBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		comboBox.setForeground(Color.RED);
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Circular Queue", "Priorty Queue", "Doubly Ended Queue", "Dequeue"}));
		frame.getContentPane().add(comboBox);
		
		JButton btnEnqueue = new JButton("Enqueue");
		btnEnqueue.setBounds(1033, 603, 97, 25);
		btnEnqueue.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		frame.getContentPane().add(btnEnqueue);
		
		JButton btnDequeue = new JButton("Dequeue");
		btnDequeue.setBounds(1209, 603, 97, 25);
		btnDequeue.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		frame.getContentPane().add(btnDequeue);
		
		textField = new JTextField();
		textField.setBounds(1033, 568, 273, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblEnterTheElements = new JLabel("Enter the element(s)");
		lblEnterTheElements.setBounds(1033, 539, 273, 16);
		lblEnterTheElements.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(lblEnterTheElements);
		
		txtCreate = new JTextField();
		txtCreate.setBounds(999, 428, 116, -49);
		txtCreate.setText("create");
		frame.getContentPane().add(txtCreate);
		txtCreate.setColumns(10);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		btnNewButton.setBounds(1033, 112, 273, 81);
		btnNewButton.setBorder(new MatteBorder(5, 5, 3, 3, (Color) Color.ORANGE));
		frame.getContentPane().add(btnNewButton);
		
		table = new JTable();
		table.setBounds(118, 132, 690, -49);
		frame.getContentPane().add(table);
		
		table_1 = new JTable();
		table_1.setColumnSelectionAllowed(true);
		table_1.setCellSelectionEnabled(true);
		table_1.setBounds(240, 242, 699, -49);
		frame.getContentPane().add(table_1);
	}
}
