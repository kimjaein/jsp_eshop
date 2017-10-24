package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String id = req.getParameter("id");
		String path = "";
		if(id.equals("AA")) {
			//dao에서 AA로 되어있는 정보 가져온 뒤 Setattribute함[멤버 객체 하나]
			
			path ="editaccount.jsp";
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");
		String path ="";
		if(action.equals("edit")) {
			//MemberVo 객체 생성 후 set으로 값 넣어주고
			req.getParameter("userid");
			req.getParameter("userpw");
			req.getParameter("username");
			req.getParameter("userphone");
			req.getParameter("useraddress");
			req.getParameter("useremail");
			
			//service에서 회원수정 작업 수행 시킴
			
			path="수정완료다";
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
}
