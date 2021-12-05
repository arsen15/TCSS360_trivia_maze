package triviaMaze;

public class MultipleChoiceQuestion implements Question {
     private boolean myQuestionAnswer;
	 private static String myQuestionText; 
	
	 private String myOptionA; 
	 private String myOptionB; 
	 private String myOptionC; 
	 private String myOptionD;
	 private char myCharacterAnswer;
	 // maybe just have setters instead of things in constructor, to be seen 
	public MultipleChoiceQuestion() { 
	//	myQuestionText = theQuestionText; 
	//	myCharacterAnswer = theAnswer;
	}  
	
	
	
	
	
	public void setAnswer(char theAnswer) { 
		myCharacterAnswer = theAnswer;
	}
	
	@Override
	public void checkQuestion(char theInput) {

		if(myCharacterAnswer == theInput) {  
			myQuestionAnswer= true;
		} else {
		
		
		myQuestionAnswer= false; 
		}

	}

	@Override
	public void setQuestionText(String theQuestionText) {
		
		myQuestionText = theQuestionText;
	} 
	
	public String getQuestionText() { 
		return myQuestionText;
	} 
	
	public String getMultipleChoiceOptionA() { 
		return myOptionA;
	} 
	public String getMultipleChoiceOptionB() { 
		return myOptionB;
	} 
	public String getMultipleChoiceOptionC() { 
		return myOptionC;
	}
	public String getMultipleChoiceOptionD() { 
		return myOptionD;
	} 
	public void setMultipleChoiceOptionA(String theA) {  
		myOptionA = theA;
	//	return myOptionA;
	} 
	public void setMultipleChoiceOptionB(String theB) {  
		myOptionB = theB;
		//return myOptionB;
	} 
	public void setMultipleChoiceOptionC(String theC) {  
		myOptionC = theC;
	
	}
	public void setMultipleChoiceOptionD(String theD) {  
		myOptionD = theD;
		//return myOptionD;
	}


// block of setters and getters ,maybe make a class for the multiple choices to seperate this


	@Override
	public boolean answer() {
	
		return myQuestionAnswer;
		
		
	}

	
	
}