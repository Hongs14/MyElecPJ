package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.UserDAO;
import dto.user.UserDTO;

public class UserInfoService {
	private ServletContext application;
	private DataSource ds;
	private UserDAO userDAO;
	
	public UserInfoService(ServletContext application) {
		this.application = application;
		userDAO = (UserDAO)application.getAttribute("userDAO");
		ds = (DataSource)application.getAttribute("dataSource");
	}
	
	public UserDTO UserInfo(UserDTO userDTO) {
		Connection conn = null;
		UserDTO result = new UserDTO();
		
		
		try {
			conn = ds.getConnection();
			result = userDAO.selectUserInfo(userDTO, conn);
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
