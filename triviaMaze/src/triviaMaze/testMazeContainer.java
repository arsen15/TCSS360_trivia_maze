package triviaMaze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class testMazeContainer {

	
	
	
	  private static final int WEST = 0;
	  private static final int NORTH = 1; 
	  private static final int EAST =2; 
	  private static final int SOUTH = 3;
	 
	  
	  
	  
	
	@Test
	void testFixedArraySetup() {
		MazeContainer mz = new MazeContainer(); 
		
		mz.fixedArraySetup(); 
		
	   Room[][] maze = mz.getFixedMaze(); 
	   
		assertEquals(7,maze.length, "asserts the height is equal"); 
		assertEquals(7,maze[0].length, "asserts length is equal");
		
		
	} 
	
	 @Test
	  void testGetCurrentRoom() {
	    MazeContainer mz = new MazeContainer();
	    mz.fixedArraySetup();
	    TriviaSQL sq = new TriviaSQL();
	    mz.setDoors(sq.setup());
	    assertEquals(mz.myFixedMaze[1][1], mz.getCurrentRoom());
	  }

	
	
	@Test
	void testGetCurrrentDoorFace() { 
		MazeContainer mz = new MazeContainer();    
		mz.fixedArraySetup();
		TriviaSQL sq = new TriviaSQL(); 
		mz.setDoors(sq.setup());
		
	 
		mz.setDoorDirection(EAST);
		Door doorEast = mz.getCurrentDoorFace();   
		assertEquals(mz.getCurrentDoorEast(),  doorEast, "checking east door face case"); 
		
		mz.setDoorDirection(SOUTH);
		Door doorSouth = mz.getCurrentDoorFace();
		assertEquals(mz.getCurrentDoorSouth(),  doorSouth, "checking east door face case");
		
		
		
	
		mz.setDoorDirection(WEST);
		Door doorWest = mz.getCurrentDoorFace();
		assertEquals(mz.getCurrentDoorWest(),  doorWest, "checking east door face case");
		
		

		mz.setDoorDirection(NORTH);
		Door doorNorth = mz.getCurrentDoorFace();
		assertEquals(mz.getCurrentDoorNorth(),  doorNorth, "checking east door face case"); 
		
		
		mz.setDoorDirection(5);
		Door doorNull = mz.getCurrentDoorFace();
		assertEquals(null,  doorNull, "checking east door face case");
		
	} 
	
	
	

	  @Test
	  void testGetCurrentDoorEast() {
	    MazeContainer mz = new MazeContainer();
	    mz.fixedArraySetup();
	    TriviaSQL sq = new TriviaSQL();
	    mz.setDoors(sq.setup());
	    mz.setDoorDirection(EAST);
	    assertEquals(mz.myFixedMaze[1][1].getEast(), mz.getCurrentDoorEast());
	  }

	  @Test
	  void testGetCurrentDoorNorth() {
		MazeContainer mz = new MazeContainer();
	    mz.fixedArraySetup();
	    TriviaSQL sq = new TriviaSQL();
	    mz.setDoors(sq.setup());
	    mz.setDoorDirection(NORTH);
	    assertEquals(mz.myFixedMaze[1][1].getNorth(), mz.getCurrentDoorNorth());
	  }

	  @Test
	  void testGetCurrentDoorSouth() {
		  MazeContainer mz = new MazeContainer();
	    mz.fixedArraySetup();
	    TriviaSQL sq = new TriviaSQL();
	    mz.setDoors(sq.setup());
	    mz.setDoorDirection(SOUTH);
	    assertEquals(mz.myFixedMaze[1][1].getSouth(), mz.getCurrentDoorSouth());
	  }

	  @Test
	  void testGetCurrentDoorWest() {
		  MazeContainer mz = new MazeContainer();
	    mz.fixedArraySetup();
	    TriviaSQL sq = new TriviaSQL();
	    mz.setDoors(sq.setup());
	    mz.setDoorDirection(WEST);
	    assertEquals(mz.myFixedMaze[1][1].getWest(), mz.getCurrentDoorWest());
	  } 
	  
	  @Test
	  void testSetDoorDirection() {
		  MazeContainer mz = new MazeContainer();
	    mz.fixedArraySetup();
	    TriviaSQL sq = new TriviaSQL();
	    mz.setDoors(sq.setup());
	    mz.setDoorDirection(NORTH);
	    assertEquals("north", mz.getCurrentDoorFaceString());
	  }
	
	@Test
	void getCurrentDoorFaceString() { 
		MazeContainer mz = new MazeContainer(); 
		mz.setDoorDirection(NORTH);
		assertEquals("north", mz.getCurrentDoorFaceString(), "north direction string check"); 
		mz.setDoorDirection(SOUTH);
		assertEquals("south", mz.getCurrentDoorFaceString(), "north direction string check");  
		mz.setDoorDirection(EAST);
		assertEquals("east", mz.getCurrentDoorFaceString(), "north direction string check"); 
		mz.setDoorDirection(WEST);
		assertEquals("west", mz.getCurrentDoorFaceString(), "north direction string check");  
		mz.setDoorDirection(5);
		assertEquals("nowhere", mz.getCurrentDoorFaceString(), "north direction string check"); 
		
	} 
	
	@Test
	void testMoveNorth() { 
		MazeContainer mz = new MazeContainer(); 
		
		 mz.fixedArraySetup();
		 TriviaSQL sq = new TriviaSQL();
		    mz.setDoors(sq.setup()); 
		    mz.myCurrentX = 2; 
		    mz.myCurrentY =2; 
		    Question q = mz.getCurrentDoorNorth().getQuestion(); 
		     q.setAnswer('a'); 
		     q.checkQuestion('a'); 
		     
		    mz.moveNorth();   
		    
		    assertEquals(1,mz.myCurrentY);
		
	}  
	
	@Test
	void testMoveEast() { 
		MazeContainer mz = new MazeContainer(); 
		
		 mz.fixedArraySetup();
		 TriviaSQL sq = new TriviaSQL();
		    mz.setDoors(sq.setup()); 
		    mz.myCurrentX = 2; 
		    mz.myCurrentY =2; 
		    Question q = mz.getCurrentDoorEast().getQuestion(); 
		     q.setAnswer('a'); 
		     q.checkQuestion('a'); 
		     
		    mz.moveEast();   
		    
		    assertEquals(3,mz.myCurrentX); 
		    
		    
		    
		    mz.myCurrentX = 5; 
		    mz.myCurrentY =3; 
		    
		    mz.moveEast(); 
		    assertEquals(5,mz.myCurrentX);
		     
		
	}  
	@Test
	void testMoveSouth() { 
		MazeContainer mz = new MazeContainer(); 
		
		 mz.fixedArraySetup();
		 TriviaSQL sq = new TriviaSQL();
		    mz.setDoors(sq.setup()); 
		    mz.myCurrentX = 2; 
		    mz.myCurrentY =2; 
		    Question q = mz.getCurrentDoorSouth().getQuestion(); 
		     q.setAnswer('a'); 
		     q.checkQuestion('a'); 
		     
		    mz.moveSouth();   
		    
		    assertEquals(3,mz.myCurrentY); 
		    
		    mz.myCurrentX = 2; 
		    mz.myCurrentY =5; 
		    
		    mz.moveSouth(); 
		    assertEquals(5,mz.myCurrentY);
		     
		    
		    
		
	}  
	
	@Test
	void testMoveWest() { 
		MazeContainer mz = new MazeContainer(); 
		
		 	mz.fixedArraySetup();
		 	TriviaSQL sq = new TriviaSQL();
		    mz.setDoors(sq.setup()); 
		    mz.myCurrentX = 2; 
		    mz.myCurrentY =2; 
		    Question q = mz.getCurrentDoorWest().getQuestion(); 
		     q.setAnswer('a'); 
		     q.checkQuestion('a'); 
		     
		    mz.moveWest();   
		    
		    assertEquals(1,mz.myCurrentX);
		
	} 
	
	@Test
	void testCheckInBoundX() { 
		MazeContainer mz = new MazeContainer();    
		mz.fixedArraySetup();
		TriviaSQL sq = new TriviaSQL(); 
		mz.setDoors(sq.setup());
		
		
		
		assertEquals(false,mz.checkInBoundX(-1),"checks West "); 
		assertEquals(true, mz.checkInBoundX(1),"check East");
		
		
		
		
	} 
	
	@Test
	void testCheckInBoundY() {  
		

	MazeContainer mz = new MazeContainer();    
	mz.fixedArraySetup();
	TriviaSQL sq = new TriviaSQL(); 
	mz.setDoors(sq.setup());
		
		assertEquals(false,mz.checkInBoundY(-1),"checks North "); 
		assertEquals(true, mz.checkInBoundY(1),"check south");
		
		
	}
	
	
	
	
	
	 @Test
	  void testGetDoorDirection() {
		MazeContainer mz = new MazeContainer();
	    mz.fixedArraySetup();
	    TriviaSQL sq = new TriviaSQL();
	    mz.setDoors(sq.setup());
	    mz.setDoorDirection(NORTH);
	    assertEquals(NORTH, mz.getDoorDirection());
	  }
	
	
	
	
	
	
	
	
	
	
	
	
	@Test 
	void blockAdjacent() { 
		
		MazeContainer mz = new MazeContainer();    
		mz.fixedArraySetup();
		TriviaSQL sq = new TriviaSQL(); 
		mz.setDoors(sq.setup());  
		
		mz.setDoorDirection(NORTH);
		mz.blockAdjacent();  
		Room[][] tempMazeNorth = mz.myFixedMaze; 
		Room tempRoomNorth = tempMazeNorth[0][1];
		assertEquals(null,tempRoomNorth);
		
		mz.setDoorDirection(WEST);
		mz.blockAdjacent();  
		Room[][] tempMazeWest = mz.myFixedMaze; 
		Room tempRoomWest = tempMazeWest[0][1];
		assertEquals(null,tempRoomWest);
		
		
		mz.setDoorDirection(EAST);   
		mz.blockAdjacent();
		Room[][] tempMaze = mz.myFixedMaze; 
		Room tempRoom = tempMaze[2][1];
	    assertEquals(true, tempRoom.getWest().getBlockedStatus()); 
	    
	    
	    mz.setDoorDirection(SOUTH);   
	    mz.blockAdjacent();
		Room[][] tempMaze2 = mz.myFixedMaze; 
		Room tempRoom2 = tempMaze2[1][2];
	    assertEquals(true, tempRoom2.getNorth().getBlockedStatus()); 
	    
	    
	    
	    
	    
	    mz.myCurrentX = 4; 
	    mz.myCurrentY = 4;  
	    Room tempRoom3= tempMaze2[3][4]; 
	    mz.setDoorDirection(WEST); 
	    mz.blockAdjacent();  
	    assertEquals(true, tempRoom3.getEast().getBlockedStatus());
	    
	    Room tempRoom4= tempMaze2[4][3]; 
	    mz.setDoorDirection(NORTH); 
	    mz.blockAdjacent();  
	    assertEquals(true, tempRoom4.getSouth().getBlockedStatus());
	    
	    
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@Test  
	void testCheckInBoundDirection() { 
		MazeContainer mz = new MazeContainer();    
		mz.fixedArraySetup();
		TriviaSQL sq = new TriviaSQL(); 
		mz.setDoors(sq.setup()); 
		
		
		assertEquals(true, mz.checkInBoundDirection(SOUTH));  
		assertEquals(true, mz.checkInBoundDirection(EAST));  
		assertEquals(false, mz.checkInBoundDirection(NORTH)); 
		assertEquals(false, mz.checkInBoundDirection(WEST)); 
		assertEquals(false, mz.checkInBoundDirection(5)); 
		
	}
	
	
	@Test  
	void moveFaceDirection() { 
		MazeContainer mz = new MazeContainer();    
		mz.fixedArraySetup();
		TriviaSQL sq = new TriviaSQL(); 
		mz.setDoors(sq.setup());  
		
		
		
		mz.setDoorDirection(NORTH);
		
		
		mz.moveFaceDirection();
		assertEquals(mz.getCurrentY(),1);  
		
        mz.setDoorDirection(WEST);
		
		
		mz.moveFaceDirection();
		assertEquals(mz.getCurrentX(),1); 
		
		
		
        mz.setDoorDirection(EAST);
		
		
		mz.moveFaceDirection();
		assertEquals(1,mz.getCurrentX(), "assertion EAst failed"); 
		
		
        mz.setDoorDirection(SOUTH);
		
		
		mz.moveFaceDirection();
		assertEquals(1,mz.getCurrentY(), " assertion SOUTH FAILED "); 
		
	}
	
	
	
	@Test 
	void testCheckinBoundXDoorSetup() { 
		MazeContainer mz = new MazeContainer();    
		mz.fixedArraySetup();
		TriviaSQL sq = new TriviaSQL(); 
		mz.setDoors(sq.setup()); 
		
	    assertEquals(false,mz.checkInBoundXDoorSetup(-1,1,1)); 
	    assertEquals(true,mz.checkInBoundXDoorSetup(1,1,1));
		
		
	   
	}
	 
	
	
	@Test 
	void testCheckinBoundYDoorSetup() { 
		MazeContainer mz = new MazeContainer();    
		mz.fixedArraySetup();
		TriviaSQL sq = new TriviaSQL(); 
		mz.setDoors(sq.setup()); 
		
	    assertEquals(false,mz.checkInBoundYDoorSetup(-1,1,1)); 
	    assertEquals(true,mz.checkInBoundYDoorSetup(1,1,1));
		
		
	   
	}
	 
	
	
	
	
	
	@Test
	void testGetCurrentXYString() { 
		MazeContainer mz = new MazeContainer();    
		mz.fixedArraySetup();
		TriviaSQL sq = new TriviaSQL(); 
		mz.setDoors(sq.setup());
	
		assertEquals(mz.myCurrentX+", "+mz.myCurrentY,mz.getCurrentXYString());
		
	}
	
	
	@Test 
	void testWon() { 
		 
		
		MazeContainer mz = new MazeContainer(); 
		mz.fixedArraySetup();  
		mz.myCurrentX =5; 
		mz.myCurrentY = 5; 
		
		assertEquals(true, mz.won()); 
		mz.myCurrentX =3; 
		assertEquals(false,mz.won());
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
