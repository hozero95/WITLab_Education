import java.io.FileReader;
import java.io.IOException;

public class GPACalc {
	private StringBuffer sbFileContent;
	
	public GPACalc() {
		sbFileContent = new StringBuffer();
	}
	
	void readSbjGrade(String path) {
		try {
			FileReader fr = new FileReader(path);
			int i;
			while((i = fr.read()) != -1) {
				sbFileContent.append((char)i);
			}
			fr.close();
		}catch(IOException e) {
			System.out.println(e);
		}
	}
	
	void printContent() {
		System.out.println("========= 1�б� ���� =========");
		System.out.println(sbFileContent);
		System.out.println("===========================");
	}
	
	void printGpa() {
		double sum = 0;
		double average = 0;
		String[] line = sbFileContent.toString().split("\n");
		
		for(int i = 0; i < line.length; i++) {
			String[] inline = line[i].split(" ");
			sum += Double.parseDouble(inline[2]);
		}
		average = sum / line.length;
		System.out.println("1�б� ��������� " + String.format("%.2f", average) + "�Դϴ�.");
	}
}
