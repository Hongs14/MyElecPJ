package Controller.board.review;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.review.ReviewBoardDTO;
import service.CreateReviewService;

@WebServlet(name = "Controller.CreateReviewController", urlPatterns = "/CreateReview")
public class CreateReviewController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ReviewBoardDTO reviewBoardDTO = new ReviewBoardDTO();
		
		ServletContext application = request.getServletContext();
		CreateReviewService createReviewService = (CreateReviewService)application.getAttribute("createReviewService");
		createReviewService.writeReview(reviewBoardDTO); 
		
		
		request.getRequestDispatcher("/WEB-INF/views/createReview.jsp").forward(request, response);
	}
}
