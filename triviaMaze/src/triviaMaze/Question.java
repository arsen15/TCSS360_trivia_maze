/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import java.io.File;

/**
 * Holds the getters for question answer options, question text, and 
 * question answer.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public interface Question {

	/**
	 * Checks question.
	 * @param theA
	 */
	public void checkQuestion(char theA);  
	 
	/**
	 * Sets question text.
	 * @param theA
	 */
	public void setQuestionText(final String theA); 
	
	/**
	 * Sets the question answer.
	 * @param theA
	 */
	public void setAnswer(char theA);
	
	/**
	 * Boolean value for the answer.
	 * @return
	 */
	public boolean answer(); 
	
	/**
	 * Gets the question text.
	 * @return
	 */
	public String getQuestionText();
	
	 /**
	 * Getter for option A.
	 * @return
	 */
    public String getMultipleChoiceOptionA();  
    
    /**
     * Gets the option B.
     * @return
     */
    public String getMultipleChoiceOptionB();    
    
    /**
     * Gets the option C.
     * @return
     */
    public String getMultipleChoiceOptionC();   
    
    /**
     * Gets the option D.
     * @return
     */
    public String getMultipleChoiceOptionD();  
    
    /**
     * Gets the image file.
     * @return
     */
	public File getImage();
	
}
