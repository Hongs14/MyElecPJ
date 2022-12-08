package Controller.board.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.qna.QnABoardDTO;
import service.ReadQnADetailService;

@WebServlet(name="Controller.ReadQnaController", urlPatterns="/ReadQna")
public class ReadQnaController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		ReadQnADetailService readQnaService = (ReadQnADetailService) application.getAttribute("readQnaService");
				
	//new ReadQnaService(application);

//		int qnaNo=Integer.parseInt(request.getParameter("qnaNo"));
		
		int qnaNo =2884;
		QnABoardDTO readQna = readQnaService.getReadQna(qnaNo);
		
		request.setAttribute("readQna", readQna);
		
		request.getRequestDispatcher("/WEB-INF/views/readQna.jsp").forward(request, response);
	}
	
}
