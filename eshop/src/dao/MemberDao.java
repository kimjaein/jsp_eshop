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
	// DB ����, ���� ���� �ʵ�� �޼ҵ��
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
////////////////////////////////////////////////////////////////////
	// SQL ���� �޼ҵ�
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
			System.out.println("Member dao insert ����");
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
			System.out.println("member dao select ����");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	/////////////////////////////////////////
	//���̵� ��ġ ����
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
			System.out.println("member dao idCheck ����");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return result;
	}
	/////////////////////////////////////////
	//��й�ȣ ��ġ ����
	public String selectPwCheck(String id) {
		con = DBUtil.makeConnection();
		String sql = "SELECT PASSWORD FROM MEMBER WHERE ID=?";
		String result = null;
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				result = rs.getString(1);
			}
		} catch (SQLException e) {
			System.out.println("member dao pwCheck ����");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		System.out.println("dao password value : "+result);
		return result;
	}
	/////////////////////////////////////////
	//���� ���� ��ȸ
	public Member selectUserInfo(String id) {
		con = DBUtil.makeConnection();
		String sql = "SELECT ID, NAME, PHONE, ADDRESS, EMAIL_ADDRESS FROM MEMBER WHERE ID=?";
		Member member=new Member();
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				member.setId(rs.getString(1));
				member.setName(rs.getString(2));
				member.setphone(rs.getString(3));
				member.setAddress(rs.getString(4));
				member.setEmail(rs.getString(5));
			}
		} catch (SQLException e) {
			System.out.println("member dao selectUserInfo ����");
			e.printStackTrace();
		} finally {
			DBUtil.closeRs(rs);
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		return member;
	}
	/////////////////////////////////////////
	//���� ����
	public int memberUpdate(Member member) {
		con = DBUtil.makeConnection();
		String sql = "UPDATE MEMBER SET PASSWORD=?,NAME=?,PHONE=?,ADDRESS=?,EMAIL_ADDRESS=? WHERE ID = ?";
		int result = 0;
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getPw());
			pstmt.setString(2, member.getName());
			pstmt.setString(3, member.getphone());
			pstmt.setString(4, member.getAddress());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getId());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("dao memberUpdate ����");
			e.printStackTrace();
		}finally {
			DBUtil.closePstmt(pstmt);
			DBUtil.closeCon(con);
		}
		System.out.println("dao update result value : "+result);
		return result;
	}
}















