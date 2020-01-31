
public class Donator {
	
	boolean donate(int won) {
		if(0 < won && won <= 20) {
			return true;
		}
		else {
			return false;
		}
	}
}
