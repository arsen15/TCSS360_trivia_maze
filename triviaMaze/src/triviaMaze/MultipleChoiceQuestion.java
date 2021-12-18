/*
 * TCSS 360 Trivia Maze Project
 * Fall 2021
 */

package triviaMaze;

import java.io.File;
import java.io.Serializable;

/**
 * This class creates the multiple choice questions of the maze.
 *   
 * @author Ryan Montoya, Phuc Luu, Arsen Shintemirov
 * @version 12/17/2021
 */
public class MultipleChoiceQuestion implements Question, Serializable {

  private static final long serialVersionUID = 9129880869446421445L;

  /**
   * Boolean value for question answer.
   */
  private boolean myQuestionAnswer;
  
  /**
   * Question text.
   */
  String myQuestionText;

  /**
   * Question answer options.
   */
  private String myOptionA;
  private String myOptionB;
  private String myOptionC;
  private String myOptionD;
  
  private char myCharacterAnswer;
  
  /**
   * Image file.
   */
  File myImageFile;

  /**
   * Sets the answer.
   */
  public void setAnswer(char theAnswer) {
    myCharacterAnswer = theAnswer;
  }

  /**
   * Checks if answer to question is correct or wrong.
   */
  @Override
  public void checkQuestion(char theInput) {

    if (myCharacterAnswer == theInput) {
      myQuestionAnswer = true;
    } else {

      myQuestionAnswer = false;
    }

  }
  
/**
 * Sets the question text.
 */
  @Override
  public void setQuestionText(final String theQuestionText) {

    myQuestionText = theQuestionText;
  }

  /**
   * Gets the question text.
   */
  public String getQuestionText() {
    return myQuestionText;
  }

  /**
   * Getter for option A.
   */
  public String getMultipleChoiceOptionA() {
    return myOptionA;
  }
  
  /**
   * Getter for option B.
   */
  public String getMultipleChoiceOptionB() {
    return myOptionB;
  }
  
  /**
   * Getter for option C.
   */
  public String getMultipleChoiceOptionC() {
    return myOptionC;
  }
  
  /**
   * Getter for option D.
   */
  public String getMultipleChoiceOptionD() {
    return myOptionD;
  }
  
  /**
   * Setter for answer option A.
   * @param theA
   */
  public void setMultipleChoiceOptionA(final String theA) {
    myOptionA = theA;
    // return myOptionA;
  }
  
  /**
   * Setter for answer option B.
   * @param theB
   */
  public void setMultipleChoiceOptionB(final String theB) {
    myOptionB = theB;
    // return myOptionB;
  }
  
  /**
   * Setter for answer option C.
   * @param theC
   */
  public void setMultipleChoiceOptionC(final String theC) {
    myOptionC = theC;

  }
  
  /**
   * Setter for answer option D.
   * @param theD
   */
  public void setMultipleChoiceOptionD(final String theD) {
    myOptionD = theD;
    // return myOptionD;
  }
  
  /**
   * Setter for the image file.
   * @param theFile
   */
  public void setImage(final File theFile) {
    myImageFile = theFile;
  }
  
  /**
   * Getter for the image file.
   */
  public File getImage() {
    return myImageFile;
  }

  /**
   * Answer method that holds the question answer.
   */
  @Override
  public boolean answer() {

    return myQuestionAnswer;

  }

}
