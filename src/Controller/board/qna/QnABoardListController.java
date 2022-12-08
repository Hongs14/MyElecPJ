package Controller.board.qna;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.qna.QnABoardDTO;
import service.QnABoardListService;
import util.Pager;

@WebServlet(name = "Controller.QnABoardListController", urlPatterns = "/QnABoardList")
public class QnABoardListController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// QnABoardListService 서비스로 요청
		ServletContext application = request.getServletContext();
		QnABoardListService qnaBoardListService = new QnABoardListService(application);

		String strPageNo = request.getParameter("pageNo");
		if (strPageNo == null) {
			strPageNo = "1";
		}
		int pageNo = Integer.parseInt(strPageNo);

		// 페이징 대상이 되는 전체 행수 얻기
		int totalQnABoardPageNum = qnaBoardListService.getTotalQnABoardPageNum();

		// pager 생성
		Pager pager = new Pager(5, 5, totalQnABoardPageNum, pageNo);

		//
		ArrayList<QnABoardDTO> qnaBoardList = qnaBoardListService.getQnABoardList(pager);
		
		request.setAttribute("pager", pager);
		request.setAttribute("qnaBoardList", qnaBoardList);
		
		request.getRequestDispatcher("/WEB-INF/views/qnaBoardList.jsp").forward(request, response);
	}
}
