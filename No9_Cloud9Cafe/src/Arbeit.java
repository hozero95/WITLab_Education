import java.util.Scanner;

public class Arbeit {
	Beverage beverage;
	OrderSheet orderSheet = new OrderSheet(beverage);
	Scanner scan = new Scanner(System.in);
	String order = "";
	int totalAmount = 0;
	int mileage = 0;
	
	void takeOrder() {
		System.out.println("안녕하세요! Cloud 9 입니다~");
		while(true) {
			System.out.print("주문하실 음료를 입력하세요 : ");
			order = scan.nextLine();
			String[] orderArr = order.split(" ");
			if(orderArr[0].equals("-1")) {
				break;
			}
			else if(orderArr[0].equals("아이스")) {
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
		System.out.println("총 금액은 " + totalAmount + "원 입니다.");
		System.out.println("적립 포인트는 " + mileage + "point 입니다.");
	}
}
