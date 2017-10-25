package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import vo.Member;

public class MemberDao {
///////////////////////////////////////////////////////////////////
	// singleton
	private static MemberDao instance;
	public static MemberDao getInstance() {
		if(instance == null) {
			instance = new MemberDao();
		}
		return instance;
	}
	private MemberDao(){
		DBUtil.loadDriver();
	}
///////////////////////////////////////////////////////////////////
	// DB 연결, 해제 관련 필드와 메소드들
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
////////////////////////////////////////////////////////////////////
	// SQL 실행 메소드
	public int insert(Member member) {
		con = DBUtil.makeConnection();
		String sql = "INSERT INTO MEMBER(ID, PASSWORD, NAME, PHONE, ADDRESS, EMAIL_ADDRESS) "
					 + "VALUES(?,?,?,?,?,?)";
		int result = 0;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPw());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getphone());
			pstmt.setString(5, member.getAddress());
			pstmt.setString(6, member.getEmail());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("Member dao insert 에러");
			e.printStackTrace();
		} finally{
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;	
	}
///////////////////////////////////////////////////////////////////////
	public String selectIdUsingIdPw(String id, String pw) {
		con = DBUtil.makeConnection();
		String sql = "SELECT ID FROM MEMBER WHERE ID=? AND PASSWORD=?";
		String result = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("member dao select 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	public String selectIdCheck(String id) {
		con = DBUtil.makeConnection();
		String sql = "SELECT ID FROM MEMBER WHERE ID=?";
		String result = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("member dao idCheck 에러");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
}















