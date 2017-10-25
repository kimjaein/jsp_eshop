package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import vo.BuyList;
import vo.Product;;

public class BuylistDao {
	///////////////////////////////////////////////////////////////////
	// DB 연결, 해제 관련 필드와 메소드들
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	///////////////////////////////////////////////////////////////////
	// singleton
	private static BuylistDao instance;

	public static BuylistDao getInstance() {
		if (instance == null) {
			instance = new BuylistDao();
		}
		return instance;
	}

	private BuylistDao() {
		DBUtil.loadDriver();
	}


	////////////////////////////////////////////////////////////////////
	// 상품 구매시 Insert **수정전**
	public int insert(BuyList buylist) {
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO BUY_LIST(BUYER_ID, PRODUCT_NUM, BUY_DATE, BUY_QUANTITY) VALUES(?,?,?,?)";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, buylist.getBuyer_id());
			pstmt.setInt(2, buylist.getProduct_num());
			pstmt.setDate(3, buylist.getBuy_date());
			pstmt.setInt(4, buylist.getBuy_quantity());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Buylist dao insert 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}

	///////////////////////////////////////////////////////////////////////
	// Single페이지 상품 선택
	public List<BuyList> selectBuyList(String id) {
		con = DBUtil.makeConnection();
		String sql = "SELECT BUY_LIST_NUM, BUYER_ID, PRODUCT_NUM, BUY_DATE, BUY_QUANTITY FROM BUY_LIST WHERE BUYER_ID=?";
		List<BuyList> buyList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				BuyList list = new BuyList();
				list.setBuy_list_num(rs.getInt(1));
				list.setBuyer_id(rs.getString(2));
				list.setProduct_num(rs.getInt(3));
				list.setBuy_date(rs.getDate(4));
				list.setBuy_quantity(rs.getInt(5));
				buyList.add(list);
			}
		} catch (SQLException e) {
			System.out.println("dao select buylist 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return buyList;
	}
	///////////////////////////////////////////////////////////////////////////////
	public List<Product> selectRecentProduct() {
		con = DBUtil.makeConnection();
		String sql = "SELECT TITLE, PRICE, COLOR, SIZE FROM PRODUCT ORDER BY DATE DESC";
		List<Product> productList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				Product product = new Product();
				product.setTitle(rs.getString(1));
				product.setPrice(rs.getInt(2));
				product.setColor(rs.getString(3));
				product.setSize(rs.getString(4));
				
				productList.add(product);
			}
		} catch (SQLException e) {
			System.out.println("dao selectProductList 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return productList;
	}

	

}
