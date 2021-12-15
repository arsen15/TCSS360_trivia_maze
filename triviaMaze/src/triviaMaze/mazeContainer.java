package triviaMaze;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * @author Ryan, Arsen, Phuc
 */

public class mazeContainer implements Serializable {

  /**
   * Unique ID that helps identify the class.
   */
  private static final long serialVersionUID = 6879807784401692805L;
  private boolean myCompleteStatus = false;
  private int myCurrentX = 1;
  private int myCurrentY = 1;
  private int myDoorDirection = 5;
  public mazeContainer() {}

  ArrayList<ArrayList<Room>> myMaze = new ArrayList<ArrayList<Room>>();
  Room[][] myFixedMaze = new Room[7][7];

  /**
   * Create the default array of size 6.
   */
  public void fixedArraySetup() {
    for (int i = 1; i < 6; i++) {
      for (int j = 1; j < 6; j++) {
        myFixedMaze[i][j] = new Room();

      }
    }
  }

  /**
   * Return the current Room that player is in.
   * 
   * @return the current room
   */
  public Room getCurrentRoom() {
    return myFixedMaze[myCurrentX][myCurrentY];
  }

  /**
   * Return the current Door in the East Direction.
   * 
   * @return the door in the East.
   */
  public Door getCurrentDoorEast() {
    return myFixedMaze[myCurrentX][myCurrentY].getEast();
  }

  /**
   * Return the current Door in the North Direction.
   * 
   * @return the door in the North.
   */
  public Door getCurrentDoorNorth() {
    return myFixedMaze[myCurrentX][myCurrentY].getNorth();
  }

  /**
   * Return the current Door in the South Direction.
   * 
   * @return the door in the South.
   */
  public Door getCurrentDoorSouth() {
    return myFixedMaze[myCurrentX][myCurrentY].getSouth();
  }

  /**
   * Return the current Door in the West Direction.
   * 
   * @return the door in the West.
   */
  public Door getCurrentDoorWest() {
    return myFixedMaze[myCurrentX][myCurrentY].getWest();
  }

  /**
   * Set the door direction.
   * 
   * @param theDirection
   *          the direction you want to set the door.
   */
  public void setDoorDirection(final int theDirection) {
    myDoorDirection = theDirection;
  }

  /**
   * Return the current door where the player is facing.
   * 
   * @return the door where player is facing
   */
  public Door getCurrentDoorFace() {
    if (myDoorDirection == 0) {
      return getCurrentDoorWest();
    } else if (myDoorDirection == 1) {
      return getCurrentDoorNorth();
    } else if (myDoorDirection == 2) {
      return getCurrentDoorEast();
    } else if (myDoorDirection == 3) {
      return getCurrentDoorSouth();
    } else {
      return null;
    }
  }

  /**
   * Get the direction of the door.
   * 
   * @return direction of the door
   */
  public int getDoorDirection() {
    return myDoorDirection;
  }

  /**
   * String presentation of where the door is facing.
   * 
   * @return the string represents where the door is facing
   */
  public String getCurrentDoorFaceString() {
    if (myDoorDirection == 0) {
      return "West";
    } else if (myDoorDirection == 1) {
      return "North";
    } else if (myDoorDirection == 2) {
      return "East";
    } else if (myDoorDirection == 3) {
      return "South";
    } else {
      return "Nowhere";
    }
  }

  /**
   * Check if we move in the North direction.
   * 
   * @return T or F if we moved in the North direction.
   */
  public boolean moveNorth() {
    if (checkInBoundY(-1) == false) {
      return false;
    }
    myFixedMaze[myCurrentX][myCurrentY].getNorth().checkQuestion();
    if (myFixedMaze[myCurrentX][myCurrentY].getNorth().checkDoor()) {
      myCurrentY--;

    }
    return true;
  }

  /**
   * Check if we move in the East direction.
   * 
   * @return T or F if we moved in the East direction.
   */
  public void moveEast() {
    if (checkInBoundX(1) == false) {
      System.out.println("move east error");
      return;
    } else {
      myFixedMaze[myCurrentX][myCurrentY].getEast().checkQuestion();
      if (myFixedMaze[myCurrentX][myCurrentY].getEast().checkDoor()) {
        myCurrentX++;
      }
    }
  }

  /**
   * Check if we move in the South direction.
   * 
   * @return T or F if we moved in the South direction.
   */
  public void moveSouth() {
    if (checkInBoundY(1) == false) {
      System.out.println("move east error");
      return;
    } else {
      myFixedMaze[myCurrentX][myCurrentY].getSouth().checkQuestion();
      if (myFixedMaze[myCurrentX][myCurrentY].getSouth().checkDoor()) {
        myCurrentY++;
      }
    }
  }

  /**
   * Check if we move in the West direction.
   * 
   * @return T or F if we moved in the West direction.
   */
  public void moveWest() {
    if (checkInBoundX(-1) == false) {
      System.out.println("move east error");
      return;
    } else {
      myFixedMaze[myCurrentX][myCurrentY].getWest().checkQuestion();
      if (myFixedMaze[myCurrentX][myCurrentY].getWest().checkDoor()) {
        myCurrentX--;
      }
    }
  }

  /**
   * Check if we are inside the maze in X Coordinate.
   * 
   * @param theX
   *          where we are in X coordinate.
   * @return T or F if we are in side the X coordinate of the maze
   */
  public boolean checkInBoundX(int theX) {

    if (myFixedMaze[myCurrentX + theX][myCurrentY] == null) {

      // System.out.println("error not in bound x");
      return false;
    } else {
      return true;
    }
  }

  /**
   * Check if we are inside the maze in Y Coordinate.
   * 
   * @param theX
   *          where we are in Y coordinate.
   * @return T or F if we are in side the Y coordinate of the maze
   */
  public boolean checkInBoundY(int theY) {
    if (myFixedMaze[myCurrentX][myCurrentY + theY] == null) {

      // System.out.println("error not in bound y ");
      return false;
    } else {
      return true;
    }
  }

  /**
   * Check if we are in the right direction.
   * 
   * @param theDirection
   *          the direction we are facing
   * @return T or F if we are inside
   */
  public boolean checkInBoundDirection(int theDirection) {
    int west = 0;
    int north = 1;
    int east = 2;
    int south = 3;
    if (theDirection == south) {
      return checkInBoundY(1);
    } else if (theDirection == east) {
      return checkInBoundX(1);
    } else if (theDirection == north) {
      return checkInBoundY(-1);
    } else if (theDirection == west) {
      return checkInBoundX(-1);
    } else {
      System.out.println("invalid direction");
      return false;
    }
  }

  /**
   * Move in the certain direction depends on the numbers.
   */
  public void moveFaceDirection() {
    if (myDoorDirection == 3) {
      moveSouth();
    } else if (myDoorDirection == 2) {
      moveEast();
    } else if (myDoorDirection == 1) {
      moveNorth();
    } else if (myDoorDirection == 0) {
      moveWest();
    }
  }

  /**
   * Return the current X coordinate of player inside the maze.
   * 
   * @return the current X coordinate
   */
  public int getCurrentX() {
    return myCurrentX;
  }

  /**
   * Return the current Y coordinate of player inside the maze.
   * 
   * @return the current Y coordinate
   */
  public int getCurrentY() {
    return myCurrentY;
  }

  /**
   * Block the doors accordingly.
   */
  public void blockAdjacent() {
    if (myDoorDirection == 0 && checkInBoundX(-1)) {
      myFixedMaze[myCurrentX - 1][myCurrentY].getEast().setBlockedStatus();
    } else if (myDoorDirection == 1 && checkInBoundY(-1)) {
      myFixedMaze[myCurrentX][myCurrentY - 1].getSouth().setBlockedStatus();
    } else if (myDoorDirection == 2 && checkInBoundX(1)) {
      myFixedMaze[myCurrentX + 1][myCurrentY].getWest().setBlockedStatus();
    } else if (myDoorDirection == 3 && checkInBoundY(1)) {
      myFixedMaze[myCurrentX][myCurrentY + 1].getNorth().setBlockedStatus();
    }

  }

  /**
   * Get the array list of the maze.
   * 
   * @return the array list
   */
  public ArrayList<ArrayList<Room>> getMaze() {
    return myMaze;
  }

  /**
   * Return the Room 2D array.
   * 
   * @return the Room 2D array.
   */
  public Room[][] getFixedMaze() {
    return myFixedMaze;
  }

  /**
   * Set the doors according to the questions.
   * 
   * @param theDoorSelection
   */
  public void setDoors(final ArrayList<Question> theDoorSelection) {
    Random rand = new Random();
    // int westCount = 0;
    // int eastCount = 0;
    // int northCount = 0;
    for (int i = 1; i < 6; i++) {
      for (int j = 1; j < 6; j++) {
        int rollNorth = rand.nextInt(theDoorSelection.size());
        int rollEast = rand.nextInt(theDoorSelection.size());
        int rollSouth = rand.nextInt(theDoorSelection.size());
        int rollWest = rand.nextInt(theDoorSelection.size());

        if (checkInBoundXDoorSetup(-1, i, j) == false) {
          myFixedMaze[i][j].getWest().setBlockedStatus();
        }
        if (checkInBoundYDoorSetup(1, i, j) == false) {
          myFixedMaze[i][j].getSouth().setBlockedStatus();
        }
        if (checkInBoundXDoorSetup(1, i, j) == false) {
          myFixedMaze[i][j].getEast().setBlockedStatus();
        }
        if (checkInBoundYDoorSetup(-1, i, j) == false) {
          myFixedMaze[i][j].getNorth().setBlockedStatus();
        }
        myFixedMaze[i][j].getNorth()
            .setQuestion(theDoorSelection.get(rollNorth));
        myFixedMaze[i][j].getEast().setQuestion(theDoorSelection.get(rollEast));
        myFixedMaze[i][j].getSouth()
            .setQuestion(theDoorSelection.get(rollSouth));
        myFixedMaze[i][j].getWest().setQuestion(theDoorSelection.get(rollWest));
      }
    }
  }

  /**
   * 
   * @param theX
   * @param theXCoordinate
   * @param theYCoordinate
   * @return
   */
  public boolean checkInBoundXDoorSetup(final int theX,
      final int theXCoordinate, final int theYCoordinate) {
    if (myFixedMaze[theXCoordinate + theX][theYCoordinate] == null) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * 
   * @param theY
   * @param theXCoordinate
   * @param theYCoordinate
   * @return
   */
  public boolean checkInBoundYDoorSetup(final int theY,
      final int theXCoordinate, final int theYCoordinate) {
    if (myFixedMaze[theXCoordinate][theYCoordinate + theY] == null) {
      return false;
    } else {
      return true;
    }
  }

  /**
   * 
   * @return
   */
  public String getCurrentXYString() {
    return myCurrentX + ", " + myCurrentY;
  }

  /**
   * 
   * @return
   */
  public boolean won() {
    if (myCurrentX == myFixedMaze.length - 2
        && myCurrentY == myFixedMaze[0].length - 2) {
      setMyCompleteStatus(true);
      return true;
    } else {
      setMyCompleteStatus(false);
      return false;
    }
  }

  /**
   * @return the myCompleteStatus
   */
  public boolean getMyCompleteStatus() {
    return myCompleteStatus;
  }

  /**
   * @param myCompleteStatus
   *          the myCompleteStatus to set
   */
  public void setMyCompleteStatus(boolean myCompleteStatus) {
    this.myCompleteStatus = myCompleteStatus;
  }

}