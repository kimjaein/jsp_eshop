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

		// �ϴ� �� ������
		int endPage = startPage + 9;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// limit ������ ���
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

		// �ϴ� �� ������
		int endPage = startPage + 9;
		if (endPage > totalPage) {
			endPage = totalPage;
		}

		// limit ������ ���
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
	//��ٱ��ϸ� �̿��ؼ� ��ǰ���� ����Ʈ�� ����ؿ��°�
	public List<Product> myCartProduct(String id){
		List<MyCart> cartList = dao.cartList(id);
		List<Product> productList = new ArrayList<>();
		for(int i=0;i<cartList.size();i++) {
			productList.add(dao.cartProduct(cartList.get(i).getProduct_num()));
		}
		return productList;
	}
	/////////////////////////////////////////////////
	//��ٱ��� ����
	public int cartDelete(String id, int productNum) {
		return dao.cartDelete(id, productNum);
	}
	//////////////////////////////////////////////
	//��ٱ��Ͽ� �̹� ��ǰ�� ������ ��������, �ƴϸ� ��ǰ���� DB�� �Է�
	public int updateAndInsert(String id, String title, String color, String size, int quantity) {
		//��ǰ��, ����, ����� �̿��ؼ� ��ǰ��ȣ �̾ƿ���
		int productNum = dao.selectProductNum(title, color, size);
		int cartQuantity = dao.quantityCheck(id, productNum);//���� �� �ش� ��ǰ�� ������ ������
		if(cartQuantity>=1) {//������ 1���� ũ�ų� �����ÿ� ��������(UPDATE)
			System.out.println("[Pservice]���� ���� ����");
			dao.quantityPlus(cartQuantity,quantity, productNum,id);
			return 2;
		}else {//1���� ������ ��,0�϶� ��ٱ��Ͽ� ���� �߰�(INSERT)
			System.out.println("[Pservice]��ٱ��� �߰� ����");
			dao.insertCart(quantity, productNum,id);
			return 1;
		}
	}
	//////////////////////////////////////////////
	//���Ÿ�� �߰��޼ҵ�[��ٱ��� ����� ����Ʈ�� �����ͼ� ������� ��ٱ����� ������ ��ǰ��ȣ�� �̾Ƽ�
	//��ǰ��ȣ�δ� ��ǰ ������ �������� ��ǰ������ ������ ���Ÿ�� DB�� ���� �� INSERT�� return���� 1�϶� ��ٱ��� DELETE
	//�װ� �ƴϸ� return false;
	public boolean buylistInsert(String id) {
		List<MyCart> cartList = dao.cartList(id);

		for(int i=0; i<cartList.size(); i++) {
			Product product = new Product();
			product = dao.cartProduct(cartList.get(i).getProduct_num());
			product.setRegisterTime(new Date());//INSERT�Ҷ� �ð��� ���ؼ� ����
			//BuyListDao�� insertBuyList�� �Ű������� product��ü, ����, ���̵� �Է�
			if(BuylistDao.getInstance().insertBuyList(product, cartList.get(i).getCart_quantity(), id)==1) {
				//�Է� ���� �� ��ٱ��� ����
				dao.cartDelete(id, cartList.get(i).getProduct_num());
			}else {
				return false;
			}
		}
		return true;
	}
	////////////////////////////////////////////////
	//��ǰ���� �̿��ؼ� size, color ���� ���� ����Ʈ�� �̾ƿ��� �޼ҵ� single.jsp[size, color select]�� ���
	public List<String> colorList(String title){
		return dao.colorList(title);
	}
	////////////////////////////////////////////////
	//��ǰ���� �̿��ؼ� size ����Ʈ
	public List<String> sizeList(String title){
		return dao.sizeList(title);
	}
}
