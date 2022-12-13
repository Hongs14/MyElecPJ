package Controller.board.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.qna.QnABoardDTO;
import service.ReadQnADetailService;

@WebServlet(name="Controller.ReadQnaController", urlPatterns="/ReadQna")
public class ReadQnaController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			id = "1";
		}
		int qnaNo=Integer.parseInt(id);
			
		ServletContext application = request.getServletContext();
		ReadQnADetailService readQnADetailService = (ReadQnADetailService) application.getAttribute("readQnADetailService");
		
		QnABoardDTO readQna = readQnADetailService.getReadQna(qnaNo);
		
		HttpSession session = request.getSession();
		request.setAttribute("userId", session.getAttribute("user_id"));
		request.setAttribute("readQna", readQna);
		request.getRequestDispatcher("/WEB-INF/views/readQna.jsp").forward(request, response);
	}
	
}
