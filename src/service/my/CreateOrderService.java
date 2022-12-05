package service.my;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.OrderDAO;
import dao.ProductDAO;
import dto.product.ProductDTO;
import util.Pager;

public class CreateOrderService {
	private ServletContext application;
	private DataSource ds;
	private OrderDAO orderDAO;
	public CreateOrderService(ServletContext application) {
		this.application = application;
		orderDAO = (OrderDAO)application.getAttribute("orderDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public int createOrder(OrderDAO order) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = orderDAO.insertOrder(conn);
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
