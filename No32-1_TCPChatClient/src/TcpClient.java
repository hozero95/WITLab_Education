import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class TcpClient extends Thread {
	String ip;
	int port;
	JTextArea jta;
	Socket socket;
	
	BufferedReader br;
	BufferedWriter bw;
	
	public TcpClient(String ip, int port, JTextArea jta) {
		this.ip = ip;
		this.port = port;
		this.jta = jta;
		try {
			socket = new Socket(ip, port);
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
	}
	
	public void run() {
		String msg = "";
		while(true) {
			try {
				msg = br.readLine();
				jta.append(msg + "\r\n");
			} catch (IOException e) {
				e.printStackTrace();
			}
			jta.setCaretPosition(jta.getText().length());
		}
	}
}
