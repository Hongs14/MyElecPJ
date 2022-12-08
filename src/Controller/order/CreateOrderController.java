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

import dto.order.OrderDTO;
import dto.order.OrderDetailDTO;
import service.CreateOrderService;

@WebServlet(name="Controller.CreateOrderController", urlPatterns="/CreateOrder")
public class CreateOrderController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("user_id");
		
		int productId = Integer.parseInt(request.getParameter("id"));
		int qty = Integer.parseInt(request.getParameter("count"));
		int price = Integer.parseInt(request.getParameter("price"));
		String address = request.getParameter("address");
		
		ServletContext application = request.getServletContext();
		//CreateOrderService createOrderService = (CreateOrderService) request.getServletContext().getAttribute("boardService");
		CreateOrderService createOrderService = new CreateOrderService(application);
				
		OrderDetailDTO orderDetail = new OrderDetailDTO();
		orderDetail.setOrder_detail_item_count(qty);
		orderDetail.setProduct_id(productId);
		
		OrderDTO order = new OrderDTO();
		order.setOrders_address(address);
		order.setOrders_status("주문 완료");
		order.setUsers_id(userId);
		order.setOrders_price(price);
		
		int result = createOrderService.createOrder(order, orderDetail);
		PrintWriter pw = new PrintWriter(response.getOutputStream());
		if (result == 2) {
			pw.write("success");
			
		}
		else {
			pw.write("success");
		}
		pw.flush();
		pw.close();
		
	}

}
