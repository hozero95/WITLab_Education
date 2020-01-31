import java.util.Random;

public class Donator extends Thread {
	DonationCenter dc;
	
	Random rand = new Random();
	int time;
	int amount;
	
	public Donator(DonationCenter dc) {
		this.dc = dc;
	}
	
	public void run() {
		while(true) {
			time = (rand.nextInt(10) + 1) * 100;
			if(dc.goal > dc.donation) {
				amount = 100000 + (rand.nextInt(401) * 1000);
				dc.donate(amount);
				if(dc.goal > dc.donation) {
					dc.callback.execute("목표 기부금 : " + dc.goal + ", 현재 기부금 : " + dc.donation);
				}
				else {
					dc.callback.execute("목표 기부금 : " + dc.goal + ", 현재 기부금 : " + dc.donation + " - 목표 달성!!");
				}
				dc.callback.listDonatorString(amount + "원 입금");
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
