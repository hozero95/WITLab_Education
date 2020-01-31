import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatClientFrame extends JFrame {
	Container ct;
	JPanel jpTop, jpBottom;
	JTextField jtfIP, jtfPort, jtfChat;
	JButton jbConnect, jbSend;
	JTextArea jta;
	JScrollPane jsp;
	
	TcpClient client = null;
	
	public ChatClientFrame(String title, int w, int h) {
		ct = getContentPane();
		jpTop = new JPanel();
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jpBottom = new JPanel();
		jtfIP = new JTextField();
		jtfPort = new JTextField();
		jbConnect = new JButton("접속");
		jtfChat = new JTextField();
		jbSend = new JButton("보내기");
		
		jpTop.setLayout(new GridLayout(2, 3, 5, 5));
		jpTop.add(new JLabel("Server IP", JLabel.CENTER));
		jpTop.add(new JLabel("Server Port", JLabel.CENTER));
		jpTop.add(new JLabel(""));
		jpTop.add(jtfIP);
		jpTop.add(jtfPort);
		jpTop.add(jbConnect);
		
		jpBottom.setLayout(new BorderLayout(5, 5));
		jpBottom.add(new JLabel("채팅", JLabel.CENTER), BorderLayout.WEST);
		jpBottom.add(jtfChat, BorderLayout.CENTER);
		jpBottom.add(jbSend, BorderLayout.EAST);
		
		ct.setLayout(new BorderLayout(5, 5));
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jpBottom, BorderLayout.SOUTH);
		
		jbConnect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client = new TcpClient(jtfIP.getText(), Integer.parseInt(jtfPort.getText()), jta);
				client.start();
			}
		});
		jbSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				client.sendMsg(jtfChat.getText());
				jtfChat.setText("");
			}
		});
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
