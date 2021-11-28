/**
 * Ryan, Arsen, Phuc
 */
import java.util.ArrayList;
import java.util.Random;

public class mazeContainer {
  private boolean myCompleteStatus = false;
  private int myCurrentX = 1;
  private int myCurrentY = 1;
  ArrayList<ArrayList<Room>> myMaze = new ArrayList<ArrayList<Room>>();
  Room[][] myFixedMaze = new Room[7][7];

  /**
   * Default constructor.
   */
  public mazeContainer() {
  }

  /*
   * public void roomSetup() {
   * 
   * for(int i = 0; i< 6; i++) { myMaze.add(new ArrayList<Room>()); for(int j
   * =0; j<6; j++) { myMaze.get(i).add(j,new Room());
   * myMaze.get(i).get(j).getEast().getQuestion().setQuestionText("beans") } } }
   */

  /**
   * Changed the array size so it fits.
   */
  public void fixedArraySetup() {
    for (int i = 1; i < 6; i++) {
      for (int j = 1; j < 6; j++) {
        myFixedMaze[i][j] = new Room();
      }
    }
  }

  /**
   * Return the current room.
   * 
   * @return the current room.
   */
  public Room getCurrentRoom() {
    return myFixedMaze[myCurrentX][myCurrentY];
  }

  /**
   * Return the current door in the East.
   * 
   * @return the East Door.
   */
  public Door getCurrentDoorEast() {
    return myFixedMaze[myCurrentX][myCurrentY].getEast();
  }

  /**
   * Return the current door in the North.
   * 
   * @return the North Door.
   */
  public Door getCurrentDoorNorth() {
    return myFixedMaze[myCurrentX][myCurrentY].getNorth();
  }

  /**
   * Return the current door in the South.
   * 
   * @return the South Door.
   */
  public Door getCurrentDoorSouth() {
    return myFixedMaze[myCurrentX][myCurrentY].getSouth();
  }

  /**
   * Return the current door in the West.
   * 
   * @return the West Door.
   */
  public Door getCurrentDoorWest() {
    return myFixedMaze[myCurrentX][myCurrentY].getWest();
  }

  /**
   * Check if we are in the East direction.
   */
  // blocks of checking directions
  public void checkEast() {
    checkInBoundX(1);
    myFixedMaze[myCurrentX][myCurrentY].getEast().checkQuestion();
    if (myFixedMaze[myCurrentX][myCurrentY].getEast().checkDoor()) {
      myCurrentX++;
    }
  }

  /**
   * Check if we are in the West direction.
   */
  public void checkWest() {
    checkInBoundX(-1);
    if (myFixedMaze[myCurrentX][myCurrentY].getWest().getQuestion().answer()) {
      myCurrentX--;
    }
  }
  /**
   * Move to the North.
   * 
   * @return true or false if we are moving to the North.
   */
  public boolean moveNorth() {
    if (checkInBoundY(1) == false) {
      return false;
    }
    myFixedMaze[myCurrentX][myCurrentY].getNorth().checkQuestion();
    if (myFixedMaze[myCurrentX][myCurrentY].getNorth().checkDoor()) {
      myCurrentY++;

    }
    return true;
  }

  /**
   * Check if we are in the South direction.
   */
  public void checkSouth() {
    checkInBoundY(-1);
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
  /**
   * Check if we are inside the X bound.
   * 
   * @param theX
   *          current position at x coordinate.
   * @return True or False if we are inside X bound.
   */
  public boolean checkInBoundX(int theX) {
    if (myFixedMaze[myCurrentX + theX][myCurrentY] == null) {

      System.out.println("error");
      return false;
    } else {
      return true;
    }
  }
  /**
   * Check if we are inside the Y bound.
   * 
   * @param theY
   *          current position at Y coordinate.
   * @return True or False if we are inside Y bound.
   */
  public boolean checkInBoundY(int theY) {
    if (myFixedMaze[myCurrentX][myCurrentY + theY] == null) {

      System.out.println("error");
      return false;
    } else {
      return true;
    }
  }

  /**
   * Return the ArrayList of the Maze.
   * 
   * @return the ArrayList.
   */
  public ArrayList<ArrayList<Room>> getMaze() {
    return myMaze;
  }

  /**
   * Return the correct size of the Maze.
   * 
   * @return the double array of maze.
   */
  public Room[][] getFixedMaze() {
    return myFixedMaze;
  }

  /**
   * Set the question for the doors.
   * 
   * @param theDoorSelection
   *          the door direction (North, South, West, East).
   */
  public void setDoors(ArrayList<Question> theDoorSelection) {
    Random rand = new Random();

    for (int i = 1; i < 6; i++) {
      for (int j = 1; j < 6; j++) {

        int roll = rand.nextInt(theDoorSelection.size());
        if (roll <= 0) {
          System.out.println("shouldn't do that"); // this doesn't help anything
                                                   // as it can be 0 and valid
        } else {

          myFixedMaze[i][j].getNorth().setQuestion(theDoorSelection.get(roll));
          myFixedMaze[i][j].getEast().setQuestion(theDoorSelection.get(roll));
          myFixedMaze[i][j].getSouth().setQuestion(theDoorSelection.get(roll));
          myFixedMaze[i][j].getWest().setQuestion(theDoorSelection.get(roll));
        }

      }
    }

  }

  /**
   * If we won then True, lose then false.
   * 
   * @return True or False.
   */
  public boolean won() {
    if (myCurrentX == myFixedMaze.length
        && myCurrentY == myFixedMaze[0].length) {
      myCompleteStatus = true;
      return true;
    } else {
      myCompleteStatus = false;
      return false;
    }
  }

  /**
   * Main program to run the maze.
   * 
   * @param args
   */
  public static void main(String[] args) {
    mazeContainer beans = new mazeContainer();
    beans.fixedArraySetup();
    MultipleChoiceQuestion mc = new MultipleChoiceQuestion();
    mc.setMultipleChoiceOptionA("the dark soul");

    MultipleChoiceQuestion mc2 = new MultipleChoiceQuestion();
    mc2.setMultipleChoiceOptionA("the dark soul beans");;

    Random rand = new Random();
    // int nerd = rand.nextInt(0);
    ArrayList<Question> testing = new ArrayList<Question>();
    System.out.println(testing.size());
    // System.out.println(nerd);

    ArrayList<Question> testArray = new ArrayList<Question>();
    testArray.add(mc);
    testArray.add(mc2);

    beans.setDoors(testArray);
    System.out.println(beans.myFixedMaze[1][1].getEast().getQuestion()
        .getMultipleChoiceOptionA());

  }
}