package folien;

import fopbot.*;
import static fopbot.Direction.*;

public class Array {

	public static void main(String[] args) {
		World.setVisible(true);
		Robot [ ] robots = new Robot [ 3 ];
		robots[0]= new Robot ( 0, 0, RIGHT, 4 );
		robots[1]= new Robot ( 2, 5, DOWN, 4 );
		robots[2]= new Robot ( 6, 2, UP, 4 );
		for (int i = 0; i < 4; i++) {
			for ( Robot robby : robots ) {
		          robby.putCoin();
		          robby.move();
		     }

		}


	}

}
