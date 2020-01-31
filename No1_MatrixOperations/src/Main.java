import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] matrix1 = new int[4];
		int[] matrix2 = new int[4];
		
		System.out.println("첫 번째 배열 입력 : ");
		for(int i = 0; i < 4; i++) {
			matrix1[i] = scan.nextInt();
		}
		System.out.println("두 번째 배열 입력 : ");
		for(int i = 0; i < 4; i++) {
			matrix2[i] = scan.nextInt();
		}
		
		System.out.print("두 행렬의 합 : ");
		for(int i = 0; i < 4; i++) {
			System.out.print(matrix1[i] + matrix2[i] + " ");
		}
		System.out.println("\n");
		
		System.out.print("두 행렬의 차 : ");
		for(int i = 0; i < 4; i++) {
			System.out.print(matrix1[i] - matrix2[i] + " ");
		}
		System.out.println("\n");
		
		System.out.print("두 행렬의 곱 : ");
		for(int i = 0; i < 3; i = i + 2) {
			for(int j = 0; j < 2; j++) {
				System.out.print((matrix1[i] * matrix2[j] + matrix1[i + 1] * matrix2[j + 2]) + " ");
			}
		}
	}
}
