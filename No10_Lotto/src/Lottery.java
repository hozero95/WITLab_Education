import java.util.Random;
import java.util.Scanner;

public class Lottery {
	Random random = new Random();
	Scanner scan = new Scanner(System.in);
	int[] lot = new int[6];
	int bonus = 0;
	int[] entry = new int[6];
	int temp;
	int grade;
	
	void lottery() {
		for(int i = 0; i < lot.length; i++) {
			lot[i] = random.nextInt(45) + 1;
			for(int j = 0; j < i; j++) {
				if(lot[i] == lot[j]) {
					i--;
					break;
				}
			}
		}
		bonus = random.nextInt(45) + 1;
		for(int i = 0; i < lot.length; i++) {
			if(bonus == lot[i]) {
				bonus = random.nextInt(45) + 1;
				i = 0;
			}
		}
		
		System.out.print("응모 번호를 입력하세요 : ");
		for(int i = 0; i < entry.length; i++) {
			entry[i] = scan.nextInt();
			for(int j = 0; j < i; j++) {
				if(entry[i] == entry[j]) {
					System.out.println("중복되는 숫자입니다. 처음부터 다시 입력해주세요.");
					i = 0;
					break;
				}
			}
			if(0 < entry[i] && entry[i] <= 45) {
				continue;
			}
			else {
				System.out.println("1~45 사이의 숫자로 다시 입력해주세요.");
				i = 0;
			}
		}
		
		for(int i = 0; i < lot.length; i++) {
			for(int j = i + 1; j < lot.length; j++) {
				if(lot[i] > lot[j]) {
					temp = lot[i];
					lot[i] = lot[j];
					lot[j] = temp;
				}
			}
		}
		for(int i = 0; i < entry.length; i++) {
			for(int j = i + 1; j < entry.length; j++) {
				if(entry[i] > entry[j]) {
					temp = entry[i];
					entry[i] = entry[j];
					entry[j] = temp;
				}
			}
		}
		
		System.out.print("당첨 번호 : ");
		for(int i = 0; i < lot.length; i++) {
			System.out.print(lot[i] + " ");
		}
		System.out.println(", 2등 보너스 볼 : " + bonus);
		System.out.print("응모 번호 : ");
		for(int i = 0; i < entry.length; i++) {
			System.out.print(entry[i] + " ");
		}
		System.out.println();
		
		grade = LottoJudge.grade(lot, bonus, entry);
		if(grade == 0) {
			System.out.println("꽝입니다.");
		}
		else {
			System.out.println("축하합니다! " + grade + "등입니다!");
		}
	}
}
