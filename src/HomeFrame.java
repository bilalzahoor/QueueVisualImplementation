import java.awt.EventQueue;

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
import javax.swing.Box;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeFrame {

	private JFrame frame;
	JButton btnDst;
	public int capacity;
	JComboBox cmbCapacity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame window = new HomeFrame();
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
		frame.setBounds(100, 100, 1336, 768);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Panel visualPanel = new Panel();
		visualPanel.setBounds(10, 58, 1023, 653);
		frame.getContentPane().add(visualPanel);
		
		JLabel lblEmpty = new JLabel("QUEUE IS EMPTY");
		lblEmpty.setFont(new Font("Tahoma", Font.PLAIN, 70));
		visualPanel.add(lblEmpty);
		
		Panel controlPanel = new Panel();
		controlPanel.setBounds(1053, 10, 182, 286);
		frame.getContentPane().add(controlPanel);
		controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
		
		JComboBox comboBox = new JComboBox();
		controlPanel.add(comboBox);
		comboBox.setForeground(Color.RED);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Priority Queue", "Circular Queue", "Doubly Ended Queue (DEqueue)"}));
		comboBox.setBackground(Color.LIGHT_GRAY);
		comboBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		Component verticalStrut = Box.createVerticalStrut(40);
		controlPanel.add(verticalStrut);
		
		JButton btnCrt = new JButton("Create");
		btnCrt.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				CreateQ win = new CreateQ();
				win.frame.setVisible(true);
				
				btnDst.setEnabled(true);
			}
		});
		
		cmbCapacity = new JComboBox();
		cmbCapacity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
						String s= cmbCapacity.getSelectedItem().toString();
						capacity=Integer.parseInt(s);
			}
		});
		cmbCapacity.addItem("5");
		cmbCapacity.addItem("10");
		controlPanel.add(cmbCapacity);
		controlPanel.add(btnCrt);
		
		Component verticalStrut_1 = Box.createVerticalStrut(40);
		controlPanel.add(verticalStrut_1);
		
		btnDst = new JButton("Destroy");
		controlPanel.add(btnDst);
		btnDst.setEnabled(false);
		btnDst.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		Component verticalStrut_2 = Box.createVerticalStrut(40);
		controlPanel.add(verticalStrut_2);
		
		JButton btnNewButton_1 = new JButton("Enqueue");
		controlPanel.add(btnNewButton_1);
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		Component verticalStrut_3 = Box.createVerticalStrut(40);
		controlPanel.add(verticalStrut_3);
		
		JButton btnNewButton_2 = new JButton("Dequeue");
		controlPanel.add(btnNewButton_2);
		btnNewButton_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	}
}
