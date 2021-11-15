/**
 * The Door class that helps run the maze.
 */

/**
 * @author Phuc, Arsen, Ryan
 *
 */
public class Door {
//	private Room roomOne;
//	private Room roomTwo;
	private boolean myDoorStatus = false;
	private boolean open = false;
	private Question myQuestion = new TFQuestion();
	private boolean myBlockedStatus = false;
	
//	/**
//	 * Constructor that helps create connection to Room class.
//	 * @param firstRoom
//	 * @param secondRoom
//	 */
//	public Door(Room firstRoom, Room secondRoom) {
//		firstRoom = roomOne;
//		secondRoom = roomTwo;	
//	}
	
	/**
	 * Check if the door is opened.
	 * @return true if it's opened and false if not.
	 */
	public boolean isOpen() {
		return open;
	}
	
	/**
	 * Manually opens the door.
	 * @param openIt
	 */
	public void openDoor() {
		myDoorStatus = true;
	}
	
	/**
	 * Manually closes the door.
	 * @param openIt
	 */
	public void closeDoor() {
		myDoorStatus = false;
	}
	
    public void checkQuestion() { 
    	if( myQuestion.answer() == true) { 
    		openDoor();
    	} else { 
    		setBlockedStatus();
    	}
    }
    
    public void setBlockedStatus() { 
    	myBlockedStatus = true;
    } 
    
    public Question getQuestion() { 
    	return myQuestion;
    }
    
    public void setQuestion(Question thePassedQuestion) { 
    	myQuestion = thePassedQuestion;
    }
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub	
	}
}
