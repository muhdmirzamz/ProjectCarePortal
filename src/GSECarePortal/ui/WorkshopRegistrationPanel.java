package GSECarePortal.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import GSECarePortal.controller.WorkshopController;
import GSECarePortal.entity.Workshop;
import GSECarePortal.entity.WorkshopRegistration;

public class WorkshopRegistrationPanel extends MasterPanel {
    protected JFrame myFrame = null; 
    private JTextField textField;
    private JTextField textField_1;
	
	
	/**
	 * Create the panel.
	 */
	public WorkshopRegistrationPanel(JFrame mf) {
		super(mf);
		
		JLabel lblSignupWorkshop = new JLabel("Sign-Up Workshop");
		lblSignupWorkshop.setFont(new Font("Tahoma", Font.BOLD, 15));
		add(lblSignupWorkshop);
		
		JLabel lblWorkshopRegistration = new JLabel("Workshop Registration");
		lblWorkshopRegistration.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblWorkshopRegistration.setBounds(143, 27, 180, 14);
		add(lblWorkshopRegistration);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblName.setBounds(39, 85, 89, 14);
		add(lblName);
		
		textField = new JTextField();
		textField.setBounds(163, 84, 180, 20);
		add(textField);
		textField.setColumns(10);
		
		JLabel lblNric = new JLabel("NRIC:");
		lblNric.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNric.setBounds(39, 130, 46, 14);
		add(lblNric);
		
		textField_1 = new JTextField();
		textField_1.setBounds(163, 129, 89, 20);
		add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		//  database retrieve is done here
		WorkshopController wc = new WorkshopController();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Art & Craft", "Pottery Crafting", "Baking", "Sewing"}));
		comboBox.setBounds(101, 205, 253, 20);
		add(comboBox);
		
		JLabel lblChooseYourDesired = new JLabel("Choose your desired workshop:");
		lblChooseYourDesired.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblChooseYourDesired.setBounds(116, 180, 253, 14);
		add(lblChooseYourDesired);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(314, 261, 89, 23);
		btnSubmit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
	          
				
			}
			
		});
		add(btnSubmit);

	}

}
