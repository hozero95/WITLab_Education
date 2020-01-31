import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class DonationAngelFrame extends JFrame {
	Container ct;
	JLabel jlHead;
	JPanel jp, jp2;
	JButton jb;
	JList<String> jListDonator, jListRecipient;
	DefaultListModel<String> modelDonator, modelRecipient;
	JScrollPane jspDonator, jspRecipient;
	
	DonationCallback callback;
	DonationCenter donationCenter;
	Donator donator;
	Recipient recipient;
	
	public DonationAngelFrame(String title, int w, int h) {
		callback = new DonationCallback() {
			public void execute(String s) {
				jlHead.setText(s);
			}
			public void listDonatorString(String s) {
				modelDonator.addElement(s);
			}
			public void listRecipientString(String s) {
				modelRecipient.addElement(s);
			}
		};
		donationCenter = new DonationCenter(callback);
		donator = new Donator(donationCenter);
		recipient = new Recipient(donationCenter);
		
		ct = getContentPane();
		jlHead = new JLabel("Start 버튼을 눌러 기부천사가 되어보세요!");
		jp = new JPanel();
		jp2 = new JPanel();
		modelDonator = new DefaultListModel<String>();
		jListDonator = new JList<String>(modelDonator);
		modelRecipient = new DefaultListModel<String>();
		jListRecipient = new JList<String>(modelRecipient);
		jspDonator = new JScrollPane(jListDonator);
		jspRecipient = new JScrollPane(jListRecipient);
		jb = new JButton("START");
		
		jp.setLayout(new BorderLayout(10, 10));
		jp2.setLayout(new GridLayout(1, 2, 5, 5));
		jp2.add(jspDonator);
		jp2.add(jspRecipient);
		jp.add(jp2, BorderLayout.CENTER);
		
		ct.setLayout(new BorderLayout(10, 10));
		ct.add(jlHead, BorderLayout.NORTH);
		ct.add(jp, BorderLayout.CENTER);
		ct.add(jb, BorderLayout.SOUTH);
		jb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				recipient.start();
				donator.start();
				jb.setEnabled(false);
			}
		});
		
		setTitle(title);
		setSize(w, h);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
