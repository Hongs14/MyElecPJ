package service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.QnABoardDAO;
import dto.qna.QnABoardDTO;

public class UpdateQnAService {
   private ServletContext application;
   private DataSource ds;
   private QnABoardDAO qnaBoardDAO;
   
   public UpdateQnAService(ServletContext application) {
      this.application = application;
      qnaBoardDAO = (QnABoardDAO) application.getAttribute("QnABoardDAO");
      ds = (DataSource) application.getAttribute("dataSource");
   }
   
   public String updateQnA(QnABoardDTO upQna) {
	   String result = null;
      Connection conn = null;
      try {
         conn = ds.getConnection();
         result = qnaBoardDAO.updateQnABoard(upQna,conn);
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {conn.close();} catch (Exception e) {}
      }
      return result;
   }
}