package Controller.board.qna;

import java.io.IOException;

import javax.servlet.ServletContext;
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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("user_id");
		QnABoardDTO upQna = new QnABoardDTO();

		upQna.setQna_board_id(Integer.parseInt(request.getParameter("qna_board_id")));
		upQna.setQna_board_title(request.getParameter("qna_board_title"));
		upQna.setQna_board_content(request.getParameter("qna_board_content"));
		upQna.setQna_category_id(Integer.parseInt(request.getParameter("qna_category_id")));

		request.setAttribute("userId", userId);
		request.setAttribute("updatedQnABoard", upQna);

		request.getRequestDispatcher("/WEB-INF/views/updateQna.jsp").forward(request, response);

	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 서블릿 얻기
		ServletContext application = request.getServletContext();
		UpdateQnAService updateQnAService = (UpdateQnAService) application.getAttribute("updateQnAService");
		// 세션 객체 얻기
		HttpSession session = request.getSession();
		// 객체 만들기
		QnABoardDTO upQna = new QnABoardDTO();

		upQna.setQna_board_id(Integer.parseInt(request.getParameter("qna_board_id")));
		upQna.setQna_board_title(request.getParameter("qna_board_title"));
		upQna.setQna_board_content(request.getParameter("qna_board_content"));
		upQna.setQna_category_id(Integer.parseInt(request.getParameter("qna_category_id")));

		int result = updateQnAService.updateQnA(upQna);
		
		response.sendRedirect("ReadQna?id=" + request.getParameter("qna_board_id"));
	}
}