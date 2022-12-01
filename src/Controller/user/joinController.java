package Controller.user;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user.UserDTO;
import service.JoinService;

@WebServlet(name="Controller.joinController", urlPatterns="/join")
public class joinController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/join.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		//클라이언트가 보낸 데이터 얻기
		UserDTO userDTO = new UserDTO();
		userDTO.setUser_name(request.getParameter("uname"));
		userDTO.setUser_id(request.getParameter("uid"));		
		userDTO.setUser_password(request.getParameter("password"));
		userDTO.setUser_email(request.getParameter("email"));
		userDTO.setUser_phone(request.getParameter("phone"));
		userDTO.setUser_birthday(request.getParameter("birth"));
		userDTO.setUser_address(request.getParameter("address"));
		//userDTO.setUser_wishProduct(request.getParameter("likeProduct"));
			
		//서비스로 회원가입 요청
		ServletContext application = request.getServletContext();
		JoinService joinService = (JoinService) application.getAttribute("joinService"); 
		joinService.join(userDTO);
		
		response.sendRedirect("joinController");
	}
}
