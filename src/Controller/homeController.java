package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import client.Client;

@WebServlet(name = "Controller.homeController", urlPatterns = "/home")
public class homeController extends HttpServlet{
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//코드 작성
		//클라이언트 생성
		//요청 받음
		//데이터를 처리함
		//서버랑연결함
		//데이터받아옴
		System.out.println("1");
		Client.ConnectServer();
		
		System.out.println("2");
		Client.sendRequest();
		System.out.println("3");
		
		JSONObject receivedFromServer = Client.receivedFromServer();
		System.out.println("4");
		
		JSONArray array = receivedFromServer.getJSONArray("images_name");
		int length = array.length();
		
		for (int i = 0; i < length; i++) {
			request.setAttribute("pathList" + i, array.getString(i));
		}
		System.out.println("5");
		
		//받은 데이터를 해가지고 jsp만들고 클라이언트로 보냄
		request.getRequestDispatcher("/WEB-INF/views/home.jsp").forward(request, response);
	}
}
