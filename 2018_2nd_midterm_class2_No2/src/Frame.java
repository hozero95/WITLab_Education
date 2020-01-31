import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame {
	Container ct;
	JPanel jpCenter, jpBottom;
	JTextArea jta;
	JLabel label;
	JTextField jtfNum1, jtfNum2, jtfNum3;
	JButton jbThrow;
	
	Random rand = new Random();
	int[] answer = new int[3];
	int[] strikeBall = new int[2];
	int[] result = new int[2];
	int cntThrow = 8;
	
	public Frame(String title, int w, int h) {
		ct = getContentPane();
		jpCenter = new JPanel();
		jpBottom = new JPanel();
		jta = new JTextArea();
		label = new JLabel("남은 시도 횟수 : 8회");
		jtfNum1 = new JTextField();
		jtfNum2 = new JTextField();
		jtfNum3 = new JTextField();
		jbThrow = new JButton("Throw");
		
		jpCenter.setLayout(new BorderLayout());
		jpCenter.add(jta, BorderLayout.CENTER);
		jpCenter.add(label, BorderLayout.SOUTH);
		
		jpBottom.setLayout(new GridLayout(1, 4));
		jpBottom.add(jtfNum1);
		jpBottom.add(jtfNum2);
		jpBottom.add(jtfNum3);
		jpBottom.add(jbThrow);
		
		ct.setLayout(new BorderLayout());
		ct.add(jpCenter, BorderLayout.CENTER);
		ct.add(jpBottom, BorderLayout.SOUTH);
		
		addActionListener();
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void addActionListener() {
		jbThrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jta.append(jtfNum1.getText() + " " + jtfNum2.getText() + " " + jtfNum3.getText() + "\t→ ");
				
				result();
				
				jtfNum1.setText("");
				jtfNum2.setText("");
				jtfNum3.setText("");
			}
		});
	}
	
	void startGame() {
		while(true) {
			for(int i = 0; i < answer.length; i++) {
				answer[i] = rand.nextInt(10);
				while(answer[i] == 0) {
					answer[i] = rand.nextInt(10);
				}
			}
			if(answer[0] != answer[1] && answer[0] != answer[2] && answer[1] != answer[2]) {
				break;
			}
		}
	}
	
	void result() {
		int[] input = {Integer.parseInt(jtfNum1.getText()), Integer.parseInt(jtfNum2.getText()), Integer.parseInt(jtfNum3.getText())};
		result = judge(input);

		if(result[0] == 3) {
			jta.append("3 Strike\r\n");
			label.setText("정답입니다!");
			jbThrow.setEnabled(false);
			return;
		}
		else if(result[0] == 0 && result[1] == 0) {
			jta.append("out\r\n");
		}
		else {
			jta.append(strikeBall[0] + " Strike " + strikeBall[1] + " Ball\r\n");
		}
		
		if(cntThrow == 0) {
			label.setText("실패하셨습니다.");
			jbThrow.setEnabled(false);
		}
		else {
			label.setText("남은 시도 횟수 : " + cntThrow + "회");
		}
	}
	
	int[] judge(int[] input) {
		for(int i = 0; i < 2; i++) {
			strikeBall[i] = 0;
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(answer[i] == input[j]) {
					if(i == j) {
						strikeBall[0]++;
					}
					else {
						strikeBall[1]++;
					}
				}
			}
		}
		cntThrow--;
		return strikeBall;
	}
}
