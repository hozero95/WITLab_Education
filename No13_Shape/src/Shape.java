
public class Shape {
	protected String name;
	protected double area;  //����
	protected double periphery;  //�ѷ�
	public int[] shape = new int[3];
	
	public Shape(String name) {
		this.name = name;
		area = 0.0;
		periphery = 0.0;
	}
	
	//������ ���� ����Ͽ� area�� ����
	protected void calcArea() {}
	
	//������ �ѷ��� ���� ����Ͽ� periphery�� ����
	protected void calcPeriphery() {}
	
	public void describe() {
		calcArea();
		System.out.println(name + "�� ���� : " + area);
		calcPeriphery();
		System.out.println(name + "�� �ѷ� : " + periphery);
	}
}
