import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MyStack myStack = new MyStack();
		String str = "";
		
		while(true) {
			System.out.print("MyStack> ");
			str = scan.nextLine();
			String[] strArr = str.split(" ");
			if(strArr[0].equals("push")) {
				myStack.push(Integer.parseInt(strArr[1]));
			}
			else if(strArr[0].equals("pop")) {
				myStack.pop();
			}
			else if(strArr[0].equals("exit")) {
				System.out.println("안녕~");
				break;
			}
			else {
				System.out.println("잘못된 명령어입니다.");
			}
		}
	}
}
