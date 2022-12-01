package Controller.product;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.product.ProductListDTO;

@WebServlet(name="Controller.productListController", urlPatterns="/productList")
public class productListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/productList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ProductListDTO productListDTO = new ProductListDTO();
		productListDTO.setProduct_id(Integer.parseInt(request.getParameter("product_id")));
		productListDTO.setProduct_name(request.getParameter("product_name"));
		productListDTO.setProduct_price(Integer.parseInt(request.getParameter("product_price")));
		productListDTO.setCategory_id(Integer.parseInt(request.getParameter("category_id")));
		productListDTO.setSubcategory_id(Integer.parseInt(request.getParameter("subcategory_id")));
		productListDTO.setCategory_name(request.getParameter("category_name"));
		productListDTO.setSubcategory_name(request.getParameter("subcategory_name"));
		
		
		ServletContext application = request.getServletContext();
		ProductListDTO productListService = (ProductListDTO)application.getAttribute("ProductListService");
		//productListService. productListDTO);
		
		
		
	}
	
	
}
