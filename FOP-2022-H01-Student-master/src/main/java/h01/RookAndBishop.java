package h01;

import java.util.concurrent.ThreadLocalRandom;

import fopbot.Direction;
import fopbot.Robot;

public class RookAndBishop {
  private final int NUMBER_OF_ROWS;
  private final int NUMBER_OF_COLUMNS;
  private final int nextFrameDelay;
  private final boolean uiVisible;

  public RookAndBishop(int rows, int columns, int nextFrameDelay, boolean uiVisible) {
    this.nextFrameDelay = nextFrameDelay;
    this.uiVisible = uiVisible;
    this.NUMBER_OF_ROWS = rows > 0 ? rows : Task1.readProperty("NUMBER_OF_ROWS", Task1.TO_INTEGER);
    this.NUMBER_OF_COLUMNS = columns > 0 ? columns : Task1.readProperty("NUMBER_OF_COLUMNS", Task1.TO_INTEGER);
  }

  public RookAndBishop(int nextFrameDelay, boolean uiVisible) {
    this(-1, -1, nextFrameDelay, uiVisible);
  }

  public RookAndBishop() {
    this(20, true);
  }

  public void execute() {
    boolean ongoing = true;
    Task1.initializeTask(NUMBER_OF_ROWS, NUMBER_OF_COLUMNS, nextFrameDelay, uiVisible);
    int numberOfCoins = ThreadLocalRandom.current().nextInt(12, 20);

    Robot rook = new Robot(ThreadLocalRandom.current().nextInt(NUMBER_OF_COLUMNS),
        ThreadLocalRandom.current().nextInt(NUMBER_OF_ROWS), getRandomDirection(), numberOfCoins);

    Robot bishop = new Robot(ThreadLocalRandom.current().nextInt(NUMBER_OF_COLUMNS),
        ThreadLocalRandom.current().nextInt(NUMBER_OF_ROWS), getRandomDirection(), 0);
    while(ongoing){
      rookMovement(rook);
      bishopMovement(rook, bishop);
      if(rook.getX()==bishop.getX()&&rook.getY()==bishop.getY()&&rook.getNumberOfCoins()==0){
        System.out.println("Der Turm hat gewonnen!");
        break;
      }else if(rook.getX()==bishop.getX()&&rook.getY()==bishop.getY()){
      System.out.println("Der Läufer hat gewonnen!");
      break;
      }else if(rook.getNumberOfCoins()==0){
        System.out.println("Der Turm hat gewonnen!");
        break;
      }
    }
  }

  /**
   * Exercise 3.1 of H01
   */
  private void rookMovement(Robot rook) {
    rook.putCoin();
    int turn = ThreadLocalRandom.current().nextInt(3);
    boolean frontClear_rook = movePossible(rook.getX(), rook.getY(), rook.getDirection());
    if (frontClear_rook) {
      rook.move();
      if (turn == 0) {
        rook.turnLeft();
      } else if (turn == 2) {
        rook.turnLeft();
        rook.turnLeft();
        rook.turnLeft();

      } else if (turn == 2 | turn == 3) {
        rook.turnLeft();
        rook.turnLeft();
      }
    }

    // Hier programmieren
  }

  /**
   * Exercise 3.2 of H01
   */
  private void bishopMovement(Robot rook, Robot bishop) {
    boolean notFinished = true;
    boolean frontClear_bishop;
    while(notFinished){
      frontClear_bishop= movePossible(bishop.getX(), bishop.getY(), bishop.getDirection());
      if(frontClear_bishop){
        bishop.move();
        bishop.turnLeft();
        frontClear_bishop= movePossible(bishop.getX(), bishop.getY(), bishop.getDirection());
        if(frontClear_bishop){
          bishop.move();
          bishop.turnLeft();
          bishop.turnLeft();
          bishop.turnLeft();
        }else{
          bishop.turnLeft();
          bishop.turnLeft();
          notFinished=false;
        }
      }else{
        bishop.turnLeft();
        notFinished=false;
      }
      if(rook.getX()==bishop.getX()&&rook.getY()==bishop.getY()){
        notFinished = false;
      }else if(bishop.isNextToACoin()){
        bishop.pickCoin();
        notFinished = false;
      }
    }// Hier programmieren
  }

  public Direction getRandomDirection() {
    int random = ThreadLocalRandom.current().nextInt(3);
    Direction randomDirection = Direction.UP;
    switch (random) {
      case 0:
        randomDirection = Direction.UP;
        break;

      case 1:
        randomDirection = Direction.RIGHT;
        break;
      case 2:
        randomDirection = Direction.DOWN;
        break;
      case 3:
        randomDirection = Direction.LEFT;
    }
    return randomDirection;
  }

  public Boolean movePossible(int x, int y, Direction direction) {
    switch (direction) {
      case UP:
        if (y == NUMBER_OF_COLUMNS - 1) {
          return false;
        }
        break;
      case LEFT:
        if (x == 0) {
          return false;
        }
        break;
      case DOWN:
        if (y == 0) {
          return false;
        }
        break;
      case RIGHT:
        if (x == NUMBER_OF_ROWS - 1) {
          return false;
        }
        break;
    }
    return true;
  }
}
