package service;

import java.util.List;

import dao.BoardDao;
import dao.BuylistDao;
import dao.MemberDao;
import dao.ProductDao;
import vo.Member;
import vo.MyCart;

public class MemberService {
	private MemberDao dao = MemberDao.getInstance();
	//////////////////////////////////////////////////////////////////
	// singleton
	private static MemberService instance;

	public static MemberService getInstance() {
		if (instance == null)
			instance = new MemberService();
		return instance;
	}

	private MemberService() {
	}

	//////////////////////////////////////////////////////////////////
	public boolean joinMember(Member member) {
		if (dao.insert(member) > 0) {
			return true;
		} else {
			return false;
		}
	}

	public String login(String id, String pw) {
		String loginId = dao.selectIdUsingIdPw(id, pw);
		return loginId;
	}

	public String loginIdCheck(String id) {
		System.out.println("id:"+id+".");
		String idCheck = dao.selectIdCheck(id);
		return idCheck;
	}

	public boolean loginPwCheck(String id, String pw) {
		String checkPw = dao.selectPwCheck(id);
		System.out.println("[loginPwCheck] checkPw : "+checkPw);
		System.out.println("[loginPwCheck] pw : "+pw);
		System.out.println("[loginPwCheck] id : "+id);
		if (checkPw.equals(pw)) {
			return true;
		}
		return false;
	}

	public Member memberInfo(String id) {
		return dao.selectUserInfo(id);
	}

	public boolean memberUpdate(Member member) {
		if (dao.memberUpdate(member) == 1) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean deleteMember(String id) {
		ProductDao.getInstance().cartAllDelete(id);
		BuylistDao.getInstance().deleteBuylist(id);
		BoardDao.getInstance().deleteAllbyID(id);
		if(dao.deleteMember(id)==1) {
			return true;
		}else {
			return false;
		}
	}
	
}
