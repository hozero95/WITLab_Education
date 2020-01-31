import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean[][] isArrSeat = new boolean[2][5];
		boolean exit = true;
		int choice = 0;
		int line = 0;
		int row = 0;
		
		System.out.println("@@ 영화 예약 프로그램 @@");
		while(exit) {
			System.out.println("1. 좌석 확인(O : 예약 가능, X : 예약 완료)");
			System.out.println("2. 좌석 예약");
			System.out.println("3. 종료");
			System.out.print("메뉴를 선택하시오 : ");
			choice = scan.nextInt();
			
			switch(choice) {
			case 1:
				for(int i = 0; i < 2; i++) {
					for(int j = 0; j < 5; j++) {
						if(isArrSeat[i][j] == false) {
							System.out.print("O ");
						}
						else {
							System.out.print("X ");
						}
					}
					System.out.println();
				}
				System.out.println();
				break;
			case 2:
				System.out.print("예약할 행을 입력하시오 : ");
				line = scan.nextInt();
				System.out.print(line + "행의 열을 입력하시오 : ");
				row = scan.nextInt();
				if(0 < line && line <= 2 && 0 < row && row <= 5) {
					if(isArrSeat[line - 1][row - 1] == false) {
						isArrSeat[line - 1][row - 1] = true;
					}
					else {
						System.out.println("이미 예약된 좌석입니다.");
					}
				}
				else {
					System.out.println("예약할 행이나 열을 잘못 입력하셨습니다.");
				}
				break;
			case 3:
				System.out.println("프로그램을 종료합니다.");
				exit = false;
				break;
			default :
				System.out.println("없는 메뉴 번호입니다.");
			}
		}
	}
}
