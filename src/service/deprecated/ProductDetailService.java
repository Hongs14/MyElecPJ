package service.deprecated;

import javax.servlet.ServletContext;

import dao.ProductDAO;
import dto.product.ProductDTO;

public class ProductDetailService {
	private ServletContext application;
	
	public ProductDetailService(ServletContext application) {
		this.application = application;
	}
	
	public void read(ProductDTO productDTO) {
		System.out.println("ProductDetail정보를 가져옴");
		ProductDAO productDAO = (ProductDAO) application.getAttribute("productDAO");
	}
}
