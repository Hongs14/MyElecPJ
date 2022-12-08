package service;

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
	
	public void deleteOrder(OrderDTO order) {
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			orderDAO.deleteOrder(order,conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		
	}
	
}
