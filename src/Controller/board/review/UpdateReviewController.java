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
import service.ReadReviewDetailService;
import service.UpdateReviewService;

@WebServlet(name = "Controller.UpdateReviewController", urlPatterns = "/UpdateReview")
public class UpdateReviewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("reviewNo", Integer.parseInt(request.getParameter("reviewNo")));
		
		//상품 이름 가져오기
		ServletContext application = request.getServletContext();
		UpdateReviewService updateReviewService = (UpdateReviewService) application.getAttribute("updateReviewService");
		ReviewBoardDTO reviewBoardDTO =  updateReviewService.getReview(Integer.parseInt(request.getParameter("reviewNo")));
		request.setAttribute("list", reviewBoardDTO);
		
		
		request.getRequestDispatcher("/WEB-INF/views/updateReview.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		UpdateReviewService updateReviewService = (UpdateReviewService) application.getAttribute("updateReviewService");
		//문자 파트
		ReviewBoardDTO reviewBoardDTO = new ReviewBoardDTO();
		HttpSession session = request.getSession();
		System.out.println("reviewNo: "+ (Integer)session.getAttribute("reviewNo"));
		reviewBoardDTO.setReview_board_id((Integer)session.getAttribute("reviewNo"));
		reviewBoardDTO.setUsers_id(session.getAttribute("user_id").toString());
		reviewBoardDTO.setReview_board_reviewpoint(Integer.parseInt(request.getParameter("s_score")));
		reviewBoardDTO.setReview_board_title(request.getParameter("title"));
		reviewBoardDTO.setReview_board_content(request.getParameter("content"));
		
		request.setAttribute("review", reviewBoardDTO);
		
		int result = updateReviewService.updateReview(reviewBoardDTO);

		
		if (result != 0) {
			request.setAttribute("ReviewBoard", reviewBoardDTO);
			response.sendRedirect("ReadReview?id=" + result);
			
		}

		else {
			response.sendRedirect("CreateReview");
		}
//		request.getRequestDispatcher("/WEB-INF/views/updateReview.jsp").forward(request, response);
	}
}
