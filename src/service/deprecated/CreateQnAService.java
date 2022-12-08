package service.deprecated;

import javax.servlet.ServletContext;

import dao.QnABoardDAO;
import dto.qna.QnABoardDTO;

public class CreateQnAService {
	private ServletContext application;
	
	public CreateQnAService(ServletContext application) {
		this.application = application;
		
	}
	
	public void write(QnABoardDTO qnABoardDTO) {
		System.out.println("리뷰작성에 성공했습니다.");
		QnABoardDAO qnABoardDAO = (QnABoardDAO)application.getAttribute("QnABoardDAO");
	}
}
