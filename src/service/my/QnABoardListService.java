package service.my;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.QnABoardDAO;
import dao.ReviewBoardDAO;
import dto.cart.CartDTO;
import dto.qna.QnABoardDTO;
import util.Pager;

public class QnABoardListService {
	private ServletContext application;
	private DataSource ds;
	private QnABoardDAO qnaBoardDAO;
	
	public QnABoardListService(ServletContext application) {
		this.application = application;
		qnaBoardDAO = (QnABoardDAO) application.getAttribute("QnABoardDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public ArrayList<QnABoardDTO> getQnABoardList(Pager pager) {
		ArrayList<QnABoardDTO> result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = qnaBoardDAO.selectAllList(pager, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		return result;		
	}

	public int getTotalQnABoardPageNum() {
		int result = 0;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = qnaBoardDAO.getTotalRows(conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
		return result;
	}
}
