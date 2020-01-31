import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Encryptor {
	protected StringBuffer sbContent;
	protected String infile;
	protected String outfile;
	String text;
	
	public Encryptor(String infile, String outfile) {
		this.infile = infile;
		this.outfile = outfile;
		sbContent = new StringBuffer();
	}
	
	protected void fileRead() {
		try {
			FileReader fr = new FileReader(infile);
			int i;
			while((i = fr.read()) != -1) {
				sbContent.append((char)i);
			}
			fr.close();
		}catch(IOException e) {
			System.out.println(e);
		}
		System.out.println("입력 파일 내용 : " + sbContent);
	}
	
	protected void fileWrite() {
		try {
			FileWriter fw = new FileWriter(outfile);
			fw.write(text);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("출력 파일 내용 : " + text);
	}
	
	protected void encryptContent() {
		text = sbContent.toString();
		String[][] change = {{"a", "4"}, {"b", "8"}, {"c", "("}, {"e", "3"}, {"g", "9"}, {"i", "1"}, {"l", "|"}, {"o", "0"}, {"s", "5"}, {"t", "7"}, {"z", "2"}};
		
		for(int i = 0; i < 11; i++) {
			if(text.indexOf(change[i][0]) != -1) {
				text = text.replaceAll(change[i][0], change[i][1]);
			}
		}
	}
	
	public void enc() {
		fileRead();
		encryptContent();
		fileWrite();
	}
}
