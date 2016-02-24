package GSECarePortal.ui;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import GSECarePortal.entity.Product;

public class ProductDetailsTable extends AbstractTableModel {

	private int rowCount,colCount;
	private String [] colName = {"Product Name","Category","Quantity","Unit Price"};
	private Object [][] data;
	
	public ProductDetailsTable(ArrayList<Product> prodList) {
        rowCount = prodList.size();
        colCount = colName.length;
        data = new Object[rowCount][colCount];
        for (int i = 0; i < rowCount; i++) {
           /*Copy an ArrayList element to an instance of Expense*/
            Product pt = (Product)(prodList.get(i)); 
            data[i][0] = pt.getProductName();
            data[i][1] = pt.getCategory();
            data[i][2] = pt.getQuantity();
            data[i][3] = pt.getProductUnitPrice();
            
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
