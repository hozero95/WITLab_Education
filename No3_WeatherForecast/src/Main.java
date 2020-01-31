import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int h = 0;
		int m = 0;
		int H = 0;
		
		int[] forecastTime = new int[8];
		forecastTime[0] = 23;
		for(int i = 1; i < forecastTime.length; i++) {
			forecastTime[i] = 2 + ((i - 1) * 3);
		}
		
		System.out.println("현재 시각을 입력하세요.");
		while(true) {
			h = scan.nextInt();
			m = scan.nextInt();
			if(0 <= h && h < 24 && 0 <= m && m < 60) {
				break;
			}
			System.out.println("잘못 입력하셨습니다.");
		}
		
		H = forecastTime[0];
		System.out.println("최근 동네 예보 발표 시각입니다.");
		for(int i = 1; i < forecastTime.length; i++) {
			if(h >= forecastTime[i]){
				if(m >= 10) {
					H = forecastTime[i];
				}
				else {
					H = forecastTime[i - 1];
				}
			}
		}
		System.out.println(H + " 10");
	}
}
