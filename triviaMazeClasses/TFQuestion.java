/**
 * Question class that implements the questions for the Trivia Maze.
 * 
 * @author Ryan, Phuc, Arsen
 *
 */
public class TFQuestion implements Question {
  /**
   * Fields that helps set the starting point.
   */
  private String myQuestionText;
  private boolean myQuestionAnswer;
  private char myAnswerCharacter;

  /**
   * Default constructor.
   */
  TFQuestion() {
  }

  /**
   * Help set up the questions.
   * 
   * @param theQuestionText
   *          input of the question.
   */
  public void setQuestionText(String theQuestionText) {
    myQuestionText = theQuestionText;
  }

  /**
   * Help return the question.
   * 
   * @return The question.
   */
  public String getQuestionText() {
    return myQuestionText;
  }

  /**
   * Return the answer chars.
   * 
   * @return character of the answer.
   */
  public char getAnswerCharacter() {
    return myAnswerCharacter;
  }

  /**
   * Help return the answers.
   * 
   * @param theAnswer
   *          the character of answer.
   */
  public void setAnswer(char theAnswer) {
    myAnswerCharacter = theAnswer;
  }

  /**
   * Check if the question is correct.
   * 
   * @param theInput
   *          the input of the question.
   */
  public void checkQuestion(char theInput) {
    if (theInput == myAnswerCharacter) {
      myQuestionAnswer = true;
    } else {
      myQuestionAnswer = false;
    }
  }

  /**
   * Help check if the answer is True or False.
   */
  @Override
  public boolean answer() {
    return myQuestionAnswer;
  }

  /**
   * Return the "T" for true of multiple choice option A.
   * 
   * @return T or True.
   */
  @Override
  public String getMultipleChoiceOptionA() {
    return "T";
  }

  /**
   * Return the "F" for true of multiple choice option B.
   * 
   * @return F or False.
   */
  @Override
  public String getMultipleChoiceOptionB() {
    return "F";
  }

  /**
   * Return the null for true of multiple choice option C.
   * 
   * @return null.
   */
  @Override
  public String getMultipleChoiceOptionC() {
    return null;
  }

  /**
   * Return the null for true of multiple choice option C.
   * 
   * @return null.
   */
  @Override
  public String getMultipleChoiceOptionD() {
    return null;
  }
}