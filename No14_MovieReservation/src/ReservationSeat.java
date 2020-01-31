import java.util.Scanner;

public class ReservationSeat {
	Scanner scan = new Scanner(System.in);
	Theater cgv = new CGV();
	Theater megabox = new Megabox();
	Theater yawoori = new Yawoori();
	int theater = 0;
	
	void menu() {
		int menu;
		int select;
		boolean flag = true;
		String seat;
		String[] seatArr;
		char[] row;
		int col;
		
		System.out.println("=== �¼� ���� ���α׷� ===");
		while(flag) {
			System.out.println("1. ��ȭ�� ����");
			System.out.println("2. �¼� ����");
			System.out.println("3. �¼� Ȯ��");
			System.out.println("4. ����");
			System.out.print("�޴��� �������ּ��� : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("1. �߿츮�ó׸�, 2. �ް��ڽ�, 3. CGV");
				System.out.print("��ȭ���� �������ּ��� : ");
				select = scan.nextInt();
				switch(select) {
				case 1:
					yawoori.printWelcome();
					theater = 1;
					break;
				case 2:
					megabox.printWelcome();
					theater = 2;
					break;
				case 3:
					cgv.printWelcome();
					theater = 3;
					break;
				default:
					System.out.println("�߸��� �Է��Դϴ�.");
					break;
				}
				break;
			case 2:
				if(theater == 0) {
					System.out.println("��ȭ���� ���õ��� �ʾҽ��ϴ�.");
				}
				else {
					scan.nextLine();
					System.out.print("�¼��� ������ �ּ���.(A-C,1-5) : ");
					seat = scan.nextLine();
					seatArr = seat.split(",");
					row = seatArr[0].toCharArray();
					col = Integer.parseInt(seatArr[1]);
					if(theater == 1) {
						yawoori.reserveSeat(row[0], col);
					}
					else if(theater == 2) {
						megabox.reserveSeat(row[0], col);
					}
					else if(theater == 3) {
						cgv.reserveSeat(row[0], col);
					}
				}
				break;
			case 3:
				if(theater == 0) {
					System.out.println("��ȭ���� ���õ��� �ʾҽ��ϴ�.");
				}
				else if(theater == 1) {
					yawoori.checkSeat();
				}
				else if(theater == 2) {
					megabox.checkSeat();
				}
				else if(theater == 3) {
					cgv.checkSeat();
				}
				break;
			case 4:
				System.out.println("���α׷��� �����մϴ�.");
				flag = false;
				break;
			default:
				System.out.println("�߸��� �Է��Դϴ�.");
				break;
			}
		}
	}
}
