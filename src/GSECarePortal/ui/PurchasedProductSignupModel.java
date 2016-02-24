package GSECarePortal.ui;
	
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

import GSECarePortal.entity.Product;

public class PurchasedProductSignupModel extends AbstractTableModel  {
	
	private int rowCount, colCount;
	private String[] colName = {"Product name","Category", "Quantity", "Product unit price"};
	private Object[][] data;
	
	public PurchasedProductSignupModel(ArrayList<Product> listOfObject) {
        rowCount = listOfObject.size();
        colCount = colName.length;
        data = new Object[rowCount][colCount];
        
        for (int i = 0; i < rowCount; i++) {
           /*Copy an ArrayList element to an instance of Expense*/
             Product p = (Product)(listOfObject.get(i)); 
             data[i][0] = p.getProductName();
             data[i][1] = p.getCategory();
             data[i][2] = p.getQuantity();
             data[i][3] = p.getProductUnitPrice();
        }              
    }

	@Override
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