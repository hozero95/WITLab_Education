import java.util.Scanner;

public class PourWaterMain {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		
		WaterTank tank = new WaterTank(1000);
		WaterHoleThread thread = new WaterHoleThread(tank, 100);
		
		System.out.println("========== ¹Ø ºüÁø µ¶¿¡ ¹° º×±â ==========");
		System.out.println("1 : ¹Ø ¹Ù´Ú¿¡ ±¸¸Û ¶Õ±â");
		System.out.println("2 : ¹° º×±â (500ml)");
		
		thread.start();
		while(true) {
			num = scan.nextInt();
			switch(num) {
			case 1:
				System.out.println(">> ±¸¸Û Ãß°¡µÊ");
				new WaterHoleThread(tank, 100).start();
				break;
			case 2:
				tank.pour(500);
				System.out.println(">> ¹° º×±â (+500ml) : " + tank.getWater());
				break;
			}
		}
	}
}
