package client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Client {
	static Socket socket;
	static DataInputStream dis;
	static DataOutputStream dos;
	static Scanner scanner;
	static JSONObject sendToServer;
	static JSONObject receivedFromServer;

	public static void ConnectServer() throws IOException {
		socket = new Socket("localhost", 50001);
		dis = new DataInputStream(socket.getInputStream());
		dos = new DataOutputStream(socket.getOutputStream());
	}

	public static void DisconnectServer() {
		try {
			socket.close();
			scanner.close();
		} catch (Exception e) {
		}
		System.out.println("[클라이언트] 종료됨");
	}
	
	public static void sendRequest(JSONObject request) {
		sendToServer = request;
		try {
			dos.writeUTF(sendToServer.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void sendRequest() {
		sendToServer = null;
		try {
			//dos.writeUTF(sendToServer.toString());
			dos.writeUTF("a");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			dos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static JSONObject receivedFromServer() {
		JSONObject receivedFromServer = null;
		try {
			receivedFromServer = new JSONObject(dis.readUTF());
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return receivedFromServer;
	}

}