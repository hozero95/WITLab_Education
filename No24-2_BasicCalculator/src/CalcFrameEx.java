import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcFrameEx extends CalcFrame {

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
							jta.append(cal + " = 잘못된 식입니다.\r\n");
							jtf.setText("");
							return;
						} else if (calArr.length > 3) {
							jta.append("한 번에 하나의 연산만 가능합니다.");
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
						jta.append(cal + " = " + result + "\r\n");
						jtf.setText("");
					}
				}
			});
		}
	}

	public CalcFrameEx(String title, int w, int h) {
		super(title, w, h);
		addActionListener();
		
		setTitle(title + " - v0.2");
	}
}
