
public class Main {
	public static void main(String[] args) {
		GPACalc gpaCalc = new GPACalc();
		gpaCalc.readSbjGrade("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\No18_GetAverage\\1st_sem.txt");
		gpaCalc.printContent();
		gpaCalc.printGpa();
	}
}
