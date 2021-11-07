package triviaMaze;

public class Door {
    private boolean mydoorStatus; 
    
    private boolean myBlockedStatus; 
    
    private Question myQuestion = new TFQuestion("beans");
    
    public void openDoor() { 
    	mydoorStatus = true;
    } 
    
    
    public void closeDoor() { 
    	mydoorStatus = false; 
    } 
    
    public boolean doorStatus() { 
    	if(myBlockedStatus == false) { 
    		return mydoorStatus;
    	} else { 
    		return myBlockedStatus;
    	}
    	
    	
    } 
   
    public void setBlockedStatus() { 
    	myBlockedStatus = true;
    } 
    
    public Question getQuestion() { 
    	return myQuestion;
    }
    
    
    
}
