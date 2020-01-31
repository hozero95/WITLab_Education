import java.awt.BorderLayout;
import java.awt.Container;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class DigitalClockFrame extends JFrame {
	Container ct;
	JLabel label;
	ClockThread clockThread;
	private class ClockThread extends Thread {
		public void run() {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
			Date date;
			while(true) {
				date = new Date();
				label.setText(sdf.format(date));
			}
		}
	}
	
	public DigitalClockFrame(String title, int w, int h) {
		clockThread = new ClockThread();
		
		ct = getContentPane();
		label = new JLabel("", JLabel.CENTER);
		
		clockThread.start();
		
		ct.setLayout(new BorderLayout(10, 10));
		ct.add(label, BorderLayout.CENTER);
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
