package Controller.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user.UserDTO;
import service.LoginService;

@WebServlet(name = "Controller.loginController", urlPatterns = "/login")
public class loginController extends HttpServlet{
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		//클라이언트 데이터 얻기
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_id(request.getParameter("user_id"));
		userDTO.setUser_password(request.getParameter("user_password"));
		
		
		//서비스로 로그인 요청
		ServletContext application = request.getServletContext();
		LoginService loginService = (LoginService)application.getAttribute("loginService");
		//loginService.join(userDTO);
		
		//response.sendRedirect("loginController");
	}
	
	
}
