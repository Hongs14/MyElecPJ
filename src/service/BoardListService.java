package service;

import javax.servlet.ServletContext;

import dao.QnABoardDAO;
import dto.qna.QnABoardDTO;

public class BoardListService {
	private ServletContext application;
	
	public BoardListService(ServletContext application) {
		this.application = application;
	}
	
	public void readList(QnABoardDTO board) {
		System.out.println("게시글 등록 함");
		QnABoardDAO qnABoardDAO = (QnABoardDAO) application.getAttribute("boardDao");
		//qnABoardDAO.insert(board);
	}
}