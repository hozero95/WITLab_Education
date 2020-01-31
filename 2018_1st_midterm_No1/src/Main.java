import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int num;
		int decimal;
		int[] binary = new int[32];
		int[] hexa = new int[8];
		
		System.out.println("=== 진수 변환기 ===");
		System.out.print("10진수 입력 : ");
		num = scan.nextInt();
		System.out.println("입력받은 10진수 : " + num);
		
		System.out.print(num + "의 2진수 표기 : ");
		decimal = num;
		int i = 0;
		while(decimal != 1) {
			binary[i++] = decimal % 2;
			decimal = decimal / 2;
		}
		binary[i] = decimal;
		for(int j = i; j >= 0; --j) {
			System.out.print(binary[j]);
		}
		System.out.println();
		
		System.out.print(num + "의 16진수 표기 : ");
		
		int buffer = 0;
		int division = 1;
		int count = 0;
		char returnChar;
		for(int j = 0; j < binary.length; j++) {
			buffer += (binary[j] * division);
			division = division * 2;
			if((j + 1) % 4 == 0) {
				hexa[count] = buffer;
				buffer = 0;
				division = 1;
				count++;
			}
		}
		boolean check = true;
		for(int j = hexa.length - 1; j >= 0; j--) {
			if(hexa[j] == 0 && check == true) {
				continue;
			}
			check = false;
			if((hexa[j]) < 10) {
				System.out.print(hexa[j]);
			}
			else {
				returnChar = (char)(hexa[j] + 55);
				System.out.print(returnChar);
			}
		}
	}
}
