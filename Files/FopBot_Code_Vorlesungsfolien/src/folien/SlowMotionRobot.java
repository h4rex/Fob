package folien;

import fopbot.*;

public class SlowMotionRobot extends SymmTurner {
	private int delay;

	public SlowMotionRobot(int x, int y, Direction direction, int numberOfCoins, int theDelay) {
		super(x, y, direction, numberOfCoins);
		delay = theDelay;
	}

	public void move() {
		super.move();
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void turnLeft() {
		super.turnLeft();
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void turnRight() {
		super.turnRight();
		try {
			Thread.sleep(delay);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
