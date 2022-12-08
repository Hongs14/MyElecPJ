package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.UserDAO;
import dto.user.UserDTO;
import util.Pager;

public class AdminUserService {

	private ServletContext application;
	private DataSource ds;
	private UserDAO userDAO;
	
	public AdminUserService(ServletContext application) {
		this.application = application;
		userDAO = (UserDAO)application.getAttribute("userDAO");
		ds = (DataSource)application.getAttribute("dataSource");
	}
	
	
	
	public int getTotalBoardNum() {
		int result = 0;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = userDAO.getTotalRows(conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		return result;
	}



	public List<UserDTO> getUserList(Pager pager) {
		List<UserDTO> result = null;
		Connection conn = null;
	
		try {
			conn = ds.getConnection();
			result = userDAO.getUserList(pager, conn);
			
			
		} catch (SQLException e) {
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
