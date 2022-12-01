package service;

import javax.servlet.ServletContext;

import dao.UserDAO;
import dto.user.UserDTO;

public class UpdateUserService {
	
	private ServletContext application;
	
	public UpdateUserService(ServletContext application) {
		this.application = application;
	}
	
	public void UpdateUserInfo(UserDTO userDTO) {
		System.out.println("회원정보를 수정 합니다");
		UserDAO userDAO = (UserDAO)application.getAttribute("userDAO");
	}
	
	
}
