package Controller.board.review;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.review.ReviewBoardDTO;
import service.ReadReviewService;

@WebServlet(name="Controller.readReviewController", urlPatterns="/readReview")
public class readReviewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/readReview.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		//클라이언트가 보낸 데이터 얻기
		ReviewBoardDTO reviewBoardDTO = new ReviewBoardDTO();
			
		//서비스로 리뷰 보기 요청
		ServletContext application = request.getServletContext();
		ReadReviewService readReviewService = (ReadReviewService) application.getAttribute("readReviewService"); 
		readReviewService.readReview(reviewBoardDTO);
		
		response.sendRedirect("readReviewController");
	}
}
