package Controller.order;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.cart.CartDTO;
import service.UpdateCartService;

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
		cartDTO.setProduct_id(Integer.parseInt(request.getParameter("productId")));
		cartDTO.setUser_id(userId);

		String task = request.getParameter("task");
		PrintWriter pw = new PrintWriter(response.getOutputStream());
		System.out.println(task);
		String result = null;
		switch (task) {
			case "updateCart": {
				// UpdateCartService로 CartDTO 보내고 받기
				System.out.println("update");
				result = updateCartService.updateCartqty(cartDTO);
				break;
			}
			case "deleteCart": {
				System.out.println("delete");
				result = updateCartService.deleteCartItem(cartDTO);
				break;
			}
			default: break;
		}
		System.out.println(result);
		pw.write(result);
		pw.flush();
		pw.close();
	}
}