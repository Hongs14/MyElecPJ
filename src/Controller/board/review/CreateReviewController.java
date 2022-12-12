package Controller.board.review;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import dto.review.ReviewBoardDTO;
import service.CreateReviewService;

@WebServlet(name = "Controller.CreateReviewController", urlPatterns = "/CreateReview")
@MultipartConfig(maxFileSize=1024*1024*10, maxRequestSize=1024*1024*20)
public class CreateReviewController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/createReview.jsp").forward(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application = request.getServletContext();
		CreateReviewService createReviewService = (CreateReviewService)application.getAttribute("createReviewService");
		
		//문자 파트
		ReviewBoardDTO reviewBoardDTO = new ReviewBoardDTO();
		HttpSession session = request.getSession();

		reviewBoardDTO.setUsers_id(session.getAttribute("user_id").toString());
		reviewBoardDTO.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
		reviewBoardDTO.setReview_board_reviewpoint(Integer.parseInt(request.getParameter("s_score")));
		reviewBoardDTO.setReview_board_title(request.getParameter("title"));
		reviewBoardDTO.setReview_board_content(request.getParameter("content"));
		
		request.setAttribute("review", reviewBoardDTO);
		
		//파일 파트
//		Part filePart = request.getPart("review_attach");
//		if(!filePart.getSubmittedFileName().equals("")) {
//			String fileName = filePart.getSubmittedFileName();
//			String savedName = new Date().getTime()+"-"+fileName;
//			String fileType = filePart.getContentType();
//			
//			System.out.println(fileName);
//			System.out.println(savedName);
//			System.out.println(fileType);
//			
//			reviewBoardDTO.setReview_filename(fileName);
//			reviewBoardDTO.setReview_savedname(savedName);
//			reviewBoardDTO.setReview_contenttype(fileType);
//			
//			String filePath = "resources\\\\images\\\\download\\\\"+savedName;
//			filePart.write(filePath);
//		}

		int result = createReviewService.writeReview(reviewBoardDTO); 
		
		if (result != 0) {
			request.setAttribute("ReviewBoard", reviewBoardDTO);
			response.sendRedirect("ReadReview?id=" + result);
			
		}

		else {
			response.sendRedirect("CreateReview");
		}
		
	}
}
