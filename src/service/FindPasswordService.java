package service;

import javax.servlet.ServletContext;

import dao.UserDAO;
import dto.user.UserDTO;

public class FindPasswordService {
	private ServletContext application;
	
	public FindPasswordService(ServletContext application) {
		this.application = application;
	}
	
	public void findPassword(UserDTO userDTO) {
		System.out.println("비밀번호 찾음");
		UserDAO userDAO = (UserDAO) application.getAttribute("userDAO");
		//userDAO.read(userDTO);
	}
}
