import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean[][] isArrSeat = new boolean[2][5];
		boolean exit = true;
		int choice = 0;
		int line = 0;
		int row = 0;
		
		System.out.println("@@ ��ȭ ���� ���α׷� @@");
		while(exit) {
			System.out.println("1. �¼� Ȯ��(O : ���� ����, X : ���� �Ϸ�)");
			System.out.println("2. �¼� ����");
			System.out.println("3. ����");
			System.out.print("�޴��� �����Ͻÿ� : ");
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
				System.out.print("������ ���� �Է��Ͻÿ� : ");
				line = scan.nextInt();
				System.out.print(line + "���� ���� �Է��Ͻÿ� : ");
				row = scan.nextInt();
				if(0 < line && line <= 2 && 0 < row && row <= 5) {
					if(isArrSeat[line - 1][row - 1] == false) {
						isArrSeat[line - 1][row - 1] = true;
					}
					else {
						System.out.println("�̹� ����� �¼��Դϴ�.");
					}
				}
				else {
					System.out.println("������ ���̳� ���� �߸� �Է��ϼ̽��ϴ�.");
				}
				break;
			case 3:
				System.out.println("���α׷��� �����մϴ�.");
				exit = false;
				break;
			default :
				System.out.println("���� �޴� ��ȣ�Դϴ�.");
			}
		}
	}
}
