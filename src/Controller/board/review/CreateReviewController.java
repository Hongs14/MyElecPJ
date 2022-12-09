package Controller.board.review;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.review.ReviewBoardDTO;
import service.CreateReviewService;

@WebServlet(name = "Controller.CreateReviewController", urlPatterns = "/CreateReview")
public class CreateReviewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/createReview.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		CreateReviewService createReviewService = (CreateReviewService)application.getAttribute("createReviewService");
		
		ReviewBoardDTO reviewBoardDTO = new ReviewBoardDTO();
		HttpSession session = request.getSession();

		reviewBoardDTO.setUsers_id(session.getAttribute("user_id").toString());
		reviewBoardDTO.setReview_board_reviewpoint(Integer.parseInt(request.getParameter("send_score")));
		reviewBoardDTO.setReview_board_title(request.getParameter("title"));
		reviewBoardDTO.setReview_board_content(request.getParameter("content"));
		
		System.out.println("cr: "+reviewBoardDTO.getUsers_id());
		System.out.println("cr: "+reviewBoardDTO.getReview_board_content());
		System.out.println("cr: "+reviewBoardDTO.getReview_board_reviewpoint());
		System.out.println("cr: "+reviewBoardDTO.getReview_board_title());
		
		/*
		request.setAttribute("review", reviewBoardDTO);

		createReviewService.writeReview(reviewBoardDTO); 
		
		response.sendRedirect("ProductDetail");
		
		request.getRequestDispatcher("/WEB-INF/views/createReview.jsp").forward(request, response);*/
	}
}
