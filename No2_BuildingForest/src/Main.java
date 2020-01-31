import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.print("ºôµùÀÇ °³¼ö : ");
		int buildingCount = scan.nextInt();
		
		int[] buildingHeight = new int[buildingCount];
		System.out.print("ºôµùµéÀÇ ³ôÀÌ : ");
		for(int i = 0; i < buildingHeight.length; i++) {
			buildingHeight[i] = scan.nextInt();
		}
		
		int max = buildingHeight[0];
		int min = buildingHeight[0];
		for(int i = 1; i < buildingHeight.length; i++) {
			if(buildingHeight[i] > max) {
				max = buildingHeight[i];
			}
			if(buildingHeight[i] < min) {
				min = buildingHeight[i];
			}
		}
		System.out.println("ÃÖ°íÃş ºôµùÀÇ ³ôÀÌ : " + max);
		System.out.println("ÃÖÀúÃş ºôµùÀÇ ³ôÀÌ : " + min);
	}
}
