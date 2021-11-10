package triviaMaze;

public class Room {

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
	   if(!myNorthDoor.getQuestion().answer() && !myEastDoor.getQuestion().answer() && !mySouthDoor.getQuestion().answer() &&  
			   !myWestDoor.getQuestion().answer()) {  
		   
		   myRoomBlocked = true;
		   
		   return true;
	   } else {  
		   myRoomBlocked = false;
		   return false; 
		  
	   }
		   
  }
 
 
	
}