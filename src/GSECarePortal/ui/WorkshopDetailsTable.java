package GSECarePortal.ui;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import GSECarePortal.entity.Workshop;

public class WorkshopDetailsTable extends AbstractTableModel {
	
	private int rowCount, colCount;
	private String[] colName = {"Workshop Title", "Workshop Description", "Workshop Date", "Workshop Venue", "Start Time","End Time","CloseRegistrationDate","Maximum Capacity"};
	private Object[][] data;
	
	public WorkshopDetailsTable(ArrayList<Workshop> workshopList) {
		rowCount = workshopList.size();
		colCount = colName.length;
		data = new Object[rowCount][colCount];
		for(int i=0; i<rowCount; i++){
			Workshop ws=(Workshop)(workshopList.get(i));
			data[i][0] = ws.getWsTitle();
			data[i][1] = ws.getWsDescription();
			data[i][2] = ws.getWsDate();
			data[i][3] = ws.getWsVenue();
			data[i][4] = ws.getsTime();
			data[i][5] = ws.geteTime();
    		data[i][6] = ws.getClosingRegDate();
			data[i][7] = ws.getMaxCap();
			
			
			
		
	}
	}
	
	 public int getColumnCount() {
	        // TODO Auto-generated method stub
	        return colCount;
	    }
	 
	    @Override
	    public int getRowCount() {
	        // TODO Auto-generated method stub
	        return rowCount;
	    }
	 
	    @Override
	    public Object getValueAt(int row, int col) {
	        // TODO Auto-generated method stub
	        return data[row][col];
	    }
	     
	    public String getColumnName(int col){
	        return colName[col];
	    }
	 

}
