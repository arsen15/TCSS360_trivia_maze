package triviaMaze;

/**
 * A JUnit Test Class that helps tests the methods in the Room class. 
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 * @author Ryan, Arsen, Phuc
 *
 */
class RoomTest {
  public Room myRoom = new Room();

  /**
   * Test if the method getNorth() return the correct door. Test method for
   * 
   */
  @Test
  void testGetNorth() {
    assertEquals(myRoom.getNorth(), myRoom.myNorthDoor);
  }

  /**
   * Test if the method getEast() return the correct door. Test method for
   * 
   */
  @Test
  void testGetEast() {
    assertEquals(myRoom.getEast(), myRoom.myEastDoor);
  }

  /**
   * Test if the method getSouth() return the correct door. Test method for
   * 
   */
  @Test
  void testGetSouth() {
    assertEquals(myRoom.getSouth(), myRoom.mySouthDoor);
  }

  /**
   * Test if the method getWest() return the correct door. Test method for
   * 
   */
  @Test
  void testGetWest() {
    assertEquals(myRoom.getWest(), myRoom.myWestDoor);
  }

  /**
   * Test if the method checkBlockedDoors() shows that the room is locked when
   * all 4 doors are closed. Test method for
   * 
   */
  @Test
  void testCheckBlockedDoors() {
    myRoom.myNorthDoor.setBlockedStatus();
    myRoom.mySouthDoor.setBlockedStatus();
    myRoom.myWestDoor.setBlockedStatus();
    myRoom.myEastDoor.setBlockedStatus();
    assertTrue(myRoom.checkBlockedDoors());
  }

  /**
   * Test if the method checkBlockedDoors() shows that the room is not locked.
   * Test method for {@link triviaMaze.Room#checkBlockedDoors()}.
   */
  @Test
  void testCheckBlockedDoorsFail() {
    assertFalse(myRoom.checkBlockedDoors());
  }

  /**
   * Test if the method checkBlockedDoors() shows that the North room is not
   * locked. Test method for {@link triviaMaze.Room#checkBlockedDoors()}.
   */
  @Test
  void testCheckBlockedDoorsNorth() {
    assertFalse(myRoom.myNorthDoor.getBlockedStatus());
  }

  /**
   * Test if the method checkBlockedDoors() shows that the South room is not
   * locked. Test method for {@link triviaMaze.Room#checkBlockedDoors()}.
   */
  @Test
  void testCheckBlockedDoorsSouth() {
    assertFalse(myRoom.mySouthDoor.getBlockedStatus());
  }

  /**
   * Test if the method checkBlockedDoors() shows that the East room is not
   * locked. Test method for {@link triviaMaze.Room#checkBlockedDoors()}.
   */
  @Test
  void testCheckBlockedDoorsEast() {
    assertFalse(myRoom.myEastDoor.getBlockedStatus());
  }

  /**
   * Test if the method checkBlockedDoors() shows that the West room is not
   * locked. Test method for {@link triviaMaze.Room#checkBlockedDoors()}.
   */
  @Test
  void testCheckBlockedDoorsWest() {
    assertFalse(myRoom.myWestDoor.getBlockedStatus());
  }
}