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
		
		System.out.println("���� �ð��� �Է��ϼ���.");
		while(true) {
			h = scan.nextInt();
			m = scan.nextInt();
			if(0 <= h && h < 24 && 0 <= m && m < 60) {
				break;
			}
			System.out.println("�߸� �Է��ϼ̽��ϴ�.");
		}
		
		H = forecastTime[0];
		System.out.println("�ֱ� ���� ���� ��ǥ �ð��Դϴ�.");
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
