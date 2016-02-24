package GSECarePortal.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import GSECarePortal.entity.Product;
import GSECarePortal.controller.ProductController;

import javax.swing.GroupLayout.Alignment;

public class ProductPanel extends MasterPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldProductName;
	private JTextField textFieldProductID;
	private JTextField textFieldQuantity;
	private JTextField textFieldUnitPrice;
		
	public ProductPanel(JFrame mf) {
		super(mf);
		// TODO Auto-generated constructor stub
		
		JLabel lblEnterProductDetails = new JLabel("Product Panel");
		lblEnterProductDetails.setFont(new Font("Arial Black", Font.PLAIN, 11));
		add(lblEnterProductDetails);
		
		JLabel labelProductDesc = new JLabel("Product Name:");
		add(labelProductDesc);
		
		JLabel labelCategory = new JLabel("Category:");
		add(labelCategory);
		
		JLabel labelQuantity = new JLabel("Quantity:");
		add(labelQuantity);
		
		textFieldProductName = new JTextField();
		textFieldProductName.setColumns(10);
		add(textFieldProductName);
		
		textFieldProductID = new JTextField();
		textFieldProductID.setColumns(10);
		add(textFieldProductID);
		
		textFieldQuantity = new JTextField();
		textFieldQuantity.setColumns(10);
		add(textFieldQuantity);
		
		
		textFieldUnitPrice = new JTextField();
		textFieldUnitPrice.setColumns(10);
		add(textFieldUnitPrice);
		
		// TESTING LATER DELETE
		JButton btnCreate = new JButton("Create");
		btnCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Product product = new Product (textFieldProductName.getText(), textFieldProductID.getText(),(Double.parseDouble(textFieldQuantity.getText())), Double.parseDouble(textFieldUnitPrice.getText()));


			
			//Double doubleobj = new Double(quantity);
			
			//Double doubleobj1 = new Double(productUnitPrice);
			
			
				
				if(ProductController.createProduct(product))
				{
				JOptionPane.showMessageDialog(mf,"Record succesfully created!","Success!",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(mf,"Record failed!","Error!",JOptionPane.ERROR_MESSAGE);
				}
			}
		}); 
		add(btnCreate);
		//END OF TESTING
		
		
		JLabel lblUnitPrice = new JLabel("Unit Price:");
		add(lblUnitPrice);
		
		
		
		
		JButton btnUpdate = new JButton("Update Record");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Product product = new Product (textFieldProductName.getText(), textFieldProductID.getText(),(Double.parseDouble(textFieldQuantity.getText())), Double.parseDouble(textFieldUnitPrice.getText()));
				
				if(ProductController.updateProduct(product))
				{
				JOptionPane.showMessageDialog(mf,"Record succesfully updated!","Success!",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(mf,"Record failed!","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		
		
		
		JButton btnNewButton = new JButton("Delete Record");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Product product = new Product (textFieldProductName.getText(), textFieldProductID.getText(),(Double.parseDouble(textFieldQuantity.getText())), Double.parseDouble(textFieldUnitPrice.getText()));
				
				if(ProductController.deleteProduct(product))
				{
				JOptionPane.showMessageDialog(mf,"Record succesfully deleted!","Success!",JOptionPane.INFORMATION_MESSAGE);
				}else{
					JOptionPane.showMessageDialog(mf,"Record failed!","Error!",JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
		});
		
		
		
		
		GroupLayout gl_contentPane = new GroupLayout(this);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(lblEnterProductDetails, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(btnCreate)
							.addGap(18)
							.addComponent(btnUpdate)
							.addGap(18)
							.addComponent(btnNewButton))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(labelCategory, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
								.addComponent(labelQuantity)
								.addComponent(lblUnitPrice)
								.addComponent(labelProductDesc, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
							.addGap(4)
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(textFieldUnitPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldProductID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldQuantity, GroupLayout.PREFERRED_SIZE, 63, GroupLayout.PREFERRED_SIZE)
								.addComponent(textFieldProductName, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE))))
					.addGap(16))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(lblEnterProductDetails)
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelProductDesc, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
						.addComponent(textFieldProductName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelCategory)
						.addComponent(textFieldProductID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(labelQuantity)
						.addComponent(textFieldQuantity, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(26)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblUnitPrice)
						.addComponent(textFieldUnitPrice, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCreate)
						.addComponent(btnUpdate)
						.addComponent(btnNewButton))
					.addContainerGap())
		);
		
		setLayout(gl_contentPane);
		
	}
}
