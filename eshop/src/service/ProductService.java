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
	public List<Product> selectRecentProduct(){
		List<Product> recentProductList = dao.selectRecentProduct();
		
		 for(int i=0; i<recentProductList.size();i++) {
			 Product p = recentProductList.get(i);
			 String title = p.getTitle();
			 
			 
			 
			 title = title.substring(0,title.length()-2);
			 p.setTitle(title);
			 
			 recentProductList.remove(i);
			 recentProductList.add(i, p);
			 
			 System.out.println(title);
			 
		 }
		
		return recentProductList;
	}
	/////////////////////////////////////////////////////////////////////////////////////////////
	public List<Product> selectBestProduct(){
		List<Product> bestProductList = dao.selectBestProduct();
		
		 for(int i=0; i<bestProductList.size();i++) {
			 Product p = bestProductList.get(i);
			 String title = p.getTitle();
			 
			 
			 
			 title = title.substring(0,title.length()-2);
			 p.setTitle(title);
			 
			 bestProductList.remove(i);
			 bestProductList.add(i, p);
			 
		 }
		
		return bestProductList;
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

		System.out.println(title);
		String str = singleProduct.getTitle();
		
		System.out.println(str);
		
		 str=str.substring(0,str.length()-2);
		 singleProduct.setTitle(str);
		
		 
		return singleProduct;
	}

	/////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Product> middleCategoryProduct(String middleCategory) {
		List<Product> categoryList = dao.selectMiddleCategory(middleCategory);
		
		 for(int i=0; i<categoryList.size();i++) {
			 Product p = categoryList.get(i);
			 String title = p.getTitle();
			 
			 
			 
			 title = title.substring(0,title.length()-2);
			 p.setTitle(title);
			 
			 categoryList.remove(i);
			 categoryList.add(i, p);
			 
			 //			 categoryList.get(i).setTitle(title);			 
		 }
//		 System.out.println(categoryList);
		 		
		return categoryList;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public List<Product> largeCategoryProduct(String largeCategory) {
		List<Product> categoryList = dao.selectLargeCategory(largeCategory);
		
		 for(int i=0; i<categoryList.size();i++) {
			 Product p = categoryList.get(i);
			 String title = p.getTitle();
			 
			 
			 
			 title = title.substring(0,title.length()-2);
			 p.setTitle(title);
			 
			 categoryList.remove(i);
			 categoryList.add(i, p);
			 
			 //			 categoryList.get(i).setTitle(title);			 
		 }
//		 System.out.println(categoryList);
		 		
		return categoryList;
	}

}
