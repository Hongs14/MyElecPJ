package Controller.product;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.product.ProductDTO;
import service.my.ReadProductDetailService;

@WebServlet(name = "Controller.ReadProductDetailController", urlPatterns ="/ReadProductDetail")
public class ReadProductDetailController extends HttpServlet{
   //클라이언트가 요청하면 실행
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  int product_id = 0;
	  
	  if (request.getParameter("productId") == null) {
		  product_id = 1;
	  }
	  else {
		  product_id = Integer.parseInt(request.getParameter("productId"));
	  }

      
      ServletContext application = request.getServletContext();
      //ReadProductDetailService readProductDetailService = (ReadProductDetailService) request.getServletContext().getAttribute("readProductDetailService");
      ReadProductDetailService readProductDetailService = new ReadProductDetailService(application);
      ProductDTO productDTO = readProductDetailService.getProductDetail(product_id);
      
      request.setAttribute("Product", productDTO);
      
      request.getRequestDispatcher("/productDetail.jsp").forward(request, response);
   
   }

}