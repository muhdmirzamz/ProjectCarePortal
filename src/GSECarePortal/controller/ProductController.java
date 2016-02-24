package GSECarePortal.controller;
import java.util.*;
import GSECarePortal.entity.Product;
public class ProductController {
	
	private ArrayList<String> ProductList = new ArrayList<String>();

	// creates an array list of products

	

	public static boolean createProduct(Product product) {
		return(Product.createProduct(product));
	}
	
	public static boolean createPurchasedProduct(Product product) {
		return(Product.createPurchasedProduct(product));
	}

	public static boolean retrieveProduct(Product rp) {
		if (Product.retrieveProduct(rp) == null) {
			return false;
		}
		
		return true;
	}
	
	public static ArrayList<Product> retrieveAllProduct() {
		return Product.retrieveAllProduct();
	}
	
	public static ArrayList<Product> retrieveAllPurchasedProduct() {
		return Product.retrieveAllPurchasedProduct();
	}

	public static boolean updateProduct(Product up) {
		return(Product.updateProduct(up));
	}

	
	public static boolean deleteProduct(Product dp){
		return(Product.deleteProduct(dp));
	}
	
}


