package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.UserDAO;
import dto.user.UserDTO;

public class FindPasswordService {
	private ServletContext application;
	private DataSource ds;
	private UserDAO userDAO;
	
	public FindPasswordService(ServletContext application) {
		this.application = application;
		userDAO = (UserDAO)application.getAttribute("userDAO");
		ds = (DataSource)application.getAttribute("dataSource");
	}
	
	public String findPassword(UserDTO userDTO) {
		Connection conn = null;
		String result = null;
		try {
			conn = ds.getConnection();
			result = userDAO.findPassword(userDTO, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result);
		return result;
	}
	public String findId(UserDTO userDTO) {
		Connection conn = null;
		String result = null;
		try {
			conn = ds.getConnection();
			result = userDAO.findId(userDTO, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
}
