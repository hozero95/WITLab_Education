
public class MyStack {
	int[] iaData = new int[10];
	int stkptr = 0;
	
	void push(int n) {
		if(stkptr < 10) {
			iaData[++stkptr] = n;
			System.out.println("pushed : " + n);
		}
		else {
			System.out.println("������ ���� ���ֽ��ϴ�.");
		}
	}
	
	void pop() {
		if(stkptr > 0) {
			System.out.println("popped : " + iaData[stkptr]);
			iaData[stkptr--] = 0;
		}
		else {
			System.out.println("������ ����ֽ��ϴ�.");
		}
	}
}
