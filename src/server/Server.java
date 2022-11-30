package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
	private ServerSocket serverSocket;
	ExecutorService threadPool=Executors.newFixedThreadPool(100);
	private static Connection conn;
	
	//서버 시작
	public void start() throws IOException {
		serverSocket = new ServerSocket(50001);

		System.out.println("[서버] 시작됨");
		
		Thread thread = new Thread(()->{
			try {
				while(true) {
					Socket socket = serverSocket.accept();
					SocketClient sc = new SocketClient(this, socket);
				}
			
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
		});
		thread.start(); 

	}
	
	// 서버 종료
	public void stop() {
		try {
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			serverSocket.close();
			threadPool.shutdownNow();
			System.exit(0);
			
			System.out.println("[서버] 종료됨 ");
		} 
		catch (IOException e1) {}
	}

	//메인메소드
	public static void main(String[] args) {
		Server Server = new Server();
		
		try {
			Server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
