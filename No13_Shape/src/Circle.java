
public class Circle extends Shape {
	int radius;

	public Circle(String name, int radius) {
		super(name);
		this.radius = radius;
	}
	
	protected void calcArea() {
		super.area = radius * radius * Math.PI;
	}
	
	protected void calcPeriphery() {
		super.periphery = 2 * radius * Math.PI;
	}
}
