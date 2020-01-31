import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CalcFrame extends JFrame {
	Container ct;
	JPanel jplO, jpBtns;
	JTextArea jta;
	JTextField jtf;
	JButton[] jb;
	
	String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "=", "¡ç", "¡À", "¡¿", "-", "£«"};
	int[] buttonIndex = {15, 12, 13, 14, 8, 9, 10, 4, 5, 6, 0, 1, 2, 3, 7, 11};
	
	public CalcFrame(String title, int w, int h) {
		ct = getContentPane();
		jplO = new JPanel();
		jta = new JTextArea();
		jtf = new JTextField();
		jpBtns = new JPanel();
		jb = new JButton[buttonValue.length];
		for(int i = 0; i < jb.length; i++) {
			jb[i] = new JButton();
		}
		
		jplO.setLayout(new BorderLayout(10, 10));
		jplO.add(jta, BorderLayout.CENTER);
		jplO.add(jtf, BorderLayout.SOUTH);
		
		jpBtns.setLayout(new GridLayout(4, 4, 5, 5));
		for(int i = 0; i < jb.length; i++) {
			jpBtns.add(jb[i]);
			jb[buttonIndex[i]].setText(buttonValue[i]);
		}
		
		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jplO, BorderLayout.CENTER);
		ct.add(jpBtns, BorderLayout.SOUTH);
		
		setTitle(title + " - v0.1");
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
