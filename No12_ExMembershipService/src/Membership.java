import java.util.Scanner;

public class Membership {
	public static final int MAX_MEMBER = 10;
	protected Member[] memberList;
	protected Scanner scan = new Scanner(System.in);
	
	Membership() {
		memberList = new Member[MAX_MEMBER];
		memberList[0] = new Member(1001L);
		memberList[1] = new Member(1002L, "�ڴ�ȯ", 5300);
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
		System.out.print("������ ȸ�� id �Է� : ");
		id = scan.nextLong();
		System.out.print("�̸� : ");
		name = scan.next();
		System.out.print("���� ����Ʈ : ");
		mileage = scan.nextInt();
		for(int i = 0; i < memberList.length && memberList[i] != null ; i++) {
			if(id == memberList[i].getID()) {
				memberList[i].set(name);
				memberList[i].set(mileage);
			}
		}
		System.out.println("�����Ͽ����ϴ�.");
	}
	
	public void manage() {
		boolean flag = true;
		int num;
		
		System.out.println("**** ȸ�� ���� ���� ���α׷� ****");
		while(flag) {
			System.out.println("1. ��ȸ, 2. ����, 3. ���� : ");
			num = scan.nextInt();
			switch(num) {
			case 1:
				select();
				break;
			case 2:
				update();
				break;
			case 3:
				System.out.println("�����մϴ�.");
				flag = false;
				break;
			}	
		}
	}
}
