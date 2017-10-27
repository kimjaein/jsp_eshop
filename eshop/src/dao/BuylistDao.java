package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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
	// 상품 구매시 Insert
	public int insertBuyList(Product product, int quantity, String id) {
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO BUY_LIST(BUYER_ID, PRODUCT_TITLE, BUY_DATE, BUY_QUANTITY) VALUES(?,?,?,?)";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, product.getTitle());
			pstmt.setTimestamp(3, new Timestamp(product.getRegisterTime().getTime()));
			pstmt.setInt(4, quantity);

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
	public List<BuyList> selectBuyList(String id, int startRow, int count) {
		con = DBUtil.makeConnection();
		String sql = "SELECT BUY_LIST_NUM, BUYER_ID, PRODUCT_TITLE, BUY_DATE, BUY_QUANTITY FROM BUY_LIST WHERE BUYER_ID=? ORDER BY BUY_LIST_NUM ASC LIMIT ?,?";
		List<BuyList> buyList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, count);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				BuyList list = new BuyList();
				list.setBuy_list_num(rs.getInt(1));
				list.setBuyer_id(rs.getString(2));
				list.setProduct_title(rs.getString(3));
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

	///////////////////////////////////////////////////////////////////////
	// Single페이지 상품 선택
	public List<BuyList> selectOnlyList(String id) {
		con = DBUtil.makeConnection();
		String sql = "SELECT BUY_LIST_NUM, BUYER_ID, PRODUCT_TITLE, BUY_DATE, BUY_QUANTITY FROM BUY_LIST WHERE BUYER_ID=?";
		List<BuyList> buyList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				BuyList list = new BuyList();
				list.setBuy_list_num(rs.getInt(1));
				list.setBuyer_id(rs.getString(2));
				list.setProduct_title(rs.getString(3));
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
	public int deleteBuylist(String id) {
		con = DBUtil.makeConnection();
		String sql = "DELETE FROM BUY_LIST WHERE BUYER_ID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("dao buylist delete 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}

	public int countBuyList(String id) {
		con = DBUtil.makeConnection();
		String sql = "SELECT COUNT(*) FROM BUY_LIST WHERE BUYER_ID=?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("[BuyListDao select Count 에러]");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
}
