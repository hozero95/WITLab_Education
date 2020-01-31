import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CalendarFrame extends JFrame {
	Container ct;
	JPanel jpHeader, jpCalendar;
	JButton jbLeft, jbRight;
	JLabel jlMonth;
	JLabel[] jlWeek;
	JLabel[] jlDay;
	String[] week;
	
	Calendar cal = Calendar.getInstance();
	int year;
	int month;
	int startDay;
	int lastDay;
	int inputDate = 1;
	
	public void view(int year, int month) {
		inputDate = 1;
		cal.set(year, month - 1, 1);
		startDay = cal.get(Calendar.DAY_OF_WEEK);
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		jlMonth.setText(year + "년" + month + "월");
		
		for(int i = 1; inputDate <= lastDay; i++) {
			if(i < startDay) {
				jlDay[i - 1].setText("");
			}
			else {
				jlDay[i - 1].setText(Integer.toString(inputDate));
				inputDate++;
			}
		}
		for(int i = startDay + lastDay - 1; i < jlDay.length; i++) {
			jlDay[i].setText("");
		}
	}
	
	public CalendarFrame(String title, int w, int h) {
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		cal.set(year, month - 1, 1);
		startDay = cal.get(Calendar.DAY_OF_WEEK);
		lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
		
		ct = getContentPane();
		jpHeader = new JPanel();
		jpCalendar = new JPanel();
		
		jpHeader.setLayout(new BorderLayout(5, 5));
		jbLeft = new JButton("◀");
		jpHeader.add(jbLeft, BorderLayout.WEST);
		jbRight = new JButton("▶");
		jpHeader.add(jbRight, BorderLayout.EAST);
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH) + 1;
		jlMonth = new JLabel(year + "년 " + month + "월", JLabel.CENTER);
		jpHeader.add(jlMonth, BorderLayout.CENTER);
		
		jpCalendar.setLayout(new GridLayout(7, 7, 5, 5));
		jlWeek = new JLabel[7];
		week = new String[] {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
		for(int i = 0; i < jlWeek.length; i++) {
			jlWeek[i] = new JLabel(week[i], JLabel.CENTER);
			jpCalendar.add(jlWeek[i]);
		}
		jlDay = new JLabel[42];
		for(int i = 0; i < jlDay.length; i++) {
			jlDay[i] = new JLabel("", JLabel.CENTER);
			jpCalendar.add(jlDay[i]);
		}
		for(int i = 1; inputDate <= lastDay; i++) {
			if(i < startDay) {
				jlDay[i - 1].setText("");
			}
			else {
				jlDay[i - 1].setText(Integer.toString(inputDate));
				inputDate++;
			}
		}
		
		jbLeft.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(month == 1) {
					year -= 1;
					month = 12;
				}
				else {
					month -= 1;
				}
				view(year, month);
			}
		});
		
		jbRight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(month == 12) {
					year += 1;
					month = 1;
				}
				else {
					month += 1;
				}
				view(year, month);
			}
		});
		
		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jpHeader, BorderLayout.NORTH);
		ct.add(jpCalendar, BorderLayout.CENTER);
		
		setTitle(title + " - v0.2");
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
