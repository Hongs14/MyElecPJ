package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.UserDAO;
import dto.user.UserDTO;

public class UpdateUserService {
	
	private ServletContext application;
	private DataSource ds;
	private UserDAO userDao;
	
	
	
	public UpdateUserService(ServletContext application) {
		this.application = application;
		userDao = (UserDAO)application.getAttribute("userDAO");
		ds = (DataSource)application.getAttribute("dataSource");
	}
	
	
	
	public void UpdateUserInfo(UserDTO userDTO) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			userDao.updateUser(userDTO, conn);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
}
