package service;

import javax.servlet.ServletContext;

import dao.ReviewBoardDAO;
import dto.review.ReviewBoardDTO;

public class ReadReviewService {
private ServletContext application;
	
	public ReadReviewService(ServletContext application) {
		this.application = application;
	}
	
	public void readReview(ReviewBoardDTO reviewBoardDTO) {
		System.out.println("작성된 리뷰 상세보기");
		ReviewBoardDAO reviewBoardDAO = (ReviewBoardDAO) application.getAttribute("reviewBoardDAO");
		//reviewBoardDAO.insert(review, null);
	}
}
