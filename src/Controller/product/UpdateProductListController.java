package Controller.product;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import dto.product.ProductDTO;
import service.my.UpdateProductListService;

@WebServlet(name="Controller.UpdateProductListController", urlPatterns="/UpdateProductList")
public class UpdateProductListController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/WEB-INF/views/productList.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UpdateProductListService updateProductListService = (UpdateProductListService) request.getServletContext().getAttribute("updateProductListService");
		
		ProductDTO product = new ProductDTO();
		product.setCategory_name(request.getParameter("category_id"));
		product.setProduct_company(request.getParameter("category_id"));
		product.setProduct_content(request.getParameter("category_id"));
		product.setProduct_name(request.getParameter("category_id"));
		product.setProduct_price(Integer.parseInt(request.getParameter("category_id")));
		product.setProduct_reserve(Integer.parseInt(request.getParameter("category_id")));
		product.setProduct_totalpoint(Integer.parseInt(request.getParameter("category_id")));
		product.setSubcategory_name(request.getParameter("category_id"));
		
		Part filePart = request.getPart("battach");
		if (!filePart.getSubmittedFileName().equals("")) {
			String fileName = filePart.getSubmittedFileName();
			String savedName = new Date().getTime() + "-" + fileName;
			String fileType = filePart.getContentType();
			
			product.setBfileName(fileName);
			product.setBsavedName(savedName);
			product.setBfileType(fileType);
			
			String filePath = "C:/temp/download/" + savedName;
			filePart.write(filePath);
		}
		
		updateProductListService.updatePageList(product);

		response.sendRedirect("ReadProductList");
	}
}
