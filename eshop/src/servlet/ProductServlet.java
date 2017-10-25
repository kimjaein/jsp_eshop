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
		String item=request.getParameter("item");
		String path="";
		
		if(item.equals("detail")) {
		String title = request.getParameter("title");
		List<Product> productList = dao.selectProductList(title);
		request.setAttribute("productList", productList);
		
		path ="single.jsp";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
	}
	

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("euc-kr");
		String task=request.getParameter("task");
		
		
	}
	
	
}
