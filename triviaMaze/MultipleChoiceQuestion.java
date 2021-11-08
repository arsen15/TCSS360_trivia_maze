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
	
	
	
	
	public void setCorrectChar(char theAnswer) { 
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
	public String setMultipleChoiceOptionA() { 
		return myOptionA;
	} 
	public String setMultipleChoiceOptionB() { 
		return myOptionB;
	} 
	public String setMultipleChoiceOptionC() { 
		return myOptionC;
	}
	public String setMultipleChoiceOptionD() { 
		return myOptionD;
	}


// block of setters and getters ,maybe make a class for the multiple choices to seperate this


	@Override
	public boolean answer() {
	
		return myQuestionAnswer;
		
		
	}

	
	
}
