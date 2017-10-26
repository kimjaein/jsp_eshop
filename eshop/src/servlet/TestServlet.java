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

import dao.ProductDao;
import service.MemberService;
import service.ProductService;
import vo.BuyList;
import vo.Member;
import vo.MyCart;
import vo.Product;

@WebServlet("/test")
public class TestServlet extends HttpServlet {
	MemberService mService = MemberService.getInstance();
	ProductService pService = ProductService.getInstance();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		String task = req.getParameter("task");
		String path = "";
		if(task == null || task.isEmpty()){
			path="mypage.jsp";
		}else if (task.equals("editaccount")) {
			path = "editaccountform.jsp";
		}else if(task.equals("buylist")) {
			String id = req.getParameter("id");
			List <BuyList> buylist=dao.BuylistDao.getInstance().selectBuyList(id);
			req.setAttribute("buylist", buylist);
			
			path="buylist.jsp";
		}else if(task.equals("cart")) {
			String id = req.getParameter("id");
			req.setAttribute("id", id);
			//service�� ����[��ٱ��Ͽ��� �޾ƿ°����� �̿��ؼ� ��ǰ��ȸ]
			List<Product> cartList = pService.myCartProduct(id);
			List<MyCart> quantityList = ProductDao.getInstance().quantityList(id);
			req.setAttribute("cartCount", ProductDao.getInstance().cartCount(id));
			req.setAttribute("cartList", cartList);
			req.setAttribute("quantityList", quantityList);
			path ="checkout.jsp";
		}else if(task.equals("buy")) {
			String id = req.getParameter("id");
			List<Product> cartList = pService.myCartProduct(id);
			List<MyCart> quantityList = ProductDao.getInstance().quantityList(id);
			
			req.setAttribute("cartList", cartList);
			req.setAttribute("quantityList", quantityList);
			path="payment.jsp";
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		HttpSession session = req.getSession();
		String task = req.getParameter("task");
		String path = "";
		if (task.equals("edit")) {
			// MemberVo ��ü ���� �� set���� �� �־��ְ�
			Member member = new Member();
			member.setId(req.getParameter("userid"));
			member.setPw(req.getParameter("userpw1"));
			member.setName(req.getParameter("username"));
			member.setphone(req.getParameter("userphone"));
			member.setAddress(req.getParameter("useraddress"));
			member.setEmail(req.getParameter("useremail"));
			
			System.out.println("name : "+member.getName());
			System.out.println("address : "+member.getAddress());
			System.out.println("email : "+member.getEmail());
			
			if (mService.memberUpdate(member)) {
				session.setAttribute("msg", "���� �Ϸ�");
				path = "index.jsp";
			} else {
				session.setAttribute("msg", "���� ���� ����");
				path = "index.jsp";
			}
			// service���� ȸ������ �۾� ���� ��Ŵ
		} else if (task.equals("editCheck")) {
			// �Է¹��� id�� DB���� �н����� �˻���, �Է¹��� pw�� �˻��� pw�� �񱳿�(service���� ����)
			// ���� �����ϱ� �� ��й�ȣ Ȯ��[��ġ �� �������� ������ ����]
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			System.out.println("[editCheck]" + "id : "+id + "/ pw : "+pw);
			// �޾ƿ� id�� pw���� �� ���� �ƴϸ�
			if (id != null && id.length() > 0 && pw != null && pw.length() > 0) {
				// �ش� id�� pw�� DB�� �ִ� pw�� �񱳰��� ���̸�
				if (mService.loginPwCheck(id, pw)) {
					// MemberInfo�� id�� �˻��� ������ �ִ´�
					Member memberInfo = mService.memberInfo(id);
					req.setAttribute("memberInfo", memberInfo);
					session.setAttribute("msg", "���� ��ġ");
					path = "editaccount.jsp";
				} else {
					// ��й�ȣ ��ġ���� ����
					session.setAttribute("msg", "��й�ȣ ��ġ���� ����");
					path = "index.jsp";
				}
			} else {
				// id�� pw���� ����
				session.setAttribute("msg", "ID�� PW�� NULL����");
				path = "index.jsp";
			}
		} else if (task.equals("delete")) {
			// ���� ����
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			if(mService.loginPwCheck(id, pw)){
				mService.deleteMember(id);
				session.removeAttribute("loginId");
				session.setAttribute("msg", "���� �Ϸ�");
				path = "index.jsp";
			}else {
				session.setAttribute("msg", "���� ����");
				path = "index.jsp";
			}
		}else if (task.equals("cartDel")) {
			String id = req.getParameter("id");
			String productNumStr = req.getParameter("num");
			int productNum=0;
			if(productNumStr.length()>0 && productNumStr != null) {
				productNum = Integer.parseInt(productNumStr);
			}
			int result = pService.cartDelete(id, productNum);
			resp.setContentType("text/text;charset=utf-8");
			resp.getWriter().print(result);
			return;
		}else if(task.equals("cartPlus")){
			String id = req.getParameter("id");
			String productNumStr = req.getParameter("num");
			int productNum=0;
			if(productNumStr.length()>0 && productNumStr != null) {
				productNum = Integer.parseInt(productNumStr);
			}
			int result = pService.updateAndInsert(id, productNum);
			if(result == 1) {
				System.out.println("[Tservlet]��ٱ��Ͽ� ���� ��ǰ");
				path = "mypage.jsp";
			}else if(result == 2) {
				System.out.println("[Tservlet]��ٱ��� ��ǰ ��������");
				path = "mypage.jsp";
			}else {
				System.out.println("[Tservlet]��ٱ��� �߰� �� ������Ʈ ����");
				path = "mypage.jsp";
			}
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
}
