package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;
import vo.Member;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	MemberService service = MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String task = req.getParameter("task");
		String path = "";
		if(task.equals("editaccount")) {
			path ="editaccountform.jsp";
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String task = req.getParameter("task");
		String path ="";
		if(task.equals("edit")) {
			//MemberVo ��ü ���� �� set���� �� �־��ְ�
			Member member = new Member();
			member.setId(req.getParameter("userid"));
			member.setPw(req.getParameter("userpw"));
			member.setName(req.getParameter("username"));
			member.setphone(req.getParameter("userphone"));
			member.setAddress(req.getParameter("useraddress"));
			member.setEmail(req.getParameter("useremail"));
			
			if(service.memberUpdate(member)) {
				path="index.jsp";
			}else {
				return;
			}
			//service���� ȸ������ �۾� ���� ��Ŵ
		}else if(task.equals("editCheck")) {
			//�Է¹��� id�� DB���� �н����� �˻���, �Է¹��� pw�� �˻��� pw�� �񱳿�(service���� ����)
			//���� �����ϱ� �� ��й�ȣ Ȯ��[��ġ ��  �������� ������ ����]
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			if(id != null && id.length()>0 && pw != null &&pw.length()>0) {
				if(service.loginPwCheck(id, pw)) {
					Member memberInfo = service.memberInfo(id);
					req.setAttribute("memberInfo", memberInfo);
					path ="editaccount.jsp";
				}else {
					path="mypage.jsp";
				}
				return;
			}
		}else if(task.equals("delete")) {
			//���� ����
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
}
