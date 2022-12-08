package service.deprecated;

import javax.servlet.ServletContext;

import dao.CartDAO;
import dto.cart.CartDTO;

public class CartService {
	private ServletContext application;
	
	public CartService(ServletContext application) {
		this.application = application;
	}
	
	public void cartList(CartDTO cartDTO) {
		System.out.println("장바구니 목록 보기");		
		CartDAO cartDAO = (CartDAO) application.getAttribute("cartDAO");
		//cartDAO.insert(cart, null);
	}
}
