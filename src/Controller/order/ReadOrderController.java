package Controller.order;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.order.OrderDTO;
import dto.product.ProductDTO;
import dto.user.UserDTO;
import service.UserInfoService;
import service.my.ReadProductService;

@WebServlet(name="Controller.ReadOrderController", urlPatterns="/ReadOrder")
public class ReadOrderController extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("user_id");
		int productid = Integer.parseInt(request.getParameter("productid"));
		int price = Integer.parseInt(request.getParameter("price"));
		
		
		//int countNum = Integer.parseInt(request.getParameter("countNum"));
		int countNum = 1;
//		BufferedReader br = request.getReader();
//		char[] buffer = new char[1024];
//		int isEnd = 0;
//		String receivedData = "";
//		while (isEnd > 0) {
//			isEnd = br.read(buffer);
//			receivedData += buffer;
//		}
//		JSONObject receivedJSON = new JSONObject(receivedData);
//		
//		String productId = receivedJSON.getString("productId");
//		int usedPoint = receivedJSON.getInt("usedPoint");
//		int price = receivedJSON.getInt("price");
//		int qty = receivedJSON.getInt("qty");
		
		
		
		ServletContext application = request.getServletContext();
		//ReadOrderService readOrderService = (ReadOrderService) request.getServletContext().getAttribute("boardService");
		//ReadOrderService readOrderService = new ReadOrderService(application);
		ReadProductService readProductService = new ReadProductService(application);
		ProductDTO product = readProductService.getProduct(productid);
		
		UserInfoService userInfoService = (UserInfoService)application.getAttribute("userInfoService");
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_id(userId);
		UserDTO user = userInfoService.UserInfo(userDTO);
		
		request.setAttribute("productId", productid);
		request.setAttribute("price", price);
		request.setAttribute("countNum", countNum);
		request.setAttribute("productName", product.getProduct_name());
		
		request.setAttribute("user", user);
		

		/*OrderDTO order = new OrderDTO();
		order.setProduct_id(Integer.parseInt(productid));
		order.setOrders_price(Integer.parseInt(price));
		
		order = readOrderService.readOrder(order);*/
		
		/*OrderDetailDTO orderDetail = new OrderDetailDTO();
		orderDetail.setOrder_detail_item_count(countNum);
		orderDetail.setOrders_id(orders_id);
		orderDetail.setProduct_id(product_id);*/
		
		
		
		request.getRequestDispatcher("order.jsp").forward(request, response);
	}

}
