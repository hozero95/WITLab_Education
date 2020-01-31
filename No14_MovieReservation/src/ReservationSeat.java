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
		
		System.out.println("=== 좌석 예약 프로그램 ===");
		while(flag) {
			System.out.println("1. 영화관 선택");
			System.out.println("2. 좌석 예약");
			System.out.println("3. 좌석 확인");
			System.out.println("4. 종료");
			System.out.print("메뉴를 선택해주세요 : ");
			menu = scan.nextInt();
			
			switch(menu) {
			case 1:
				System.out.println("1. 야우리시네마, 2. 메가박스, 3. CGV");
				System.out.print("영화관을 선택해주세요 : ");
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
					System.out.println("잘못된 입력입니다.");
					break;
				}
				break;
			case 2:
				if(theater == 0) {
					System.out.println("영화관이 선택되지 않았습니다.");
				}
				else {
					scan.nextLine();
					System.out.print("좌석을 선택해 주세요.(A-C,1-5) : ");
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
					System.out.println("영화관이 선택되지 않았습니다.");
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
				System.out.println("프로그램을 종료합니다.");
				flag = false;
				break;
			default:
				System.out.println("잘못된 입력입니다.");
				break;
			}
		}
	}
}
