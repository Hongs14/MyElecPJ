package Controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller.homeController", urlPatterns = "/home")
public class homeController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//코드 작성
		//클라이언트 생성
		//요청 받음
		//데이터를 처리함
		//서버랑연결함
		//데이터받아옴
		request.setAttribute("pathList0", "carou1.png");
		request.setAttribute("pathList1", "carou2.png");
		request.setAttribute("pathList2", "carou3.png");
		request.setAttribute("pathList3", "carou4.png");
		request.setAttribute("pathList4", "map.png");
		request.setAttribute("pathList5", "otilogo.png");
		request.setAttribute("pathList6", "kosalogo.png");
		
		//받은 데이터를 해가지고 jsp만들고 클라이언트로 보냄
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}
}
