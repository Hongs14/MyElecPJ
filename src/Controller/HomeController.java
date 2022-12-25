package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller.HomeController", urlPatterns = "/Home")
public class HomeController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("pathList0", "carou1.png");
		request.setAttribute("pathList1", "carou2.png");
		request.setAttribute("pathList2", "carou3.png");
		request.setAttribute("pathList3", "carou4.png");
		request.setAttribute("pathList4", "map.png");
		request.setAttribute("pathList5", "otilogo.png");
		request.setAttribute("pathList6", "kosalogo.png");
		
		//jsp로 이동
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}
}
