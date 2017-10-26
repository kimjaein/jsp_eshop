package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.Response;

import service.MemberService;
import vo.BuyList;
import vo.Member;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	MemberService service = MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		String task = req.getParameter("task");
		String path = "";
		if(task == null || task.isEmpty()){
			path="mypage.jsp";
		}else if (task.equals("editaccount")) {
			path = "editaccountform.jsp";
		}else if(task.equals("buylist")) {
			String id = req.getParameter("id");
			List <BuyList> buylist=dao.BuylistDao.getInstance().selectBuyList(id);
			req.setAttribute("buylist", buylist);
			
			path="buylist.jsp";
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		String task = req.getParameter("task");
		String path = "";
		if (task.equals("edit")) {
			// MemberVo ��ü ���� �� set���� �� �־��ְ�
			Member member = new Member();
			member.setId(req.getParameter("userid"));
			member.setPw(req.getParameter("userpw1"));
			member.setName(req.getParameter("username"));
			member.setphone(req.getParameter("userphone"));
			member.setAddress(req.getParameter("useraddress"));
			member.setEmail(req.getParameter("useremail"));
			
			System.out.println("name : "+member.getName());
			System.out.println("address : "+member.getAddress());
			System.out.println("email : "+member.getEmail());
			
			if (service.memberUpdate(member)) {
				req.setAttribute("msg", "���� �Ϸ�");
				path = "mypage.jsp";
			} else {
				req.setAttribute("msg", "���� ���� ����");
				path = "mypage.jsp";
			}
			// service���� ȸ������ �۾� ���� ��Ŵ
		} else if (task.equals("editCheck")) {
			// �Է¹��� id�� DB���� �н����� �˻���, �Է¹��� pw�� �˻��� pw�� �񱳿�(service���� ����)
			// ���� �����ϱ� �� ��й�ȣ Ȯ��[��ġ �� �������� ������ ����]
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			System.out.println("[editCheck]" + "id : "+id + "/ pw : "+pw);
			// �޾ƿ� id�� pw���� �� ���� �ƴϸ�
			if (id != null && id.length() > 0 && pw != null && pw.length() > 0) {
				// �ش� id�� pw�� DB�� �ִ� pw�� �񱳰��� ���̸�
				if (service.loginPwCheck(id, pw)) {
					// MemberInfo�� id�� �˻��� ������ �ִ´�
					Member memberInfo = service.memberInfo(id);
					req.setAttribute("memberInfo", memberInfo);
					req.setAttribute("msg", "���� ��ġ");
					path = "editaccount.jsp";
				} else {
					// ��й�ȣ ��ġ���� ����
					req.setAttribute("msg", "��й�ȣ ��ġ���� ����");
					path = "mypage.jsp";
				}
			} else {
				// id�� pw���� ����
				req.setAttribute("msg", "ID�� PW�� NULL����");
				path = "mypage.jsp";
			}
		} else if (task.equals("delete")) {
			// ���� ����
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			if(service.loginPwCheck(id, pw)){
				service.deleteMember(id);
				HttpSession session = req.getSession();
				session.removeAttribute("loginId");
				req.setAttribute("msg", "���� �Ϸ�");
				path ="mypage.jsp";
			}else {
				req.setAttribute("msg", "���� ����");
				path = "mypage.jsp";
			}
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
}
