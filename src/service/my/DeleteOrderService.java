package service.my;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.OrderDAO;
import dto.order.OrderDTO;

public class DeleteOrderService {
	private ServletContext application;
	private DataSource ds;
	private OrderDAO orderDAO;
	public DeleteOrderService(ServletContext application) {
		this.application = application;
		orderDAO = (OrderDAO)application.getAttribute("orderDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public int deleteOrder(OrderDTO order) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = orderDAO.deleteOrder(conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		
		return result;
	}
	
}
