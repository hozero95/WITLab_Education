
public class WaterHoleThreadEx extends WaterHoleThread {
	int count;
	
	public WaterHoleThreadEx(WaterTank tank, int amount, int count) {
		super(tank, amount);
		this.count = count;
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
