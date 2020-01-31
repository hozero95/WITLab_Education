import java.util.Scanner;

public class HangmanGame extends AbsHangmanGame {
	String[] answerArr;
	boolean endGame = false;
	
	public HangmanGame() {
		answer = "committee";
		isBlank = new boolean[answer.length()];
		scan = new Scanner(System.in);
		max = 8;
	}
	
	protected void intro() {
		System.out.println("Hangman Game!");
		System.out.println("�� �õ�Ƚ�� : " + max + "ȸ");
		count = 1;
	}

	protected void print() {
		int check = 0;
		answerArr = answer.split("");
		for(int i = 0; i < answerArr.length; i++) {
			if(isBlank[i] == false) {
				System.out.print("_ ");
			}
			else {
				System.out.print(answerArr[i] + " ");
				check++;
			}
		}
		System.out.println();
		if(check == answerArr.length) {
			System.out.println("����!");
			endGame = true;
		}
	}

	protected void guess() {
		String inputChar;
		System.out.print(max + "ȸ �� " + count + "ȸ�� �õ� : ");
		while(true) {
			inputChar = scan.next();
			char[] check = inputChar.toCharArray();
			input = check[0];
			if(Character.isAlphabetic(input)) {
				Character.toLowerCase(input);
				break;
			}
			else {
				System.out.print("������ �Է����ּ��� : ");
			}
		}
	}

	protected void check() {
		int check = 0;
		char[] checkArr = answer.toCharArray();
		for(int i = 0; i < checkArr.length; i++) {
			if(checkArr[i] == input) {
				isBlank[i] = true;
				check++;
			}
		}
		if(check == 0) {
			System.out.println("Ʋ�Ƚ��ϴ�!");
		}
		else {
			System.out.println("������ϴ�!");
		}
	}

	protected boolean gameEnd() {
		if(endGame) {
			return true;
		}
		if(count >= max) {
			System.out.println("����! ������ " + answer + "�Դϴ�.");
			return true;
		}
		count++;
		return false;
	}

}
