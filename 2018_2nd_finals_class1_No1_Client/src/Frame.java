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
	JTextField jtfCliPort, jtfSerIP, jtfSerPort;
	JButton jbSet, jbBuy;
	JTextArea jta;
	JScrollPane jsp;
	
	Fandom fandom = null;

	public Frame(String title, int w, int h) {
		ct = getContentPane();
		jpTop = new JPanel();
		jtfCliPort = new JTextField("9000");
		jtfSerIP = new JTextField("localhost");
		jtfSerPort = new JTextField("9001");
		jbSet = new JButton("설정");
		jta = new JTextArea();
		jsp = new JScrollPane(jta);
		jbBuy = new JButton("구매 시작");

		jpTop.setLayout(new GridLayout(2, 4));
		jpTop.add(new JLabel("Client Port", JLabel.CENTER));
		jpTop.add(new JLabel("Server IP", JLabel.CENTER));
		jpTop.add(new JLabel("Server Port", JLabel.CENTER));
		jpTop.add(new JLabel(""));
		jpTop.add(jtfCliPort);
		jpTop.add(jtfSerIP);
		jpTop.add(jtfSerPort);
		jpTop.add(jbSet);

		ct.setLayout(new BorderLayout());
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jsp, BorderLayout.CENTER);
		ct.add(jbBuy, BorderLayout.SOUTH);

		addActionListener();

		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void addActionListener() {
		jbSet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fandom = new Fandom(Integer.parseInt(jtfCliPort.getText()), Integer.parseInt(jtfSerPort.getText()), jtfSerIP.getText(), jta);
			}
		});
		jbBuy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fandom.start();
			}
		});
	}
}
