package vo;

public class MyCart {
	
	private int cart_quantity;
	private int product_num;
	private String user;
	
	public int getCart_quantity() {
		return cart_quantity;
	}
	public void setCart_quantity(int cart_quantity) {
		this.cart_quantity = cart_quantity;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public MyCart(int cart_quantity, int product_num, String user) {
		this.cart_quantity = cart_quantity;
		this.product_num = product_num;
		this.user = user;
	}
	public MyCart() {
		
	}
	@Override
	public String toString() {
		return "MyCart [cart_quantity=" + cart_quantity + ", product_num=" + product_num + ", user=" + user + "]";
	}

	/////////////////////////////////////////////////////////////

}
