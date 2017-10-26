package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import vo.Article;
import vo.Product;;

public class ProductDao {
	///////////////////////////////////////////////////////////////////
	// DB 연결, 해제 관련 필드와 메소드들
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	///////////////////////////////////////////////////////////////////
	// singleton
	private static ProductDao instance;

	public static ProductDao getInstance() {
		if (instance == null) {
			instance = new ProductDao();
		}
		return instance;
	}

	private ProductDao() {
		DBUtil.loadDriver();
	}


	////////////////////////////////////////////////////////////////////
	// 상품 입력
	public int insert(Product product) {
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO PRODUCT(TITLE, PRICE, COLOR, SIZE, LARGE_CATEGORY, MIDDLE_CATEGORY, DATE, STOCK) VALUES(?,?,?,?,?,?,?,?)";
		int result = 0;

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, product.getTitle());
			pstmt.setInt(2, product.getPrice());
			pstmt.setString(3, product.getColor());
			pstmt.setString(4, product.getSize());
			pstmt.setString(5, product.getLarge_Category());
			pstmt.setString(6, product.getMiddle_Category());
			pstmt.setTimestamp(7, new Timestamp(product.getRegisterTime().getTime()));
			pstmt.setInt(8, product.getStock());

			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Product dao insert 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}

	///////////////////////////////////////////////////////////////////////
	// Single페이지 상품 선택
	public List<Product> selectBestProduct() {
		con = DBUtil.makeConnection();
		String sql = "SELECT TITLE, PRICE, COLOR, SIZE, LARGE_CATEGORY, MIDDLE_CATEGORY FROM PRODUCT ORDER BY PRODUCT_NUM ASC LIMIT 6";
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
				product.setLarge_Category(rs.getString(5));
				product.setMiddle_Category(rs.getString(6));
				
				productList.add(product);
			}
		} catch (SQLException e) {
			System.out.println("dao selectBestProduct 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return productList;
	}
	///////////////////////////////////////////////////////////////////////////////
	public List<Product> selectRecentProduct() {
		con = DBUtil.makeConnection();
		String sql = "SELECT TITLE, PRICE, COLOR, SIZE, LARGE_CATEGORY, MIDDLE_CATEGORY FROM PRODUCT ORDER BY DATE DESC LIMIT 6";
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
				product.setLarge_Category(rs.getString(5));
				product.setMiddle_Category(rs.getString(6));
				
				productList.add(product);
			}
		} catch (SQLException e) {
			System.out.println("dao selectRecentProduct 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return productList;
	}
	///////////////////////////////////////////////////////////////////////////////
	public Product selectProduct(String title) {
		con = DBUtil.makeConnection();
		String sql = "SELECT TITLE, PRICE, COLOR, SIZE, LARGE_CATEGORY, MIDDLE_CATEGORY FROM PRODUCT WHERE TITLE=?";
		Product product = new Product();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, title);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				product.setTitle(rs.getString(1));
				product.setPrice(rs.getInt(2));
				product.setColor(rs.getString(3));
				product.setSize(rs.getString(4));
				product.setLarge_Category(rs.getString(5));
				product.setMiddle_Category(rs.getString(6));
				
			}
		} catch (SQLException e) {
			System.out.println("dao selectProduct 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		
		return product;
	}
	///////////////////////////////////////////////////////////////////////////////
	public List<Product> selectMiddleCategory(String middleCategory) {
		con = DBUtil.makeConnection();
		String sql = "SELECT TITLE, PRICE, LARGE_CATEGORY, MIDDLE_CATEGORY FROM PRODUCT WHERE MIDDLE_CATEGORY=?";
		List<Product> productList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, middleCategory);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				Product product = new Product();
				product.setTitle(rs.getString(1));
				product.setPrice(rs.getInt(2));
				product.setLarge_Category(rs.getString(3));
				product.setMiddle_Category(rs.getString(4));
				
				productList.add(product);
			}
		} catch (SQLException e) {
			System.out.println("dao selectMiddleCategory 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return productList;
	}
	///////////////////////////////////////////////////////////////////////////////
	public List<Product> selectLargeCategory(String largeCategory) {
		con = DBUtil.makeConnection();
		String sql = "SELECT TITLE, PRICE, LARGE_CATEGORY, MIDDLE_CATEGORY FROM PRODUCT WHERE LARGE_CATEGORY=?";
		List<Product> productList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, largeCategory);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				Product product = new Product();
				product.setTitle(rs.getString(1));
				product.setPrice(rs.getInt(2));
				product.setLarge_Category(rs.getString(3));
				product.setMiddle_Category(rs.getString(4));
				
				productList.add(product);
			}
		} catch (SQLException e) {
			System.out.println("dao selectLargeCategory 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return productList;
	}
	//////////////////////////////////////
	//아이디를 이용해서 장바구니에서 상품조회하는 메소드
	public List<Integer> cartList(String id){
		con = DBUtil.makeConnection();
		List<Integer> numList = new ArrayList<>();
		String sql = "SELECT PRODUCT_NUM FROM MYCART WHERE USER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				numList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Product Dao cartList 에러");
			e.printStackTrace();
		}finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return numList;
	}
	///////////////////////////////////////
	//List에 담긴 상품번호를 이용해서 여러번 상품 조회하는 메소드
	public Product cartProduct(int i){
		con = DBUtil.makeConnection();
		String sql = "SELECT PRODUCT_NUM, TITLE, PRICE, COLOR, SIZE, LARGE_CATEGORY,"
				+ " MIDDLE_CATEGORY FROM PRODUCT WHERE PRODUCT_NUM=?";
		Product product = new Product();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery(); // SQL 실행

			if(rs.next()) {
				product.setProduct_num(rs.getInt(1));
				product.setTitle(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setColor(rs.getString(4));
				product.setSize(rs.getString(5));
				product.setLarge_Category(rs.getString(6));
				product.setMiddle_Category(rs.getString(7));
			}
		} catch (SQLException e) {
			System.out.println("dao productList[장바구니] 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return product;
	}
	
	///////////////////////////////////////////
	//해당 아이디 장바구니 목록이 몇개인지
	public int cartCount(String id){
		con = DBUtil.makeConnection();
		int count = 0;
		String sql = "SELECT COUNT(*) FROM MYCART WHERE USER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Product Dao cartCount 에러");
			e.printStackTrace();
		}finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return count;
	}
}
