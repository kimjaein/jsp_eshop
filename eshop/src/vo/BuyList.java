package vo;

import java.sql.Date;

public class BuyList {
	private int buy_list_num;
	private String buyer_id;
	private int product_num;
	private Date buy_date;
	private int buy_quantity;
	
	public BuyList() {
		
	}
	
	public BuyList(int buy_list_num, String buyer_id, int product_num, Date buy_date, int buy_quantity) {
		this.buy_list_num = buy_list_num;
		this.buyer_id = buyer_id;
		this.product_num = product_num;
		this.buy_date = buy_date;
		this.buy_quantity = buy_quantity;
	}
	public int getBuy_list_num() {
		return buy_list_num;
	}
	public void setBuy_list_num(int buy_list_num) {
		this.buy_list_num = buy_list_num;
	}
	public String getBuyer_id() {
		return buyer_id;
	}
	public void setBuyer_id(String buyer_id) {
		this.buyer_id = buyer_id;
	}
	public int getProduct_num() {
		return product_num;
	}
	public void setProduct_num(int product_num) {
		this.product_num = product_num;
	}
	public Date getBuy_date() {
		return buy_date;
	}
	public void setBuy_date(Date buy_date) {
		this.buy_date = buy_date;
	}
	public int getBuy_quantity() {
		return buy_quantity;
	}
	public void setBuy_quantity(int buy_quantity) {
		this.buy_quantity = buy_quantity;
	}
	@Override
	public String toString() {
		return "BuyList [buy_list_num=" + buy_list_num + ", buyer_id=" + buyer_id + ", product_num=" + product_num
				+ ", buy_date=" + buy_date + ", buy_quantity=" + buy_quantity + "]";
	}
	
	
}
