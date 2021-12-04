package triviaMaze;

/**
 * @author Ryan, Arsen, Phuc
 */
import java.util.ArrayList;
import java.util.Random;

public class mazeContainer {

  private boolean myCompleteStatus = false;
  private int myCurrentX = 1;
  private int myCurrentY = 1;
  private int myDoorDirection;
  ArrayList<ArrayList<Room>> myMaze = new ArrayList<ArrayList<Room>>();
  Room[][] myFixedMaze = new Room[7][7];

  public mazeContainer() {}

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

  
  
  
  // blocks of checking directions
  public void checkEast() {
    checkInBoundX(1);
    myFixedMaze[myCurrentX][myCurrentY].getEast().checkQuestion();
    if (myFixedMaze[myCurrentX][myCurrentY].getEast().checkDoor()) {
      myCurrentX++;
    }
  }
  public void checkWest() {
    checkInBoundX(-1);
    if (myFixedMaze[myCurrentX][myCurrentY].getWest().getQuestion().answer()) {
      myCurrentX--;
    }
  }
  public boolean moveNorth() {
    if (checkInBoundY(-1) == false) {
      return false;
    }
    myFixedMaze[myCurrentX][myCurrentY].getNorth().checkQuestion();
    if (myFixedMaze[myCurrentX][myCurrentY].getNorth().checkDoor()) {
      myCurrentY++;

    }
    return true;
  }
  public void checkSouth() {
    checkInBoundY(1);
    myFixedMaze[myCurrentX][myCurrentY].getSouth().checkQuestion();
    if (myFixedMaze[myCurrentX][myCurrentY].getSouth().checkDoor()) {
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
        myCurrentY++;
      }
    }
  }

  public boolean checkInBoundX(int theX) {
    if (myFixedMaze[myCurrentX + theX][myCurrentY] == null) {

      System.out.println("error not in  bound x");
      return false;
    } else {
      return true;
    }
  }
  
  public boolean checkInBoundY(int theY) {
    if (myFixedMaze[myCurrentX][myCurrentY + theY] == null) {

      System.out.println("error not in bound y ");
      return false;
    } else {
      return true;
    }
  }
  
  public int getCurrentX() {
    return myCurrentX;
  }
  
  public int getCurrentY() {
    return myCurrentY;
  }
 

  public boolean checkInBoundDirection(int theDirection) {
    
    int west = 0; 
    int north = 1; 
    int east = 2; 
    int south = 3;
    
    
    if(theDirection == south ) { 
      return checkInBoundY(1);
    } else if(theDirection ==east ) { 
      return checkInBoundX(1); 
    } else if(theDirection == north) { 
      return  checkInBoundY(-1);
    } else if(theDirection == west) { 
      return checkInBoundX(-1);
    } else {  
      System.out.println("invalid direction");
      return false;
    }
  } 
  
  public void blockAdjacent() {
    if (myDoorDirection == 0 && checkInBoundX(-1)) { 
      myFixedMaze[myCurrentX-1][myCurrentY].getEast().setBlockedStatus();
    } else if(myDoorDirection ==  1 && checkInBoundY(-1)) { 
      myFixedMaze[myCurrentX][myCurrentY-1].getSouth().setBlockedStatus();
    } else if(myDoorDirection ==2 && checkInBoundX(1)) { 
      myFixedMaze[myCurrentX+1][myCurrentY].getWest().setBlockedStatus();
    } else if(myDoorDirection == 3 && checkInBoundY(1)) { 
      myFixedMaze[myCurrentX][myCurrentY+1].getNorth().setBlockedStatus();
    }
  }
  

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

  public boolean checkInBoundXDoorSetup(final int theX, final int theXCoordinate, final int theYCoordinate) { 
    if(myFixedMaze[theXCoordinate+theX][theYCoordinate] == null ) {  
        
      //  System.out.println("error not in  bound x"); 
        return false;
      } else { 
        return true;
      }
  }  
  public boolean checkInBoundYDoorSetup(final int theY, final int theXCoordinate, final int theYCoordinate) { 
    if(myFixedMaze[theXCoordinate][theYCoordinate+theY] == null ) {  
        
      //  System.out.println("error not in  bound x"); 
        return false;
      } else { 
        return true;
      }
  } 
  public ArrayList<ArrayList<Room>> getMaze() {
    return myMaze;
  }
  public Room[][] getFixedMaze() {
    return myFixedMaze;
  }

  public void setDoors(final ArrayList<Question> theDoorSelection) {
    Random rand = new Random();
    int westCount = 0; 
    int eastCount = 0;  
    int northCount = 0;
    for(int i =1; i< 6; i++) { 
      for(int j=1; j<6; j++) {  
        int roll = rand.nextInt(theDoorSelection.size()); 
        
        
            if(checkInBoundXDoorSetup(-1,i,j) == false) {  
            
              myFixedMaze[i][j].getWest().setBlockedStatus();   
                
            }  
            
            if(checkInBoundYDoorSetup(1,i,j) == false) { 
              myFixedMaze[i][j].getSouth().setBlockedStatus();  
              
            } 
            
            if(checkInBoundXDoorSetup(1,i,j) == false) { 
              myFixedMaze[i][j].getEast().setBlockedStatus();
            } 
            if(checkInBoundYDoorSetup(-1,i,j) == false) { 
              myFixedMaze[i][j].getNorth().setBlockedStatus(); 
           
            } 
            
            
        myFixedMaze[i][j].getNorth().setQuestion(theDoorSelection.get(roll));   
        myFixedMaze[i][j].getEast().setQuestion(theDoorSelection.get(roll));  
        myFixedMaze[i][j].getSouth().setQuestion(theDoorSelection.get(roll));  
        myFixedMaze[i][j].getWest().setQuestion(theDoorSelection.get(roll));  

      }
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