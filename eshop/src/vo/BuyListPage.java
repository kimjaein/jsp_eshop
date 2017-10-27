package vo;

import java.util.List;

public class BuyListPage {
	private List<BuyList> buylist;
	private int startPage;
	private int endPage;
	private int currentPage;
	private int totalPage;
	public List<BuyList> getBuylist() {
		return buylist;
	}
	public void setBuylist(List<BuyList> buylist) {
		this.buylist = buylist;
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
	@Override
	public String toString() {
		return "BuyListPage [buylist=" + buylist + ", startPage=" + startPage + ", endPage=" + endPage
				+ ", currentPage=" + currentPage + ", totalPage=" + totalPage + "]";
	}
	public BuyListPage(List<BuyList> buylist, int startPage, int endPage, int currentPage, int totalPage) {
		this.buylist = buylist;
		this.startPage = startPage;
		this.endPage = endPage;
		this.currentPage = currentPage;
		this.totalPage = totalPage;
	}
	public BuyListPage() {
		
	}
	
}
