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

import org.json.JSONArray;
import org.json.JSONObject;

import dto.ReviewComment;
import dto.review.ReviewBoardDTO;
import service.my.ReadReviewService;

@WebServlet(name="Controller.ReadReviewController", urlPatterns="/ReadReview")
public class ReadReviewController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		if (id == null) {
			id = "1";
		}
		int reviewBoardId = Integer.parseInt(id);
		System.out.println(reviewBoardId);
		ServletContext application = request.getServletContext();
		//ReadReviewService readReviewService = (ReadReviewService) application.getAttribute("readReviewServie");
		ReadReviewService readReviewService = new ReadReviewService(application);
		ReviewBoardDTO reviewBoard = readReviewService.getReview(reviewBoardId);
		
		if (reviewBoard.getReview_board_comment() != null) {
			JSONObject commentJO = new JSONObject(reviewBoard.getReview_board_comment());
			JSONArray commentJA = commentJO.getJSONArray("comment");
			JSONArray dateJA = commentJO.getJSONArray("date");
			JSONArray userJA = commentJO.getJSONArray("user");
			int length = commentJA.length();
			List<ReviewComment> commentList = new ArrayList<>();
			ReviewComment reviewComment;
			for (int i = 0; i < length; i++) {
				reviewComment = new ReviewComment();
				reviewComment.setComment(commentJA.getString(i));
				reviewComment.setDate(dateJA.getString(i));
				reviewComment.setUser(userJA.getString(i));
				commentList.add(reviewComment);
			}
			request.setAttribute("commentList", commentList);
		}

		
		request.setAttribute("reviewBoard", reviewBoard);
		
		request.getRequestDispatcher("/readReview.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {				
		

	}
}
