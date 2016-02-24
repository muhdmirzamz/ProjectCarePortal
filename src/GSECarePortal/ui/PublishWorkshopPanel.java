package GSECarePortal.ui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;

import GSECarePortal.controller.WorkshopController;
import GSECarePortal.entity.Workshop;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextArea;

public class PublishWorkshopPanel extends MasterPanel{
	protected JFrame myFrame = null;
	private JTextField textFieldTitle;
	private JTextField textFieldDescription;
//	private JTextField textFieldWorkshopDate;
//	private JTextField textFieldClosingRegDate;
	private JTextField textFieldVenue; 
	private JTextField textFieldWsTitle;
	private JTextField textFieldWsDescription;
	private JTextField textFieldWsDate;
	private JTextField textFieldSTime;
	private JTextField textFieldETime;
	private JTextField textFieldClosingRegDate;
	private JTextField textFieldMaxCap;
	private JTextField textFieldWsVenue;
//	private JTextField textFieldMaxCap;
//	private JTextField textFieldStartTime;
//	private JTextField textFieldEndTime;
	/**
	 * Create the panel.
	 */
	public PublishWorkshopPanel(JFrame mf) {
		  super(mf);
	      myFrame = mf;
	      setLayout(null);
	      
	      JLabel lblWorkshopPublication = new JLabel("Workshop Publication");
	      lblWorkshopPublication.setFont(new Font("Tahoma", Font.BOLD, 14));
	      lblWorkshopPublication.setBounds(158, 11, 161, 14);
	      add(lblWorkshopPublication);
	      
	      textFieldWsTitle = new JTextField();
	      textFieldWsTitle.setBounds(168, 43, 206, 20);
	      add(textFieldWsTitle);
	      textFieldWsTitle.setColumns(10);
	      
	      textFieldWsDescription = new JTextField();
	      textFieldWsDescription.setColumns(10);
	      textFieldWsDescription.setBounds(168, 74, 206, 20);
	      add(textFieldWsDescription);
	      
/*	      textField_2 = new JTextField();
	      textField_2.setColumns(10);
	      textField_2.setBounds(174, 160, 86, 20);
          add(textField_2);
*/	      
	      JLabel lblWsTitle = new JLabel("Workshop Title:");
	      lblWsTitle.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblWsTitle.setBounds(22, 45, 97, 14);
	      add(lblWsTitle);
	      
	      JLabel lblWsDescription = new JLabel("Workshop Description:\r\n");
	      lblWsDescription.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblWsDescription.setBounds(22, 70, 142, 14);
	      add(lblWsDescription);
	    
	      
	      JLabel lblNewLabel = new JLabel("Workshop Publication");
	      lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	      lblNewLabel.setBounds(175, 11, 197, 68);
	      //getContentPane().add(lblNewLabel);
	      
	      JLabel lblNewLabel_1 = new JLabel("Title:");
	      lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      lblNewLabel_1.setBounds(22, 73, 61, 28);
	      //getContentPane().add(lblNewLabel_1);
	      
	      JLabel lblDescription = new JLabel("Description:");
	      lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      lblDescription.setBounds(22, 112, 96, 28);
	      //getContentPane().add(lblDescription);
	      
	      JLabel lblDate = new JLabel("Workshop Date:");
	      lblDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      lblDate.setBounds(22, 151, 179, 47);
	      //getContentPane().add(lblDate);
	      
	      JLabel lblVenue = new JLabel("Venue:");
	      lblVenue.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      lblVenue.setBounds(22, 234, 61, 28);
	      //getContentPane().add(lblVenue);
	      
	      JLabel lblClosingRegistrationDate = new JLabel("Closing Registration Date:");
	      lblClosingRegistrationDate.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      lblClosingRegistrationDate.setBounds(22, 195, 197, 28);
	      //getContentPane().add(lblClosingRegistrationDate);
	      
	      JLabel lblMaximumCapacity = new JLabel("Maximum Capacity:");
	      lblMaximumCapacity.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      lblMaximumCapacity.setBounds(22, 294, 162, 28);
	      //getContentPane().add(lblMaximumCapacity);
	      
	      JLabel lblStartTime = new JLabel("Start Time:");
	      lblStartTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      lblStartTime.setBounds(22, 333, 96, 28);
	      //getContentPane().add(lblStartTime);
	      
	      JLabel lblEndTime = new JLabel("End Time:");
	      lblEndTime.setFont(new Font("Tahoma", Font.PLAIN, 15));
	      lblEndTime.setBounds(22, 372, 96, 28);
	      //getContentPane().add(lblEndTime);
	      
	      textFieldTitle = new JTextField();
	      textFieldTitle.setBounds(222, 79, 247, 20);
	      //getContentPane().add(textFieldTitle);
	      textFieldTitle.setColumns(10);
	      
	      textFieldDescription = new JTextField();
	      textFieldDescription.setBounds(222, 105, 247, 47);
	      //getContentPane().add(textFieldDescription);
	      textFieldDescription.setColumns(10);
	      
/*	      textFieldWorkshopDate = new JTextField();
	      textFieldWorkshopDate.setBounds(222, 166, 112, 20);
	      getContentPane().add(textFieldWorkshopDate);
	      textFieldWorkshopDate.setColumns(10);
	      
	      textFieldClosingRegDate = new JTextField();
	      textFieldClosingRegDate.setColumns(10);
	      textFieldClosingRegDate.setBounds(222, 201, 112, 20);
	      getContentPane().add(textFieldClosingRegDate);
*/	      
	      textFieldVenue = new JTextField();
	      textFieldVenue.setColumns(10);
	      textFieldVenue.setBounds(222, 234, 247, 47);
	      //getContentPane().add(textFieldVenue);
	      
/*	      textFieldMaxCap = new JTextField();
	      textFieldMaxCap.setBounds(222, 300, 61, 20);
	      getContentPane().add(textFieldMaxCap);
	      textFieldMaxCap.setColumns(10);
	      
	      textFieldStartTime = new JTextField();
	      textFieldStartTime.setColumns(10);
	      textFieldStartTime.setBounds(222, 339, 61, 20);
	      getContentPane().add(textFieldStartTime);
	      
	      textFieldEndTime = new JTextField();
	      textFieldEndTime.setColumns(10);
	      textFieldEndTime.setBounds(222, 378, 61, 20);
	      getContentPane().add(textFieldEndTime);
	      
*/
	      JLabel lblDateOfWorkshop = new JLabel("Date of Workshop:");
	      lblDateOfWorkshop.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblDateOfWorkshop.setBounds(22, 107, 142, 14);
	      add(lblDateOfWorkshop);
	      
	      JLabel lblDateOfClosing = new JLabel("Date of Closing Registration:\r\n");
	      lblDateOfClosing.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblDateOfClosing.setBounds(22, 229, 161, 14);
	      add(lblDateOfClosing);
	      
	      JLabel lblWorkshopVenue = new JLabel("Workshop Venue:\r\n\r\n");
	      lblWorkshopVenue.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblWorkshopVenue.setBounds(22, 132, 161, 14);
	      add(lblWorkshopVenue);
	      
	      JLabel lblStartTime_1 = new JLabel("Start Time:\r\n");
	      lblStartTime_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblStartTime_1.setBounds(168, 173, 161, 14);
	      add(lblStartTime_1);
	      
	      JLabel lblEndTime_1 = new JLabel("End Time:\r\n");
	      lblEndTime_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblEndTime_1.setBounds(305, 173, 69, 14);
	      add(lblEndTime_1);
	      
	      textFieldWsDate = new JTextField();
	      textFieldWsDate.setBounds(167, 105, 69, 20);
	      add(textFieldWsDate);
	      textFieldWsDate.setColumns(10);
	      
	      textFieldSTime = new JTextField();
	      textFieldSTime.setColumns(10);
	      textFieldSTime.setBounds(168, 198, 63, 20);
	      add(textFieldSTime);
	      
	      textFieldETime = new JTextField();
	      textFieldETime.setColumns(10);
	      textFieldETime.setBounds(311, 198, 63, 20);
	      add(textFieldETime);
	      
	      textFieldClosingRegDate = new JTextField();
	      textFieldClosingRegDate.setColumns(10);
	      textFieldClosingRegDate.setBounds(186, 227, 133, 20);
	      add(textFieldClosingRegDate);
	      
	      JLabel lblMaxCapacity = new JLabel("Max Capacity:\r\n");
	      lblMaxCapacity.setFont(new Font("Tahoma", Font.PLAIN, 12));
	      lblMaxCapacity.setBounds(22, 254, 161, 14);
	      add(lblMaxCapacity);
	      
	      textFieldMaxCap = new JTextField();
	      textFieldMaxCap.setBounds(168, 252, 69, 20);
	      add(textFieldMaxCap);
	      textFieldMaxCap.setColumns(10);
  
	      //Publish button
	      JButton btnPublish = new JButton("Publish");
	      btnPublish.addActionListener(new ActionListener() {
	      	public void actionPerformed(ActionEvent arg0) {
	      		WorkshopController wc = new WorkshopController();
	      		boolean create = false;
	      		
	      		create = wc.createWorkshop(textFieldWsTitle.getText(), textFieldWsDescription.getText(), textFieldWsDate.getText(), textFieldWsVenue.getText(), textFieldSTime.getText(), textFieldETime.getText(), textFieldClosingRegDate.getText(), Integer.parseInt(textFieldMaxCap.getText()));
	      		if (create == true) {
	      			JOptionPane.showMessageDialog(null, "Create Successful","Message", 1);
	      		}
	      			else{
	      				JOptionPane.showMessageDialog(null, "Create Failed","Error", 0);
	      		}
	      		
	      	}
	      	
	      });
	      btnPublish.setBounds(295, 278, 96, 34);
	      add(btnPublish);
	      
	      textFieldWsVenue = new JTextField();
	      textFieldWsVenue.setBounds(158, 130, 218, 20);
	      add(textFieldWsVenue);
	      textFieldWsVenue.setColumns(10);
	      
	      
	}
}


