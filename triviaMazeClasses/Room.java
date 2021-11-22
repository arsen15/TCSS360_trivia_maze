/**
 * @author Phuc, Arsen, Ryan TCSS 350 A The Room class for Trivia Maze.
 */
public class Room {
  private static final boolean inRoom = false;
  private static boolean myRoomBlocked;
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
  public Room() {
  }

  /**
   * Check to see if the door is blocked or not.
   * 
   * @return True if blocked and False if not.
   */
  public boolean checkBlockedDoors() {
    if (!myNorthDoor.getQuestion().answer()
        && !myEastDoor.getQuestion().answer()
        && !mySouthDoor.getQuestion().answer()
        && !myWestDoor.getQuestion().answer()) {
      myRoomBlocked = true;
      return true;
    } else {
      myRoomBlocked = false;
      return false;
    }
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
   * 
   * @return the North Door.
   */
  public Door getNorth() {
    return myNorthDoor;
  }

  /**
   * The door in the East.
   * 
   * @return the East Door.
   */
  public Door getEast() {
    return myEastDoor;
  }

  /**
   * The door in the South.
   * 
   * @return the South Door.
   */
  public Door getSouth() {
    return mySouthDoor;
  }

  /**
   * The door in the West.
   * 
   * @return the West Door.
   */
  public Door getWest() {
    return myWestDoor;
  }
}