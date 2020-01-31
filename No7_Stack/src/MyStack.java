
public class MyStack {
	int[] iaData = new int[10];
	int stkptr = 0;
	
	void push(int n) {
		if(stkptr < 10) {
			iaData[++stkptr] = n;
			System.out.println("pushed : " + n);
		}
		else {
			System.out.println("스택이 가득 차있습니다.");
		}
	}
	
	void pop() {
		if(stkptr > 0) {
			System.out.println("popped : " + iaData[stkptr]);
			iaData[stkptr--] = 0;
		}
		else {
			System.out.println("스택이 비어있습니다.");
		}
	}
}
