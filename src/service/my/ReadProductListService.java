package service.my;

import java.sql.Connection;
import java.util.List;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ProductDAO;
import dto.product.ProductDTO;
import util.Pager;

public class ReadProductListService {
	private ServletContext application;
	private DataSource ds;
	private ProductDAO productDAO;
	public ReadProductListService(ServletContext application) {
		this.application = application;
		productDAO = (ProductDAO)application.getAttribute("productDAO");
		ds = (DataSource) application.getAttribute("dataSource");
	}
	
	public int getTotalBoardNum() {
		int result = 0;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = productDAO.countRows(conn);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		finally {
			try {conn.close();} catch (Exception e) {}
		}
		
		return result;
	}
	
	public List<ProductDTO> getPageList(Pager pager) {
		List<ProductDTO> result = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = productDAO.selectPageList(pager, conn);
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
