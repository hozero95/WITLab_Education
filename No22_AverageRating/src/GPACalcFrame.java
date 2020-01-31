import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GPACalcFrame extends JFrame {
	Container ct;
	JTextArea jta;
	JPanel jp;
	JTextField jtfSubject, jtfCredit, jtfGrade;
	JButton jbAdd;
	JLabel jlAverage;
	
	double sumCredit = 0.0;
	double sumGrade = 0.0;
	
	public GPACalcFrame(String title, int w, int h) {
		ct = getContentPane();
		jta = new JTextArea();
		jp = new JPanel();
		jtfSubject = new JTextField();
		jtfCredit = new JTextField();
		jtfGrade = new JTextField();
		jbAdd = new JButton("추가");
		jlAverage = new JLabel("", JLabel.CENTER);
		
		jp.setLayout(new GridLayout(3, 4, 5, 5));
		jp.add(new JLabel("과목명"));
		jp.add(new JLabel("학점"));
		jp.add(new JLabel("평점"));
		jp.add(new JLabel(""));
		jp.add(jtfSubject);
		jp.add(jtfCredit);
		jp.add(jtfGrade);
		jp.add(jbAdd);
		jp.add(new JLabel(""));
		jp.add(new JLabel(""));
		jp.add(new JLabel("평점평균"));
		jp.add(jlAverage);
		
		jbAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sumCredit += Double.parseDouble(jtfCredit.getText());
				sumGrade += Double.parseDouble(jtfGrade.getText()) * Double.parseDouble(jtfCredit.getText());
				jta.append(jtfSubject.getText() + " " + jtfCredit.getText() + " " + jtfGrade.getText() + "\r\n");
				jtfSubject.setText("");
				jtfCredit.setText("");
				jtfGrade.setText("");
				jlAverage.setText(String.format("%.2f", sumGrade / sumCredit));
			}
		});
		
		ct.setLayout(new BorderLayout(5, 5));
		ct.add(jta, BorderLayout.CENTER);
		ct.add(jp, BorderLayout.SOUTH);
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
