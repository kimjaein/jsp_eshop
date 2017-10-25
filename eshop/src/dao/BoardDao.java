package dao;

import java.sql.*;
import java.util.*;

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
				+ " VALUES(?,?,?,?,?,?,?,?)";
		int result=0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,article.getBoardName());
			pstmt.setString(2, article.getTitle());
			pstmt.setString(3, article.getWriter());
			pstmt.setInt(4, article.getReadCount());
			pstmt.setTimestamp(5, new Timestamp(article.getWriteDate().getTime()));
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
	public int selectArticleCount(String type) {
		con=DBUtil.makeConnection();
		String sql="select count(article_num) from board where board_Name=?";
		
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, type);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				result=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeCon(con);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeRs(rs);
		}
		return result;
	}
	
	public List<Article> selectArticleList(int startRow ,int count,String boardName){
		con=DBUtil.makeConnection();
		String sql="SELECT ARTICLE_NUM,TITLE,WRITER,CONTENTS,WRITE_DATE,READ_COUNT,LIST,DEPTH FROM BOARD where board_name=?"
				+ "ORDER BY LIST DESC, DEPTH ASC LIMIT ?,?";
		List<Article> articleList =new ArrayList<>();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1, boardName);
			pstmt.setInt(2, startRow);
			pstmt.setInt(3, count);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Article article = new Article();
				article.setArticleNum(rs.getInt(1));
				article.setTitle(rs.getString(2));
				article.setWriter(rs.getString(3));
				article.setContents(rs.getString(4));
				article.setWriteDate(rs.getDate(5));
				article.setReadCount(rs.getInt(6));
				article.setList(rs.getInt(7));
				article.setDepth(rs.getString(8));
				
				articleList.add(article);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeCon(con);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeRs(rs);
		}
		
		return articleList;
	}
	
	public Article selectArticle(int articleNum) {
		con=DBUtil.makeConnection();
		
		String sql="SELECT TITLE,WRITER,CONTENTS,WRITE_DATE,READ_COUNT,LIST,DEPTH FROM BOARD where article_num=?";
		Article article = new Article();
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, articleNum);

			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				article.setArticleNum(articleNum);
				article.setTitle(rs.getString(1));
				article.setWriter(rs.getString(2));
				article.setContents(rs.getString(3));
				article.setWriteDate(rs.getDate(4));
				article.setReadCount(rs.getInt(5));
				article.setList(rs.getInt(6));
				article.setDepth(rs.getString(7));
				
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeCon(con);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeRs(rs);
		}
		return article;
	}
	
	public int updateReadCount(int articleNum) {
		con = DBUtil.makeConnection();
		String sql ="update board set read_count=read_count+1 where article_num=?";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,articleNum);
			
			result =pstmt.executeUpdate();
			
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
