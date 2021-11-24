package triviaMaze;

public class Door {
    private boolean myDoorStatus= false;
    
    private boolean myBlockedStatus= false; 
    
    
    
    
    
    private Question myQuestion = new TFQuestion();
    
    private void openDoor() { 
    	 myDoorStatus = true;
    } 
    
    
    private void closeDoor() { 
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
    	return myDoorStatus;
    } 
    
    public boolean getBlockedStatus() { 
    	return myBlockedStatus;
    }
    
    private void setBlockedStatus() { 
    	myBlockedStatus = true; 
    	closeDoor();
    } 
    
    public Question getQuestion() { 
    	return myQuestion;
    }
    
    public void setQuestion(Question thePassedQuestion) { 
    	myQuestion = thePassedQuestion;
    }
    
}