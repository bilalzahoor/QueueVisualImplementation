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
import javax.swing.Box;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import java.awt.ComponentOrientation;

public class HomeFrame {

	private JFrame frame;
	JButton btnDst;
	public int capacity;
	JComboBox cmbCapacity;
	JLabel lblEmpty;
	static HomeFrame homeWin;

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
		visualPanel.setBackground(Color.decode("#2c3e50"));
		visualPanel.setBounds(10, 58, 1023, 653);
		frame.getContentPane().add(visualPanel);
		
		lblEmpty = new JLabel("QUEUE IS EMPTY");
		lblEmpty.setForeground(Color.ORANGE);
		lblEmpty.setFont(new Font("Tahoma", Font.PLAIN, 70));
		visualPanel.add(lblEmpty);
		capacity= 5;
		
		Panel controlPanel = new Panel();
		controlPanel.setBounds(1053, 58, 255, 653);
		frame.getContentPane().add(controlPanel);
		controlPanel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(0, 0, 255, 32);
		controlPanel.add(comboBox);
		comboBox.setForeground(Color.BLACK);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Priority Queue", "Circular Queue", "Doubly Ended Queue (DEqueue)"}));
		comboBox.setBackground(Color.ORANGE);
		comboBox.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		
		JButton btnCrt = new JButton("Create");
		btnCrt.setBounds(0, 472, 49, 23);
		btnCrt.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		btnCrt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CreateQueueFrame win = new CreateQueueFrame(homeWin);
				win.frame.setVisible(true);
				btnDst.setEnabled(true);
			}
		});
		
		cmbCapacity = new JComboBox();
		cmbCapacity.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		cmbCapacity.setBackground(Color.ORANGE);
		cmbCapacity.setComponentOrientation(ComponentOrientation.UNKNOWN);
		cmbCapacity.setBounds(12, 50, 231, 32);
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
		
		btnDst = new JButton("Destroy");
		btnDst.setBounds(0, 508, 49, 23);
		controlPanel.add(btnDst);
		btnDst.setEnabled(false);
		btnDst.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnNewButton_1 = new JButton("Enqueue");
		btnNewButton_1.setBounds(186, 472, 57, 23);
		controlPanel.add(btnNewButton_1);
		btnNewButton_1.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		
		JButton btnNewButton_2 = new JButton("Dequeue");
		btnNewButton_2.setBounds(186, 508, 57, 23);
		controlPanel.add(btnNewButton_2);
		btnNewButton_2.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
	}
}
