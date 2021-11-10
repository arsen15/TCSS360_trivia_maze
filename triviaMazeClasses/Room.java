/**
 * The Room class for Trivia Maze.
 */

/**
 * @author Phuc, Arsen, Ryan
 * TCSS 350 A
 *
 */
public class Room {
	private static final boolean inRoom = false;
	public int xPosition;
	public int yPosition;
	
	/**
	 * Constructor that creates the room.
	 * @param theX the X coordinate position.
	 * @param theYthe X coordinate position.
	 */
	public Room(int theX, int theY) {
		xPosition = theX;
		yPosition = theY;
	}
	
	/**
	 * Return the X position.
	 * @return the x coordinate.
	 */
	public int getXPosition() {
		return xPosition;
	}
	
	/**
	 * Return the Y position.
	 * @return the y coordinate
	 */
	public int getYPosition() {
		return yPosition;
	}
	
	/**
	 * Set the state of the room.
	 * @param s
	 */
//	public void setStateRoom(visitedState s) {
//		roomState = s;
//	}
	
	/**
	 * This will help check if we are in the room.
	 * @return true if is in room and false if not.
	 */
	public boolean isInRoom() {
		return inRoom;
	}
	
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
