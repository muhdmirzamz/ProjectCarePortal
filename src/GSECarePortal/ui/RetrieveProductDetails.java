package GSECarePortal.ui;

import javax.swing.JPanel;
import javax.swing.JTable;

import GSECarePortal.controller.ProductController;
import GSECarePortal.entity.Product;

import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;


public class RetrieveProductDetails extends MasterPanel {
	
	private Product p;
    
	/**
	 * Create the panel.
	 */
	public RetrieveProductDetails(JFrame f, String prodName, String prodPicURL) {
		super(f);
		
		DecimalFormat df = new DecimalFormat("0.00");
		
		p = Product.retrieveProductByName(prodName);
		
		// title----------------------------------------
		JLabel title = new JLabel("Product details");
		title.setBounds(200, 10, 100, 50);
		add(title);
		
		//String productName, String category, double quantity, double productUnitPrice
		// product name----------------------------------------
		JLabel productNameLbl = new JLabel("Product name:"); 
		productNameLbl.setBounds(10, 100, 150, 50);
		add(productNameLbl);
		
		JLabel productName = new JLabel(p.getProductName()); 
		productName.setBounds(180, 100, 100, 50);
		add(productName);
		
		// product category----------------------------------------
		JLabel productCategoryLbl = new JLabel("Product category:"); 
		productCategoryLbl.setBounds(10, 150, 150, 50);
		add(productCategoryLbl);
		
		JLabel productCategory = new JLabel(p.getCategory()); 
		productCategory.setBounds(180, 150, 150, 50);
		add(productCategory);
		
		// product quantity----------------------------------------
		JLabel productQuantityLbl = new JLabel("Product quantity:"); 
		productQuantityLbl.setBounds(10, 200, 150, 50);
		add(productQuantityLbl);
		
		JLabel productQuantity = new JLabel(String.valueOf((int)p.getQuantity())); 
		productQuantity.setBounds(180, 200, 100, 50);
		add(productQuantity);
		
		// product unit price----------------------------------------
		JLabel productUnitPriceLbl = new JLabel("Product unit price:"); 
		productUnitPriceLbl.setBounds(10, 250, 150, 50);
		add(productUnitPriceLbl);
		
		JLabel productUnitPrice = new JLabel("$" + df.format(p.getProductUnitPrice())); 
		productUnitPrice.setBounds(180, 250, 100, 50);
		add(productUnitPrice);
		
		JButton purchaseBtn = new JButton("Purchase");
		purchaseBtn.setBounds(180, 300, 150, 50);
		purchaseBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selection = JOptionPane.showConfirmDialog(frame, "Are you sure you want to purchase?");
				
				if (selection == JOptionPane.OK_OPTION) {
					JOptionPane.showInputDialog("Please enter your card pin:");
					
					if (ProductController.createPurchasedProduct(p)) {
						JOptionPane.showMessageDialog(frame, "Purchase successful!");
					} else {
						JOptionPane.showMessageDialog(frame, "Purchase failed!");
					}
				}
			}
			
		});
		add(purchaseBtn);
	}

}
