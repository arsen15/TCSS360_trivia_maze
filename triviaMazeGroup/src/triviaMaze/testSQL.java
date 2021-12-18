package triviaMaze;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class testSQL {

	
	
	
	@Test 
	void testSetup() { 
		
		int QuestionsSize = 4; 
		
		TriviaSQL sq = new TriviaSQL(); 
		ArrayList<Question> ar = sq.setup(); 
		int arraySize = ar.size(); 
		assertEquals(QuestionsSize,arraySize, "compare size of the array with the number of elements it should carry");
		
		
	}
	
}
