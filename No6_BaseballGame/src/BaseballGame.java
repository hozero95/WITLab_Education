import java.util.Random;

public class BaseballGame {
	Random r = new Random();
	int[] answer = new int[3];
	int[] strikeBall = new int[2];
	int cntThrow = 0;
	
	void initialize() {
		while(true) {
			for(int i = 0; i < answer.length; i++) {
				answer[i] = r.nextInt(10);
				while(answer[i] == 0) {
					answer[i] = r.nextInt(10);
				}
			}
			if(answer[0] != answer[1] && answer[0] != answer[2] && answer[1] != answer[2]) {
				break;
			}
		}
	}
	
	int[] judge(int[] input) {
		for(int i = 0; i < 2; i++) {
			strikeBall[i] = 0;
		}
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 3; j++) {
				if(answer[i] == input[j]) {
					if(i == j) {
						strikeBall[0]++;
					}
					else {
						strikeBall[1]++;
					}
				}
			}
		}
		cntThrow++;
		return strikeBall;
	}
	
	int getCntThrow() {
		return cntThrow;
	}
}