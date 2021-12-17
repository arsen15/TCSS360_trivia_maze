package triviaMaze;

import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class testMCQuestion {

	@Test
	void testCheckQuestion() { 
		
		
		MultipleChoiceQuestion mc = new MultipleChoiceQuestion();  
		
		mc.setAnswer('b');
		mc.checkQuestion('b'); 
		assertEquals(true, mc.answer(), "checking if statement correct"); 
		
		mc.setAnswer('c'); 
		mc.checkQuestion('z'); 
		assertEquals(false, mc.answer(), "checking else statement");
		
		
	} 
	
	
	
	@Test 
	void testGetQuestionText() { 
		
		
		
	
		 MultipleChoiceQuestion mc = new MultipleChoiceQuestion();   
		 
		 mc.setQuestionText("question text"); 
		 assertEquals(mc.myQuestionText, mc.getQuestionText()); 
		 
		 
		 
		 
		 
		 
		 
	}  
	
	@Test 
	void testSetQuestionText() { 
		
		
		
		 MultipleChoiceQuestion mc = new MultipleChoiceQuestion();  
		 mc.setQuestionText("question text"); 
		 assertEquals("question text", mc.getQuestionText());
		
		
	}
	
	
	
	
	@Test  
	void testSetMultipleChoiceOptionA() { 
		
		 MultipleChoiceQuestion mc = new MultipleChoiceQuestion();  
		 
		 mc.setMultipleChoiceOptionA("beans"); 
		 assertEquals(mc.getMultipleChoiceOptionA(),"beans");
		 
		 
		
	} 
	
	
	
	@Test  
	void testSetMultipleChoiceOptionB() { 
		
		 MultipleChoiceQuestion mc = new MultipleChoiceQuestion();  
		 
		 mc.setMultipleChoiceOptionB("beans"); 
		 assertEquals(mc.getMultipleChoiceOptionB(),"beans");
		 
		 
		 
	} 
	
	
	@Test  
	void testSetMultipleChoiceOptionC() { 
		
		 MultipleChoiceQuestion mc = new MultipleChoiceQuestion();  
		 
		 mc.setMultipleChoiceOptionC("beans"); 
		 assertEquals(mc.getMultipleChoiceOptionC(),"beans");
		 
		 
		
	} 
	
	
	@Test  
	void testSetMultipleChoiceOptionD() { 
		
		 MultipleChoiceQuestion mc = new MultipleChoiceQuestion();  
		 
		 mc.setMultipleChoiceOptionD("beans"); 
		 assertEquals(mc.getMultipleChoiceOptionD(),"beans");
		 
		 
		
	} 
	
	
	@Test 
	void testSetImage() { 
		
		 MultipleChoiceQuestion mc = new MultipleChoiceQuestion();   
		 File testFile = new File("");  
		 mc.setImage(testFile); 
		 assertEquals(mc.getImage(),testFile);
		 
		
		 
	} 
	
	
	@Test 
	void testGetImage() { 
		 MultipleChoiceQuestion mc = new MultipleChoiceQuestion();    
		 File testFile = new File("");  
		 mc.setImage(testFile);  
		 assertEquals(mc.myImageFile,mc.getImage());
	}
	
	
	
	
}
