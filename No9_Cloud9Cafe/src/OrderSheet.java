
public class OrderSheet {
	Beverage beverage;
	int totalAmount = 0;
	int mileage = 0;
	
	public OrderSheet(Beverage beverage) {
		this.beverage = beverage;
	}
	
	int getTotalAmount() {
		if(beverage.type.equals("¾Æ¸Þ¸®Ä«³ë")) {
			totalAmount += beverage.count * 2000;
			if(beverage.ice == true) {
				totalAmount += beverage.count * 200;
			}
		}
		else if(beverage.type.equals("¹Ù´Ò¶ó¶ó¶¼")) {
			totalAmount += beverage.count * 3000;
			if(beverage.ice == true) {
				totalAmount += beverage.count * 200;
			}
		}
		else if(beverage.type.equals("Ä«¶ó¸á¸¶³¢¾ß¶Ç")) {
			totalAmount += beverage.count * 4000;
			if(beverage.ice == true) {
				totalAmount += beverage.count * 200;
			}
		}
		return totalAmount;
	}
	
	int getMileage() {
		mileage += totalAmount * 5 / 100;
		return mileage;
	}
}
