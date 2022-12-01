package Controller.order;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.cart.CartDTO;
import service.CartService;

@WebServlet(name="Controller.cartController", urlPatterns="/cart")
public class cartController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		request.getRequestDispatcher("/WEB-INF/views/cart.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		//클라이언트가 보낸 데이터 얻기
		CartDTO cartDTO = new CartDTO();
				
		//서비스로 장바구니 목록 보기 요청
		ServletContext application = request.getServletContext();
		CartService cartListService = (CartService) application.getAttribute("cartListService"); 
		cartListService.cartList(cartDTO);
		
		response.sendRedirect("cartController");
	}	
}
