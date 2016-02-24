package GSECarePortal.entity;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

import GSECarePortal.controller.DBController;

public class Product {

	String productName;
	String category;
	double quantity;
	double productUnitPrice;

	public Product(String productName, String category, double quantity, double productUnitPrice) {
		super();
		this.productName = productName;
		this.category = category;
		this.quantity = quantity;
		this.productUnitPrice = productUnitPrice;

	}

	public Product() {

	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public double getProductUnitPrice() {
		return productUnitPrice;
	}

	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}

	public boolean updateProductDetails(String productName, double productUnitPrice, String category) {
		return true;
	}

	/**
	 * Purpose: This method takes in an Expense object and store it into the
	 * database. Input: Expense object Return: boolean
	 */
	public static boolean createProduct(Product product) {
		// declare local variables
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;

		// step 1 - establish connection to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "INSERT INTO productdetails(productName,category,quantity,productUnitPrice) VALUES(?, ?, ?, ?)";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - to insert record using executeUpdate method
		try {
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2, product.getCategory());
			pstmt.setDouble(3, product.getQuantity());
			pstmt.setDouble(4, product.getProductUnitPrice());
			if (pstmt.executeUpdate() == 1)
				success = true;
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return success;
	}
	
	public static boolean createPurchasedProduct(Product product) {
		// declare local variables
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;

		// step 1 - establish connection to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "INSERT INTO PurchasedProductDetail(productName,category,quantity,productUnitPrice) VALUES(?, ?, ?, ?)";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - to insert record using executeUpdate method
		try {
			pstmt.setString(1, product.getProductName());
			pstmt.setString(2, product.getCategory());
			pstmt.setInt(3, (int)product.getQuantity());
			pstmt.setDouble(4, product.getProductUnitPrice());
			if (pstmt.executeUpdate() == 1)
				success = true;
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return success;
	}

	private static Product convertToProduct(ResultSet rs) throws SQLException {
		Product p;
		String productName = rs.getString("productName");
		String category = rs.getString("category");
		double quantity = rs.getDouble("quantity");
		double productUnitPrice = rs.getDouble("productUnitPrice");
		
		p = new Product(productName, category, quantity, productUnitPrice);

		return p;
	}

	/**
	 * Purpose: This method retrieves all the expense records in the database
	 * and returns them in an ArrayList. Input: Nil Return: ArrayList of Expense
	 * objects
	 */
	public static Product retrieveProduct(Product rp) {
		// declare local variables
		Product p = null;
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt = null;
		
		// Step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM productdetails WHERE productName = ?";

		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		try {
			pstmt.setString(1, rp.getProductName());
			
			if (rs.next()) {
				p = convertToProduct(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return p;
	}
	
	public static ArrayList<Product> retrieveAllProduct() {
		// declare local variables
		ArrayList<Product> list = new ArrayList<Product>();
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;

		// Step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM productdetails";

		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				Product p = convertToProduct(rs);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return list;
	}
	
	public static ArrayList<Product> retrieveAllPurchasedProduct() {
		// declare local variables
		ArrayList<Product> list = new ArrayList<Product>();
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;

		// Step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM PurchasedProductDetail";

		// step 3 - using DBControlle readRequest method
		rs = db.readRequest(dbQuery);
		try {
			while (rs.next()) {
				Product p = convertToProduct(rs);
				list.add(p);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();

		return list;
	}

	public static Product retrieveProductByName(String name) {
		// declare local variables
		Product p = null;
		ResultSet rs = null;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;

		// step 1 - connect to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "SELECT * FROM productdetails WHERE productName = ?";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - execute query
		try {
			pstmt.setString(1, name);
			
			rs = pstmt.executeQuery();
			if (rs.next()) { // first record found
				p = convertToProduct(rs);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		// step 4 - close connection
		db.terminate();
		return p;
	}

	public static boolean updateProduct(Product up) {
		// declare local variables
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;

		// step 1 - establish connection to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "UPDATE productdetails SET productName = ?, category = ?, quantity = ? WHERE productUnitPrice = ?";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - to update record using executeUpdate method
		try {
			pstmt.setString(1, up.getProductName());
			pstmt.setString(2, up.getCategory());
			pstmt.setDouble(3, up.getQuantity());
			pstmt.setDouble(4, up.getProductUnitPrice());

			if (pstmt.executeUpdate() == 1)
				success = true;
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(success);
		// step 4 - close connection
		db.terminate();

		return success;


	}



	public static boolean deleteProduct(Product dp) {
		// declare local variables
		boolean success = false;
		DBController db = new DBController();
		String dbQuery;
		PreparedStatement pstmt;

		// step 1 - establish connection to database
		db.getConnection();

		// step 2 - declare the SQL statement
		dbQuery = "DELETE FROM productdetails WHERE productName = ?";
		pstmt = db.getPreparedStatement(dbQuery);

		// step 3 - to update record using executeUpdate method
		try {
			pstmt.setString(1, dp.getProductName());
			pstmt.setString(2, dp.getCategory());
			pstmt.setDouble(3, dp.getQuantity());
			pstmt.setDouble(4, dp.getProductUnitPrice());

			if (pstmt.executeUpdate() == 1)
				success = true;
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(success);
		// step 4 - close connection
		db.terminate();

		return success;

	}
}

	
// *
// * public static void main(String[] args) { // create Expense object using
// * default constructor Expense e1 = new Expense(0); // e1 object uses setter
// * methods to set values e1.setDateSpend("08-09-2013");
// * e1.setCategory("Transport"); e1.setAmount(15.00); e1.setContent(
// * "EZ Link card");
// *
// * // create record in database boolean result = ExpenseDA.createExpense(e1);
// * System.out.println(result); // is the record successfully created?
// *
// * // retrieve all expense record from database ArrayList<Expense> eList =
// * ExpenseDA.retrieveAllExpense(); for (int i=0; i<eList.size(); i++){ Expense
// e
// * = eList.get(i); // print out the record data using getter methods
// * System.out.print(e.getDateSpend() + "\t"); System.out.print(e.getCategory()
// +
// * "\t"); System.out.print(e.getAmount() + "\t");
// * System.out.print(e.getContent() + "\n"); } } }
// */