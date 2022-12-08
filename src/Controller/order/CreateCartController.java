package Controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import service.CreateCartService;

@WebServlet(name = "Controller.CreateCartController", urlPatterns = "/CreateCart")
public class CreateCartController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션에 저장된 유저ID 가져오기
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginUser");

		// CreateCartService 객체 얻기
		CreateCartService createCartService = (CreateCartService) request.getServletContext().getAttribute("createCartService");

		// Cart 생성
		createCartService.createCart(userId);

		response.sendRedirect("Home");
	}
}
