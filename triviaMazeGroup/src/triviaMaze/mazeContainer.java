/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class is responsible for the major logic of the maze and the maze itself.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class MazeContainer implements Serializable {

  private static final long serialVersionUID = 6879807784401692805L;

  /**
   * Boolean value to check if maze is complete and player has won.
   */
  private boolean myCompleteStatus = false;
  
  /**
   * The current horizontal coordinate.
   */
  int myCurrentX = 1;
  
  /**
   * The current vertical coordinate.
   */
  int myCurrentY = 1;
  
  /**
   * The value to represent the door direction.
   */
  private int myDoorDirection = 5;
  
  /**
   * Numbers represent directions.
   */
  private static final int NORTH = 1;  
  private static final int EAST = 2;
  private static final int SOUTH = 3; 
  private static final int WEST = 0;

  /**
   * The array list of rooms that represents the maze.
   */
  ArrayList<ArrayList<Room>> myMaze = new ArrayList<ArrayList<Room>>();
  
  /**
   * The 2D array of rooms of fixed size.
   */
  Room[][] myFixedMaze = new Room[7][7];

  /**
   * This method creates the maze of rooms of certain size.
   */
  public void fixedArraySetup() {

    for (int i = 1; i < 6; i++) {
      for (int j = 1; j < 6; j++) {
        myFixedMaze[i][j] = new Room();

      }
    }
  }

  /**
   * Getter method that gets the current room.
   * @return
   */
  public Room getCurrentRoom() {
    return myFixedMaze[myCurrentX][myCurrentY];
  }

  /**
   * Door method that gets the current east door.
   * @return
   */
  public Door getCurrentDoorEast() {
    return myFixedMaze[myCurrentX][myCurrentY].getEast();
  }

  /**
   * Door method that gets the current north door.
   * @return
   */
  public Door getCurrentDoorNorth() {
    return myFixedMaze[myCurrentX][myCurrentY].getNorth();
  }
  
  /**
   * Door method that gets the current south door.
   * @return
   */
  public Door getCurrentDoorSouth() {
    return myFixedMaze[myCurrentX][myCurrentY].getSouth();
  }
  
  /**
   * Door method that gets the current west door.
   * @return
   */
  public Door getCurrentDoorWest() {
    return myFixedMaze[myCurrentX][myCurrentY].getWest();
  }
  
  /**
   * Setter method that sets the door direction.
   * @param theDirection
   */
  public void setDoorDirection(final int theDirection) {
    myDoorDirection = theDirection;
  }
  
  /**
   * Door getter method that gets the door currently faced by player.
   * @return
   */
  public Door getCurrentDoorFace() {
	    if (myDoorDirection == WEST) {
	      return getCurrentDoorWest();
	    } else if (myDoorDirection == NORTH) {
	      return getCurrentDoorNorth();
	    } else if (myDoorDirection == EAST) {
	      return getCurrentDoorEast();
	    } else if (myDoorDirection == SOUTH) {
	      return getCurrentDoorSouth();
	    } else {
	      return null;
	    }
	  }
  
  /**
   * The method that gets the value of the door direction.
   * @return
   */
  public int getDoorDirection() {
    return myDoorDirection;
  }

  /**
   * Method that gets the string value of currently facing door.
   * @return
   */
  public String getCurrentDoorFaceString() {
	    if (myDoorDirection == WEST) {
	      return "west";
	    } else if (myDoorDirection == NORTH) {
	      return "north";
	    } else if (myDoorDirection == EAST) {
	      return "east";
	    } else if (myDoorDirection == SOUTH) {
	      return "south";
	    } else {
	      return "nowhere";
	    }
	  }

  /**
   * Method that moves player north when needed.
   * @return
   */
  public void moveNorth() {
    if (checkInBoundY(-1) == false) {
      return;
    }
    myFixedMaze[myCurrentX][myCurrentY].getNorth().checkQuestion();
    if (myFixedMaze[myCurrentX][myCurrentY].getNorth().checkDoor()) {
      myCurrentY--;

    }
    
  }

  /**
   * Method that moves player east when needed.
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
   * Method that moves player south when needed.
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
   * Method that moves player west when needed.
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
   * Method that checks if player is in bounds in X direction.
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
   * Method that checks if player is in bounds in Y direction.
   */
  public boolean checkInBoundY(int theY) {
    if (myFixedMaze[myCurrentX][myCurrentY + theY] == null) {

      // System.out.println("error not in bound y ");
      return false;
    } else {
      return true;
    }
  }

  public boolean checkInBoundDirection(int theDirection) {

	    if (theDirection == SOUTH) {
	      return checkInBoundY(1);
	    } else if (theDirection == EAST) {
	      return checkInBoundX(1);
	    } else if (theDirection == NORTH) {
	      return checkInBoundY(-1);
	    } else if (theDirection == WEST) {
	      return checkInBoundX(-1);
	    } else {
	      System.out.println("invalid direction");
	      return false;
	    }
	  }

  /**
   * Moves player in facing direction.
   */
  public void moveFaceDirection() {
	    if (myDoorDirection == SOUTH) {
	      moveSouth();
	    } else if (myDoorDirection == EAST) {
	      moveEast();
	    } else if (myDoorDirection == NORTH) {
	      moveNorth();
	    } else if (myDoorDirection == WEST) {
	      moveWest();
	    }
	  }

  /**
   * Getter method that gets current X value.
   * @return
   */
  public int getCurrentX() {
    return myCurrentX;
  }
  
  /**
   * Getter method that gets current Y value.
   * @return
   */
  public int getCurrentY() {
    return myCurrentY;
  }

  /**
   * Method that blocks adjacent rooms.
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
   * Getter method that gets the maze.
   * @return
   */
  public ArrayList<ArrayList<Room>> getMaze() {
    return myMaze;
  }
  
  /**
   * Getter method that gets the fixed sized maze.
   * @return
   */
  public Room[][] getFixedMaze() {
    return myFixedMaze;
  }

  /**
   * The method that sets up the doors in rooms. 
   * @param theDoorSelection
   */
  public void setDoors(final ArrayList<Question> theDoorSelection) {
    Random rand = new Random();
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
   * Method that checks if player is in correct X bounds.
   * @param theX
   * @param theXCoordinate
   * @param theYCoordinate
   * @return
   */
  public boolean checkInBoundXDoorSetup(final int theX,
      final int theXCoordinate, final int theYCoordinate) {
    if (myFixedMaze[theXCoordinate + theX][theYCoordinate] == null) {

      // System.out.println("error not in bound x");
      return false;
    } else {
      return true;
    }
  }
  
  /**
   * Method that checks if player is in correct Y bounds.
   * @param theY
   * @param theXCoordinate
   * @param theYCoordinate
   * @return
   */
  public boolean checkInBoundYDoorSetup(final int theY,
      final int theXCoordinate, final int theYCoordinate) {
    if (myFixedMaze[theXCoordinate][theYCoordinate + theY] == null) {

      // System.out.println("error not in bound x");
      return false;
    } else {
      return true;
    }
  }

  /**
   * Method that gets the current x and y coordinates, and returns these coordinates in a string.
   * @return
   */
  public String getCurrentXYString() {
    return myCurrentX + ", " + myCurrentY;
  }

  /**
   * Method that checks if player has reached the end of the maze and thus won.
   * @return
   */
  public boolean won() {
    if (myCurrentX == myFixedMaze.length - 2
        && myCurrentY == myFixedMaze[0].length - 2) {
      myCompleteStatus = true;
      return true;
    } else {
      return myCompleteStatus;
    }
  }

}
