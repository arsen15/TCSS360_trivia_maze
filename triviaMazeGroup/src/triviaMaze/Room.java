/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import java.io.Serializable;

/**
 * This class creates the maze rooms and room logic.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class Room implements Serializable {

  private static final long serialVersionUID = 9101079280627683610L;

  /**
   * Boolean value to check if room is blocked.
   */
  private static boolean myRoomBlocked;

  /**
   * Represents north door.
   */
  Door myNorthDoor = new Door();
  
  /**
   * Represents east door.
   */
  Door myEastDoor = new Door();
  
  /**
   * Represents south door.
   */
  Door mySouthDoor = new Door();
  
  /**
   * Represents west door.
   */
  Door myWestDoor = new Door();

  /**
   * Getter for north door.
   */
  public Door getNorth() {
    return myNorthDoor;
  }

  /**
   * Getter for east door.
   */
  public Door getEast() {
    return myEastDoor;
  }
  
  /**
   * Getter for south door.
   */
  public Door getSouth() {
    return mySouthDoor;
  }
  
  /**
   * Getter for west door.
   */
  public Door getWest() {
    return myWestDoor;
  }

  /**
   * Checks if a certain door is blocked.
   * @return
   */
  public boolean checkBlockedDoors() {
    if (myNorthDoor.getBlockedStatus() && myEastDoor.getBlockedStatus()
        && mySouthDoor.getBlockedStatus() && myWestDoor.getBlockedStatus()) {

      myRoomBlocked = true;

      return true;
    } else {
      myRoomBlocked = false;
      return false;

    }

  }

}
