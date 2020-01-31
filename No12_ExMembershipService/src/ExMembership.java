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
			System.out.println("(���� ����)");
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
			System.out.println("(���� ����)");
		}
		else {
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
	}
	
	void insert() {
		scan.nextLine();
		String input;
		String[] inputArr;
		long id;
		String name;
		int mileage;
		
		System.out.print("\"id �̸� ����Ʈ\"�� �Է��ϼ��� (id�� �ʼ�) : ");
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
		System.out.println("�߰��Ǿ����ϴ�.");
		count++;
	}
	
	public void manage() {
		boolean flag = true;
		int num;
		
		System.out.println("**** ȸ�� ���� ���� ���α׷� ****");
		while(flag) {
			System.out.print("1. ��ȸ, 2. ����, 3. �߰�, 4. ���� : ");
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
				System.out.println("�����մϴ�.");
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
