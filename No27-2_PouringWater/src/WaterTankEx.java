
public class WaterTankEx extends WaterTank {
	WaterCallback callback;
	int maxWater;
	
	public WaterTankEx(int water, WaterCallback callback) {
		super(water);
		this.callback = callback;
		maxWater = water;
	}

	public synchronized void drain(int amount, int count) {
		while(water == 0 || water < amount) {
			try {
				wait();
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		water -= amount;
		callback.callbackDrain(count + ")-" + amount + "ml, " + water + "ml ����");
	}
	
	public synchronized void pour(int amount) {
		callback.callbackPour("�� ���� : " + amount);
		if(maxWater < water + amount) {
			water = maxWater;
			callback.callbackPour("���� ���� á���ϴ�.");
		}
		else {
			water += amount;
		}
		notifyAll();
	}
	
	public int getWater() {
		return water;
	}
}
