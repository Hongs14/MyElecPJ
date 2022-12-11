package Controller.board.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.qna.QnABoardDTO;
import service.UpdateQnAService;

@WebServlet(name = "Controller.UpdateQnaController", urlPatterns = "/UpdateQna")
public class UpdateQnaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setAttribute("userId", session.getAttribute("user_id"));			
		//session.setAttribute("qnaNo", session.getAttribute("qna_board_id"));	
		
		request.getRequestDispatcher("/WEB-INF/views/updateQna.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 세션 객체 생성
		HttpSession session = request.getSession();
		UpdateQnAService updateQnAService = (UpdateQnAService) request.getServletContext()
				.getAttribute("updateQnAService");
		// 객체 만들기
		QnABoardDTO upQna = new QnABoardDTO();
		//upQna.setUsers_id(session.getAttribute("user_id").toString());
		upQna.setQna_board_id(Integer.parseInt(request.getParameter("qna_board_id")));
		upQna.setQna_board_title(request.getParameter("qna_board_title"));
		upQna.setQna_board_content(request.getParameter("qna_board_content"));
		upQna.setQna_category_id(Integer.parseInt(request.getParameter("qna_category_id")));
	
		int result = updateQnAService.updateQnA(upQna);
		System.out.println(upQna.getQna_board_id());
		if (result != 0) {
			//updateQnAService.updateQnA(upQna);
			request.setAttribute("updatedQnABoard", upQna);		
			//request.setAttribute("qnaNo", upQna.getQna_board_id());		
			
			//request.setAttribute("userId", session.getAttribute("user_id"));
			//request.getRequestDispatcher("WEB-INF/views/updateQna.jsp").forward(request, response);
			response.sendRedirect("ReadQna?id=" + upQna.getQna_board_id());
//	         request.getRequestDispatcher("WEB-INF/views/readQna.jsp").forward(request, response);
		}

		else {
			response.sendRedirect("UpdateQna");
		}

	}
}