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
		String sql = "SELECT TITLE, PRICE, COLOR, SIZE, LARGE_CATEGORY, MIDDLE_CATEGORY FROM PRODUCT ORDER BY PRICE ASC LIMIT 6";
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
	

	

}
