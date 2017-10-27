package service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dao.BuylistDao;
import dao.ProductDao;
import vo.MyCart;
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
			 
//			 System.out.println(title);
			 
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
	public List<Product> selectColorAndSize(String title){
		Product Product = dao.selectProduct(title);
		List<Product> productList = new ArrayList<>();
		
		
		productList.add(Product);
		
		return productList;
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
	//장바구니를 이용해서 상품정보 리스트로 출력해오는거
	public List<Product> myCartProduct(String id){
		List<MyCart> cartList = dao.cartList(id);
		List<Product> productList = new ArrayList<>();
		for(int i=0;i<cartList.size();i++) {
			productList.add(dao.cartProduct(cartList.get(i).getProduct_num()));
		}
		return productList;
	}
	/////////////////////////////////////////////////
	//장바구니 삭제
	public int cartDelete(String id, int productNum) {
		return dao.cartDelete(id, productNum);
	}
	//////////////////////////////////////////////
	//장바구니에 이미 상품이 있으면 수량증가, 아니면 상품정보 DB에 입력
	public int updateAndInsert(String id, String title, String color, String size, int quantity) {
		//상품명, 색상, 사이즈를 이용해서 상품번호 뽑아오기
		int productNum = dao.selectProductNum(title, color, size);
		int cartQuantity = dao.quantityCheck(id, productNum);//수행 전 해당 상품의 수량을 가져옴
		if(cartQuantity>=1) {//수량이 1보다 크거나 같을시에 수량증가(UPDATE)
			System.out.println("[Pservice]수량 증가 실행");
			dao.quantityPlus(cartQuantity,quantity, productNum,id);
			return 2;
		}else {//1보다 작을때 즉,0일땐 장바구니에 새로 추가(INSERT)
			System.out.println("[Pservice]장바구니 추가 실행");
			dao.insertCart(quantity, productNum,id);
			return 1;
		}
	}
	//////////////////////////////////////////////
	//구매목록 추가메소드[장바구니 목록을 리스트로 가져와서 순차대로 장바구니의 수량과 상품번호를 뽑아서
	//상품번호로는 상품 정보를 가져오고 상품정보와 수량을 구매목록 DB에 넣은 뒤 INSERT의 return값이 1일때 장바구니 DELETE
	//그게 아니면 return false;
	public boolean buylistInsert(String id) {
		List<MyCart> cartList = dao.cartList(id);

		for(int i=0; i<cartList.size(); i++) {
			Product product = new Product();
			product = dao.cartProduct(cartList.get(i).getProduct_num());
			product.setRegisterTime(new Date());//INSERT할때 시간을 위해서 설정
			//BuyListDao에 insertBuyList의 매개변수로 product객체, 수량, 아이디 입력
			if(BuylistDao.getInstance().insertBuyList(product, cartList.get(i).getCart_quantity(), id)==1) {
				//입력 성공 시 장바구니 삭제
				dao.cartDelete(id, cartList.get(i).getProduct_num());
			}else {
				return false;
			}
		}
		return true;
	}
	////////////////////////////////////////////////
	//상품명을 이용해서 size, color 따로 따로 리스트로 뽑아오는 메소드 single.jsp[size, color select]에 사용
	public List<String> colorList(String title){
		return dao.colorList(title);
	}
	////////////////////////////////////////////////
	//상품명을 이용해서 size 리스트
	public List<String> sizeList(String title){
		return dao.sizeList(title);
	}
}
