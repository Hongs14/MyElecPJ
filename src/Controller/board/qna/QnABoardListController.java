package Controller.board.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.qna.QnABoardDTO;
import service.BoardListService;

@WebServlet(name="Controller.QnABoardDTOListController", urlPatterns="/QnABoardDTOList")
public class QnABoardListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		QnABoardDTO QnABoardDTO = new QnABoardDTO();
		
		//서비스로 회원 가입 요청
		ServletContext application = request.getServletContext();
		BoardListService QnABoardListService = (BoardListService) application.getAttribute("QnAboardListService"); 
		QnABoardListService.readList(QnABoardDTO);
		
		request.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(request, response);
	}
}
