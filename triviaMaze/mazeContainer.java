package triviaMaze;

import java.util.ArrayList;
import java.util.Random;

public class mazeContainer { 
	
	    private boolean myCompleteStatus = false;
	    private  int myCurrentX =  1;
	    private  int myCurrentY= 1;  
	    private int myDoorDirection;
	    public mazeContainer() { 
	    	
	    }
	
	
		ArrayList<ArrayList<Room>> myMaze = new ArrayList<ArrayList<Room>>(); 
		Room[][] myFixedMaze = new Room[7][7];
		
		/*
		public void roomSetup() { 
			
			for(int i = 0; i< 6; i++) { 
				myMaze.add(new ArrayList<Room>()); 
                 for(int j =0; j<6; j++) {  
                	 myMaze.get(i).add(j,new Room()); 
                	 myMaze.get(i).get(j).getEast().getQuestion().setQuestionText("beans");
                	 
                	 
                	 
                 }
             
                 
			}
			
			
			
		} */
		 
		
		
		public void fixedArraySetup() { 
			
			for(int i = 1; i<6; i++) { 
				for(int j =1; j<6; j++) { 
					myFixedMaze[i][j] = new Room(); 
					
					
					
					
				}
			}
		}  
		 
	   public Room getCurrentRoom() { 
		  return myFixedMaze[myCurrentX][myCurrentY];
	   }
	    	
	   public Door getCurrentDoorEast() { 
		   return myFixedMaze[myCurrentX][myCurrentY].getEast();
	   } 
	   public Door getCurrentDoorNorth() { 
		   return myFixedMaze[myCurrentX][myCurrentY].getNorth();
	   } 
	   public Door getCurrentDoorSouth() { 
		   return myFixedMaze[myCurrentX][myCurrentY].getSouth();
	   } 
	   public Door getCurrentDoorWest() { 
		   return myFixedMaze[myCurrentX][myCurrentY].getWest();
	   }   
	   public void setDoorDirection(final int theDirection) { 
		   myDoorDirection= theDirection;
	   }
	   public Door getCurrentDoorFace() { 
		   if(myDoorDirection == 0) { 
			   return getCurrentDoorWest();
		   } else if(myDoorDirection == 1) { 
			   return getCurrentDoorNorth();
		   } else if(myDoorDirection == 2) { 
			   return getCurrentDoorEast();
		   } else if(myDoorDirection == 3) { 
			   return getCurrentDoorSouth();
		   } else { 
			   return null;
		   }
	   }
		
		//blocks of checking directions
		public void checkEast() {  
			checkInBoundX(1); 
			myFixedMaze[myCurrentX][myCurrentY].getEast().checkQuestion();
			if(myFixedMaze[myCurrentX][myCurrentY].getEast().checkDoor()) { 
				myCurrentX++;
			}
		} 
	public void checkWest() {  
		checkInBoundX(-1); 
			if(myFixedMaze[myCurrentX][myCurrentY].getWest().getQuestion().answer()) { 
				myCurrentX--;
			}
		} 
	public boolean moveNorth() { 
		if(checkInBoundY(-1) == false) { 
	     return false;
		}
		myFixedMaze[myCurrentX][myCurrentY].getNorth().checkQuestion();
		if(myFixedMaze[myCurrentX][myCurrentY].getNorth().checkDoor()) { 
			myCurrentY++; 
		
		} 
		return true;
	} 
	public void checkSouth() { 
		checkInBoundY(1); 
		myFixedMaze[myCurrentX][myCurrentY].getSouth().checkQuestion();
		if(myFixedMaze[myCurrentX][myCurrentY].getSouth().checkDoor()) { 
			myCurrentY--;
		}
	}   
	
	public void moveEast() { 
		if(checkInBoundX(1)== false) {  
			System.out.println("move east error");
			return;
		} else { 
		myFixedMaze[myCurrentX][myCurrentY].getEast().checkQuestion();
		if(myFixedMaze[myCurrentX][myCurrentY].getEast().checkDoor()) { 
			myCurrentX++;
		} 
	  }
	} 
	public void moveSouth() { 
		if(checkInBoundY(1)== false) {  
			System.out.println("move east error");
			return;
		} else { 
		myFixedMaze[myCurrentX][myCurrentY].getSouth().checkQuestion();
		if(myFixedMaze[myCurrentX][myCurrentY].getSouth().checkDoor()) { 
			myCurrentY++;
		} 
	  }
	} 
	public void moveWest() { 
		if(checkInBoundX(-1)== false) {  
			System.out.println("move east error");
			return;
		} else { 
		myFixedMaze[myCurrentX][myCurrentY].getWest().checkQuestion();
		if(myFixedMaze[myCurrentX][myCurrentY].getWest().checkDoor()) { 
			myCurrentY++;
		} 
	  }
	}
		
		
	    public boolean checkInBoundX(int theX) { 
	    	if(myFixedMaze[myCurrentX+theX][myCurrentY] == null ) {  
	    		
				System.out.println("error not in  bound x"); 
				return false;
			} else { 
				return true;
			}
	    } 
	    public boolean checkInBoundY(int theY) { 
           if(myFixedMaze[myCurrentX][myCurrentY+theY] == null ) {  
	    		
				System.out.println("error not in bound y "); 
				return false;
			} else { 
				return true;
			}
	    } 
	    
	    public boolean checkInBoundDirection(int theDirection) { 
	    	if(theDirection == 3 ) { 
	    		return checkInBoundY(1);
	    	} else if(theDirection ==2 ) { 
	    		return checkInBoundX(1); 
	    	} else if(theDirection == 1) { 
	    		return  checkInBoundY(-1);
	    	} else if(theDirection == 0) { 
	    		return checkInBoundX(-1);
	    	} else {  
	    		System.out.println("invalid direction");
	    		return false;
	    	}
	    } 
	    
	    public void moveFaceDirection() { 
	    	if(myDoorDirection ==3) { 
	    		moveSouth();
	    	} else if(myDoorDirection ==2) { 
	    		moveEast();
	    	} else if(myDoorDirection ==1) { 
	    		moveNorth();
	    	} else if(myDoorDirection ==0) { 
	    		moveWest();
	    	}
	    }
		
		
		
		public ArrayList<ArrayList<Room>> getMaze() { 
			return myMaze;
		}  
		public Room[][] getFixedMaze() { 
			return myFixedMaze;
		} 
		
		public void setDoors(final ArrayList<Question> theDoorSelection) { 
			Random rand = new Random();
			
			for(int i =1; i< 6; i++) { 
				for(int j=1; j<6; j++) {  
					int roll = rand.nextInt(theDoorSelection.size()); 
					
					
			        if(checkInBoundX(-1) == false) {  
			        
			        	myFixedMaze[i][j].getWest().setBlockedStatus();  
			        }  
			        
			        if(checkInBoundY(1) == false) { 
			        	myFixedMaze[i][j].getSouth().setBlockedStatus(); 
			        } 
			        
			        if(checkInBoundX(1) == false) { 
			        	myFixedMaze[i][j].getEast().setBlockedStatus();
			        } 
			        if(checkInBoundY(-1) == false ) { 
			        	myFixedMaze[i][j].getNorth().setBlockedStatus();
			        } 
			        
			        
					myFixedMaze[i][j].getNorth().setQuestion(theDoorSelection.get(roll));   
					myFixedMaze[i][j].getEast().setQuestion(theDoorSelection.get(roll));  
					myFixedMaze[i][j].getSouth().setQuestion(theDoorSelection.get(roll));  
					myFixedMaze[i][j].getWest().setQuestion(theDoorSelection.get(roll));  
			           
				
					
				}
			}
			
			
		}  
		
       		
		public String getCurrentXYString() { 
			return myCurrentX+", "+myCurrentY;
		}
		
		
		public boolean won() { 
			if(myCurrentX == myFixedMaze.length-2 && myCurrentY == myFixedMaze[0].length-2) {   
				myCompleteStatus = true;
				return true;
			} else {  
				myCompleteStatus = false;
				return false;
			}
		}
	    /*
		public static void main(String[] args) { 
			mazeContainer beans = new mazeContainer();  
			beans.fixedArraySetup(); 
			MultipleChoiceQuestion mc = new MultipleChoiceQuestion(); 
			mc.setMultipleChoiceOptionA("the dark soul"); 
		
			MultipleChoiceQuestion mc2 = new MultipleChoiceQuestion(); 
			mc2.setMultipleChoiceOptionA("the dark soul beans"); 
;  

			Random rand = new Random(); 
			
			ArrayList<Question> testing = new ArrayList<Question>(); 
			System.out.println(testing.size());
		
			
			ArrayList<Question> testArray = new ArrayList<Question>(); 
			testArray.add(mc); 
			testArray.add(mc2); 
			
			beans.setDoors(testArray); 
			System.out.println(beans.myFixedMaze[1][1].getEast().getQuestion().getMultipleChoiceOptionA());
			
		} */
		
		
		
		
		
		
		
		
}
