package service;


import java.sql.SQLException;

import org.json.JSONObject;

import dao.ImageDAO;

public class ImageService {
	public JSONObject getImageName() throws SQLException {
		ImageDAO imageDAO = new ImageDAO();
		return imageDAO.selectImageName();
	}
}
