package service;

import javax.servlet.ServletContext;

import dao.ReviewBoardDAO;
import dto.review.ReviewBoardDTO;

public class CreateReviewService {
	private ServletContext application;
	
	public CreateReviewService(ServletContext application) {
		this.application = application;
		
	}
	
	public void write(ReviewBoardDTO reviewBoardDTO) {
		System.out.println("리뷰작성에 성공했습니다.");
		ReviewBoardDAO reviewBoardDAO = (ReviewBoardDAO)application.getAttribute("createReviewService");
	}
}
