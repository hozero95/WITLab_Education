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

public class UdpCalcFrame extends JFrame {
	Container ct;
	JPanel jpTop, jpBottom;
	JTextArea jta;
	JScrollPane jsp;
	JTextField jtfMyPort, jtfYourPort, jtfIP, jtfChat;
	JButton jbSet, jbSend;
	
	UdpComm udp = null;
	
	public UdpCalcFrame(String title, int w, int h) {
		ct = getContentPane();
		jpTop = new JPanel();
		jpBottom = new JPanel();
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jtfMyPort = new JTextField();
		jtfYourPort = new JTextField();
		jtfIP = new JTextField();
		jbSet = new JButton("설정");
		jtfChat = new JTextField();
		jbSend = new JButton("보내기");
		
		jpTop.setLayout(new GridLayout(2, 4, 5, 5));
		jpTop.add(new JLabel("My Port", JLabel.CENTER));
		jpTop.add(new JLabel("Your Port", JLabel.CENTER));		
		jpTop.add(new JLabel("Your IP", JLabel.CENTER));
		jpTop.add(new JLabel(""));
		jpTop.add(jtfMyPort);
		jpTop.add(jtfYourPort);
		jpTop.add(jtfIP);
		jpTop.add(jbSet);
		
		jpBottom.setLayout(new BorderLayout(5, 5));
		jpBottom.add(new JLabel("채팅", JLabel.CENTER), BorderLayout.WEST);
		jpBottom.add(jtfChat, BorderLayout.CENTER);
		jpBottom.add(jbSend, BorderLayout.EAST);
		
		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jta, BorderLayout.CENTER);
		ct.add(jpBottom, BorderLayout.SOUTH);
		
		jbSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				udp = new UdpComm(Integer.parseInt(jtfMyPort.getText()), Integer.parseInt(jtfYourPort.getText()), jtfIP.getText(), jta);
				udp.start();
			}
		});
		jbSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				udp.sendMsg(jtfChat.getText());
				jtfChat.setText("");
			}
		});
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
