import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Arrow extends JLabel implements Runnable {
	ImageIcon arrow;
	int xMax, yMax;
	int xSize, ySize;
	int xPos, yPos;
	
	Pig pig;
	
	public Arrow(int xMax, int yMax, Pig pig) {
		this.pig = pig;
		this.yMax = yMax;
		arrow = new ImageIcon("C:\\Users\\WITLAB\\Desktop\\witlab_edu\\2018_2nd_finals_class2_No2\\arrow.png");
		setIcon(arrow);
		xSize = arrow.getIconWidth();
		ySize = arrow.getIconHeight();
		setSize(xSize, ySize);
		xPos = xMax / 2;
		yPos = yMax;
	}
	
	public void run() {
		setLocation(xPos, yPos);
		while(yPos >= 0) {
			yPos -= 3;
			setLocation(xPos, yPos);
			
			int pigXSize = pig.xSize;
			int pigYSize = pig.ySize;
			int pigXPos = (int)pig.getLocation().getX();
			if((xPos >= pigXPos) && (xPos <= (pigXPos + pigXSize)) && (yPos == pigYSize)) {
				pig.hitPig();
			}
			
			try {
				Thread.sleep(5);
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		setIcon(null);
	}
}
