package service.deprecated;

import javax.servlet.ServletContext;

import dao.ReviewBoardDAO;
import dto.review.ReviewBoardDTO;

public class ReviewboardListService {
	private ServletContext application;
	
	public ReviewboardListService(ServletContext application) {
		this.application = application;
	}
	
	public void readList(ReviewBoardDTO board) {
		System.out.println("게시글 등록 함");
		ReviewBoardDAO reviewBoardDAO = (ReviewBoardDAO) application.getAttribute("boardDao");
		//reviewBoardDAO.insert(board);
	}
}
