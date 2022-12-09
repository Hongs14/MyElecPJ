package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletContext;
import javax.sql.DataSource;

import dao.ProductDAO;
import dto.product.ProductDTO;

public class ReadProductDetailService {
   private ServletContext application;
   private DataSource ds;
   private ProductDAO productDAO;
   
   public ReadProductDetailService(ServletContext application) {
      this.application = application;
      productDAO = (ProductDAO) application.getAttribute("productDAO");
      ds = (DataSource) application.getAttribute("dataSource");
   }

   public ProductDTO getProductDetail(int product_id) {
      ProductDTO result = null;
      ProductDTO result1 = null;
      
      Connection conn = null;
      try {
         conn = ds.getConnection();
         result = productDAO.selectProductContent(product_id, conn);
         result1 = productDAO.averageStar(result, conn);
  
      } catch (Exception e) {
         e.printStackTrace();
      } finally {
         try { conn.close();} catch (Exception e) {}
      }
      return result1;
   }
   
   public ProductDTO getImage(int product_id) {
		ProductDTO result = null;
		Connection conn = null;
		
		try {
			conn = ds.getConnection();
			result = productDAO.getImage(product_id, conn);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     
		
		return result;
	}
}