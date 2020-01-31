
public class WaterHoleThread extends Thread {
	private WaterTank tank;
	private int amount;
	
	public WaterHoleThread(WaterTank tank, int amount) {
		this.tank = tank;
		this.amount = amount;
	}
	
	public void run() {
		while(true) {
			tank.drain(amount);
			try {
				sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
