package service;

import javax.servlet.ServletContext;

import dao.UserDAO;
import dto.user.UserDTO;

public class JoinService {
private ServletContext application;
	
	public JoinService(ServletContext application) {
		this.application = application;
	}
	
	public void join(UserDTO userDTO) {
		System.out.println("회원가입 완료");
		UserDAO userDAO = (UserDAO) application.getAttribute("userDAO");
		//userDAO.insert(user, null);
	}
}
