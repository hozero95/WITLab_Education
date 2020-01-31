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
					dc.callback.listRecipientString("잔액이 부족하여 입금 대기중...");
				}
				else {
					dc.withdraw(amount);
					dc.callback.listRecipientString(amount + "원 출금");
				}
				dc.callback.execute("목표 기부금 : " + dc.goal + ", 현재 기부금 : " + dc.donation);
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
