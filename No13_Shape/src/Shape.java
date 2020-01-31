
public class Shape {
	protected String name;
	protected double area;  //넓이
	protected double periphery;  //둘레
	public int[] shape = new int[3];
	
	public Shape(String name) {
		this.name = name;
		area = 0.0;
		periphery = 0.0;
	}
	
	//도형의 넓이 계산하여 area에 저장
	protected void calcArea() {}
	
	//도형의 둘레의 길이 계산하여 periphery에 저장
	protected void calcPeriphery() {}
	
	public void describe() {
		calcArea();
		System.out.println(name + "의 넓이 : " + area);
		calcPeriphery();
		System.out.println(name + "의 둘레 : " + periphery);
	}
}
