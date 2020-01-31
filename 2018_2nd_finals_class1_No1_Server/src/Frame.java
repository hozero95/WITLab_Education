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

public class Frame extends JFrame {
	Container ct;
	JPanel jpTop;
	JTextField jtfSerPort, jtfCliIP, jtfCliPort;
	JButton jbSet;
	JTextArea jta;
	JScrollPane jsp;
	
	Server server = null;
	
	public Frame(String title, int w, int h) {
		ct = getContentPane();
		jpTop = new JPanel();
		jtfSerPort = new JTextField("9001");
		jtfCliIP = new JTextField("localhost");
		jtfCliPort = new JTextField("9000");
		jbSet = new JButton("¼³Á¤");
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		
		jpTop.setLayout(new GridLayout(2, 4));
		jpTop.add(new JLabel("Server Port", JLabel.CENTER));
		jpTop.add(new JLabel("Client IP", JLabel.CENTER));
		jpTop.add(new JLabel("Client Port", JLabel.CENTER));
		jpTop.add(new JLabel(""));
		jpTop.add(jtfSerPort);
		jpTop.add(jtfCliIP);
		jpTop.add(jtfCliPort);
		jpTop.add(jbSet);
		
		ct.setLayout(new BorderLayout());
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		
		addActionListener();
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void addActionListener() {
		jbSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				server = new Server(Integer.parseInt(jtfSerPort.getText()), Integer.parseInt(jtfCliPort.getText()), jtfCliIP.getText(), jta);
				server.start();
			}
		});
	}
}
