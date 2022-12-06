package service.my;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.OrderDAO;
import dto.order.OrderDTO;

public class ReadOrderService {
	private ServletContext application;
	private DataSource ds;
	private OrderDAO orderDAO;
	public ReadOrderService(ServletContext application) {
		this.application = application;
		orderDAO = (OrderDAO)application.getAttribute("orderDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public OrderDTO readOrder(OrderDTO order) {
		OrderDTO result = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = orderDAO.selectOrder(conn);
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
