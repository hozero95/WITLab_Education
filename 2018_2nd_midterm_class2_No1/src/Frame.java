import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashSet;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Frame extends JFrame {
	Container ct;
	JPanel jpCenter, jpBottom;
	JTextArea jta;
	JList<String> jList;
	DefaultListModel<String> model;
	JScrollPane jsp;
	JTextField jtf;
	JButton jbRead, jbCount, jbWrite;

	StringBuffer sbContent;
	String text;

	public Frame(String title, int w, int h) {
		ct = getContentPane();
		jpCenter = new JPanel();
		jpBottom = new JPanel();
		jta = new JTextArea();
		jList = new JList<String>(new DefaultListModel<String>());
		model = (DefaultListModel<String>) jList.getModel();
		jsp = new JScrollPane(jList);
		jtf = new JTextField();
		jbRead = new JButton("파일 불러오기");
		jbCount = new JButton("단어별 개수 세기");
		jbWrite = new JButton("결과 파일로 내보내기");

		jpCenter.setLayout(new GridLayout(1, 2, 5, 5));
		jpCenter.add(jta);
		jpCenter.add(jsp);

		jpBottom.setLayout(new GridLayout(2, 2));
		jpBottom.add(jtf);
		jpBottom.add(jbRead);
		jpBottom.add(jbCount);
		jpBottom.add(jbWrite);

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
		jbRead.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fileRead();
			}
		});
		jbCount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				wordCount();
			}
		});
		jbWrite.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String result = "";
				for (int i = 0; i < model.getSize(); i++) {
					result += (model.getElementAt(i) + "\r\n");
				}
				fileWrite(result);
			}
		});
	}

	void wordCount() {
		String[] wordArr = text.split(" |\r\n");
		wordArr = new LinkedHashSet<String>(Arrays.asList(wordArr)).toArray(new String[0]);
		int[] wordCount = new int[wordArr.length];
		
		for(int i = 0; i < wordArr.length; i++) {
			wordCount[i] = count(wordArr[i]);
			model.addElement(wordArr[i] + " " + wordCount[i]);
		}
	}

	int count(String word) {
		int i = 0;
		int count = 0;

		while (true) {
			if (word.equals(sbContent.substring(i, i + word.length()))) {
				count++;
			}
			if (sbContent.length() <= i + word.length()) {
				break;
			}
			i++;
		}
		return count;
	}

	void fileRead() {
		sbContent = new StringBuffer();
		try {
			FileReader fr = new FileReader(jtf.getText()); // C:\Users\WITLAB\Desktop\witlab_edu\2018_2nd_midterm_class2_No1\paper.txt
			int i;
			while ((i = fr.read()) != -1) {
				sbContent.append((char) i);
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		text = sbContent.toString();
		jta.append(text);
	}

	void fileWrite(String result) {
		FileWriter fw;
		try {
			fw = new FileWriter("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\2018_2nd_midterm_class2_No1\\wordcount.txt");
			fw.write(result);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
