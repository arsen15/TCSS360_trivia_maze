/**
 * The Door class that helps run the maze.
 * 
 * @author Phuc, Arsen, Ryan
 *
 */
public class Door {
  /**
   * Instance fields for Door class.
   */
  private boolean myDoorStatus = false;
  private boolean open = false;
  private Question myQuestion = new TFQuestion();
  private boolean myBlockedStatus = false;

  /**
   * Initialize the Door class.
   */
  public Door() {}
  
  /**
   * Check if the door is opened.
   * 
   * @return true if it's opened and false if not.
   */
  public boolean isOpen() {
    return open;
  }

  /**
   * Manually opens the door.
   */
  public void openDoor() {
    setMyDoorStatus(true);
  }

  /**
   * Manually closes the door.
   */
  public void closeDoor() {
    setMyDoorStatus(false);
  }


  /**
   * Check to questions.
   */
  public void checkQuestion() {
    if (myQuestion.answer() == true) {
      openDoor();
    } else {
      setBlockedStatus();
    }
  }

  /**
   * Set the status of the door.
   */
  public void setBlockedStatus() {
    setMyBlockedStatus(true);
  }

  /**
   * Return the question.
   * 
   * @return the question.
   */
  public Question getQuestion() {
    return myQuestion;
  }

  /**
   * Set the questions.
   * 
   * @param thePassedQuestion questions that are being passed in.
   */
  public void setQuestion(Question thePassedQuestion) {
    myQuestion = thePassedQuestion;
  }

  /**
   * Check to see if door is open.
   * 
   * @return the myDoorStatus
   */
  public boolean isMyDoorStatus() {
    return myDoorStatus;
  }

  /**
   * Set the door status.
   * 
   * @param myDoorStatus
   *          the myDoorStatus to set
   */
  public void setMyDoorStatus(boolean myDoorStatus) {
    this.myDoorStatus = myDoorStatus;
  }

  /**
   * Check to see if it's blocked.
   * 
   * @return the myBlockedStatus
   */
  public boolean isMyBlockedStatus() {
    return myBlockedStatus;
  }

  /**
   * Set the blocked door status.
   * @param myBlockedStatus
   *          the myBlockedStatus to set
   */
  public void setMyBlockedStatus(boolean myBlockedStatus) {
    this.myBlockedStatus = myBlockedStatus;
  }
}
