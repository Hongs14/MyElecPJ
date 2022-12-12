package service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.OrderDAO;
import dao.ReviewBoardDAO;
import dto.order.OrderDTO;

public class DeleteReviewService {
	private ServletContext application;
	private DataSource ds;
	private ReviewBoardDAO reviewBoardDAO;
	
	public DeleteReviewService(ServletContext application) {
		this.application = application;
		reviewBoardDAO = (ReviewBoardDAO)application.getAttribute("reviewBoardDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public int deleteReview(int review_board_id) {
		Connection conn = null;
		int result = 0;
		try {
			conn = ds.getConnection();
			result = reviewBoardDAO.deleteReviewBoard(review_board_id, conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		
		return result;
	}
	
}
