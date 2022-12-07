package Controller.order;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import dto.order.OrderDTO;
import dto.order.OrderDetailDTO;
import service.my.CreateOrderService;

@WebServlet(name="Controller.CreateOrderController", urlPatterns="/CreateOrder")
public class CreateOrderController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		BufferedReader br = request.getReader();
		char[] buffer = new char[1024];
		int isEnd = 0;
		String receivedData = "";
		while (isEnd > 0) {
			isEnd = br.read(buffer);
			receivedData += buffer;
		}
		JSONObject receivedJSON = new JSONObject(receivedData);
		
		String productId = receivedJSON.getString("id");
		int qty = receivedJSON.getInt("qty");
		int price = receivedJSON.getInt("price");
		String address = receivedJSON.getString("address");
		String date = receivedJSON.getString("date");
		
		CreateOrderService createOrderService = (CreateOrderService) request.getServletContext().getAttribute("boardService");
		
		OrderDetailDTO orderDetail = new OrderDetailDTO();
		orderDetail.setOrder_detail_item_count(qty);
		orderDetail.setProduct_id(Integer.parseInt(productId));
		
		OrderDTO order = new OrderDTO();
		order.setOrders_address(address);
		order.setOrders_date(date);
		order.setOrders_status("주문 완료");
		order.setUsers_id(userId);
		
		int result = createOrderService.createOrder(order, orderDetail);
		
		if (result != -1) {
			//success
			request.getRequestDispatcher("/WEB-INF/views/order.jsp").forward(request, response);
		}
		else {
			//fail
		}
		
	}

}
