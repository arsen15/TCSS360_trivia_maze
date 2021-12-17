package triviaMaze;

import java.io.Serializable;

public class Door implements Serializable { 
	
	
	private static final long serialVersionUID = -4273157348381729462L;
	// set to public for test cases for geter test cases
    boolean myDoorStatus= false;
    
    private boolean myBlockedStatus= false; 
    
    private boolean myQuestioningStatus = false;
    
    
    
    public Question myQuestion = new TFQuestion();
    
    private void openDoor() { 
    	 myDoorStatus = true;
    } 
    
      
    
    // set to public for test case
    public void closeDoor() { 
    	 myDoorStatus = false; 
    } 
    /*
    public boolean doorStatus() { 
    	if(myBlockedStatus == false) { 
    		return myDoorStatus; 
    	} 
    	else { 
    		return myBlockedStatus;
    	}
    	
    	
    }  */
      
    public void checkQuestion() { 
    	if( myQuestion.answer() == true) { 
    		openDoor();
    	} else { 
    		setBlockedStatus();
    	}
    } 
    
    
    public boolean checkDoor() {  
    	if(myDoorStatus && !myBlockedStatus) { 
    		return true;
    	} else { 
    		return false;
    	}
    //	return myDoorStatus;
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
    
    // questioning status for if the  door is in the process of being answered
    public void setQuestioningStatus(final boolean theQuestioningStatus) { 
    	myQuestioningStatus=theQuestioningStatus;
    }
    
    public void setQuestion(Question thePassedQuestion) { 
    	myQuestion = thePassedQuestion;
    }
    
}
