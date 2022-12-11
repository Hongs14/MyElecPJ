package Controller.order;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dto.order.OrderDTO;
import service.ReadOrderListService;
import util.Pager;

@WebServlet(name="Controller.ReadOrderListController", urlPatterns="/ReadOrderList")
public class ReadOrderListController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("user_id");
		
		int pageNo = 1;
		if (request.getParameter("pageNo") != null) {
			pageNo = Integer.parseInt(request.getParameter("pageNo"));
		}

		
		
		ServletContext application = request.getServletContext();
		ReadOrderListService readOrderListSerivce = (ReadOrderListService) application.getAttribute("readOrderListService");
		
		OrderDTO order = new OrderDTO();
		order.setUsers_id(userId);

		//페이징 대상이 되는 전체 행수 얻기
		int totalBoardNum = readOrderListSerivce.getTotalBoardNum(order);
		  
		//pager 생성
		Pager pager = new Pager(5, 5, totalBoardNum, pageNo);
		  
		//pageNo에 해당하는 게시물 가져오기
		List<OrderDTO> pageList = readOrderListSerivce.getPageList(pager, order);
		  
		//jsp에서 사용할수 있도록 request 범위에 저장
		request.setAttribute("pager", pager);
		request.setAttribute("pageList", pageList);
		
		
		request.getRequestDispatcher("/WEB-INF/views/orderList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}
}
