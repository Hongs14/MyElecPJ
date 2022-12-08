package service;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.QnABoardDAO;
import dto.qna.QnABoardDTO;

public class CreateQnAService {
   private ServletContext application;
   private DataSource ds;
   private QnABoardDAO qnaBoardDAO;
   
   public CreateQnAService(ServletContext application) {
      this.application = application;
      qnaBoardDAO = (QnABoardDAO) application.getAttribute("QnABoardDAO");
      ds = (DataSource) application.getAttribute("dataSource");
   }
   
   public int writeQnA(QnABoardDTO qnaBoardDTO) {
      int result = 0;
      Connection conn = null;
      try {
         conn = ds.getConnection();
         result = qnaBoardDAO.insertQnABoard(qnaBoardDTO,conn);
      } catch(Exception e) {
         e.printStackTrace();
      } finally {
         try {conn.close();} catch (Exception e) {}
      }
      return result;
   }
}