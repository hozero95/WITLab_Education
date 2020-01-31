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

public class ChatServerFrame extends JFrame {
	Container ct;
	JPanel jpTop, jpBottom;
	JTextArea jta;
	JScrollPane jsp;
	JTextField jtfPort, jtfChat;
	JButton jbCreate, jbSend;
	
	TcpServer server = null;
	
	public ChatServerFrame(String title, int w, int h) {
		ct = getContentPane();
		jpTop = new JPanel();
		jpBottom = new JPanel();
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jtfPort = new JTextField();
		jbCreate = new JButton("생성");
		jtfChat = new JTextField();
		jbSend = new JButton("보내기");
		
		jpTop.setLayout(new GridLayout(2, 2, 5, 5));
		jpTop.add(new JLabel("Server Port", JLabel.CENTER));
		jpTop.add(new JLabel(""));
		jpTop.add(jtfPort);
		jpTop.add(jbCreate);
		
		jpBottom.setLayout(new BorderLayout(5, 5));
		jpBottom.add(new JLabel("채팅", JLabel.CENTER), BorderLayout.WEST);
		jpBottom.add(jtfChat, BorderLayout.CENTER);
		jpBottom.add(jbSend, BorderLayout.EAST);
		
		ct.setLayout(new BorderLayout(5, 5));
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jpBottom, BorderLayout.SOUTH);
		
		jbCreate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server = new TcpServer(Integer.parseInt(jtfPort.getText()), jta);
				server.start();
			}
		});
		jbSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server.sendMsg("Server : " + jtfChat.getText());
				jtfChat.setText("");
			}
		});
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
