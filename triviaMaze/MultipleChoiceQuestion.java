package triviaMaze;

public class MultipleChoiceQuestion implements Question {
     private boolean myQuestionAnswer;
	 private static String myQuestionText; 
	 private char myA; 
	 private char myB; 
	 private char myC; 
	 private char myD;  
	 
	public MultipleChoiceQuestion(String theQuestionText, char theA, char theB, char theC, char theD) { 
		myQuestionText = theQuestionText; 
		myA = theA ; 
		myB = theB;  
		myC = theC; 
		myD = theD;
	}
	
	
	@Override
	public void checkQuestion(char a) {
		// TODO Auto-generated method stub 
		myQuestionAnswer= false;
	//	return false;
	}

	@Override
	public void setQuestionText() {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean answer() {
		// TODO Auto-generated method stub
		
		return myQuestionAnswer;
		
		
	}

	
	
}
