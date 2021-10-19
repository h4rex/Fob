package folien;

import fopbot.*;

public class PacmanRobot1 extends SymmTurner {
	
	private boolean nextTurnLeft;

	public PacmanRobot1(int x, int y, Direction direction) {
		super(x, y, direction, 0);
		nextTurnLeft = true;
	}
	
	private void pickAllCoins () {
	     while ( isNextToACoin() )
	          pickCoin();
	}

	public void huntCoinsOneStep() {
	      move();
	      pickAllCoins();
	      if ( nextTurnLeft == true ) {
	          turnLeft();
	          nextTurnLeft = false;
	      }
	     else {
	          turnRight();
	          nextTurnLeft = true;
	     }

	}


}
