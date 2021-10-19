package folien;

import fopbot.*;
import static fopbot.Direction.*;

public class ChessArray {

	public static void main(String[] args) {
		World.setVisible(true);
		Robot [ ]  lineRobots = new Robot [ 8 ];
		for ( int i = 0; i < lineRobots.length; i++ ) {
		     lineRobots[i] = new Robot ( 1, i, RIGHT, 4 );
		     boolean coinToBePut = ( i % 2 == 1 );
		     for (int j = 0; j < 8; j++) {
		         if ( coinToBePut )
		             lineRobots[i].putCoin();
		         coinToBePut = ! coinToBePut;
		         lineRobots[i].move();
		     }
		}

	}

}
