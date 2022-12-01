package service;

import javax.servlet.ServletContext;

import dao.UserDAO;
import dto.user.UserDTO;

public class LoginService {

	private ServletContext application;
	
	public LoginService(ServletContext application) {
		this.application = application;
	}
	
	public void join(UserDTO userDTO) {
		System.out.println("로그인을 합니다");
		UserDAO userDAO = (UserDAO) application.getAttribute("userDAO");
		
		
		//userDAO.selectUser(userDTO);
		
		
	}
	
	
}
