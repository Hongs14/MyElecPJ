package Controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

import service.AdminDeleteUserService;

@WebServlet(name="Controller.adminDeleteUserController", urlPatterns="/deleteUser")
public class adminDeleteUserController extends HttpServlet{
	
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/adminUserList.jsp").forward(request, response);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//받은 ID
		String data = request.getParameter("chk_arr");
		JSONArray jsonArray = new JSONArray(data);
		int checkUserNum = jsonArray.length();
		
		//Service 전달할 UserID
		List<String> deleteUser = new ArrayList<>();
		for(int i = 0; i<checkUserNum; i++) {
			deleteUser.add(jsonArray.getString(i));
		}
	
		//서비스 요청
		ServletContext application = request.getServletContext();
		AdminDeleteUserService adminDeleteUserService = (AdminDeleteUserService) application.getAttribute("adminDeleteUserService");
		//서비스 메소드 호출
		int result = adminDeleteUserService.UserDelete(deleteUser);
		
		
		
//		ajax 사용 시 데이터 돌려주는 방법
//		PrintWriter pw = new PrintWriter(response.getWriter());
//		pw.write("");
//		pw.flush();
//		pw.close();
	    
	    
	}
	
}
