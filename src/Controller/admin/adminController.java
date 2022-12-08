package Controller.admin;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.user.UserDTO;
import service.AdminUserService;
import util.Pager;

@WebServlet(name="Controller.adminController", urlPatterns="/admin")
public class adminController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		ServletContext application = request.getServletContext();
		AdminUserService adminUserService = (AdminUserService)application.getAttribute("adminUserService");

		//pager
		int totalBoardNum = adminUserService.getTotalBoardNum();
		String strpageNo = request.getParameter("pageNo");
		if(strpageNo == null) {
			strpageNo = "1";
		}
		int pageNo = Integer.parseInt(strpageNo);
		
		Pager pager = new Pager(5, 5, totalBoardNum, pageNo);
		
		//page에 해당하는 유저 목록
		List<UserDTO> userList = adminUserService.getUserList(pager);
		
		
		request.setAttribute("pager", pager);
		request.setAttribute("userList", userList);
		
		request.getRequestDispatcher("/WEB-INF/views/adminUserList.jsp").forward(request, response);
		
	}
	
}
