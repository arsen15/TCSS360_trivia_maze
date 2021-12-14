package triviaMaze;

import java.io.Serializable;

/**
 * 
 * @author Ryan. Arsen, Phuc
 *
 */
public class Room implements Serializable{

  /**
   * 
   */
  private static final long serialVersionUID = 9101079280627683610L;
  private static boolean myRoomBlocked;
  private Door myNorthDoor = new Door();
  private Door myEastDoor = new Door();
  private Door mySouthDoor = new Door();
  private Door myWestDoor = new Door();
  private boolean myRoomAccessed;

  public Door getNorth() throws IllegalArgumentException {
    if (myNorthDoor != null) {
      return myNorthDoor;
    } else {
      throw new IllegalArgumentException("We don't have a North Door.");
    }
  }

  public Door getEast() throws IllegalArgumentException {
    if (myEastDoor != null) {
      return myEastDoor;
    } else {
      throw new IllegalArgumentException("We don't have an East Door.");
    }
  }

  public Door getSouth() throws IllegalArgumentException {
    if (mySouthDoor != null) {
      return mySouthDoor;
    } else {
      throw new IllegalArgumentException("We don't have a South Door.");
    }
  }

  public Door getWest() throws IllegalArgumentException {
    if (myWestDoor != null) {
      return myWestDoor;
    } else {
      throw new IllegalArgumentException("We don't have a West Door.");
    }
  }

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

  public void setRoomState() {
    myRoomAccessed = true;
  }

  public boolean isRoomAccessed() {
    return myRoomAccessed;
  }

  /**
   * @return the myRoomBlocked
   */
  public static boolean isMyRoomBlocked() {
    return myRoomBlocked;
  }

  /**
   * @param myRoomBlocked
   *          the myRoomBlocked to set
   */
  public static void setMyRoomBlocked(boolean myRoomBlocked) {
    Room.myRoomBlocked = myRoomBlocked;
  }

}