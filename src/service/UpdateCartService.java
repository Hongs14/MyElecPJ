package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	public List<String> updateCartqty(CartDTO cartDTO) {
		List<String> result = new ArrayList<>();
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result.add(cartDAO.updateCartItem(cartDTO, conn));
			result.add(cartDAO.updateSumPrice(cartDTO, conn));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {}
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
			try {conn.close();} catch (SQLException e) {}
		}
		return result;
	}

	public String deleteCartItem(CartDTO cartDTO) {
		String result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = cartDAO.delCartItem(cartDTO, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {conn.close();} catch (SQLException e) {}
		}
		return result;
	}
	
	
}
