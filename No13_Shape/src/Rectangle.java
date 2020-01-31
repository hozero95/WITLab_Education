
public class Rectangle extends Shape{
	int width;
	int height;
	
	public Rectangle(String name, int width, int height) {
		super(name);
		this.width = width;
		this.height = height;
	}
	
	protected void calcArea() {
		super.area = width * height;
	}
	
	protected void calcPeriphery() {
		super.periphery = (2 * width) + (2 * height);
	}
}
