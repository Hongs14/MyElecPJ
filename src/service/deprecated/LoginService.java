package service.deprecated;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.UserDAO;
import dto.user.UserDTO;

public class LoginService {

	private ServletContext application;
	private DataSource ds;
	private UserDAO userDAO;
	
	
	public LoginService(ServletContext application) {
		this.application = application;
		userDAO = (UserDAO)application.getAttribute("userDAO");
		ds = (DataSource)application.getAttribute("dataSource");
	}
	
	public UserDTO join(UserDTO userDTO) {
		UserDTO result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = userDAO.selectUser(userDTO, conn);
		} catch (Exception e) {
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
