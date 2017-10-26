package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import vo.MyCart;
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
	public List<Product> selectMiddleCategory(String middleCategory, int startRow, int count) {
		con = DBUtil.makeConnection();
<<<<<<< HEAD
		String sql = "SELECT PRODUCT_NUM, TITLE, PRICE, LARGE_CATEGORY, MIDDLE_CATEGORY FROM PRODUCT WHERE MIDDLE_CATEGORY=?";
=======
		String sql = "SELECT TITLE, PRICE, LARGE_CATEGORY, MIDDLE_CATEGORY FROM PRODUCT WHERE MIDDLE_CATEGORY=? ORDER BY PRODUCT_NUM DESC LIMIT ?,?";
>>>>>>> c9231304ba1b780056b14bf6d7667ed4d913228f
		List<Product> productList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, middleCategory);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, count);
			rs = pstmt.executeQuery(); // SQL 실행

			while (rs.next()) {
				Product product = new Product();
<<<<<<< HEAD
				product.setProduct_num(rs.getInt(1));
				product.setTitle(rs.getString(2));
				product.setPrice(rs.getInt(3));
				product.setLarge_Category(rs.getString(4));
				product.setMiddle_Category(rs.getString(5));
				
=======
				product.setTitle(rs.getString(1));
				product.setPrice(rs.getInt(2));
				product.setLarge_Category(rs.getString(3));
				product.setMiddle_Category(rs.getString(4));

>>>>>>> c9231304ba1b780056b14bf6d7667ed4d913228f
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
	public List<Product> selectLargeCategory(String largeCategory, int startRow, int count) {
		con = DBUtil.makeConnection();
		String sql = "SELECT TITLE, PRICE, LARGE_CATEGORY, MIDDLE_CATEGORY FROM PRODUCT WHERE LARGE_CATEGORY=? ORDER BY PRODUCT_NUM DESC LIMIT ?,?";
		List<Product> productList = new ArrayList<>();

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, largeCategory);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, count);
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
<<<<<<< HEAD
	//아이디를 이용해서 장바구니에서 상품번호 및 수량 조회하는 메소드
	public List<Integer> cartList(String id){
=======
	// 아이디를 이용해서 장바구니에서 상품조회하는 메소드
	public List<Integer> cartList(String id) {
>>>>>>> c9231304ba1b780056b14bf6d7667ed4d913228f
		con = DBUtil.makeConnection();
		List<Integer> numList = new ArrayList<>();
		String sql = "SELECT PRODUCT_NUM FROM MYCART WHERE USER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				numList.add(rs.getInt(1));
			}
		} catch (SQLException e) {
			System.out.println("Product Dao cartList 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return numList;
	}

	///////////////////////////////////////
	// List에 담긴 상품번호를 이용해서 여러번 상품 조회하는 메소드
	public Product cartProduct(int i) {
		con = DBUtil.makeConnection();
		String sql = "SELECT PRODUCT_NUM, TITLE, PRICE, COLOR, SIZE, LARGE_CATEGORY,"
				+ " MIDDLE_CATEGORY FROM PRODUCT WHERE PRODUCT_NUM=?";
		Product product = new Product();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, i);
			rs = pstmt.executeQuery(); // SQL 실행

			if (rs.next()) {
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
	// 해당 아이디 장바구니 목록이 몇개인지
	public int cartCount(String id) {
		con = DBUtil.makeConnection();
		int count = 0;
		String sql = "SELECT COUNT(*) FROM MYCART WHERE USER=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				count = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Product Dao cartCount 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return count;
	}

	///////////////////////////////////////////////////////////////////////////////
	public int selectProductCount() {
		con = DBUtil.makeConnection();
		String sql = "SELECT COUNT(*) FROM PRODUCT";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery(); // sql 실행

			// 결과 숫자 하나 얻기
			rs.next();
			result = rs.getInt(1);
		} catch (SQLException e) {
			System.out.println("dao count 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closeCon(con);
		
		}
		return result;
	}
	
	///////////////////////////////////////////////
	//장바구니 삭제
	public int cartDelete(String id, int productNum) {
		con = DBUtil.makeConnection();
		int result = 0;
		String sql = "DELETE FROM MYCART WHERE USER=? AND PRODUCT_NUM=?";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, id);
			pstmt.setInt(2, productNum);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Product Dao cartDelete 에러");
			e.printStackTrace();
		}finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}

	/////////////////////////////////////////////////
	//장바구니 추가 메소드
	public void insertCart(int quantity, int productNum ,String id){
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO MYCART(CART_QUANTITY, PRODUCT_NUM, USER)"
				+ " VALUES(?,?,?)";
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, quantity);
			pstmt.setInt(2, productNum);
			pstmt.setString(3, id);
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Product Dao cartNum 에러");
			e.printStackTrace();
		}finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
	}
	/////////////////////////////////////////////////
	//장바구니 수량 추가 메소드
	public int quantityPlus(int quantity,int productNum,String id){
		con = DBUtil.makeConnection();
		int result = 0;
		String sql = "UPDATE MYCART SET CART_QUANTITY = ? + 1 "
				+ " WHERE USER=? AND PRODUCT_NUM=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, quantity);
			pstmt.setString(2, id);
			pstmt.setInt(3, productNum);
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Product Dao quantityPlus 에러");
			e.printStackTrace();
		}finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	////////////////////////////////////////////////////
	//장바구니 수량 조회 메소드
	public int quantityCheck(String id, int productNum){
		con = DBUtil.makeConnection();
		int quantity = 0;
		String sql = "SELECT CART_QUANTITY FROM MYCART WHERE USER=? AND PRODUCT_NUM=?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setInt(2, productNum);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				quantity = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("Product Dao quantityCheck 에러");
			e.printStackTrace();
		}finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return quantity;
	}
<<<<<<< HEAD
=======
<<<<<<< HEAD
	//////////////////////////////////////////////////////
	//장바구니에서 수량과 상품번호를 List로 담는거
	public List<MyCart> quantityList(String id){
		con = DBUtil.makeConnection();
		List<MyCart> mycartList = new ArrayList<>();
		String sql = "SELECT CART_QUANTITY, PRODUCT_NUM FROM MYCART WHERE USER=?";
		MyCart cart = new MyCart();
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				cart.setCart_quantity(rs.getInt(1));
				cart.setProduct_num(rs.getInt(2));
				
				mycartList.add(cart);
			}
		} catch (SQLException e) {
			System.out.println("Product Dao mycartList 에러");
			e.printStackTrace();
		}finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return mycartList;
	}
=======
>>>>>>> ac9e988fda9e41e925d9c1693638dd9e4aa8642d
>>>>>>> c9231304ba1b780056b14bf6d7667ed4d913228f
>>>>>>> b9de29620abab00753b05c65913686da0b69950d
}
