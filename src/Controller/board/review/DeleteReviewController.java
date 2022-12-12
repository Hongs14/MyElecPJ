package Controller.board.review;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.ReviewComment;
import dto.review.ReviewBoardDTO;
import service.DeleteReviewService;
import service.ReadReviewDetailService;

@WebServlet(name="Controller.DeleteReviewController", urlPatterns="/DeleteReview")
public class DeleteReviewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		HttpSession session = request.getSession();
		int reviewNo = Integer.parseInt(request.getParameter("review_no"));
		System.out.println("del: "+Integer.parseInt(request.getParameter("review_no")));
		
		
		DeleteReviewService deleteReviewService = (DeleteReviewService) application.getAttribute("deleteReviewService");
		deleteReviewService.deleteReview(reviewNo);
		
		response.sendRedirect("ReadReviewBoardList");
	}

}
