
public class Beverage {
	boolean ice;
	String type;
	int count;
	
	Beverage(boolean ice, String type, int count){
		this.ice = ice;
		this.type = type;
		this.count = count;
	}
	
	Beverage(String type, int count){
		this.type = type;
		this.count = count;
	}
}
