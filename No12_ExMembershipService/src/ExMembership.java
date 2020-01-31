import java.util.Scanner;

public class ExMembership extends Membership {
	public static final int MAX_MEMBER = 10;
	protected Member[] memberList;
	protected Scanner scan = new Scanner(System.in);
	int count = 0;
	
	ExMembership() {
		memberList = new Member[MAX_MEMBER];
	}
	
	void select() {
		if(memberList[0] == null) {
			System.out.println("(정보 없음)");
		}
		else {
			System.out.println("id\t\tname\t\tmileage");
			System.out.println("==================================");
			for(int i = 0; i < memberList.length; i++) {
				if(memberList[i] != null) {
					System.out.println(memberList[i]);
				}
			}
			System.out.println("==================================");	
		}
	}
	
	void update() {
		long id;
		String name;
		int mileage;
		
		if(memberList[0] == null) {
			System.out.println("(정보 없음)");
		}
		else {
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
	}
	
	void insert() {
		scan.nextLine();
		String input;
		String[] inputArr;
		long id;
		String name;
		int mileage;
		
		System.out.print("\"id 이름 포인트\"를 입력하세요 (id값 필수) : ");
		input = scan.nextLine();
		inputArr = input.split(" ");
		id = Long.parseLong(inputArr[0]);
		
		if(inputArr.length > 1) {
			if(isNumeric(inputArr[1])) {
				mileage = Integer.parseInt(inputArr[1]);
				memberList[count] = new Member(id, mileage);
			}
			else {
				name = inputArr[1];
				if(inputArr.length > 2) {
					mileage = Integer.parseInt(inputArr[2]);
					memberList[count] = new Member(id, name, mileage);
				}
				else {
					memberList[count] = new Member(id, name);
				}
			}
		}
		else {
			memberList[count] = new Member(id);
		}
		System.out.println("추가되었습니다.");
		count++;
	}
	
	public void manage() {
		boolean flag = true;
		int num;
		
		System.out.println("**** 회원 정보 관리 프로그램 ****");
		while(flag) {
			System.out.print("1. 조회, 2. 수정, 3. 추가, 4. 종료 : ");
			num = scan.nextInt();
			switch(num) {
			case 1:
				select();
				break;
			case 2:
				update();
				break;
			case 3:
				insert();
				break;
			case 4:
				System.out.println("종료합니다.");
				flag = false;
				break;				
			}	
		}
	}
	
	public static boolean isNumeric(String s) {
		try {
			Double.parseDouble(s);
			return true;
		}catch(NumberFormatException e) {
			return false;
		}
	}
}
