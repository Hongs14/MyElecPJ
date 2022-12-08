package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.CartDAO;
import dto.cart.CartDTO;

public class DeleteCartService {
	private ServletContext application;
	private DataSource ds;
	private CartDAO cartDAO;

	public DeleteCartService(ServletContext application) {
		this.application = application;
		cartDAO = (CartDAO) application.getAttribute("cartDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}

	public String deleteCart(CartDTO cart) {
		String result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = cartDAO.delCartItem(cart, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
}
