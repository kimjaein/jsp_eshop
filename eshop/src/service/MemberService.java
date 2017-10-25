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
		if(id != null && id.length()>0) {
			System.out.println("���̵� ���� ���� �ƴϸ�");
			return dao.selectUserInfo(id);
		}else {
			System.out.println("���̵��� ���̸�");
			return null;
		}
	}
	
	public boolean memberUpdate(Member member) {
		if(member != null) {
			if(dao.memberUpdate(member)==1)
				System.out.println("���� ���� ����");
			return true;
		}
		System.out.println("���� ���� ����");
		return false;
	}
}
