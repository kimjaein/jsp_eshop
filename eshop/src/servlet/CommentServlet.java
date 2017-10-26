package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.Gson;

import service.CommentService;
import vo.Comment;

@WebServlet("/comment")
public class CommentServlet extends HttpServlet {
	private CommentService service = CommentService.getInstance();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String task = request.getParameter("task");
		System.out.println("comment");
		if (task.equals("read")) {
			String articleNumStr = request.getParameter("articleNum");
			int articleNum = Integer.parseInt(articleNumStr);
			response.setContentType("text/text;charset=euc-kr");
			List<Comment> commentList = service.readComment(articleNum);
			PrintWriter writer = response.getWriter();
			Gson gson = new Gson();
			writer.print(gson.toJson(commentList));
			System.out.println(gson.toString());
		}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String task = request.getParameter("task");
		String path = "";
		if (task.equals("write")) {

			String writer = request.getParameter("writer");
			String contents = request.getParameter("contents");
			String articleNumStr = request.getParameter("articleNum");
			int articleNum = Integer.parseInt(articleNumStr);

			Comment comment = new Comment();
			comment.setArticleNum(articleNum);
			comment.setWriter(writer);
			comment.setContents(contents);

			boolean result = service.writeComment(comment);
			if (result) {
				path = "board?task=read&articleNum=" + articleNum;
			}
			
			response.sendRedirect(path); // 원래의 페이지로 이동
		}

	}

}
