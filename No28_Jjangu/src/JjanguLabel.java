import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JjanguLabel extends JLabel implements Runnable {
	Random rand;
	ImageIcon ii;
	int xSize, ySize;
	int xPos, yPos;
	int xMax, yMax;
	int xSpeed, ySpeed;
	int xDir, yDir;
	
	public JjanguLabel(int xMax, int yMax) {
		this.xMax = xMax;
		this.yMax = yMax;
		rand = new Random();
		ii = new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\No28_Jjangu\\jjangu.png");
		setIcon(ii);
		xSize = ii.getIconWidth();
		ySize = ii.getIconHeight();
		setSize(xSize, ySize);
		xPos = rand.nextInt(xMax - xSize);
		yPos = rand.nextInt(yMax - ySize);
		xSpeed = rand.nextInt(4) + 1;
		ySpeed = rand.nextInt(4) + 1;
	}
	
	public void run() {
		int dir = rand.nextInt(4);
		switch(dir) {
		case 0:
			xDir = 1;
			yDir = 1;
			break;
		case 1:
			xDir = 1;
			yDir = -1;
			break;
		case 2:
			xDir = -1;
			yDir = 1;
			break;
		case 3:
			xDir = -1;
			yDir = -1;
			break;
		}
		while(true) {
			if(xPos > xMax - xSize) {
				xDir = -1;
			}
			else if(xPos <= 0) {
				xDir = 1;
			}
			if(yPos > yMax - ySize) {
				yDir = -1;
			}
			else if(yPos <= 0) {
				yDir = 1;
			}
			xPos += (xDir * xSpeed);
			yPos += (yDir * ySpeed);
			setLocation(xPos, yPos);
			try {
				Thread.sleep(5);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
