import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.rmi.UnknownHostException;

import javax.swing.JTextArea;

public class UdpComm extends Thread {
	int myPort, yourPort;
	String ip;
	JTextArea jta;
	
	InetAddress ia;
	DatagramSocket ds;
	byte[] buffer = new byte[30];
	
	public UdpComm(int myPort, int yourPort, String ip, JTextArea jta) {
		this.myPort = myPort;
		this.yourPort = yourPort;
		this.ip = ip;
		this.jta = jta;
		try {
			ds = new DatagramSocket(myPort);
			ia = InetAddress.getByName(ip);
		} catch (SocketException | java.net.UnknownHostException e) {
			e.printStackTrace();
		}
	}
	
	public void sendMsg(String content) {
		buffer = content.getBytes();
		DatagramPacket dp = new DatagramPacket(buffer, buffer.length, ia, yourPort);
		try {
			ds.send(dp);
		} catch (IOException e) {
			e.printStackTrace();
		}
		jta.append("나 : " + content + "\r\n");
	}
	
	public void run() {
		while(true) {
			DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
			try {
				ds.receive(dp);
			} catch (IOException e) {
				e.printStackTrace();
			}
			String msg = new String(dp.getData(), 0, dp.getLength());
			jta.append("상대방 : " + msg + "\r\n");
		}
	}
}
