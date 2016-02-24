package GSECarePortal.ui;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class ViewProductPanel extends MasterPanel {

	private JSplitPane splitPane;
	/**
	 * Create the panel.
	 */
	public ViewProductPanel(JFrame f, JSplitPane viewSplitPane) {
		super(f);
		
		splitPane = viewSplitPane;
		
		JLabel lblNewLabel = new JLabel("View Products");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(195, 11, 109, 14);
		add(lblNewLabel);
		
		// mat----------------------------------------------
		JLabel img1 = new JLabel();
		img1.setIcon(new ImageIcon("res/images/mat.jpg"));
		img1.setBounds(10, 50, 109, 76);
		add(img1);
		
		JLabel textImg1 = new JLabel("Mat");
		textImg1.setBounds(10, 140, 74, 14);
		add(textImg1);
		
		JButton img1ViewBtn = new JButton("View"); 
		img1ViewBtn.setBounds(10, 160, 109, 20);
		img1ViewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel productDetails = new RetrieveProductDetails(frame, "Mat", "res/images/mat.jpg");
				splitPane.setRightComponent(productDetails);
				
				splitPane.setDividerLocation(splitPane.getWidth() - 520);
				splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
				splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
			}
			
		});
		add(img1ViewBtn);
		
		
		// carpet brush----------------------------------------------
		JLabel img2 = new JLabel();
		img2.setIcon(new ImageIcon("res/images/carpetbrush.jpg"));
		img2.setBounds(179, 50, 97, 76);
		add(img2);
		
		JLabel textImg2 = new JLabel("Brush");
		textImg2.setBounds(179, 140, 46, 14);
		add(textImg2);
		
		JButton img2ViewBtn = new JButton("View"); 
		img2ViewBtn.setBounds(179, 160, 109, 20);
		img2ViewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel productDetails = new RetrieveProductDetails(frame, "Brush", "res/images/carpetbrush.jpg");
				splitPane.setRightComponent(productDetails);
				
				splitPane.setDividerLocation(splitPane.getWidth() - 520);
				splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
				splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
			}
			
		});
		add(img2ViewBtn);
		
		// nutella----------------------------------------------
		JLabel img3 = new JLabel("New label");
		img3.setIcon(new ImageIcon("res/images/nutella.jpg"));
		img3.setBounds(315, 50, 109, 76);
		add(img3);
		
		JLabel textImg3 = new JLabel("Nutella");
		textImg3.setBounds(315, 140, 46, 14);
		add(textImg3);
		
		JButton img3ViewBtn = new JButton("View"); 
		img3ViewBtn.setBounds(315, 160, 109, 20);
		img3ViewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel productDetails = new RetrieveProductDetails(frame, "Nutella", "res/images/nutella.jpg");
				splitPane.setRightComponent(productDetails);
				
				splitPane.setDividerLocation(splitPane.getWidth() - 520);
				splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
				splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
			}
			
		});
		add(img3ViewBtn);
		
		
		// wax----------------------------------------------
		JLabel img4 = new JLabel("New label");
		img4.setIcon(new ImageIcon("res/images/wax.jpg"));
		img4.setBounds(10, 200, 128, 76);
		add(img4);
		
		JLabel textImg4 = new JLabel("Wax");
		textImg4.setBounds(10, 290, 150, 14);
		add(textImg4);
		
		JButton img4ViewBtn = new JButton("View"); 
		img4ViewBtn.setBounds(10, 310, 109, 20);
		img4ViewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel productDetails = new RetrieveProductDetails(frame, "Wax", "res/images/wax.jpg");
				splitPane.setRightComponent(productDetails);
				
				splitPane.setDividerLocation(splitPane.getWidth() - 520);
				splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
				splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
			}
			
		});
		add(img4ViewBtn);
		
		
		// camera lens----------------------------------------------
		JLabel img5 = new JLabel("New label");
		img5.setIcon(new ImageIcon("res/images/camera_lens.jpg"));
		img5.setBounds(179, 200, 97, 76);
		add(img5);
		
		JLabel textImg5 = new JLabel("Camera lens");
		textImg5.setBounds(179, 290, 150, 14);
		add(textImg5);
		
		JButton img5ViewBtn = new JButton("View"); 
		img5ViewBtn.setBounds(179, 310, 109, 20);
		img5ViewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel productDetails = new RetrieveProductDetails(frame, "Camera lens", "res/images/camera_lens.jpg");
				splitPane.setRightComponent(productDetails);
				
				splitPane.setDividerLocation(splitPane.getWidth() - 520);
				splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
				splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
			}
			
		});
		add(img5ViewBtn);
		
		
		// shampoo----------------------------------------------
		JLabel img6 = new JLabel("New label");
		img6.setIcon(new ImageIcon("res/images/shampoo.jpg"));
		img6.setBounds(308, 200, 116, 76);
		add(img6);

		JLabel textImg6 = new JLabel("Shampoo");
		textImg6.setBounds(315, 290, 150, 14);
		add(textImg6);
		
		JButton img6ViewBtn = new JButton("View"); 
		img6ViewBtn.setBounds(315, 310, 109, 20);
		img6ViewBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JPanel productDetails = new RetrieveProductDetails(frame, "Shampoo", "res/images/shampoo.jpg");
				splitPane.setRightComponent(productDetails);
				
				splitPane.setDividerLocation(splitPane.getWidth() - 520);
				splitPane.getLeftComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 520, MainFrame.APP_WINDOW_H));
				splitPane.getRightComponent().setMinimumSize(new Dimension(splitPane.getWidth() - 120, MainFrame.APP_WINDOW_H));
			}
			
		});
		add(img6ViewBtn);
	}
}
