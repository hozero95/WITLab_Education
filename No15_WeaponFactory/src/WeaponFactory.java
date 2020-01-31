
public class WeaponFactory extends ItemFactory {

	protected void printLog(int type) {
		System.out.print("log> ");
		if(type == 0) {
			System.out.println("积己 : 八");
		}
		else if(type == 1) {
			System.out.println("积己 : 瘤莆捞");
		}
		else if(type == 2) {
			System.out.println("积己 : 噶摹");
		}
	}

	protected Item createItem(int type) {
		if(type == 0) {
			return new Sword();
		}
		else if(type == 1) {
			return new Staff();
		}
		else if(type == 2) {
			return new Hammer();
		}
		return null;
	}
	
}
