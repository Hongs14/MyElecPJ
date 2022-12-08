package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.CartDAO;
import dto.cart.CartDTO;
import util.Pager;

public class ReadCartService {
	private ServletContext application;
	private DataSource ds;
	private CartDAO cartDAO;

	public ReadCartService(ServletContext application) {
		this.application = application;
		cartDAO = (CartDAO) application.getAttribute("cartDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}

	public List<CartDTO> getCartList(String userId) {
		List<CartDTO> result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = cartDAO.selectAllList(userId, conn);
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
