package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.ProductDao;
import vo.MyCart;
import vo.Article;
import vo.ArticlePage;
import vo.Product;
import vo.ProductPage;

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
	private static final int COUNT_PER_PAGE=6;
	
	
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
	public ProductPage middleCategoryProduct(String middleCategory, int page) {
		
		int totalProductCount = dao.selectMiddleProductCount(middleCategory);
		int totalPage = totalProductCount / COUNT_PER_PAGE;
		if(totalProductCount % COUNT_PER_PAGE > 0) {
			totalPage++;
		}
		int startPage = (page -1) / 10 * 10 + 1;

		// 하단 끝 페이지
		int endPage = startPage + 9;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// limit 시작행 계산
		int startRow = (page - 1) * COUNT_PER_PAGE;
		
		List<Product> categoryList = dao.selectMiddleCategory(middleCategory, startRow, COUNT_PER_PAGE);
		
		
		
		 for(int i=0; i<categoryList.size();i++) {
			 Product p = categoryList.get(i);
			 String title = p.getTitle();
			 
			 
			 
			 title = title.substring(0,title.length()-2);
			 p.setTitle(title);
			 
			 categoryList.remove(i);
			 categoryList.add(i, p);
			 
			 //			 categoryList.get(i).setTitle(title);			 
		 }
		 
		 ProductPage productPage = new ProductPage(categoryList, startPage, endPage, page, totalPage);
//		 System.out.println(categoryList);
		 		
		return productPage;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	public ProductPage largeCategoryProduct(String largeCategory, int page) {
		System.out.println(largeCategory+"string");
		int totalProductCount = dao.selectLargeProductCount(largeCategory);
		System.out.println(totalProductCount + "service total");
		int totalPage = totalProductCount / COUNT_PER_PAGE;
		if(totalProductCount % COUNT_PER_PAGE > 0) {
			totalPage++;
		}
		int startPage = (page -1) / 10 * 10 + 1;

		// 하단 끝 페이지
		int endPage = startPage + 9;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// limit 시작행 계산
		int startRow = (page - 1) * COUNT_PER_PAGE;
		
		List<Product> categoryList = dao.selectLargeCategory(largeCategory, startRow, COUNT_PER_PAGE);
		
		
		
		 for(int i=0; i<categoryList.size();i++) {
			 Product p = categoryList.get(i);
			 String title = p.getTitle();
			 
			 
			 
			 title = title.substring(0,title.length()-2);
			 p.setTitle(title);
			 
			 categoryList.remove(i);
			 categoryList.add(i, p);
			 
			 //			 categoryList.get(i).setTitle(title);			 
		 }
		 
		 ProductPage productPage = new ProductPage(categoryList, startPage, endPage, page, totalPage);
//		 System.out.println(categoryList);
		 		
		return productPage;
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	public List<Product> myCartProduct(String id){
		List<Integer> list = dao.cartList(id);
		List<Product> productList = new ArrayList<>();
		for(int i=0;i<list.size();i++) {
			productList.add(dao.cartProduct(list.get(i)));
		}
		return productList;
	}
	public int cartDelete(String id, int productNum) {
		return dao.cartDelete(id, productNum);
	}
	
	public int updateAndInsert(String id, int productNum) {
		int cartQuantity = dao.quantityCheck(id, productNum);
		if(cartQuantity>=1) {
			System.out.println("[Pservice]수량 증가 실행");
			dao.quantityPlus(cartQuantity, productNum,id);
			return 2;
		}else {
			System.out.println("[Pservice]장바구니 추가 실행");
			cartQuantity=1;
			dao.insertCart(cartQuantity, productNum,id);
			return 1;
		}
	}
}
