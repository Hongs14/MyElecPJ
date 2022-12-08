package service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ReviewBoardDAO;
import dto.review.ReviewBoardDTO;

public class CreateReviewService {
	private ServletContext application;
	private DataSource ds;
	private ReviewBoardDAO reviewBoardDAO;
	
	public CreateReviewService(ServletContext application) {
		this.application = application;
		reviewBoardDAO = (ReviewBoardDAO)application.getAttribute("reviewBoardDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public void writeReview(ReviewBoardDTO reviewBoardDTO) {
		Connection conn = null;
		try {
			conn = ds.getConnection();
			reviewBoardDAO.insertReviewBoard(reviewBoardDTO, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (Exception e) {}
		}
	}

}
