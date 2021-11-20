
import java.util.ArrayList;
import java.util.Random;

public class mazeContainer { 
  
      private boolean myCompleteStatus = false;
      private  int myCurrentX =  0;
      private  int myCurrentY= 0; 
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
    if(checkInBoundY(1) == false) { 
       return false;
    }
    myFixedMaze[myCurrentX][myCurrentY].getNorth().checkQuestion();
    if(myFixedMaze[myCurrentX][myCurrentY].getNorth().checkDoor()) { 
      myCurrentY++; 
    
    } 
    return true;
  } 
  public void checkSouth() { 
    checkInBoundY(-1); 
    myFixedMaze[myCurrentX][myCurrentY].getSouth().checkQuestion();
    if(myFixedMaze[myCurrentX][myCurrentY].getSouth().checkDoor()) { 
      myCurrentY--;
    }
  }
    
    
      public boolean checkInBoundX(int theX) { 
        if(myFixedMaze[myCurrentX+theX][myCurrentY] == null ) {  
          
        System.out.println("error"); 
        return false;
      } else { 
        return true;
      }
      } 
      public boolean checkInBoundY(int theY) { 
           if(myFixedMaze[myCurrentX][myCurrentY+theY] == null ) {  
          
        System.out.println("error"); 
        return false;
      } else { 
        return true;
      }
      }
    
    
    
    public ArrayList<ArrayList<Room>> getMaze() { 
      return myMaze;
    }  
    public Room[][] getFixedMaze() { 
      return myFixedMaze;
    } 
    
    public void setDoors(ArrayList<Question> theDoorSelection) { 
      Random rand = new Random();
      
      for(int i =1; i< 6; i++) { 
        for(int j=1; j<6; j++) {  
          
          
      
          
          myFixedMaze[i][j].getNorth().setQuestion(theDoorSelection.get(rand.nextInt(theDoorSelection.size())));   
          myFixedMaze[i][j].getEast().setQuestion(theDoorSelection.get(rand.nextInt(theDoorSelection.size())));  
          myFixedMaze[i][j].getSouth().setQuestion(theDoorSelection.get(rand.nextInt(theDoorSelection.size())));  
          myFixedMaze[i][j].getWest().setQuestion(theDoorSelection.get(rand.nextInt(theDoorSelection.size())));  
          
        
          
        }
      }
      
      
    }
    
    
    public boolean won() { 
      if(myCurrentX == myFixedMaze.length && myCurrentY == myFixedMaze[0].length) {   
        myCompleteStatus = true;
        return true;
      } else {  
        myCompleteStatus = false;
        return false;
      }
    }
  
    public static void main(String[] args) { 
      mazeContainer beans = new mazeContainer();  
      beans.fixedArraySetup(); 
      MultipleChoiceQuestion mc = new MultipleChoiceQuestion(); 
      mc.setMultipleChoiceOptionA("the dark soul"); 
    
      MultipleChoiceQuestion mc2 = new MultipleChoiceQuestion(); 
      mc2.setMultipleChoiceOptionA("the dark soul beans"); 
; 
      
      ArrayList<Question> testArray = new ArrayList<Question>(); 
      testArray.add(mc); 
      testArray.add(mc2);
      beans.setDoors(testArray); 
      System.out.println(beans.myFixedMaze[1][1].getEast().getQuestion().getMultipleChoiceOptionA());
      
    }
    
    
    
    
    
    
    
    
}
