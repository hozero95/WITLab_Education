import java.util.Scanner;

public class StringFinder {
	StringBuffer post = new StringBuffer("Be thankful for what you have; you'll end up having more. If you concentrate on what you don't have, you will never, ever have enough.");
	Scanner scan = new Scanner(System.in);
	
	void menu() {
		boolean flag = true;
		int select = 0;
		
		while(flag) {
			System.out.println("1. ���� ���, 2. �ܾ� �˻�, 3. ����");
			System.out.print("�޴� �Է� : ");
			select = scan.nextInt();
			int postLength = post.length();
			switch(select) {
			case 1:
				System.out.println(post);
				System.out.println("�� ���� : " + postLength);
				break;
			case 2:
				find();
				break;
			case 3:
				System.out.println("�����մϴ�.");
				flag = false;
				break;
			default:
				System.out.println("�߸��� �޴� ��ȣ �Դϴ�.");
				break;
			}	
		}
	}
	
	void find() {
		scan.nextLine();
		String word;
		int i = 0;
		int position = 0;
		
		System.out.print("ã�� ���ڸ� �Է��ϼ��� : ");
		word = scan.nextLine();
		System.out.print(word + "�� ");
		while(true) {
			if(word.equals(post.substring(i, i + word.length()))) {
				position = i + 1;
				System.out.print(position + ", ");
			}
			if(post.length() <= i + word.length()) {
				System.out.println("�� °��ġ�� �ֽ��ϴ�.");
				break;
			}
			i++;
		}
	}
}
