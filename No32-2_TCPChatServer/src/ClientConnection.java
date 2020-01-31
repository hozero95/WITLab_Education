import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JTextArea;

public class ClientConnection extends Thread {
	private int port;
	private JTextArea jta;
	private ServerSocket ss;
	
	private Vector<Socket> client = new Vector<Socket>();
	ClientThread ct;
	
	DBConnection connection;
	
	//생성자
	public ClientConnection(int port, JTextArea jta) {
		this.port = port;
		this.jta = jta;
		ct = new ClientThread(null);
		
		connection = new DBConnection();
	}
	
	//서버 오픈
	public void openServer() {
		try {
			ss= new ServerSocket(port);
			jta.append("서버가 연결되었습니다.\r\n");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//클라이언트 접속 시도 대기
	public void clientAccept() {
		try {
			while(true) {
				Socket sc = ss.accept();
				ClientThread thread = new ClientThread(sc);
				thread.start();
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void sendMsg(String msg) {
		try {
			ct.send("관리자 : " + msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//클라이언트 접속 스레드
	public void run() {
		try {
			clientAccept();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	class ClientThread extends Thread {
		private Socket sc = null;
		
		public ClientThread(Socket sc) {
			this.sc = sc;
		}
		
		public void send(String str) throws IOException {
			for(Socket s : client) {
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
				bw.write(str);
				bw.newLine();
				bw.flush();
			}
			jta.append(str + "\r\n");
			jta.setCaretPosition(jta.getText().length());
			connection.logChat("관리자", str);
		}
		
		public void run() {
			String ip = null;
			String str;
			try {
				client.add(sc);
				ip = sc.getInetAddress().getHostAddress();
				BufferedReader br = new BufferedReader(new InputStreamReader(sc.getInputStream()));
				
				//입장 알림
				str = "(" + ip + ")님이 입장하셨습니다.";
				send(str);
				
				//클라이언트 메세지 읽기
				while((str = br.readLine()) != null) {
					//다른 클라이언트에 전송
					for(Socket s : client) {
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
						bw.write("(" + ip + ") : " + str);
						bw.newLine();
						bw.flush();
					}
					jta.append("(" + ip + ") : " + str + "\r\n");
					jta.setCaretPosition(jta.getText().length());
					connection.logChat(ip, str);
				}
			}catch(Exception e) {
				//퇴장 알림
				str = "(" + ip + ") 님이 퇴장하셨습니다.";
				try {
					for(Socket s : client) {
						if(s == sc) {
							continue;
						}
						BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
						bw.write(str);
						bw.newLine();
						bw.flush();
					}
					jta.append(str + "\r\n");
					jta.setCaretPosition(jta.getText().length());
					connection.logChat(ip, str);
				}catch(Exception e2) {
					e2.printStackTrace();
				}
				client.remove(sc);
				sc = null;
			}
		}
	}
}