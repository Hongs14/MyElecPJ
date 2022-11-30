package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.json.JSONArray;
import org.json.JSONObject;

import server.ConnectionProvider;

public class ImageDAO {
	Connection conn = ConnectionProvider.getConnection();
	public JSONObject selectImageName() throws SQLException {
		String sql = "Select image_name from images";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		JSONArray array = new JSONArray();
		JSONObject returnJSON = new JSONObject();
		
		while (rs.next()) {
			String imageName = rs.getString("image_name");
			array.put(imageName);
		}
		
		returnJSON.put("images_name", array);
		
		rs.close();
		conn.close();
		pstmt.close();
		
		return returnJSON;
	}
}
