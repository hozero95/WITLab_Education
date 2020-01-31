import java.util.Arrays;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random rand = new Random();
		
		int[][] arr2D = new int[4][4];
		int[] num = new int[10];
		
		System.out.println("****배열 생성****");
		for(int i = 0; i < num.length; i++) {
			num[i] = rand.nextInt(10);
		}
		Arrays.sort(num);
		
		int count = 0;
		for(int i = 0; i < 4; i++) {
			for(int j = 0; j <= i; j++) {
				arr2D[i][j] = num[count];
				System.out.print(arr2D[i][j]);
				count++;
			}
			System.out.println();
		}
	}
}
