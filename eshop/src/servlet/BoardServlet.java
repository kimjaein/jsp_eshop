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
import vo.ArticlePage;

 
@WebServlet("/board")
public class BoardServlet extends HttpServlet{
	private BoardService service = BoardService.getInstance(); 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String task = request.getParameter("task");
        String path="";

        if(task.equals("writeForm")) {
        	HttpSession session=request.getSession();
        	String loginId =(String)session.getAttribute("loginId");
        	
        	if(loginId==null ||loginId.isEmpty()) {
        		path="account.jsp";
        	}else {
        		path="QnaWrite.jsp";
        	}
        }else if(task.equals("boardList")) {
        	String type=request.getParameter("type");
        	
        	String p=request.getParameter("p");
        	int page=1;
        	if(p!=null && !p.isEmpty()) {
        		page=Integer.parseInt(p);
        	}
        	
        	ArticlePage articlePage = service.makeArticlePage(page,type);
        	
        	request.setAttribute("articlePage",articlePage);
        	if(type.equals("qna")){
        		path="QnA.jsp";
        	}
        }else if(task.equals("read")) {
        	HttpSession session=request.getSession();
        	String loginId =(String)session.getAttribute("loginId");
        	
        	String articleNumStr =request.getParameter("articleNum");
        	int articleNum=Integer.parseInt(articleNumStr);
        	Article article = service.read(articleNum,loginId);
        	
        	if(article !=null) {
        		request.setAttribute("article", article);
        		path="read.jsp";
        	}else {
        		path="QnA.jsp";//俊矾 匡副 规过 积阿
        	}
        }
        
      
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