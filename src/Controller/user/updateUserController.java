package Controller.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user.UserDTO;
import service.UpdateUserService;


@WebServlet(name="Controller.updateUserInfoController", urlPatterns="/updateUserinfo")
public class updateUserController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/updateUserInfo.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트 데이터 받기
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_id(request.getParameter("user_id"));
		userDTO.setUser_password(request.getParameter("user_password"));
		userDTO.setUser_email(request.getParameter("user_email"));
		userDTO.setUser_address(request.getParameter("user_address"));
		userDTO.setUser_phone(request.getParameter("user_phone"));
		userDTO.setUser_name(request.getParameter("user_name"));
		userDTO.setUser_birthday(request.getParameter("user_birthday"));
		
		//서비스로 로그인 요청
		ServletContext application = request.getServletContext();
		UpdateUserService updateUserService = (UpdateUserService)application.getAttribute("updateUserService");
		updateUserService.UpdateUserInfo(userDTO);
		
		
	}
	
	
}
