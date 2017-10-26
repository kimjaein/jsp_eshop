package service;

import java.util.Date;
import java.util.List;

import dao.ProductDao;
import vo.Product;

public class ProductService {
	private ProductDao dao = ProductDao.getInstance();
	/////////////////////////////////////////////////////////////////////////////////////////////
	// Singleton
	private static ProductService instance;

	public static ProductService getInstance() {
		if (instance == null) {
			instance = new ProductService();
		}
		return instance;
	}

	private ProductService() {
	}

	/////////////////////////////////////////////////////////////////////////////////////////////
	public boolean addProduct(Product product) {
		product.setRegisterTime(new Date());

		int result = dao.insert(product);
		if (result == 1)
			return true;
		else
			return false;

	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	public Product makeProduct(String title) {
		Product singleProduct = dao.selectProduct(title);

		return singleProduct;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Product> categoryProduct(String category) {
		List<Product> categoryList = dao.selectCategory(category);
		for (int i = 0; i < categoryList.size(); i++) {
			Product p = categoryList.get(i);
			String title = p.getTitle();
			//
			p.setTitle(title);
			categoryList.remove(i); // 기존 객체지우고
			categoryList.add(i, p);//
		}

		return categoryList;
	}

}
