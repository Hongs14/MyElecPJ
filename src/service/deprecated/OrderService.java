package service.deprecated;

import javax.servlet.ServletContext;

import dao.OrderDAO;
import dto.order.OrderDTO;

public class OrderService {
	private ServletContext application;
	
	public OrderService(ServletContext application) {
		this.application = application;
	}
	
	public void read(OrderDTO board) {
		System.out.println("주문 페이지 읽음");
		OrderDAO orderDAO = (OrderDAO) application.getAttribute("orderDao");
		//qnABoardDAO.insert(board);
	}
}
