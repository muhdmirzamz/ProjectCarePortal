package GSECarePortal.ui;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JScrollBar;

import GSECarePortal.controller.DBController;
import GSECarePortal.controller.WorkshopController;
import GSECarePortal.entity.Workshop;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;

public class SignUpWorkshopPanel extends MasterPanel {
	protected JFrame myFrame = null;
	private JTextField textFieldFname;
	private JTextField textFieldNric;
	private JTextField textFieldEmailAdd;
	private JTextField textFieldMNo;
	private JTextField textFieldHNo;
	private JTable table;

	
	
	/**
	 * Create the panel.
	 */
	public SignUpWorkshopPanel(JFrame mf) {
		super(mf);
		myFrame = mf;
		setLayout(null);
		
		JLabel label = new JLabel("");
		label.setBounds(213, 5, 0, 0);
		add(label);
		
		JLabel lblWorkshopRegistration = new JLabel("Workshop Registration");
		lblWorkshopRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWorkshopRegistration.setBounds(129, 0, 198, 52);
		add(lblWorkshopRegistration);
		
		JLabel lblFullName = new JLabel("Full Name:");
		lblFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFullName.setBounds(31, 34, 63, 25);
		add(lblFullName);
		
		textFieldFname = new JTextField();
		textFieldFname.setBounds(104, 38, 275, 20);
		add(textFieldFname);
		textFieldFname.setColumns(10);
		
		JLabel lblNric = new JLabel("NRIC:");
		lblNric.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNric.setBounds(31, 56, 63, 25);
		add(lblNric);
		
		JLabel lblEmailAddress = new JLabel("Email Address:");
		lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailAddress.setBounds(31, 92, 112, 25);
		add(lblEmailAddress);
		
		JLabel lblTelephoneNo = new JLabel("Mobile No:");
		lblTelephoneNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTelephoneNo.setBounds(31, 128, 112, 25);
		add(lblTelephoneNo);
		
		JLabel lblHomeNo = new JLabel("Home No:");
		lblHomeNo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblHomeNo.setBounds(31, 164, 112, 25);
		add(lblHomeNo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(31, 92, 348, 8);
		add(separator);
		
		textFieldNric = new JTextField();
		textFieldNric.setBounds(104, 63, 114, 20);
		add(textFieldNric);
		textFieldNric.setColumns(10);
		
		textFieldEmailAdd = new JTextField();
		textFieldEmailAdd.setColumns(10);
		textFieldEmailAdd.setBounds(129, 96, 153, 20);
		add(textFieldEmailAdd);
		
		textFieldMNo = new JTextField();
		textFieldMNo.setColumns(10);
		textFieldMNo.setBounds(129, 128, 153, 20);
		add(textFieldMNo);
		
		textFieldHNo = new JTextField();
		textFieldHNo.setColumns(10);
		textFieldHNo.setBounds(129, 164, 153, 20);
		add(textFieldHNo);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WorkshopController wc = new WorkshopController();
	      		boolean create = false;
	      		
	      		create = wc.createWorkshopRegistrationRecord(textFieldNric.getText(), textFieldFname.getText(), textFieldEmailAdd.getText(), textFieldMNo.getText(), textFieldHNo.getText());
	      		if (create == true) {
	      			JOptionPane.showMessageDialog(null, "Create Successful","Message", 1);
	      		}
	      			else{
	      				JOptionPane.showMessageDialog(null, "Create Failed","Error", 0);
	      		}
	      		
	      	
			}
		});
		btnSubmit.setBounds(298, 246, 89, 23);
		add(btnSubmit);
		
        ArrayList <Workshop> wsList = WorkshopController.getWorkshopDetails();
		ArrayList <String> wsList2 = new ArrayList<String>();
		
		for(int i= 0; i<wsList.size(); i++){
			String s = wsList.get(i).getWsTitle(); 
			wsList2.add(s);	
		}
	
		JComboBox comboBox = new JComboBox(wsList2.toArray());
		comboBox.setBounds(61, 216, 220, 20);
		add(comboBox);
		
		
		JLabel lblChooseYourWorkshop = new JLabel("Choose your workshop:");
		lblChooseYourWorkshop.setBounds(48, 200, 153, 14);
		add(lblChooseYourWorkshop);

	}
}
