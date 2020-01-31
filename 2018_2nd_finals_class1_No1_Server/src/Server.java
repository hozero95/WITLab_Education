import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class Server extends Thread {
	int serverPort, clientPort;
	String ip;
	JTextArea jta;

	InetAddress ia;
	DatagramSocket ds;
	
	int count;

	public Server(int serverPort, int clientPort, String ip, JTextArea jta) {
		this.serverPort = serverPort;
		this.clientPort = clientPort;
		this.ip = ip;
		this.jta = jta;

		try {
			ds = new DatagramSocket(serverPort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		try {
			ia = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		count = 100;
	}
	
	public synchronized int count() {
		count--;
		return count;
	}

	public void sendMsg(String content) {
		byte[] buffer = new byte[50];
		buffer = content.getBytes();
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, clientPort);
		try {
			ds.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		while (true) {
			byte[] buffer = new byte[50];
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			try {
				ds.receive(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String content = new String(dp.getData(), 0, dp.getLength());

			count();
			if (count >= 0) {
				sendMsg(content);
				jta.append(content + " : 티켓을 구매했습니다. (남은 개수 : " + count + ")\r\n");
				jta.setCaretPosition(jta.getText().length());
			} else {
				jta.append("티켓이 완판되었습니다!\r\n");
				jta.setCaretPosition(jta.getText().length());
				break;
			}
		}
	}
}
