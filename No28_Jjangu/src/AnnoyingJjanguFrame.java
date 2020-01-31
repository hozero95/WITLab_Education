import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AnnoyingJjanguFrame extends JFrame {
	Container ct;
	JPanel jp;
	JButton jb;
	JjanguLabel jj;
	
	int count;
	
	public AnnoyingJjanguFrame(String title, int w, int h) {
		count = 0;
		
		ct = getContentPane();
		jp = new JPanel();
		jb = new JButton("짱구 만들기(현재 " + count + "개)");
		
		jp.setLayout(null);
		jp.setBackground(new Color(255, 255, 255));
		
		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jp, BorderLayout.CENTER);
		ct.add(jb, BorderLayout.SOUTH);
		
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jj = new JjanguLabel(jp.getWidth(), jp.getHeight());
				jp.add(jj);
				new Thread((Runnable)jj).start();
				count++;
				jb.setText("짱구 만들기(현재 " + count + "개)");
			}
		});
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
