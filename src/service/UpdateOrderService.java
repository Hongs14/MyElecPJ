package service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.OrderDAO;
import dto.order.OrderDTO;

public class UpdateOrderService {
	private ServletContext application;
	private DataSource ds;
	private OrderDAO orderDAO;
	public UpdateOrderService(ServletContext application) {
		this.application = application;
		orderDAO = (OrderDAO)application.getAttribute("orderDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public void updateOrder(OrderDTO order) {
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			orderDAO.updateOrder(order, conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		
	}
	
}
