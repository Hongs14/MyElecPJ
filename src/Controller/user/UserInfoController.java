package Controller.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user.UserDTO;
import service.UserInfoService;


@WebServlet(name="Controller.UserInfoController", urlPatterns="/UserInfo")
public class UserInfoController extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_id((String) request.getSession().getAttribute("user_id"));
		userDTO.setUser_password((String)request.getSession().getAttribute("user_password"));
		
		ServletContext application = request.getServletContext();
		UserInfoService userInfoService = (UserInfoService)application.getAttribute("userInfoService");
		
		
		UserDTO result = userInfoService.UserInfo(userDTO);
		request.setAttribute("result", result);
		
		request.getRequestDispatcher("/WEB-INF/views/userInfo.jsp").forward(request, response);
	}
	

	
	
}
