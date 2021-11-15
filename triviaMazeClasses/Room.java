/**
 * @author Phuc, Arsen, Ryan TCSS 350 A
 * The Room class for Trivia Maze.
 */
public class Room {
  private static final boolean inRoom = false;
  private int xPosition;
  private int yPosition;
  private Door myNorthDoor = new Door();
  private Door myEastDoor = new Door();
  private Door mySouthDoor = new Door();
  private Door myWestDoor = new Door();

  /**
   * Constructor that creates the room.
   * 
   * @param theX
   *          the X coordinate position.
   * @param theYthe
   *          X coordinate position.
   */
  public Room(int theX, int theY) {
    xPosition = theX;
    yPosition = theY;
  }

  /**
   * Return the X position.
   * 
   * @return the x coordinate.
   */
  public int getXPosition() {
    return xPosition;
  }

  /**
   * Return the Y position.
   * 
   * @return the y coordinate
   */
  public int getYPosition() {
    return yPosition;
  }

  /**
   * This will help check if we are in the room.
   * 
   * @return true if is in room and false if not.
   */
  public boolean isInRoom() {
    return inRoom;
  }
  
  /**
   * The door in the North.
   * @return the North Door.
   */
  public Door getNorth() {
    return myNorthDoor;
  }

  /**
   * The door in the East.
   * @return the East Door.
   */
  public Door getEast() {
    return myEastDoor;
  }
  
  /**
   * The door in the South.
   * @return the South Door.
   */
  public Door getSouth() {
    return mySouthDoor;
  }
  
  /**
   * The door in the West.
   * @return the West Door.
   */
  public Door getWest() {
    return myWestDoor;
  }
}