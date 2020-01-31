import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DragonballAnimationFrame extends JFrame {
	Container ct;
	JPanel jp, jpButton;
	JLabel jlNormal, jlDefense, jlEnergy, jlGi, jlPar;
	JButton jbDefense, jbGi, jbPar;

	boolean check, parCheck;

	public DragonballAnimationFrame(String title, int w, int h) {
		ct = getContentPane();
		jp = new JPanel();
		jp.setLayout(null);
		jpButton = new JPanel();
		jlNormal = new JLabel(new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\No29_Dragonball\\normal.png"));
		jlDefense = new JLabel(new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\No29_Dragonball\\defense.png"));
		jlEnergy = new JLabel(new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\No29_Dragonball\\energy.png"));
		jlGi = new JLabel(new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\No29_Dragonball\\gi.png"));
		jlPar = new JLabel(new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\No29_Dragonball\\par.png"));
		jlNormal.setSize(100, 200);
		jlDefense.setSize(100, 200);
		jlEnergy.setSize(80, 160);
		jlGi.setSize(100, 200);
		jlPar.setSize(100, 200);
		jbGi = new JButton("기 모으기");
		jbDefense = new JButton("막기");
		jbPar = new JButton("파 쏘기");

		jp.add(jlNormal);

		jpButton.setLayout(new GridLayout(1, 3, 5, 5));
		jpButton.add(jbGi);
		jpButton.add(jbDefense);
		jpButton.add(jbPar);

		check = true;
		parCheck = false;
		jbGi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new ImageChange(0)).start();
			}
		});
		jbDefense.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new ImageChange(1)).start();
			}
		});
		jbPar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new ImageChange(2)).start();
				new Thread(new EnergyPar()).start();
			}
		});

		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jp, BorderLayout.CENTER);
		ct.add(jpButton, BorderLayout.SOUTH);

		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	class ImageChange implements Runnable {
		int select;

		public ImageChange(int select) {
			this.select = select;
		}

		public void run() {
			if (check == false) {
				return;
			}
			check = false;
			JLabel jlChange = null;
			switch (select) {
			case 0:
				jlChange = jlGi;
				break;
			case 1:
				jlChange = jlDefense;
				break;
			case 2:
				jlChange = jlPar;
				parCheck = true;
				break;
			}
			jp.remove(jlNormal);
			jp.add(jlChange);
			jp.updateUI();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			jp.remove(jlChange);
			jp.add(jlNormal);
			jp.updateUI();
			check = true;
		}
	}

	class EnergyPar implements Runnable {

		public void run() {
			if (parCheck == false) {
				return;
			}
			parCheck = false;
			int xMax = jp.getWidth();
			int x = 100;
			int y = 30;

			jp.add(jlEnergy);
			jlEnergy.setLocation(x, y);
			jp.updateUI();

			while (x < xMax) {
				x += 5;
				jlEnergy.setLocation(x, y);
				jp.updateUI();
				try {
					Thread.sleep(10);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			jp.remove(jlEnergy);
			jp.updateUI();
		}
	}
}
