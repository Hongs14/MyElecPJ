package Controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.my.DeleteCartService;

@WebServlet(name = "Controller.DeleteCartController", urlPatterns = "/DeleteCart")
public class DeleteCartController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션에 저장된 유저ID 가져오기
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginUser");

		// CreateCartService 객체 얻기
		DeleteCartService deleteCartService = (DeleteCartService) request.getServletContext().getAttribute("deleteCartService");

		// Cart 생성
		deleteCartService.deleteCart(userId);

		response.sendRedirect("HomeController");
	}
}
