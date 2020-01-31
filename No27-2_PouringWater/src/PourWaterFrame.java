import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PourWaterFrame extends JFrame {
	Container ct;
	JPanel jp1, jp2, jp3;
	JLabel label1, label2, status;
	JTextArea jtaDrain, jtaPour;
	JScrollPane jspDrain, jspPour;
	JButton jbAddHole, jbPour;
	JProgressBar prgbar;
	JTextField jtf;
	
	WaterCallback callback;
	WaterTankEx tank;
	
	int count;
	
	public PourWaterFrame(String title, int w, int h) {
		callback = new WaterCallback() {
			public void callbackDrain(String s) {
				jtaDrain.append(s + "\r\n");
				jtaDrain.setCaretPosition(jtaDrain.getDocument().getLength());
				status.setText(Integer.toString(tank.getWater()));
				prgbar.setValue(tank.getWater());
			}

			public void callbackPour(String s) {
				jtaPour.append(s + "\r\n");
				jtaPour.setCaretPosition(jtaPour.getDocument().getLength());
				status.setText(Integer.toString(tank.getWater()));
				prgbar.setValue(tank.getWater());
			}
		};
		count = 0;
		tank = new WaterTankEx(10000, callback);
		
		ct = getContentPane();
		jp1 = new JPanel();
		jp2 = new JPanel();
		jp3 = new JPanel();
		label1 = new JLabel("물 빠짐", JLabel.CENTER);
		jtaDrain = new JTextArea();
		jspDrain = new JScrollPane(jtaDrain, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jbAddHole = new JButton("구멍 추가 (현재 0개)");
		status = new JLabel("", JLabel.CENTER);
		status.setText(Integer.toString(tank.getWater()));
		prgbar = new JProgressBar(JProgressBar.VERTICAL);
		prgbar.setMaximum(tank.getWater());
		prgbar.setMinimum(0);
		prgbar.setValue(tank.getWater());
		jtf = new JTextField("500");
		jtf.setHorizontalAlignment(JTextField.CENTER);
		label2 = new JLabel("물 부음", JLabel.CENTER);
		jtaPour = new JTextArea();
		jspPour = new JScrollPane(jtaPour, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		jbPour = new JButton("물 붓기");
		
		jp1.setLayout(new BorderLayout(10, 10));
		jp1.add(label1, BorderLayout.NORTH);
		jp1.add(jspDrain, BorderLayout.CENTER);
		jp1.add(jbAddHole, BorderLayout.SOUTH);
		
		jbAddHole.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				count++;
				jbAddHole.setText("구멍 추가 (현재 " + count + "개)");
				new WaterHoleThreadEx(tank, 100, count).start();
			}
		});
		
		jp2.setLayout(new BorderLayout(10, 10));
		jp2.add(status, BorderLayout.NORTH);
		jp2.add(prgbar, BorderLayout.CENTER);
		jp2.add(jtf, BorderLayout.SOUTH);
		
		jp3.setLayout(new BorderLayout(10, 10));
		jp3.add(label2, BorderLayout.NORTH);
		jp3.add(jspPour, BorderLayout.CENTER);
		jp3.add(jbPour, BorderLayout.SOUTH);
		
		jbPour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tank.pour(Integer.parseInt(jtf.getText()));
			}
		});
		
		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jp1, BorderLayout.WEST);
		ct.add(jp2, BorderLayout.CENTER);
		ct.add(jp3, BorderLayout.EAST);
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
