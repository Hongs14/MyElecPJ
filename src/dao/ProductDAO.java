package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import dto.product.ProductDTO;
import util.Pager;


public class ProductDAO {
	

	//상품 총 갯수 출력
	public int getTotalRows(ProductDTO productDTO, Connection conn) throws SQLException {
		int totalRows = 0;

		String sql = "SELECT count(*) " +
					"FROM product " + 
					"WHERE category_id = ? and subcategory_id = ? ";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, productDTO.getCategory_id());
		pstmt.setInt(2, productDTO.getSubcategory_id());
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			totalRows = rs.getInt(1);
		}

		return totalRows;
	}
	
	//상품 목록 조회
	public List<ProductDTO> selectAllList(Pager pager, ProductDTO productDTO, Connection conn) throws SQLException {
		List<ProductDTO> productListDTOs = new ArrayList<>();
		int pageNo = pager.getPageNo();
		
		String sql = "SELECT rnum, product_id, product_name, product_price, category_id, category_name, subcategory_id, subcategory_name, product_totalpoint " +
				 "FROM ( " + 
				    "SELECT rownum as rnum, product_id, product_name, product_price, category_id, category_name, subcategory_id, subcategory_name, product_totalpoint " + 
				    "FROM ( " +
				        "SELECT product_id, product_name, product_price, c.category_id, category_name, s.subcategory_id, subcategory_name, product_totalpoint " +
				        "FROM product p, subcategory s, category c " +
				        "WHERE p.subcategory_id = s.subcategory_id and s.category_id = c.category_id and p.category_id = c.category_id " +
				             "and p.category_id = ? and p.subcategory_id = ? " +
				        "ORDER BY product_id " +
				        ") " +
				    "WHERE rownum <= (? * 5) " +
				    ") " + 
				"WHERE rnum >= ((? - 1) * 5) + 1 ";
	
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, productDTO.getCategory_id());
		pstmt.setInt(2, productDTO.getSubcategory_id());
		pstmt.setInt(3, pageNo);
		pstmt.setInt(4, pageNo);
		ResultSet rs = pstmt.executeQuery();
					
		while(rs.next()) {
			ProductDTO product = new ProductDTO();
			
			product.setProduct_id(rs.getInt("product_id"));
			product.setProduct_name(rs.getString("product_name"));
			product.setProduct_price(rs.getInt("product_price"));
			product.setProduct_totalpoint(rs.getDouble("product_totalpoint"));
			
			productListDTOs.add(product);
		}
		
		rs.close();
		pstmt.close();
		
		return productListDTOs;
		
	}
	
	//상품 상세 정보 출력
	public ProductDTO selectProductContent(int product_id, Connection conn) throws SQLException {
		ProductDTO productDTO = null;

			String sql = "SELECT product_id, product_name, product_price, product_company, product_content, c.category_id, category_name, s.subcategory_id, subcategory_name, product_totalpoint " +
						"FROM product p, category c, subcategory s " + 
						"WHERE c.category_id = s.category_id and s.subcategory_id = p.subcategory_id and c.category_id = p.category_id " +
						"and product_id = ? ";
		
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_id);
			
			ResultSet rs = pstmt.executeQuery();
						
			while(rs.next()) {
				productDTO = new ProductDTO();
				
				productDTO.setProduct_id(rs.getInt("product_id"));
				productDTO.setProduct_name(rs.getString("product_name"));
				productDTO.setProduct_price(rs.getInt("product_price"));
				productDTO.setProduct_company(rs.getString("product_company"));
				productDTO.setProduct_content(rs.getString("product_content"));
				productDTO.setCategory_id(rs.getInt("category_id"));
				productDTO.setCategory_name(rs.getString("category_name"));
				productDTO.setSubcategory_id(rs.getInt("subcategory_id"));
				productDTO.setSubcategory_name(rs.getString("subcategory_name"));
				productDTO.setProduct_totalpoint(rs.getDouble("product_totalpoint"));
//				productDTO.setProduct_filename(rs.getString("product_filename"));
//	            productDTO.setProduct_savedname(rs.getString("product_savedname"));
//	            productDTO.setProduct_contenttype(rs.getString("product_contenttype"));

				
			}
			rs.close();
			pstmt.close();


		return productDTO;
	}
	
	  //리뷰 평점 구하기
public ProductDTO averageStar(ProductDTO productDTO, Connection conn) throws Exception{
	double average=0.0;
	String result= "";
	String sql = "select sum(r.review_board_reviewpoint) as pointsum, count(*) as count " + 
			"from review_board r, product p  "+ 
			"where p.product_id = r.product_id and p.product_id = ?";
	      
	PreparedStatement pstmt = conn.prepareStatement(sql);
	pstmt.setInt(1, productDTO.getProduct_id());
	  
	ResultSet rs = pstmt.executeQuery();
	if (rs.next()) {
		if (rs.getDouble("count") == 0) {
			result = "0.0";
		}
		else {
			average = rs.getDouble("pointsum") / rs.getDouble("count");
			DecimalFormat df = new DecimalFormat("#.#");
			result = df.format(average);	
		}
	}
	  
	rs.close();
	pstmt.close();
	      
	productDTO.setProduct_totalpoint(Double.parseDouble(result));
	
	return productDTO;
	}

//이미지 얻기
public ProductDTO getImage(int product_id, Connection conn) throws SQLException {
	String sql = "select product_filename, product_savedname, product_contenttype ";
			sql += "from product ";
			sql += "where product_id = ? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, product_id);
			System.out.println(product_id);
			ResultSet rs = pstmt.executeQuery();
			
			ProductDTO result = new ProductDTO();
		while(rs.next()){
			result.setProduct_filename(rs.getString("product_filename"));
			result.setProduct_savedname(rs.getString("product_savedname"));
			result.setProduct_contenttype(rs.getString("product_contenttype"));
			
			System.out.println(result.getProduct_filename());
		}
	rs.close();
	pstmt.close();
	
	return result;
}
}
	
