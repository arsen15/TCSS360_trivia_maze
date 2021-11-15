/**
 * Question class that implements the questions for the Trivia Maze.
 * @author Ryan, Phuc, Arsen
 *
 */
public class TFQuestion implements Question {

  private String myQuestionText;

  private boolean myQuestionAnswer;
  private char myAnswerCharacter;
  TFQuestion() {
  }

  public void setQuestionText(String theQuestionText) {
    myQuestionText = theQuestionText;
  }

  public String getQuestionText() {
    return myQuestionText;
  }

  public char getAnswerCharacter() {
    return myAnswerCharacter;
  }

  public void setAnswer(char theAnswer) {
    myAnswerCharacter = theAnswer;
  }

  public void checkQuestion(char theInput) {
    if (theInput == myAnswerCharacter) {
      myQuestionAnswer = true;
    } else {
      myQuestionAnswer = false;
    }

  }

  @Override
  public boolean answer() {

    return myQuestionAnswer;
  }

}
