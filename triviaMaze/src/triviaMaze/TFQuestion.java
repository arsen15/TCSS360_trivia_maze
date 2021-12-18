/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import java.io.File;
import java.io.Serializable;

/**
 * This class for true/false type questions.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class TFQuestion implements Question, Serializable {
 
	
	private static final long serialVersionUID = -8456352154158600169L;
	
	/**
	 * The question text.
	 */
	private String myQuestionText; 
	
	/**
	 * Boolean value for question answer.
	 */
	private boolean myQuestionAnswer;  
	
	/**
	 * Character for answer.
	 */
	private char myAnswerCharacter;  
	
	/**
	 * Image file.
	 */
	File myImageFile;

	/**
	 * Sets the question text.
	 */
	public void setQuestionText(final  String theQuestionText) { 
		myQuestionText = theQuestionText;
	}  
	
	/**
	 * Gets the question text.
	 */
	public String getQuestionText() { 
		return myQuestionText;
	}
	
	/**
	 * Gets the character to represent question answers.
	 * @return
	 */
	public char getAnswerCharacter()  { 
		return myAnswerCharacter;
	}
	
	/**
	 * Sets the answer.
	 */
	public void setAnswer(final char theAnswer) { 
		myAnswerCharacter = theAnswer;
	}
	
	/**
	 * Checks if question answer is right or wrong.
	 */
	 public void checkQuestion(char theInput) { 
		 if(theInput == myAnswerCharacter) { 
			 myQuestionAnswer =  true;
		 } else { 
			 myQuestionAnswer = false;
		 }
		
	 }

	 /**
	  * Method that provides the right answer.
	  */
	@Override
	public boolean answer() {
	
		return myQuestionAnswer;
	}

	/**
	 * Gets the "True" type of answer.
	 */
	@Override
	public String getMultipleChoiceOptionA() {
		
		return "T";
	}

	/**
	 * Gets the "False" type of answer.
	 */
	@Override
	public String getMultipleChoiceOptionB() {
	
		return "F";
	}

	/**
	 * Returns empty string.
	 */
	@Override
	public String getMultipleChoiceOptionC() {
	
		return "";
	}

	/**
	 * Returns empty string.
	 */
	@Override
	public String getMultipleChoiceOptionD() {
		
		return "";
	} 
	 
	/**
	 * Setter for image file.
	 */
	public void setImage(final File theFile) { 
		myImageFile= theFile;
	}  
	
	/**
	 * Gets the image file.
	 */
	public File getImage() { 
		return myImageFile;
	}
	
}
