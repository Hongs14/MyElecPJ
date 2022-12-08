package Controller.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.user.UserDTO;
import service.UpdateUserService;


@WebServlet(name="Controller.UpdateUserController", urlPatterns="/UpdateUser")
public class UpdateUserController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/updateUserInfo.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//클라이언트 데이터 받기
		UserDTO userDTO = new UserDTO();
		HttpSession session = request.getSession();
		String user_id= session.getAttribute("user_id").toString();
		
		userDTO.setUser_id(user_id);
		userDTO.setUser_password(request.getParameter("user_password"));
		userDTO.setUser_name(request.getParameter("user_name"));
		userDTO.setUser_email(request.getParameter("user_email"));
		userDTO.setUser_phone(request.getParameter("user_phone"));
		userDTO.setUser_birthday(request.getParameter("user_birthday"));
		//날짜 병합
		String address1 = request.getParameter("postcode")+request.getParameter("addr1")+request.getParameter("addr3");
		userDTO.setUser_address(address1);
		//세션에서 user_id 가져오기
		
		
		
		
		//서비스로 로그인 요청
		ServletContext application = request.getServletContext();
		UpdateUserService updateUserService = (UpdateUserService)application.getAttribute("updateUserService");
		updateUserService.UpdateUserInfo(userDTO);
		
		
		
		response.sendRedirect("UserInfo");
	}
	
	
}
