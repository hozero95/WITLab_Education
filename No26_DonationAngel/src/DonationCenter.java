
public class DonationCenter {
	DonationCallback callback;
	int goal;
	int donation;
	
	public DonationCenter(DonationCallback callback) {
		this.callback = callback;
		goal = 3000000;
		donation = 0;
	}
	
	public synchronized void donate(int donate) {
		donation += donate;
	}
	
	public synchronized void withdraw(int donate) {
		donation -= donate;
	}
}
