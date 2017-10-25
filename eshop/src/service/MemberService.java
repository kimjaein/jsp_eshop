package service;

import dao.MemberDao;
import vo.Member;

public class MemberService {
	private MemberDao dao = MemberDao.getInstance();
//////////////////////////////////////////////////////////////////
	//singleton
	private static MemberService instance;
	public static MemberService getInstance() {
		if(instance==null)
			instance = new MemberService();
		return instance;
	}
	private MemberService() {}
//////////////////////////////////////////////////////////////////
	public boolean joinMember(Member member) {
		if(dao.insert(member)>0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public String login(String id, String pw) {
		String loginId = dao.selectIdUsingIdPw(id,pw);
		return loginId;
	}
	
	public String loginIdCheck(String id) {
		String idCheck = dao.selectIdCheck(id);
		return idCheck;
	}
	public boolean loginPwCheck(String id, String pw) {
		if(dao.selectPwCheck(id).equals(pw)) {
			return true;
		}
		return false;
	}
	
	public Member memberInfo(String id) {
		if(id != null && id.isEmpty()) {
			return dao.selectUserInfo(id);
		}else {
			return null;
		}
	}
}
