package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BoardService;
import vo.Article;

@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	private BoardService service = BoardService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("board");
			request.setCharacterEncoding("euc-kr");
			String task=request.getParameter("task");
			
			if(task.equals("write")) {
				Article article = new Article();
				article.setBoardName(request.getParameter("type"));
				article.setTitle(request.getParameter("title"));
				article.setWriter(request.getParameter("writer"));
				article.setContents(request.getParameter("contents"));
				boolean reault =service.writeArticle(article);
				
			}
	
	}

}
