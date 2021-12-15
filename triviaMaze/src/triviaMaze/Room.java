package triviaMaze;

import java.io.Serializable;

public class Room implements Serializable { 
	
	
	
	private static final long serialVersionUID = 9101079280627683610L;
	

	private static boolean myRoomBlocked; 
	
	
	
	
    private	Door myNorthDoor = new Door(); 
	private Door myEastDoor = new Door();
	private Door mySouthDoor = new Door();
	private Door myWestDoor = new Door();  
	
	
	
    public Door getNorth() { 
    	return myNorthDoor;
    }
	
 public Door getEast() { 
    	return myEastDoor; 
    } 
 public Door getSouth() { 
 	return mySouthDoor;
 } 
 public Door getWest() { 
 	return myWestDoor;
 } 
 
  public boolean checkBlockedDoors() { 
	   if(myNorthDoor.getBlockedStatus() && myEastDoor.getBlockedStatus() && mySouthDoor.getBlockedStatus() &&  
			   myWestDoor.getBlockedStatus()) {  
		   
		   myRoomBlocked = true;
		   
		   return true;
	   } else {  
		   myRoomBlocked = false;
		   return false; 
		  
	   }
		   
  }
 
 
	
}
