import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pig extends JLabel implements Runnable {
	Random rand;
	ImageIcon pig, pig2;
	int xMax;
	int xSize, ySize;
	int xPos, yPos;
	int xSpeed;
	int xDir;
	boolean check;
	
	public Pig(int xMax) {
		this.xMax = xMax;
		rand = new Random();
		pig = new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\2018_2nd_finals_class2_No2\\pig.png");
		pig2 = new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\2018_2nd_finals_class2_No2\\pig2.png");
		setIcon(pig);
		xSize = pig.getIconWidth();
		ySize = pig.getIconHeight();
		setSize(xSize, ySize);
		xPos = 0;
		yPos = 0;
		check = true;
	}
	
	void hitPig() {
		setIcon(pig2);
		check = false;
	}
	
	public void run() {
		int dir = rand.nextInt(2);
		switch(dir) {
		case 0:
			xDir = 1;
			break;
		case 1:
			xDir = -1;
			break;
		}
		while(check) {
			xSpeed = rand.nextInt(4) + 2;
			if(xPos > xMax - xSize) {
				xDir = -1;
			}
			else if(xPos <= 0) {
				xDir = 1;
			}
			xPos += (xDir * xSpeed);
			setLocation(xPos, yPos);
			try {
				Thread.sleep(5);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
