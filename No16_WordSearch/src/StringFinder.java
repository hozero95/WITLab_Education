import java.util.Scanner;

public class StringFinder {
	StringBuffer post = new StringBuffer("Be thankful for what you have; you'll end up having more. If you concentrate on what you don't have, you will never, ever have enough.");
	Scanner scan = new Scanner(System.in);
	
	void menu() {
		boolean flag = true;
		int select = 0;
		
		while(flag) {
			System.out.println("1. 본문 출력, 2. 단어 검색, 3. 종료");
			System.out.print("메뉴 입력 : ");
			select = scan.nextInt();
			int postLength = post.length();
			switch(select) {
			case 1:
				System.out.println(post);
				System.out.println("총 길이 : " + postLength);
				break;
			case 2:
				find();
				break;
			case 3:
				System.out.println("종료합니다.");
				flag = false;
				break;
			default:
				System.out.println("잘못된 메뉴 번호 입니다.");
				break;
			}	
		}
	}
	
	void find() {
		scan.nextLine();
		String word;
		int i = 0;
		int position = 0;
		
		System.out.print("찾을 문자를 입력하세요 : ");
		word = scan.nextLine();
		System.out.print(word + "는 ");
		while(true) {
			if(word.equals(post.substring(i, i + word.length()))) {
				position = i + 1;
				System.out.print(position + ", ");
			}
			if(post.length() <= i + word.length()) {
				System.out.println("번 째위치에 있습니다.");
				break;
			}
			i++;
		}
	}
}
