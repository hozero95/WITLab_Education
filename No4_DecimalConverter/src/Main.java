import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n = 0;
		int sum = 0;
		
		System.out.print("이진수의 자릿수를 입력하세요(0<n<32) : ");
		while(true) {
			n = scan.nextInt();
			if(0 < n && n < 32) {
				break;
			}
			System.out.print("다시 입력해주세요 : ");
		}
		
		System.out.println("이진수를 입력하세요");
		int[] num = new int[n];
		for(int i = n - 1; i >= 0; i--) {
			num[i] = scan.nextInt();
		}
		
		for(int i = 0; i < n; i++) {
			if(num[i] == 1) {
				sum = (int)(sum + Math.pow(2, i));	
			}
		}
		System.out.println("십진수 : " + sum);
	}
}
