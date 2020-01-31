import java.util.Random;

public class Recipient extends Thread {
	DonationCenter dc;
	
	Random rand = new Random();
	int time;
	int amount;
	
	public Recipient(DonationCenter dc) {
		this.dc = dc;
	}
	
	public void run() {
		while(true) {
			time = (rand.nextInt(10) + 1) * 100;
			if(dc.goal > dc.donation) {
				amount = 100000 + (rand.nextInt(201) * 1000);
				if(dc.donation - amount < 0) {
					dc.callback.listRecipientString("�ܾ��� �����Ͽ� �Ա� �����...");
				}
				else {
					dc.withdraw(amount);
					dc.callback.listRecipientString(amount + "�� ���");
				}
				dc.callback.execute("��ǥ ��α� : " + dc.goal + ", ���� ��α� : " + dc.donation);
				try {
					sleep(time);
				}catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			else {
				break;
			}
		}
	}
}
