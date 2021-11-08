package triviaMaze;

import java.util.ArrayList;

public class mazeContainer { 
	
	    private boolean myCompleteStatus;
	    private final int mySolutionXLocation =  5;
	    private final int mySolutionYLocation= 5;
	    public mazeContainer() { 
	    	
	    }
	
	
		ArrayList<ArrayList<Room>> myMaze = new ArrayList<ArrayList<Room>>(); 
		
		
		
		public void roomSetup() { 
			
			
			for(int i = 0; i< 6; i++) { 
				myMaze.add(new ArrayList<Room>()); 
                 for(int j =0; j<6; j++) {  
                	// Room t = temp.get(i).get(j);
                	// t = new Room();  
           // probably just have a set here
                	 myMaze.get(i).add(j,new Room()); 
                	 myMaze.get(i).get(j).getEast().getQuestion().setQuestionText("beans");
                	 
                	 
                	 
                 }
                // temp.get(0).get(0).getEast().getQuestion().answer();
                 
			}
			
			
			
		} 
		
		
		public ArrayList<ArrayList<Room>> getMaze() { 
			return myMaze;
		}
		
		
		public void startGame() { 
			
			boolean beans = true; 
			int x = 0; 
			int y = 0;
			while(beans) { 
				
				if(x== mySolutionXLocation && y == mySolutionYLocation) { 
					
				}
				
				
				
			}
		}
		
		
	
		
		
		
		
		
		
		
		
		
}
