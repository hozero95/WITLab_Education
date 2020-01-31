import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class CalculatorFrame extends JFrame {
	Container ct;
	JPanel jplO, jpBtns;
	JTextField jtf;
	JButton[] jb;
	JList<String> jList;
	DefaultListModel<String> model;
	
	String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "=", "←", "÷", "×", "-", "+"};
	int[] buttonIndex = {15, 12, 13, 14, 8, 9, 10, 4, 5, 6, 0, 1, 2, 3, 7, 11};
	
	public void addActionListener() {
		for (int i = 0; i < jb.length; i++) {
			final int num = i;
			jb[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ((4 <= num && num <= 6) || (8 <= num && num <= 10) || (12 <= num && num <= 15)) {
						String value = e.getActionCommand();
						jtf.setText(jtf.getText() + value);
					} else if ((2 <= num && num <= 3) || num == 7 || num == 11) {
						String equation = e.getActionCommand();
						jtf.setText(jtf.getText() + " " + equation + " ");
					} else if (num == 1) {
						String expression = jtf.getText();
						if (expression.length() == 0) {
							return;
						} else {
							jtf.setText(expression.substring(0, expression.length() - 1));
						}
					} else if (num == 0) {
						String cal = jtf.getText();
						String[] calArr = cal.split(" ");
						if (calArr.length < 3) {
							model.addElement(cal + " = 잘못된 식입니다.");
							fileWrite(cal + "잘못된 식입니다.\r\n");
							jtf.setText("");
							return;
						} else if (calArr.length > 3) {
							model.addElement("한 번에 하나의 연산만 가능합니다.");
							fileWrite("한 번에 하나의 연산만 가능합니다.\r\n");
							jtf.setText("");
							return;
						}

						double value1 = Double.parseDouble(calArr[0]);
						double value2 = Double.parseDouble(calArr[2]);
						double result = 0.0;
						if (calArr[1].equals("-")) {
							result = value1 - value2;
						} else if (calArr[1].equals("+")) {
							result = value1 + value2;
						} else if (calArr[1].equals("÷")) {
							result = value1 / value2;
						} else if (calArr[1].equals("×")) {
							result = value1 * value2;
						}
						model.addElement(cal + " = " + result);
						fileWrite(cal + " = " + result + "\r\n");
						jtf.setText("");
					}
				}
			});
		}
	}
	
	public void fileWrite(String result) {
		FileWriter fw;
		try {
			fw = new FileWriter("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\No24-3_BasicCalculator\\calc_history.txt", true);
			fw.write(result);
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public CalculatorFrame(String title, int w, int h) {
		ct = getContentPane();
		jplO = new JPanel();
		jList = new JList<String>(new DefaultListModel<String>());
		model = (DefaultListModel<String>) jList.getModel();
		jtf = new JTextField();
		jpBtns = new JPanel();
		jb = new JButton[buttonValue.length];
		for(int i = 0; i < jb.length; i++) {
			jb[i] = new JButton();
		}
		
		jplO.setLayout(new BorderLayout(10, 10));
		jplO.add(new JScrollPane(jList), BorderLayout.CENTER);
		jplO.add(jtf, BorderLayout.SOUTH);
		
		jpBtns.setLayout(new GridLayout(4, 4, 5, 5));
		for(int i = 0; i < jb.length; i++) {
			jpBtns.add(jb[i]);
			jb[buttonIndex[i]].setText(buttonValue[i]);
		}
		addActionListener();
		
		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jplO, BorderLayout.CENTER);
		ct.add(jpBtns, BorderLayout.SOUTH);
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
