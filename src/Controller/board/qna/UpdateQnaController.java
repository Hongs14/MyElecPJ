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

		request.getRequestDispatcher("/WEB-INF/views/createQna.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		UpdateQnAService updateQnAService = (UpdateQnAService) request.getServletContext()
				.getAttribute("updateQnAService");
		// 객체 만들기
		QnABoardDTO upQna = new QnABoardDTO();
		// 세션 객체 생성
		HttpSession session = request.getSession();

		// 문자파트
		upQna.setQna_board_title(request.getParameter("qna_board_title"));
		upQna.setQna_board_content(request.getParameter("qna_board_content"));
		upQna.setQna_category_name(request.getParameter("qna_category_name"));

		String result = updateQnAService.updateQnA(upQna);

		if (result != null) {
			request.setAttribute("updatedQnABoard", upQna);
			response.sendRedirect("readQna?=" + session.getAttribute("users_id").toString());
//	         request.getRequestDispatcher("WEB-INF/views/readQna.jsp").forward(request, response);
		}

		else {
			response.sendRedirect("UpdateQna");
		}

	}
}