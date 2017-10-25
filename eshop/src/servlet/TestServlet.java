package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.MemberService;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	MemberService service = MemberService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String task = req.getParameter("task");
		String path = "";
		if(task.equals("editaccount")) {
			//dao에서 id가 AA인 정보 가져온 뒤 Setattribute함[멤버 객체 하나]
			
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
			//MemberVo 객체 생성 후 set으로 값 넣어주고
			System.out.println("ID : " +req.getParameter("userid"));
			System.out.println("PW : " +req.getParameter("userpw"));
			System.out.println("NAME : " +req.getParameter("username"));
			req.getParameter("userphone");
			req.getParameter("useraddress");
			req.getParameter("useremail");
			
			//service에서 회원수정 작업 수행 시킴
			
			path="index.jsp";
		}else if(task.equals("editCheck")) {
			//입력받은 id는 DB에서 패스워드 검색용, 입력받은 pw는 검색된 pw와 비교용(service에서 실행)
			//정보 수정하기 전 비밀번호 확인[일치 시  정보수정 폼으로 연결]
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			
			if(service.loginPwCheck(id, pw)) {
				
				req.setAttribute("memberInfo", service.memberInfo(id));
				path ="editaccount.jsp";
			}
		}else if(task.equals("delete")) {
			//계정 삭제
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
}
