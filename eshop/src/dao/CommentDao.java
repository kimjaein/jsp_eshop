package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import vo.Comment;

public class CommentDao {
	private static CommentDao instance = new CommentDao();
	public static CommentDao getInstance() {
		return instance;
	}
	private CommentDao() {
		DBUtil.loadDriver();
	}
////////////////////////////////////////////////////////////	
	// DB 연결, 해제 관련 필드와 메소드들
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public int insert(Comment comment) {
		con=DBUtil.makeConnection();
		String sql = "INSERT INTO Comment(PRODUCT_TITLE,WRITER,WRITE_Time,CONTENTS,C_list,C_level) VALUES(?,?,?,?,?,?);";
		//	"update board_list set b_list = article_num where article_num=last_insert_id();";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, comment.getTitle());
			pstmt.setString(2, comment.getWriter());
			pstmt.setTimestamp(3, new Timestamp(comment.getWriteTime().getTime()));
			pstmt.setString(4,comment.getContents());
			pstmt.setInt(5, comment.getC_list());
			pstmt.setString(6, comment.getC_level());
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
	public int selectLastId() {
		con=DBUtil.makeConnection();
		String sql="SELECT comment_num from comment order by comment_num desc limit 1";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				result= rs.getInt(1);
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
	public int insertCList(int last) {
		con=DBUtil.makeConnection();
		String sql = "update comment set c_list = comment_num where comment_num=? order by comment_num desc , c_level asc";
		int result=0;
		try {
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1, last);
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
	
	public List<Comment> selectCommentList(String title) {
		con=DBUtil.makeConnection();
		String sql="SELECT Comment_num,WRITER,CONTENTS,WRITE_Time,c_LIST,c_LEVEL FROM Comment "
				+ "where PRODUCT_TITLE=? ORDER BY c_LIST DESC, c_LEVEL ASC ";
		List<Comment> commentList = new ArrayList<>();
		try {
			pstmt=con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			rs=pstmt.executeQuery();
			
			while(rs.next()) {
				Comment c = new Comment();
				c.setTitle(title);
				c.setCommentNum(rs.getInt(1));
				c.setWriter(rs.getString(2));
				c.setContents(rs.getString(3));
				c.setWriteTime(rs.getDate(4));
				c.setC_list(rs.getInt(5));
				c.setC_level(rs.getString(6));
				
				commentList.add(c);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeCon(con);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeRs(rs);
		}
		return commentList;
		
	}
}
