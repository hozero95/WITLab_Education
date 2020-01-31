
abstract class Theater {
	boolean[][] seat = new boolean[3][5];
	
	abstract void printWelcome();
	
	void reserveSeat(char row, int col){
		int row2 = 0;
		if(row == 'A') {
			row2 = 1;
		}
		else if(row == 'B') {
			row2 = 2;
		}
		else if(row == 'C') {
			row2 = 3;
		}
		
		if(0 < row2 && row2 <= 3 && 0 < col && col <= 5) {
			if(seat[row2 - 1][col - 1] == false) {
				seat[row2 - 1][col - 1] = true;
				System.out.println(row + "�� " + col + "������ ���� �Ǿ����ϴ�.");
			}
			else {
				System.out.println("�̹� ����� �¼��Դϴ�.");
			}
		}
		else {
			System.out.println("������ ���̳� ���� �߸� �Է��ϼ̽��ϴ�.");
		}
	}
	
	void checkSeat() {
		char row = 'A';
		System.out.println("\t1\t2\t3\t4\t5");
		for(int i = 0; i < 3; i++) {
			System.out.print(row++ + "\t");
			for(int j = 0; j < 5; j++) {
				if(seat[i][j] == false) {
					System.out.print("O\t");
				}
				else {
					System.out.print("X\t");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
