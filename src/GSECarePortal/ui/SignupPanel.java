package GSECarePortal.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import GSECarePortal.controller.CustomerProfileController;
import GSECarePortal.controller.ElderlyProfileController;
import GSECarePortal.entity.Elderly;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

public class SignupPanel extends MasterPanel {
	
	private Font signupFont;
	private JRadioButton customerRdBtn;
	private JRadioButton elderlyRdBtn;
	private JLabel usernameLbl;
	private JTextField usernameTxtField;
	private JPasswordField passwordTxtField;
	private JPasswordField verifyPasswordTxtField;
	private JTextField firstNameTxtField;
	private JTextField lastNameTxtField;
	private JTextField addressTxtField;
	
	private JLabel expiryDateLbl;
	
	private JLabel phoneNumLbl;
	private JRadioButton maleBtn;
	private JRadioButton femaleBtn;
	private JTextField phoneNumTxtField;
	
	public SignupPanel(JFrame f) {
		super(f);
		    
		JLabel signupLabel = new JLabel("Sign up");
		try {
			signupFont = Font.createFont(Font.TRUETYPE_FONT, new FileInputStream(new File("res/Lato-Hairline.ttf"))).deriveFont(Font.TRUETYPE_FONT,  20);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(f, "Font resource not found");
			
			e.printStackTrace();
		}
		signupLabel.setFont(signupFont);
		signupLabel.setBounds(26, 6, 242, 50);
		add(signupLabel);
	
		customerRdBtn = new JRadioButton("Customer");
		customerRdBtn.setBounds(26, 56, 141, 23);
		customerRdBtn.setSelected(true);
		customerRdBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (elderlyRdBtn.isSelected()) {
					customerRdBtn.setSelected(true);
					elderlyRdBtn.setSelected(false);
					
					usernameLbl.setText("Username");
					
					maleBtn.setVisible(false);
					femaleBtn.setVisible(false);
					phoneNumLbl.setVisible(false);
					phoneNumTxtField.setVisible(false);
				} else {
					customerRdBtn.setSelected(true);
				}
			}
			
		});
		add(customerRdBtn);
		
		elderlyRdBtn = new JRadioButton("Elderly");
		elderlyRdBtn.setBounds(26, 94, 141, 23);
		elderlyRdBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (customerRdBtn.isSelected()) {				
					elderlyRdBtn.setSelected(true);
					customerRdBtn.setSelected(false);
					
					usernameLbl.setText("NRIC");
					
					maleBtn.setVisible(true);
					femaleBtn.setVisible(true);
					phoneNumLbl.setVisible(true);
					phoneNumTxtField.setVisible(true);
				} else {
					elderlyRdBtn.setSelected(true);
				}
			}
		});
		add(elderlyRdBtn);
		
		usernameLbl = new JLabel("Username");
		usernameLbl.setBounds(307, 126, 79, 16);
		add(usernameLbl);
		
		JLabel passwordLbl = new JLabel("Password");
		passwordLbl.setBounds(307, 154, 79, 16);
		add(passwordLbl);
		
		JLabel verifyPasswordLbl = new JLabel("Verify password");
		verifyPasswordLbl.setBounds(307, 195, 107, 16);
		add(verifyPasswordLbl);
		
		usernameTxtField = new JTextField();
		usernameTxtField.setBounds(423, 120, 166, 28);
		add(usernameTxtField);
		usernameTxtField.setColumns(10);
		
		passwordTxtField = new JPasswordField();
		passwordTxtField.setBounds(423, 148, 166, 28);
		add(passwordTxtField);
		
		verifyPasswordTxtField = new JPasswordField();
		verifyPasswordTxtField.setBounds(423, 189, 166, 28);
		add(verifyPasswordTxtField);
		
		JLabel firstNameLbl = new JLabel("First Name");
		firstNameLbl.setBounds(26, 132, 79, 16);
		add(firstNameLbl);
		
		JLabel lastNameLbl = new JLabel("Last Name");
		lastNameLbl.setBounds(26, 160, 79, 16);
		add(lastNameLbl);
		
		JLabel addressLbl = new JLabel("Address");
		addressLbl.setBounds(26, 200, 79, 16);
		add(addressLbl);
		
		firstNameTxtField = new JTextField();
		firstNameTxtField.setColumns(10);
		firstNameTxtField.setBounds(117, 126, 166, 28);
		add(firstNameTxtField);
		
		lastNameTxtField = new JTextField();
		lastNameTxtField.setColumns(10);
		lastNameTxtField.setBounds(117, 154, 166, 28);
		add(lastNameTxtField);
		
		addressTxtField = new JTextField();
		addressTxtField.setColumns(10);
		addressTxtField.setBounds(117, 194, 166, 28);
		add(addressTxtField);
		
		phoneNumLbl = new JLabel("<html>Phone<br/>number</html>");
		phoneNumLbl.setBounds(26, 256, 180, 30);
		phoneNumLbl.setVisible(false);
		add(phoneNumLbl);
		
		phoneNumTxtField = new JTextField();
		phoneNumTxtField.setBounds(117, 260, 166, 28);
		phoneNumTxtField.setVisible(false);
		add(phoneNumTxtField);
		phoneNumTxtField.setColumns(10);
		
		maleBtn = new JRadioButton("Male");
		maleBtn.setBounds(26, 320, 80, 28);
		maleBtn.setVisible(false);
		maleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (femaleBtn.isSelected()) {
					maleBtn.setSelected(true);
					femaleBtn.setSelected(false);
				} else {
					maleBtn.setSelected(true);
				}
			}
			
		});
		add(maleBtn);
		
		femaleBtn = new JRadioButton("Female");
		femaleBtn.setBounds(117, 320, 166, 28);
		femaleBtn.setVisible(false);
		femaleBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (maleBtn.isSelected()) {
					femaleBtn.setSelected(true);
					maleBtn.setSelected(false);
				} else {
					femaleBtn.setSelected(true);
				}
			}
			
		});
		add(femaleBtn);
		
		JButton backBtn = new JButton("Back");
		backBtn.setBounds(423, 334, 79, 29);
		backBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel p = new SigninPanel(frame);
				frame.setContentPane(p);
				frame.setVisible(true);
			}
			
		});
		add(backBtn);
		
		JButton doneBtn = new JButton("Done");
		doneBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if (customerRdBtn.isSelected()) {
					String password = new String(passwordTxtField.getPassword());
					String verifyPassword = new String(verifyPasswordTxtField.getPassword());
					
						if (password.equalsIgnoreCase(verifyPassword)) {
							String username = usernameTxtField.getText();
							String firstName = firstNameTxtField.getText();
							String lastName = lastNameTxtField.getText();
							String address = addressTxtField.getText();
							// date here
							
							// validate 
							// pass on data to customer profile controller
							if (CustomerProfileController.createCustomer(firstName, lastName, username, password,
							        address, "", "active")) {
								JOptionPane.showMessageDialog(frame, "Sign up successful!");
								
								JPanel p = new SigninPanel(frame);
								frame.setContentPane(p);
								frame.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(frame, "Sign up failed!");
							}
						} else {
							JOptionPane.showMessageDialog(frame, "Password verification failed"); 
						}	
				} else if (elderlyRdBtn.isSelected()) {
					String firstName = firstNameTxtField.getText();
					String lastName = lastNameTxtField.getText();
					String address = addressTxtField.getText();
					
					String username = usernameTxtField.getText();
					String password = new String(passwordTxtField.getPassword());
					
					String phoneNumString = phoneNumTxtField.getText();
					Integer phoneNum = new Integer(phoneNumString);
					
					String gender = new String();
					
					if (maleBtn.isSelected()) {
						gender = maleBtn.getText();
					} else {
						gender = femaleBtn.getText();
					}
				
					
					// validate 
					// pass on data to customer profile controller
					ElderlyProfileController.createElderly(password, "active", firstName, lastName,
					        username, phoneNum, gender, address);
				}
			}
		});
		doneBtn.setBounds(510, 334, 79, 29);
		add(doneBtn);
	}
}
