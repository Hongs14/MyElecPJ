package service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.OrderDAO;
import dto.order.OrderDTO;
import util.Pager;

public class ReadOrderListService {
	private ServletContext application;
	private DataSource ds;
	private OrderDAO orderDAO;
	public ReadOrderListService(ServletContext application) {
		this.application = application;
		orderDAO = (OrderDAO)application.getAttribute("orderDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public int getTotalBoardNum(OrderDTO order) {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = orderDAO.getTotalRows(order, conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		
		return result;
	}
	
	public List<OrderDTO> getPageList(Pager pager, OrderDTO order) {
		List<OrderDTO> result = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = orderDAO.selectOrderList(pager, order, conn);
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