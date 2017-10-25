package vo;

import java.util.List;

public class ProductList {
	private List<Product> productList;
	
	public ProductList(List<Product> productList) {
		this.productList = productList;
	}
	

	public ProductList() {}
//////////////////////////////////////////////////////////
	
	public List<Product> getProductList() {
		return productList;
	}
	
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}


	
//////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return "ProductList [productList=" + productList + "]";
	}
	

}
