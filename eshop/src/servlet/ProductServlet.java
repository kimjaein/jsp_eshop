package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CommentService;
import service.ProductService;
import vo.Comment;
import vo.Product;
import vo.ProductPage;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private ProductService service = ProductService.getInstance();
	private CommentService serviceComment = CommentService.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task=request.getParameter("task");
		String path="";
		
		
		if(task.equals("start")) {
		List<Product> recentProductList = service.selectRecentProduct();
		List<Product> bestProductList = service.selectBestProduct();
		request.setAttribute("recentProductList", recentProductList);
		request.setAttribute("bestProductList", bestProductList);
		
		path ="main.jsp";
		
		} else if(task.equals("detail")) {
			String title = request.getParameter("title");
			List<Comment> commentList = serviceComment.readComment(title);
			Product singleProduct = service.makeProduct(title);
						 
			//title로 와일드카드 조회 
			List<String> colorList = service.colorList(title);
			List<String> sizeList = service.sizeList(title);
			request.setAttribute("colorList", colorList);
			request.setAttribute("sizeList", sizeList);
			request.setAttribute("singleProduct", singleProduct);
			request.setAttribute("commentList",commentList);
			
			path = "single.jsp";
			
		} else if(task.equals("middleCategory")) {
			String middleList = request.getParameter("middleList");
			String pageStr = request.getParameter("p");
			String option = request.getParameter("option");
			
			System.out.println("option:"+option);
			
			int page = 1;
			if(pageStr != null && !pageStr.isEmpty()) {
				page = Integer.parseInt(pageStr);
			}
			
			ProductPage productPage = service.middleCategoryProduct(middleList, page, option);
			
			
			request.setAttribute("type", task);
			request.setAttribute("categoryPage", productPage);

			
			path="products.jsp";

		} else if(task.equals("largeCategory")) {
			String largeList = request.getParameter("largeList");
			String pageStr = request.getParameter("p");
			String option = request.getParameter("option");
			System.out.println("option:"+option);
			
			int page = 1;
			if(pageStr != null && !pageStr.isEmpty()) {
				page = Integer.parseInt(pageStr);
			}
			
			ProductPage productPage = service.largeCategoryProduct(largeList, page, option);
			
			request.setAttribute("type", task);
			request.setAttribute("categoryPage", productPage);
			
			
			path="products.jsp";
		
		}
		
		
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String task=request.getParameter("task");
		
		
	}
	
	
}
