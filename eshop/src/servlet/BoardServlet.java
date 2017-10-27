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
import service.CommentService;
import vo.Article;
import vo.ArticlePage;
import vo.Comment;

 
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
        	loginId="wodls";
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
        		path="board?task=boardList&type=qna";//에러 울릴 방법 생각
        	}
        }else if(task.equals("replyForm")) { //답변 글 달기
    		String articleNumStr = request.getParameter("articleNum");
    		int articleNum = Integer.parseInt(articleNumStr);
    		//필요한 정보 담아서 넘기기
    		Article article = service.readArticleInfo(articleNum);
    		request.setAttribute("article",article);
    		
    		path="replyWrite.jsp";
    	}else if (task.equals("updateForm")) {
    		String articleNumStr = request.getParameter("articleNum");
    		int articleNum = Integer.parseInt(articleNumStr);
    		
    		Article article = service.readWithoutReadCount(articleNum);
    		System.out.println(article);
    		request.setAttribute("origin",article);
    		
    		path="QnAUpdate.jsp";
    	}else if(task.equals("delete")) {
    		String writer = request.getParameter("writer");
    		String articleNumStr = request.getParameter("articleNum");
    		int articleNum = Integer.parseInt(articleNumStr);
    		if(service.delete(articleNum,writer)) {
    			response.sendRedirect("board?task=boardList&type=qna");
    			return;
    		}
    		
    	}
      
        RequestDispatcher dispatcher = request.getRequestDispatcher(path);
        dispatcher.forward(request, response);
    }
     
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	request.setCharacterEncoding("euc-kr");
		String task=request.getParameter("task");
		String path="";
		
		if(task.equals("write")) {
			Article article = new Article();
			article.setBoardName(request.getParameter("type"));
			article.setTitle(request.getParameter("title"));
			article.setWriter(request.getParameter("writer"));
			article.setContents(request.getParameter("contents"));
			boolean result =service.writeArticle(article);
			
			path="board?task=boardList&type=qna";
			response.sendRedirect("board?task=boardList&type=qna");
			return;
		}else if(task.equals("reply")) {
    		Article article =new Article();
    		article.setTitle(request.getParameter("title")); //수정된title로 업데이트
    		article.setWriter(request.getParameter("writer"));
    		article.setContents(request.getParameter("contents"));
    		article.setList(Integer.parseInt(request.getParameter("list")));
    		article.setDepth(request.getParameter("depth"));
    		article.setBoardName(request.getParameter("type"));
    		
    		if(service.setReplyArticle(article)){
    			//path="board?task=boardList&type=qna";
    			response.sendRedirect("board?task=boardList&type=qna");
    			return;
    		}else {
    			//path=".jsp";
    		}
    		
    	}else if(task.equals("update")) {
    		Article article = new Article();
    		String articleNumStr = request.getParameter("articleNum");
    		int articleNum = Integer.parseInt(articleNumStr);
    		
    		article.setArticleNum(articleNum);
    		article.setTitle(request.getParameter("title"));
    		article.setContents(request.getParameter("contents"));
    		
    		if(service.update(article)) {
    			response.sendRedirect("board?task=boardList&type=qna");
    			return;
    		}
    	}
		
    }
}