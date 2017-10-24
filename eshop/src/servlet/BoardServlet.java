package servlet;
 
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.BoardService;
import vo.Article;

 
@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	private BoardService service = BoardService.getInstance(); 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");
        String path="";
        System.out.println("board +get");
         
      
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	System.out.println("board");
		request.setCharacterEncoding("euc-kr");
		String task=request.getParameter("task");
		String path="";
		
		if(task.equals("write")) {
			Article article = new Article();
			article.setBoardName(request.getParameter("type"));
			article.setTitle(request.getParameter("title"));
			article.setWriter(request.getParameter("writer"));
			article.setContents(request.getParameter("contents"));
			boolean reault =service.writeArticle(article);
			
			path="QnA.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
    }
}