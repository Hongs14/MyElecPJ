package service.my;

import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ProductDAO;
import dto.product.ProductDTO;

public class ReadProductService {
	private ServletContext application;
	private DataSource ds;
	private ProductDAO productDAO;
	public ReadProductService(ServletContext application) {
		this.application = application;
		productDAO = (ProductDAO)application.getAttribute("productDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public ProductDTO getProduct(int id) {
		ProductDTO result = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = productDAO.selectProductContent(id, conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		
		return result;
	}

}
