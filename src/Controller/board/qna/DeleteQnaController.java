package Controller.board.qna;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.order.OrderDTO;
import service.DeleteQnaService;

@WebServlet(name = "Controller.DeleteQnaController", urlPatterns = "/DeleteQna")
public class DeleteQnaController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("users_id");			
		DeleteQnaService deleteQnaService = (DeleteQnaService) request.getServletContext()
				.getAttribute("deleteQnaService");

		int qnaNo=Integer.parseInt(request.getParameter("qna_board_id"));
		int result = deleteQnaService.deleteQnA(qnaNo);
		
		if (result != 0) {
			request.setAttribute("userId", userId);

			response.sendRedirect("ReadQnABoardList");
		}

	}

}
