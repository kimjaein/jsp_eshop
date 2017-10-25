package service;

import java.util.Date;
import java.util.List;

import dao.ProductDao;
import vo.Product;
import vo.ProductList;

public class ProductService {
	private ProductDao dao = ProductDao.getInstance();
	/////////////////////////////////////////////////////////////////////////////////////////////
	// Singleton
	private static ProductService instance;
	public static ProductService getInstance() {
		if(instance==null) {
			instance = new ProductService();
		}
		return instance;
	}
	
	private ProductService() {}
	/////////////////////////////////////////////////////////////////////////////////////////////
	public boolean addProduct(Product product) {
		product.setRegisterTime(new Date());
		
		int result = dao.insert(product);
		if(result==1)
			return true;
		else
			return false;
	
	}
	
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public Product makeProduct(String title) {
		Product singleProduct = dao.selectProduct(title);
		
		return singleProduct;
	}
	
	
}
