/**
 * Ryan, Arsen, Phuc
 */
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
    // myQuestionText = theQuestionText;
    // myCharacterAnswer = theAnswer;
  }

  /**
   * Set the answer for the trivia.
   * @param theAnswer
   */
  public void setAnswer(char theAnswer) {
    myCharacterAnswer = theAnswer;
  }

  /**
   * Check if the question has the appropriate input.
   * @param theInput 
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
   * Set the question of the trivia maze.
   */
  @Override
  public void setQuestionText(String theQuestionText) {

    myQuestionText = theQuestionText;
  }

  /**
   * Return the question.
   */
  public String getQuestionText() {
    return myQuestionText;
  }

  /**
   * Return the multiple choice option A.
   */
  public String getMultipleChoiceOptionA() {
    return myOptionA;
  }
  
  /**
   * Return the multiple choice option B.
   */
  public String getMultipleChoiceOptionB() {
    return myOptionB;
  }
  
  /**
   * Return the multiple choice option C.
   */
  public String getMultipleChoiceOptionC() {
    return myOptionC;
  }
  
  /**
   * Return the multiple choice option D.
   */
  public String getMultipleChoiceOptionD() {
    return myOptionD;
  }
  
  /**
   * Set the multiple choice option A.
   * @param theA
   */
  public void setMultipleChoiceOptionA(String theA) {
    myOptionA = theA;
    // return myOptionA;
  }
  
  /**
   * Set the multiple choice option B.
   * @param theB
   */
  public void setMultipleChoiceOptionB(String theB) {
    myOptionB = theB;
    // return myOptionB;
  }
  
  /**
   * Set the multiple choice option C.
   * @param theC
   */
  public void setMultipleChoiceOptionC(String theC) {
    myOptionC = theC;
  }
  
  /**
   * Set the multiple choice option D.
   * @param theD
   */
  public void setMultipleChoiceOptionD(String theD) {
    myOptionD = theD;
    // return myOptionD;
  }

  // block of setters and getters ,maybe make a class for the multiple choices
  // to seperate this

  /**
   * Check if the answer is T or F.
   */
  @Override
  public boolean answer() {

    return myQuestionAnswer;

  }

}