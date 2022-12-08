package Controller.order;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.cart.CartDTO;
import service.my.UpdateCartService;

@WebServlet(name = "Controller.UpdateCartController", urlPatterns = "/UpdateCart")
public class UpdateCartController extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션에 저장된 유저ID 가져오기
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("loginUser");
		userId = "NewUser";

		// UpdateCartService 객체 얻기
		ServletContext application = request.getServletContext();
		// UpdateCartService updateCartService = (UpdateCartService)
		// application.getAttribute("updateCartService");
		UpdateCartService updateCartService = new UpdateCartService(application);

		// Cart 상품 수량 업데이트 & 상품 삭제
		CartDTO cartDTO = new CartDTO();
		cartDTO.setCart_detail_item_count(Integer.parseInt(request.getParameter("cartItemCount")));
		//System.out.println(Integer.parseInt(request.getParameter("cartItemCount")));
		cartDTO.setProduct_id(Integer.parseInt(request.getParameter("productId")));
		//System.out.println(Integer.parseInt(request.getParameter("productId")));
		cartDTO.setUser_id(userId);

		String task = request.getParameter("task");
		switch (task) {
			case "updateCart": {
				// UpdateCartService로 CartDTO 보내고 받기
				String result = updateCartService.controlCartqty(cartDTO);
	
				// 다 지우기~~~~
				if (result.equals("success")) {
					response.sendRedirect("ReadCartController");
				} else {
					// 에러 처리 페이지
					response.sendRedirect("ReadCartController");
				}
			}
			case "deleteCart": {
				int result = updateCartService.deleteCartItem(cartDTO);
			}
		}
	}
}
