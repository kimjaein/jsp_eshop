package service;

import java.util.Date;

import dao.ProductDao;
import vo.Product;

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
	
	
}
