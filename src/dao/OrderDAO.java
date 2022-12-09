package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.order.OrderDTO;
import dto.order.OrderDetailDTO;
import dto.order.OrderReadListDTO;
import util.Pager;

public class OrderDAO {
	public int insertOrder(OrderDTO order, OrderDetailDTO orderDetail, Connection conn) throws SQLException {
		int price = order.getOrders_price();
		String userId = order.getUsers_id();
		String address = order.getOrders_address();
		
		String SQL
			="INSERT INTO ORDERS "
			+"VALUES ("
			+"SEQ_ORDERS_ID.nextval, SYSDATE, ?, ?, ?, DEFAULT"
			+")";
		
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setInt(1, price);
		pstmt.setString(2, userId);
		pstmt.setString(3, address);
		int result = pstmt.executeUpdate();
		
		int count = orderDetail.getOrder_detail_item_count();
		int productId = orderDetail.getProduct_id();
		SQL
			="INSERT INTO ORDER_DETAIL "
			+"VALUES ("
			+"SEQ_ORDER_DETAIL_ID.nextval, ?, SEQ_ORDERS_ID.currval, ?"
			+")";
		
		pstmt = conn.prepareStatement(SQL);
		pstmt.setInt(1, count);
		pstmt.setInt(2, productId);
		result += pstmt.executeUpdate();
		
		pstmt.close();
		
		return result;
		
	}
	
	public OrderDTO selectOrder(OrderDTO order, Connection conn) throws SQLException {
		String id = order.getUsers_id();
		OrderDTO result = new OrderDTO();
		String SQL
			="SELECT ORDERS.USER_ID, ORDERS.ORDERS_ID, PRODUCT_NAME, ORDER_DETAIL_ITEM_COUNT, ORDERS_DATE, ORDERS_PRICE, ORDERS_STATUS, ORDERS_ADDRESS "
			+"FROM ORDERS, ORDER_DETAIL, PRODUCT "
			+"WHERE ORDERS.USERS_ID = ? AND "
		    +"ORDERS.ORDERS_ID = ORDER_DETAIL.ORDERS_ID AND "
		    +"ORDER_DETAIL.PRODUCT_ID = PRODUCT.PRODUCT_ID";

		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()) {
			result.setUsers_id(rs.getString("USERS_ID"));
			result.setOrders_id(rs.getInt("ORDERS_ID"));
			result.setProduct_name(rs.getString("PRODUCT_NAME"));
			result.setOrder_detail_item_count(rs.getInt("ORDER_DETAIL_ITEM_COUNT"));
			result.setOrders_date(rs.getString("ORDERS_DATE"));
			result.setOrders_price(rs.getInt("ORDERS_PRICE"));
			result.setOrders_status(rs.getString("ORDERS_STATUS"));
			result.setOrders_address(rs.getString("ORDERS_ADDRESS"));
		}
		
		rs.close();
		pstmt.close();
		
		return result;
	}
	
	public OrderDTO selectOrder(int id, Connection conn) throws SQLException {
		String SQL
			="SELECT ORDERS.USERS_ID, ORDERS.ORDERS_ID, PRODUCT_NAME, ORDER_DETAIL_ITEM_COUNT, ORDERS_DATE, ORDERS_PRICE, ORDERS_STATUS, ORDERS_ADDRESS "
			+"FROM ORDERS, ORDER_DETAIL, PRODUCT "
			+"WHERE ORDERS.ORDERS_ID = ? AND "
	    	+"ORDERS.ORDERS_ID = ORDER_DETAIL.ORDERS_ID AND "
	    	+"ORDER_DETAIL.PRODUCT_ID = PRODUCT.PRODUCT_ID";
		
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setInt(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		OrderDTO order = new OrderDTO();
		
		if(rs.next()) {
			order.setUsers_id(rs.getString("USERS_ID"));
			order.setOrders_id(rs.getInt("ORDERS_ID"));
			order.setProduct_name(rs.getString("PRODUCT_NAME"));
			order.setOrder_detail_item_count(rs.getInt("ORDER_DETAIL_ITEM_COUNT"));
			order.setOrders_date(rs.getString("ORDERS_DATE"));
			order.setOrders_price(rs.getInt("ORDERS_PRICE"));
			order.setOrders_status(rs.getString("ORDERS_STATUS"));
			order.setOrders_address(rs.getString("ORDERS_ADDRESS"));
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return order;
	}
	
	public List<OrderDTO> selectOrderList(Pager pager, OrderDTO order, Connection conn) throws SQLException {
		int pageNo = pager.getPageNo();
		StringBuilder sqlBuilder = new StringBuilder();
		sqlBuilder.append("SELECT USERS_ID, ORDERS_ID, PRODUCT_NAME, ORDERS_DATE, ORDERS_STATUS, RNUM ");
		sqlBuilder.append("FROM ( ");
		sqlBuilder.append("	SELECT ORDERS.USERS_ID, ORDERS.ORDERS_ID, PRODUCT_NAME, ORDERS_DATE, ORDERS_STATUS, rownum as RNUM ");
		sqlBuilder.append(" FROM ORDERS, ORDER_DETAIL, PRODUCT ");
		sqlBuilder.append(" WHERE ORDERS.ORDERS_ID = ORDER_DETAIL.ORDERS_ID AND ");
		sqlBuilder.append("  ORDER_DETAIL.PRODUCT_ID = PRODUCT.PRODUCT_ID AND ");
		sqlBuilder.append("  (rownum - 1) < ? ");
		sqlBuilder.append("	) ");
		sqlBuilder.append("WHERE (RNUM - 1) > = ?");

		PreparedStatement pstmt = conn.prepareStatement(sqlBuilder.toString());
		
		pstmt.setInt(1, pageNo * 5);
		pstmt.setInt(2, ((pageNo - 1) * 5));
		ResultSet rs = pstmt.executeQuery();
		
		List<OrderDTO> orders = new ArrayList<>();
		
		while (rs.next()) {
			OrderDTO orderDTO = new OrderDTO();
			orderDTO.setUsers_id(rs.getString("USERS_ID"));
			orderDTO.setOrders_id(rs.getInt("ORDERS_ID"));
			orderDTO.setProduct_name(rs.getString("PRODUCT_NAME"));
			orderDTO.setOrders_date(rs.getString("ORDERS_DATE"));
			orderDTO.setOrders_status(rs.getString("ORDERS_STATUS"));
			orders.add(orderDTO);
		}
		
		rs.close();
		pstmt.close();
		
		return orders;
	}
	
	public int getTotalRows(OrderDTO order, Connection conn) throws SQLException {
		String SQL
				="SELECT COUNT(*) as total "
				+"FROM ORDERS WHERE USERS_ID = ? "
				;

		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setString(1, order.getUsers_id());
		ResultSet rs = pstmt.executeQuery();
		
		int result;
		if (rs.next()) {
			result = rs.getInt("total");
		}
		else {
			result = 0;
		}
		rs.close();
		pstmt.close();
		return result;
	}
	
	public int getTotalJoinRows(OrderReadListDTO receivedDTO, Connection conn) throws SQLException {
		String SQL
				="SELECT COUNT(*) as total "
				+"FROM ORDERS, ORDER_DETAIL, PRODUCT "
				+"WHERE ORDERS.ORDERS_ID = ORDER_DETAIL.ORDERS_ID AND "
				+"ORDER_DETAIL.PRODUCT_ID = PRODUCT.PRODUCT_ID AND ";
		
		if (!(receivedDTO.getCondition() == null)) {
			if (receivedDTO.getCondition().equals("LIKE")) {
				SQL = SQL.concat("PRODUCT_NAME LIKE ? ");
			}
			else {
				SQL = SQL.concat("PRODUCT_NAME = ? ");
			}
			
		}
		
		PreparedStatement pstmt = conn.prepareStatement(SQL);
		
		if (!(receivedDTO.getCondition() == null)) {
			if (receivedDTO.getCondition().equals("LIKE")) {
				pstmt.setString(1, "%" + receivedDTO.getProduct_name() + "%");
			}
			else {
				pstmt.setString(1, receivedDTO.getProduct_name());
			}
			
		}
		
		ResultSet rs = pstmt.executeQuery();
		int result;
		if (rs.next()) {
			result = rs.getInt("total");
		}
		else {
			result = 0;
		}
		rs.close();
		pstmt.close();
		conn.close();
		return result;
	}
	
	public void updateOrder(OrderDTO order, Connection conn) throws SQLException {
		int id = order.getOrders_id();
		String status = order.getOrders_status();
		
		if (!status.equals("X")) {
			String SQL
			="UPDATE ORDERS "
			+"SET ORDERS_STATUS = ? "
			+"WHERE ORDERS_ID = ?";
		
			PreparedStatement pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, status);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			
			pstmt.close();
			conn.close();
		}
		
	}
	
	public void deleteOrder(OrderDTO order, Connection conn) throws SQLException {
		int id = order.getOrders_id();
		String SQL = "DELETE FROM ORDERS WHERE ORDERS_ID = ?";

		PreparedStatement pstmt = conn.prepareStatement(SQL);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
}