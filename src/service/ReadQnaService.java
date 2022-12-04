package service;

import javax.servlet.ServletContext;

import dao.QnABoardDAO;
import dto.qna.QnABoardProductDTO;

public class ReadQnaService {
private ServletContext application;
	
	public ReadQnaService(ServletContext application) {
		this.application = application;
	}
	
	public void readQna(QnABoardProductDTO qnABoardProductDTO) {
		System.out.println("작성된 문의글 상세보기");
		QnABoardDAO qnABoardDAO = (QnABoardDAO) application.getAttribute("qnABoardDAO");
		//QnABoardDAO.insert(qna, null);
	}
}
