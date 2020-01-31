
public class WaterHoleThread extends Thread {
	protected WaterTank tank;
	protected int amount;
	int count;
	
	public WaterHoleThread(WaterTank tank, int amount) {
		this.tank = tank;
		this.amount = amount;
	}
	
	public void run() {
		while(true) {
			tank.drain(amount, count);
			try {
				sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
