
public class MyQueue {
	private int[] queue;
	private int head;
	private int tail;
	
	public MyQueue(int size) {
		queue = new int[size];
		head = -1;
		tail = -1;
	}
	
	//ť ����
	public void input(int number) {
		if(tail == -1 && head == -1) {
			tail = 0;
			head = 0;
		}
		else {
			if(tail != queue.length - 1) {
				tail++;	
			}
			sortQueue();
		}
		queue[head] = number;
		System.out.println("* ������ ���� : " + queue[head]);
	}
	
	//ť ����
	public void sortQueue() {
		for(int i = tail; i > 0; i--) {
			queue[i] = queue[i - 1];
		}
	}
	
	public void printQueue() {
		System.out.println("> ���� ť ������ ��Ȳ");
		for(int i = 0; i <= tail; i++) {
			System.out.println("queue[" + i + "] : " + queue[i]);
		}
	}
}
