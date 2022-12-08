package service;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ReviewBoardDAO;
import dto.product.ProductDTO;
import dto.review.ReviewBoardDTO;
import util.Pager;

public class ReadReviewService {
	private ServletContext application;
	private DataSource ds;
	private ReviewBoardDAO reviewBoardDAO;
	public ReadReviewService(ServletContext application) {
		this.application = application;
		reviewBoardDAO = (ReviewBoardDAO)application.getAttribute("reviewBoardDAO");
		ds = (DataSource) application.getAttribute("dataSource");
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
