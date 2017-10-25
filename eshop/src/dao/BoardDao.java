package dao;

import java.sql.*;

import vo.Article;

public class BoardDao {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	private static BoardDao instance = new BoardDao();
	public static BoardDao getInstance() {
		return instance;
	}
	private BoardDao(){
		DBUtil.loadDriver();
	}
	
	public int insert(Article article) {
		con=DBUtil.makeConnection();
		
		String sql="INSERT INTO BOARD(BOARD_NAME,TITLE,WRITER,READ_COUNT,WRITE_DATE,CONTENTS,LIST,DEPTH)"
				+ " VALUES(?,?,?,?,?,?,?,?)" ;
		int result=0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,article.getBoardName());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getWriter());
			pstmt.setInt(4, article.getReadCount());
			pstmt.setTimestamp(5, new Timestamp(article.getWriteTime().getTime()));
			pstmt.setString(6, article.getContents());
			pstmt.setInt(7, article.getList());
			pstmt.setString(8, article.getDepth());
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeCon(con);
			DBUtil.closePstmt(pstmt);
		}
		return result;
	}
}
