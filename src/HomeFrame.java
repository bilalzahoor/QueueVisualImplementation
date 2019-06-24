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
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Priority Queue", "Circular Queue", "Doubly Ended Queue (DEqueue)"}));
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
		
		btnDst = new JButton("Destroy");
		btnDst.setBackground(Color.decode("#FAF0F6"));
		btnDst.setBounds(150, 496, 103, 28);
		controlPanel.add(btnDst);
		btnDst.setEnabled(false);
		btnDst.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		JButton btnNewButton_1 = new JButton("Enqueue");
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
}
