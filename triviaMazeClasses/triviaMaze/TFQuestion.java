package triviaMaze;

import java.io.Serializable;

/**
 * 
 * @author Ryan. Arsen, Phuc
 *
 */
public class TFQuestion implements Question, Serializable {
 
	/**
   * 
   */
  private static final long serialVersionUID = -8456352154158600169L;

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
	 

	
}