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
			//dao���� id�� AA�� ���� ������ �� Setattribute��[��� ��ü �ϳ�]
			
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
			//MemberVo ��ü ���� �� set���� �� �־��ְ�
			System.out.println("ID : " +req.getParameter("userid"));
			System.out.println("PW : " +req.getParameter("userpw"));
			System.out.println("NAME : " +req.getParameter("username"));
			req.getParameter("userphone");
			req.getParameter("useraddress");
			req.getParameter("useremail");
			
			//service���� ȸ������ �۾� ���� ��Ŵ
			
			path="�����Ϸ��";
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
}
