import java.util.Scanner;

public class Arbeit {
	Beverage beverage;
	OrderSheet orderSheet = new OrderSheet(beverage);
	Scanner scan = new Scanner(System.in);
	String order = "";
	int totalAmount = 0;
	int mileage = 0;
	
	void takeOrder() {
		System.out.println("�ȳ��ϼ���! Cloud 9 �Դϴ�~");
		while(true) {
			System.out.print("�ֹ��Ͻ� ���Ḧ �Է��ϼ��� : ");
			order = scan.nextLine();
			String[] orderArr = order.split(" ");
			if(orderArr[0].equals("-1")) {
				break;
			}
			else if(orderArr[0].equals("���̽�")) {
				beverage = new Beverage(true, orderArr[1], Integer.parseInt(orderArr[2]));
				orderSheet.beverage = beverage;
			}
			else {
				beverage = new Beverage(orderArr[0], Integer.parseInt(orderArr[1]));
				orderSheet.beverage = beverage;
			}
			orderSheet.getTotalAmount();
		}
		orderSheet.getMileage();
	}
	
	void pay() {
		totalAmount = orderSheet.totalAmount;
		mileage = orderSheet.mileage;
		System.out.println("�� �ݾ��� " + totalAmount + "�� �Դϴ�.");
		System.out.println("���� ����Ʈ�� " + mileage + "point �Դϴ�.");
	}
}
