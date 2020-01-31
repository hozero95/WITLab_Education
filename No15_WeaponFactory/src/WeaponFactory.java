
public class WeaponFactory extends ItemFactory {

	protected void printLog(int type) {
		System.out.print("log> ");
		if(type == 0) {
			System.out.println("���� : ��");
		}
		else if(type == 1) {
			System.out.println("���� : ������");
		}
		else if(type == 2) {
			System.out.println("���� : ��ġ");
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
