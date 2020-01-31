import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Frame extends JFrame{
	Container ct;
	JPanel jpCenter;
	JButton jbStart;
	JButton[] jbImage;
	ImageIcon iBlank, iUser, iCom;
	JLabel label;
	
	boolean[] check;

	public Frame(String title, int w, int h) {
		ct = getContentPane();
		jpCenter = new JPanel();
		jbStart = new JButton("시작");
		jbImage = new JButton[9];
		for (int i = 0; i < jbImage.length; i++) {
			jbImage[i] = new JButton();
			jbImage[i].setEnabled(false);
		}
		iBlank = new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\2018_2nd_finals_class1_No2\\blank.png");
		iUser = new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\2018_2nd_finals_class1_No2\\user.png");
		iCom = new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\2018_2nd_finals_class1_No2\\com.png");
		label = new JLabel("'시작' 버튼을 눌러 시작하세요!");
		
		check = new boolean[jbImage.length];
		for(int i = 0; i < check.length; i++) {
			check[i] = true;
		}

		jpCenter.setLayout(new GridLayout(3, 3));
		for (int i = 0; i < jbImage.length; i++) {
			jpCenter.add(jbImage[i]);
		}

		ct.setLayout(new BorderLayout());
		ct.add(jbStart, BorderLayout.NORTH);
		ct.add(jpCenter, BorderLayout.CENTER);
		ct.add(label, BorderLayout.SOUTH);

		startActionListener();
		for(int i = 0; i < jbImage.length; i++) {
			imageActionListener(i);
		}
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void startActionListener() {
		jbStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < jbImage.length; i++) {
					jbImage[i].setEnabled(true);
					jbImage[i].setIcon(iBlank);
					check[i] = true;
				}
				label.setText("게임 시작-");
			}
		});
	}
	
	void imageActionListener(int i) {
		jbImage[i].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setUser(i);
				setCom();
			}
		});
	}
	
	void setUser(int i) {
		if(check[i]) {
			jbImage[i].setIcon(iUser);
			jbImage[i].setDisabledIcon(iUser);
			jbImage[i].setEnabled(false);
			check[i] = false;
			checkWin("사용자");	
		}
	}
	
	void setCom() {
		Random rand = new Random();
		int setBoard;
		for(int i = 0; i < jbImage.length; i++) {
			setBoard = rand.nextInt(9);
			if(check[setBoard]) {
				jbImage[setBoard].setIcon(iCom);
				jbImage[setBoard].setDisabledIcon(iCom);
				jbImage[setBoard].setEnabled(false);
				check[setBoard] = false;
				checkWin("컴퓨터");
				break;
			}
		}
	}

	void checkWin(String winner) {
		try {
			if (jbImage[0].getIcon() == jbImage[1].getIcon() && jbImage[1].getIcon() == jbImage[2].getIcon() && jbImage[0].getIcon() != iBlank
					|| jbImage[3].getIcon() == jbImage[4].getIcon() && jbImage[4].getIcon() == jbImage[5].getIcon() && jbImage[3].getIcon() != iBlank
					|| jbImage[6].getIcon() == jbImage[7].getIcon() && jbImage[7].getIcon() == jbImage[8].getIcon() && jbImage[6].getIcon() != iBlank
					|| jbImage[0].getIcon() == jbImage[3].getIcon() && jbImage[3].getIcon() == jbImage[6].getIcon() && jbImage[0].getIcon() != iBlank
					|| jbImage[1].getIcon() == jbImage[4].getIcon() && jbImage[4].getIcon() == jbImage[7].getIcon() && jbImage[1].getIcon() != iBlank
					|| jbImage[2].getIcon() == jbImage[5].getIcon() && jbImage[5].getIcon() == jbImage[8].getIcon() && jbImage[2].getIcon() != iBlank
					|| jbImage[0].getIcon() == jbImage[4].getIcon() && jbImage[4].getIcon() == jbImage[8].getIcon() && jbImage[0].getIcon() != iBlank
					|| jbImage[2].getIcon() == jbImage[4].getIcon() && jbImage[4].getIcon() == jbImage[6].getIcon() && jbImage[2].getIcon() != iBlank) {
				if(winner.equals("사용자")) {
					label.setText("승자는" + winner + "입니다!");
				}
				else if(winner.equals("컴퓨터")) {
					label.setText("승자는" + winner + "입니다!");
				}
				for(int i = 0; i < jbImage.length; i++) {
					check[i] = false;
				}
			}	
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
