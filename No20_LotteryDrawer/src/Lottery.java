import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class Lottery {
	protected Random rand;
	protected int[] lot;
	protected int secondBonusBall;
	protected int[] entry;
	
	public Lottery() {
		
	}
	
	protected void generate() {
		rand = new Random();
		lot = new int[6];
		for(int i = 0; i < lot.length; i++) {
			lot[i] = rand.nextInt(45) + 1;
			for(int j = 0; j < i; j++) {
				if(lot[i] == lot[j]) {
					i--;
					break;
				}
			}
		}
		secondBonusBall = rand.nextInt(45) + 1;
		for(int i = 0; i < lot.length; i++) {
			if(secondBonusBall == lot[i]) {
				secondBonusBall = rand.nextInt(45) + 1;
				i = 0;
			}
		}
	}
	
	protected void inputEntry() {
		Scanner scan = new Scanner(System.in);
		entry = new int[6];
		System.out.println("***** �ζ� ��÷�� *****");
		System.out.print("���� ��ȣ�� �Է��ϼ��� (1~45, 6��) : ");
		for(int i = 0; i < entry.length; i++) {
			entry[i] = scan.nextInt();
			for(int j = 0; j < i; j++) {
				if(entry[i] == entry[j]) {
					System.out.println("�ߺ��Ǵ� �����Դϴ�. ó������ �ٽ� �Է����ּ���.");
					i = 0;
					break;
				}
			}
			if(0 < entry[i] && entry[i] <= 45) {
				continue;
			}
			else {
				System.out.println("1~45 ������ ���ڷ� �ٽ� �Է����ּ���.");
				i = 0;
			}
		}
	}
	
	protected void printResult(int grade) {
		String lotText = "��÷ ��ȣ : " + arrToStr(lot) + ", 2�� ���ʽ��� : " + secondBonusBall;
		String entryText = "���� ��ȣ : " + arrToStr(entry) + " => ";
		String result = "";
		String outfile = "C:\\Users\\WITLAB\\Desktop\\witlab_edu\\No20_LotteryDrawer";
		FileWriter fw;
		System.out.println(lotText);
		if(grade == 0) {
			entryText += "���Դϴ�.";
			System.out.println(entryText);
			result = lotText + "\r\n" + entryText + "\r\n";
			try {
				fw = new FileWriter(outfile + "\\tries.txt", true);
				fw.write(result);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		else {
			entryText += "�����մϴ�! " + grade + "���Դϴ�!";
			System.out.println(entryText);
			result = lotText + "\r\n" + entryText + "\r\n";
			try {
				fw = new FileWriter(outfile + "\\wins.txt", true);
				fw.write(result);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	protected String arrToStr(int[] arr) {
		String arrStr = "";
		for(int i = 0; i < arr.length; i++) {
			if(i == arr.length - 1) {
				arrStr += arr[i];
			}
			else {
				arrStr += arr[i] + " ";
			}
		}
		return arrStr;
	}
	
	public void playLottery() {
		inputEntry();
		generate();
		Arrays.sort(lot);
		Arrays.sort(entry);
		int grade = LottoJudge.grade(lot, secondBonusBall, entry);
		printResult(grade);
	}
}
