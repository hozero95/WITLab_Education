import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] input = new int[3];
		int[] result = new int[2];
		BaseballGame baseballGame = new BaseballGame();
		
		System.out.println("숫자 야구 게임!");
		baseballGame.initialize();
		
		while(true) {
			while(true) {
				System.out.print("공을 던져주세요 : ");
				for(int i = 0; i < input.length; i++) {
					input[i] = scan.nextInt(10);
				}
				if(input[0] != 0 && input[1] != 0 && input[2] != 0 && input[0] != input[1] && input[0] != input[2] && input[1] != input[2]) {
					break;
				}
				System.out.println("1~9 사이의 숫자가 중복없이 입력되어야 합니다.");
			}
			
			result = baseballGame.judge(input);

			if(result[0] == 3) {
				System.out.println("정답입니다!");
				System.out.println("투구 횟수 : " + baseballGame.getCntThrow());
				break;
			}
			else if(result[0] == 0 && result[1] == 0) {
				System.out.println("아웃!!");
			}
			else {
				System.out.println(result[0] + " strike " + result[1] + " ball 입니다.");
				baseballGame.getCntThrow();
			}
		}
	}
}
