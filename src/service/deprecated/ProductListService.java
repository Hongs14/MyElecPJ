package service.deprecated;

import javax.servlet.ServletContext;

import dto.product.ProductListDTO;

public class ProductListService {
	
private ServletContext application;
	
	public ProductListService(ServletContext application) {
		this.application = application;
	}
	
	public void productListView(ProductListDTO ProductListDTO) {
		System.out.println("상품을 조회합니다");
		ProductListDTO productListDTO = (ProductListDTO) application.getAttribute("ProductListDTO");
		
		
		//userDAO.selectUser(userDTO);
		
		
	}
	
	
}
