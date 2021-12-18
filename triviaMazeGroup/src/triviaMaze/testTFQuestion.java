package triviaMaze;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class testTFQuestion {

	@Test
	void setQuestionText() { 
		
		TFQuestion q = new TFQuestion();  
		
		q.setQuestionText("beans"); 
		assertEquals("beans",q.getQuestionText(), "asserting question text"); 
		
		
		
	}
	
	
	@Test 
	void testGetQuestionText() { 
		
		TFQuestion q = new TFQuestion();
		
		
	}   
	
	@Test 
	void testGetAnswerCharacter() { 
		TFQuestion q = new TFQuestion(); 
		
		
		q.setAnswer('q'); 
		
		assertEquals('q',q.getAnswerCharacter());
		
		
	}
	
	
	
	
	
	@Test 
	void testSetAnswer() { 
		
		TFQuestion q = new TFQuestion(); 
		q.setAnswer('q'); 
		assertEquals('q',q.getAnswerCharacter());
	}
	
	
	
	@Test  
	void testCheckQuestion() { 
		TFQuestion q = new TFQuestion();  
		q.setAnswer('b');
		q.checkQuestion('b');  
		assertEquals(true,q.answer(), "aserting question check"); 
		
		q.setAnswer('c'); 
		q.checkQuestion('a'); 
		assertEquals(false,q.answer(), "asserting else statement ");
		
		
		
	} 
	
	
	@Test 
	void testGetMultipleChoiceOptionA() {  
		
		
		TFQuestion q = new TFQuestion();   
		
		assertEquals("T", q.getMultipleChoiceOptionA()); 
		
		
		
	} 
	
	@Test 
	void testGetMultipleChoiceOptionB() {  
		
		
		TFQuestion q = new TFQuestion();   
		
		assertEquals("F", q.getMultipleChoiceOptionB()); 
		
		
		
	}
	 
	@Test 
	void testGetMultipleChoiceOptionC() {  
		
		
		TFQuestion q = new TFQuestion();   
		
		assertEquals("", q.getMultipleChoiceOptionC()); 
		
		
		
	}
	
	
	
	@Test 
	void testGetMultipleChoiceOptionD() {  
		
		
		TFQuestion q = new TFQuestion();   
		
		assertEquals("", q.getMultipleChoiceOptionD()); 
		
		
		
	}
	
	
	
	@Test 
	void testSetImage() { 
		
		 TFQuestion mc = new TFQuestion();   
		 File testFile = new File("");  
		 mc.setImage(testFile); 
		 assertEquals(mc.getImage(),testFile);
		 
		
		 
	} 
	
	
	@Test 
	void testGetImage() { 
		 TFQuestion mc = new TFQuestion();    
		 File testFile = new File("");  
		 mc.setImage(testFile);  
		 assertEquals(mc.myImageFile,mc.getImage());
	}
	
	
	

}
