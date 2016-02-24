package GSECarePortal.ui;

import java.awt.Font;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;

import GSECarePortal.controller.ProductController;
import GSECarePortal.entity.Product;

public class PurchasedProductPanel extends MasterPanel {

	private JTable table;
	private Font titleFont;
	
	public PurchasedProductPanel(JFrame f, JSplitPane sp) {
		super(f);
		
		JLabel title = new JLabel("Purchased products");
		try {
			titleFont = Font.createFont(Font.TRUETYPE_FONT,new FileInputStream(new File("res/Lato-Hairline.ttf"))).deriveFont(Font.TRUETYPE_FONT, 40);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(f, "Font resource not found");
			
			e.printStackTrace();
		}
		title.setFont(titleFont);
		title.setBounds(10, 10, 350, 50);
		add(title);
		
		JScrollPane scrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(10, 70, sp.getWidth() - 180, 300);
		add(scrollPane);
		
		table = new JTable();
		setTableModelFromDB();
		scrollPane.setViewportView(table);
		scrollPane.setColumnHeaderView(table.getTableHeader());
	}

	private void setTableModelFromDB(){
		ArrayList<Product> result = ProductController.retrieveAllPurchasedProduct();
		PurchasedProductSignupModel model = new PurchasedProductSignupModel(result);
		table.setModel(model);
	}
}
