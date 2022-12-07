package service.my;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ReviewBoardDAO;
import dto.product.ProductDTO;
import dto.review.ReviewBoardDTO;
import util.Pager;

public class ReadReviewBoardListService {
	private ServletContext application;
	private DataSource ds;
	private ReviewBoardDAO reviewBoardDAO;
	public ReadReviewBoardListService(ServletContext application) {
		this.application = application;
		reviewBoardDAO = (ReviewBoardDAO)application.getAttribute("reviewBoardDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public int getTotalBoardNum() {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = reviewBoardDAO.getTotalRows(conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		
		return result;
	}
	
	public List<ReviewBoardDTO> getPageList(Pager pager) {
		List<ReviewBoardDTO> result = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = reviewBoardDAO.selectAllList(pager, conn);
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
