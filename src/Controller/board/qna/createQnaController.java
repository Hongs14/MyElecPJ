package Controller.board.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.qna.QnABoardDTO;
import service.CreateQnAService;

@WebServlet(name = "Controller.createQnaController", urlPatterns = "/createQna")
public class createQnaController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		QnABoardDTO qnaBoardDTO = new QnABoardDTO();
		
		ServletContext application = request.getServletContext();
		CreateQnAService createQnAService = (CreateQnAService)application.getAttribute("createQnAService");
		createQnAService.write(qnaBoardDTO);
	
		request.getRequestDispatcher("/WEB-INF/views/createQna.jsp").forward(request, response);
	
		
	}
}