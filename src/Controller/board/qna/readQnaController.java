package Controller.board.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.qna.QnABoardProductDTO;
import service.ReadQnaService;

@WebServlet(name="Controller.readQnaController", urlPatterns="/readQna")
public class readQnaController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/readQna.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		//클라이언트가 보낸 데이터 얻기
		QnABoardProductDTO qnABoardProductDTO = new QnABoardProductDTO();
			
		//서비스로 Qna 상세보기 요청
		ServletContext application = request.getServletContext();
		ReadQnaService readQnaService = (ReadQnaService) application.getAttribute("readQnaService"); 
		readQnaService.readQna(qnABoardProductDTO);
		
		response.sendRedirect("readQnaController");
	}
}
