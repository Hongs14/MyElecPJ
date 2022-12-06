package Controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.order.OrderDTO;
import service.my.DeleteOrderService;

@WebServlet(name="Controller.DeleteOrderController", urlPatterns="/DeleteOrder")
public class DeleteOrderController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		DeleteOrderService deleteOrderService = (DeleteOrderService) request.getServletContext().getAttribute("boardService");
		
		OrderDTO order = new OrderDTO();
		order.setOrders_id(Integer.parseInt(request.getParameter("order_detail_item_count")));
		
		deleteOrderService.deleteOrder(order);
		
		request.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(request, response);
	}

}
