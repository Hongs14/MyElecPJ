package service;

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
		int queryResult = 0;
		try {
			conn= ds.getConnection();
			conn.setAutoCommit(false);
			queryResult = userDAO.insertUser(userDTO, conn);
			
		} catch(Exception e) {
			try {
				//수동 롤백 -> 모두 실패 처리
				conn.rollback();
				result = false;
				
			} catch(SQLException e1) {
			}
			System.out.println("회원가입, 장바구니 생성 실패");
			e.printStackTrace();
		} finally {
			if(conn != null) {
				try {
					//자동 커밋 기능 켜기
					conn.setAutoCommit(true);
					conn.close();
				} catch (SQLException e) {
					
				}
			}
		}
		
		if (queryResult == 2) {
			result = true;
		}
		
		return result;
	}
}
