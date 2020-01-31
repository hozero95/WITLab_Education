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
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class Frame extends JFrame {
	Container ct;
	JPanel jpTop, jpCenter, jpCenTop;
	JTextField jtfID, jtfKor, jtfMat, jtfEng;
	JButton jbAdd, jbAverage, jbSave;
	JList<String> jList;
	DefaultListModel<String> model;
	JScrollPane jsp;
	JLabel viewAverage;
	
	double stuCount = 0.0;
	double kor = 0.0;
	double mat = 0.0;
	double eng = 0.0;
	double average = 0.0;
	double totKor = 0.0;
	double totMat = 0.0;
	double totEng = 0.0;
	double totAverage = 0.0;
	
	public Frame(String title, int w, int h) {
		ct = getContentPane();
		jpTop = new JPanel();
		jpCenter = new JPanel();
		viewAverage = new JLabel("<���� ���> ���� : , ���� : , ���� : , �� ��� : ");
		jtfID = new JTextField();
		jtfKor = new JTextField();
		jtfMat = new JTextField();
		jtfEng = new JTextField();
		jbAdd = new JButton("�߰�");
		jpCenTop = new JPanel();
		jList = new JList<String>(new DefaultListModel<String>());
		model = (DefaultListModel<String>) jList.getModel();
		jsp = new JScrollPane(jList);
		jbAverage = new JButton("��� ���");
		jbSave = new JButton("���Ϸ� ����");
		
		jpTop.setLayout(new GridLayout(2, 5));
		jpTop.add(new JLabel("�й�", JLabel.CENTER));
		jpTop.add(new JLabel("����", JLabel.CENTER));
		jpTop.add(new JLabel("����", JLabel.CENTER));
		jpTop.add(new JLabel("����", JLabel.CENTER));
		jpTop.add(new JLabel(""));
		jpTop.add(jtfID);
		jpTop.add(jtfKor);
		jpTop.add(jtfMat);
		jpTop.add(jtfEng);
		jpTop.add(jbAdd);
		
		jpCenter.setLayout(new BorderLayout(5, 5));
		jpCenter.add(jpCenTop, BorderLayout.NORTH);
		jpCenter.add(jsp, BorderLayout.CENTER);
		
		jpCenTop.setLayout(new GridLayout(1, 2));
		jpCenTop.add(jbAverage);
		jpCenTop.add(jbSave);
		
		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jpTop, BorderLayout.NORTH);
		ct.add(jpCenter, BorderLayout.CENTER);
		ct.add(viewAverage, BorderLayout.SOUTH);
		
		addActionListener();
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	void addActionListener() {
		jbAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				stuCount++;
				kor = Double.parseDouble(jtfKor.getText());
				mat = Double.parseDouble(jtfMat.getText());
				eng = Double.parseDouble(jtfEng.getText());
				average = (kor + mat + eng) / 3;
				totKor += kor;
				totMat += mat;
				totEng += eng;
				totAverage += average;
				model.addElement("�й� : " + jtfID.getText() + ", ���� : " + jtfKor.getText() + ", ���� : " + jtfMat.getText() + ", ���� : " + jtfEng.getText() + ", ��� : "
						+ String.format("%.2f", average));
				jtfID.setText("");
				jtfKor.setText("");
				jtfMat.setText("");
				jtfEng.setText("");
			}
		});
		jbAverage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewAverage.setText("<���� ���> ���� : " + String.format("%.2f", (totKor / stuCount)) + ", ���� : " + String.format("%.2f", (totMat / stuCount))
					+ ", ���� : " + String.format("%.2f", (totEng / stuCount)) + ", �� ��� : " + String.format("%.2f", (totAverage / stuCount)));
			}
		});
		jbSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";
				for(int i = 0; i < model.getSize(); i++) {
					result += (model.getElementAt(i) + "\r\n");
				}
				result += viewAverage.getText();
				fileWrite(result);
			}
		});
	}
	
	public void fileWrite(String result) {
		FileWriter fw;
		try {
			fw = new FileWriter("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\2018_2nd_midterm_class1_No1\\result.txt");
			fw.write(result);
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
