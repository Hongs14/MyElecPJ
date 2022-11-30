package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;

import org.json.JSONObject;

import service.ImageService;

public class SocketClient {
	// 필드
	Socket socket;
	DataInputStream dis;
	DataOutputStream dos;
	Server server;

	// 생성자
	public SocketClient(Server server, Socket socket) throws IllegalArgumentException, IllegalAccessException {
		try {
			this.server = server;
			this.socket = socket;
			this.dis = new DataInputStream(socket.getInputStream());
			this.dos = new DataOutputStream(socket.getOutputStream());
			receiveJSON();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// JSON 수신
	public void receiveJSON() {
		server.threadPool.execute(() -> {
			try {
				while (true) {
					// command는 json에서 얻어오기
					// socket을 통해 json을 얻어와서 receviedJSON에 넣어줍니다
					//JSONObject receivedJSON = new JSONObject(dis.readUTF());
					JSONObject sendJSON = null;
					//ControllerMapper.sendToDB(receviedJSON); // receviesJSON을 이제 DB로 보내줍니다.
					
					ImageService imageService = new ImageService();
					
					try {
						sendJSON = imageService.getImageName();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					//System.out.println("socket received: " + receviedJSON);
					//JSONObject sendJSON = ControllerMapper.receviedFromDB();

					//System.out.println("socket sendJSON: " + sendJSON);
					dos.writeUTF(sendJSON.toString());
					dos.flush();
				}
			} catch (IOException e) {
				close();
			} /*catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}*/
		});
	}

	public void close() {
		try {
			socket.close();
		} catch (IOException e) {
		}
	}

}