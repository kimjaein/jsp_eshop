package service;

import dao.MemberDao;
import vo.Member;

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
		String idCheck = dao.selectIdCheck(id);
		return idCheck;
	}

	public boolean loginPwCheck(String id, String pw) {
		String checkPw = dao.selectPwCheck(id);
		if (checkPw.equals(pw)) {
			System.out.println("pw value : "+pw);
			System.out.println("checkPw value : "+checkPw);
			System.out.println("service 패스워드 일치");
			return true;
		}
		System.out.println("service 패스워드 불일치");
		return false;
	}

	public Member memberInfo(String id) {
		return dao.selectUserInfo(id);
	}

	public boolean memberUpdate(Member member) {
		if (dao.memberUpdate(member) == 1) {
			System.out.println("정보 수정 성공");
			return true;
		}else {
			return false;
		}
	}
}
