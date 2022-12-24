package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ReviewBoardDAO;
import dto.review.ReviewBoardDTO;

public class UpdateReviewService {
	private ServletContext application;
	private DataSource ds;
	private ReviewBoardDAO reviewBoardDAO;
	
	public UpdateReviewService(ServletContext application) {
		this.application = application;
		reviewBoardDAO = (ReviewBoardDAO)application.getAttribute("reviewBoardDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public int writeReview(ReviewBoardDTO reviewBoardDTO) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = ds.getConnection();
			result = reviewBoardDAO.insertReviewBoard(reviewBoardDTO, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try { conn.close(); } catch (Exception e) {}
		}
		
		return result;
	}

	public int updateReview(ReviewBoardDTO reviewBoardDTO) {
		Connection conn = null;
		int result = 0;
		
		try {
			conn = ds.getConnection();
			result = reviewBoardDAO.updateReviewBoard(reviewBoardDTO, conn);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public ReviewBoardDTO getReview(int id) {
		ReviewBoardDTO result = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = reviewBoardDAO.selectOnereview(id, conn);
			
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
