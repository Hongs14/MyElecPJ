package service.my;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.CartDAO;
import dto.cart.CartDTO;

public class UpdateCartService {
	private ServletContext application;
	private DataSource ds;
	private CartDAO cartDAO;

	// 수량변경, 상품삭제, 총액 변경
	public UpdateCartService(ServletContext application) {
		this.application = application;
		cartDAO = (CartDAO) application.getAttribute("cartDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}

	public String controlCartqty(CartDTO cartDTO) {
		String result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = cartDAO.insertCart(cartDTO, conn);
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
	
	public String controlCartSum(CartDTO cartDTO) {
		String result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = cartDAO.insertCart(cartDTO, conn);
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

	public int deleteCartItem(CartDTO cartDTO) {
		int result = 0;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = cartDAO.delCartItem(cartDTO, conn);
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
