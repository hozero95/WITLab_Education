import java.util.Scanner;

public class PourWaterMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		WaterTank tank = new WaterTank(1000);
		WaterHoleThread thread = new WaterHoleThread(tank, 100);
		
		System.out.println("========== �� ���� ���� �� �ױ� ==========");
		System.out.println("1 : �� �ٴڿ� ���� �ձ�");
		System.out.println("2 : �� �ױ� (500ml)");
		
		thread.start();
		while(true) {
			num = scan.nextInt();
			switch(num) {
			case 1:
				System.out.println(">> ���� �߰���");
				new WaterHoleThread(tank, 100).start();
				break;
			case 2:
				tank.pour(500);
				System.out.println(">> �� �ױ� (+500ml) : " + tank.getWater());
				break;
			}
		}
	}
}
