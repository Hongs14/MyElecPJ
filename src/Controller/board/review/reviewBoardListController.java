package Controller.board.review;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.review.ReviewBoardDTO;
import service.ReviewboardListService;

@WebServlet(name="Controller.boardListController", urlPatterns="/boardList")
public class reviewBoardListController extends HttpServlet{

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ReviewBoardDTO reviewBoardDTO = new ReviewBoardDTO();
		
		//서비스로 회원 가입 요청
		ServletContext application = request.getServletContext();
		ReviewboardListService reviewBoardListService = (ReviewboardListService) application.getAttribute("QnAboardListService"); 
		reviewBoardListService.readList(reviewBoardDTO);
		
		request.getRequestDispatcher("/WEB-INF/views/boardList.jsp").forward(request, response);
	}
}
