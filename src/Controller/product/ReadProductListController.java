package Controller.product;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.product.ProductDTO;
import service.my.ReadProductListService;
import util.Pager;

@WebServlet(name="Controller.ReadProductListController", urlPatterns="/ReadProductList")
public class ReadProductListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/views/productList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      String strPageNo = request.getParameter("pageNo");
	      
	      if (strPageNo == null) {
	         strPageNo = "1";      
	      }
	      
	      int pageNo = Integer.parseInt(strPageNo);
	      
	      //BoardService 객체 얻기
	      ServletContext application = request.getServletContext();
	      ReadProductListService readProductListService = (ReadProductListService) application.getAttribute("readProductListService");
	      
	      //페이징 대상이 되는 전체 행수 얻기
	      int totalBoardNum = readProductListService.getTotalBoardNum();
	      
	      //pager 생성
	      Pager pager = new Pager(10, 5, totalBoardNum, pageNo);
	      
	      //pageNo에 해당하는 게시물 가져오기
	      List<ProductDTO> pageList = readProductListService.getPageList(pager);
	      
	      //jsp에서 사용할수 있도록 request 범위에 저장
	      request.setAttribute("pager", pager);
	      request.setAttribute("pageList", pageList);
	}
}
