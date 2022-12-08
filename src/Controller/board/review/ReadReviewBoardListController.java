package Controller.board.review;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.review.ReviewBoardDTO;
import service.ReadReviewBoardListService;
import util.Pager;
@WebServlet(name="Controller.ReadReviewBoardListController", urlPatterns="/ReadReviewBoardList")
public class ReadReviewBoardListController extends HttpServlet{
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strPageNo = request.getParameter("pageNo");
		if (strPageNo == null) {
		   strPageNo = "1";      
		}
		int pageNo = Integer.parseInt(strPageNo);
		
		//서비스로 리뷰 보기 요청
		ServletContext application = request.getServletContext();
		//ReadReviewService readReviewService = (ReadReviewService) application.getAttribute("readReviewService");
		ReadReviewBoardListService readReviewBoardListService = new ReadReviewBoardListService(application);
		
		int totalBoardNum = readReviewBoardListService.getTotalBoardNum();
		Pager pager = new Pager(6, 5, totalBoardNum, pageNo);
		List<ReviewBoardDTO> pageList = readReviewBoardListService.getPageList(pager);
		
		request.setAttribute("pageList", pageList);
		request.setAttribute("pager", pager);
		
		request.getRequestDispatcher("/WEB-INF/views/reviewBoardList.jsp").forward(request, response);
	}
}
