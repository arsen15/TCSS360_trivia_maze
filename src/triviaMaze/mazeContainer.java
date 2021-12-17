package triviaMaze;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class mazeContainer implements Serializable {

  private static final long serialVersionUID = 6879807784401692805L;
// set the currentX and Y to public to test the getCurrentXY
  private boolean myCompleteStatus = false;
  public int myCurrentX = 1;
  public int myCurrentY = 1;
  private int myDoorDirection = 5; 
  
  private static final int NORTH =1;  
  private static final int EAST =2;
  private static final int SOUTH = 3; 
  private static final int WEST = 0;
  
  
  
  public mazeContainer() {

  }

 // ArrayList<ArrayList<Room>> myMaze = new ArrayList<ArrayList<Room>>();
  Room[][] myFixedMaze = new Room[7][7];

  public void fixedArraySetup() {

    for (int i = 1; i < 6; i++) {
      for (int j = 1; j < 6; j++) {
        myFixedMaze[i][j] = new Room();

      }
    }
  }

  public Room getCurrentRoom() {
    return myFixedMaze[myCurrentX][myCurrentY];
  }

  public Door getCurrentDoorEast() {
    return myFixedMaze[myCurrentX][myCurrentY].getEast();
  }

  public Door getCurrentDoorNorth() {
    return myFixedMaze[myCurrentX][myCurrentY].getNorth();
  }
  public Door getCurrentDoorSouth() {
    return myFixedMaze[myCurrentX][myCurrentY].getSouth();
  }
  public Door getCurrentDoorWest() {
    return myFixedMaze[myCurrentX][myCurrentY].getWest();
  }
  public void setDoorDirection(final int theDirection) {
    myDoorDirection = theDirection;
  }
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
  public int getDoorDirection() {
    return myDoorDirection;
  }

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

  public void moveNorth() {
    if (checkInBoundY(-1) == false) {
      return;
    }
    myFixedMaze[myCurrentX][myCurrentY].getNorth().checkQuestion();
    if (myFixedMaze[myCurrentX][myCurrentY].getNorth().checkDoor()) {
      myCurrentY--;

    }
  
  }

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

  public boolean checkInBoundX(int theX) {

    if (myFixedMaze[myCurrentX + theX][myCurrentY] == null) {

      // System.out.println("error not in bound x");
      return false;
    } else {
      return true;
    }
  }
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

  public int getCurrentX() {
    return myCurrentX;
  }
  public int getCurrentY() {
    return myCurrentY;
  }

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
/*
  public ArrayList<ArrayList<Room>> getMaze() {
    return myMaze;
  } */
  public Room[][] getFixedMaze() {
    return myFixedMaze;
  }

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

  public boolean checkInBoundXDoorSetup(final int theX,
      final int theXCoordinate, final int theYCoordinate) {
    if (myFixedMaze[theXCoordinate + theX][theYCoordinate] == null) {

      // System.out.println("error not in bound x");
      return false;
    } else {
      return true;
    }
  }
  public boolean checkInBoundYDoorSetup(final int theY,
      final int theXCoordinate, final int theYCoordinate) {
    if (myFixedMaze[theXCoordinate][theYCoordinate + theY] == null) {

      // System.out.println("error not in bound x");
      return false;
    } else {
      return true;
    }
  }

  public String getCurrentXYString() {
    return myCurrentX + ", " + myCurrentY;
  }

  public boolean won() {
    if (myCurrentX == myFixedMaze.length - 2
        && myCurrentY == myFixedMaze[0].length - 2) {
      myCompleteStatus = true;
      return true;
    } else {
      myCompleteStatus = false;
      return false;
    }
  }

}
