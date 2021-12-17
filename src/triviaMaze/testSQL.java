package triviaMaze;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testSQL {

	
	
	
	@Test 
	void testSetup() { 
		
		int QuestionsSize = 4; 
		
		triviaSQL sq = new triviaSQL(); 
		ArrayList<Question> ar = sq.setup(); 
		int arraySize = ar.size(); 
		assertEquals(QuestionsSize,arraySize, "compare size of the array with the number of elements it should carry");
		
		
	}
	
}
