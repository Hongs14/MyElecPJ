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
import service.LoginService;

@WebServlet(name = "Controller.loginController", urlPatterns = "/login")
public class loginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 클라이언트 데이터 얻기
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_id(request.getParameter("user_id"));
		userDTO.setUser_password(request.getParameter("user_password"));

		// 서비스로 로그인 요청
		ServletContext application = request.getServletContext();
		LoginService loginService = (LoginService) application.getAttribute("loginService");
		UserDTO result = null;

		result = loginService.join(userDTO);
		
		if(result == null) {
			response.sendRedirect("login");
		} else {
			
			HttpSession session = request.getSession();
			session.setAttribute("user_id", result.getUser_id());
			session.setAttribute("user_password", result.getUser_password());
			
			//session에 User 등급 저장
			if(result.getUser_level()==1) {
			session.setAttribute("user_level", "VIP");
			} else if(result.getUser_level()==2) {
				session.setAttribute("user_level", "VVIP");	
			}
			session.setAttribute("user_point", result.getUser_point());
			
			
			//관리자 로그인 이동
			if (result.getUser_level()==99) {
				session.setAttribute("user_level", "ADMIN");	
				response.sendRedirect("admin");
			} else{
				response.sendRedirect("productList");
			}
			
			
		}
		
	}
}
