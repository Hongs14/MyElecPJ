package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.cart.CartDTO;

public class CartDAO {

	public String insertCart(CartDTO cartDTO, Connection conn) throws Exception {
		String result = null;
		int rsResult = 0;

			// 자동 커밋 기능 끄기
			conn.setAutoCommit(false);

			// cart_detail에 insert
			String sql1 = "INSERT INTO cart_detail (cart_detail_id, cart_detail_item_count, product_id, users_id) "
					+ "VALUES (seq_cart_detail_id.nextval, ?, ?, ?)";

			PreparedStatement pstmt1 = conn.prepareStatement(sql1);
			pstmt1.setInt(1, cartDTO.getCart_detail_item_count());
			pstmt1.setInt(2, cartDTO.getProduct_id());
			pstmt1.setString(3, cartDTO.getUser_id());

			int rows1 = pstmt1.executeUpdate();
			if (rows1 == 0)
				throw new Exception("장바구니에 추가되지 않았음.");
			pstmt1.close();

			// 장바구니에 담겨있는 상품 총액 읽어오기
			String sql2 = "SELECT sum(product_price * c.cart_detail_item_count) as total_price "
					+ "FROM cart_detail c, product p " + "WHERE c.product_id = p.product_id and c.users_id = ? ";

			if (rows1 == 1) {
				PreparedStatement pstmt2 = conn.prepareStatement(sql2);
				pstmt2.setString(1, cartDTO.getUser_id());

				ResultSet rs = pstmt2.executeQuery();

				if (rs.next()) {
					cartDTO.setUser_cart_price(rs.getLong("total_price"));
				}
				pstmt2.close();
			}

			// 해당 사용자 장바구니의 총액 업데이트 해주기
			String sql3 = "UPDATE user_cart " + "SET user_cart_price = ? " + "WHERE users_id = ? ";

			PreparedStatement pstmt3 = conn.prepareStatement(sql3);
			pstmt3.setLong(1, cartDTO.getUser_cart_price());
			pstmt3.setString(2, cartDTO.getUser_id());

			int rows2 = pstmt3.executeUpdate();
			if (rows2 == 0)
				throw new Exception("장바구니 총합 금액이 업데이트되지 않음.");
			pstmt3.close();

			rsResult = rows1 + rows2;
			if (rsResult == 2) {
				result = "success";
			} else {
				result = "fail";
			}

			// 수동 커밋
			conn.commit();

		return result;
	}

	// 장바구니 총 갯수 출력
	public int getTotalRows(String user_id, Connection conn) throws Exception {
		int totalRows = 0;

			String sql = "SELECT count(*) " + "FROM cart_detail " + "WHERE users_id = ? ";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				totalRows = rs.getInt(1);
			}
		
		return totalRows;
	}

	// 장바구니 목록
	public List<CartDTO> selectAllList(String user_id, Connection conn) throws SQLException {
		//int pageNo = pager.getPageNo();
		List<CartDTO> cartList = new ArrayList<>();

		String sql = "SELECT c.product_id, product_name, product_price, c.users_id, cart_detail_item_count, user_cart_price, p.product_filename " + 
				"FROM product p, cart_detail c, user_cart u " + 
				"WHERE p.product_id = c.product_id and u.users_id = c.users_id and c.users_id = ? ";

		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, user_id);
	/*	pstmt.setInt(2, pageNo);
		pstmt.setInt(3, pageNo);*/
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {
			CartDTO cartDTO = new CartDTO();
			cartDTO.setProduct_id(rs.getInt("product_id"));
			cartDTO.setProduct_name(rs.getString("product_name"));
			cartDTO.setProduct_price(rs.getInt("product_price"));
			cartDTO.setUser_id(rs.getString("users_id"));
			cartDTO.setCart_detail_item_count(rs.getInt("cart_detail_item_count"));
			cartDTO.setUser_cart_price(rs.getLong("user_cart_price"));
			cartDTO.setProduct_filename(rs.getString("product_filename"));
			cartList.add(cartDTO);
		}
		rs.close();
		pstmt.close();
		
		return cartList;
	}

	// 장바구니 아이템 삭제
	public String delCartItem(CartDTO cartDTO, Connection conn) throws Exception {	
		String result = null;

			// 자동 커밋 기능 끄기
			conn.setAutoCommit(false);

			String sql = "DELETE FROM cart_detail WHERE product_id=? and users_id=? ";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cartDTO.getProduct_id());
			pstmt.setString(2, cartDTO.getUser_id());
			
			int queryResult = pstmt.executeUpdate();
			pstmt.close();
			
			// 수동 커밋
			conn.commit();
		if (queryResult == 1) {
			result = "success";
		}
		else {
			result = "fail";
		}
		
		return result;
	}
	
	public String updateCartItem(CartDTO cartDTO, Connection conn) throws SQLException {
		String result = null;
		
		String sql = "UPDATE cart_detail SET cart_detail_item_count = ? WHERE users_id = ? and product_id = ? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, cartDTO.getCart_detail_item_count());
		pstmt.setString(2, cartDTO.getUser_id());
		pstmt.setInt(3, cartDTO.getProduct_id());
		int queryResult = pstmt.executeUpdate();
		if(queryResult==1) {	
			result = "success";
		}
		else {
			result = "fail";
		}
		
		pstmt.close();
		return result;
	}

	public String updateSumPrice(CartDTO cartDTO, Connection conn) throws Exception {
		String result = null;
		String sql = ""
				+"update user_cart set user_cart_price =(select sum(p.product_price*cd.cart_detail_item_count) "
				+ "from cart_detail cd, product p  where p.product_id = cd.product_id and users_id = ?) " 
				+ "where users_id=? ";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, cartDTO.getUser_id());
		pstmt.setString(2, cartDTO.getUser_id());
		int queryResult = pstmt.executeUpdate();
		
		if(queryResult==1) {	
			result = "success";
		}
		else {
			result = "fail";
		}
		
		pstmt.close();
		return result;
	}

}
