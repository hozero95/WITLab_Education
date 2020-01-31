import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class DragonBallFrame extends JFrame {
	Container ct;
	JPanel jpGameBoard, jpComputer, jpUser, jpSelect, jpSituation;
	JTextArea jta;
	JLabel jlComputer, jlUser, jlComLife, jlUserLife;
	ButtonGroup bg;
	JRadioButton[] jrb;
	JButton jb;

	String[] action = { "기", "막기", "파" };
	Font fontSituation = new Font("궁서체", Font.BOLD, 50);
	Font fontLife = new Font("궁서체", Font.BOLD, 20);

	Random rand = new Random();
	int userActionNum = 0;
	int comLife = 3;
	int userLife = 3;
	int comKi = 0;
	int userKi = 0;

	public void result(String action) {
		int comActionNum = rand.nextInt(3);
		while (true) {
			if (comActionNum == 2) {
				if (comKi == 0) {
					comActionNum = rand.nextInt(3);
				} else {
					break;
				}
			} else {
				break;
			}
		}
		if (action.equals("기")) {
			userActionNum = 0;
			userKi++;
		} else if (action.equals("막기")) {
			userActionNum = 1;
		} else if (action.equals("파")) {
			userActionNum = 2;
			userKi--;
		}

		if (!(userKi == 0 && userActionNum == 2)) {
			if (comActionNum == 0) {
				comKi++;
				jlComputer.setText("기");
			} else if (comActionNum == 1) {
				jlComputer.setText("막기");
			} else if (comActionNum == 2) {
				jlComputer.setText("파");
				comKi--;
			}
			jlUser.setText(action);

			if (comActionNum == userActionNum) {
				if (comActionNum == 2 && userActionNum == 2) {
					comLife--;
					userLife--;
				}
			} else {
				if (comActionNum == 0 && userActionNum == 2) {
					comLife--;
				} else if (comActionNum == 2 && userActionNum == 0) {
					userLife--;
				}
			}
			if (comLife == 0) {
				jlComLife.setText("♡♡♡");
				jb.setEnabled(false);
			} else if (comLife == 1) {
				jlComLife.setText("♥♡♡");
			} else if (comLife == 2) {
				jlComLife.setText("♥♥♡");
			}
			if (userLife == 0) {
				jlUserLife.setText("♡♡♡");
				jb.setEnabled(false);
			} else if (userLife == 1) {
				jlUserLife.setText("♥♡♡");
			} else if (userLife == 2) {
				jlUserLife.setText("♥♥♡");
			}

			jta.append("Computer> action:" + jlComputer.getText() + ", life:" + comLife + "\tUser> action:"
					+ jlUser.getText() + ", life:" + userLife + "\r\n");
			jrb[2].setEnabled(true);
		}
	}

	public DragonBallFrame(String title, int w, int h) {
		ct = getContentPane();
		jpGameBoard = new JPanel();
		jta = new JTextArea();
		jlComputer = new JLabel("--", JLabel.CENTER);
		jlComLife = new JLabel("♥♥♥", JLabel.CENTER);
		jlUser = new JLabel("--", JLabel.CENTER);
		jlUserLife = new JLabel("♥♥♥", JLabel.CENTER);
		jrb = new JRadioButton[3];
		bg = new ButtonGroup();
		for (int i = 0; i < jrb.length; i++) {
			jrb[i] = new JRadioButton(action[i]);
			bg.add(jrb[i]);
		}
		jb = new JButton("Go!");

		jpComputer = new JPanel();
		jpComputer.setLayout(new BorderLayout(10, 10));
		jpComputer.add(new JLabel("Computer", JLabel.CENTER), BorderLayout.NORTH);
		jlComputer.setFont(fontSituation);
		jpComputer.add(jlComputer, BorderLayout.CENTER);
		jlComLife.setFont(fontLife);
		jpComputer.add(jlComLife, BorderLayout.SOUTH);

		jpUser = new JPanel();
		jpUser.setLayout(new BorderLayout(10, 10));
		jpUser.add(new JLabel("User", JLabel.CENTER), BorderLayout.NORTH);
		jlUser.setFont(fontSituation);
		jpUser.add(jlUser, BorderLayout.CENTER);
		jlUserLife.setFont(fontLife);
		jpUser.add(jlUserLife, BorderLayout.SOUTH);

		jpSituation = new JPanel();
		jpSituation.setLayout(new GridLayout(1, 2, 10, 10));
		jpSituation.add(jpComputer);
		jpSituation.add(jpUser);

		jpSelect = new JPanel();
		jpSelect.setLayout(new GridLayout(1, 4, 10, 10));
		jpSelect.add(jrb[0]);
		jpSelect.add(jrb[1]);
		jrb[2].setEnabled(false);
		jpSelect.add(jrb[2]);
		jpSelect.add(jb);

		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jrb[0].isSelected()) {
					result(jrb[0].getActionCommand());
				} else if (jrb[1].isSelected()) {
					result(jrb[1].getActionCommand());
				} else if (jrb[2].isSelected()) {
					result(jrb[2].getActionCommand());
				}
			}
		});

		jpGameBoard.setLayout(new BorderLayout(10, 10));
		jpGameBoard.add(jpSituation, BorderLayout.CENTER);
		jpGameBoard.add(jpSelect, BorderLayout.SOUTH);

		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jpGameBoard, BorderLayout.NORTH);
		ct.add(jta, BorderLayout.CENTER);

		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
