import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

import javax.swing.JTextArea;

public class Fandom extends Thread {
	int clientPort, serverPort;
	String ip;
	JTextArea jta;
	
	InetAddress ia;
	DatagramSocket ds;
	
	int[] userBuy = new int[100];
	User[] user = new User[100];
	
	public Fandom(int clientPort, int serverPort, String ip, JTextArea jta) {
		this.clientPort = clientPort;
		this.serverPort = serverPort;
		this.ip = ip;
		this.jta = jta;
		
		try {
			ds = new DatagramSocket(clientPort);
		} catch (SocketException e) {
			e.printStackTrace();
		}
		try {
			ia = InetAddress.getByName(ip);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		createUser();
	}
	
	public void createUser() {
		for(int i = 0; i < user.length; i++) {
			user[i] = new User(i + 1);
			addCallback(i);
		}
	}
	
	public void addCallback(int i) {
		user[i].setCallback(new Callback() {
			public void send(int id) {
				sendMsg(id);
			}
		});
	}
	
	public void sendMsg(int id) {
		byte[] buffer = new byte[50];
		String content = Integer.toString(id);
		buffer = content.getBytes();
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, serverPort);
		try {
			ds.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		for(int i = 0; i < user.length; i++) {
			user[i].start();
		}
		while(true) {
			byte[] buffer = new byte[50];
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			try {
				ds.receive(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			String msg = new String(dp.getData(), 0, dp.getLength());
			int userNum = Integer.parseInt(msg);
			
			userBuy[userNum - 1]++;
			jta.append(msg + " : 티켓을 구매했습니다. (보유 개수 : " + userBuy[userNum - 1] + ")\r\n");
			jta.setCaretPosition(jta.getText().length());
		}
	}
}
