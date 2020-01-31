import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	Container ct;
	JPanel jp;
	JButton jb;
	
	Pig pig;
	Arrow arrow;
	
	public Frame(String title, int w, int h) {
		ct = getContentPane();
		jp = new JPanel();
		jb = new JButton("´øÁö±â");
		
		jp.setLayout(null);
		
		ct.setLayout(new BorderLayout());
		ct.add(jp, BorderLayout.CENTER);
		ct.add(jb, BorderLayout.SOUTH);
		
		addActionListener();
		pig = new Pig(w);
		jp.add(pig);
		new Thread((Runnable)pig).start();
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void addActionListener() {
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arrow = new Arrow(jp.getWidth(), jp.getHeight(), pig);
				jp.add(arrow);
				new Thread((Runnable)arrow).start();
			}
		});
	}
}
