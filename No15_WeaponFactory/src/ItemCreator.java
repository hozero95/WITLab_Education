import java.util.Random;

public class ItemCreator {
	Item[] items = new Item[5];
	ItemFactory factory = new WeaponFactory();
	Random random = new Random();
	
	void itemCreator() {
		int[] randomItem = new int[5];
		for(int i = 0; i < 5; i++) {
			randomItem[i] = random.nextInt(3);
			items[i] = factory.createItem(randomItem[i]);
			factory.printLog(randomItem[i]);
		}
		System.out.print("생성된 아이템은 ");
		for(int i = 0; i < 5; i++) {
			System.out.print(items[i].getName() + ", ");
		}
		System.out.println("입니다.");
	}
}
