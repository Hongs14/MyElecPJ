package Controller.order;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.order.OrderDTO;
import service.UpdateOrderService;

@WebServlet(name="Controller.UpdateOrderController", urlPatterns="/UpdateOrder")
public class UpdateOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		UpdateOrderService updateOrderService = (UpdateOrderService) request.getServletContext().getAttribute("boardService");
		
		OrderDTO order = new OrderDTO();
		order.setOrder_detail_item_count(Integer.parseInt(request.getParameter("order_detail_item_count")));
		order.setOrders_address(request.getParameter("order_detail_item_count"));
		order.setOrders_date(request.getParameter("order_detail_item_count"));
		order.setOrders_price(Integer.parseInt(request.getParameter("order_detail_item_count")));
		order.setOrders_status(request.getParameter("order_detail_item_count"));
		order.setProduct_id(Integer.parseInt(request.getParameter("order_detail_item_count")));
		order.setProduct_name(request.getParameter("order_detail_item_count"));
		order.setUsers_id(userId);
		
		updateOrderService.updateOrder(order);
		request.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(request, response);
	}

}
