package vo;

import java.util.List;

public class ProductPage {
	private List<Product> productList;
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
//////////////////////////////////////////////////////
	
	
	public ProductPage(List<Product> productList, int startPage, int endPage, int currentPage, int totalPage) {
		super();
		this.productList = productList;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	
	public ProductPage() {
	}
	
	
//////////////////////////////////////////////////////
	public List<Product> getProductList() {
		return productList;
	}
	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
//////////////////////////////////////////////////////
	
	
	
	@Override
	public String toString() {
		return "ProductPage [productList=" + productList + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", currentPage=" + currentPage + ", totalPage=" + totalPage + "]";
	}
	
	
	
	

}
