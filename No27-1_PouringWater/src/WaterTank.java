
public class WaterTank {
	private int water;
	
	public WaterTank(int water) {
		this.water = water;
	}
	
	public synchronized void drain(int amount) {
		while(water == 0 || water < amount) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		water -= amount;
		System.out.println("물이 " + amount + " 빠짐, " + water + "ml 남음");
	}
	
	public synchronized void pour(int amount) {
		water += amount;
		notifyAll();
	}
	
	public int getWater() {
		return water;
	}
}
