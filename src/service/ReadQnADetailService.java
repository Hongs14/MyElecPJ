package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.QnABoardDAO;
import dto.qna.QnABoardDTO;

public class ReadQnADetailService {
private ServletContext application;
private DataSource ds;
private QnABoardDAO qnaBoardDAO;
	
	public ReadQnADetailService(ServletContext application) {
		this.application = application;
		qnaBoardDAO = (QnABoardDAO) application.getAttribute("QnABoardDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public QnABoardDTO getReadQna(int qnaNo) {
		QnABoardDTO result = null;
		Connection conn = null;
		try {
			conn = ds.getConnection();
			result = qnaBoardDAO.selectOneQnA(qnaNo, conn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (Exception e){
				e.printStackTrace();
			}
		}
		return result;
	}


}
