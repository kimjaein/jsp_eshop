package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDao;
import service.ProductService;
import vo.Product;

@WebServlet("/product")
public class ProductServlet extends HttpServlet{
	private ProductService service = ProductService.getInstance();
	private ProductDao dao = ProductDao.getInstance();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String task=request.getParameter("task");
		String path="";
		
		if(task.equals("start")) {
		List<Product> recentProductList = dao.selectRecentProduct();
		List<Product> bestProductList = dao.selectBestProduct();
		request.setAttribute("recentProductList", recentProductList);
		request.setAttribute("bestProductList", bestProductList);
		
		path ="main.jsp";
		} else if(task.equals("detail")) {
			String title = request.getParameter("title");

			Product singleProduct = service.makeProduct(title);
			
			 String str=singleProduct.getTitle();
			 str=str.substring(0,str.length()-2);
			 singleProduct.setTitle(str);
			 
			request.setAttribute("singleProduct", singleProduct);
			System.out.println(singleProduct.toString());
			
			path = "single.jsp";
		} else if(task.equals("list")) {
			String category = request.getParameter("category");
			List<Product> categoryList = service.categoryProduct(category);
			
			request.setAttribute("categoryList", categoryList);
			
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
