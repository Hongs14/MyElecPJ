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
import dto.user.UserDTO;
import service.CreateQnAService;

@WebServlet(name = "Controller.CreateQnaController", urlPatterns = "/CreateQna")
public class CreateQnaController extends HttpServlet {
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

		CreateQnAService createQnAService = (CreateQnAService) request.getServletContext()
				.getAttribute("createQnAService");
		// 객체 만들기
		QnABoardDTO qnaBoardDTO = new QnABoardDTO();
		// 세션 객체 생성
		HttpSession session = request.getSession();

		// 문자파트
		qnaBoardDTO.setUsers_id(session.getAttribute("user_id").toString());
		qnaBoardDTO.setQna_board_title(request.getParameter("qna_board_title"));
		qnaBoardDTO.setQna_board_content(request.getParameter("qna_board_content"));
		qnaBoardDTO.setQna_category_id(Integer.parseInt(request.getParameter("qna_category_id")));

		int result = createQnAService.writeQnA(qnaBoardDTO);
		//qnaBoardDTO.setQna_board_id(Integer.parseInt(request.getParameter("qna_board_id")));
				
		if (result != 0) {
			request.setAttribute("qnaBoard", qnaBoardDTO);
			response.sendRedirect("ReadQna?id=" + result);
			System.out.println(result);
			
			//System.out.println(qnaBoardDTO.getQna_board_id());
//	         request.getRequestDispatcher("WEB-INF/views/readQna.jsp").forward(request, response);
		}

		else {
			response.sendRedirect("CreateQna");
		}

	}
}