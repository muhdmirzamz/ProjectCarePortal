package GSECarePortal.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class MasterPanel extends JPanel {
	
	protected JFrame frame = null;
	
	public MasterPanel(JFrame f) {
		frame = f;
		
		setLayout(null);
		setBackground(new Color(238, 238, 238));
		setBorder(new EmptyBorder(5, 5, 5, 5));
	}
}