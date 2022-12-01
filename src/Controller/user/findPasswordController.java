package Controller.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user.UserDTO;
import service.FindPasswordService;

@WebServlet(name = "Controller.findPasswordController", urlPatterns = "/findPassword")
public class findPasswordController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		
		//서비스로 회원 가입 요청
		ServletContext application = request.getServletContext();
		FindPasswordService findPasswordService = (FindPasswordService) application.getAttribute("findPasswordService"); 
		findPasswordService.findPassword(userDTO);
		request.getRequestDispatcher("/WEB-INF/views/findPassword.jsp").forward(request, response);
	}
}
