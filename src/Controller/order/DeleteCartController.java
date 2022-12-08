package Controller.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.cart.CartDTO;
import service.DeleteCartService;

@WebServlet(name = "Controller.DeleteCartController", urlPatterns = "/DeleteCart")
public class DeleteCartController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션에 저장된 유저ID 가져오기
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginUser");
		
		int productId = Integer.parseInt((String) request.getAttribute("productId"));

		// CreateCartService 객체 얻기
		DeleteCartService deleteCartService = (DeleteCartService) request.getServletContext().getAttribute("deleteCartService");
		CartDTO cart = new CartDTO();
		cart.setUser_id(userId);
		cart.setProduct_id(productId);
		String result = deleteCartService.deleteCart(cart);
		
		PrintWriter pw = new PrintWriter(response.getOutputStream());
		pw.write(result);
		pw.flush();
		pw.close();
	}
}
