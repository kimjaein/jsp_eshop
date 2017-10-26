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
			// MemberVo 객체 생성 후 set으로 값 넣어주고
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
				req.setAttribute("msg", "수정 완료");
				path = "mypage.jsp";
			} else {
				req.setAttribute("msg", "정보 수정 실패");
				path = "mypage.jsp";
			}
			// service에서 회원수정 작업 수행 시킴
		} else if (task.equals("editCheck")) {
			// 입력받은 id는 DB에서 패스워드 검색용, 입력받은 pw는 검색된 pw와 비교용(service에서 실행)
			// 정보 수정하기 전 비밀번호 확인[일치 시 정보수정 폼으로 연결]
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			System.out.println("[editCheck]" + "id : "+id + "/ pw : "+pw);
			// 받아온 id와 pw값이 빈 값이 아니면
			if (id != null && id.length() > 0 && pw != null && pw.length() > 0) {
				// 해당 id의 pw와 DB에 있는 pw와 비교값이 참이면
				if (service.loginPwCheck(id, pw)) {
					// MemberInfo에 id로 검색한 정보를 넣는다
					Member memberInfo = service.memberInfo(id);
					req.setAttribute("memberInfo", memberInfo);
					req.setAttribute("msg", "정보 일치");
					path = "editaccount.jsp";
				} else {
					// 비밀번호 일치하지 않음
					req.setAttribute("msg", "비밀번호 일치하지 않음");
					path = "mypage.jsp";
				}
			} else {
				// id나 pw값이 빈값임
				req.setAttribute("msg", "ID나 PW가 NULL값임");
				path = "mypage.jsp";
			}
		} else if (task.equals("delete")) {
			// 계정 삭제
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			if(service.loginPwCheck(id, pw)){
				service.deleteMember(id);
				HttpSession session = req.getSession();
				session.removeAttribute("loginId");
				req.setAttribute("msg", "삭제 완료");
				path ="mypage.jsp";
			}else {
				req.setAttribute("msg", "삭제 실패");
				path = "mypage.jsp";
			}
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
}
