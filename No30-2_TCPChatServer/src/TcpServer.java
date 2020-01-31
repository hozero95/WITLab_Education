import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JTextArea;

public class TcpServer extends Thread {
	int port;
	JTextArea jta;
	Socket socket;
	ServerSocket serverSocket;
	
	
	BufferedReader br;
	BufferedWriter bw;
	
	public TcpServer(int port, JTextArea jta) {
		this.port = port;
		this.jta = jta;
		try {
			serverSocket = new ServerSocket(port);
			socket = serverSocket.accept();
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMsg(String msg) {
		try {
			bw.write(msg);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		jta.append(msg + "\r\n");
	}
	
	public void run() {
		String msg = "";
		while(true) {
			try {
				msg = br.readLine();
				jta.append("Client : " + msg + "\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			jta.setCaretPosition(jta.getText().length());
		}
	}
}
