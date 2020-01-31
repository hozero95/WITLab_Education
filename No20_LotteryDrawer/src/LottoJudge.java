
public class LottoJudge {
	static int grade(int[] lot, int second, int[] entry) {
		int grade = 0;
		int count = 0;
		int bonusCount = 0;
		
		for(int i = 0; i < entry.length; i++) {
			for(int j = 0; j < lot.length; j++) {
				if(entry[i] == lot[j]) {
					count++;
				}
			}
			if(entry[i] == second) {
				bonusCount = 1;
			}
		}
		
		if(count == 6) {
			grade = 1;
		}
		else if(count == 5) {
			if(bonusCount == 1) {
				grade = 2;
			}
			else {
				grade = 3;
			}
		}
		else if(count == 4) {
			grade = 4;
		}
		else if(count == 3) {
			grade = 5;
		}
		return grade;
	}
}
