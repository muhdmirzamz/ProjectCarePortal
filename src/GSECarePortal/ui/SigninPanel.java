package GSECarePortal.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import GSECarePortal.controller.CustomerProfileController;
import GSECarePortal.entity.Customer;
import GSECarePortal.entity.Elderly;

import java.awt.Color;

import javax.swing.JSeparator;

public class SigninPanel extends MasterPanel {

	private JRadioButton customerRdBtn;
	private JRadioButton elderlyRdBtn;
	private JRadioButton staffRdBtn;
	private JLabel usernameLabel;
	private JTextField usernameTxtField;
	private JPasswordField passwordTxtField;
	private JButton signupBtn;
	private JButton signinBtn;
	private Font titleFont;
	
	public SigninPanel(JFrame f) {
		super(f);
		
		JLabel title = new JLabel("GSE Care Portal");	
		try {
			titleFont = Font.createFont(Font.TRUETYPE_FONT,new FileInputStream(new File("res/Lato-Hairline.ttf"))).deriveFont(Font.TRUETYPE_FONT, 40);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(f, "Font resource not found");
			
			e.printStackTrace();
		}
		title.setFont(titleFont);
		title.setBounds(174, 29, 341, 47);
		add(title);
		
		JLabel userTypeLbl = new JLabel("Choose");
		userTypeLbl.setBounds(142, 112, 61, 28);
		add(userTypeLbl);
		
		customerRdBtn= new JRadioButton("Customer");
		customerRdBtn.setBounds(269, 114, 93, 23);
		customerRdBtn.setSelected(true);
		customerRdBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (elderlyRdBtn.isSelected() || staffRdBtn.isSelected()) {
					customerRdBtn.setSelected(true);
					elderlyRdBtn.setSelected(false);
					staffRdBtn.setSelected(false);
					
					usernameLabel.setText("Username");
				} else {
					customerRdBtn.setSelected(true);
				}
			}
			
		});
		add(customerRdBtn);
		
		elderlyRdBtn = new JRadioButton("Elderly");
		elderlyRdBtn.setBounds(360, 114, 75, 23);
		elderlyRdBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (customerRdBtn.isSelected() || staffRdBtn.isSelected()) {
					elderlyRdBtn.setSelected(true);
					customerRdBtn.setSelected(false);
					staffRdBtn.setSelected(false);
					
					usernameLabel.setText("NRIC");
				} else {
					elderlyRdBtn.setSelected(true);
				}
			}
			
		});
		add(elderlyRdBtn);
		
		staffRdBtn = new JRadioButton("Staff");
		staffRdBtn.setBounds(430, 114, 75, 23);
		staffRdBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (customerRdBtn.isSelected() || elderlyRdBtn.isSelected()) {
					staffRdBtn.setSelected(true);
					elderlyRdBtn.setSelected(false);
					customerRdBtn.setSelected(false);
					
					usernameLabel.setText("ID");
				} else {
					staffRdBtn.setSelected(true);
				}
			}
			
		});
		add(staffRdBtn);
		
		usernameLabel = new JLabel("Username");
		usernameLabel.setBounds(142, 167, 62, 16);
		add(usernameLabel);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(142, 223, 62, 16);
		add(passwordLabel);
		
		usernameTxtField = new JTextField();
		usernameTxtField.setBounds(269, 161, 224, 28);
		usernameTxtField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					signIn();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(usernameTxtField);
		usernameTxtField.setColumns(10);
		
		passwordTxtField = new JPasswordField();
		passwordTxtField.setBounds(269, 217, 224, 28);
		passwordTxtField.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyPressed(KeyEvent e) {
				
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					signIn();
				}
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(passwordTxtField);
		
		signinBtn = new JButton("Sign In");
		signinBtn.setBounds(418, 277, 75, 29);
		signinBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				signIn();
			}
			
		});
		add(signinBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(142, 318, 351, 12);
		add(separator);
		
		JLabel noAccLbl = new JLabel("Don't have an account?");
		noAccLbl.setBounds(142, 380, 145, 16);
		add(noAccLbl);
		
		signupBtn = new JButton("Sign Up");
		signupBtn.setBounds(418, 375, 75, 29);
		signupBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel p = new SignupPanel(frame);
				frame.setContentPane(p);
				frame.setVisible(true);
			}
			
		});
		add(signupBtn);
	}
	
	private void signIn() {
		if (!usernameTxtField.getText().isEmpty() && !passwordTxtField.getPassword().toString().isEmpty()) {
			if (customerRdBtn.isSelected()) {
				String username = usernameTxtField.getText();
				String password = new String(passwordTxtField.getPassword());
				
				CustomerProfileController cpc = new CustomerProfileController();
				Customer c = cpc.retrieveCustomerDetails(username); // validation occurs here
				
				if (c != null) {
					JPanel p = new MainPanel(frame, 1, username, ""); // not using password
					frame.setContentPane(p);
					frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Account not registered");
					
					usernameTxtField.setText("");
					passwordTxtField.setText("");
				}
			} else if (elderlyRdBtn.isSelected()) {
				Elderly e = new Elderly();
				String username = usernameTxtField.getText();
				String password = new String(passwordTxtField.getPassword());
				if (e.getElderlyDetails(username, password)!= null) {
					JPanel p = new MainPanel(frame, 2, username, password);
					frame.setContentPane(p);
					frame.setVisible(true);
				} else {
					JOptionPane.showMessageDialog(frame, "Account not registered");
					
					usernameTxtField.setText("");
					passwordTxtField.setText("");
				}
			}
		} else {
			JOptionPane.showMessageDialog(frame, "Fields not filled");
		}
	}
}
