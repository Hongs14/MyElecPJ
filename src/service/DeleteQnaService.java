package service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.QnABoardDAO;



public class DeleteQnaService {
	private ServletContext application;
	private DataSource ds;
	private QnABoardDAO qnaBoardDAO;

	public DeleteQnaService(ServletContext application) {
		this.application = application;
		qnaBoardDAO = (QnABoardDAO) application.getAttribute("QnABoardDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}

	public int deleteQnA(int qnaNo) {
		Connection conn = null;
		int result = 0;
		try {
			conn = ds.getConnection();
			result=qnaBoardDAO.deleteQnABoard(qnaNo, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e) {
			}
		}
		return result;
	}
}