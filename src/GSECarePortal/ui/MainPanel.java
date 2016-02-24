package GSECarePortal.ui;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSplitPane;
import javax.swing.JTextField;

import GSECarePortal.controller.CustomerProfileController;
import GSECarePortal.controller.ElderlyProfileController;
import GSECarePortal.entity.Customer;
import GSECarePortal.entity.Elderly;
import GSECarePortal.entity.Staff;
import GSECarePortal.ui.SigninPanel;

public class MainPanel extends MasterPanel {
	
	private Font titleFont;
	
	private GridBagConstraints gbc;
	
	private JSplitPane splitPane;
	
	private JPanel customerPanel;
	private JLabel rightPanelTitle;
	private JTextField firstNameTxtField;
	private JTextField lastNameTxtField;
	private JTextField usernameTxtField;
	private JPasswordField passwordTxtField;
	private JTextField addressTxtField;
	private JButton deleteBtn;
	private JButton updateBtn;
	
	private JPanel elderlyPanel;
	private JPanel staffPanel;
	
	private JPanel leftPanel;
	
	private int appUserType;
	
	private CustomerProfileController cpc;
	private Customer c;
	private ElderlyProfileController epc;
	private Elderly el;
	private Staff s;
	private String elderlyID;
	private String accPassword;
	
	public MainPanel(JFrame f, int userType, String username, String password) {
		super(f);
		
		appUserType = userType;
		
		// elderly stuff
		elderlyID = username;
		accPassword = password;
		
		splitPane = new JSplitPane();
		splitPane.setBounds(0, 0, MainFrame.APP_WINDOW_W, MainFrame.APP_WINDOW_H);
		add(splitPane);
		
		final int TITLE_X_POS = (splitPane.getWidth() - 120 - 200) / 2;
		final int TXTFIELD_WIDTH = 200;
		
		gbc = new GridBagConstraints();
		
		if (appUserType == 1) { // customer---------------------------------------------------------
			customerPanel = new JPanel();
			customerPanel.setLayout(null);
			rightPanelTitle = new JLabel("View Profile");
			try {
				titleFont = Font.createFont(Font.TRUETYPE_FONT,new FileInputStream(new File("res/Lato-Hairline.ttf"))).deriveFont(Font.TRUETYPE_FONT, 40);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(f, "Font resource not found");
				
				e.printStackTrace();
			}
			rightPanelTitle.setFont(titleFont);
			rightPanelTitle.setBounds(TITLE_X_POS, 10, 250, 50); // keep it centralised
			customerPanel.add(rightPanelTitle);
			
			// retrieve customer details
			cpc = new CustomerProfileController();
			c = cpc.retrieveCustomerDetails(username);
			
			JLabel firstNameLbl = new JLabel("First name");
			firstNameLbl.setBounds(TITLE_X_POS - 100, 80, 100, 20);
			customerPanel.add(firstNameLbl);
			firstNameTxtField = new JTextField(c.getFirstName());
			firstNameTxtField.setBounds(TITLE_X_POS, 80, TXTFIELD_WIDTH, 20);
			firstNameTxtField.setEnabled(false);
			customerPanel.add(firstNameTxtField);
			
			JLabel lastNameLbl = new JLabel("Last name");
			lastNameLbl.setBounds(TITLE_X_POS - 100, 120, 100, 20);
			customerPanel.add(lastNameLbl);
			lastNameTxtField = new JTextField(c.getLastName());
			lastNameTxtField.setBounds(TITLE_X_POS, 120, TXTFIELD_WIDTH, 20);
			lastNameTxtField.setEnabled(false);
			customerPanel.add(lastNameTxtField);
			
			JLabel usernameLbl = new JLabel("Username");
			usernameLbl.setBounds(TITLE_X_POS - 100, 180, 100, 20);
			customerPanel.add(usernameLbl);
			usernameTxtField = new JTextField(c.getUsername());
			usernameTxtField.setBounds(TITLE_X_POS, 180, TXTFIELD_WIDTH, 20);
			usernameTxtField.setEnabled(false);
			customerPanel.add(usernameTxtField);
			
			JLabel passwordLbl = new JLabel("Password");
			passwordLbl.setBounds(TITLE_X_POS - 100, 220, 100, 20);
			customerPanel.add(passwordLbl);
			passwordTxtField = new JPasswordField(c.getPassword());
			passwordTxtField.setBounds(TITLE_X_POS, 220, TXTFIELD_WIDTH, 20);
			passwordTxtField.setEnabled(false);
			customerPanel.add(passwordTxtField);
			
			JLabel addressLbl = new JLabel("Address");
			addressLbl.setBounds(TITLE_X_POS - 100, 280, 100, 20);
			customerPanel.add(addressLbl);
			addressTxtField = new JTextField(c.getAddress());
			addressTxtField.setBounds(TITLE_X_POS, 280, TXTFIELD_WIDTH, 20);
			addressTxtField.setEnabled(false);
			customerPanel.add(addressTxtField);
			
			JLabel statusLbl = new JLabel("Status");
			statusLbl.setBounds(TITLE_X_POS - 100, 320, 100, 20);
			customerPanel.add(statusLbl);
			JLabel statusStateLbl = new JLabel(c.getStatus());
			statusStateLbl.setBounds(TITLE_X_POS + 5, 320, TXTFIELD_WIDTH, 20);
			statusStateLbl.setEnabled(false);
			customerPanel.add(statusStateLbl);
			
			updateBtn = new JButton("Update");
			updateBtn.setBounds(TITLE_X_POS, 380, TXTFIELD_WIDTH, 20);
			updateBtn.setVisible(false);
			updateBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int choice = JOptionPane.showConfirmDialog(frame, "Are you sure?");

					if (choice == JOptionPane.OK_OPTION) {
						// extract input
						String username = usernameTxtField.getText();
						String password = new String(passwordTxtField.getPassword());
						String firstName = firstNameTxtField.getText();
						String lastName = lastNameTxtField.getText();
						String address = addressTxtField.getText();
						
						String oldUsername = c.getUsername();
						
						c = new Customer();
						c.setUsername(username);
						c.setPassword(password);
						c.setFirstName(firstName);
						c.setLastName(lastName);
						c.setAddress(address);
						
						// update
						if (cpc.updateDetails(c, oldUsername)) {
							refreshCustomerPanel("Update Profile", cpc, c, 2, customerPanel);
							
							JOptionPane.showMessageDialog(frame, "Successfully updated profile!");
						}
					}	
				}
				
			});
			customerPanel.add(updateBtn);
			
			deleteBtn = new JButton("Set inactive");
			deleteBtn.setBounds(TITLE_X_POS, 380, TXTFIELD_WIDTH, 20);
			deleteBtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					int choice = JOptionPane.showConfirmDialog(frame, "Are you sure?");

					if (choice == JOptionPane.OK_OPTION) {
						String reason = JOptionPane.showInputDialog(frame, "Any reason for setting your account inactive?");
						
						if (cpc.processDelete(c, reason)) {
							JOptionPane.showMessageDialog(frame, "Account is now inactive!");
							
							JPanel p = new SigninPanel(frame);
							frame.setContentPane(p);
							frame.setVisible(true);
						}
					}	
				}
				
			});
			customerPanel.add(deleteBtn);
			
			leftPanel = new JPanel();
			leftPanel.setLayout(new GridBagLayout()); 
			
			JButton viewProfileBtn = new JButton("<html>View<br/>profile</html>");
			viewProfileBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					refreshCustomerPanel("View Profile", cpc, c, 1, customerPanel);
				}
				
			});
			positionButton(gbc, 0);
			leftPanel.add(viewProfileBtn, gbc);
			
			JButton updateProfileBtn = new JButton("<html>Update<br/>profile</html>");
			updateProfileBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					refreshCustomerPanel("Update Profile", cpc, c, 2, customerPanel);
				}
				
			});
			positionButton(gbc, 1);
			leftPanel.add(updateProfileBtn, gbc);
			
			JButton viewProductBtn = new JButton("<html>View<br/>products</html>");
			viewProductBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel viewProductPanel = new ViewProductPanel(frame, splitPane);
					splitPane.setRightComponent(viewProductPanel);
					
					refreshPanel();
				}
				
			});
			positionButton(gbc, 2);
			leftPanel.add(viewProductBtn, gbc);
			
			JButton viewPurchasedProductBtn = new JButton("<html>View<br/>Purchased products</html>");
			viewPurchasedProductBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel viewPurchasedProductPanel = new PurchasedProductPanel(frame, splitPane);
					splitPane.setRightComponent(viewPurchasedProductPanel);
					
					refreshPanel();
				}
				
			});
			positionButton(gbc, 3);
			leftPanel.add(viewPurchasedProductBtn, gbc);
			
			JButton logoutBtn = new JButton("Logout");
			logoutBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel p = new SigninPanel(frame);
					frame.setContentPane(p);
					frame.setVisible(true);
				}
				
			});
			positionButton(gbc, 4);
			leftPanel.add(logoutBtn, gbc);
			
			splitPane.setRightComponent(customerPanel);
			
			// elderly code here
		} else if (appUserType == 2) { // elderly---------------------------------------------------------
			elderlyPanel = new JPanel();
			elderlyPanel.setLayout(null); 
			
			leftPanel = new JPanel();
			leftPanel.setLayout(new GridBagLayout());
			
			rightPanelTitle = new JLabel("View Profile");
			try {
				titleFont = Font.createFont(Font.TRUETYPE_FONT,new FileInputStream(new File("res/Lato-Hairline.ttf"))).deriveFont(Font.TRUETYPE_FONT, 40);
			} catch (Exception el) {
				JOptionPane.showMessageDialog(frame, "Font resource not found");
				
				el.printStackTrace();
			}
			rightPanelTitle.setFont(titleFont);
			rightPanelTitle.setBounds(TITLE_X_POS, 10, 250, 50); // keep it centralised
			elderlyPanel.add(rightPanelTitle);
			
			// retrieve elderly details
			epc = new ElderlyProfileController();
			el = epc.retrieveElderlyDetails(elderlyID, accPassword);

			JLabel firstNameLbl = new JLabel("First name");
			firstNameLbl.setBounds(TITLE_X_POS - 100, 80, 100, 20);
			elderlyPanel.add(firstNameLbl);
			firstNameTxtField = new JTextField(el.getFname());
			firstNameTxtField.setBounds(TITLE_X_POS, 80, TXTFIELD_WIDTH, 20);
			firstNameTxtField.setEnabled(false);
			elderlyPanel.add(firstNameTxtField);
			
			JLabel lastNameLbl = new JLabel("Last name");
			lastNameLbl.setBounds(TITLE_X_POS - 100, 120, 100, 20);
			elderlyPanel.add(lastNameLbl);
			lastNameTxtField = new JTextField(el.getLname());
			lastNameTxtField.setBounds(TITLE_X_POS, 120, TXTFIELD_WIDTH, 20);
			lastNameTxtField.setEnabled(false);
			elderlyPanel.add(lastNameTxtField);
			
			JLabel usernameLbl = new JLabel("NRIC");
			usernameLbl.setBounds(TITLE_X_POS - 100, 180, 100, 20);
			elderlyPanel.add(usernameLbl);
			usernameTxtField = new JTextField(el.getElderlyID());
			usernameTxtField.setBounds(TITLE_X_POS, 180, TXTFIELD_WIDTH, 20);
			usernameTxtField.setEnabled(false);
			elderlyPanel.add(usernameTxtField);
			
			JLabel passwordLbl = new JLabel("Password");
			passwordLbl.setBounds(TITLE_X_POS - 100, 220, 100, 20);
			elderlyPanel.add(passwordLbl);
			passwordTxtField = new JPasswordField(el.getAccPassword());
			passwordTxtField.setBounds(TITLE_X_POS, 220, TXTFIELD_WIDTH, 20);
			passwordTxtField.setEnabled(false);
			elderlyPanel.add(passwordTxtField);
			
			JLabel addressLbl = new JLabel("Address");
			addressLbl.setBounds(TITLE_X_POS - 100, 280, 100, 20);
			elderlyPanel.add(addressLbl);
			addressTxtField = new JTextField(el.getAddress());
			addressTxtField.setBounds(TITLE_X_POS, 280, TXTFIELD_WIDTH, 20);
			addressTxtField.setEnabled(false);
			elderlyPanel.add(addressTxtField);
			
			JLabel statusLbl = new JLabel("Status");
			statusLbl.setBounds(TITLE_X_POS - 100, 320, 100, 20);
			elderlyPanel.add(statusLbl);
			JLabel statusStateLbl = new JLabel(el.getAccStatus());
			statusStateLbl.setBounds(TITLE_X_POS + 5, 320, TXTFIELD_WIDTH, 20);
			statusStateLbl.setEnabled(false);
			elderlyPanel.add(statusStateLbl);
			
			updateBtn = new JButton("Update");
			updateBtn.setBounds(TITLE_X_POS, 380, TXTFIELD_WIDTH, 20);
			updateBtn.setVisible(false);
			updateBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					int choice = JOptionPane.showConfirmDialog(frame, "Are you sure?");
					
					if (choice == JOptionPane.OK_OPTION) {
						// extract input
						String accPassword = new String(passwordTxtField.getPassword());
						String fname = firstNameTxtField.getText();
						String lname = lastNameTxtField.getText();
						String address = addressTxtField.getText();
						
						String oldUsername = el.getElderlyID();
						
						el = new Elderly();
						el.setElderlyID(usernameTxtField.getText());
						el.setAccPassword(accPassword);
						el.setFname(fname);
						el.setLname(lname);
						el.setAddress(address);
						
						// update
						if (epc.updateDetails(el, oldUsername)) {
							refreshElderlyPanel("Update Profile", epc, el, 2, elderlyPanel);
							
							JOptionPane.showMessageDialog(frame, "Successfully updated profile!");
						}
					}
				}
			});
			elderlyPanel.add(updateBtn);
			
			JButton viewProfileBtn = new JButton("<html>View<br/>profile</html>");
			viewProfileBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					refreshElderlyPanel("View Profile", epc, el, 1, elderlyPanel);
				}
			});
			positionButton(gbc, 0);			
			leftPanel.add(viewProfileBtn, gbc);
			
			JButton updateProfileBtn = new JButton("<html>Update<br/>profile</html>");
			updateProfileBtn.addActionListener(new ActionListener() {
	
				@Override
				public void actionPerformed(ActionEvent e) {
					refreshElderlyPanel("Update Profile", epc, el, 2, elderlyPanel);
				}
			});
			
			positionButton(gbc, 1);
			leftPanel.add(updateProfileBtn, gbc);
			
			JButton viewWorkshopBtn = new JButton("<html>View<br/>workshops</html>");
			viewWorkshopBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel registerWorkshopPanel = new SignUpWorkshopPanel(frame);
					splitPane.setRightComponent(registerWorkshopPanel);
					
					refreshPanel();
				}
				
			});
			positionButton(gbc, 2);
			leftPanel.add(viewWorkshopBtn, gbc);
			
			JButton viewRegisteredWorkshopBtn = new JButton("<html>View<br/>registered workshops</html>");
			positionButton(gbc, 3);
			leftPanel.add(viewRegisteredWorkshopBtn, gbc);
			
			JButton logoutBtn = new JButton("Logout");
			positionButton(gbc, 4);
			logoutBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel p = new SigninPanel(frame);
					frame.setContentPane(p);
					frame.setVisible(true);
				}
				
			});
			leftPanel.add(logoutBtn, gbc);
			
			splitPane.setRightComponent(elderlyPanel);
		} else if (appUserType == 3) { // staff----------------------------------------
			leftPanel = new JPanel();
			leftPanel.setLayout(new GridBagLayout()); 
			
			JPanel publishWorkshopPanel = new PublishWorkshopPanel(frame);
			splitPane.setRightComponent(publishWorkshopPanel);
			
			JButton createWorkshopBtn = new JButton("<html>Create<br/>workshop</html>");
			createWorkshopBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel publishWorkshopPanel = new PublishWorkshopPanel(frame);
					splitPane.setRightComponent(publishWorkshopPanel);
					
					refreshPanel();
				}
				
			});
			positionButton(gbc, 0);
			leftPanel.add(createWorkshopBtn, gbc);
			
			JButton updateWorkshopBtn = new JButton("<html>Update<br/>workshop</html>");
			updateWorkshopBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel processRegPanel = new ProcessRegPanel(frame, splitPane);
					splitPane.setRightComponent(processRegPanel);
					
					refreshPanel();
				}
				
			});
			positionButton(gbc, 1);
			leftPanel.add(updateWorkshopBtn, gbc);
			
			JButton createProductBtn = new JButton("Products");
			createProductBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel productPanel = new ProductPanel(frame);
					splitPane.setRightComponent(productPanel);
					
					refreshPanel();
				}
				
			});
			positionButton(gbc, 2);
			leftPanel.add(createProductBtn, gbc);
			
			JButton logoutBtn = new JButton("Logout");
			logoutBtn.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					JPanel p = new SigninPanel(frame);
					frame.setContentPane(p);
					frame.setVisible(true);
				}
				
			});
			positionButton(gbc, 3);
			leftPanel.add(logoutBtn, gbc);
		}
		
		splitPane.setLeftComponent(leftPanel);
		
		splitPane.setDividerLocation(splitPane.getWidth() - 520);
		splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
		splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
	}
	
	private void refreshPanel() {
		splitPane.setDividerLocation(splitPane.getWidth() - 520);
		splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
		splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
	}
	
	private void refreshCustomerPanel(String title, CustomerProfileController cpc, Customer c, int operationType, JPanel p) {
		boolean isEnabled = false;
		
		rightPanelTitle.setText(title);
		
		cpc = new CustomerProfileController();
		c = cpc.retrieveCustomerDetails(c.getUsername());
		
		if (operationType == 1) { // view profile
			isEnabled = false;
		} else if (operationType == 2) { // update profile
			isEnabled = true;
		}
		
		firstNameTxtField.setText(c.getFirstName());
		firstNameTxtField.setEnabled(isEnabled);
		lastNameTxtField.setText(c.getLastName());
		lastNameTxtField.setEnabled(isEnabled);
		usernameTxtField.setText(c.getUsername());
		usernameTxtField.setEnabled(isEnabled);
		passwordTxtField.setText(c.getPassword());
		passwordTxtField.setEnabled(isEnabled);
		addressTxtField.setText(c.getAddress());
		addressTxtField.setEnabled(isEnabled);
		
		if (operationType == 1) { // view profile
			isEnabled = true;
		} else if (operationType == 2) { // update profile
			isEnabled = false;
		}
		deleteBtn.setVisible(isEnabled);
		
		if (operationType == 1) { // view profile
			isEnabled = false;
		} else if (operationType == 2) { // update profile
			isEnabled = true;
		}
		updateBtn.setVisible(isEnabled);
		
		splitPane.setRightComponent(customerPanel); 
		splitPane.setDividerLocation(splitPane.getWidth() - 520);
		splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
		splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
	}
	
	private void refreshElderlyPanel(String title, ElderlyProfileController epc, Elderly el, int operationType, JPanel p) {
		boolean isEnabled = false;
		
		rightPanelTitle.setText(title);
		
		epc = new ElderlyProfileController();
		System.out.println("Elderly ID: " + el.getElderlyID() + "Elderly pass: " + el.getAccPassword());
		
		el = epc.retrieveElderlyDetails(el.getElderlyID(), el.getAccPassword());
		 
		if (operationType == 1) { // view profile
			isEnabled = false;
		} else if (operationType == 2) { // update profile
			isEnabled = true;
		}
		
		firstNameTxtField.setText(el.getFname());
		firstNameTxtField.setEnabled(isEnabled);
		lastNameTxtField.setText(el.getLname());
		lastNameTxtField.setEnabled(isEnabled);
		passwordTxtField.setText(el.getAccPassword());
		passwordTxtField.setEnabled(isEnabled);
		addressTxtField.setText(el.getAddress());
		addressTxtField.setEnabled(isEnabled);
		
		if (operationType == 1) { // view profile
			isEnabled = false;
		} else if (operationType == 2) { // update profile
			isEnabled = true;
		}
		updateBtn.setVisible(isEnabled);
		
		splitPane.setRightComponent(elderlyPanel); 
		splitPane.setDividerLocation(splitPane.getWidth() - 520);
		splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
		splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
	}
	
	private void positionButton(GridBagConstraints gbc, int y) {
		gbc.fill = gbc.BOTH; // fill in empty spaces
		gbc.gridx = 0;
		gbc.gridy = y;
		gbc.weighty = 0.05; // space between the buttons
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		
		
	}
}
