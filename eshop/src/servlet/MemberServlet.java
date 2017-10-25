package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.MemberService;
import vo.Member;

@WebServlet("/member")
public class MemberServlet extends HttpServlet{
	private MemberService service = MemberService.getInstance();
///////////////////////////////////////////////////////////////////
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task = request.getParameter("task");
		String path = "index.jsp";		
		
//		if(task.equals("joinForm")) {
//			path = "join_form.jsp";
//		}
//		else if(task.equals("loginForm")) {
//			path = "login_form.jsp";
//		}
//		else if(task.equals("logoutForm")) {
//			path = "logout_form.jsp";
//		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String task = request.getParameter("task");
		String path = "";
		
		if(task.equals("join")) {
			Member member = new Member();
			member.setId(request.getParameter("id"));
			member.setPw(request.getParameter("pw"));
			member.setName(request.getParameter("name"));
			member.setphone(request.getParameter("phone"));
			member.setAddress(request.getParameter("address"));
			member.setEmail(request.getParameter("email"));
			
			if(service.joinMember(member)) {
				path = "account.jsp";
			} 
//			else {
//				path = "join_fail.jsp";
//			}
		} else if(task.equals("login")) {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String loginId = service.login(id, pw);
			if(loginId!=null) {
				// 로그인 된 아이디를 세션에 저장
				HttpSession session = request.getSession();
				session.setAttribute("loginId", loginId);
				path = "index.jsp";
			}
//			else {
//				path = "login_fail.jsp";
//			}
		} else if(task.equals("loginIdCheck")) {
			String id = request.getParameter("id");
			String idCheck = service.loginIdCheck(id);
			response.setContentType("text/json;charset=euc-kr");
			response.getWriter().print(idCheck);
			return;
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
}













