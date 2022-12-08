package service.my;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.CartDAO;

public class CreateCartService {
	private ServletContext application;
	private DataSource ds;
	private CartDAO cartDAO;

	public CreateCartService(ServletContext application) {
		this.application = application;
		cartDAO = (CartDAO) application.getAttribute("cartDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}

	public void createCart(String userId) {
		
		Connection conn = null;
		try {
			conn = ds.getConnection();
			cartDAO.selectAllList(userId, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}
}
