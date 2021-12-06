package triviaMaze;

public class Door {
  private boolean myDoorStatus = false;

  private boolean myBlockedStatus = false;

  private boolean myQuestioningStatus = false;

  private Question myQuestion = new TFQuestion();

  private void openDoor() {
    myDoorStatus = true;
  }

  private void closeDoor() {
    myDoorStatus = false;
  }

  public void checkQuestion() {
    if (myQuestion.answer() == true) {
      openDoor();
    } else {
      setBlockedStatus();
    }
  }

  public boolean checkDoor() {
    if (myDoorStatus && !myBlockedStatus) {
      return true;
    } else {
      return false;
    }
  }

  public boolean getBlockedStatus() {
    return myBlockedStatus;
  }

  public void setBlockedStatus() {
    myBlockedStatus = true;
    closeDoor();
  }

  public Question getQuestion() {
    return myQuestion;
  }

  public boolean getQuestioningStatus() {
    return myQuestioningStatus;
  }

  // questioning status for if the door is in the process of being answered
  public void setQuestioningStatus(final boolean theQuestioningStatus) {
    myQuestioningStatus = theQuestioningStatus;
  }

  public void setQuestion(Question thePassedQuestion) {
    myQuestion = thePassedQuestion;
  }

}