package service.my;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.UserDAO;


public class AdminDeleteUserService {
	private ServletContext application;
	private DataSource ds;
	private UserDAO userDAO;
	
	
	public AdminDeleteUserService(ServletContext application) {
		this.application = application;
		userDAO = (UserDAO)application.getAttribute("userDAO");
		ds = (DataSource)application.getAttribute("dataSource");
	}
	
	public int UserDelete(List<String> list) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = ds.getConnection();
			for(int i = 0 ; i<list.size(); i++) {
				userDAO.deleteUser(list.get(i), conn);
			}
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
