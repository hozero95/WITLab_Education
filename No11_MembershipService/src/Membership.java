import java.util.Scanner;

public class Membership {
	public static final int MAX_MEMBER = 10;
	protected Member[] memberList;
	protected Scanner scan = new Scanner(System.in);
	
	Membership() {
		memberList = new Member[MAX_MEMBER];
		memberList[0] = new Member(1001L);
		memberList[1] = new Member(1002L, "박대환", 5300);
		memberList[2] = new Member(1003L, "Jake");
		memberList[3] = new Member(1004L, 7700);
	}
	
	void select() {
		System.out.println("id\t\tname\t\tmileage");
		System.out.println("==================================");
		for(int i = 0; i < memberList.length; i++) {
			if(memberList[i] != null) {
				System.out.println(memberList[i]);
			}
		}
		System.out.println("==================================");
	}
	
	void update() {
		long id;
		String name;
		int mileage;
		System.out.print("수정할 회원 id 입력 : ");
		id = scan.nextLong();
		System.out.print("이름 : ");
		name = scan.next();
		System.out.print("적립 포인트 : ");
		mileage = scan.nextInt();
		for(int i = 0; i < memberList.length && memberList[i] != null ; i++) {
			if(id == memberList[i].getID()) {
				memberList[i].set(name);
				memberList[i].set(mileage);
			}
		}
		System.out.println("수정하였습니다.");
	}
	
	public void manage() {
		boolean flag = true;
		int num;
		
		System.out.println("**** 회원 정보 수정 프로그램 ****");
		while(flag) {
			System.out.println("1. 조회, 2. 수정, 3. 종료 : ");
			num = scan.nextInt();
			switch(num) {
			case 1:
				select();
				break;
			case 2:
				update();
				break;
			case 3:
				System.out.println("종료합니다.");
				flag = false;
				break;
			}	
		}
	}
}
