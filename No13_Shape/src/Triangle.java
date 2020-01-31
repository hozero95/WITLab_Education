
public class Triangle extends Shape {
	int side1;
	int side2;
	int side3;
	double k;
	
	public Triangle(String name, int side1, int side2, int side3) {
		super(name);
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	protected void calcArea() {
		k = (side1 + side2 + side3) / 2;
		super.area = Math.sqrt(k * (k - side1) * (k - side2) * (k- side3));
	}
	
	protected void calcPeriphery() {
		super.periphery = side1 + side2 + side3;
	}
}
