import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int[] matrix1 = new int[4];
		int[] matrix2 = new int[4];
		
		System.out.println("ù ��° �迭 �Է� : ");
		for(int i = 0; i < 4; i++) {
			matrix1[i] = scan.nextInt();
		}
		System.out.println("�� ��° �迭 �Է� : ");
		for(int i = 0; i < 4; i++) {
			matrix2[i] = scan.nextInt();
		}
		
		System.out.print("�� ����� �� : ");
		for(int i = 0; i < 4; i++) {
			System.out.print(matrix1[i] + matrix2[i] + " ");
		}
		System.out.println("\n");
		
		System.out.print("�� ����� �� : ");
		for(int i = 0; i < 4; i++) {
			System.out.print(matrix1[i] - matrix2[i] + " ");
		}
		System.out.println("\n");
		
		System.out.print("�� ����� �� : ");
		for(int i = 0; i < 3; i = i + 2) {
			for(int j = 0; j < 2; j++) {
				System.out.print((matrix1[i] * matrix2[j] + matrix1[i + 1] * matrix2[j + 2]) + " ");
			}
		}
	}
}
