package GSECarePortal.ui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JComboBox;

import GSECarePortal.controller.WorkshopController;
import GSECarePortal.entity.Workshop;

public class ProcessRegPanel extends MasterPanel {
	private JTable table;
	protected JFrame myFrame = null;

	/**
	 * Create the panel.
	 */
	public ProcessRegPanel(JFrame mf, JSplitPane sp) {
		super(mf);
	    myFrame = mf;
	    setLayout(null);
		
	    JLabel lblUpdateRegistrationStatus = new JLabel("Update Registration Status");
		lblUpdateRegistrationStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblUpdateRegistrationStatus.setBounds(136, 0, 226, 31);
		add(lblUpdateRegistrationStatus);
		
		ArrayList <Workshop> wsList = WorkshopController.getWorkshopDetails();
		final ArrayList <String> wsList2 = new ArrayList<String>();
		
		for(int i= 0; i<wsList.size(); i++){
			String s = wsList.get(i).getWsTitle(); 
			wsList2.add(s);	
		}
		
		table = new JTable();
		setTableModelFromDB();
		table.setBounds(10, 70, sp.getWidth(), 300);
		add(table);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(298, 247, 89, 23);
		add(btnUpdate);
	}

	
	private void setTableModelFromDB(){
	  ArrayList<Workshop> result = WorkshopController.getWorkshopDetails();
	  WorkshopDetailsTable model = new WorkshopDetailsTable(result);
	  table.setModel(model);
	}
}
