package Controller.product;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.product.ProductDTO;
import service.ProductDetailService;

@WebServlet(name = "Controller.productDetailController", urlPatterns ="/productDetail")
public class productDetailController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//수정해야됨
		request.getRequestDispatcher("/WEB-INF/views/productDetail.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDTO productDTO = new ProductDTO();
		ServletContext application = request.getServletContext();
		ProductDetailService productdetailService = (ProductDetailService)application.getAttribute("productDetailService");
		
		request.getRequestDispatcher("/WEB-INF/views/productDetail.jsp").forward(request, response);
	}
}
