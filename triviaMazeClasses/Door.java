/**
 * 
 */

/**
 * @author Phuc Luu
 *
 */
public class Door {
	private Room roomOne;
	private Room roomTwo;
	private boolean open = false;
	
	/**
	 * Constructor that helps create connection to Room class.
	 * @param firstRoom
	 * @param secondRoom
	 */
	public Door(Room firstRoom, Room secondRoom) {
		firstRoom = roomOne;
		secondRoom = roomTwo;	
	}
	
	/**
	 * Check if the door is opened.
	 * @return true if it's opened and false if not.
	 */
	public boolean isOpen() {
		return open ;
	}
	
	/**
	 * Manually opens the room.
	 * @param openIt
	 */
	public void openRoom(boolean openIt) {
		openIt = open;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
