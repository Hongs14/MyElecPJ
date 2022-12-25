package Controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.cart.CartDTO;
import dto.product.ProductDTO;
import service.ReadCartService;

@WebServlet(name = "Controller.ReadCartController", urlPatterns = "/ReadCart")
public class ReadCartController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션에 저장된 유저ID 가져오기
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("user_id");
		// userId = "Test1";

		// ReadCartService 객체 얻기
		ServletContext application = request.getServletContext();
		ReadCartService readCartService = (ReadCartService) application.getAttribute("readCartService");

		// CartList 가져오기
		List<CartDTO> cartList = readCartService.getCartList(userId);

		// jsp에서 사용할수 있도록 request 범위에 저장
		request.setAttribute("cartList", cartList);

		// 장바구니 이미지 얻기
		CartDTO cart = new CartDTO();
		String filePath = null;
		for (CartDTO c : cartList) {
			cart = readCartService.getImage(c.getUser_id(), c.getProduct_id());
			filePath = "resources\\images\\download\\" + cart.getProduct_savedname();
			c.setProduct_savedname(filePath);
		}

		request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
	}
}
