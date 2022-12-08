package service.my;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.OrderDAO;
import dto.order.OrderDTO;
import dto.order.OrderDetailDTO;

public class CreateOrderService {
	private ServletContext application;
	private DataSource ds;
	private OrderDAO orderDAO;
	public CreateOrderService(ServletContext application) {
		this.application = application;
		orderDAO = (OrderDAO)application.getAttribute("orderDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public int createOrder(OrderDTO order, OrderDetailDTO orderDetail) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = orderDAO.insertOrder(order, orderDetail, conn);
		}
		catch (Exception e) {
			result = -1;
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		
		return result;
	}
	
}
