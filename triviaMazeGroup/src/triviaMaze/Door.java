/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import java.io.Serializable;

/**
 * This class creates the door of each room. The door brings up a question when player tries to enter a room.
 * This class checks the various conditions of the doors in the maze.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class Door implements Serializable { 
	
	private static final long serialVersionUID = -4273157348381729462L;
	
	/**
	 * Boolean value for open door status.
	 */
    boolean myDoorStatus= false;
    
    /**
     * Boolean value for blocked door status.
     */
    private boolean myBlockedStatus= false; 
    
    /**
     * Boolean value for question status.
     */
    private boolean myQuestioningStatus = false;
   
    /**
     * Boolean value for true/false questions.
     */
    Question myQuestion = new TFQuestion();
    
    /**
     * Method to hold the open door status.
     */
    private void openDoor() { 
    	 myDoorStatus = true;
    } 
    
    /**
     * Method to hold the closed open door status.
     */
    void closeDoor() { 
    	 myDoorStatus = false; 
    } 
    
    /**
     * Method that opens door if question answered correctly.
     */
    public void checkQuestion() { 
    	if( myQuestion.answer() == true) { 
    		openDoor();
    	} else { 
    		setBlockedStatus();
    	}
    } 
    
    /**
     * Method to check the status of a door.
     */
    public boolean checkDoor() {  
    	if(myDoorStatus && !myBlockedStatus) { 
    		return true;
    	} else { 
    		return false;
    	}
    } 
    
    /**
     * Getter method for blocked door status.
     */
    public boolean getBlockedStatus() { 
    	return myBlockedStatus;
    }
    
    /**
     * Setter method for blocked door status.
     */
    public void setBlockedStatus() { 
    	myBlockedStatus = true; 
    	closeDoor();
    } 
    
    /**
     * Getter method for question.
     */
    public Question getQuestion() { 
    	return myQuestion;
    } 
    
    /**
     * Getter method for question status.
     */
    public boolean getQuestioningStatus() { 
    	return myQuestioningStatus;  
    }  
    
    /**
     * Questioning status for if the  door is in the process of being answered
     * @param theQuestioningStatus is the status of the question.
     */
    public void setQuestioningStatus(final boolean theQuestioningStatus) { 
    	myQuestioningStatus=theQuestioningStatus;
    }
    
    /**
     * The setter for the question status.
     * @param thePassedQuestion when question is passed.
     */
    public void setQuestion(Question thePassedQuestion) { 
    	myQuestion = thePassedQuestion;
    }
    
}
