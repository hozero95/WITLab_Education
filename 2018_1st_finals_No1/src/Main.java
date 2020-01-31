
public class Main {
	public static void main(String[] args) {
		MyQueue queue = new MyQueue(10);
		
		queue.input(1);
		queue.input(2);
		queue.input(3);
		queue.input(4);
		queue.input(5);
		queue.input(6);
		queue.input(7);
		queue.input(8);
		queue.input(9);
		queue.input(10);
		queue.printQueue();
		queue.input(11);
		queue.input(12);
		queue.input(13);
		queue.printQueue();
	}
}
