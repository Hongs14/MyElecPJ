package service.deprecated;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.UserDAO;
import dto.user.UserDTO;

public class JoinService {
private ServletContext application;
private DataSource ds;
private UserDAO userDAO;


	public JoinService(ServletContext application) {
		this.application = application;
		userDAO = (UserDAO)application.getAttribute("userDAO");
		ds = (DataSource)application.getAttribute("dataSource");
	}
	
	public boolean join(UserDTO userDTO) {
		boolean result = false;
		Connection conn = null;
		
		try {
			conn= ds.getConnection();
			result = userDAO.insertUser(userDTO, conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
