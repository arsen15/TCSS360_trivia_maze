<<<<<<< HEAD
package triviaMaze;

public class TFQuestion implements Question {
 
	private static String myQuestionText; 
	
	private boolean myQuestionAnswer;  
	private char myAnswerCharacter; 
	TFQuestion() { 
	//	myQuestionText = theQuestion; 
	}
	
	public void setQuestionText(final String theQuestionText) { 
		myQuestionText = theQuestionText;
	} 
	
	public String getQuestionText() { 
		return myQuestionText;
	}
	
	public char getAnswerCharacter()  { 
		return myAnswerCharacter;
	}
	
	public void setAnswer(final char theAnswer) { 
		myAnswerCharacter = theAnswer;
	}
	

	 public void checkQuestion(char theInput) { 
		 if(theInput == myAnswerCharacter) { 
			 myQuestionAnswer =  true;
		 } else { 
			 myQuestionAnswer = false;
		 }
		
	 }

	@Override
	public boolean answer() {
	
		return myQuestionAnswer;
	}

	@Override
	public String getMultipleChoiceOptionA() {
		
		return "T";
	}

	@Override
	public String getMultipleChoiceOptionB() {
	
		return "F";
	}

	@Override
	public String getMultipleChoiceOptionC() {
	
		return "";
	}

	@Override
	public String getMultipleChoiceOptionD() {
		
		return "";
	} 
	 

	
=======
package triviaMaze;

public class TFQuestion implements Question {
 
	private static String myQuestionText; 
	
	private boolean myQuestionAnswer;  
	private char myAnswerCharacter; 
	TFQuestion() { 
	//	myQuestionText = theQuestion; 
	}
	
	public void setQuestionText(final String theQuestionText) { 
		myQuestionText = theQuestionText;
	} 
	
	public String getQuestionText() { 
		return myQuestionText;
	}
	
	public char getAnswerCharacter()  { 
		return myAnswerCharacter;
	}
	
	public void setAnswer(final char theAnswer) { 
		myAnswerCharacter = theAnswer;
	}
	

	 public void checkQuestion(char theInput) { 
		 if(theInput == myAnswerCharacter) { 
			 myQuestionAnswer =  true;
		 } else { 
			 myQuestionAnswer = false;
		 }
		
	 }

	@Override
	public boolean answer() {
	
		return myQuestionAnswer;
	}

	@Override
	public String getMultipleChoiceOptionA() {
		
		return "T";
	}

	@Override
	public String getMultipleChoiceOptionB() {
	
		return "F";
	}

	@Override
	public String getMultipleChoiceOptionC() {
	
		return "";
	}

	@Override
	public String getMultipleChoiceOptionD() {
		
		return "";
	} 
	 

	
>>>>>>> d41749bba451d49e9a0aeff0b1e7f820ff5e976c
}