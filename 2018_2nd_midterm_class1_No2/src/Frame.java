import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Frame extends JFrame {
	Container ct;
	JPanel jpTop, jpBottom, jpTopCen, jpTopBot;
	JList<String> jListWest, jListCen, jListEast;
	DefaultListModel<String> modelWest, modelCen, modelEast;
	JScrollPane jspWest, jspCen, jspEast;
	JButton jbRight1, jbLeft1, jbRight2, jbLeft2, jbCompare;
	JTextArea jta;

	String[] ball = { "1", "2", "3", "4", "5", "6", "7", "8" };
	String heavyBall = "";

	public Frame(String title, int w, int h) {
		ct = getContentPane();
		jpTop = new JPanel();
		jpBottom = new JPanel();
		jpTopCen = new JPanel();
		jpTopBot = new JPanel();
		jListWest = new JList<String>(new DefaultListModel<String>());
		modelWest = (DefaultListModel<String>) jListWest.getModel();
		jspWest = new JScrollPane(jListWest);
		jListCen = new JList<String>(new DefaultListModel<String>());
		modelCen = (DefaultListModel<String>) jListCen.getModel();
		jspCen = new JScrollPane(jListCen);
		jListEast = new JList<String>(new DefaultListModel<String>());
		modelEast = (DefaultListModel<String>) jListEast.getModel();
		jspEast = new JScrollPane(jListEast);
		jbRight1 = new JButton("▶");
		jbLeft1 = new JButton("◀");
		jbRight2 = new JButton("▶");
		jbLeft2 = new JButton("◀");
		jbCompare = new JButton("양쪽 무게 비교하기");
		jta = new JTextArea();

		jpTop.setLayout(new BorderLayout(5, 5));
		jpTop.add(jpTopCen, BorderLayout.CENTER);
		jpTop.add(jpTopBot, BorderLayout.SOUTH);

		jpTopCen.setLayout(new GridLayout(1, 3));
		jpTopCen.add(jspWest);
		jpTopCen.add(jspCen);
		jpTopCen.add(jspEast);

		jpTopBot.setLayout(new GridLayout(1, 6));
		jpTopBot.add(new JLabel(""));
		jpTopBot.add(jbRight1);
		jpTopBot.add(jbLeft1);
		jpTopBot.add(jbRight2);
		jpTopBot.add(jbLeft2);
		jpTopBot.add(new JLabel(""));

		jpBottom.setLayout(new BorderLayout(5, 5));
		jpBottom.add(jbCompare, BorderLayout.NORTH);
		jpBottom.add(jta, BorderLayout.CENTER);

		ct.setLayout(new GridLayout(2, 1, 5, 5));
		ct.add(jpTop);
		ct.add(jpBottom);
		
		addActionListener();

		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	void addActionListener() {
		jbRight1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(jListWest.getSelectedValue() != null) {
						String str = jListWest.getSelectedValue();
						modelCen.addElement(str);
						int index = jListWest.getSelectedIndex();
						modelWest.remove(index);		
					}
				}catch(Exception e1) {
				}
			}
		});
		jbLeft1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(jListCen.getSelectedValue() != null) {
						String str = jListCen.getSelectedValue();
						modelWest.addElement(str);
						int index = jListCen.getSelectedIndex();
						modelCen.remove(index);		
					}
				}catch(Exception e1) {
				}
			}
		});
		jbRight2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(jListCen.getSelectedValue() != null) {
						String str = jListCen.getSelectedValue();
						modelEast.addElement(str);
						int index = jListCen.getSelectedIndex();
						modelCen.remove(index);		
					}
				}catch(Exception e1) {
				}
			}
		});
		jbLeft2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if(jListEast.getSelectedValue() != null) {
						String str = jListEast.getSelectedValue();
						modelCen.addElement(str);
						int index = jListEast.getSelectedIndex();
						modelEast.remove(index);		
					}
				}catch(Exception e1) {
				}
			}
		});
		jbCompare.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					for(int i = 0; i < modelWest.size(); i++) {
						jta.append(modelWest.getElementAt(i));
						if(i != modelWest.size() - 1) {
							jta.append(", ");
						}
					}
					jta.append(" / ");
					for(int i = 0; i < modelEast.size(); i++) {
						jta.append(modelEast.getElementAt(i));
						if(i != modelEast.size() - 1) {
							jta.append(", ");
						}
					}
					jta.append(" → ");
					compare();
				}catch(Exception e1) {
				}
			}
		});
	}

	void startGame() {
		int randomBall;
		Random rand = new Random();
		randomBall = rand.nextInt(8) + 1;
		heavyBall = Integer.toString(randomBall);
		System.out.println(heavyBall);
		for (int i = 0; i < ball.length; i++) {
			modelCen.addElement(ball[i]);
		}
	}
	
	void compare() {
		int westWeight = 0;
		int eastWeight = 0;
		
		for(int i = 0; i < modelWest.size(); i++) {
			if(modelWest.getElementAt(i).equals(heavyBall)) {
				westWeight += 2;
			}
			else {
				westWeight++;
			}
			System.out.println(westWeight);
		}
		for(int i = 0; i < modelEast.size(); i++) {
			if(modelEast.getElementAt(i).equals(heavyBall)) {
				eastWeight += 2;
			}
			else {
				eastWeight++;
			}
			System.out.println(eastWeight);
		}
		
		if(westWeight < eastWeight) {
			jta.append("오른쪽이 무겁습니다.\r\n");
		}
		else if(westWeight > eastWeight){
			jta.append("왼쪽이 무겁습니다.\r\n");
		}
		else {
			jta.append("양쪽의 무게가 같습니다.\r\n");
		}
		
		if((modelWest.size() == 1 && modelEast.size() == 1) && ((westWeight > eastWeight) || (westWeight < eastWeight))) {
			jta.append("정답은 " + heavyBall + "번입니다!\r\n");
		}
	}
}
