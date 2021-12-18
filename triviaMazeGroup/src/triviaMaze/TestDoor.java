package triviaMaze;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestDoor {

	@Test
	void testOpenDoor() { 
		
	} 
	@Test
	void testCloseDoor() {  
		
		Door d = new Door(); 
	    d.closeDoor();
		assertEquals(false,d.myDoorStatus, "door closes");
		
	}  
	
	@Test
	void testCheckQuestion() { 
		
		Door ifStatement = new Door();  
		Question q = new TFQuestion(); 
		q.setAnswer('a'); 
		q.checkQuestion('a');
		ifStatement.setQuestion(q);    
		ifStatement.checkQuestion();
	
		assertEquals(true, ifStatement.myDoorStatus, "if statement blocc opening door"); 
		
		Door elseStatement = new Door(); 
		Question q2 = new TFQuestion(); 
		q2.setAnswer('a'); 
		q2.checkQuestion('b');
		elseStatement.setQuestion(q2);   
		
		elseStatement.checkQuestion();
		
		assertEquals(false,elseStatement.myDoorStatus, "else statement");
		
		
	} 
	
	
	@Test 
	void testCheckDoor() {  
		
		Door d = new Door(); 
		
		assertEquals(false, d.checkDoor(), "else statement"); 
		
		d.myDoorStatus = true;
		assertEquals(true, d.checkDoor(), "if statement");
		
		
	}
	
	
	
	@Test
	void testGetBlockedStatus() {  
		
		Door d = new Door();
		
		assertEquals(false,d.getBlockedStatus(), "checks false"); 
	}  
	
	
	@Test
	void testSetBlockedStatus() { 
		Door d = new Door(); 
		
		d.setBlockedStatus(); 
		
		assertEquals(true, d.getBlockedStatus(), "Checks blocked status"); 
		assertEquals(false, d.myDoorStatus, "checks closeDoor");
	} 
	
	
	
	@Test 
	void  testGetQuestion() { 
		Door d = new Door(); 
		
		assertEquals(d.myQuestion, d.getQuestion(), " get check" );
		
	
		
		
		
	} 
	
	@Test 
	void testSetQuestioningStatus() { 
		
		Door d = new Door();  
		
		boolean b = true;
		d.setQuestioningStatus(b); 
		assertEquals(b,d.getQuestioningStatus(), "checking the set");
		
		
	}
	
	
	
	@Test
	void testGetQuestioningStatus() { 
		
		Door d = new Door(); 
		
		
		
          assertEquals(false, d.getQuestioningStatus(), "checks question status");
		
		
	} 
	
	
	
	

}
