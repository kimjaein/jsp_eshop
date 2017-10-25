package vo;

import java.sql.Timestamp;
import java.util.Date;

public class Product {
	private int product_num;
	private String title;
	private int price;
	private String color;
	private String size;
	private String large_Category;
	private String middle_Category;
	private Date registerTime;
	private int stock;

	public Product(int product_num, String title, int price, String color, String size, String large_Category,
			String middle_Category, Timestamp registerTime, int stock) {
		super();
		this.product_num = product_num;
		this.title = title;
		this.price = price;
		this.color = color;
		this.size = size;
		this.large_Category = large_Category;
		this.middle_Category = middle_Category;
		this.registerTime = registerTime;
		this.stock = stock;
	}
	
	public Product() {
	}
	///////////////////////////////////////////////////////////////////////////////////////////////
	public int getProduct_num() {
		return product_num;
	}

	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getLarge_Category() {
		return large_Category;
	}

	public void setLarge_Category(String large_Category) {
		this.large_Category = large_Category;
	}

	public String getMiddle_Category() {
		return middle_Category;
	}

	public void setMiddle_Category(String middle_Category) {
		this.middle_Category = middle_Category;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////



	///////////////////////////////////////////////////////////////////////////////////////////////
	@Override
	public String toString() {
		return "Product [product_num=" + product_num + ", title=" + title + ", price=" + price + ", color=" + color
				+ ", size=" + size + ", large_Category=" + large_Category + ", middle_Category=" + middle_Category
				+ ", registerTime=" + registerTime + ", stock=" + stock + "]";
	}

}
