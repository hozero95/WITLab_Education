import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = new int[3];
		int[] result = new int[2];
		BaseballGame baseballGame = new BaseballGame();
		
		System.out.println("���� �߱� ����!");
		baseballGame.initialize();
		
		while(true) {
			while(true) {
				System.out.print("���� �����ּ��� : ");
				for(int i = 0; i < input.length; i++) {
					input[i] = scan.nextInt(10);
				}
				if(input[0] != 0 && input[1] != 0 && input[2] != 0 && input[0] != input[1] && input[0] != input[2] && input[1] != input[2]) {
					break;
				}
				System.out.println("1~9 ������ ���ڰ� �ߺ����� �ԷµǾ�� �մϴ�.");
			}
			
			result = baseballGame.judge(input);

			if(result[0] == 3) {
				System.out.println("�����Դϴ�!");
				System.out.println("���� Ƚ�� : " + baseballGame.getCntThrow());
				break;
			}
			else if(result[0] == 0 && result[1] == 0) {
				System.out.println("�ƿ�!!");
			}
			else {
				System.out.println(result[0] + " strike " + result[1] + " ball �Դϴ�.");
				baseballGame.getCntThrow();
			}
		}
	}
}
