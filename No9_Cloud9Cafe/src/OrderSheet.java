
public class OrderSheet {
	Beverage beverage;
	int totalAmount = 0;
	int mileage = 0;
	
	public OrderSheet(Beverage beverage) {
		this.beverage = beverage;
	}
	
	int getTotalAmount() {
		if(beverage.type.equals("�Ƹ޸�ī��")) {
			totalAmount += beverage.count * 2000;
			if(beverage.ice == true) {
				totalAmount += beverage.count * 200;
			}
		}
		else if(beverage.type.equals("�ٴҶ��")) {
			totalAmount += beverage.count * 3000;
			if(beverage.ice == true) {
				totalAmount += beverage.count * 200;
			}
		}
		else if(beverage.type.equals("ī��Ḷ���߶�")) {
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
