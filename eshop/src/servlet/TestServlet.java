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

import dao.BuylistDao;
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
	ProductDao pDao = ProductDao.getInstance();
	BuylistDao bDao = BuylistDao.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("EUC-KR");
		String task = req.getParameter("task");
		String path = "";
		if (task == null || task.isEmpty()) {
			path = "mypage.jsp";
		} else if (task.equals("editaccount")) {
			path = "editaccountform.jsp";
		} else if (task.equals("buylist")) {
			String id = req.getParameter("id");
			List<BuyList> buylist = bDao.selectBuyList(id);
			req.setAttribute("buylist", buylist);

			path = "buylist.jsp";
		} else if (task.equals("cart")) {
			String id = req.getParameter("id");
			req.setAttribute("id", id);
			// service에 보냄[장바구니에서 받아온값들을 이용해서 상품조회]
			List<Product> productList = pService.myCartProduct(id);
			List<MyCart> cartList = pDao.cartList(id);

			req.setAttribute("cartCount", pDao.cartCount(id));// id로 장바구니 총 개수 조회
			req.setAttribute("productList", productList);// 상품 리스트
			req.setAttribute("cartList", cartList);// 장바구니 리스트
			path = "checkout.jsp";

		} else if (task.equals("buy")) {
			String id = req.getParameter("id");
			List<Product> productList = pService.myCartProduct(id);
			List<MyCart> cartList = pDao.cartList(id);

			// buy로 task주는곳이 두곳[single.jsp와 checkout.jsp]
			// single.jsp에서 size, color, 상품번호, id가 파라매터로 넘어오고
			// checkout.jsp에서는 id만 파라매터로 넘어온다
			// 둘을 구분짓기위해 if문을 사용하여 single.jsp에서 넘어온 파라매터들이 널일때는 읽기(List)만 하고
			// 널이 아닐때는 장바구니에 해당 상품을 INSERT 하는 작업을 수행

			req.setAttribute("productList", productList);
			req.setAttribute("cartList", cartList);
			path = "payment.jsp";
		} else if (task.equals("payment")) {
			String id = req.getParameter("id");
			HttpSession session = req.getSession();

			pService.buylistInsert(id);
			// 결제완료될때 DB에서 장바구니 삭제

			session.setAttribute("msg", "결제 완료");
			path = "index.jsp";
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
			// MemberVo 객체 생성 후 set으로 값 넣어주고
			Member member = new Member();
			member.setId(req.getParameter("userid"));
			member.setPw(req.getParameter("userpw1"));
			member.setName(req.getParameter("username"));
			member.setphone(req.getParameter("userphone"));
			member.setAddress(req.getParameter("useraddress"));
			member.setEmail(req.getParameter("useremail"));

			System.out.println("name : " + member.getName());
			System.out.println("address : " + member.getAddress());
			System.out.println("email : " + member.getEmail());

			if (mService.memberUpdate(member)) {
				session.setAttribute("msg", "수정 완료");
				path = "index.jsp";
			} else {
				session.setAttribute("msg", "정보 수정 실패");
				path = "index.jsp";
			}
			// service에서 회원수정 작업 수행 시킴
		} else if (task.equals("editCheck")) {
			// 입력받은 id는 DB에서 패스워드 검색용, 입력받은 pw는 검색된 pw와 비교용(service에서 실행)
			// 정보 수정하기 전 비밀번호 확인[일치 시 정보수정 폼으로 연결]
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			System.out.println("[editCheck]" + "id : " + id + "/ pw : " + pw);
			// 받아온 id와 pw값이 빈 값이 아니면
			if (id != null && id.length() > 0 && pw != null && pw.length() > 0) {
				// 해당 id의 pw와 DB에 있는 pw와 비교값이 참이면
				if (mService.loginPwCheck(id, pw)) {
					// MemberInfo에 id로 검색한 정보를 넣는다
					Member memberInfo = mService.memberInfo(id);
					req.setAttribute("memberInfo", memberInfo);
					path = "editaccount.jsp";
				} else {
					// 비밀번호 일치하지 않음
					session.setAttribute("msg", "비밀번호 일치하지 않음");
					path = "index.jsp";
				}
			} else {
				// id나 pw값이 빈값임
				session.setAttribute("msg", "ID나 PW가 NULL값임");
				path = "index.jsp";
			}
		} else if (task.equals("delete")) {
			// 계정 삭제
			String id = req.getParameter("userid");
			String pw = req.getParameter("userpw");
			if (mService.loginPwCheck(id, pw)) {
				mService.deleteMember(id);
				session.removeAttribute("loginId");
				session.setAttribute("msg", "탈퇴 완료");
				path = "index.jsp";
			} else {
				session.setAttribute("msg", "탈퇴 실패");
				path = "index.jsp";
			}
		} else if (task.equals("cartDel")) {
			String id = req.getParameter("id");
			String productNumStr = req.getParameter("num");
			int productNum = 0;
			if (productNumStr.length() > 0 && productNumStr != null) {
				productNum = Integer.parseInt(productNumStr);
			}
			int result = pService.cartDelete(id, productNum);
			resp.setContentType("text/text;charset=utf-8");
			resp.getWriter().print(result);
			return;
		} else if (task.equals("cartPlus")) {
			String id = req.getParameter("id");
			String title = req.getParameter("title");
			String color = req.getParameter("color");
			String size = req.getParameter("size");
			String quantityStr = req.getParameter("quantity");
			int quantity=1;
			if(quantityStr!=null && quantityStr.length()>0) {
				quantity = Integer.parseInt(quantityStr);
			}
			
			System.out.println("id : " + id + ": title : " + title + " color : " + color + " size : " + size
					+ " quantity : " + quantity);
			int result = 0;
			if(id != null && id.length()>0 && title != null && title.length()>0 && color != null && color.length()>0 &&
				size != null && size.length()>0 ) {
				result = pService.updateAndInsert(id, title, color, size, quantity);	
			}
			if (result == 1) {
				System.out.println("[Tservlet]장바구니에 없는 상품");
			} else if (result == 2) {
				System.out.println("[Tservlet]장바구니 물품 수량증가");
			} else{
				System.out.println("[Tservlet]장바구니 추가 및 업데이트 에러");
			}
			path = "index.jsp";
		}
		RequestDispatcher dispacther = req.getRequestDispatcher(path);
		dispacther.forward(req, resp);
	}
}
